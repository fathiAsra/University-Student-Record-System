public class StudentHashTable {

    Student[] table;

    public StudentHashTable(int size) {
        table = new Student[size];
    }

    // Hash function
    private int hash(int id) {
        return Math.abs(id) % table.length;
    }

    // Insert student
    public boolean insert(Student student) {

        int index = hash(student.studentId);
        int start = index;

        while (table[index] != null) {

            // Duplicate ID
            if (table[index].studentId == student.studentId) {
                return false;
            }

            // Linear probing
            index = (index + 1) % table.length;

            // Table is full
            if (index == start) {
                return false;
            }
        }

        table[index] = student;

        return true;
    }

    // Search student by ID
    public Student search(int id) {

        int index = hash(id);
        int start = index;

        while (table[index] != null) {

            if (table[index].studentId == id) {
                return table[index];
            }

            // Linear probing
            index = (index + 1) % table.length;

            if (index == start) {
                break;
            }
        }

        return null;
    }
}