package model;


public class Users {
    private int userId;
    private String email;
    private String fName;
    private String lName;
    private String password;

    public Users(int userId, String email, String fName, String lName, String password) {
        this.userId = userId;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
