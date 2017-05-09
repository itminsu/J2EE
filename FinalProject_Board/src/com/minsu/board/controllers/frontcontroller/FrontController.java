package com.minsu.board.controllers.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minsu.board.controllers.commands.Command;
import com.minsu.board.controllers.commands.ContentCommand;
import com.minsu.board.controllers.commands.DeleteCommand;
import com.minsu.board.controllers.commands.ListCommand;
import com.minsu.board.controllers.commands.ModifyCommand;
import com.minsu.board.controllers.commands.WriteCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null; //choose which page will be shown
		Command command = null; //choose which command will be chosen for logic
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/write_view.do"))
		{
			viewPage = "write_view.jsp";
		}
		else if(com.equals("/write.do"))
		{
			command = new WriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		else if(com.equals("/list.do"))
		{
			command = new ListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		}
		else if(com.equals("/content_view.do"))
		{
			command = new ContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		}
		else if(com.equals("/modify.do"))
		{
			command = new ModifyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		else if(com.equals("/delete.do"))
		{
			command = new DeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

}
