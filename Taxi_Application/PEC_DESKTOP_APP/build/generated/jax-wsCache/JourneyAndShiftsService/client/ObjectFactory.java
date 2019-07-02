
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateJourneyResponse_QNAME = new QName("http://webServices/", "createJourneyResponse");
    private final static QName _CreateShiftResponse_QNAME = new QName("http://webServices/", "createShiftResponse");
    private final static QName _Login_QNAME = new QName("http://webServices/", "login");
    private final static QName _CreateJourney_QNAME = new QName("http://webServices/", "createJourney");
    private final static QName _FinishShiftResponse_QNAME = new QName("http://webServices/", "finishShiftResponse");
    private final static QName _FinishJourney_QNAME = new QName("http://webServices/", "finishJourney");
    private final static QName _FinishShift_QNAME = new QName("http://webServices/", "finishShift");
    private final static QName _CreateShift_QNAME = new QName("http://webServices/", "createShift");
    private final static QName _LoginResponse_QNAME = new QName("http://webServices/", "loginResponse");
    private final static QName _FinishJourneyResponse_QNAME = new QName("http://webServices/", "finishJourneyResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateShift }
     * 
     */
    public CreateShift createCreateShift() {
        return new CreateShift();
    }

    /**
     * Create an instance of {@link FinishJourneyResponse }
     * 
     */
    public FinishJourneyResponse createFinishJourneyResponse() {
        return new FinishJourneyResponse();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link FinishJourney }
     * 
     */
    public FinishJourney createFinishJourney() {
        return new FinishJourney();
    }

    /**
     * Create an instance of {@link FinishShift }
     * 
     */
    public FinishShift createFinishShift() {
        return new FinishShift();
    }

    /**
     * Create an instance of {@link CreateJourneyResponse }
     * 
     */
    public CreateJourneyResponse createCreateJourneyResponse() {
        return new CreateJourneyResponse();
    }

    /**
     * Create an instance of {@link CreateShiftResponse }
     * 
     */
    public CreateShiftResponse createCreateShiftResponse() {
        return new CreateShiftResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link CreateJourney }
     * 
     */
    public CreateJourney createCreateJourney() {
        return new CreateJourney();
    }

    /**
     * Create an instance of {@link FinishShiftResponse }
     * 
     */
    public FinishShiftResponse createFinishShiftResponse() {
        return new FinishShiftResponse();
    }

    /**
     * Create an instance of {@link TemporalWSObject }
     * 
     */
    public TemporalWSObject createTemporalWSObject() {
        return new TemporalWSObject();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateJourneyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "createJourneyResponse")
    public JAXBElement<CreateJourneyResponse> createCreateJourneyResponse(CreateJourneyResponse value) {
        return new JAXBElement<CreateJourneyResponse>(_CreateJourneyResponse_QNAME, CreateJourneyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateShiftResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "createShiftResponse")
    public JAXBElement<CreateShiftResponse> createCreateShiftResponse(CreateShiftResponse value) {
        return new JAXBElement<CreateShiftResponse>(_CreateShiftResponse_QNAME, CreateShiftResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateJourney }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "createJourney")
    public JAXBElement<CreateJourney> createCreateJourney(CreateJourney value) {
        return new JAXBElement<CreateJourney>(_CreateJourney_QNAME, CreateJourney.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FinishShiftResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "finishShiftResponse")
    public JAXBElement<FinishShiftResponse> createFinishShiftResponse(FinishShiftResponse value) {
        return new JAXBElement<FinishShiftResponse>(_FinishShiftResponse_QNAME, FinishShiftResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FinishJourney }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "finishJourney")
    public JAXBElement<FinishJourney> createFinishJourney(FinishJourney value) {
        return new JAXBElement<FinishJourney>(_FinishJourney_QNAME, FinishJourney.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FinishShift }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "finishShift")
    public JAXBElement<FinishShift> createFinishShift(FinishShift value) {
        return new JAXBElement<FinishShift>(_FinishShift_QNAME, FinishShift.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateShift }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "createShift")
    public JAXBElement<CreateShift> createCreateShift(CreateShift value) {
        return new JAXBElement<CreateShift>(_CreateShift_QNAME, CreateShift.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FinishJourneyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webServices/", name = "finishJourneyResponse")
    public JAXBElement<FinishJourneyResponse> createFinishJourneyResponse(FinishJourneyResponse value) {
        return new JAXBElement<FinishJourneyResponse>(_FinishJourneyResponse_QNAME, FinishJourneyResponse.class, null, value);
    }

}
