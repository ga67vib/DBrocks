package de.tum.in.dbpra;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.AreaListBean;
import de.tum.in.dbpra.model.bean.PersonBean;
import de.tum.in.dbpra.model.bean.ShiftListBean;
import de.tum.in.dbpra.model.bean.StaffListBean;
import de.tum.in.dbpra.model.dao.AreaDAO;
import de.tum.in.dbpra.model.dao.PersonDAO;
import de.tum.in.dbpra.model.dao.ShiftDAO;
import de.tum.in.dbpra.model.dao.StaffDAO;

/**
 * Servlet implementation class
 */
@WebServlet("/shift")
public class ShiftServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShiftServlet() {
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
			int staffId = Helpermethods.isParsable(request.getParameter("staffId"))
					? Integer.parseInt(request.getParameter("staffId")) : 0;
			PersonBean personBean = new PersonBean();
			PersonDAO personDAO = new PersonDAO();
			personDAO.getPersonbyID(personBean, staffId);
			request.setAttribute("staffname", personBean.getFirstName()+" "+personBean.getLastName());
			ShiftDAO sd = new ShiftDAO();
			ShiftListBean slb = new ShiftListBean();
			sd.getShifts(slb, staffId);
			request.setAttribute("bean", slb);
			// fill in jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("ShiftsPerStaff.jsp");
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
