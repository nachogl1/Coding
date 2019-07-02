package model;

import java.util.ArrayList;
import hibernate.HibernateUtil;
import java.time.LocalDateTime;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
@Stateless
public class Controller  {
    private static Controller instance = null;
    public static Driver currentDriver;
    public static Session session = HibernateUtil.getSessionFactory().openSession();
    public static LocalDateTime currentDateObj;

    public static boolean getUserValidation(String username, String password) {
        session.beginTransaction();
        Query queryResult = session.createQuery(" FROM Driver");
        List<Driver> usernames = queryResult.list();
        session.getTransaction().commit();
        if(!usernames.isEmpty()){
            int i;
            for(i=0;i<usernames.size();i++){
                if(usernames.get(i).getUserName().contains(username)&&usernames.get(i).getPassword().contains(password)){
                    currentDriver=usernames.get(i);
                    return true;
                }
            }
            return false;
        }
        else{
            return false;
        } 
    }

    public static ArrayList<String> getPossibleExpiredCourses(int localVal) {       
        int iterator = localVal;
        ArrayList<Driver_qualification> expiryValidation;
        ArrayList<String> expiredQualification=new ArrayList<>();
        
        expiryValidation = (ArrayList<Driver_qualification>) retrieveExpiry(iterator);
        int i;
        for (i = 0; i < expiryValidation.size(); i++) {
            
            LocalDateTime d1 = expiryValidation.get(i).getDateExpiry();
            
            
            LocalDateTime d2 = LocalDateTime.now();
            
            if (d2.isAfter(d1.minusMonths(1))) {
                expiredQualification.add(expiryValidation.get(i).getQualification().getName()+" ("+expiryValidation.get(i).getDateExpiry()+") ");
            }
        }
        return expiredQualification;
    }
    public static ArrayList<String> getPossibleExpiredTrainings(int localVal) {       
        int iterator = localVal;
        ArrayList<Training_profile> expiryValidation;
        ArrayList<String> expiredQualification=new ArrayList<>();
        
        expiryValidation = (ArrayList<Training_profile>) retrieveExpiryT(iterator);
        int i;
        for (i = 0; i < expiryValidation.size(); i++) {
            
            LocalDateTime d1 = expiryValidation.get(i).getDateExpiry();
            LocalDateTime d2 = LocalDateTime.now();
            
            if (d2.isAfter(d1.minusMonths(1))) {
                expiredQualification.add(expiryValidation.get(i).getSchedule().getTraining().getName()+" ("+expiryValidation.get(i).getDateExpiry()+")");
            }
        }
        return expiredQualification;
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public static void setInstance(Controller instance) {
        Controller.instance = instance;
    }

    public static Driver getCurrentDriver() {
        return currentDriver;
    }

    public static void setCurrentDriver(Driver currentDriver) {
        Controller.currentDriver = currentDriver;
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        Controller.session = session;
    }

    public static void create(Object d) {
        session.beginTransaction();
        session.persist(d);
        session.getTransaction().commit();
    }

    public static void update(Object d) {
        session.beginTransaction();
        session.delete(d);
        session.persist(d);
        session.getTransaction().commit();
    }

    public static void delete(Object d) {
        session.beginTransaction();
        session.delete(d);
        session.getTransaction().commit();
    }
    
  

    public static List<Driver> retrieve() {
        session.beginTransaction();
        Query queryResult = session.createQuery(" from Driver");
        List<Driver> allDrivers;
        allDrivers = queryResult.list();
        session.getTransaction().commit();
        return allDrivers;
    }
    public static List<Qualification> retrieveQs() {
        session.beginTransaction();
        Query queryResult = session.createQuery(" from Qualification");
        List<Qualification> allQualifications;
        allQualifications = queryResult.list();
        session.getTransaction().commit();
        return allQualifications;
    }
    public static Driver retrieveDriver(String localVal) {
        session.beginTransaction();
        Query queryResult = session.createQuery("FROM Driver WHERE userName = '"+ localVal +"' ");
        Driver driver;
        driver = (Driver) queryResult.uniqueResult();
        session.getTransaction().commit();
        return driver;
    }
    public static Driver retrieveDriverById(int localVal) {
        session.beginTransaction();
        Query queryResult = session.createQuery("FROM Driver WHERE driver_Id = "+ localVal +" ");
        Driver driver;
        driver = (Driver) queryResult.uniqueResult();
        session.getTransaction().commit();
        return driver;
    }
    public static Journey retrieveJourneyById(int localVal) {
        session.beginTransaction();
        Query queryResult = session.createQuery("FROM Journey WHERE journey_Id = "+ localVal +" ");
        Journey j;
        j = (Journey) queryResult.uniqueResult();
        session.getTransaction().commit();
        return j;
    }
    public static Shift retrieveShiftById(int localVal) {
        session.beginTransaction();
        Query queryResult = session.createQuery("FROM Shift WHERE shift_Id = "+ localVal +" ");
        Shift shift;
        shift = (Shift) queryResult.uniqueResult();
        session.getTransaction().commit();
        return shift;
    }
    public static Incident retrieveIncident(String localVal) {
        session.beginTransaction();
        Query queryResult = session.createQuery("FROM Incident WHERE name = '"+ localVal +"' ");
        Incident d;
        d = (Incident) queryResult.uniqueResult();
        session.getTransaction().commit();
        return d;
    }
    public static Qualification retrieveQualification(String localVal) {
        session.beginTransaction();
        Query queryResult = session.createQuery("FROM Qualification WHERE name = '"+ localVal +"' ");
        Qualification q;
        q = (Qualification) queryResult.uniqueResult();
        session.getTransaction().commit();
        return q;
    }
    public static Schedule retrieveSchedule(int localVal) {
        session.beginTransaction();
        Query queryResult = session.createQuery("FROM Schedule WHERE schedule_Id = "+ localVal +" ");
        Schedule q;
        q = (Schedule) queryResult.uniqueResult();
        session.getTransaction().commit();
        return q;
    }
    
    public static Training retrieveTraining(String localVal) {
        session.beginTransaction();
        Query queryResult = session.createQuery("FROM Training WHERE name = '"+ localVal +"' ");
        Training t;
        t = (Training) queryResult.uniqueResult();
        session.getTransaction().commit();
        return t;
    }
    public static List<Training> retrieveTrainings() {
        session.beginTransaction();
        Query queryResult = session.createQuery(" FROM Training ");
        List<Training> t;
        t = queryResult.list();
        session.getTransaction().commit();
        return t;
    }
    public static List<Incident> retrieveIncidents() {
        session.beginTransaction();
        Query queryResult = session.createQuery(" FROM Incident ");
        List<Incident> t;
        t = queryResult.list();
        session.getTransaction().commit();
        return t;
    }
    public static List<Schedule> retrieveSchedules() {
        session.beginTransaction();
        Query queryResult = session.createQuery(" FROM Schedule ");
        List<Schedule> t;
        t = queryResult.list();
        session.getTransaction().commit();
        return t;
    }

    public static List<Driver_qualification> retrieveExpiry(int iterator) {
        session.beginTransaction();
        Query queryResult = session.createQuery(" from Driver_qualification WHERE driver_id = " + iterator + "");
        List<Driver_qualification> allDates;
        allDates = queryResult.list();
        session.getTransaction().commit();
        return allDates;
    }
    
    public static List<Training_profile> retrieveExpiryT(int iterator) {
        session.beginTransaction();
        Query queryResult = session.createQuery(" from Training_profile WHERE driver_id = " + iterator + "");
        List<Training_profile> allDates;
        allDates = queryResult.list();
        session.getTransaction().commit();
        return allDates;
    }

}
