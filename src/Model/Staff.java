package Model;

import java.time.LocalDate;

public class Staff {
    private String staffId;
    private String staffName;
    private boolean staffGender;
    private LocalDate dob;
    private String staffPhone;
    private String staffEmail;
    private String staffStatus;

    // Quan hệ 1 - 1 với Account
    private Account account;

    public Staff() {}

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

    public boolean isStaffGender() {
        return staffGender;
    }

    public void setStaffGender(boolean staffGender) {
        this.staffGender = staffGender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
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

    public String getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

