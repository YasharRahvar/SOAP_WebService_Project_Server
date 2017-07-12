
package ca.bcit.comp4656.employee.types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getEmployeesReq" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getEmployeesReq"
})
@XmlRootElement(name = "getEmployeesRequest")
public class GetEmployeesRequest {

    @XmlElement(required = true)
    protected Object getEmployeesReq;

    /**
     * Gets the value of the getEmployeesReq property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getGetEmployeesReq() {
        return getEmployeesReq;
    }

    /**
     * Sets the value of the getEmployeesReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setGetEmployeesReq(Object value) {
        this.getEmployeesReq = value;
    }

}
