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
public class Qualification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int qualification_Id;
    private String name;
    private String description;
    private int yearsOfValidity;
    @OneToMany(mappedBy = "qualification", cascade = CascadeType.ALL)
    private List<Driver_qualification> driver_qual_List;

    public Qualification() {
    }

    public Qualification(String name, String description,int yearsOfValidity) {
        this.name = name;
        this.description = description;
        this.driver_qual_List=new ArrayList<>();
        this.yearsOfValidity=yearsOfValidity;
    }

    public List<Driver_qualification> getDriver_qual_List() {
        return driver_qual_List;
    }

    public void setDriver_qual_List(List<Driver_qualification> driver_qual_List) {
        this.driver_qual_List = driver_qual_List;
    }

    public int getYearsOfValidity() {
        return yearsOfValidity;
    }

    public void setYearsOfValidity(int yearsOfValidity) {
        this.yearsOfValidity = yearsOfValidity;
    }
        
    public int getQualification_Id() {
        return qualification_Id;
    }

    public void setQualification_Id(int qualification_Id) {
        this.qualification_Id = qualification_Id;
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
