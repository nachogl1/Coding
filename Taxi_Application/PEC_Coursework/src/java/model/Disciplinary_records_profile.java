package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;


/**
 *
 * @author ig2348z.gre.ac.uk
 */
@Entity
public class Disciplinary_records_profile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int disciplinary_Records_Profile_Id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date_Occurrence;
    @ManyToOne(fetch = FetchType.LAZY)//, cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private Driver driver;
    @ManyToOne(fetch = FetchType.LAZY)//, cascade = CascadeType.ALL)
    @JoinColumn(name = "incident_id")
    private Incident incident;

    public Disciplinary_records_profile(Driver driver, Incident incident, Date date_Occurrence) {
        this.driver = driver;
        this.incident = incident;
        this.date_Occurrence=date_Occurrence;
    }

    public Disciplinary_records_profile() {
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }
    
    public Date getDate_Occurrence() {
        return date_Occurrence;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    
    public void setDate_Occurrence(Date date_Occurrence) {
        this.date_Occurrence = date_Occurrence;
    }
    
    public int getDisciplinary_Records_Profile_Id() {
        return disciplinary_Records_Profile_Id;
    }

    public void setDisciplinary_Records_Profile_Id(int disciplinary_Records_Profile_Id) {
        this.disciplinary_Records_Profile_Id = disciplinary_Records_Profile_Id;
    }

    
    
}
