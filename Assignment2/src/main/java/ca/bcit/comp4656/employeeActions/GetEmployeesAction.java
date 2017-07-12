/**
 * @author Yashar Rahvar
 * Date: 10/Sep/2016
 * Project: SOAP Web Service Project 
 * Class: GetEmployeesAction
 * This class is responsible for getting all employees. 
 */
package ca.bcit.comp4656.employeeActions;

import java.util.ArrayList;
import java.util.List;

import ca.bcit.comp4656.PresentationUtility.DateConverter;
import ca.bcit.comp4656.employee.types.Employee;
import ca.bcit.comp4656.employee.types.GetEmployeesRequest;
import ca.bcit.comp4656.employee.types.GetEmployeesResponse;
import ca.bcit.comp4656.jpa.data.EmployeeFacade;
import ca.bcit.comp4656.jpa.entity.EmployeeObj;

public class GetEmployeesAction {
	/**
	 * This method is responsible for getting all employees.
	 * 
	 * @param getEmployeesReq
	 *            sets GetEmployeesRequest
	 * @return returns GetEmployeesResponse
	 */
	public GetEmployeesResponse getEmployees(GetEmployeesRequest getEmployeesReq) {
		GetEmployeesResponse getEmployeeResponse = new GetEmployeesResponse();
		List<EmployeeObj> employeesObj = EmployeeFacade.getInstance().getPeople();
		List<Employee> employees = new ArrayList<Employee>();

		for (EmployeeObj employee : employeesObj) {
			Employee newEmployee = new Employee();
			newEmployee.setFirstName(employee.getFirstName());
			newEmployee.setLastName(employee.getLastName());
			newEmployee.setId(employee.getId());
			newEmployee.setDob(DateConverter.toXMLGregorianCalendar(employee.getDob()));
			employees.add(newEmployee);
			getEmployeeResponse.getGetEmployees().add(newEmployee);
		}
		return getEmployeeResponse;
	}
}
