package controller;

import java.io.IOException;

import dao.UserAdminDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UserAdmin;

/**
 * Servlet implementation class Login
 */
@WebServlet("/loginmarket")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("action").equals("close")) {
		request.getSession().invalidate();
		RequestDispatcher redirect = request.getRequestDispatcher("/");
		redirect.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher redirect = request.getRequestDispatcher("/loginadmin.jsp");
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		UserAdmin userAdmin = new UserAdmin(user, password);
		UserAdminDAO userDao = new UserAdminDAO();
		boolean isUserTrue = userDao.existUser(userAdmin);
		if (user.isEmpty() || password.isEmpty()) {
			if (!user.isEmpty())
				request.setAttribute("user", user);
			if (!password.isEmpty())
				request.setAttribute("password", password);
			request.setAttribute("message", "Por favor preencha usuário e/ou senha!");
			redirect.forward(request, response);
		}

		if (isUserTrue) {
			request.getSession().setAttribute("user", user);
			RequestDispatcher redirect1 = request.getRequestDispatcher("/admin");
			redirect1.forward(request, response);
		} else {
			request.setAttribute("user", user);
			request.setAttribute("password", password);
			request.setAttribute("messageError", "Usuário ou Senha incorretos!");
			redirect.forward(request, response);

		}
	}

}
