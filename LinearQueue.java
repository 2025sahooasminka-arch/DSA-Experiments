import java.util.Scanner;

class LinearQueue {
    int N = 10;
    int queue[] = new int[N];
    int front = -1;
    int rear = -1;

    void enqueue(int customer) {
        if (rear == N - 1) {
            System.out.println("Queue is Full!");
        } 
        else if (front == -1 && rear == -1) {
            front = rear = 0;
            queue[rear] = customer;
            System.out.println("Customer " + customer + " has been added.");
        } 
        else {
            rear++;
            queue[rear] = customer;
            System.out.println("Customer " + customer + " has been added.");
        }
    }

    void dequeue() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is Empty!");
        } 
        else if (front == rear) {
            System.out.println("Serving Customer " + queue[front] + ".");
            front = rear = -1;
        } 
        else {
            System.out.println("Serving Customer " + queue[front] + ".");
            front++;
        }
    }

    void peek() {
        if (front == -1 && rear == -1) {
            System.out.println("No customers in the queue.");
        } 
        else {
            System.out.println("Next customer: " + queue[front]);
        }
    }

    void display() {
        if (front == -1 && rear == -1) {
            System.out.println("No customers in the queue.");
        } 
        else {
            System.out.println("Current customers:");

            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinearQueue q = new LinearQueue();

        int choice;
        int customer;

        do {
            System.out.println("\n===== RAILWAY RESERVATION SYSTEM =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Serve Customer");
            System.out.println("3. View Next Customer");
            System.out.println("4. Show Queue");
            System.out.println("5. Close Program");
            System.out.print("Select an option: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter customer ID: ");
                    customer = sc.nextInt();
                    q.enqueue(customer);
                    break;

                case 2:
                    q.dequeue();
                    break;

                case 3:
                    q.peek();
                    break;

                case 4:
                    q.display();
                    break;

                case 5:
                    System.out.println("Thank you! Program closed.");
                    break;

                default:
                    System.out.println("Please enter a valid option!");
            }

        } while (choice != 5);

        sc.close();
    }
}