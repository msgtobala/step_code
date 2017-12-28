package org.main;

import java.sql.SQLException;
import org.main.DBFactory;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Authentictaion {
	public static boolean check(User user) throws ClassNotFoundException,SQLException{
		boolean status = false;
		Connection con = DBFactory.getConn();
		Statement stmt=(Statement)con.createStatement();
		String qury;
		qury="";
		ResultSet rs=(ResultSet) stmt.executeQuery("Select * from Users_table" + "where User_name ='"+user.getUsername()+"' and User_password ='"+user.getPassword()+"'");
		if(rs.next()){
			status = true;
		}
		stmt.close();
		con.close();
		return status;
	}
}
