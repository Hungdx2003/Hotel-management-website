package cms.invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objects.Invoice;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class InvoiceFunctionImpl implements InvoiceFunction {
	private Connection con;

	public InvoiceFunctionImpl(ConnectionPool cp) {
		if(cp==null) {
			cp=new ConnectionPoolImpl();
		}
		try {
			this.con=cp.getConnection("Service");
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
	public Invoice getTotalInvoice(int id) {
		Invoice invoice = getInvoice(id);
	    
	    if (invoice != null) {
	        Invoice roomDetails = getRoom(id);
	        ArrayList<Invoice> serviceDetails = getServiceUsage(id);
	        
	        if (roomDetails != null) {
	            int room_total=roomDetails.getTotal();
	            int service_total=0;
	            for(Invoice a: serviceDetails) {
	            	service_total+=a.getTotal();
	            }
	            int invoice_total=room_total+service_total;
	            invoice.setAmount(invoice_total);
	            
	            return invoice;
	        }
	    }
	    return null;
	}
	@Override
	public Invoice getRoom(int id) {
		StringBuilder sql=new StringBuilder();
		sql.append("SELECT i.invoice_id, r.RoomNumber, r.Price, rt.RoomTypeName, b.check_in_date, ");
		sql.append("DATEDIFF(COALESCE(b.check_out_date, CURRENT_DATE), b.check_in_date) AS num_days, ");
		sql.append("DATEDIFF(COALESCE(b.check_out_date, CURRENT_DATE), b.check_in_date) * r.Price AS total ");
		sql.append("FROM invoice i ");
		sql.append("JOIN booking b ON b.booking_id=i.booking_id ");
		sql.append("JOIN room r ON r.RoomID=b.RoomID ");
		sql.append("JOIN room_type rt ON r.RoomTypeID=rt.RoomTypeID ");
		sql.append("WHERE i.invoice_id=?");
		
		try {
			PreparedStatement pre=this.con.prepareStatement(sql.toString());
			pre.setInt(1, id);
			
			ResultSet rs=pre.executeQuery();
			if (rs.next()) {
				Invoice item=new Invoice();
				item.setInvoice_id(rs.getInt("invoice_id"));
				item.setRoomNumber(rs.getInt("RoomNumber"));
				item.setRoomType(rs.getString("RoomTypeName"));
				item.setQuantity(rs.getInt("num_days"));
				item.setTotal(rs.getInt("total"));
				item.setRoom_price(rs.getInt("Price"));
				return item;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}
	
	@Override
	public ArrayList<Invoice> getServiceUsage(int id) {
	    StringBuilder sql = new StringBuilder();
	    sql.append("SELECT s.service_name, s.price, su.quantity, ");
	    sql.append("s.price * su.quantity AS total ");
	    sql.append("FROM invoice i ");
	    sql.append("JOIN booking b ON b.booking_id = i.booking_id ");
	    sql.append("JOIN service_usage su ON su.booking_id = b.booking_id ");
	    sql.append("JOIN service s ON s.service_id = su.service_id ");
	    sql.append("WHERE i.invoice_id = ?");

	    ArrayList<Invoice> list = new ArrayList<>();

	    try {
	        PreparedStatement pre = this.con.prepareStatement(sql.toString());
	        pre.setInt(1, id);

	        ResultSet rs = pre.executeQuery();
	        while (rs.next()) {
	        	Invoice item = new Invoice();
	        	item.setService_name(rs.getString("service_name"));
	        	item.setQuantity(rs.getInt("quantity"));
	        	item.setService_price(rs.getInt("price"));
	        	item.setTotal(rs.getInt("total"));
	        	list.add(item);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}
	
	@Override
	public boolean payInvoice(int id) {
		StringBuilder sql=new StringBuilder();
		sql.append("UPDATE invoice SET ");
		sql.append("pay_date=CURRENT_DATE,status='Đã thanh toán', amount=? ");
		sql.append("WHERE invoice_id=?");
		
		Invoice invoice=getTotalInvoice(id);
		int total=invoice.getAmount();
		
		try {
			PreparedStatement pre=this.con.prepareStatement(sql.toString());
			pre.setInt(1, total);
			pre.setInt(2, id);
			return this.exe(pre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Invoice getInvoice(int id) {
		String sql = "SELECT i.*, c.*, b.* " +
	                "FROM invoice i " +
	                "JOIN booking b ON b.booking_id = i.booking_id " +
	                "JOIN customer c ON b.customer_id = c.customer_id " +
	                "WHERE i.invoice_id = ?";
   
	   try {
	       PreparedStatement pre = this.con.prepareStatement(sql);
	       pre.setInt(1, id);
	       
	       ResultSet rs = pre.executeQuery();
	       if (rs.next()) {
	    	   Invoice item = new Invoice();
	           item.setBooking_id(rs.getInt("booking_id"));
	           item.setCustomer_fullname(rs.getString("customer_fullname"));
	           item.setPay_date(rs.getString("pay_date"));
	           item.setStatus(rs.getString("status"));
	           item.setInvoice_id(rs.getInt("invoice_id"));
	           item.setAmount(rs.getInt("amount"));
	           item.setCustomer_mobilephone(rs.getString("customer_mobilephone"));
	           item.setCheck_in_date(rs.getString("check_in_date"));
	           item.setCheck_out_date(rs.getString("check_out_date"));
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
	public ArrayList<Invoice> getAllInvoice(Invoice simillar) {
		String sql = "SELECT i.*, c.customer_fullname " +
                "FROM invoice i " +
                "JOIN booking b ON b.booking_id = i.booking_id " +
                "JOIN customer c ON b.customer_id = c.customer_id " +
                "ORDER BY i.invoice_id DESC";
		ArrayList<Invoice> list=new ArrayList<>();
	   try {
	       PreparedStatement pre = this.con.prepareStatement(sql);
	       ResultSet rs = pre.executeQuery();
	       while (rs.next()) {
	    	   Invoice item = new Invoice();
	           item.setBooking_id(rs.getInt("booking_id"));
	           item.setCustomer_fullname(rs.getString("customer_fullname"));
	           item.setPay_date(rs.getString("pay_date"));
	           item.setStatus(rs.getString("status"));
	           item.setInvoice_id(rs.getInt("invoice_id"));
	           item.setAmount(rs.getInt("amount"));
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
		ConnectionPool cp = new ConnectionPoolImpl();
    	InvoiceFunction bsf = new InvoiceFunctionImpl(cp);
    	
    	Invoice i=bsf.getTotalInvoice(47);
    	System.out.println(i);
    	
//    	ArrayList<Invoice> list = bsf.getAllInvoice(null);
//    	list.forEach(u ->{
//    		System.out.println(u);
//    	});
	}
}
