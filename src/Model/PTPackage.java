public class PTPackage {
    private String packageId;
    private String packageName;
    private int packageDuration;
    private double packagePrice;
    private String description;
    private String trainerId;

    public PTPackage() {}

    public PTPackage(String packageId, String packageName, int packageDuration,
                     double packagePrice, String description, String trainerId) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.packageDuration = packageDuration;
        this.packagePrice = packagePrice;
        this.description = description;
        this.trainerId = trainerId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }
}
