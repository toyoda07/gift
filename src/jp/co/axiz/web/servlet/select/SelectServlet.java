package jp.co.axiz.web.servlet.select;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserService;
import entity.User;


@WebServlet("/select")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String join = " WHERE ";


		if (!"".equals(id)) {
			join += " user_id = ? ";
		}
		if (!"".equals(name)) {
			if (!"".equals(id)) {
				join += " AND user_name = ? ";
			} else {
				join += " user_name = ? ";
			}
		}

		if (!"".equals(tel)) {
			if ((!"".equals(id)) || (!"".equals(name))) {
				join += " AND telephone = ? ";
			} else {
				join += " telephone = ? ";
			}
		}

		// 入力値のチェック
		if (("".equals(id)) && ("".equals(name) && ("".equals(tel)))) {//全て空文字の時
			UserService userService = new UserService();

			List<User> list = userService.findAll();
			request.setAttribute("userList", list);

			request.getRequestDispatcher("selectResult.jsp").forward(request, response);
		} else {

			UserService userService = new UserService();

			// 表示メッセージの受け渡し
			List<User> list = userService.find(id, name, tel, join);
			int i = 0;
			if(i == list.size()){
				request.setAttribute("error", "入力されたデータはありませんでした");

				// 次画面指定
				request.getRequestDispatcher("select.jsp").forward(request, response);
			}
			request.setAttribute("userList", list);

			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);
		}
	}

}
