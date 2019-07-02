package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
@Entity
public class Journey implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int journey_Id;
    private int duration;
    private LocalDateTime time_In;
    private String toPlace;
    private String fromPlace;
    private LocalDateTime time_Out;
    private float total_Km;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "shift_id")
    private Shift shift;

    public Journey() {
    }
    public Journey(Shift shift) {
        this.duration = 0;
        this.time_In = LocalDateTime.now();
        Controller.currentDateObj=time_In;
        this.time_Out = null;
        this.total_Km = 0;
        this.shift = shift;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public int getJourney_Id() {
        return journey_Id;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public void setJourney_Id(int journey_Id) {
        this.journey_Id = journey_Id;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(int price) {
        this.duration = price;
    }

    public LocalDateTime getTime_In() {
        return time_In;
    }

    public void setTime_In(LocalDateTime time_In) {
        this.time_In = time_In;
    }

    public LocalDateTime getTime_Out() {
        return time_Out;
    }

    public void setTime_Out(LocalDateTime time_Out) {
        this.time_Out = time_Out;
    }

    public float getTotal_Km() {
        return total_Km;
    }

    public void setTotal_Km(float total_Km) {
        this.total_Km = total_Km;
    }

}
