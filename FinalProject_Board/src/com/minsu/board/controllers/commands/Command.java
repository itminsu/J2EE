package com.minsu.board.controllers.commands;

import javax.servlet.http.*;

public interface Command
{
	void execute(HttpServletRequest request, HttpServletResponse response);
}
