
package pec_desktop_app;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
public class TemporalWSObject {
    private boolean lock;
    private int userId;

    public TemporalWSObject(boolean lock, int userId) {
        this.lock = lock;
        this.userId = userId;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
}
