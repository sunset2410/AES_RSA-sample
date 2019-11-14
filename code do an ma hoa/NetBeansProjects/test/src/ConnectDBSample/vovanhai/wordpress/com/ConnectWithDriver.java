package ConnectDBSample.vovanhai.wordpress.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectWithDriver {
	private Connection con=null;
	public ConnectWithDriver()throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url="jdbc:sqlserver://localhost:1433;databaseName=Student";
		con=DriverManager.getConnection(url,"sa","chieu12a2");
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
			System.out.println("Danh sách Nhân viên");
			ConnectWithDriver conDSN=new ConnectWithDriver();
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
