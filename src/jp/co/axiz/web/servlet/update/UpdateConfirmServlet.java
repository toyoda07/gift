package jp.co.axiz.web.servlet.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.UserService;
import entity.User;

@WebServlet("/updateConfirm")
public class UpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(true);
		String newname = request.getParameter("newName");
		String newtel = request.getParameter("newTel");
		String newpass = (String) session.getAttribute("newpass");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		User user = new User(Integer.parseInt(id), newname, newtel, newpass);
		if (!"".equals(newpass)) {
			if (pass.equals(newpass)) {
				UserService userService = new UserService();
				userService.update(user);
			} else {
				request.setAttribute("repass", pass);
				request.setAttribute("error", "前画面で入力したパスワードと一致しません");
				request.getRequestDispatcher("updateConfirm.jsp").forward(request, response);
			}
		}
		UserService userService = new UserService();
		userService.update(user);
		request.getRequestDispatcher("updateResult.jsp").forward(request, response);
	}

}
