package model;

import java.io.Serializable;
import java.time.LocalDateTime;
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
public class Training_profile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int training_Profile_Id;
    private String remark;
    private int mark;
    private LocalDateTime dateOccurrence;
    private LocalDateTime dateExpiry;     
    private boolean attendance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private Driver driver;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public Training_profile() {
    }

    public Training_profile(String remark, int mark, Schedule schedule, Driver driver, boolean attendance, LocalDateTime dateOccurrence ) {
        this.remark = remark;
        this.mark = mark;
        this.schedule = schedule;
        this.driver = driver;
        this.attendance = attendance;
        this.dateOccurrence=dateOccurrence;
        this.dateExpiry=dateOccurrence.plusYears(1);
    }

    public int getTraining_Profile_Id() {
        return training_Profile_Id;
    }

    public void setTraining_Profile_Id(int training_Profile_Id) {
        this.training_Profile_Id = training_Profile_Id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public LocalDateTime getDateOccurrence() {
        return dateOccurrence;
    }

    public void setDateOccurrence(LocalDateTime dateOccurrence) {
        this.dateOccurrence = dateOccurrence;
    }

    public LocalDateTime getDateExpiry() {
        return dateExpiry;
    }

    public void setDateExpiry(LocalDateTime dateExpiry) {
        this.dateExpiry = dateExpiry;
    }
    
    
    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public boolean isAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    
    
}
