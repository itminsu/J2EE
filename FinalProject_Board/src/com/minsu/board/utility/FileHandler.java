package com.minsu.board.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {
	private FileHandler()
	{
	}
	private static final String FILE_DELIMITER = ":";
	
	public static final String PASSWORD_FILE = "/WEB-INF/passwords.txt";

	public static Map<String, String> loadFileData(final String fileName) throws IOException
	{
		String temp;
		Map<String, String> map = new HashMap<String, String>();
		try (BufferedReader bfr = new BufferedReader (new FileReader(fileName)))
		{
			while ((temp = bfr.readLine()) != null)
			{
				String[] data = temp.split(FILE_DELIMITER);
				map.put(data[0], data[1]);
			}
		}
		return map;
	}
	
}