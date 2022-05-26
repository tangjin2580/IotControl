package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Test {

	private static final String SQLSERVER_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// private static final String POSTGRESQL_DRIVER="org.postgresql.Driver";
	private static final String SQLSERVER_URL = "jdbc:sqlserver://192.168.0.77\\ZKZS;databaseName=xian";


	public static void main(String[] args) {
		try {
			Class.forName(SQLSERVER_DRIVER).newInstance();
			String url = SQLSERVER_URL;
			Connection con = DriverManager.getConnection(url, "sa", "sys");
			Statement st = con.createStatement();
			String sql = " select * from zkzs.table_1";
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
			}
			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
