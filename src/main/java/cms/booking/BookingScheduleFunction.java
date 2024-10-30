package cms.booking;

import java.util.ArrayList;

import objects.BookingSchedule;


public interface BookingScheduleFunction {
	public boolean addSchedule(BookingSchedule item);
	public boolean editSchedule(BookingSchedule item);
	
	public BookingSchedule getSchedule(int id);
	public ArrayList<BookingSchedule> getAllSchedule(BookingSchedule similar);
}
