package de.tum.in.dbpra;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.dao.NoteDAO;

/**
 * Servlet implementation class
 */
@WebServlet("/noteCreate")
public class NoteCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoteCreateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//concatenate all selected person_ids (if called from staff site)
		String result="";
		Enumeration<String> parameterNames = request.getParameterNames(); //get set parameters; possibly none, if not called from staff side
		if(parameterNames != null){ //if == null, just do nothing, leave result as ""
			while(parameterNames.hasMoreElements()){
				result+= request.getParameter(parameterNames.nextElement()) + ","; //while there are still checked staff members, concatenate their person id to the result
			}
			if (result!=""){
				result = result.substring(0, result.length()-1);//remove last comma
			}
		}
		request.setAttribute("input_person_ids", result); //set input_person_ids, so they are immediately displayed
		RequestDispatcher dispatcher = request.getRequestDispatcher("/createNote.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String person_ids_string = request.getParameter("person_ids");
		//get an int array out of the comma separated string; ignore whitespace
		String[] person_ids_strarray = person_ids_string.split(",");
		int[] person_ids_intarray = new int[person_ids_strarray.length]; //initialize int array
		try{
			for (int i=0;i<person_ids_strarray.length;i++){
				person_ids_strarray[i]=person_ids_strarray[i].trim();//remove whitespace
				person_ids_intarray[i] = Integer.parseInt(person_ids_strarray[i]); //make integer
			}
			NoteDAO nd = new NoteDAO();
			nd.insertNotes(person_ids_intarray, request.getParameter("content")); //give the method all person_ids, so all inserts can be handled in one transaction
			NoteServlet redirectServlet = new NoteServlet();
			redirectServlet.doGet(request, response);
		}
		catch(NumberFormatException e){//user input something invalid
			request.setAttribute("error", "NumberFormatException occured. You entered the person_ids in an invalid format. \nRequired format: id1, id2, id3 \n(i.e. comma separated string)");
            request.getRequestDispatcher("/createNote.jsp").forward(request, response);
		}
		catch(SQLException e){
        	request.setAttribute("error", "SQLException occured. Text:\n"+e.getMessage());
            request.getRequestDispatcher("/createNote.jsp").forward(request, response);
        }
        catch(ClassNotFoundException e){
        	request.setAttribute("error", "ClassNotFoundException occured. Text:\n"+e.getMessage());
            request.getRequestDispatcher("/createNote.jsp").forward(request, response);
        }
		
		
	}

}
