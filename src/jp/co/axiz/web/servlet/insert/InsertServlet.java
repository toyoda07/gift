package jp.co.axiz.web.servlet.insert;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String pass = request.getParameter("pass");

			// 入力情報を取得
			User user = new User();

			// ユーザーを登録
			if (("".equals(name) || ("".equals(tel) || ("".equals(pass))))) {//全て空文字の時

				request.getRequestDispatcher("insert.jsp").forward(request, response);
			} else {

			// userを設定
				HttpSession session = request.getSession(true);
			request.setAttribute("user", user);
			session.setAttribute("name", name);
			session.setAttribute("tel", tel);
			session.setAttribute("pass", pass);

			// 次画面指定
			request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);
		}
	}

}
