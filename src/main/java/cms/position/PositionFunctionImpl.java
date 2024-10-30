package cms.position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import objects.PositionObject;
import util.ConnectionPool;
import util.ConnectionPoolImpl;

public class PositionFunctionImpl implements PositionFunction {
	private Connection con;

	public PositionFunctionImpl(ConnectionPool cp) {
		if(cp==null) {
			cp=new ConnectionPoolImpl();
		}
		try {
			this.con=cp.getConnection("Position");
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
	public boolean addPosition(PositionObject item) {
		if(this.isExisting(item)) {
			return false;
		}
		
		StringBuilder sql=new StringBuilder();
		sql.append("INSERT INTO position (position_name) ");
		sql.append("VALUES(?)");
		
		try {
			PreparedStatement pre=this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getPosition_name());

			
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
	
	private boolean isExisting(PositionObject item) {
		boolean flag=false;
		String sql="SELECT position_id FROM position WHERE position_name=?";
		
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			pre.setString(1, item.getPosition_name());
			
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
	public boolean editPosition(PositionObject item) {
		StringBuilder sql=new StringBuilder();
		sql.append("UPDATE position SET ");
		sql.append("position_name=? ");
		sql.append("WHERE position_id=?");
		
		try {
			PreparedStatement pre=this.con.prepareStatement(sql.toString());
			pre.setString(1, item.getPosition_name());
			pre.setInt(2, item.getPosition_id());
			
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
	public boolean delPosition(PositionObject item) {
		String sql="DELETE FROM position WHERE position_id=?";
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			pre.setInt(1, item.getPosition_id());
			
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
	public PositionObject getPosition(int id) {
		String sql="SELECT*FROM position WHERE position_id=?";
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			pre.setInt(1, id);
			PositionObject item=null;
			ResultSet rs=pre.executeQuery();
			if (rs!=null) {
				if (rs.next()) {
					item=new PositionObject();
					item.setPosition_id(rs.getInt("position_id"));
					item.setPosition_name(rs.getString("position_name"));
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
	public PositionObject searchPositionByName(String name) {
		String sql="SELECT*FROM position WHERE position_name=?";
		
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			pre.setString(1, name);
			PositionObject item=null;
			ResultSet rs=pre.executeQuery();
			
			if (rs!=null) {
				if(rs.next()) {
					item=new PositionObject();
					item.setPosition_id(rs.getInt("position_id"));
					item.setPosition_name(rs.getString("position_name"));
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
	public ArrayList<PositionObject> getPosition(PositionObject similar) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM Position";
		sql+=" ";
		sql+="ORDER BY Position_id DESC ";
		
		ArrayList<PositionObject> list =new ArrayList<>();
		PositionObject item=null;
		
		//Bien dich cau lenh
		try {
			PreparedStatement pre=this.con.prepareStatement(sql);
			
			// Lay tap ket qua
			ResultSet rs=pre.executeQuery();
			if (rs!=null) {
				while (rs.next()) {
					item=new PositionObject();
					item.setPosition_id(rs.getInt("position_id"));
					item.setPosition_name(rs.getString("position_name"));
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
		
		PositionFunction cf=new PositionFunctionImpl(cp);
		
		PositionObject co=new PositionObject();
		co.setPosition_id(73);
		co.setPosition_name("Lễ Tân");

		
		boolean results=cf.addPosition(co);
//		boolean results=cf.editPosition(co);
//		boolean results=cf.delPosition(co);
		if (!results) {
			System.out.println("---------------- KHÔNG THÀNH CÔNG -----------------");
		}
//		ArrayList<PositionObject> list=cf.getPosition(null);
//		list.forEach(u ->{
//			System.out.println(u);
//		});

	}
}
