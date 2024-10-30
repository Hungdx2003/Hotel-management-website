package cms.employee;

import java.util.ArrayList;
import objects.EmployeeObject;

public interface EmployeeFunction {
	public boolean addEmployee(EmployeeObject item);
	public boolean editEmployee(EmployeeObject item);
	public boolean delEmployee(EmployeeObject item);
	public String getPositionNameByID(int id);
	
	public EmployeeObject checkLogin(String username, String password);
	public EmployeeObject getEmployee(int id);
	public EmployeeObject searchEmployeeByName(String name);
	public ArrayList<EmployeeObject> getEmployee(EmployeeObject similar);
	
	
	
	
	
}
