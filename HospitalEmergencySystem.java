import java.util.Scanner;

class PatientNode {
    int patientId;
    String name;
    String condition;
    PatientNode next;

    public PatientNode(int patientId, String name, String condition) {
        this.patientId = patientId;
        this.name = name;
        this.condition = condition;
        this.next = null;
    }
}

class EmergencyStack {
    private PatientNode top;

    public EmergencyStack() {
        this.top = null;
    }

    public void push(int patientId, String name, String condition) {
        PatientNode newNode = new PatientNode(patientId, name, condition);
        newNode.next = top;
        top = newNode;
        System.out.println("Patient " + name + " (ID: " + patientId + ") admitted successfully.");
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("No patients in the queue to process.");
            return;
        }
        System.out.println("Processing/Treating Patient: " + top.name + " (ID: " + top.patientId + ") - Condition: " + top.condition);
        top = top.next;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("No patients currently waiting.");
            return;
        }
        System.out.println("Next Patient for Immediate Treatment: ID " + top.patientId + " | Name: " + top.name + " | Condition: " + top.condition);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Emergency record stack is empty.");
            return;
        }
        System.out.println("Current Emergency Patients (Top to Bottom) ");
        PatientNode current = top;
        while (current != null) {
            System.out.println("ID: " + current.patientId + " | Name: " + current.name + " | Condition: " + current.condition);
            current = current.next;
        }
        System.out.println("--------------------------------------------------");
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class HospitalEmergencySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmergencyStack stack = new EmergencyStack();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=================================");
            System.out.println(" HOSPITAL EMERGENCY STACK SYSTEM ");
            System.out.println("=================================");
            System.out.println("1. Admit Emergency Patient (Push)");
            System.out.println("2. Process Immediate Patient (Pop)");
            System.out.println("3. View Next Patient (Peek)");
            System.out.println("4. Display All Patient Records");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Patient Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Condition/Triage Status: ");
                    String condition = scanner.nextLine();
                    stack.push(id, name, condition);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.peek();
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting Emergency System. Stay safe!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 5.");
            }
        }
        scanner.close();
    }
}