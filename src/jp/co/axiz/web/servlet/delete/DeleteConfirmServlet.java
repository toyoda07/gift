package jp.co.axiz.web.servlet.delete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UserService;
import entity.User;

@WebServlet("/deleteConfirm")
public class DeleteConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		int ID = 0;
		ID	 = Integer.parseInt(id);
		User user = new User(ID);
		UserService userService = new UserService();
		userService.delete(user);
		// 次画面指定
		request.getRequestDispatcher("deleteResult.jsp").forward(request, response);
	}

}
