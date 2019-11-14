package ConnectDBSample.vovanhai.wordpress.com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Connect_JNDI {
	private Connection con=null;
	public Connect_JNDI() throws Exception{
		DataSource ds=null;
		Context ctx=new InitialContext();
		ds=(DataSource)ctx.lookup("java://MyDSJNDI_Name");
		con=ds.getConnection();
	}
	/**
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
			ConnectODBC_DSN conDSN=new ConnectODBC_DSN();
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
