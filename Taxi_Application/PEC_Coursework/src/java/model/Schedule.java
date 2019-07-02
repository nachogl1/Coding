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
public class Schedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int schedule_Id;
    private String place;
    private LocalDateTime time_Start;
    private LocalDateTime time_Finish;
    private String details;
    private int roomSpace;
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private List<Training_profile> training_profile_List;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "training_id")
    private Training training;
    int[] arrayAssessment;

    public Schedule() {
    }

    public Schedule(String place, LocalDateTime time_Start, Training training, String details, int roomSpace, int[] arrayAssessment) {
        this.place = place;
        this.time_Start = time_Start;
        this.training = training;
        this.details = details;
        this.roomSpace = roomSpace;
        this.time_Finish = time_Start.plusHours(training.getDurationInHours());
        this.training_profile_List = new ArrayList<>();
        this.arrayAssessment=arrayAssessment;

    }

    public int getSchedule_Id() {
        return schedule_Id;
    }

    public void setSchedule_Id(int schedule_Id) {
        this.schedule_Id = schedule_Id;
    }

    public LocalDateTime getTime_Finish() {
        return time_Finish;
    }

    public void setTime_Finish(LocalDateTime time_Finish) {
        this.time_Finish = time_Finish;
    }

    public int[] getArrayAssessment() {
        return arrayAssessment;
    }

    public void setArrayAssessment(int[] arrayAssessment) {
        this.arrayAssessment = arrayAssessment;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDateTime getTime_Start() {
        return time_Start;
    }

    public void setTime_Start(LocalDateTime time_Start) {
        this.time_Start = time_Start;
    }

    public List<Training_profile> getTraining_profile_List() {
        return training_profile_List;
    }

    public void setTraining_profile_List(List<Training_profile> training_profile_List) {
        this.training_profile_List = training_profile_List;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getRoomSpace() {
        return roomSpace;
    }

    public void setRoomSpace(int roomSpace) {
        this.roomSpace = roomSpace;
    }

}
