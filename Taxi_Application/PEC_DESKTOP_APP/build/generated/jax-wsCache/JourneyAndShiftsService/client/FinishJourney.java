
package client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para finishJourney complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="finishJourney">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="JourneyId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="JourneyFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="JourneyTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "finishJourney", propOrder = {
    "journeyId",
    "journeyFrom",
    "journeyTo"
})
public class FinishJourney {

    @XmlElement(name = "JourneyId")
    protected int journeyId;
    @XmlElement(name = "JourneyFrom")
    protected String journeyFrom;
    @XmlElement(name = "JourneyTo")
    protected String journeyTo;

    /**
     * Obtiene el valor de la propiedad journeyId.
     * 
     */
    public int getJourneyId() {
        return journeyId;
    }

    /**
     * Define el valor de la propiedad journeyId.
     * 
     */
    public void setJourneyId(int value) {
        this.journeyId = value;
    }

    /**
     * Obtiene el valor de la propiedad journeyFrom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJourneyFrom() {
        return journeyFrom;
    }

    /**
     * Define el valor de la propiedad journeyFrom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJourneyFrom(String value) {
        this.journeyFrom = value;
    }

    /**
     * Obtiene el valor de la propiedad journeyTo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJourneyTo() {
        return journeyTo;
    }

    /**
     * Define el valor de la propiedad journeyTo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJourneyTo(String value) {
        this.journeyTo = value;
    }

}
