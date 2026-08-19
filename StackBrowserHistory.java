import java.util.Scanner;

public class StackBrowserHistory {

    
    String[] history = new String[5];

    
    int top = -1;

    
    void push(String url) {

        if (top == history.length - 1) {
            System.out.println("History is full!");
            return;
        }

        top++;
        history[top] = url;

        System.out.println("Visited: " + url);
    }

    
    void pop() {

        if (top == -1) {
            System.out.println("History is empty!");
            return;
        }

        System.out.println("Going back from: " + history[top]);
        top--;
    }

    
    void peek() {

        if (top == -1) {
            System.out.println("History is empty!");
            return;
        }

        System.out.println("Current page: " + history[top]);
    }

    
    void display() {

        if (top == -1) {
            System.out.println("History is empty!");
            return;
        }

        System.out.println("\nBrowser History:");

        for (int i = 0; i <= top; i++) {
            System.out.println(history[i]);
        }
    }

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StackBrowserHistory browser = new StackBrowserHistory();

        int choice;

        do {
            System.out.println("\n===== BROWSER HISTORY =====");
            System.out.println("1. Visit New Page");
            System.out.println("2. Go Back");
            System.out.println("3. Show Current Page");
            System.out.println("4. Display History");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter URL: ");
                    String url = sc.nextLine();

                    browser.push(url);
                    break;

                case 2:
                    browser.pop();
                    break;

                case 3:
                    browser.peek();
                    break;

                case 4:
                    browser.display();
                    break;

                case 5:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}