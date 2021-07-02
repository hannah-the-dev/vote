/**
 * 
 */
package votes.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;


/**
 * @author kopo21
 * BasicDataSource creates connection pool and deliver the connection 
 */
public enum ConnectionPool {
	INSTANCE;
//    private Connection connection;
    private static BasicDataSource DS = new BasicDataSource();
    
    static {
    	DS.setUrl("jdbc:mysql://192.168.23.91:3306/kopoctc");
    	DS.setDriverClassName("com.mysql.cj.jdbc.Driver");
        DS.setUsername("root");
        DS.setPassword("kopoctc");
        DS.setMinIdle(5);
        DS.setMaxIdle(10);
        DS.setMaxOpenPreparedStatements(100);
    }
    
    private ConnectionPool() {
//    	String DRIVER = "com.mysql.cj.jdbc.Driver";  
//    	String DB_URL = "jdbc:mysql://192.168.23.91:3306/kopoctc";
//    	
//    	// JDBC Database Credentials
//    	String USER = "root";
//    	String PASS = "kopoctc";
//    	try {
//			Class.forName(DRIVER);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		try {
//			connection = DriverManager.getConnection
//					(DB_URL, USER, PASS);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
	
	public static ConnectionPool getInstance(){
		return INSTANCE;
	}

    public static Connection getConnection() throws SQLException {
		return DS.getConnection();
    }
}
