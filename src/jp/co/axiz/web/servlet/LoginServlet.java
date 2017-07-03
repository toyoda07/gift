package jp.co.axiz.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.AdminService;
import entity.Admin;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// ログインID、パスワードを取得
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		// ログインチェック
		AdminService adminService = new AdminService();
		Admin admin = adminService.authentication(id, pass);
		boolean isSuccess = admin != null;

		// 表示メッセージの受け渡し
		if (isSuccess) {
			HttpSession session = request.getSession(true);
			session.setAttribute("admin", admin.getAdminName());

			// 次画面指定
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		} else {

			// メッセージ設定
			request.setAttribute("error", "IDまたはPASSが間違っています");

			// 次画面指定
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
