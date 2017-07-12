/**
 * @author Yashar Rahvar
 * Date: 10/Sep/2016
 * Project: SOAP Web Service Project 
 * Class: ResponseCode
 * This is a pojo class for responseCode object. 
 */

package ca.bcit.comp4656.jpa.entity;

public class ResponseCode {
	protected String code;
	protected String desc;

	/**
	 * 
	 * @return returns code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @param value
	 *            sets code
	 */
	public void setCode(String value) {
		this.code = value;
	}

	/**
	 * 
	 * @return returns description
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * 
	 * @param value
	 *            sets value
	 */
	public void setDesc(String value) {
		this.desc = value;
	}

	/**
	 * this is toString method for responseCode object.
	 */
	@Override
	public String toString() {
		return "ResponseCode [code=" + code + ", desc=" + desc + "]";
	}
}
