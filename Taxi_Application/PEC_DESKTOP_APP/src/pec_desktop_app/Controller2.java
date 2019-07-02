
package pec_desktop_app;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
public class Controller2 {
    private static Controller2 instance = null;
    public static String currentUserName;
    public static int userId;
    public static int journeyId;
    public static int shiftId;
    public static int currentMin;
    public static boolean jS = false;
    public static boolean sS = false;
  

    public static Controller2 getInstance() {
        if (instance == null) {
            instance = new Controller2();
        }
        return instance;
    }

    public static String getCurrentUserName() {
        return currentUserName;
    }

    public static int getJourneyId() {
        return journeyId;
    }

    public static void setJourneyId(int journeyId) {
        Controller2.journeyId = journeyId;
    }

  

    public static void setCurrentUserName(String currentUserName) {
        Controller2.currentUserName = currentUserName;
    }

    public static int getUserId() {
        return userId;
    }

    public static int getShiftId() {
        return shiftId;
    }

    public static void setShiftId(int shiftId) {
        Controller2.shiftId = shiftId;
    }

    public static void setUserId(int userId) {
        Controller2.userId = userId;
    }

    
    
    
}
