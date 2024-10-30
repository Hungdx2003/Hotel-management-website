package cms.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objects.EmployeeObject;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class EmployeeFunctionImpl implements EmployeeFunction {
	private Connection con;

	public EmployeeFunctionImpl(ConnectionPool cp) {
		if(cp==null) {
			cp=new ConnectionPoolImpl();
		}
		try {
			this.con=cp.getConnection("Employee");
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
	public boolean addEmployee(EmployeeObject item) {
		if(this.isExisting(item)) {
			return false;
		}
		
		StringBuilder sql=new StringBuilder();
		sql.append("INSERT INTO employee(");
		sql.append("username, password, full_name, email, ");
		sql.append("phone_number, gender, position_id, created_at) ");
		sql.append("VALUES(?,?,?,?,?,?,?,?)");
		
		try {
			PreparedStatement pre=this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getEmployee_username());
			pre.setString(2, item.getEmployee_password());
			pre.setString(3, item.getEmployee_full_name());
			pre.setString(4, item.getEmployee_email());
			pre.setString(5, item.getEmployee_phone_number());
			pre.setString(6, item.getEmployee_gender());
			pre.setString(7, item.getEmployee_position_id());
			pre.setString(8, item.getEmployee_created_at());
			
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
	
	private boolean isExisting(EmployeeObject item) {
		boolean flag=false;
		String sql="SELECT employee_id FROM employee WHERE full_name=?";
		
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			pre.setString(1, item.getEmployee_full_name());
			
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
	public boolean editEmployee(EmployeeObject item) {
		StringBuilder sql=new StringBuilder();
		sql.append("UPDATE employee SET ");
		sql.append("username=?, password=?, full_name=?, email=?, ");
		sql.append("phone_number=?, gender=?, position_id=?, created_at=? ");
		sql.append("WHERE employee_id=?");
		
		try {
			PreparedStatement pre=this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getEmployee_username());
			pre.setString(2, item.getEmployee_password());
			pre.setString(3, item.getEmployee_full_name());
			pre.setString(4, item.getEmployee_email());
			pre.setString(5, item.getEmployee_phone_number());
			pre.setString(6, item.getEmployee_gender());
			pre.setString(7, item.getEmployee_position_id());
			pre.setString(8, item.getEmployee_created_at());
			pre.setInt(9, item.getEmployee_id());
			
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
	public boolean delEmployee(EmployeeObject item) {
		String sql="DELETE FROM employee WHERE employee_id=?";
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			pre.setInt(1, item.getEmployee_id());
			
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
	public EmployeeObject getEmployee(int id) {
		String sql="SELECT*FROM employee WHERE employee_id=?";
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			pre.setInt(1, id);
			EmployeeObject item=null;
			ResultSet rs=pre.executeQuery();
			if (rs!=null) {
				if (rs.next()) {
					item=new EmployeeObject();
					item.setEmployee_id(rs.getInt("employee_id"));
					item.setEmployee_username(rs.getString("username"));
					item.setEmployee_password(rs.getString("password"));
					item.setEmployee_full_name(rs.getString("full_name"));
					item.setEmployee_email(rs.getString("email"));
					item.setEmployee_phone_number(rs.getString("phone_number"));
					item.setEmployee_gender(rs.getString("gender"));
					item.setEmployee_position_id(rs.getString("position_id"));
					item.setEmployee_created_at(rs.getString("created_at"));
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
	public String getPositionNameByID(int id) {
		String sql = "SELECT e.full_name, p.position_name " +
                "FROM employee e " +
                "JOIN position p ON e.position_id = p.position_id " +
                "WHERE p.position_id = ?";
		String result="";
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			pre.setInt(1, id);
			
			ResultSet rs = pre.executeQuery();
			if (rs != null && rs.next()) {
	            result=rs.getString("position_name");
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public EmployeeObject checkLogin(String username, String password) {
		EmployeeObject item = null;
	    String sql = "SELECT * FROM employee WHERE (username = ?) AND (password = ?)";
	    
	    try {
	        PreparedStatement pre = this.con.prepareStatement(sql);
	        pre.setString(1, username);
	        pre.setString(2, password);

	        ResultSet rs = pre.executeQuery();
	        if (rs != null && rs.next()) {
	            item = new EmployeeObject();
	            item.setEmployee_id(rs.getInt("employee_id"));
				item.setEmployee_full_name(rs.getString("full_name"));
				item.setEmployee_email(rs.getString("email"));
				item.setEmployee_phone_number(rs.getString("phone_number"));
				item.setEmployee_gender(rs.getString("gender"));
				item.setEmployee_position_id(rs.getString("position_id"));
				item.setEmployee_created_at(rs.getString("created_at"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return item;
	}
	
	@Override
	public EmployeeObject searchEmployeeByName(String name) {
		String sql="SELECT*FROM Employee WHERE Employee_full_name=?";
		
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			pre.setString(1, name);
			EmployeeObject item=null;
			ResultSet rs=pre.executeQuery();
			
			if (rs!=null) {
				if(rs.next()) {
					item=new EmployeeObject();
					item.setEmployee_id(rs.getInt("employee_id"));
					item.setEmployee_username(rs.getString("username"));
					item.setEmployee_password(rs.getString("password"));
					item.setEmployee_full_name(rs.getString("full_name"));
					item.setEmployee_email(rs.getString("email"));
					item.setEmployee_phone_number(rs.getString("phone_number"));
					item.setEmployee_gender(rs.getString("gender"));
					item.setEmployee_position_id(rs.getString("position_id"));
					item.setEmployee_created_at(rs.getString("created_at"));
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
	public ArrayList<EmployeeObject> getEmployee(EmployeeObject similar) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM Employee";
		sql+=" ";
		sql+="ORDER BY Employee_id DESC ";
		
		ArrayList<EmployeeObject> list =new ArrayList<>();
		EmployeeObject item=null;
		
		//Bien dich cau lenh
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			
			// Lay tap ket qua
			ResultSet rs=pre.executeQuery();
			if (rs!=null) {
				while (rs.next()) {
					item=new EmployeeObject();
					item.setEmployee_id(rs.getInt("employee_id"));
					item.setEmployee_username(rs.getString("username"));
					item.setEmployee_password(rs.getString("password"));
					item.setEmployee_full_name(rs.getString("full_name"));
					item.setEmployee_email(rs.getString("email"));
					item.setEmployee_phone_number(rs.getString("phone_number"));
					item.setEmployee_gender(rs.getString("gender"));
					item.setEmployee_position_id(rs.getString("position_id"));
					item.setEmployee_created_at(rs.getString("created_at"));
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
		
		EmployeeFunction cf=new EmployeeFunctionImpl(cp);
		
		EmployeeObject co=new EmployeeObject();
		co.setEmployee_id(73);
		co.setEmployee_username("Cuongdz");
		co.setEmployee_password("abc123!!@#");
		co.setEmployee_full_name("Lê Văn Cường");
		co.setEmployee_email("Dongongdz@gmail.com");
		co.setEmployee_gender("Nam");
		co.setEmployee_phone_number("0122345465");
		
//		boolean results=cf.addEmployee(co);
//		boolean results=cf.editEmployee(co);
//		boolean results=cf.delEmployee(co);
//		if (!results) {
//			System.out.println("---------------- KHÔNG THÀNH CÔNG -----------------");
//		}
//		ArrayList<EmployeeObject> list=cf.getEmployee(null);
//		list.forEach(u ->{
//			System.out.println(u);
//		});
		String rs=cf.getPositionNameByID(1);
		System.out.println(rs);
	}
}
