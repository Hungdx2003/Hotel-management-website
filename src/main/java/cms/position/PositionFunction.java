package cms.position;

import java.util.ArrayList;

import objects.PositionObject;

public interface PositionFunction {
	public boolean addPosition(PositionObject item);
	public boolean editPosition(PositionObject item);
	public boolean delPosition(PositionObject item);
	
	public PositionObject getPosition(int id);
	public PositionObject searchPositionByName(String name);
	public ArrayList<PositionObject> getPosition(PositionObject similar);
}
