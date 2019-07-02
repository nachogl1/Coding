
package client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para temporalWSObject complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="temporalWSObject">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lock" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "temporalWSObject", propOrder = {
    "lock",
    "userId"
})
public class TemporalWSObject {

    protected boolean lock;
    protected int userId;

    /**
     * Obtiene el valor de la propiedad lock.
     * 
     */
    public boolean isLock() {
        return lock;
    }

    /**
     * Define el valor de la propiedad lock.
     * 
     */
    public void setLock(boolean value) {
        this.lock = value;
    }

    /**
     * Obtiene el valor de la propiedad userId.
     * 
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Define el valor de la propiedad userId.
     * 
     */
    public void setUserId(int value) {
        this.userId = value;
    }

}
