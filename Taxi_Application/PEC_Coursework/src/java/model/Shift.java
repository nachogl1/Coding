package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
@Entity
public class Shift implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shift_Id;
    private LocalDateTime inTimeStamp;
    private int duration;
    private LocalDateTime outTimeStamp;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private Driver driver;
    @OneToMany(mappedBy = "shift", cascade = CascadeType.ALL)
    private List<Journey> journey_List;

    public Shift() {
    }

    public Shift(Driver driver) {
        this.driver = driver;
        this.inTimeStamp =  LocalDateTime.now();
        this.outTimeStamp = null;
        this.journey_List = new ArrayList<>();
        this.duration=0;
    }

    public List<Journey> getJourney_List() {
        return journey_List;
    }

    public void setJourney_List(List<Journey> journey_List) {
        this.journey_List = journey_List;
    }

    public int getShift_Id() {
        return shift_Id;
    }

    public void setShift_Id(int shift_Id) {
        this.shift_Id = shift_Id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public LocalDateTime getInTimeStamp() {
        return inTimeStamp;
    }

    public void setInTimeStamp(LocalDateTime inTimeStamp) {
        this.inTimeStamp = inTimeStamp;
    }

    public LocalDateTime getOutTimeStamp() {
        return outTimeStamp;
    }

    public void setOutTimeStamp(LocalDateTime outTimeStamp) {
        this.outTimeStamp = outTimeStamp;
    }

}
