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
public class Incident implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int incident_Id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "incident", cascade = CascadeType.ALL)
    private List<Disciplinary_records_profile> disciplinary_Records_List;

    public Incident(String name, String description) {
        this.name = name;
        this.description = description;
        this.disciplinary_Records_List=new ArrayList<>();
    }

    public Incident() {
    }

    public List<Disciplinary_records_profile> getDisciplinary_Records_List() {
        return disciplinary_Records_List;
    }

    public void setDisciplinary_Records_List(List<Disciplinary_records_profile> disciplinary_Records_List) {
        this.disciplinary_Records_List = disciplinary_Records_List;
    }
    
    public int getIncident_Id() {
        return incident_Id;
    }

    public void setIncident_Id(int incident_Id) {
        this.incident_Id = incident_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
