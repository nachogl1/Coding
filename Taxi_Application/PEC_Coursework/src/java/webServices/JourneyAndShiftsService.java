package webServices;

import java.time.LocalDateTime;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Controller;
import static model.Controller.currentDriver;
import static model.Controller.session;
import model.Driver;
import model.Journey;
import model.Shift;
import model.TemporalWSObject;
import org.hibernate.Query;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
@WebService(serviceName = "JourneyAndShiftsService")
public class JourneyAndShiftsService {

    @WebMethod(operationName = "login")
    public TemporalWSObject login(@WebParam(name = "username") String username,
            @WebParam(name = "password") String password) {

        session.beginTransaction();
        Query queryResult = session.createQuery(" FROM Driver");
        List<Driver> usernames = queryResult.list();
        session.getTransaction().commit();

        TemporalWSObject t = new TemporalWSObject(false, -1);

        if (!usernames.isEmpty()) {
            int i;
            for (i = 0; i < usernames.size(); i++) {
                if (usernames.get(i).getUserName().equals(username) && usernames.get(i).getPassword().equals(password)) {
                    currentDriver = usernames.get(i);
                    t.setLock(true);
                    t.setUserId(usernames.get(i).getId());
                    return t;
                }
            }
            return t;
        }
        return t;
    }

    @WebMethod(operationName = "createShift")
    public int createShift(@WebParam(name = "userId") int userId) {

        Driver d = Controller.retrieveDriverById(userId);
        Shift s = new Shift(d);
        session.beginTransaction();
        session.persist(s);
        session.getTransaction().commit();
        System.out.println(d);
        return s.getShift_Id();
    }

    @WebMethod(operationName = "createJourney")
    public int createJourney(@WebParam(name = "shiftId") int shiftId) {
        Shift s = Controller.retrieveShiftById(shiftId);
        Journey j = new Journey(s);
        session.beginTransaction();
        session.persist(j);
        session.getTransaction().commit();
        return j.getJourney_Id();
    }

    @WebMethod(operationName = "finishShift")
    public int finishShift(@WebParam(name = "shiftId") int shiftId,@WebParam(name = "shiftDuration") int shiftDur) {
        Shift s = Controller.retrieveShiftById(shiftId);
        LocalDateTime myDateObj = LocalDateTime.now();
        s.setOutTimeStamp(myDateObj);
        s.setDuration(shiftDur);
        session.beginTransaction(); 
        session.update(s);
        session.getTransaction().commit();
        return 0;
    }

    @WebMethod(operationName = "finishJourney")
    public int finishJourney(@WebParam(name = "JourneyId") int journeyId,@WebParam(name = "JourneyFrom") String journeyFrom,
            @WebParam(name = "JourneyTo") String journeyTo) {
        
        Journey s = Controller.retrieveJourneyById(journeyId);
        LocalDateTime myDateObj = LocalDateTime.now();
        s.setTime_Out(myDateObj);
        s.setDuration(myDateObj.minusMinutes(Controller.currentDateObj.getMinute()).getMinute());
        s.setFromPlace(journeyFrom);
        s.setToPlace(journeyTo);
        session.beginTransaction();    
        session.update(s);
        session.getTransaction().commit();
        
        return myDateObj.minusMinutes(Controller.currentDateObj.getMinute()).getMinute();
    }    
}
