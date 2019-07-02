
package client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para finishShift complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="finishShift">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="shiftId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="shiftDuration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "finishShift", propOrder = {
    "shiftId",
    "shiftDuration"
})
public class FinishShift {

    protected int shiftId;
    protected int shiftDuration;

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

    /**
     * Obtiene el valor de la propiedad shiftDuration.
     * 
     */
    public int getShiftDuration() {
        return shiftDuration;
    }

    /**
     * Define el valor de la propiedad shiftDuration.
     * 
     */
    public void setShiftDuration(int value) {
        this.shiftDuration = value;
    }

}
