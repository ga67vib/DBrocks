package de.tum.in.dbpra;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.ProductListBean;
import de.tum.in.dbpra.model.dao.ProductDAO;

/**
 * Servlet implementation class
 */
@WebServlet("/myProduct")
public class MyProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyProductServlet() {
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
			if(request.getSession().getAttribute("staff") !=null){
				ProductDAO pd = new ProductDAO();
				ProductListBean plb = new ProductListBean();
				pd.getProducts(plb);
				request.setAttribute("bean", plb);
				RequestDispatcher dispatcher = request.getRequestDispatcher("allProduct.jsp");
				dispatcher.forward(request, response);
			}else if(request.getSession().getAttribute("supplier") != null){
				int sponsorId = Integer.parseInt(request.getSession().getAttribute("supplier").toString());
				ProductDAO pd = new ProductDAO();
				ProductListBean plb = new ProductListBean();
				pd.getProductbySponsorID(plb, sponsorId);
				request.setAttribute("bean", plb);
				RequestDispatcher dispatcher = request.getRequestDispatcher("allProduct.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Throwable e) {
			request.setAttribute("error", "Exception occured. Text:<br>" + e.getMessage());
            request.getRequestDispatcher("/allProduct.jsp").forward(request, response);
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
