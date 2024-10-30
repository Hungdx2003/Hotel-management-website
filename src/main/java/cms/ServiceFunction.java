package cms;

import java.util.ArrayList;

import objects.ServiceObject;

public interface ServiceFunction {
	public boolean addService(ServiceObject item);
	public boolean editService(ServiceObject item);
	public boolean delService(ServiceObject item);
	
	public ServiceObject getService(int id);
	public ArrayList<ServiceObject> getAllService(ServiceObject similar);
}
