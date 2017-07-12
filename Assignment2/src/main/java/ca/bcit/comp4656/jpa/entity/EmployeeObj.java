/**
 * @author Yashar Rahvar
 * Date: 10/Sep/2016
 * Project: SOAP Web Service Project 
 * Class: EmployeeObj
 * This is employee entity class. 
 */

package ca.bcit.comp4656.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "EmployeeObj.findById", query = "select p from EmployeeObj p where p.id= :id"),
		@NamedQuery(name = "EmployeeObj.deleteById", query = "delete from EmployeeObj where id= :id"),
		@NamedQuery(name = "EmployeeObj.getAllEmployee", query = "select e from EmployeeObj e") })
@Table(name = "employee")
public class EmployeeObj {

	@Id
	private String id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private Date dob;

	/**
	 * 
	 * @return returns id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            sets id.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return returns firstName.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @param firstName
	 *            sets firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return returns lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @param lastName
	 *            sets lastName.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return returns dob.
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * 
	 * @param dob
	 *            sets dob
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * toString method for employee Object.
	 */
	@Override
	public String toString() {
		return "EmployeeObj [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + "]";
	}

}
