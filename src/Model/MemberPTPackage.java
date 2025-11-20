import java.sql.Date;

public class MemberPTPackage {
    private Date startDate;
    private Date endDate;
    private int sta;
    private String memberId;
    private String packageId;

    public MemberPTPackage() {}

    public MemberPTPackage(Date startDate, Date endDate, int sta,
                           String memberId, String packageId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.sta = sta;
        this.memberId = memberId;
        this.packageId = packageId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
}
