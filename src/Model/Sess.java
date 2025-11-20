import java.sql.Date;
import java.sql.Time;

public class Sess {
    private Date sessionDate;
    private Time startTime;
    private String memberId;
    private String packageId;

    public Sess() {}

    public Sess(Date sessionDate, Time startTime, String memberId, String packageId) {
        this.sessionDate = sessionDate;
        this.startTime = startTime;
        this.memberId = memberId;
        this.packageId = packageId;
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
}
