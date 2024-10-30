package cms.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objects.CustomerObject;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class CustomerFunctionImpl implements CustomerFunction {
	private Connection con;

	public CustomerFunctionImpl(ConnectionPool cp) {
		if(cp==null) {
			cp=new ConnectionPoolImpl();
		}
		try {
			this.con=cp.getConnection("Customer");
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
	public boolean addCustomer(CustomerObject item) {
		if(this.isExisting(item)) {
			return false;
		}
		
		StringBuilder sql=new StringBuilder();
		sql.append("INSERT INTO customer(");
		sql.append("customer_fullname, ");
		sql.append("customer_birthday, customer_mobilephone, customer_email, customer_gender, ");
		sql.append("customer_nationality, customer_ID_number, customer_address) ");
		sql.append("VALUES(?,?,?,?,?,?,?,?)");
		
		try {
			PreparedStatement pre=this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getCustomer_fullname());
			pre.setString(2, item.getCustomer_birthday());
			pre.setString(3, item.getCustomer_mobilephone());
			pre.setString(4, item.getCustomer_email());
			pre.setString(5, item.getCustomer_gender());
			pre.setString(6, item.getCustomer_nationality());
			pre.setString(7, item.getCustomer_ID_number());
			pre.setString(8, item.getCustomer_address());
			
			return exe(pre);
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
		return false;
	}
	
	private boolean isExisting(CustomerObject item) {
		boolean flag=false;
		String sql="SELECT customer_id FROM customer WHERE customer_fullname=?";
		
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			pre.setString(1, item.getCustomer_fullname());
			
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
	public boolean editCustomer(CustomerObject item) {
		StringBuilder sql=new StringBuilder();
		sql.append("UPDATE customer SET ");
		sql.append("customer_fullname=?, ");
		sql.append("customer_birthday=?, customer_mobilephone=?, customer_email=?, customer_gender=?, ");
		sql.append("customer_nationality=?, customer_ID_number=?, customer_address=? ");
		sql.append("WHERE customer_id=?");
		
		try {
			PreparedStatement pre=this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getCustomer_fullname());
			pre.setString(2, item.getCustomer_birthday());
			pre.setString(3, item.getCustomer_mobilephone());
			pre.setString(4, item.getCustomer_email());
			pre.setString(5, item.getCustomer_gender());
			pre.setString(6, item.getCustomer_nationality());
			pre.setString(7, item.getCustomer_ID_number());
			pre.setString(8, item.getCustomer_address());
			pre.setInt(9, item.getCustomer_id());
			
			return this.exe(pre);
			
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
		return false;
	}

	@Override
	public boolean delCustomer(CustomerObject item) {
		String sql="DELETE FROM customer WHERE customer_id=?";
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			pre.setInt(1, item.getCustomer_id());
			
			return this.exe(pre);
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
		return false;
	}
	
	@Override
	public String getCountOfGender(CustomerObject item) {
	    StringBuilder message = new StringBuilder();

	    String sql = "SELECT customer_gender, COUNT(*) AS count FROM customer GROUP BY customer_gender";
	    try {
	        PreparedStatement pre = this.con.prepareStatement(sql);
	        ResultSet rs = pre.executeQuery();
	        message.append("[");
	        boolean first = true;
	        while (rs.next()) {
	            if (!first) {
	                message.append(",");
	            }
	            String gender = rs.getString("customer_gender");
	            int count = rs.getInt("count");
	            message.append("{");
	            message.append("\"gender\": \"").append(gender).append("\",");
	            message.append("\"count\": ").append(count);
	            message.append("}");
	            first = false;
	        }
	        message.append("]");
	        rs.close(); // Đóng ResultSet sau khi sử dụng
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return message.toString();
	}
	
	@Override
	public String getCountOfAgeGroup(CustomerObject item) {
	    StringBuilder message = new StringBuilder();

	    String sql = "SELECT "
                + "SUM(CASE WHEN TIMESTAMPDIFF(YEAR, STR_TO_DATE(customer_birthday, '%d/%m/%Y'), CURDATE()) BETWEEN 0 AND 12 THEN 1 ELSE 0 END) AS age_group_0_12, "
                + "SUM(CASE WHEN TIMESTAMPDIFF(YEAR, STR_TO_DATE(customer_birthday, '%d/%m/%Y'), CURDATE()) BETWEEN 13 AND 18 THEN 1 ELSE 0 END) AS age_group_13_18, "
                + "SUM(CASE WHEN TIMESTAMPDIFF(YEAR, STR_TO_DATE(customer_birthday, '%d/%m/%Y'), CURDATE()) BETWEEN 19 AND 30 THEN 1 ELSE 0 END) AS age_group_19_30, "
                + "SUM(CASE WHEN TIMESTAMPDIFF(YEAR, STR_TO_DATE(customer_birthday, '%d/%m/%Y'), CURDATE()) BETWEEN 31 AND 50 THEN 1 ELSE 0 END) AS age_group_31_50, "
                + "SUM(CASE WHEN TIMESTAMPDIFF(YEAR, STR_TO_DATE(customer_birthday, '%d/%m/%Y'), CURDATE()) > 50 THEN 1 ELSE 0 END) AS age_group_over_50 "
                + "FROM customer";

	    try {
	        PreparedStatement pre = this.con.prepareStatement(sql);
	        ResultSet rs = pre.executeQuery();

	        message.append("[");
	        if (rs.next()) {
	            message.append("{age_group: '0-12', count: ").append(rs.getInt("age_group_0_12")).append("},");
	            message.append("{age_group: '13-18', count: ").append(rs.getInt("age_group_13_18")).append("},");
	            message.append("{age_group: '19-30', count: ").append(rs.getInt("age_group_19_30")).append("},");
	            message.append("{age_group: '31-50', count: ").append(rs.getInt("age_group_31_50")).append("},");
	            message.append("{age_group: 'Over 50', count: ").append(rs.getInt("age_group_over_50")).append("}");
	        }
	        message.append("]");

	        rs.close(); // Đóng ResultSet sau khi sử dụng
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return message.toString();
	}

	@Override
	public CustomerObject getCustomer(int id) {
		String sql="SELECT*FROM customer WHERE customer_id=?";
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			pre.setInt(1, id);
			CustomerObject item=null;
			ResultSet rs=pre.executeQuery();
			if (rs!=null) {
				if (rs.next()) {
					item=new CustomerObject();
					item.setCustomer_id(rs.getInt("customer_id"));
					item.setCustomer_name(rs.getString("customer_name"));
					item.setCustomer_pass(rs.getString("customer_pass"));
					item.setCustomer_fullname(rs.getString("customer_fullname"));
					item.setCustomer_birthday(rs.getString("customer_birthday"));
					item.setCustomer_mobilephone(rs.getString("customer_mobilephone"));
					item.setCustomer_email(rs.getString("customer_email"));
					item.setCustomer_gender(rs.getString("customer_gender"));
					item.setCustomer_nationality(rs.getString("customer_nationality"));
					item.setCustomer_ID_number(rs.getString("customer_ID_number"));
					item.setCustomer_address(rs.getString("customer_address"));
					return item;
				}
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
		return null;
	}

	@Override
	public CustomerObject searchCustomerByName(String name) {
		String sql="SELECT*FROM customer WHERE customer_name=?";
		
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			pre.setString(1, name);
			CustomerObject item=null;
			ResultSet rs=pre.executeQuery();
			
			if (rs!=null) {
				if(rs.next()) {
					item=new CustomerObject();
					item.setCustomer_id(rs.getInt("customer_id"));
					item.setCustomer_name(rs.getString("customer_name"));
					item.setCustomer_pass(rs.getString("customer_pass"));
					item.setCustomer_fullname(rs.getString("customer_fullname"));
					item.setCustomer_birthday(rs.getString("customer_birthday"));
					item.setCustomer_mobilephone(rs.getString("customer_mobilephone"));
					item.setCustomer_email(rs.getString("customer_email"));
					item.setCustomer_gender(rs.getString("customer_gender"));
					item.setCustomer_nationality(rs.getString("customer_nationality"));
					item.setCustomer_ID_number(rs.getString("customer_ID_number"));
					item.setCustomer_address(rs.getString("customer_address"));
					return item;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<CustomerObject> getCustomer(CustomerObject similar) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM customer";
		sql+=" ";
		sql+="ORDER BY customer_id DESC ";
		
		ArrayList<CustomerObject> list =new ArrayList<>();
		CustomerObject item=null;
		
		//Bien dich cau lenh
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			
			// Lay tap ket qua
			ResultSet rs=pre.executeQuery();
			if (rs!=null) {
				while (rs.next()) {
					item=new CustomerObject();
					item.setCustomer_id(rs.getInt("customer_id"));
					item.setCustomer_name(rs.getString("customer_name"));
					item.setCustomer_pass(rs.getString("customer_pass"));
					item.setCustomer_fullname(rs.getString("customer_fullname"));
					item.setCustomer_birthday(rs.getString("customer_birthday"));
					item.setCustomer_mobilephone(rs.getString("customer_mobilephone"));
					item.setCustomer_email(rs.getString("customer_email"));
					item.setCustomer_gender(rs.getString("customer_gender"));
					item.setCustomer_nationality(rs.getString("customer_nationality"));
					item.setCustomer_ID_number(rs.getString("customer_ID_number"));
					item.setCustomer_address(rs.getString("customer_address"));
					list.add(item);
				}
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
		return list;
	}
	public static void main(String[] args) {
		ConnectionPool cp=new ConnectionPoolImpl();
		
		CustomerFunction cf=new CustomerFunctionImpl(cp);
		
		CustomerObject co=new CustomerObject();
		co.setCustomer_id(73);
		co.setCustomer_name("advance java");
		co.setCustomer_pass("abc123!!@#");
		co.setCustomer_fullname("Đình Xuân Hưng");
		co.setCustomer_address("BÌnh định");
		co.setCustomer_gender("Nam");
		co.setCustomer_mobilephone("0122345465");
		
//		boolean results=cf.addCustomer(co);
//		boolean results=cf.editCustomer(co);
//		boolean results=cf.delCustomer(co);
//		if (!results) {
//			System.out.println("---------------- KHÔNG THÀNH CÔNG -----------------");
//		}
//		ArrayList<CustomerObject> list=cf.getCustomer(null);
//		list.forEach(u ->{
//			System.out.println(u);
//		});
//		System.out.println(cf.getCountOfGender(null));
		System.out.println(cf.getCountOfAgeGroup(null));
	}
}
