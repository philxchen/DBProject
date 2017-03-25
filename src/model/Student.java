package model;

/**
 * Created by philxchen on 3/25/17.
 */
public class Student extends Users {
    private String program;
    private int level;

    public Student(int userId, String email, String fName, String lName, String password, String program, int level) {
        super(userId, email, fName, lName, password);
        this.program = program;
        this.level = level;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
