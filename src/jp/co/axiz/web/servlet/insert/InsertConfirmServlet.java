package jp.co.axiz.web.servlet.insert;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.UserService;
import entity.User;

@WebServlet("/insertConfirm")
public class InsertConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(true);
		String repass = request.getParameter("rePass");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String pass = (String)session.getAttribute("pass");
		User user = new User(name,tel,pass);
		if(repass.equals(pass)){
			// ユーザーを登録
			UserService userService = new UserService();
			userService.register(user);
			int Maxid = userService.maxid();

			// userを設定
			request.setAttribute("user", user);
			session.setAttribute("id", Maxid);

			// 次画面指定
			request.getRequestDispatcher("insertResult.jsp").forward(request, response);
		} else {
			request.setAttribute("error", "前画面で入力したパスワードと一致しません");
			// 次画面指定
			request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);
		}

	}

}
