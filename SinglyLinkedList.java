import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    String course;
    Student next;

    Student(int rollNo, String name, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.next = null;
    }
}

public class SinglyLinkedList {

    Student head = null;
    Scanner sc = new Scanner(System.in);
    void insert() {
        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        if (searchNode(rollNo) != null) {
            System.out.println("Student with this Roll Number already exists.");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        Student newNode = new Student(rollNo, name, course);

        if (head == null) {
            head = newNode;
        } else {
            Student temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println("Student inserted successfully.");
    }

    Student searchNode(int rollNo) {
        Student temp = head;

        while (temp != null) {
            if (temp.rollNo == rollNo) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    void search() {
        System.out.print("Enter Roll Number to search: ");
        int rollNo = sc.nextInt();

        Student student = searchNode(rollNo);

        if (student != null) {
            System.out.println("\nStudent Found!");
            System.out.println("Roll Number : " + student.rollNo);
            System.out.println("Name        : " + student.name);
            System.out.println("Course      : " + student.course);
        } else {
            System.out.println("Student not found.");
        }
    }

    void delete() {
        System.out.print("Enter Roll Number to delete: ");
        int rollNo = sc.nextInt();

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student deleted successfully.");
            return;
        }

        Student temp = head;

        while (temp.next != null &&
               temp.next.rollNo != rollNo) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student deleted successfully.");
        }
    }

    void update() {
        System.out.print("Enter Roll Number to update: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        Student student = searchNode(rollNo);

        if (student != null) {
            System.out.print("Enter New Name: ");
            student.name = sc.nextLine();

            System.out.print("Enter New Course: ");
            student.course = sc.nextLine();

            System.out.println("Student record updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
    void display() {
        if (head == null) {
            System.out.println("No student registrations available.");
            return;
        }

        Student temp = head;

        System.out.println("\n===== Student Registration List =====");

        while (temp != null) {
            System.out.println("Roll Number : " + temp.rollNo);
            System.out.println("Name        : " + temp.name);
            System.out.println("Course      : " + temp.course);
            System.out.println("------------------------------------");

            temp = temp.next;
        }
    }
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n========== STUDENT REGISTRATION ==========");
            System.out.println("1. Insert Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Display Students");
            System.out.println("6. Exit");
            System.out.println("==========================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    list.insert();
                    break;

                case 2:
                    list.delete();
                    break;

                case 3:
                    list.search();
                    break;

                case 4:
                    list.update();
                    break;

                case 5:
                    list.display();
                    break;

                case 6:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}