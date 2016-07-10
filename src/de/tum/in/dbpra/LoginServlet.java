package de.tum.in.dbpra;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.PersonBean;
import de.tum.in.dbpra.model.dao.PersonDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp"); //fill in jsp
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        
        PersonBean pb = new PersonBean();
        PersonDAO pd = new PersonDAO();
        try{
	        //get the person for this mail
	        pd.getPersonbyMail(pb, mail);
	        
	        if(pb.getPassword().equals(password)){
	        	//Successful login. Find out, whether the person is visitor or staff
	        	if(pd.isVisitor(pb.getPersonID())){
	        		request.getSession().setAttribute("visitor", pb.getPersonID());
		            request.getRequestDispatcher("/Welcome.jsp").forward(request, response);
	        	}
	        	else if(pd.isStaffMember(pb.getPersonID())){ 
	        		request.getSession().setAttribute("staff", pb.getPersonID());
		            request.getRequestDispatcher("/Welcome.jsp").forward(request, response);

	        	}
	        	else{ //this then is a supplier. Registered suppliers are in person, but not visitors or staff.
	        		request.getSession().setAttribute("supplier", pb.getPersonID());
		            request.getRequestDispatcher("/Welcome.jsp").forward(request, response);
	        	}
	        }
	        else if (pb.getMail()==null){ //mail not set => no person with that mail
	        	request.setAttribute("error", "Unknown mail, please try again.");
	        }
	        else{//Mail set, but password not equal => Wrong password
	        	request.setAttribute("error", "Wrong password. Please try again.");
	            request.getRequestDispatcher("/Login.jsp").forward(request, response);
	        }
        }
        catch(SQLException e){
        	request.setAttribute("error", "SQLException occured. Text:\n"+e.getMessage());
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }
        catch(ClassNotFoundException e){
        	request.setAttribute("error", "ClassNotFoundException occured. Text:\n"+e.getMessage());
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }
        
        
	}

}
