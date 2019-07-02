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
public class Driver_qualification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private int driver_Qualification_Id;
     private LocalDateTime dateOccurrence;
     private LocalDateTime dateExpiry;
     private String remark;
     private int mark;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    private Driver driver;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qualification_id")
    private Qualification qualification;

    public Driver_qualification() {
    }

    public Driver_qualification(LocalDateTime dateOccurrence, Driver driver, Qualification qualification, String remark, int mark) {
        this.dateOccurrence = dateOccurrence;
        this.dateExpiry=dateOccurrence.plusYears(qualification.getYearsOfValidity());       
       
        this.qualification = qualification;
        this.driver = driver;
        this.remark = remark;
        this.mark = mark;
    }

    public int getDriver_Qualification_Id() {
        return driver_Qualification_Id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setDriver_Qualification_Id(int driver_Qualification_Id) {
        this.driver_Qualification_Id = driver_Qualification_Id;
    }

    public LocalDateTime getDateStart() {
        return dateOccurrence;
    }

    public void setDateStart(LocalDateTime dateOccurrence) {
        this.dateOccurrence = dateOccurrence;
    }

    public LocalDateTime getDateExpiry() {
        return dateExpiry;
    }

    public void setDateExpiry(LocalDateTime dateExpiry) {
        this.dateExpiry = dateExpiry;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
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
     
     
     

}
