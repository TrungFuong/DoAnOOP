package Model;

import java.sql.Date;

public class MemberPackage {
    private Date startDate;
    private Date endDate;
    private int sta;
    private String memberId;
    private String packageId;
    private boolean isDeleted;

    public MemberPackage() {}

    public MemberPackage(Date startDate, Date endDate, int sta, String memberId, String packageId, boolean isDeleted) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.sta = sta;
        this.memberId = memberId;
        this.packageId = packageId;
        this.isDeleted = false;
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

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
