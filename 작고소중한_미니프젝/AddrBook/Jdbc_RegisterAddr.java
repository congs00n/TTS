package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc_RegisterAddr {
	
	public static void main(String[] args) {
		
		
		String url = "jdbc:oracle:thin:@192.168.35.244:1522/xepdb1";
		String sql = "INSERT INTO ADDRBOOK (ADDRESS_NAME, ADDRESS_TELEPHONE) VALUES (?, ?)";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, "CONGSOON", "congsoon");
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "정채은");
			pstmt.setString(2, "010-4ddd-ddd1");
			int cnt = pstmt.executeUpdate();
			
		}
		catch (Exception  e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				pstmt.close();
				con.close();
			}
			catch(Exception e) {
				
			}

		}
		
}

}


	