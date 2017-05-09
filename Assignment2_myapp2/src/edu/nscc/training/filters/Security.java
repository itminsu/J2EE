package edu.nscc.training.filters;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.nscc.training.utility.FileHandler;

/**
 * Servlet Filter implementation class Security
 */
@WebFilter("/welcome.html")
public class Security implements Filter {

    /**
     * Default constructor. 
     */
    public Security() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	private Map<String, String> passwords = new HashMap<String, String>();
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		
		String path = "C:\\Users\\Minsu\\Documents\\J2EE_workplace\\Assignment2_myapp2\\WebContent\\WEB-INF\\passwords.txt";
		passwords = FileHandler.loadFileData(path);
		//HttpSession sess = ((HttpServletRequest) request).getSession(true);
		
		// Session does exist
		if ((session.getAttribute("userName") != null && session.getAttribute("password") != null))
				//|| (sess.getAttribute("userName") != null && sess.getAttribute("password") != null))
		{
			// When session exist, pass direct to welcome.html
			RequestDispatcher rd = request.getRequestDispatcher("welcome.html");
			rd.forward(request, response);
		}
		else // Session does not exist.
		{
			try
			{
				// get parameter from login.html
//				String userName = request.getParameter("lUsername");
//				String password = request.getParameter("lPassword");
				String userName = (request.getParameter("lUsername") == null) ? "" : request.getParameter("lUsername");
				String password = (request.getParameter("lPassword") == null) ? "" : request.getParameter("lPassword");
				System.out.println(userName);
				System.out.println(password);

				System.out.println("password: 	" + passwords.get(userName));
				// Direct to welcome.html when valid user and password
				if ((passwords.get(userName) != null) && (passwords.get(userName).equals(password)))
				{
					session.setAttribute("userName", userName);
					session.setAttribute("password", password);
					
					//escape filter
					chain.doFilter(request, response);
				}
			
				else
				{
					//user doesn't have the required authorization, the user is being directed to the register page
					// register.html
					RequestDispatcher rd = request.getRequestDispatcher("register.html");
					rd.forward(request, response);
				}
			}
			catch(NullPointerException e)
			{
				e.printStackTrace();
			}
			
		}// end else
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		URL url;
		try
		{
			url = fConfig.getServletContext().getResource(FileHandler.PASSWORD_FILE);
			//get path to the file
			String path = url.getPath();
			//passwords: data member defined as a map in the filter
			passwords = FileHandler.loadFileData(path);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
