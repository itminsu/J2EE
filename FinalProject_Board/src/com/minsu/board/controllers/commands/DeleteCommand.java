package com.minsu.board.controllers.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minsu.board.model.DAO;

public class DeleteCommand implements Command
{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	{
		String bId = request.getParameter("bId");
		DAO dao = new DAO();
		dao.delete(bId);
		
	}

}
