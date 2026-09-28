public class StudentLinkedList {

    class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    Node head;

    // Add student
    public boolean addStudent(Student student) {

        if (searchStudent(student.studentId) != null) {
            return false;
        }

        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
            return true;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

        return true;
    }

    // Search student
    public Student searchStudent(int id) {

        Node current = head;

        while (current != null) {

            if (current.student.studentId == id) {
                return current.student;
            }

            current = current.next;
        }

        return null;
    }

    // Update student
    public boolean updateStudent(
            int id,
            String name,
            String programme,
            double marks) {

        Student student = searchStudent(id);

        if (student == null) {
            return false;
        }

        student.name = name;
        student.programme = programme;
        student.marks = marks;

        return true;
    }

    // Delete student
    public Student deleteStudent(int id) {

        if (head == null) {
            return null;
        }

        if (head.student.studentId == id) {

            Student deleted = head.student;
            head = head.next;

            return deleted;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.student.studentId == id) {

                Student deleted = current.next.student;

                current.next = current.next.next;

                return deleted;
            }

            current = current.next;
        }

        return null;
    }

    // Display all students
    public void displayStudents() {

        if (head == null) {
            System.out.println("No student records found.");
            return;
        }

        Node current = head;

        while (current != null) {

            current.student.displayStudent();

            current = current.next;
        }
    }
}