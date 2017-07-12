/**
 * @author Yashar Rahvar
 * Date: 10/Sep/2016
 * Project: SOAP Web Service Project 
 * Class: FindAction
 * This class is responsible for Finding employee. 
 */
package ca.bcit.comp4656.employeeActions;

import ca.bcit.comp4656.PresentationUtility.PresentationUtil;
import ca.bcit.comp4656.employee.types.Employee;
import ca.bcit.comp4656.employee.types.FindEmployeeFault;
import ca.bcit.comp4656.employee.types.FindRequest;
import ca.bcit.comp4656.employee.types.FindResponse;
import ca.bcit.comp4656.employee.types.ObjectFactory;
import ca.bcit.comp4656.employee.types.ResponseCode;
import ca.bcit.comp4656.employee.xml.FindError;
import ca.bcit.comp4656.jpa.data.EmployeeFacade;
import ca.bcit.comp4656.jpa.entity.EmployeeObj;
import ca.bcit.comp4656.validator.EmployeeIDValidator;

public class FindAction {
	private final static String ID_PATTERN = "[A][0][0-9]{7}";

	/**
	 * This method is responsible for finding employee.
	 * 
	 * @param findReq
	 *            sets FindRequest
	 * @return returns FindRequest
	 * @throws FindError
	 */
	public FindResponse find(FindRequest findReq) throws FindError {
		FindResponse response = new FindResponse();
		ObjectFactory objFactory = new ObjectFactory();
		ResponseCode responseCode = objFactory.createResponseCode();
		String employeeID = findReq.getFindEmployeeID();
		FindEmployeeFault findPersonFault = new FindEmployeeFault();
		if (!EmployeeIDValidator.isValidInput(employeeID, ID_PATTERN)) {
			findPersonFault.setFaultInfo("Input: " + employeeID);
			findPersonFault.setMessage("Invalid ID");
			FindError error = new FindError(PresentationUtil.getString("error.find.employee.invalid.desc"),
					findPersonFault);
			throw error;
		}

		EmployeeObj employeeObj = EmployeeFacade.getInstance().findEmployeeById(findReq.getFindEmployeeID());

		if (employeeObj == null) {
			Employee employee = objFactory.createEmployee();
			responseCode.setDescription(PresentationUtil.getString("error.find.employee.desc"));
			responseCode.setCode(PresentationUtil.getString("error.find.employee.code"));
			response.setResult(employee);
			response.setResponseCode(responseCode);
		} else {
			Employee employee = objFactory.createEmployee();
			employee.setFirstName(employeeObj.getFirstName());
			employee.setLastName(employeeObj.getLastName());
			employee.setId(employeeObj.getId());
			responseCode.setDescription(PresentationUtil.getString("find.employee.success.desc"));
			responseCode.setCode(PresentationUtil.getString("find.employee.success.code"));
			response.setResult(employee);
			response.setResponseCode(responseCode);
		}
		return response;
	}
}
