
package client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para createJourney complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="createJourney">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="shiftId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createJourney", propOrder = {
    "shiftId"
})
public class CreateJourney {

    protected int shiftId;

    /**
     * Obtiene el valor de la propiedad shiftId.
     * 
     */
    public int getShiftId() {
        return shiftId;
    }

    /**
     * Define el valor de la propiedad shiftId.
     * 
     */
    public void setShiftId(int value) {
        this.shiftId = value;
    }

}
