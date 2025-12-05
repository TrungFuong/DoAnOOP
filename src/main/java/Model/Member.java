package Model;

import java.sql.Date;

public class Member {
    private String memberId;
    private String memberName;
    private String memberPhone;
    private Date memberDOB;
    private String memberEmail;
    private String memberImage;
    private boolean sta; 

    public Member() {}

    public Member(String memberId, String memberName, String memberPhone,
                  Date memberDOB, String memberEmail, String memberImage, boolean sta) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.memberDOB = memberDOB;
        this.memberEmail = memberEmail;
        this.memberImage = memberImage;
        this.sta = sta;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public Date getMemberDOB() {
        return memberDOB;
    }

    public void setMemberDOB(Date memberDOB) {
        this.memberDOB = memberDOB;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberImage() {
        return memberImage;
    }

    public void setMemberImage(String memberImage) {
        this.memberImage = memberImage;
    }

    public boolean getSta() {
        return sta;
    }

    public void setSta(boolean sta) {
        this.sta = sta;
    }
}
