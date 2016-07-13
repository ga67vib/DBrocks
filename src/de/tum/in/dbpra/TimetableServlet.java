package de.tum.in.dbpra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;

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
			PerformanceDAO pd = new PerformanceDAO();
			PerformanceListBean plb19 = new PerformanceListBean();
			PerformanceListBean plb20 = new PerformanceListBean();
			PerformanceListBean plb19own = new PerformanceListBean();
			PerformanceListBean plb20own = new PerformanceListBean();
			int person_id = 0;
			if (request.getSession().getAttribute("visitor") != null
					&& Helpermethods.isParsable(request.getSession().getAttribute("visitor").toString())) {
				person_id = Integer.parseInt(request.getSession().getAttribute("visitor").toString());
			}else if (request.getSession().getAttribute("staff") != null
					&& Helpermethods.isParsable(request.getSession().getAttribute("staff").toString())) {
				person_id = Integer.parseInt(request.getSession().getAttribute("staff").toString());
			}
			//get all performances by day
			pd.getPerformancesByDay(plb19, 19, 0);
			pd.getPerformancesByDay(plb20, 20, 0);
			//get all performances for the user by day (or all performances, if not user is not visitor)
			pd.getPerformancesByDay(plb20own, 20, person_id);
			pd.getPerformancesByDay(plb19own, 19, person_id);
			if (request.getSession().getAttribute("visitor") != null){
				//remove those performances from the complete set, which are in the timetable of the visitor
				removeVisitorPerformancesFromFullSet(plb19, plb19own);
				removeVisitorPerformancesFromFullSet(plb20, plb20own);
			}

			request.setAttribute("bean19", plb19);
			request.setAttribute("bean20", plb20);
			request.setAttribute("bean19own", plb19own);
			request.setAttribute("bean20own", plb20own);

			RequestDispatcher dispatcher = request.getRequestDispatcher("timetable.jsp"); 
			
			//only dispatch request if user is a logged in visitor or staff member; else blank page
			if (request.getSession().getAttribute("visitor") != null || request.getSession().getAttribute("staff") != null){
				dispatcher.forward(request, response);
			}

		} catch (Throwable e) {
			e.printStackTrace();
			request.setAttribute("error", "Exception occured. Text:<br>" + e.getMessage());
            request.getRequestDispatcher("/allNote.jsp").forward(request, response);
		}
	}

	/**
	 * Inserts the performances selected on the timetable site into the database for the visitor
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			if(request.getSession().getAttribute("visitor")!=null){
				//get person_id of visitor
				int person_id = Integer.parseInt(request.getSession().getAttribute("visitor").toString());
				//we can use parseInt without danger, since personID is set by the program, and not user input
			
				//get performance_ids to insert
				Enumeration<String> parameterNames = request.getParameterNames(); //get set parameters;
				ArrayList<Integer> performances_to_insert = new ArrayList<Integer>(); 
				//ArrayList, since it is complicated to know the number of parameters beforehand
				if(parameterNames != null){ //if == null, just do nothing, no things to be inserted
					while(parameterNames.hasMoreElements()){
						//while there are still checked performances, get the performance_id and add it to the ArrayList
						performances_to_insert.add(Integer.parseInt(request.getParameter(parameterNames.nextElement())));
						//we can use parseInt without danger, since it is a performanceID set by the program, and not user input
					}
				}
				//insert performances to timetable
				PerformanceDAO pd = new PerformanceDAO();
				pd.insertPerformancesIntoTimetable(performances_to_insert, person_id);
				
				//display timetable as usual
				doGet(request, response);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			request.setAttribute("error", "Exception occured. Text:<br>" + e.getMessage());
            request.getRequestDispatcher("/allNote.jsp").forward(request, response);
		}
		
	}
	
	
	
	
	/**
     * Removes those PerformanceBeans from the fullSet, which are in the visitorSet.
     */
    public void removeVisitorPerformancesFromFullSet(PerformanceListBean fullSet, PerformanceListBean visitorSet){
    	//get all performanceIDs in the visitorSet
    	HashSet<Integer> visitorIDs = new HashSet<Integer>();
    	for (int i=0; i<visitorSet.getList().size(); i++){
    		visitorIDs.add(visitorSet.getChild(i).getPerformanceID());
    	}
    	
    	//remove them in the fullSet; do it from back to front, because else index shift on removing causes problems
    	for (int i=fullSet.getList().size()-1; i>=0; i--){
    		if(visitorIDs.contains(fullSet.getList().get(i).getPerformanceID())){
    			fullSet.getList().remove(i);    		
    		}
    	}
    }

}
