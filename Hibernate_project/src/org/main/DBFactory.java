package org.main;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class DBFactory {
	public static Connection getConn() throws ClassNotFoundException,SQLException{
		if(connection==null){
			Class.forName("com.mysql.jdbc.Driver");
			connection= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "");
		}
		return connection;
	}
   private static Connection connection=null;

}
