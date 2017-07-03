package jp.co.axiz.web.servlet.delete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.UserService;
import entity.User;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");

		if ("".equals(id)) {
			request.setAttribute("error", "必須項目を入力してください");
			// 次画面指定
			request.getRequestDispatcher("delete.jsp").forward(request, response);
			// return ;
		} else {
			UserService userService = new UserService();
			User user = userService.findById(id);

			if (user == null) {
				request.setAttribute("error", "入力されたデータはありませんでした");
				// 次画面指定
				request.getRequestDispatcher("delete.jsp").forward(request, response);
			}
			HttpSession session = request.getSession(true);
			request.setAttribute("id", id);
			session.setAttribute("name", user.getUserName());
			session.setAttribute("tel", user.getTelephone());
			session.setAttribute("pass", user.getPassword());
			// 次画面指定
			request.getRequestDispatcher("deleteConfirm.jsp").forward(request, response);
		}
	}
}
