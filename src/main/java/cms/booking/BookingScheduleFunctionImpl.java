 package cms.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import objects.BookingSchedule;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class BookingScheduleFunctionImpl implements BookingScheduleFunction {
	private Connection con;

	public BookingScheduleFunctionImpl(ConnectionPool cp) {
		if(cp==null) {
			cp=new ConnectionPoolImpl();
		}
		try {
			this.con=cp.getConnection("Booking");
			// Kiem tra che do thuc thi tu dong
			if(this.con.getAutoCommit()) {
				this.con.setAutoCommit(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private boolean exe(PreparedStatement pre) {
		if(pre!=null) {
			try {
				int results=pre.executeUpdate();
				if(results==0) {
					this.con.rollback();
					return false;
				}
				// Xac nhan thuc thi sau cung
				this.con.commit();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				try {
					this.con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}finally {
				pre=null;
			}
		}
		return false;
	}
	
	@Override
	public boolean addSchedule(BookingSchedule item) {
		
		StringBuilder sql=new StringBuilder();
		sql.append("INSERT INTO booking(");
		sql.append("customer_id, RoomID, ");
		sql.append("check_in_date, status) ");
		sql.append("VALUES(?,?,?,?)");
		
		try {
	        String customerQuery = "SELECT customer_id FROM customer WHERE customer_fullname=?";
	        PreparedStatement customerPre = this.con.prepareStatement(customerQuery);
	        customerPre.setString(1, item.getCustomer_fullname());
	        ResultSet customerRs = customerPre.executeQuery();
	        
	        int customerId = -1;
	        if (customerRs.next()) {
	            customerId = customerRs.getInt("customer_id");
	        } else {
	            throw new SQLException("Customer not found");
	        }

	        String roomQuery = "SELECT RoomID, RoomTypeID FROM room WHERE RoomNumber=?";
	        PreparedStatement roomPre = this.con.prepareStatement(roomQuery);
	        roomPre.setInt(1, item.getRoomNumber());
	        ResultSet roomRs = roomPre.executeQuery();
	        
	        int roomId = -1;
	        if (roomRs.next()) {
	            roomId = roomRs.getInt("RoomID");
	        } else {
	            throw new SQLException("Room not found");
	        }

	        PreparedStatement pre = this.con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
	        pre.setInt(1, customerId);
	        pre.setInt(2, roomId);
	        pre.setString(3, item.getCheck_in_date());
	        pre.setString(4, item.getStatus());

	        boolean result= this.exe(pre);
	        ResultSet generatedKeys = pre.getGeneratedKeys();
            int bookingId = -1;
            if (generatedKeys.next()) {
                bookingId = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Creating booking failed, no ID obtained.");
            }
	        if (result) {
				createInvoice(bookingId, roomId);
			}
	        return result;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        try {
	            this.con.rollback();
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	    }
	    return false;
	}
	
	public void createInvoice(int bookingId, int roomId) {
		String sql="INSERT INTO invoice (booking_id, status) VALUES (?, ?)";
		try {
			String roomTypeQuery = "SELECT Price FROM room WHERE RoomID=?";
	        PreparedStatement roomTypePre= this.con.prepareStatement(roomTypeQuery);
			roomTypePre.setInt(1, roomId);
	        
	        String status="Chưa thanh toán";
	        PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setInt(1, bookingId);
            pre.setString(2,status);
            
            this.exe(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean isCheckedin(BookingSchedule item) {
		boolean flag=false;
		String sql="SELECT RoomID FROM booking WHERE status='Nhận phòng' AND RoomID IN (SELECT RoomID FROM room WHERE RoomNumber=?)";
		
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			pre.setInt(1, item.getRoomNumber());
			
			ResultSet rs=pre.executeQuery();
			if (rs!= null) {
				if (rs.next()) {
					flag=true;
				}
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				this.con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return flag;
	}
	
	@Override
	public boolean editSchedule(BookingSchedule item) {
		StringBuilder sql = new StringBuilder();
	    sql.append("UPDATE booking SET ");
	    sql.append("customer_id=?, RoomID=?, ");
	    sql.append("check_in_date=?, status=? ");
	    sql.append("WHERE booking_id=?");
	    
	    try {
	        String customerQuery = "SELECT customer_id FROM customer WHERE customer_fullname=?";
	        PreparedStatement customerStmt = this.con.prepareStatement(customerQuery);
	        customerStmt.setString(1, item.getCustomer_fullname());
	        ResultSet customerRs = customerStmt.executeQuery();
	        
	        int customerId = -1;
	        if (customerRs.next()) {
	            customerId = customerRs.getInt("customer_id");
	        } else {
	            throw new SQLException("Customer not found");
	        }

	        String roomQuery = "SELECT RoomID FROM room WHERE RoomNumber=?";
	        PreparedStatement roomStmt = this.con.prepareStatement(roomQuery);
	        roomStmt.setInt(1, item.getRoomNumber());
	        ResultSet roomRs = roomStmt.executeQuery();
	        
	        int roomId = -1;
	        if (roomRs.next()) {
	            roomId = roomRs.getInt("RoomID");
	        } else {
	            throw new SQLException("Room not found");
	        }

	        PreparedStatement pre = this.con.prepareStatement(sql.toString());
	        pre.setInt(1, customerId);
	        pre.setInt(2, roomId);
	        pre.setString(3, item.getCheck_in_date());
	        pre.setString(4, item.getStatus());
	        pre.setInt(5, item.getBooking_id());

	        return this.exe(pre);

	    } catch (SQLException e) {
	        e.printStackTrace();
	        try {
	            this.con.rollback();
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	    }
	    return false;
	}
	
	public String getBookingCountByMonth() {
	    StringBuilder message = new StringBuilder();

	    String sql = "SELECT DATE_FORMAT(check_in_date, '%Y-%m') AS month_year, COUNT(*) AS count " +
	                 "FROM booking " +
	                 "GROUP BY month_year " +
	                 "ORDER BY month_year";
	    try {
	        PreparedStatement pre = this.con.prepareStatement(sql);
	        ResultSet rs = pre.executeQuery();
	        message.append("[");
	        boolean first = true;
	        while (rs.next()) {
	            if (!first) {
	                message.append(",");
	            }
	            String monthYear = rs.getString("month_year");
	            int count = rs.getInt("count");
	            message.append("{");
	            message.append("\"month_year\": \"").append(monthYear).append("\",");
	            message.append("\"count\": ").append(count);
	            message.append("}");
	            first = false;
	        }
	        message.append("]");
	        rs.close(); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return message.toString();
	}



	public ArrayList<String> getRoomTypes() {
	    String sql = "SELECT RoomTypeName FROM room_type";
	    ArrayList<String> roomTypes = new ArrayList<>();

	    try {
	        PreparedStatement pre = this.con.prepareStatement(sql);
	        ResultSet rs = pre.executeQuery();
	        while (rs.next()) {
	            roomTypes.add(rs.getString("RoomTypeName"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        try {
	            this.con.rollback();
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	    }

	    return roomTypes;
	}
	
	public ArrayList<String> getRoomsByType(String roomTypeName) {
        String sql = "SELECT r.RoomNumber FROM room r " +
                     "JOIN room_type rt ON r.RoomTypeID = rt.RoomTypeID " +
                     "WHERE rt.RoomTypeName = ? AND r.RoomID NOT IN " +
                     "(SELECT RoomID FROM booking WHERE status = 'Nhận phòng')";
        ArrayList<String> rooms = new ArrayList<>();

        try {
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setString(1, roomTypeName);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                rooms.add(rs.getString("RoomNumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                this.con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        return rooms;
    }
	
	public ArrayList<String> getServiceName() {
	    String sql = "SELECT service_name FROM service";
	    ArrayList<String> list = new ArrayList<>();

	    try {
	        PreparedStatement pre = this.con.prepareStatement(sql);
	        ResultSet rs = pre.executeQuery();
	        while (rs.next()) {
	            list.add(rs.getString("service_name"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        try {
	            this.con.rollback();
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	    }

	    return list;
	}
	
	public boolean addRequest(BookingSchedule item) {
			StringBuilder sql=new StringBuilder();
			sql.append("INSERT INTO service_usage(");
			sql.append("booking_id, service_id, ");
			sql.append("quantity) ");
			sql.append("VALUES(?,?,?)");
			
			try {
		        String customerQuery = "SELECT service_id FROM service WHERE service_name=?";
		        PreparedStatement servicePre = this.con.prepareStatement(customerQuery);
		        servicePre.setString(1, item.getService_name());
		        ResultSet serviceRs = servicePre.executeQuery();
		        
		        int serviceId = -1;
		        if (serviceRs.next()) {
		            serviceId = serviceRs.getInt("service_id");
		        } else {
		            throw new SQLException("Service not found");
		        }
	
		        PreparedStatement pre = this.con.prepareStatement(sql.toString());
		        pre.setInt(1, item.getBooking_id());
		        pre.setInt(2, serviceId);
		        pre.setInt(3, item.getQuanity());
	
		        return this.exe(pre);
	
		    } catch (SQLException e) {
		        e.printStackTrace();
		        try {
		            this.con.rollback();
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
		    }
		    return false;
		}

	@Override
	public BookingSchedule getSchedule(int id) {
	    String sql = "SELECT b.*, c.customer_fullname, r.RoomNumber " +
	                 "FROM booking b " +
	                 "JOIN customer c ON b.customer_id = c.customer_id " +
	                 "JOIN room r ON b.RoomID = r.RoomID " +
	                 "WHERE b.booking_id = ?";
	    
	    try {
	        PreparedStatement pre = this.con.prepareStatement(sql);
	        pre.setInt(1, id);
	        
	        ResultSet rs = pre.executeQuery();
	        if (rs.next()) {
	            BookingSchedule item = new BookingSchedule();
	            item.setCustomer_id(rs.getInt("customer_id"));
	            item.setCustomer_fullname(rs.getString("customer_fullname"));
	            item.setBooking_id(rs.getInt("booking_id"));
	            item.setRoomID(rs.getInt("RoomID"));
	            item.setRoomNumber(rs.getInt("RoomNumber"));
	            item.setCheck_in_date(rs.getString("check_in_date"));
	            item.setCheck_out_date(rs.getString("check_out_date"));
	            item.setStatus(rs.getString("status"));
	            return item;
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        try {
	            this.con.rollback();
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	    }
	    
	    return null;
	}

	
	@Override
	public ArrayList<BookingSchedule> getAllSchedule(BookingSchedule similar) {
	    String sql = "SELECT b.*, c.customer_fullname, r.RoomNumber " +
	                 "FROM booking b " +
	                 "JOIN customer c ON b.customer_id = c.customer_id " +
	                 "JOIN room r ON b.RoomID = r.RoomID " +
	                 "ORDER BY b.booking_id DESC";

	    ArrayList<BookingSchedule> list = new ArrayList<>();
	    
	    try {
	        PreparedStatement pre = this.con.prepareStatement(sql);
	        ResultSet rs = pre.executeQuery();
	        
	        while (rs.next()) {
	            BookingSchedule item = new BookingSchedule();
	            item.setCustomer_id(rs.getInt("customer_id"));
	            item.setCustomer_fullname(rs.getString("customer_fullname"));
	            item.setBooking_id(rs.getInt("booking_id"));
	            item.setRoomID(rs.getInt("RoomID"));
	            item.setRoomNumber(rs.getInt("RoomNumber"));
	            item.setCheck_in_date(rs.getString("check_in_date"));
	            item.setCheck_out_date(rs.getString("check_out_date"));
	            item.setStatus(rs.getString("status"));
	            list.add(item);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        try {
	            this.con.rollback();
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	    }
	    
	    return list;
	}
	public static void main(String[] args) {
		BookingSchedule b=new BookingSchedule();
		b.setBooking_id(50);
		b.setCheck_in_date("2024-06-14");
		b.setStatus("Nhận phòng");
		b.setCustomer_fullname("Trình Ban Mai");
		b.setRoomNumber(104);
		b.setService_name("Dịch vụ thuê xe du lịch");
		b.setQuanity(1);
		
		ConnectionPool cp=new ConnectionPoolImpl();
		BookingScheduleFunction bf=new BookingScheduleFunctionImpl(cp);
//		boolean editResult=bf.editSchedule(b);
//		if (!editResult) {
//			System.out.println("---------------- KHÔNG THÀNH CÔNG -----------------");
//		}
//		ArrayList<BookingSchedule> list=bf.getAllSchedule(null);
//		list.forEach(u ->{
//			System.out.println(u);
//		}); 
//		 ArrayList<String> roomTypes = ((BookingScheduleFunctionImpl) bf).getRoomTypes();
//		    System.out.println("Danh sách tên các loại phòng:");
//		    roomTypes.forEach(roomType -> {
//		        System.out.println(roomType);
//		    });
//		ArrayList<String> rooms = ((BookingScheduleFunctionImpl) bf).getRoomsByType("Phòng đơn");
//        System.out.println("Danh sách các phòng loại Phòng đơn không trong trạng thái 'Nhận phòng':");
//        rooms.forEach(room -> {
//            System.out.println(room);
//        });
		String bookingCountByMonth = ((BookingScheduleFunctionImpl) bf).getBookingCountByMonth();
        System.out.println(bookingCountByMonth);
//		boolean addRequest=((BookingScheduleFunctionImpl)bf).addRequest(b);
	}
}

