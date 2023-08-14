package controller;

import java.io.IOException;

import dao.ProductDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

/**
 * Servlet implementation class InsertProduct
 */
@WebServlet("/insert_product")
public class InsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name").equals("") ? null : request.getParameter("name");
		int quantidade = request.getParameter("quantidade").equals("") ? 0
				: Integer.parseInt(request.getParameter("quantidade"));
		double valor = request.getParameter("valor").equals("") ? 0
				: Double.parseDouble(request.getParameter("valor").replace(",", "."));
		String linkImg = request.getParameter("linkimg").equals("") ? null : request.getParameter("linkimg");
		Product product = new Product(name, quantidade, valor, linkImg);
		ProductDAO productDAO = new ProductDAO();
		if (productDAO.insertProduct(product)) {
			RequestDispatcher redirect = request.getRequestDispatcher("/admin/index.jsp");
			request.setAttribute("action", "Cadastro");
			redirect.forward(request, response);
		} else {
			request.setAttribute("name", name);
			request.setAttribute("valor", valor);
			request.setAttribute("quantidade", quantidade);
			request.setAttribute("linkimg", linkImg);
			RequestDispatcher redirect = request.getRequestDispatcher("/admin/cadastro_produto.jsp");
			request.setAttribute("cadastro", "bad");
			redirect.forward(request, response);
		}

	}

}
