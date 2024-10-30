package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class ConnectionPoolImpl implements ConnectionPool {
	// Trinh dieu khien lam viec
		private String driver;
		
		// Tai khoan ket noi
		private String username;
		private String userpass;
		
		// Duong dan thuc thi
		private String url;
		
		// Doi tuong ket noi
		private Stack<Connection> pool; 
		
		public ConnectionPoolImpl() {
			// Xac dinh trinh dieu khien
			this.driver = "com.mysql.cj.jdbc.Driver";
			
			// Nap trinh dieu khien
			try {
				Class.forName(this.driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Xac dinh tai khoan
			this.username="it6020_hungdx";
			this.userpass="abc123!@#";
			
			// Xac dinh duong dan
			this.url="jdbc:mysql://localhost:3306/hotel_managment_website?allowMultiQueries=true";
			
			// Khoi tao bo nho doi tuong luu tru
			this.pool=new Stack<>();
		}

		@Override
		public Connection getConnection(String objectName) throws SQLException {
			// TODO Auto-generated method stub
			if (this.pool.isEmpty()) {
				System.out.println(objectName+" da khoi tao mot ket noi");
				return DriverManager.getConnection(this.url,this.username, this.userpass);
			}else {
				System.out.println(objectName+" da lay ra mot ket noi.");
				return this.pool.pop();
			}
		}

		@Override
		public void releaseConnection(Connection con, String objectName) throws SQLException {
			System.out.println(objectName+" da tra ve mot ket noi");
			this.pool.push(con);
		}
		 
		protected void finalize() throws Throwable{
			this.pool.clear();
			this.pool=null;
			System.out.println("CPool is close!");
		}
}
