import java.sql.*;

public class Conexao {
	 Connection con;
	 PreparedStatement st;
	 ResultSet rs;
	public void abrirBanco()throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = ("jdbc:mysql://localhost:3306/Pas");
		con = DriverManager.getConnection(url,"root","pas2011");
			
	}
		public void fecharBanco()throws Exception{
			if(con != null)
				con.close();
		}

	
}
