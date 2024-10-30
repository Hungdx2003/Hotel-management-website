package objects;

public class ServiceObject {
	private int service_id; 
	private String service_name; 
	private String description; 
	private int price; 
	
	public ServiceObject() {
	}

	public ServiceObject(int service_id, String service_name, String description, int price) {
		this.service_id = service_id;
		this.service_name = service_name;
		this.description = description;
		this.price = price;
	}

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ServiceObject [service_id=" + service_id + ", service_name=" + service_name + ", description="
				+ description + ", price=" + price + "]";
	}
	
	
}
