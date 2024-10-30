package objects;

public class Room {

	private int roomID ;
	private int roomTypeID ;
	private long price;
	private String status; 
	private String image;
	private String reviews;
	private int floorRoom;
	private int numberOfBeds;
	private int maxOccupancy;
	private float area;
	private String amentities;
	private String numberPhoneExtension;
	private String bookingHistory;
	private int roomNumber;
	
	public Room() {
		
	}
	
	

	public Room(int roomID) {
		this.roomID = roomID;
	}



	public Room(int roomTypeID, long price, String status, String image, String reviews, int floorRoom,
			int numberOfBeds, int maxOccupancy, float area, String amentities, String numberPhoneExtension,
			String bookingHistory) {
		
		this.roomTypeID = roomTypeID;
		this.price = price;
		this.status = status;
		this.image = image;
		this.reviews = reviews;
		this.floorRoom = floorRoom;
		this.numberOfBeds = numberOfBeds;
		this.maxOccupancy = maxOccupancy;
		this.area = area;
		this.amentities = amentities;
		this.numberPhoneExtension = numberPhoneExtension;
		this.bookingHistory = bookingHistory;
	}



	public Room(int roomID, int roomTypeID, long price, String status, String image, String reviews, int floorRoom,
			int numberOfBeds, int maxOccupancy, float area, String amentities, String numberPhoneExtension,
			String bookingHistory) {
		super();
		this.roomID = roomID;
		this.roomTypeID = roomTypeID;
		this.price = price;
		this.status = status;
		this.image = image;
		this.reviews = reviews;
		this.floorRoom = floorRoom;
		this.numberOfBeds = numberOfBeds;
		this.maxOccupancy = maxOccupancy;
		this.area = area;
		this.amentities = amentities;
		this.numberPhoneExtension = numberPhoneExtension;
		this.bookingHistory = bookingHistory;
	}



	public int getRoomNumber() {
		return roomNumber;
	}



	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}



	public int getRoomID() {
		return roomID;
	}



	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}



	public int getRoomTypeID() {
		return roomTypeID;
	}



	public void setRoomTypeID(int roomTypeID) {
		this.roomTypeID = roomTypeID;
	}



	public long getPrice() {
		return price;
	}



	public void setPrice(long price) {
		this.price = price;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getReviews() {
		return reviews;
	}



	public void setReviews(String reviews) {
		this.reviews = reviews;
	}



	public int getFloorRoom() {
		return floorRoom;
	}



	public void setFloorRoom(int floorRoom) {
		this.floorRoom = floorRoom;
	}



	public int getNumberOfBeds() {
		return numberOfBeds;
	}



	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}



	public int getMaxOccupancy() {
		return maxOccupancy;
	}



	public void setMaxOccupancy(int maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}



	public float getArea() {
		return area;
	}



	public void setArea(float area) {
		this.area = area;
	}



	public String getAmentities() {
		return amentities;
	}



	public void setAmentities(String amentities) {
		this.amentities = amentities;
	}



	public String getNumberPhoneExtension() {
		return numberPhoneExtension;
	}



	public void setNumberPhoneExtension(String numberPhoneExtension) {
		this.numberPhoneExtension = numberPhoneExtension;
	}



	public String getBookingHistory() {
		return bookingHistory;
	}



	public void setBookingHistory(String bookingHistory) {
		this.bookingHistory = bookingHistory;
	}



	@Override
	public String toString() {
		return "Room [roomID=" + roomID + ", roomTypeID=" + roomTypeID + ", price=" + price + ", status=" + status
				+ ", image=" + image + ", reviews=" + reviews + ", floorRoom=" + floorRoom + ", numberOfBeds="
				+ numberOfBeds + ", maxOccupancy=" + maxOccupancy + ", area=" + area + ", amentities=" + amentities
				+ ", numberPhoneExtension=" + numberPhoneExtension + ", bookingHistory=" + bookingHistory + "]";
	}
}
