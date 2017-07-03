package jp.co.axiz.web.servlet.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/updateInput")
public class UpdateInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(true);
		String newname = request.getParameter("newName");
		String newtel = request.getParameter("newTel");
		String newpass = request.getParameter("newPass");
		String name2 = (String) session.getAttribute("name");
		String tel2 = (String) session.getAttribute("tel");
		String pass2 = (String) session.getAttribute("pass");

		if (!"".equals(newname) || !"".equals(newtel) || !"".equals(newpass)) {
			if (!name2.equals(newname) || !tel2.equals(newtel) || !pass2.equals(newpass)) {
				if (pass2.equals(newpass)) {
					request.setAttribute("repass", newpass);
					session.setAttribute("newpass", newpass);
				} else {
					session.setAttribute("newpass", newpass);
					request.setAttribute("repass", "");
				}
				session.setAttribute("newname", newname);
				session.setAttribute("newtel", newtel);

				request.getRequestDispatcher("updateConfirm.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "１項目以上変更してください");
				request.getRequestDispatcher("updateInput.jsp").forward(request, response);
			}
		}

	}

}
