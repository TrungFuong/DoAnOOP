package Model;
import java.time.LocalDate;
import java.util.List;

public class Member {
    private String memberId;
    private String memberName;
    private boolean memberGender;
    private LocalDate dob;
    private String memberPhone;
    private String memberEmail;
    private String memberAddress;
    private String memberImages;
    private String memberStatus;

    private List<MemberPackage> memberPackages;

    public Member() {}

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

    public boolean getMemberGender() {
        return memberGender;
    }

    public void setMemberGender(boolean memberGender) {
        this.memberGender = memberGender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    public String getMemberImages() {
        return memberImages;
    }

    public void setMemberImages(String memberImages) {
        this.memberImages = memberImages;
    }

    public List<MemberPackage> getMemberPackages() {
        return memberPackages;
    }

    public void setMemberPackages(List<MemberPackage> memberPackages) {
        this.memberPackages = memberPackages;
    }
}
