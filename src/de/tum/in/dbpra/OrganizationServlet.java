package de.tum.in.dbpra;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.ConcertAreaListBean;
import de.tum.in.dbpra.model.dao.ConcertAreaDAO;

@WebServlet("/location/organization")
public class OrganizationServlet {

	/**
	 * Servlet implementation class
	 */
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				
				
				
	    	} catch (Throwable e) {
	    		e.printStackTrace();
	    		request.setAttribute("error", e.toString() + e.getMessage());
	    	}
			RequestDispatcher dispatcher = request.getRequestDispatcher("Organization.jsp"); //fill in jsp
			dispatcher.forward(request, response);
	}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		}

}

	

