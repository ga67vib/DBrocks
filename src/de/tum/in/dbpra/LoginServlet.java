package de.tum.in.dbpra;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.tum.in.dbpra.model.bean.PersonBean;
import de.tum.in.dbpra.model.dao.PersonDAO;
import de.tum.in.dbpra.model.dao.RFID_TicketDAO;
import de.tum.in.dbpra.model.dao.VisitorDAO;

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
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp"); //fill in jsp
		dispatcher.forward(request, response);
	}

	/**
	 * Checks whether the user used the login or the register form.
	 * Then calls the corresponding method.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Post login");
		if (request.getParameter("whoami").equals("login")){
			//System.out.println("ogin");
			doLogin(request,response);
		}
		else if (request.getParameter("whoami").equals("register")){
			//System.out.println("register");
			doRegister(request,response);
		}
		else{
			request.setAttribute("error", "Post request from unkown form.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
	/**
	 * Reads necessary data from the login form, and then tries to log the user in.
	 * In case of invalid mail, invalid password or exceptions the user is notified.
	 */
	protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        
        PersonBean pb = new PersonBean();
        PersonDAO pd = new PersonDAO();
        try{
	        //get the person for this mail
	        pd.getPersonbyMail(pb, mail);
	        
	        if(pb.getMail()==null){//mail not set => no person with that mail
	        	request.setAttribute("error", "Unknown mail, please try again.");
	            request.getRequestDispatcher("/Login.jsp").forward(request, response);
	        }
	        else if(pb.getPassword().equals(password)){
	        	//Successful login. Find out, whether the person is visitor or staff
	        	if(pd.isVisitor(pb.getPersonID())){
	        		request.getSession().setAttribute("visitor", pb.getPersonID());
		            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
	        	}
	        	else if(pd.isStaffMember(pb.getPersonID())){ 
	        		request.getSession().setAttribute("staff", pb.getPersonID());
		            request.getRequestDispatcher("/welcome.jsp").forward(request, response);

	        	}
	        	else{ //this then is a supplier. Registered suppliers are in person, but not visitors or staff.
	        		request.getSession().setAttribute("supplier", pb.getPersonID());
		            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
	        	}
	        }
	        else{//Mail set, but password not equal => Wrong password
	        	request.setAttribute("error", "Wrong password. Please try again.");
	            request.getRequestDispatcher("/login.jsp").forward(request, response);
	        }
        }
        catch(SQLException e){
        	request.setAttribute("error", "SQLException occured. Text:\n"+e.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        catch(ClassNotFoundException e){
        	request.setAttribute("error", "ClassNotFoundException occured. Text:\n"+e.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        
        
	}

	/**
	 * Reads necessary data from the register form, and then tries to register a visitor.
	 * Inserts a new Person, a new visitor and a new RFID_ticket.
	 * In case of anything not meeting the constraints or exceptions the user is notified.
	 */
	protected void doRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("newPassword");
        String bday = request.getParameter("bday"); 
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
	 	String phonenumber = request.getParameter("phonenumber");
	 	boolean camper = (request.getParameter("camper")!=null);
	 	boolean vip = (request.getParameter("vip")!=null);
	 	String prefGenre = request.getParameter("prefGenre");
	 	Date validFrom = Date.valueOf("2016-08-19");
	 	Date validUntil = Date.valueOf("2016-08-21");
	 	BigDecimal price = BigDecimal.valueOf((double) 9.99);
			
        PersonDAO pd = new PersonDAO();
                
        try{
        	//cast the birthday to date; done here, so we have the catch block to handle it in a sensible position
        	Date birthday = Date.valueOf(bday);
        	//PersonDAO handles the complete insert; returns the personID of the newly inserted visitor
        	int personID = pd.insertVisitor(firstname, lastname, email, password, birthday, gender, address, phonenumber, camper, vip, prefGenre, validFrom, validUntil, price);
        	if(pd.isVisitor(personID)){ //check the visitor was successfully inserted
        		//immediately login and welcome the new visitor
        		request.getSession().setAttribute("visitor", personID);
	            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        	}
        	else{
        		request.setAttribute("error", "Unexpected error: Insert threw no exception, but visitor does not exist.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
        	}
        }
        catch(SQLException e){
        	request.setAttribute("error", "SQLException occured. Text:\n"+e.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        catch(ClassNotFoundException e){
        	request.setAttribute("error", "ClassNotFoundException occured. Text:\n"+e.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        catch(IllegalArgumentException e){
        	request.setAttribute("error", "IllegalArgumentException occured. You entered your birthday in an invalid format. Required format: yyyy-mm-dd");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        
        
	}
	
}
