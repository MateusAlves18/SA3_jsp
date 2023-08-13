package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UserAdmin;
import model.UserClient;

import java.io.IOException;

import dao.UserAdminDAO;
import dao.UserClientDAO;

/**
 * Servlet implementation class LoginClient
 */
@WebServlet("/login_client")
public class LoginClient extends HttpServlet  {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginClient() {
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
		RequestDispatcher redirect = request.getRequestDispatcher("/login.jsp");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	
		UserClient userClient = new UserClient(email,password);
		UserClientDAO userDao = new UserClientDAO();
		String name = userDao.existUser(userClient);
		boolean isUserTrue = !name.isEmpty();
		if (email.isEmpty() || password.isEmpty()) {
			if (!email.isEmpty())
				request.setAttribute("email", email);
			if (!password.isEmpty())
				request.setAttribute("password", password);
			request.setAttribute("message", "Por favor preencha email e/ou senha!");
			redirect.forward(request, response);
		}

		if (isUserTrue) {
			request.getSession().setAttribute("name", name);
			RequestDispatcher redirect1 = request.getRequestDispatcher("/");
			redirect1.forward(request, response);
		} else {
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			request.setAttribute("messageError", "Usuário ou Senha incorretos!");
			redirect.forward(request, response);

		}
	}

}
