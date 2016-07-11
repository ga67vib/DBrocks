package de.tum.in.dbpra;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.AreaListBean;
import de.tum.in.dbpra.model.bean.SponsorBean;
import de.tum.in.dbpra.model.bean.SponsorListBean;
import de.tum.in.dbpra.model.dao.AreaDAO;
import de.tum.in.dbpra.model.dao.SponsorDAO;

/**
 * Servlet implementation class
 */
@WebServlet("/sponsor")
public class SponsorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SponsorServlet() {
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
			SponsorDAO sd = new SponsorDAO();
			SponsorListBean slb = new SponsorListBean();
			sd.getSponsors(slb);
			request.setAttribute("bean", slb);

			RequestDispatcher dispatcher = request.getRequestDispatcher("allSponsor.jsp"); 
			dispatcher.forward(request, response);
		} catch (Throwable e) {
			request.setAttribute("error", "Exception occured. Text:<br>" + e.getMessage());
            request.getRequestDispatcher("/allSponsor.jsp").forward(request, response);
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
