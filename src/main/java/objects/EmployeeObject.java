package objects;

public class EmployeeObject {
	private int employee_id; 
	private String employee_username; 
	private String employee_password; 
	private String employee_full_name; 
	private String employee_email; 
	private String employee_phone_number; 
	private String employee_gender; 
	private String employee_position_id; 
	private String employee_created_at;
	
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_username() {
		return employee_username;
	}
	public void setEmployee_username(String employee_username) {
		this.employee_username = employee_username;
	}
	public String getEmployee_password() {
		return employee_password;
	}
	public void setEmployee_password(String employee_password) {
		this.employee_password = employee_password;
	}
	public String getEmployee_full_name() {
		return employee_full_name;
	}
	public void setEmployee_full_name(String employee_full_name) {
		this.employee_full_name = employee_full_name;
	}
	public String getEmployee_email() {
		return employee_email;
	}
	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}
	public String getEmployee_phone_number() {
		return employee_phone_number;
	}
	public void setEmployee_phone_number(String employee_phone_number) {
		this.employee_phone_number = employee_phone_number;
	}
	public String getEmployee_gender() {
		return employee_gender;
	}
	public void setEmployee_gender(String employee_gender) {
		this.employee_gender = employee_gender;
	}
	public String getEmployee_position_id() {
		return employee_position_id;
	}
	public void setEmployee_position_id(String employee_position_id) {
		this.employee_position_id = employee_position_id;
	}
	public String getEmployee_created_at() {
		return employee_created_at;
	}
	public void setEmployee_created_at(String employee_created_at) {
		this.employee_created_at = employee_created_at;
	}
	
	
	
	public EmployeeObject() {
	}
	
	public EmployeeObject(int employee_id, String employee_username, String employee_password,
			String employee_full_name, String employee_email, String employee_phone_number, String employee_gender,
			String employee_position_id, String employee_created_at) {
		super();
		this.employee_id = employee_id;
		this.employee_username = employee_username;
		this.employee_password = employee_password;
		this.employee_full_name = employee_full_name;
		this.employee_email = employee_email;
		this.employee_phone_number = employee_phone_number;
		this.employee_gender = employee_gender;
		this.employee_position_id = employee_position_id;
		this.employee_created_at = employee_created_at;
	}
	@Override
	public String toString() {
		return "EmployeeObject [employee_id=" + employee_id + ", employee_username=" + employee_username
				+ ", employee_password=" + employee_password + ", employee_full_name=" + employee_full_name
				+ ", employee_email=" + employee_email + ", employee_phone_number=" + employee_phone_number
				+ ", employee_gender=" + employee_gender + ", employee_position_id=" + employee_position_id
				+ ", employee_created_at=" + employee_created_at + "]";
	}
	
	
}
