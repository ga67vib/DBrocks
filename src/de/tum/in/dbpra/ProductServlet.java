package de.tum.in.dbpra;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.AreaListBean;
import de.tum.in.dbpra.model.bean.ProductListBean;
import de.tum.in.dbpra.model.dao.AreaDAO;
import de.tum.in.dbpra.model.dao.ProductDAO;

/**
 * Servlet implementation class
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ProductDAO pd = new ProductDAO();
			ProductListBean plb = new ProductListBean();
			pd.getProducts(plb);
			request.setAttribute("bean", plb);
			// fill in jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("allProduct.jsp");
			dispatcher.forward(request, response);
		} catch (Throwable e) {
			e.printStackTrace();
			request.setAttribute("error", e.toString() + e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
