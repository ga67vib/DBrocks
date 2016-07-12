package de.tum.in.dbpra;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.AdvertisingListBean;
import de.tum.in.dbpra.model.dao.AdvertisingDAO;

/**
 * Servlet implementation class
 */
@WebServlet("/myAdvertising")
public class MyAdvertisingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyAdvertisingServlet() {
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
			System.out.println(request.getSession().getAttribute("staff"));
			System.out.println(request.getSession().getAttribute("supplier"));
			if(request.getSession().getAttribute("staff") !=null){
					AdvertisingDAO ad = new AdvertisingDAO();
					AdvertisingListBean alb = new AdvertisingListBean();
					ad.getAdvertisings(alb);
					request.setAttribute("bean", alb);

					RequestDispatcher dispatcher = request.getRequestDispatcher("allAdvertising.jsp"); 
					dispatcher.forward(request, response);
			}else if(request.getSession().getAttribute("supplier") != null){
			
			int sponsorId = Integer.parseInt(request.getSession().getAttribute("supplier").toString());
			AdvertisingDAO ad = new AdvertisingDAO();
			AdvertisingListBean alb = new AdvertisingListBean();
			ad.getAdvertisingsBySponsorId(alb, sponsorId);
			request.setAttribute("bean", alb);

			RequestDispatcher dispatcher = request.getRequestDispatcher("myAdvertising.jsp"); 
			dispatcher.forward(request, response);

			}
		} catch (Throwable e) {
			request.setAttribute("error", "Exception occured. Text:<br>" + e.getMessage());
            request.getRequestDispatcher("/allAdvertising.jsp").forward(request, response);
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
