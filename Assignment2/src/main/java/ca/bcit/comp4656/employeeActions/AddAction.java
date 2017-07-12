/**
 * @author Yashar Rahvar
 * Date: 10/Sep/2016
 * Project: SOAP Web Service Project 
 * Class: AddAction
 * This class is responsible for Adding employee. 
 */
package ca.bcit.comp4656.employeeActions;

import java.util.Date;
import ca.bcit.comp4656.PresentationUtility.DateConverter;
import ca.bcit.comp4656.PresentationUtility.PresentationUtil;
import ca.bcit.comp4656.employee.types.AddFault;
import ca.bcit.comp4656.employee.types.AddRequest;
import ca.bcit.comp4656.employee.types.AddResponse;
import ca.bcit.comp4656.employee.types.Employee;
import ca.bcit.comp4656.employee.types.ObjectFactory;
import ca.bcit.comp4656.employee.types.ResponseCode;
import ca.bcit.comp4656.employee.xml.AddError;
import ca.bcit.comp4656.jpa.data.EmployeeFacade;
import ca.bcit.comp4656.jpa.entity.EmployeeObj;
import ca.bcit.comp4656.validator.EmployeeIDValidator;

public class AddAction {
	private final static String ID_PATTERN = "[A][0][0-9]{7}";

	/**
	 * This method is responsible for adding addRequest.
	 * 
	 * @param addReq
	 *            sets AddRequest
	 * @return returns AddResponse
	 * @throws AddError
	 */
	public AddResponse add(AddRequest addReq) throws AddError {
		Employee employee = addReq.getAddEmployee();
		ObjectFactory objFactory = new ObjectFactory();
		ResponseCode responseCode = objFactory.createResponseCode();
		AddResponse addResponse = new AddResponse();
		AddFault addFault = new AddFault();

		// Checking for valid employee ID Format.
		if (!EmployeeIDValidator.isValidInput(employee.getId(), ID_PATTERN)) {
			addFault.setFaultInfo("Input: " + employee.getId());
			addFault.setMessage("Invalid ID Pattern");
			AddError error = new AddError(PresentationUtil.getString("error.find.employee.invalid.desc"), addFault);
			throw error;
		}
		if (employee.getId().trim() == null || employee.getId().trim().isEmpty()) {

			addFault.setFaultInfo("Input: " + employee.getId());
			addFault.setMessage("ID Can Not Be Empty");
			AddError error = new AddError("ID Can Not Be Empty", addFault);
			throw error;
		}

		if (employee.getFirstName().trim() == null || employee.getFirstName().trim().isEmpty()) {
			System.out.println("Inside empty stringsss first names////////////////////////////////////////////////");
			addFault.setFaultInfo("Input: " + employee.getFirstName());
			addFault.setMessage("First Name Can Not Be Empty");
			AddError error = new AddError("First Name Can Not Be Empty", addFault);
			throw error;
		}

		if (employee.getLastName().trim() == null || employee.getLastName().trim().isEmpty()) {
			addFault.setFaultInfo("Input: " + employee.getLastName());
			addFault.setMessage("Last Name Can Not Be Empty");
			AddError error = new AddError("Last Name Can Not Be Empty", addFault);
			throw error;
		}

		String dob = String.valueOf(employee.getDob());
		if (dob.trim() == null || dob.trim().isEmpty()) {
			addFault.setFaultInfo("Input: " + employee.getDob());
			addFault.setMessage("Date Of Birth Can Not Be Empty");
			AddError error = new AddError("Date Of Birth Can Not Be Empty", addFault);
			throw error;
		}

		EmployeeObj employeeObj = EmployeeFacade.getInstance().findEmployeeById(employee.getId());
		if (employeeObj != null) {
			responseCode.setDescription(PresentationUtil.getString("error.add.employee.duplicate.desc"));
			responseCode.setCode(PresentationUtil.getString("error.add.employee.invalid.code"));
			addResponse.setResponseCode(responseCode);
		}

		else {
			Date dobDate = DateConverter.toDate(employee.getDob());
			EmployeeFacade.getInstance().addEmployee(employee.getId(), employee.getFirstName(), employee.getLastName(),
					dobDate);
			responseCode.setDescription(PresentationUtil.getString("add.employee.success.desc"));
			responseCode.setCode(PresentationUtil.getString("add.employee.success.code"));
			addResponse.setResponseCode(responseCode);
		}
		return addResponse;

	}

}
