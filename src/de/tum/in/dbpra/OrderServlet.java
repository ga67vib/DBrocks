package de.tum.in.dbpra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.CustomerBean;
import de.tum.in.dbpra.model.bean.OrderListBean;
import de.tum.in.dbpra.model.dao.CustomerDAO;
import de.tum.in.dbpra.model.dao.OrderDAO;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
        	OrderDAO daoNo = new OrderDAO();
        	OrderDAO daoOk = new OrderDAO();
        	OrderListBean orderNo = new OrderListBean();
        	OrderListBean orderOk = new OrderListBean();
        	daoNo.getOrderstatus(orderNo, "no");
        	daoOk.getOrderstatus(orderOk, "ok");
        	request.setAttribute("orderNo", orderNo);
        	request.setAttribute("orderOk", orderOk);
    	} catch (Throwable e) {
    		e.printStackTrace();
    		request.setAttribute("error", e.toString() + e.getMessage());
    	}
		RequestDispatcher dispatcher = request.getRequestDispatcher("exercise72.jsp");
		dispatcher.forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
