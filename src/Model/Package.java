package Model;

import java.util.List;

public class Package {
    private String packageId;
    private String packageName;
    private String packageDuration;
    private double packagePrice;
    private String description;
    private Integer duration;

    private List<MemberPackage> memberPackages;

    private List<Session> sessions;

    public Package() {}

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public double getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(double packagePrice) {
        this.packagePrice = packagePrice;
    }

    public String getPackageDuration() {
        return packageDuration;
    }

    public void setPackageDuration(String packageDuration) {
        this.packageDuration = packageDuration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public List<MemberPackage> getMemberPackages() {
        return memberPackages;
    }

    public void setMemberPackages(List<MemberPackage> memberPackages) {
        this.memberPackages = memberPackages;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
