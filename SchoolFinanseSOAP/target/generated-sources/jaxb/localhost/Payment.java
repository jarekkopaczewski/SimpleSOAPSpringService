//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.04.28 at 10:05:18 AM CEST 
//


package localhost;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for payment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="payment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="instalmentNumber" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="payday" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="payed" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="paymentAmount" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="paymentDeadline" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paymentEvent" type="{localhost}event" minOccurs="0"/&gt;
 *         &lt;element name="paymentId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="paymentPerson" type="{localhost}person" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payment", propOrder = {
    "instalmentNumber",
    "payday",
    "payed",
    "paymentAmount",
    "paymentDeadline",
    "paymentEvent",
    "paymentId",
    "paymentPerson"
})
public class Payment {

    protected long instalmentNumber;
    protected String payday;
    protected boolean payed;
    protected long paymentAmount;
    protected String paymentDeadline;
    protected Event paymentEvent;
    protected int paymentId;
    protected Person paymentPerson;

    /**
     * Gets the value of the instalmentNumber property.
     * 
     */
    public long getInstalmentNumber() {
        return instalmentNumber;
    }

    /**
     * Sets the value of the instalmentNumber property.
     * 
     */
    public void setInstalmentNumber(long value) {
        this.instalmentNumber = value;
    }

    /**
     * Gets the value of the payday property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayday() {
        return payday;
    }

    /**
     * Sets the value of the payday property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayday(String value) {
        this.payday = value;
    }

    /**
     * Gets the value of the payed property.
     * 
     */
    public boolean isPayed() {
        return payed;
    }

    /**
     * Sets the value of the payed property.
     * 
     */
    public void setPayed(boolean value) {
        this.payed = value;
    }

    /**
     * Gets the value of the paymentAmount property.
     * 
     */
    public long getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * Sets the value of the paymentAmount property.
     * 
     */
    public void setPaymentAmount(long value) {
        this.paymentAmount = value;
    }

    /**
     * Gets the value of the paymentDeadline property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentDeadline() {
        return paymentDeadline;
    }

    /**
     * Sets the value of the paymentDeadline property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentDeadline(String value) {
        this.paymentDeadline = value;
    }

    /**
     * Gets the value of the paymentEvent property.
     * 
     * @return
     *     possible object is
     *     {@link Event }
     *     
     */
    public Event getPaymentEvent() {
        return paymentEvent;
    }

    /**
     * Sets the value of the paymentEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Event }
     *     
     */
    public void setPaymentEvent(Event value) {
        this.paymentEvent = value;
    }

    /**
     * Gets the value of the paymentId property.
     * 
     */
    public int getPaymentId() {
        return paymentId;
    }

    /**
     * Sets the value of the paymentId property.
     * 
     */
    public void setPaymentId(int value) {
        this.paymentId = value;
    }

    /**
     * Gets the value of the paymentPerson property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    public Person getPaymentPerson() {
        return paymentPerson;
    }

    /**
     * Sets the value of the paymentPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    public void setPaymentPerson(Person value) {
        this.paymentPerson = value;
    }

}