package com.minsu.translate.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minsu.translate.utility.FileHandler;


/**
 * Servlet implementation class Translator
 */
@WebServlet(
		urlPatterns={"/translator"},
		initParams = {
				@WebInitParam(name = "dictionary_path_F", value = "/WEB-INF/dictionaryF.txt"),
				@WebInitParam(name = "dictionary_path_R", value = "/WEB-INF/dictionaryR.txt")
				
		}
	)
public class Translator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Translator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try
		{
			String path_F = config.getInitParameter("dictionary_path_F");
			String path_R = config.getInitParameter("dictionary_path_R");
			if(config.getServletContext().getResource(path_F) == null && config.getServletContext().getResource(path_R) == null)
			{
				throw new RuntimeException("Can not find a file");
			}
			
			
		}
		catch (MalformedURLException e)
		{
			
		}
	}
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	private Map<String, String> dictionary = new HashMap<String, String>();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		if (request.getParameter("dictionary").equals("french")){
			
			String path = "C:\\Users\\Minsu\\Documents\\J2EE_workplace\\Assignment3_translate\\WebContent\\WEB-INF\\dictionary"+"F"+".txt";
			dictionary = FileHandler.loadFileData(path);
		} 
		else 
		{
			
			String path = "C:\\Users\\Minsu\\Documents\\J2EE_workplace\\Assignment3_translate\\WebContent\\WEB-INF\\dictionary"+"R"+".txt";
			dictionary = FileHandler.loadFileData(path);
		}
		session.setAttribute("dictionary", request.getParameter("dictionary"));
		request.setAttribute("dics", dictionary);
		request.getRequestDispatcher("jsps/list.jsp").forward(request, response);
		//HashMap sorting try TreeMap()
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = ((HttpServletRequest) request).getSession(true);
		
		try
		{
			if(request.getParameter("word") != null && !request.getParameter("word").equals(""))
			{
				if (request.getParameter("language").equals("french")){
					
					String path = "C:\\Users\\Minsu\\Documents\\J2EE_workplace\\Assignment3_translate\\WebContent\\WEB-INF\\dictionary"+"F"+".txt";
					dictionary = FileHandler.loadFileData(path);
				} 
				else 
				{
					
					String path = "C:\\Users\\Minsu\\Documents\\J2EE_workplace\\Assignment3_translate\\WebContent\\WEB-INF\\dictionary"+"R"+".txt";
					dictionary = FileHandler.loadFileData(path);
				}
			
				String displayWord = dictionary.get(request.getParameter("word"));
				
				session.setAttribute("displayWord", displayWord);
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				response.getWriter().write(dictionary.get(request.getParameter("word")));
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}
		}catch(NullPointerException e){

			e.printStackTrace();
			// display message "No word in .txt"
		}
	}// end doPost

}// end class
