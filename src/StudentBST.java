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

    // Insert student into BST
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

    // Search student by ID
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

    // Delete student by ID
    public void delete(int id) {
        root = deleteRecursive(root, id);
    }

    private Node deleteRecursive(Node root, int id) {

        if (root == null) {
            return null;
        }

        if (id < root.student.studentId) {

            root.left = deleteRecursive(root.left, id);

        } else if (id > root.student.studentId) {

            root.right = deleteRecursive(root.right, id);

        } else {

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Only right child
            if (root.left == null) {
                return root.right;
            }

            // Case 3: Only left child
            if (root.right == null) {
                return root.left;
            }

            // Case 4: Two children
            Node successor = findMin(root.right);

            root.student = successor.student;

            root.right =
                    deleteRecursive(root.right,
                            successor.student.studentId);
        }

        return root;
    }

    // Find smallest node
    private Node findMin(Node root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // Display students in ascending Student ID
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