package Model;

import java.sql.Date;

public class Staff {
    private String staffId;
    private String staffName;
    private String staffPhone;
    private String staffEmail;
    private Date staffDOB;
    private boolean staffGender;
    private boolean staffStatus;
    private String accountId;

    public Staff() {}

    public Staff(String staffId, String staffName, String staffPhone, String staffEmail,
                 Date staffDOB, boolean staffGender, boolean staffStatus, String accountId) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffPhone = staffPhone;
        this.staffEmail = staffEmail;
        this.staffDOB = staffDOB;
        this.staffGender = staffGender;
        this.staffStatus = staffStatus;
        this.accountId = accountId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public Date getStaffDOB() {
        return staffDOB;
    }

    public void setStaffDOB(Date staffDOB) {
        this.staffDOB = staffDOB;
    }

    public boolean isStaffGender() {
        return staffGender;
    }

    public void setStaffGender(boolean staffGender) {
        this.staffGender = staffGender;
    }

    public boolean isStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(boolean staffStatus) {
        this.staffStatus = staffStatus;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
