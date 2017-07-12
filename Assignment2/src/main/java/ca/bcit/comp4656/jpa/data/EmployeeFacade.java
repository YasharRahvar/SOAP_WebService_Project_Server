/**
 * @author Yashar Rahvar
 * Date: 10/Sep/2016
 * Project: SOAP Web Service Project 
 * Class: EmployeeFacade
 * This class is responsible doing all CRUD operations(none-JTA). 
 */

package ca.bcit.comp4656.jpa.data;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import ca.bcit.comp4656.jpa.entity.EmployeeObj;

public class EmployeeFacade {

	private EntityManagerFactory entityManagerFactory = null;
	private EntityManager entityManager = null;
	private static EmployeeFacade personFacade = null;

	/**
	 * 
	 * @return returning employeFacade instance
	 */
	public static synchronized EmployeeFacade getInstance() {
		if (personFacade != null) {
			return personFacade;
		} else
			return new EmployeeFacade();
	}

	/**
	 * EmployeeFacade constructor.
	 */
	private EmployeeFacade() {
		entityManagerFactory = Persistence.createEntityManagerFactory("PersonPU");
		entityManager = entityManagerFactory.createEntityManager();
	}

	/**
	 * EmployeeFacade constructor.
	 * 
	 * @param entityManager
	 */
	public EmployeeFacade(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * 
	 * @return returning all employees.
	 */
	public List<EmployeeObj> getPeople() {
		return entityManager.createNamedQuery("EmployeeObj.getAllEmployee", EmployeeObj.class).getResultList();
	}

	/**
	 * 
	 * @param employeeID
	 *            sets employeeID
	 * @return returns employee object.
	 */
	public EmployeeObj findEmployeeById(String employeeID) {
		try {
			return entityManager.createNamedQuery("EmployeeObj.findById", EmployeeObj.class)
					.setParameter("id", employeeID).getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * Delete Employee
	 * 
	 * @param employeeID
	 *            sets employee ID.
	 * @return returns boolean
	 */
	public boolean deleteEmployeeById(String employeeID) {
		boolean checkForDelete = false;
		EmployeeObj employee = findEmployeeById(employeeID);
		if (employee == null) {
			checkForDelete = false;
		} else {
			entityManager.getTransaction().begin();
			entityManager.remove(findEmployeeById(employeeID));
			entityManager.getTransaction().commit();
			checkForDelete = true;
		}
		return checkForDelete;
	}

	/**
	 * Adding employee
	 * 
	 * @param ID
	 *            sets employee id.
	 * @param firstName
	 *            sets employee firstName.
	 * @param lastName
	 *            sets employee lastName.
	 * @param dob
	 *            sets employee dob.
	 */
	public void addEmployee(String ID, String firstName, String lastName, Date dob) {
		EmployeeObj employee = new EmployeeObj();
		employee.setId(ID);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setDob(dob);
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}

	/**
	 * Closing entity Manager
	 */
	public void closeEntityManager() {
		if (entityManager.isOpen()) {
			entityManager.close();
		}
	}
}
