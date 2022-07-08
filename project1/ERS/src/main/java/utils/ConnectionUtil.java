//package utils;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
//
//public class ConnectionUtil {
//	private static Connection c;
//
//	public static Connection getConnectionFromEnv() throws SQLException, IOException {
//		
//		try {
//			Class.forName("org.postgresql.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Properties prop = new Properties();
//		ClassLoader loader = Thread.currentThread().getContextClassLoader();
//		prop.load(loader.getResourceAsStream("connection.properties"));
//		
//		String url = prop.getProperty("url");
//		String username = prop.getProperty("username");
//		String password = prop.getProperty("password");
//		
//		if (c == null || c.isClosed()) {
//			c = DriverManager.getConnection(url, username, password);
//		}
//		
//		return c;
//	}
//}
