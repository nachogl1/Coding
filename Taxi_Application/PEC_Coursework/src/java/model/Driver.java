package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author ig2348z.gre.ac.uk
 */
@Entity
public class Driver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int driver_Id;
    private String car_Info;
    private String mobile;
    private String userName;
    private String completeName;
    private String password;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date seniority;
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Disciplinary_records_profile> disciplinary_r_p_list;
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Driver_qualification> driver_qua_list;
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Shift> shift_list;
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Training_profile> training_p_list;

    public Driver(String car_Info, String mobile, String userName, String completeName, String password) {
        this.car_Info = car_Info;
        this.mobile = mobile;
        this.userName = userName;
        this.completeName = completeName;
        this.password = password;
        this.disciplinary_r_p_list = new ArrayList<>();
        this.driver_qua_list = new ArrayList<>();
        this.shift_list = new ArrayList<>();
        this.training_p_list = new ArrayList<>();
        this.seniority = new Date();
    }

    public Driver() {
    }

    @Override
    public String toString() {
        return "Driver{" + "driver_Id=" + driver_Id + ", car_Info=" + car_Info + ", mobile=" + mobile + ", userName=" + userName + ", completeName=" + completeName + ", password=" + password + ", seniority=" + seniority + ", disciplinary_r_p_list=" + disciplinary_r_p_list + ", driver_qua_list=" + driver_qua_list + ", shift_list=" + shift_list + ", training_p_list=" + training_p_list + '}';
    }

    public int getId() {
        return driver_Id;
    }

    public int getDriver_Id() {
        return driver_Id;
    }

    public Date getSeniority() {
        return seniority;
    }

    public void setSeniority(Date seniority) {
        this.seniority = seniority;
    }

    public void setDriver_Id(int driver_Id) {
        this.driver_Id = driver_Id;
    }

    public List<Disciplinary_records_profile> getDisciplinary_r_p_list() {
        return disciplinary_r_p_list;
    }

    public void setDisciplinary_r_p_list(List<Disciplinary_records_profile> disciplinary_r_p_list) {
        this.disciplinary_r_p_list = disciplinary_r_p_list;
    }

    public List<Driver_qualification> getDriver_qua_list() {
        return driver_qua_list;
    }

    public void setDriver_qua_list(List<Driver_qualification> driver_qua_list) {
        this.driver_qua_list = driver_qua_list;
    }

    public List<Shift> getShift_list() {
        return shift_list;
    }

    public void setShift_list(List<Shift> shift_list) {
        this.shift_list = shift_list;
    }

    public List<Training_profile> getTraining_p_list() {
        return training_p_list;
    }

    public void setTraining_p_list(List<Training_profile> training_p_list) {
        this.training_p_list = training_p_list;
    }

    public void setId(int driver_Id) {
        this.driver_Id = driver_Id;
    }

    public String getCar() {
        return car_Info;
    }

    public void setCar_Info(String car_Info) {
        this.car_Info = car_Info;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompleteName() {
        return completeName;
    }

    public void setCompleteName(String completeName) {
        this.completeName = completeName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
