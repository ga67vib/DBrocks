package de.tum.in.dbpra;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.StaffListBean;
import de.tum.in.dbpra.model.dao.StaffDAO;

/**
 * Servlet implementation class
 */
@WebServlet("/staff")
public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StaffServlet() {
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
			int shiftId = Helpermethods.isParsable(request.getParameter("shiftId"))? Integer.parseInt(request.getParameter("shiftId")) : 0;
			StaffDAO sd = new StaffDAO();
			StaffListBean slb = new StaffListBean();
			sd.getStaff(slb, shiftId);
			if(shiftId>0){
				request.setAttribute("shiftId", shiftId);
			}
			request.setAttribute("bean", slb);
			// fill in jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("allStaff.jsp");
			dispatcher.forward(request, response);
		} catch (Throwable e) {
			request.setAttribute("error", "Exception occured. Text:<br>" + e.getMessage());
            request.getRequestDispatcher("/allStaff.jsp").forward(request, response);
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
