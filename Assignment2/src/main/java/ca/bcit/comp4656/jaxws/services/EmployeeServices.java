package ca.bcit.comp4656.jaxws.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

import ca.bcit.comp4656.jpa.entity.EmployeeObj;

// Implement this interface.
@WebService
public interface EmployeeServices {
	@WebMethod
	public EmployeeObj findEmployeeById(String id);

	@WebMethod
	public EmployeeObj deleteEmplyoeeById(String id);

	@WebMethod
	public void getEmplyoees();

	@WebMethod
	public void addEmployee();
}
