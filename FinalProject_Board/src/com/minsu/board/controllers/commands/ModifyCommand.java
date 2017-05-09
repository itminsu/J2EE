package com.minsu.board.controllers.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minsu.board.model.DAO;

public class ModifyCommand implements Command
{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	{
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		DAO dao = new DAO();
		dao.modify(bId, bName, bTitle, bContent);
		
	}

}
