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

/**
 * Servlet implementation class
 */

@WebServlet("/location/concertarea")
public class ConcertAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConcertAreaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ConcertAreaDAO cad = new ConcertAreaDAO();
			ConcertAreaListBean calb = new ConcertAreaListBean();
			cad.getConcertAreas(calb);
			
    	} catch (Throwable e) {
    		e.printStackTrace();
    		request.setAttribute("error", e.toString() + e.getMessage());
    	}
		RequestDispatcher dispatcher = request.getRequestDispatcher("ConcertArea.jsp"); //fill in jsp
		dispatcher.forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
