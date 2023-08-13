package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UserClient;

import java.io.IOException;

import dao.UserClientDAO;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/register_user")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String matricula = request.getParameter("matricula");
		String endereco = request.getParameter("endereco");
		String password = request.getParameter("password");
		String isCNPJ = request.getParameter("isCNPJ");
		UserClient userClient = new UserClient(email, name, matricula, endereco, password, isCNPJ);
		UserClientDAO userDAO = new UserClientDAO();
		
		if(userDAO.registerUser(userClient)) {
			RequestDispatcher redirect = request.getRequestDispatcher("/");
			request.getSession().setAttribute("name", name);
			request.setAttribute("cadastro", "ok");
			redirect.forward(request, response);
		}
		else {
			RequestDispatcher redirect = request.getRequestDispatcher("/cadastro_usuario.jsp");
			request.setAttribute("cadastro", "bad");
			redirect.forward(request, response);
		}
		
	}

}
