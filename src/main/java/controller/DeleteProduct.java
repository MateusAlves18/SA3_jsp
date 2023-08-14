package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

import java.io.IOException;

import dao.ProductDAO;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/delete_product")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ProductDAO productDAO = new ProductDAO();
		Product product = productDAO.searchForId(id);
		if (product.getName() != null) {
			request.setAttribute("name", product.getName());
			request.setAttribute("valor", product.getValor());
			request.setAttribute("quantidade", product.getQuantidade());
			request.setAttribute("linkimg", product.getLinkImg());
			request.setAttribute("id", product.getIdProduto());
			RequestDispatcher redirect = request.getRequestDispatcher("/admin/deletar_produto.jsp");
			redirect.forward(request, response);

		} else {
			RequestDispatcher redirect = request.getRequestDispatcher("/admin/deletar_id.jsp");
			request.setAttribute("id", Integer.toString(id));
			redirect.forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		
		ProductDAO productDAO = new ProductDAO();
		
		if (productDAO.deleteProduct(id)) {
			RequestDispatcher redirect = request.getRequestDispatcher("/admin/index.jsp");
			request.setAttribute("action","Remoção");
			redirect.forward(request, response);
		}
		else {
			RequestDispatcher redirect = request.getRequestDispatcher("/admin/deletar_produto.jsp");
			request.setAttribute("delete","true");
			redirect.forward(request, response);
		}
	}

}
