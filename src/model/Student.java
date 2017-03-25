package model;

/**
 * Created by philxchen on 3/25/17.
 */
public class Student extends Users {
    private String program;
    private int level;

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
