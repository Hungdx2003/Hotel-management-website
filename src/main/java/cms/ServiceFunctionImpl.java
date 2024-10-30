package cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objects.ServiceObject;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class ServiceFunctionImpl implements ServiceFunction {
	private Connection con;

	public ServiceFunctionImpl(ConnectionPool cp) {
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
	public boolean addService(ServiceObject item) {
		if(this.isExisting(item)) {
			return false;
		}
		
		StringBuilder sql=new StringBuilder();
		sql.append("INSERT INTO service(");
		sql.append("service_name, description, price)");
		sql.append("VALUES(?,?,?)");
		
		try {
			PreparedStatement pre=this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getService_name());
			pre.setString(2, item.getDescription());
			pre.setInt(3, item.getPrice());

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

	private boolean isExisting(ServiceObject item) {
		boolean flag=false;
		String sql="SELECT service_id FROM service WHERE service_name=?";
		
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			pre.setString(1, item.getService_name());
			
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
	public boolean editService(ServiceObject item) {
		StringBuilder sql=new StringBuilder();
		sql.append("UPDATE service SET ");
		sql.append("service_name=?, description=?, price=? ");
		sql.append("WHERE service_id=?");
		
		try {
			PreparedStatement pre=this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getService_name());
			pre.setString(2, item.getDescription());
			pre.setInt(3, item.getPrice());
			pre.setInt(4, item.getService_id());
			
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
	public boolean delService(ServiceObject item) {
		String sql="DELETE FROM service WHERE service_id=?";
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			pre.setInt(1, item.getService_id());
			
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
	public ServiceObject getService(int id) {
		String sql="SELECT*FROM service WHERE service_id=?";
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			pre.setInt(1, id);
			ServiceObject item=null;
			ResultSet rs=pre.executeQuery();
			if (rs!=null) {
				if (rs.next()) {
					item=new ServiceObject();
					item.setService_id(rs.getInt("service_id"));
					item.setService_name(rs.getString("service_name"));
					item.setDescription(rs.getString("description"));
					item.setPrice(rs.getInt("price"));
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
	public ArrayList<ServiceObject> getAllService(ServiceObject similar) {
		String sql="SELECT * FROM service";
		sql+=" ";
		sql+="ORDER BY service_id DESC ";
		
		ArrayList<ServiceObject> list =new ArrayList<>();
		ServiceObject item=null;
		
		//Bien dich cau lenh
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			
			// Lay tap ket qua
			ResultSet rs=pre.executeQuery();
			if (rs!=null) {
				while (rs.next()) {
					item=new ServiceObject();
					item.setService_id(rs.getInt("service_id"));
					item.setService_name(rs.getString("service_name"));
					item.setDescription(rs.getString("description"));
					item.setPrice(rs.getInt("price"));
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
		ServiceObject so=new ServiceObject();
		so.setService_name("Dịch vụ dọn dẹp phòng");
		so.setPrice(100000);
		so.setDescription("Dịch vụ dọn dẹp phòng");
		
		ConnectionPool cp=new ConnectionPoolImpl();
		ServiceFunction sf=new ServiceFunctionImpl(cp);
		boolean addResult=sf.addService(so);
		ArrayList<ServiceObject> list=sf.getAllService(null);
		if (!addResult) {
			System.out.println("---------------- KHÔNG THÀNH CÔNG -----------------");
		}
		list.forEach(u ->{
			System.out.println(u);
		});
	}
}
