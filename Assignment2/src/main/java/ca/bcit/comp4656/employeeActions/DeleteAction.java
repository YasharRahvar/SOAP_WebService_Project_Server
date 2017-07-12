/**
 * @author Yashar Rahvar
 * Date: 10/Sep/2016
 * Project: SOAP Web Service Project 
 * Class: AddAction
 * This class is responsible for Delete employee. 
 */
package ca.bcit.comp4656.employeeActions;

import ca.bcit.comp4656.PresentationUtility.PresentationUtil;
import ca.bcit.comp4656.employee.types.DeleteFault;
import ca.bcit.comp4656.employee.types.DeleteRequest;
import ca.bcit.comp4656.employee.types.DeleteResponse;
import ca.bcit.comp4656.employee.types.ObjectFactory;
import ca.bcit.comp4656.employee.types.ResponseCode;
import ca.bcit.comp4656.employee.xml.DeleteError;
import ca.bcit.comp4656.jpa.data.EmployeeFacade;
import ca.bcit.comp4656.validator.EmployeeIDValidator;

public class DeleteAction {
	private final static String ID_PATTERN = "[A][0][0-9]{7}";

	/**
	 * This method is responsible for deleting employee object.
	 * 
	 * @param deleteReq
	 *            sets deleteReq
	 * @return returns DeleteResponse
	 * @throws DeleteError
	 */
	public DeleteResponse delete(DeleteRequest deleteReq) throws DeleteError {
		String employeeID = deleteReq.getDeleteEmployeeID();
		DeleteFault deleteFault = new DeleteFault();
		if (!EmployeeIDValidator.isValidInput(employeeID, ID_PATTERN)) {
			deleteFault.setFaultInfo("Input: " + employeeID);
			deleteFault.setMessage("Invalid ID Pattern");
			DeleteError error = new DeleteError(PresentationUtil.getString("error.find.employee.invalid.desc"),
					deleteFault);
			throw error;
		}
		ObjectFactory objFactory = new ObjectFactory();
		ResponseCode responseCode = objFactory.createResponseCode();
		DeleteResponse deleteResponse = new DeleteResponse();
		if (EmployeeFacade.getInstance().deleteEmployeeById(deleteReq.getDeleteEmployeeID())) {

			responseCode.setDescription(PresentationUtil.getString("remove.employee.success.desc"));
			responseCode.setCode(PresentationUtil.getString("remove.employee.success.code"));
		} else {
			responseCode.setDescription(PresentationUtil.getString("error.remove.employee.desc"));
			responseCode.setCode(PresentationUtil.getString("error.remove.employee.code"));
		}
		deleteResponse.setResponseCode(responseCode);
		return deleteResponse;
	}
}
