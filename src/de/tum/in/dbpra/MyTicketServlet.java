package de.tum.in.dbpra;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.RFID_TicketBean;
import de.tum.in.dbpra.model.bean.RFID_TicketListBean;
import de.tum.in.dbpra.model.bean.TransactionListBean;
import de.tum.in.dbpra.model.dao.RFID_TicketDAO;
import de.tum.in.dbpra.model.dao.TransactionDAO;

/**
 * Servlet implementation class
 */
@WebServlet("/myTicket")
public class MyTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyTicketServlet() {
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
			int userId = 0;
			if (request.getSession().getAttribute("visitor") != null
					&& Helpermethods.isParsable(request.getSession().getAttribute("visitor").toString())) {
				userId = Integer.parseInt(request.getSession().getAttribute("visitor").toString());
			}else if (request.getSession().getAttribute("staff") != null
					&& Helpermethods.isParsable(request.getSession().getAttribute("staff").toString())) {
				userId = Integer.parseInt(request.getSession().getAttribute("staff").toString());
			}

			
				//int userId = Integer.parseInt(request.getSession().getAttribute("visitor").toString());
			RFID_TicketDAO td = new RFID_TicketDAO();
			RFID_TicketListBean tlb = new RFID_TicketListBean();
			td.getTicketbyUserID(tlb, userId);
			request.setAttribute("bean", tlb);
			
			TransactionDAO transb = new TransactionDAO();
			TransactionListBean translb = new TransactionListBean();
			transb.getTransactionsbyPersonID(translb, userId);
			request.setAttribute("transbean", translb);
				
			RequestDispatcher dispatcher = request.getRequestDispatcher("MyTicket.jsp"); 
			dispatcher.forward(request, response);
			

		} catch (Throwable e) {
			request.setAttribute("error", "Exception occured. Text:<br>" + e.getMessage());
            request.getRequestDispatcher("/MyTicket.jsp").forward(request, response);
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
