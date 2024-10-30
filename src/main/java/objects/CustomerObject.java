package objects;

public class CustomerObject {
	private int customer_id; 
	private String customer_name; 
	private String customer_pass; 
	private String customer_fullname; 
	private String customer_birthday; 
	private String customer_mobilephone; 
	private String customer_email; 
	private String customer_gender; 
	private String customer_nationality; 
	private String customer_ID_number; 
	private String customer_address; 
	
	public CustomerObject() {
	}

	public CustomerObject(int customer_id, String customer_name, String customer_pass, String customer_fullname,
			String customer_birthday, String customer_mobilephone, String customer_email, String customer_gender,
			String customer_nationality, String customer_ID_number, String customer_address) {
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_pass = customer_pass;
		this.customer_fullname = customer_fullname;
		this.customer_birthday = customer_birthday;
		this.customer_mobilephone = customer_mobilephone;
		this.customer_email = customer_email;
		this.customer_gender = customer_gender;
		this.customer_nationality = customer_nationality;
		this.customer_ID_number = customer_ID_number;
		this.customer_address = customer_address;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_pass() {
		return customer_pass;
	}

	public void setCustomer_pass(String customer_pass) {
		this.customer_pass = customer_pass;
	}

	public String getCustomer_fullname() {
		return customer_fullname;
	}

	public void setCustomer_fullname(String customer_fullname) {
		this.customer_fullname = customer_fullname;
	}

	public String getCustomer_birthday() {
		return customer_birthday;
	}

	public void setCustomer_birthday(String customer_birthday) {
		this.customer_birthday = customer_birthday;
	}

	public String getCustomer_mobilephone() {
		return customer_mobilephone;
	}

	public void setCustomer_mobilephone(String customer_mobilephone) {
		this.customer_mobilephone = customer_mobilephone;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_gender() {
		return customer_gender;
	}

	public void setCustomer_gender(String customer_gender) {
		this.customer_gender = customer_gender;
	}

	public String getCustomer_nationality() {
		return customer_nationality;
	}

	public void setCustomer_nationality(String customer_nationality) {
		this.customer_nationality = customer_nationality;
	}

	public String getCustomer_ID_number() {
		return customer_ID_number;
	}

	public void setCustomer_ID_number(String customer_ID_number) {
		this.customer_ID_number = customer_ID_number;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}


	@Override
	public String toString() {
		return "CustomerObject [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_pass="
				+ customer_pass + ", customer_fullname=" + customer_fullname + ", customer_birthday="
				+ customer_birthday + ", customer_mobilephone=" + customer_mobilephone + ", customer_email="
				+ customer_email + ", customer_gender=" + customer_gender + ", customer_nationality="
				+ customer_nationality + ", customer_ID_number=" + customer_ID_number + ", customer_address="
				+ customer_address  + "]";
	}
	
	
}
