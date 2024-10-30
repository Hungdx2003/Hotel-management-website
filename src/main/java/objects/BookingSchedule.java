package objects;

public class BookingSchedule {
	private int booking_id;
	private int customer_id; 
	private int RoomID; 
	private String customer_fullname;
	private int RoomNumber;
	private String check_in_date; 
	private String check_out_date; 
	private String status;
	private String room_type_name;
	private String service_name;
	private int quanity;
	
	public BookingSchedule() {
	}

	public BookingSchedule(int booking_id, int customer_id, int roomID, String check_in_date, String check_out_date,
			String status) {
		super();
		this.booking_id = booking_id;
		this.customer_id = customer_id;
		RoomID = roomID;
		this.check_in_date = check_in_date;
		this.check_out_date = check_out_date;
		this.status = status;
	}
	
	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public String getRoom_type_name() {
		return room_type_name;
	}

	public void setRoom_type_name(String room_type_name) {
		this.room_type_name = room_type_name;
	}

	public String getCustomer_fullname() {
		return customer_fullname;
	}

	public void setCustomer_fullname(String customer_fullname) {
		this.customer_fullname = customer_fullname;
	}

	public int getRoomNumber() {
		return RoomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		RoomNumber = roomNumber;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getRoomID() {
		return RoomID;
	}

	public void setRoomID(int roomID) {
		RoomID = roomID;
	}

	public String getCheck_in_date() {
		return check_in_date;
	}

	public void setCheck_in_date(String check_in_date) {
		this.check_in_date = check_in_date;
	}

	public String getCheck_out_date() {
		return check_out_date;
	}

	public void setCheck_out_date(String check_out_date) {
		this.check_out_date = check_out_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BookingSchedule [booking_id=" + booking_id + ", customer_id=" + customer_id + ", RoomID=" + RoomID
				+ ", check_in_date=" + check_in_date + ", check_out_date=" + check_out_date + ", status=" + status
				+ "]";
	}
	
	
}
