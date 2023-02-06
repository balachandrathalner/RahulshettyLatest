
package Academy.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class JdbcConection {

	
	@Test
	
	public  void getMysqlConnection() throws SQLException{
		
		
		String host="localhost";
		
		String port="3306";
		
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+"/sample","root","root");
		
		Statement s=con.createStatement();
		
		ResultSet rs=s.executeQuery("select * from employeeinfo where name='sachin';");
		
		while (rs.next()) {
			
			System.out.println(rs.getString("location"));
			System.out.println(rs.getInt("id"));
		}
		
		
	}
	
	
	
	
}
