package com.minsu.board.controllers.commands;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minsu.board.model.DAO;
import com.minsu.board.model.DTO;

public class ListCommand implements Command
{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
	{
		DAO dao = new DAO();
		ArrayList<DTO> dtos = dao.list();
		request.setAttribute("list", dtos);
		
	}
	
}
