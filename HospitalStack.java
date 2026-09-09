import java.util.Scanner;

class Patient {
    int patientId;
    String name;
    String emergency;
    Patient next;

    Patient(int patientId, String name, String emergency) {
        this.patientId = patientId;
        this.name = name;
        this.emergency = emergency;
        this.next = null;
    }
}

public class HospitalStack {

    Patient top = null;

    Scanner sc = new Scanner(System.in);

    // PUSH operation
    void push() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Emergency Type: ");
        String emergency = sc.nextLine();

        Patient newPatient = new Patient(id, name, emergency);

        newPatient.next = top;
        top = newPatient;

        System.out.println("Patient record added successfully.");
    }

    // POP operation
    void pop() {

        if (top == null) {
            System.out.println("Stack is empty. No patient records available.");
            return;
        }

        System.out.println("\nProcessing Patient:");
        System.out.println("Patient ID    : " + top.patientId);
        System.out.println("Patient Name  : " + top.name);
        System.out.println("Emergency     : " + top.emergency);

        top = top.next;

        System.out.println("Patient record removed from stack.");
    }

    // PEEK operation
    void peek() {

        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("\nPatient at TOP:");
        System.out.println("Patient ID    : " + top.patientId);
        System.out.println("Patient Name  : " + top.name);
        System.out.println("Emergency     : " + top.emergency);
    }

    // DISPLAY operation
    void display() {

        if (top == null) {
            System.out.println("No patient records available.");
            return;
        }

        Patient temp = top;

        System.out.println("\n===== EMERGENCY PATIENT RECORDS =====");

        while (temp != null) {

            System.out.println("Patient ID    : " + temp.patientId);
            System.out.println("Patient Name  : " + temp.name);
            System.out.println("Emergency     : " + temp.emergency);
            System.out.println("-------------------------------------");

            temp = temp.next;
        }
    }

    // Main method
    public static void main(String[] args) {

        HospitalStack stack = new HospitalStack();

        int choice;

        do {
            System.out.println("\n========== HOSPITAL EMERGENCY STACK ==========");
            System.out.println("1. Add Patient Record (PUSH)");
            System.out.println("2. Process Patient (POP)");
            System.out.println("3. View Top Patient (PEEK)");
            System.out.println("4. Display All Patients");
            System.out.println("5. Exit");
            System.out.println("===============================================");

            System.out.print("Enter your choice: ");
            choice = stack.sc.nextInt();

            switch (choice) {

                case 1:
                    stack.push();
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
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);

        stack.sc.close();
    }
}
