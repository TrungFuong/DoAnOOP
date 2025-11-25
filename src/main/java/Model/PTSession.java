package Model;

import java.sql.Date;
import java.sql.Time;

public class PTSession {
    private Date sessionDate;
    private Time startTime;
    private Time endTime;
    private int sta;
    private String memberId;
    private String packageId;
    private String trainerId;

    public PTSession() {}

    public PTSession(Date sessionDate, Time startTime, Time endTime, int sta,
                     String memberId, String packageId, String trainerId) {
        this.sessionDate = sessionDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.sta = sta;
        this.memberId = memberId;
        this.packageId = packageId;
        this.trainerId = trainerId;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int getSta() {
        return sta;
    }

    public void setSta(int sta) {
        this.sta = sta;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }
}
