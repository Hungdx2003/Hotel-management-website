package cms.room;

import java.util.ArrayList;

import objects.Room;

public interface RoomFunction {
	public int addItem(Room room);
	
	public int editItem(Room room);

	public int delItem(Room room);
	
	public ArrayList<Room> displayAllItem();
	
	public Room selectById(int id);
}
