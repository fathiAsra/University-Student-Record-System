public class Student {

    int studentId;
    String name;
    String programme;
    double marks;

    public Student(int studentId, String name, String programme, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.programme = programme;
        this.marks = marks;
    }

    public void displayStudent() {
        System.out.println("----------------------------");
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Programme: " + programme);
        System.out.println("Marks: " + marks);
    }
}