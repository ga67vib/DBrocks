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

import de.tum.in.dbpra.model.bean.PartBean;
import de.tum.in.dbpra.model.bean.PartListBean;
import de.tum.in.dbpra.model.bean.SearchedBean;
import de.tum.in.dbpra.model.dao.PartDAO;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/parts")
public class PartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SearchedBean searched; 
    private String sortBy = "";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
        	PartDAO dao = new PartDAO();
        	PartListBean part = new PartListBean();
        	if(request.getParameter("sortBy")==null){
        		dao.getPartsInAscOrder(part,"name");
        	}else{
        		dao.getPartsInAscOrder(part,request.getParameter("sortBy"));
        		this.sortBy = request.getParameter("sortBy");
        		if(searched != null){
        			PartDAO dao2 = new PartDAO();
                	PartListBean searchedPart = new PartListBean();
                	
            		//set the searchparameter in searchbean to be able to display them when just filtering the table
            		dao2.getPartsBySearch(searchedPart, searched.getSearch(), searched.getColumn(), searched.getLike(),searched.getBsl());
            		request.setAttribute("searchedPart", searchedPart);
        		}
        	}
        	request.setAttribute("part", part);
    	} catch (Throwable e) {
    		e.printStackTrace();
    		request.setAttribute("error", e.toString() + e.getMessage());
    	}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/exercise73.jsp");
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			PartDAO dao = new PartDAO();
        	PartListBean part = new PartListBean();
        	
        	//is the post method called from hyperlink in tableheader?
        	if(sortBy.equals("")){
        		dao.getPartsInAscOrder(part, "name");
        	}else{
        		dao.getPartsInAscOrder(part, sortBy);
        	}
        	request.setAttribute("part", part);
        	
        	PartDAO dao2 = new PartDAO();
        	PartListBean searchedPart = new PartListBean();
        	
    		//set the searchparameter in searchbean to be able to display them when just filtering the table
    		searched = new SearchedBean();
    		searched.setColumn(request.getParameter("column"));
    		searched.setLike(request.getParameter("like"));
    		searched.setSearch(request.getParameter("search"));
    		searched.setBsl(request.getParameter("bsl"));
    		dao2.getPartsBySearch(searchedPart, (String) searched.getSearch(), searched.getColumn(), searched.getLike(), searched.getBsl());
    		request.setAttribute("searchedPart", searchedPart);
        	
			
		} catch (Throwable e) {
			e.printStackTrace();
			request.setAttribute("error", e.toString() + e.getMessage());
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/exercise73.jsp");
		dispatcher.forward(request, response);
		
		
	}

}