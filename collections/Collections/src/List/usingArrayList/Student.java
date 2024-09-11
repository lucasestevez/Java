package List.usingArrayList;

public class Student {

    private int ID;
    private String name;
    private double grade;

    public Student(int ID, String name, double grade) {
        this.ID = ID;
        this.name = name;
        this.grade = grade;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "[ID: "+getID()+"; Name: "+getName()+"; Grade: "+getGrade()+"]";
    }
}
