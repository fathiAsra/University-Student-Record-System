public class StudentHashTable {

    Student[] table;

    public StudentHashTable(int size) {
        table = new Student[size];
    }

    private int hash(int id) {
        return id % table.length;
    }

    public boolean insert(Student student) {

        int index = hash(student.studentId);
        int start = index;

        while (table[index] != null) {

            if (table[index].studentId == student.studentId) {
                return false;
            }

            index = (index + 1) % table.length;

            if (index == start) {
                return false;
            }
        }

        table[index] = student;

        return true;
    }

    public Student search(int id) {

        int index = hash(id);
        int start = index;

        while (table[index] != null) {

            if (table[index].studentId == id) {
                return table[index];
            }

            index = (index + 1) % table.length;

            if (index == start) {
                break;
            }
        }

        return null;
    }
}