package ConnectDBSample.vovanhai.wordpress.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectODBC_ConString {
	private Connection con=null;
	public ConnectODBC_ConString() throws Exception{
		String url="sun.jdbc.odbc.JdbcOdbcDriver";
		Class.forName(url);
		String dbUrl="jdbc:odbc:Driver={SQL Server};Server=.;Database=Student;UserName=sa;Password=chieu12a2";
		con=DriverManager.getConnection(dbUrl);
		System.out.println(con.getCatalog());
	}
	/*
	 * Lấy danh sách các mẫu tin của bảng CSDL
	 * @param tableName: tên bảng cần lấy các dòng
	 * @return danh sách các dòng được lưu trong 1 ResultSet
	 * @throws SQLException
	 */
	public ResultSet GetResultSet(String tableName)throws SQLException {
		ResultSet rs=null;
		Statement stmt=con.createStatement();
		String sql="select * from "+tableName;
		rs=stmt.executeQuery(sql);
		return rs;
	}
	public void Close()throws Exception{
		con.close();
	}
	//Thử chương trình
	public static void main(String[] args) {
		try {
			System.out.println("Danh sách sinh viên  - connection string");
			ConnectODBC_ConString conDSN=new ConnectODBC_ConString();
			ResultSet rs=conDSN.GetResultSet("EmployeeInfo");
			while(rs.next()) {
				System.out.println(rs.getString("EmpName"));
			}
			conDSN.Close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
