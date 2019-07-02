package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
@Entity
public class Training implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int training_Id;
    private String area;
    private String details;
    private int durationInHours;
    private String name;
    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
    private List<Schedule> schedule_List;

    public Training() {
    }

    public Training(String area, String details, int durationInHours, String name) {
        this.area = area;
        this.details = details;
        this.durationInHours = durationInHours;
        this.name = name;
        this.schedule_List= new ArrayList<>();
    }

    public List<Schedule> getSchedule_List() {
        return schedule_List;
    }

    public void setSchedule_List(List<Schedule> schedule_List) {
        this.schedule_List = schedule_List;
    }
    
    public int getDurationInHours() {
        return durationInHours;
    }

    public void setDurationInHours(int durationInHours) {
        this.durationInHours = durationInHours;
    }

    public int getTraining_Id() {
        return training_Id;
    }

    public void setTraining_Id(int training_Id) {
        this.training_Id = training_Id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
