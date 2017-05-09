package edu.nscc.training.controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.nscc.training.model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = (request.getParameter("rUsername") == null) ? "" : request.getParameter("rUsername");
		String password = (request.getParameter("rPassword") == null) ? "" : request.getParameter("rPassword");
		String name = (request.getParameter("rName") == null) ? "" : request.getParameter("rName");
//		String userName = request.getParameter("rUsername");
//		String password = request.getParameter("rPassword");
//		String name = request.getParameter("rName");
		User user;
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		BufferedWriter bw;
		FileWriter fw;
		System.out.println(userName);
		System.out.println(password);
		System.out.println(name);
		
		try 
		{	        
			if(!name.equals("") && !password.equals("") && !userName.equals(""))
			{
				user = new User();
				//set user
				user.setUsername(userName);
				user.setPassword(password);
				user.setName(name);
				session.setAttribute("userName", user.getUsername());
				session.setAttribute("password", user.getPassword());
				
				//file buffer
				File file = new File("C:\\Users\\Minsu\\Documents\\J2EE_workplace\\Assignment2_myapp2\\WebContent\\WEB-INF\\passwords.txt");
				String text = user.getName() + ":"+ user.getUsername() + ":" + user.getPassword();
				System.out.println(text);
				fw = new FileWriter(file, true);
				bw = new BufferedWriter(fw);
				bw.write("\n" + text);
				bw.close();
				fw.close();
			    
				//Direct to welcome.html page
				RequestDispatcher rd = request.getRequestDispatcher("welcome.html");
				rd.forward(request, response);				
			}
			else //Try register again 
			{
				RequestDispatcher rd = request.getRequestDispatcher("register.html");
				rd.forward(request, response);
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
