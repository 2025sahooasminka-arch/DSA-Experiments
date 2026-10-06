import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularSinglyLinkedList {
    private Node tail;

    public CircularSinglyLinkedList() {
        this.tail = null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
        System.out.println("Player " + data + " added at start.");
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("Player " + data + " added at the end.");
    }

    public void deleteByValue(int data) {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = tail.next;
        Node previous = tail;
        boolean found = false;

        do {
            if (current.data == data) {
                found = true;
                break;
            }
            previous = current;
            current = current.next;
        } while (current != tail.next);

        if (found) {
            if (current == tail && current.next == tail) {
                tail = null;
            } else {
                previous.next = current.next;
                if (current == tail) {
                    tail = previous;
                }
            }
            System.out.println("Player " + data + " removed.");
        } else {
            System.out.println("Player " + data + " not found.");
        }
    }

    public void display() {
        if (tail == null) {
            System.out.println("No players in the circle.");
            return;
        }

        Node current = tail.next;
        System.out.print("Players in turn order: ");
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != tail.next);
        System.out.println("(back to first player: " + tail.next.data + ")");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        int choice = 0;

        do {
            System.out.println("CIRCULAR SINGLY LINKED LIST MENU");
            System.out.println("1. Insert Player at Beginning");
            System.out.println("2. Insert Player at End");
            System.out.println("3. Delete Player by Value");
            System.out.println("4. Display Players");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Player ID to insert at beginning: ");
                    if (scanner.hasNextInt()) {
                        csll.insertAtBeginning(scanner.nextInt());
                    } else {
                        System.out.println("Invalid input.");
                        scanner.next();
                    }
                    break;
                case 2:
                    System.out.print("Enter Player ID to insert at end: ");
                    if (scanner.hasNextInt()) {
                        csll.insertAtEnd(scanner.nextInt());
                    } else {
                        System.out.println("Invalid input.");
                        scanner.next();
                    }
                    break;
                case 3:
                    System.out.print("Enter Player ID to delete: ");
                    if (scanner.hasNextInt()) {
                        csll.deleteByValue(scanner.nextInt());
                    } else {
                        System.out.println("Invalid input.");
                        scanner.next();
                    }
                    break;
                case 4:
                    csll.display();
                    break;
                case 5:
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}