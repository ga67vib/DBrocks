package de.tum.in.dbpra;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.NoteListBean;
import de.tum.in.dbpra.model.dao.NoteDAO;

@WebServlet("/")
public class OrganizationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrganizationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Displays the notes for a single staff member
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if(request.getSession().getAttribute("staff")!=null){ //if staff, display something; if not: Empty page
				request.setAttribute("singleStaff", "Yep"); // to reuse the jsp for all notes, we set this attribute
				int person_id = Integer.parseInt(request.getSession().getAttribute("staff").toString());
				NoteListBean nlb = new NoteListBean();
				NoteDAO nd = new NoteDAO();
				nd.getNotesbyPersonID(nlb, person_id);
				request.setAttribute("bean", nlb);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			request.setAttribute("error", e.toString() + e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/allNote.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
