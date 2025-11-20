import java.sql.Date;

public class Trainer {
    private String trainerId;
    private String trainerName;
    private String trainerEmail;
    private String trainerPhone;
    private Date trainerDOB;
    private int trainerStatus;
    private boolean trainerGender;
    private String accountId;

    public Trainer() {}

    public Trainer(String trainerId, String trainerName, String trainerEmail, String trainerPhone, Date trainerDOB, int trainerStatus, boolean trainerGender, String accountId) {
        this.trainerId = trainerId;
        this.trainerName = trainerName;
        this.trainerEmail = trainerEmail;
        this.trainerPhone = trainerPhone;
        this.trainerDOB = trainerDOB;
        this.trainerStatus = trainerStatus;
        this.trainerGender = trainerGender;
        this.accountId = accountId;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainerEmail() {
        return trainerEmail;
    }

    public void setTrainerEmail(String trainerEmail) {
        this.trainerEmail = trainerEmail;
    }

    public String getTrainerPhone() {
        return trainerPhone;
    }

    public void setTrainerPhone(String trainerPhone) {
        this.trainerPhone = trainerPhone;
    }

    public Date getTrainerDOB() {
        return trainerDOB;
    }

    public void setTrainerDOB(Date trainerDOB) {
        this.trainerDOB = trainerDOB;
    }

    public int getTrainerStatus() {
        return trainerStatus;
    }

    public void setTrainerStatus(int trainerStatus) {
        this.trainerStatus = trainerStatus;
    }

    public boolean isTrainerGender() {
        return trainerGender;
    }

    public void setTrainerGender(boolean trainerGender) {
        this.trainerGender = trainerGender;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
