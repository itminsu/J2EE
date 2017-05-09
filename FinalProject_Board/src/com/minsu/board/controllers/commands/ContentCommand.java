package com.minsu.board.controllers.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minsu.board.model.DAO;
import com.minsu.board.model.DTO;

public class ContentCommand implements Command
{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	{
		String bId = request.getParameter("bId");
		DAO dao = new DAO();
		DTO dto = dao.contentView(bId);
		
		request.setAttribute("content_view", dto);
		
	}

}
