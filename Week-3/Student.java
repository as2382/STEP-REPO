public class Student {
    // Private instance variables (Encapsulation)
    private String studentId;
    private String name;
    private double grade;
    private String course;

    // Default constructor (no parameters)
    public Student() {
        this.studentId = "";
        this.name = "";
        this.grade = 0.0;
        this.course = "";
    }

    // Parameterized constructor
    public Student(String studentId, String name, double grade, String course) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }

    // Getter and Setter methods
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // Method to calculate letter grade
    public String calculateLetterGrade() {
        if (grade >= 90) {
            return "A";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 70) {
            return "C";
        } else if (grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // Method to display student information
    public void displayStudent() {
        System.out.println("Student Information:");
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Grade: " + grade);
        System.out.println("Letter Grade: " + calculateLetterGrade());
        System.out.println("----------------------");
    }

    // Main method
    public static void main(String[] args) {
        // Create student using default constructor
        Student s1 = new Student();
        s1.setStudentId("S001");
        s1.setName("Alice Johnson");
        s1.setGrade(85.5);
        s1.setCourse("Mathematics");

        // Create student using parameterized constructor
        Student s2 = new Student("S002", "Bob Smith", 72.3, "Physics");

        // Demonstrate getter and setter methods
        System.out.println("Before update: " + s1.getName() + " has grade " + s1.getGrade());
        s1.setGrade(92.0); // updating grade using setter
        System.out.println("After update: " + s1.getName() + " has grade " + s1.getGrade());
        System.out.println();

        // Display both students' info
        s1.displayStudent();
        s2.displayStudent();

    }
}
