package objects;

public class Invoice {
	private int invoice_id; 
	private int booking_id; 
	private String pay_date; 
	private int amount; 
	private String status;
	private String customer_fullname;
	private String customer_mobilephone;
	private String check_in_date;
	private String check_out_date;
	private int RoomNumber;
	private String RoomType;
	private String service_name;
	private int quantity;
	private int total;
	private int room_price;
	private int service_price;
	
	public Invoice() {
	}

	public Invoice(int invoice_id, int booking_id, String pay_date, int amount, String status) {
		this.invoice_id = invoice_id;
		this.booking_id = booking_id;
		this.pay_date = pay_date;
		this.amount = amount;
		this.status = status;
	}
	
	public int getRoom_price() {
		return room_price;
	}

	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}

	public int getService_price() {
		return service_price;
	}

	public void setService_price(int service_price) {
		this.service_price = service_price;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRoomNumber() {
		return RoomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		RoomNumber = roomNumber;
	}

	public String getRoomType() {
		return RoomType;
	}

	public void setRoomType(String roomType) {
		RoomType = roomType;
	}

	public String getCustomer_mobilephone() {
		return customer_mobilephone;
	}

	public void setCustomer_mobilephone(String customer_mobilephone) {
		this.customer_mobilephone = customer_mobilephone;
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

	public String getCustomer_fullname() {
		return customer_fullname;
	}

	public void setCustomer_fullname(String customer_fullname) {
		this.customer_fullname = customer_fullname;
	}

	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getPay_date() {
		return pay_date;
	}

	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Invoice [invoice_id=" + invoice_id + ", booking_id=" + booking_id + ", pay_date=" + pay_date
				+ ", amount=" + amount + ", status=" + status + "]";
	}
	
}
