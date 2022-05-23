package ex1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Program {
	
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
			String url = "jdbc:oracle:thin:@192.168.35.244:1522/xepdb1";
			String sql = "SELECT * FROM NOTICE";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection(url, "CONGSOON", "congsoon");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			
			
			
			if(rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getNString("TITLE");
				String writerID = rs.getNString("WRITER_ID");
				Date regDate = rs.getTimestamp("REGDATE");
				String content = rs.getNString("CONTENT");
				int hit = rs.getInt("hit");		
				
				System.out.printf("id : %d, title : %s, writerID : %s, regDate : %s, content : %s, hit : %d\n",
						id, title, writerID, regDate, content, hit);
			}			
		
			
			if(rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getNString("TITLE");
				String writerID = rs.getNString("WRITER_ID");
				Date regDate = rs.getTimestamp("REGDATE");
				String content = rs.getNString("CONTENT");
				int hit = rs.getInt("hit");		
				
				System.out.printf("id : %d, title : %s, writerID : %s, regDate : %s, content : %s, hit : %d\n",
						id, title, writerID, regDate, content, hit);
			}		
			
			rs.close();
			st.close();
			con.close();
		}
}
