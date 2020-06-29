package com.hms.dao;
import com.hms.util.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import com.hms.bean.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LoginDao {

	private Connection connection = DataBaseConnection.getConnection();
	 
	  public  boolean validate(LoginBean loginBean) throws ClassNotFoundException {
	        boolean status = false;

	        Class.forName("com.mysql.jdbc.Driver");
	        try {

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select * from userstore where login = ? and password = ? ");
	            preparedStatement.setString(1, loginBean.getLogin());
	            preparedStatement.setString(2, loginBean.getPassword());

	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            status = rs.next();

	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	        }
	        return status;
	    }
	  private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
}
