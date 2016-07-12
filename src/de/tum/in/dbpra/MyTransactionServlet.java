package de.tum.in.dbpra;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.TransactionListBean;
import de.tum.in.dbpra.model.dao.TransactionDAO;

/**
 * Servlet implementation class
 */
@WebServlet("/myTransaction")
public class MyTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyTransactionServlet() {
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
				TransactionDAO td = new TransactionDAO();
				TransactionListBean tlb = new TransactionListBean();
				td.getTransactions(tlb);
				request.setAttribute("bean", tlb);
	
				RequestDispatcher dispatcher = request.getRequestDispatcher("allTransaction.jsp"); 
				dispatcher.forward(request, response);
			}else if(request.getSession().getAttribute("supplier") != null){
				
				int sponsorId = Integer.parseInt(request.getSession().getAttribute("supplier").toString());
				TransactionDAO td = new TransactionDAO();
				TransactionListBean tlb = new TransactionListBean();
				td.getTransactionsBySponsorID(tlb, sponsorId);
				
				request.setAttribute("bean", tlb);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("allTransaction.jsp"); 
				dispatcher.forward(request, response);
			}

		} catch (Throwable e) {
			request.setAttribute("error", "Exception occured. Text:<br>" + e.getMessage());
            request.getRequestDispatcher("/allTransaction.jsp").forward(request, response);
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
