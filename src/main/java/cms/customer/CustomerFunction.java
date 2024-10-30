package cms.customer;

import java.util.ArrayList;

import objects.CustomerObject;

public interface CustomerFunction {
	public boolean addCustomer(CustomerObject item);
	public boolean editCustomer(CustomerObject item);
	public boolean delCustomer(CustomerObject item);
	
	public String getCountOfGender(CustomerObject item);
	public String getCountOfAgeGroup(CustomerObject item);
	
	public CustomerObject getCustomer(int id);
	public CustomerObject searchCustomerByName(String name);
	public ArrayList<CustomerObject> getCustomer(CustomerObject similar);
}
