import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static StudentLinkedList studentList =
            new StudentLinkedList();

    static ActionStack actionStack =
            new ActionStack(100);

    static ServiceQueue serviceQueue =
            new ServiceQueue(100);

    static StudentBST studentBST =
            new StudentBST();

    static StudentHashTable hashTable =
            new StudentHashTable(101);

    static CampusGraph campusGraph =
            new CampusGraph();

    public static void main(String[] args) {

        while (true) {

            displayMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    updateStudent();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                    studentList.displayStudents();
                    break;

                case 5:
                    addServiceRequest();
                    break;

                case 6:
                    processServiceRequest();
                    break;

                case 7:
                    actionStack.display();
                    break;

                case 8:
                    studentBST.displayInOrder();
                    break;

                case 9:
                    searchUsingHashing();
                    break;

                case 10:
                    addCampusLocation();
                    break;

                case 11:
                    removeCampusLocation();
                    break;

                case 12:
                    addCampusConnection();
                    break;

                case 13:
                    removeCampusConnection();
                    break;

                case 14:
                    campusGraph.displayGraph();
                    break;

                case 15:
                    bfsCampus();
                    break;

                case 16:
                    System.out.println("Program exited.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ================= MENU =================

    static void displayMenu() {

        System.out.println("\n======================================");
        System.out.println(" UNIVERSITY STUDENT RECORD SYSTEM");
        System.out.println("======================================");

        System.out.println("1. Add Student Record");
        System.out.println("2. Update Student Record");
        System.out.println("3. Delete Student Record");
        System.out.println("4. Display All Records using Linked List");
        System.out.println("5. Add Service Request to Queue");
        System.out.println("6. Process Next Service Request");
        System.out.println("7. Display Recent Actions using Stack");
        System.out.println("8. Display Students using BST");
        System.out.println("9. Search Student using Hashing");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection");
        System.out.println("13. Remove Campus Connection");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. Traverse Campus using BFS");
        System.out.println("16. Exit");
        System.out.println("======================================");
    }

    // ================= STUDENT =================

    static void addStudent() {

        System.out.println("\n===== ADD STUDENT =====");

        int id = readInt("Enter Student ID: ");

        if (studentList.searchStudent(id) != null) {

            System.out.println("Student ID already exists.");
            return;
        }

        String name = readText("Enter Name: ");
        String programme = readText("Enter Programme: ");

        double marks = readMarks();

        Student student =
                new Student(id, name, programme, marks);

        studentList.addStudent(student);

        studentBST.insert(student);
        hashTable.insert(student);

        actionStack.push(
                "Added student: " + id);

        System.out.println(
                "Student added successfully.");
    }

    static void updateStudent() {

        System.out.println("\n===== UPDATE STUDENT =====");

        int id = readInt("Enter Student ID: ");

        Student student =
                studentList.searchStudent(id);

        if (student == null) {

            System.out.println("Student not found.");
            return;
        }

        String name = readText("Enter New Name: ");
        String programme =
                readText("Enter New Programme: ");

        double marks = readMarks();

        studentList.updateStudent(
                id,
                name,
                programme,
                marks);

        actionStack.push(
                "Updated student: " + id);

        System.out.println(
                "Student updated successfully.");
    }

    static void deleteStudent() {

        System.out.println("\n===== DELETE STUDENT =====");

        int id = readInt("Enter Student ID: ");

        Student deleted =
                studentList.deleteStudent(id);

        if (deleted == null) {

            System.out.println("Student not found.");
            return;
        }

        actionStack.push(
                "Deleted student: " + id);

        System.out.println(
                "Student deleted successfully.");

        System.out.println(
                "Deleted record:");

        deleted.displayStudent();
    }

    // ================= QUEUE =================

    static void addServiceRequest() {

        System.out.println("\n===== ADD SERVICE REQUEST =====");

        String request =
                readText("Enter service request: ");

        serviceQueue.enqueue(request);

        actionStack.push(
                "Added service request");
    }

    static void processServiceRequest() {

        System.out.println(
                "\n===== PROCESS SERVICE REQUEST =====");

        String request =
                serviceQueue.dequeue();

        if (request == null) {

            System.out.println(
                    "No service requests.");
            return;
        }

        System.out.println(
                "Processing: " + request);

        actionStack.push(
                "Processed service request");
    }

    // ================= HASHING =================

    static void searchUsingHashing() {

        System.out.println(
                "\n===== HASHING SEARCH =====");

        int id =
                readInt("Enter Student ID: ");

        Student student =
                hashTable.search(id);

        if (student == null) {

            System.out.println(
                    "Student not found.");

        } else {

            System.out.println(
                    "Student found using Hashing:");

            student.displayStudent();
        }
    }

    // ================= GRAPH =================

    static void addCampusLocation() {

        System.out.println(
                "\n===== ADD CAMPUS LOCATION =====");

        String location =
                readText("Enter location name: ");

        if (campusGraph.addLocation(location)) {

            System.out.println(
                    "Location added successfully.");

        } else {

            System.out.println(
                    "Location already exists.");
        }
    }

    static void removeCampusLocation() {

        System.out.println(
                "\n===== REMOVE CAMPUS LOCATION =====");

        String location =
                readText("Enter location name: ");

        if (campusGraph.removeLocation(location)) {

            System.out.println(
                    "Location removed successfully.");

        } else {

            System.out.println(
                    "Location not found.");
        }
    }

    static void addCampusConnection() {

        System.out.println(
                "\n===== ADD CAMPUS CONNECTION =====");

        String location1 =
                readText("Enter first location: ");

        String location2 =
                readText("Enter second location: ");

        if (campusGraph.addConnection(
                location1, location2)) {

            System.out.println(
                    "Connection added successfully.");

        } else {

            System.out.println(
                    "Unable to add connection.");
        }
    }

    static void removeCampusConnection() {

        System.out.println(
                "\n===== REMOVE CAMPUS CONNECTION =====");

        String location1 =
                readText("Enter first location: ");

        String location2 =
                readText("Enter second location: ");

        if (campusGraph.removeConnection(
                location1, location2)) {

            System.out.println(
                    "Connection removed successfully.");

        } else {

            System.out.println(
                    "Connection not found.");
        }
    }

    static void bfsCampus() {

        System.out.println(
                "\n===== CAMPUS BFS =====");

        String start =
                readText("Enter starting location: ");

        campusGraph.bfs(start);
    }

    // ================= INPUT =================

    static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number.");
            }
        }
    }

    static String readText(String message) {

        while (true) {

            System.out.print(message);

            String value =
                    scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println(
                    "Input cannot be empty.");
        }
    }

    static double readMarks() {

        while (true) {

            try {

                System.out.print(
                        "Enter Marks (0-100): ");

                double marks =
                        Double.parseDouble(
                                scanner.nextLine());

                if (marks >= 0 && marks <= 100) {
                    return marks;
                }

                System.out.println(
                        "Marks must be between 0 and 100.");

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid mark.");
            }
        }
    }
}