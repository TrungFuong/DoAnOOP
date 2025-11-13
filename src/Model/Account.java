package Model;

public class Account {
    private String accountId;
    private String accountPwHash;
    private String salt;
    private String role;

    private Trainer trainer;
    private Staff staff;

    public Account() {}

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountPw() {
        return accountPw;
    }

    public String getAccountPwHash() {
        return accountPwHash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setPassword(String rawPassword) {
        try {
            SecureRandom sr = new SecureRandom();
            byte[] saltBytes = new byte[16];
            sr.nextBytes(saltBytes);
            this.salt = Base64.getEncoder().encodeToString(saltBytes);

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(saltBytes);
            byte[] hashBytes = md.digest(rawPassword.getBytes());
            this.accountPwHash = Base64.getEncoder().encodeToString(hashBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public boolean checkPassword(String rawPassword) {
        try {
            byte[] saltBytes = Base64.getDecoder().decode(this.salt);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(saltBytes);
            byte[] hashBytes = md.digest(rawPassword.getBytes());
            String hashAttempt = Base64.getEncoder().encodeToString(hashBytes);
            return hashAttempt.equals(this.accountPwHash);
        } catch (Exception e) {
            throw new RuntimeException("Error checking password", e);
        }
    }
}
