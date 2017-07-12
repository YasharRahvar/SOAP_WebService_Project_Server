package ca.bcit.comp4656.jaxws.services;

import javax.jws.WebService;
import ca.bcit.comp4656.employee.types.AddRequest;
import ca.bcit.comp4656.employee.types.AddResponse;
import ca.bcit.comp4656.employee.types.DeleteRequest;
import ca.bcit.comp4656.employee.types.DeleteResponse;
import ca.bcit.comp4656.employee.types.FindRequest;
import ca.bcit.comp4656.employee.types.FindResponse;
import ca.bcit.comp4656.employee.types.GetEmployeesRequest;
import ca.bcit.comp4656.employee.types.GetEmployeesResponse;
import ca.bcit.comp4656.employee.xml.AddError;
import ca.bcit.comp4656.employee.xml.DeleteError;
import ca.bcit.comp4656.employee.xml.EmployeeServicePort;
import ca.bcit.comp4656.employee.xml.FindError;
import ca.bcit.comp4656.employee.xml.GetEmployeesError;
import ca.bcit.comp4656.employeeActions.FindAction;
import ca.bcit.comp4656.employeeActions.AddAction;
import ca.bcit.comp4656.employeeActions.DeleteAction;
import ca.bcit.comp4656.employeeActions.GetEmployeesAction;

@WebService(endpointInterface = "ca.bcit.comp4656.employee.xml.EmployeeServicePort")
public class BasicEmployeeService implements EmployeeServicePort {

	@Override
	public FindResponse find(FindRequest findReq) throws FindError {
		FindAction findAction = new FindAction();
		FindResponse response = findAction.find(findReq);
		return response;
	}

	@Override
	public DeleteResponse delete(DeleteRequest deleteReq) throws DeleteError {
		DeleteAction deleteAction = new DeleteAction();
		DeleteResponse response = deleteAction.delete(deleteReq);
		return response;

	}

	@Override
	public GetEmployeesResponse getEmployees(GetEmployeesRequest getEmployeesReq) throws GetEmployeesError {
		GetEmployeesAction getEmployeeAction = new GetEmployeesAction();
		GetEmployeesResponse getEmployeeResponse = getEmployeeAction.getEmployees(getEmployeesReq);
		return getEmployeeResponse;
	}

	@Override
	public AddResponse add(AddRequest addReq) throws AddError {
		AddAction addAction = new AddAction();
		AddResponse addResponse = addAction.add(addReq);
		return addResponse;
	}

}
