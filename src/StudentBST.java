public class StudentBST {

    class Node {

        Student student;
        Node left;
        Node right;

        Node(Student student) {
            this.student = student;
        }
    }

    Node root;

    public void insert(Student student) {
        root = insertRecursive(root, student);
    }

    private Node insertRecursive(Node root, Student student) {

        if (root == null) {
            return new Node(student);
        }

        if (student.studentId < root.student.studentId) {

            root.left = insertRecursive(root.left, student);

        } else if (student.studentId > root.student.studentId) {

            root.right = insertRecursive(root.right, student);
        }

        return root;
    }

    public Student search(int id) {

        Node current = root;

        while (current != null) {

            if (id == current.student.studentId) {
                return current.student;
            }

            if (id < current.student.studentId) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    public void displayInOrder() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node root) {

        if (root != null) {

            inOrderRecursive(root.left);

            root.student.displayStudent();

            inOrderRecursive(root.right);
        }
    }
}