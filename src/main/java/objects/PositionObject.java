package objects;

public class PositionObject {
	private int position_id;
	private String position_name;
	
	
	
	public PositionObject() {
	
	}
	
	public PositionObject(int position_id, String position_name) {
		super();
		this.position_id = position_id;
		this.position_name = position_name;
	}


	public int getPosition_id() {
		return position_id;
	}
	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

	@Override
	public String toString() {
		return "PositionObject [position_id=" + position_id + ", position_name=" + position_name + "]";
	}
		
	
}
