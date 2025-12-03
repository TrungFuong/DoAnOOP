package Model;

public class MembershipPackage {
    private String packageId;
    private String packageName;
    private int packageDuration;
    private double packagePrice;
    private String packageDescription;
    private boolean sta;

    public MembershipPackage() {}

    public MembershipPackage(String packageId, String packageName, int packageDuration,
                             double packagePrice, String packageDescription, boolean sta) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.packageDuration = packageDuration;
        this.packagePrice = packagePrice;
        this.packageDescription = packageDescription;
        this.sta = sta;
    }

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

    public int getPackageDuration() {
        return packageDuration;
    }

    public void setPackageDuration(int packageDuration) {
        this.packageDuration = packageDuration;
    }

    public double getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(double packagePrice) {
        this.packagePrice = packagePrice;
    }

    public String getPackageDescription() {
        return packageDescription;
    }

    public void setPackageDescription(String packageDescription) {
        this.packageDescription = packageDescription;
    }

    public boolean getSta() {
        return sta;
    }

    public void setSta(boolean sta) {
        this.sta = sta;
    }
    
    
}
