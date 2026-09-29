# University Student Record and Campus Route Management System

## Project Description

This project is a University Student Record and Campus Route Management System developed for the CIT300 Data Structures and Algorithms module.

The system manages student records, service requests, recent actions, and campus locations using different data structures.

## Data Structures Used

* Linked List – manages student records
* Stack – manages recent actions
* Queue – manages service requests
* Binary Search Tree – manages student records using tree traversal
* Hash Table – searches student records using student ID
* Graph – manages campus locations and connections
* BFS – traverses connected campus locations

## Main Features

* Add student records
* Update student records
* Delete student records
* Display student records
* Add and process service requests
* Display recent actions
* Display students using BST
* Search students using hashing
* Add and remove campus locations
* Add and remove campus connections
* Display campus connections
* Traverse campus locations using BFS

## Work Division

### S.F.Asra 23DA2-1171

Main.java, system integration, testing, and documentation

### A.F.Asrifa 23DA2-1046

Student.java and StudentLinkedList.java

### H.H.Hafsa 23DA2-0904

StudentBST.java and StudentHashTable.java

### A.K.F.Sahadiya 23DA2-0972

CampusGraph.java, ActionStack.java, and ServiceQueue.java

## Technologies Used

* Java
* Git
* GitHub
* Visual Studio Code

## How to Run

1. Open the project in Visual Studio Code.
2. Open the terminal.
3. Navigate to the `src` folder.
4. Compile the Java files.
5. Run the Main class.

Example:

```bash
cd src
javac *.java
java Main
```

## Project Structure

```text
University-Student-Record-System
│
├── src
│   ├── Main.java
│   ├── Student.java
│   ├── StudentLinkedList.java
│   ├── ActionStack.java
│   ├── ServiceQueue.java
│   ├── StudentBST.java
│   ├── StudentHashTable.java
│   └── CampusGraph.java
│
├── .gitignore
└── README.md
```

