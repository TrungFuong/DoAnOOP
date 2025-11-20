public class Account {
    private String accountId;
    private String accountPw;
    private String salt;
    private int role;

    public Account() {
    }

    public Account(String accountId, String accountPw, String salt, int role) {
        this.accountId = accountId;
        this.accountPw = accountPw;
        this.salt = salt;
        this.role = role;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountPw() {
        return accountPw;
    }

    public void setAccountPw(String accountPw) {
        this.accountPw = accountPw;
    }


    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
