package cms.room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import objects.Room;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class RoomFunctionImpl implements RoomFunction {
	private Connection con;

	public RoomFunctionImpl(ConnectionPool cp) {
		if(cp==null) {
			cp=new ConnectionPoolImpl();
		}
		try {
			this.con=cp.getConnection("Room");
			// Kiem tra che do thuc thi tu dong
			if(this.con.getAutoCommit()) {
				this.con.setAutoCommit(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	private boolean exe(PreparedStatement pre) {
//		if(pre!=null) {
//			try {
//				int results=pre.executeUpdate();
//				if(results==0) {
//					this.con.rollback();
//					return false;
//				}
//				// Xac nhan thuc thi sau cung
//				this.con.commit();
//				return true;
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				
//				try {
//					this.con.rollback();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}finally {
//				pre=null;
//			}
//		}
//		return false;
//	}
	
	@Override
	public int addItem(Room room) {
		String sql = "INSERT into  room "
				+ "( RoomTypeID , Price , Status, Images , Reviews,"
				+ "FloorRoom ,NumberOfBeds , MaxOccupancy ,"
				+ " Area , Amentities ,NumberPhoneExtension , BookingHistory )"
				+" VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		int ketQua= 0;
		PreparedStatement st= null;
		//tạo đối tượng statement
		try {
			 st = con.prepareStatement(sql);
		
			st.setInt(1, room.getRoomTypeID());
			st.setLong(2, room.getPrice());
			st.setString(3, room.getStatus());
			st.setString (4,room.getImage());
			st.setString(5, room.getReviews());
			st.setInt(6, room.getFloorRoom());
			st.setInt(7, room.getNumberOfBeds());
			st.setInt(8, room.getMaxOccupancy());
			st.setFloat(9,room.getArea());
			st.setString(10, room.getAmentities());
			st.setString(11, room.getNumberPhoneExtension());
			st.setString(12, room.getBookingHistory());
			
		  ketQua = st.executeUpdate();	
		 con.commit();
		 System.out.println("Có "+ ketQua +" dòng bị thay đổi" );
		 
		} catch (SQLException e) {
			if(con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				if(con != null ) {
					con.close();
				}
				if(con != null ) {
					st.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			 
		}
		return ketQua;
	}

	@Override
	public int editItem(Room room) {
		String sql = "Update room Set RoomTypeID= ? , Price = ?, Status = ?, Images = ?, Reviews = ?, "
				+ "FloorRoom = ?, NumberOfBeds = ?, MaxOccupancy = ?,"
				+ " Area = ?, Amentities = ?, NumberPhoneExtension = ? , BookingHistory = ?"
				+" Where RoomID = ? ";
		int ketQua= 0;
		PreparedStatement st = null;
		//tạo đối tượng statement
		try {
			con.setAutoCommit(false);
			st = con.prepareStatement(sql);
		
			st.setInt(1, room.getRoomTypeID());
			st.setLong(2, room.getPrice());
			st.setString(3, room.getStatus());
			st.setString(4, room.getImage());
			st.setString(5, room.getReviews());
			st.setInt(6, room.getFloorRoom());
			st.setInt(7, room.getNumberOfBeds());
			st.setInt(8, room.getMaxOccupancy());
			st.setFloat(9,room.getArea());
			st.setString(10, room.getAmentities());
			st.setString(11, room.getNumberPhoneExtension());
			st.setString(12, room.getBookingHistory());
			st.setInt(13, room.getRoomID());	
		  ketQua = st.executeUpdate();	
		  con.commit();
		
		 System.out.println("Có "+ ketQua +" dòng bị thay đổi" );
		 
		} catch (SQLException e) {
			if(con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				if(con != null ) {
					con.close();
				}
				if(con != null ) {
					st.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			 {
				
			}
		}
		return ketQua;
	}

	@Override
	public int delItem(Room room) {
		String sql = "Delete from room where RoomID = ?";
		PreparedStatement st = null;
		int ketQua= 0;
		//tạo đối tượng statement
		try {
			 st = con.prepareStatement(sql);
			 st.setInt(1, room.getRoomID());
			 ketQua = st.executeUpdate();	
			 con.commit();
		 System.out.println("Có "+ ketQua +" dòng bị thay đổi" );
		 
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null ) {
					con.close();
				}
				if(con != null ) {
					st.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return ketQua;
	}

	@Override
	public ArrayList<Room> displayAllItem() {
		ArrayList<Room> ketQua = new ArrayList<Room>();
		Statement st=null;
		ResultSet rs = null;
		//tạo đối tượng statement
		try {
			 st = con.createStatement();
			String sql = "Select * from room order by RoomID DESC";
			 rs = st.executeQuery(sql);
			
			while (rs.next()) {
				Room room = new Room(rs.getInt("RoomID"),
									rs.getInt("RoomTypeID"), 
									rs.getLong("Price"), 
									rs.getString("Status"), 
									rs.getString("Images"),
									rs.getString("Reviews"),
									rs.getInt("FloorRoom"), 
									rs.getInt("NumberOfBeds"), 
									rs.getInt("MaxOccupancy"), 
									rs.getFloat("Area"),
									rs.getString("Amentities"),
									rs.getString("NumberPhoneExtension"),
									rs.getString("BookingHistory")) ;
				ketQua.add(room);
				
			}
		 System.out.println(sql);
		 //đóng kết nối
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null ) {
					con.close();
				}
				if(con != null ) {
					st.close();
				}
				if(con != null ) {
					rs.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
			 
		}
		return ketQua;
	}

	@Override
	public Room selectById(int id) {
		Room ketQua = null;
		
		//tạo đối tượng statement
		try {
			Statement st = con.createStatement();
			String sql = "Select * from room where RoomID = "+ id +" ";
			
			ResultSet rs = st.executeQuery(sql);
			
			if (rs.next()) {
				 	ketQua = new Room(rs.getInt("RoomID"),
									rs.getInt("RoomTypeID"), 
									rs.getLong("Price"), 
									rs.getString("Status"), 
									rs.getString("Images"),
									rs.getString("Reviews"),
									rs.getInt("FloorRoom"), 
									rs.getInt("NumberOfBeds"), 
									rs.getInt("MaxOccupancy"), 
									rs.getFloat("Area"),
									rs.getString("Amentities"),
									rs.getString("NumberPhoneExtension"),
									rs.getString("BookingHistory")) ;
				 	return ketQua;
				}
			System.out.println(sql);
 
			
		 
		 //đóng kết nối
		 con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

}
