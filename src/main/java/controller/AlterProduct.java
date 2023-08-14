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
 * Servlet implementation class AlterProduct
 */
@WebServlet("/alter_product")
public class AlterProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlterProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ProductDAO productDAO = new ProductDAO();
		Product product = productDAO.searchForId(id);
		if (product.getName() != null) {
			request.setAttribute("name", product.getName());
			request.setAttribute("valor", product.getValor());
			request.setAttribute("quantidade", product.getQuantidade());
			request.setAttribute("linkimg", product.getLinkImg());
			request.setAttribute("id", product.getIdProduto());
			RequestDispatcher redirect = request.getRequestDispatcher("/admin/alterar_produto.jsp");
			redirect.forward(request, response);

		} else {
			RequestDispatcher redirect = request.getRequestDispatcher("/admin/alterar_id.jsp");
			request.setAttribute("id", Integer.toString(id));
			redirect.forward(request, response);
		}
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
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = new Product(name, quantidade, valor, linkImg);
		product.setIdProduto(id);
		ProductDAO productDAO = new ProductDAO();
		
		if (productDAO.updateProduct(product)) {
			RequestDispatcher redirect = request.getRequestDispatcher("/admin/index.jsp");
			request.setAttribute("action","Alteração");
			redirect.forward(request, response);
		}
		else {
			RequestDispatcher redirect = request.getRequestDispatcher("/admin/alterar_produto.jsp");
			request.setAttribute("altera","true");
			redirect.forward(request, response);
		}
	}

}
