package de.tum.in.dbpra;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import de.tum.in.dbpra.model.bean.PerformanceListBean;
import de.tum.in.dbpra.model.dao.PerformanceDAO;

/**
 * Servlet implementation class
 */
@WebServlet("/timetable")
public class TimetableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TimetableServlet() {
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
			PerformanceDAO td = new PerformanceDAO();
			PerformanceListBean tlb19 = new PerformanceListBean();
			PerformanceListBean tlb20 = new PerformanceListBean();
			PerformanceListBean tlb19own = new PerformanceListBean();
			PerformanceListBean tlb20own = new PerformanceListBean();
			int person_id = 0;
			if (request.getSession().getAttribute("visitor") != null
					&& Helpermethods.isParsable(request.getSession().getAttribute("visitor").toString())) {
				person_id = Integer.parseInt(request.getSession().getAttribute("visitor").toString());
			}else if (request.getSession().getAttribute("staff") != null
					&& Helpermethods.isParsable(request.getSession().getAttribute("staff").toString())) {
				person_id = Integer.parseInt(request.getSession().getAttribute("staff").toString());
			}
			td.getPerformancesByDay(tlb19, 19, 0);
			td.getPerformancesByDay(tlb20, 20, 0);
			td.getPerformancesByDay(tlb20own, 20, person_id);
			td.getPerformancesByDay(tlb19own, 19, person_id);
			request.setAttribute("bean19", tlb19);
			request.setAttribute("bean20", tlb20);
			request.setAttribute("bean19own", tlb19own);
			request.setAttribute("bean20own", tlb20own);

			RequestDispatcher dispatcher = request.getRequestDispatcher("timetable.jsp"); // fill
			// in
			// jsp
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
