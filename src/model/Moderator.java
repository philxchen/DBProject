package model;

public class Moderator extends Users {
    private int moderatorId;

    public Moderator(int userId, String email, String fName, String lName, String password, int moderatorId) {
        super(userId, email, fName, lName, password);
        this.moderatorId = moderatorId;
    }

    public int getModeratorId() {
        return moderatorId;
    }
}
