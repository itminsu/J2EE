package com.minsu.board.model;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.DataSource;

//Data Access Object
public class DAO
{
	DataSource dataSource;

	public DAO()
	{
		try
		{
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void write(String bName, String bTitle, String bContent) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into board (bId, bName, bTitle, bContent, bHit)"
					+ "values(board_seq.nextval, ?, ?, ?, 0)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			//return row numbers
			int rn = preparedStatement.executeUpdate();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try{
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			}
			catch (Exception ee)
			{
				ee.printStackTrace();
			}
		}
	}// end write
	
	public ArrayList<DTO> list(){
		
		ArrayList<DTO> dtos = new ArrayList<DTO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "SELECT bId, bName, bTitle, bContent, bDate, bHit FROM board ORDER BY bId DESC";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next())
			{
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				
				DTO dto = new DTO(bId, bName, bTitle, bContent, bDate, bHit);
				dtos.add(dto);

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try{
				if(resultSet != null)
					resultSet.close();
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			}
			catch (Exception ee)
			{
				ee.printStackTrace();
			}
		}
		
		return dtos;
		
	}// end list()
	
	public DTO contentView(String strID)
	{
		upHit(strID);
		DTO dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM board WHERE bID = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strID));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				
				dto = new DTO(bId, bName, bTitle, bContent, bDate, bHit);
			
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try{
				if(resultSet != null)
					resultSet.close();
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			}
			catch (Exception ee)
			{
				ee.printStackTrace();
			}
		}
		
		return dto;
		
	}

	public void modify(String bId, String bName, String bTitle, String bContent) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "UPDATE board SET bName = ?, bTitle = ?, bContent = ? WHERE bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, Integer.parseInt(bId));
			int rn = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception ee) {
				
				ee.printStackTrace();
			}
		}
	}
	
	public void delete(String bId) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			connection = dataSource.getConnection();
			String query = "DELETE FROM board WHERE bId =?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(bId));
			int rn = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) 
					preparedStatement.close();
				if(connection != null) 
					connection.close();
			} catch (Exception ee) {
				
				ee.printStackTrace();
			}
		}
	}
	
	private void upHit(String bId)
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "UPDATE board SET bHit = bHit + 1 WHERE bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bId);
			
			int rn = preparedStatement.executeUpdate();
					
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception ee) {
				
				ee.printStackTrace();
			}
		}
		
	}
	
}// end DAO class
