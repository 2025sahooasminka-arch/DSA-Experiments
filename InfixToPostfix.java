import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    // Returns the priority of an operator
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
            case '%':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    // Converts infix expression to postfix
    static String convertToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // If operand, add it to postfix
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }

            // If opening bracket, push it
            else if (ch == '(') {
                stack.push(ch);
            }

            // If closing bracket, pop until '('
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            }

            // If operator
            else {
                while (!stack.isEmpty() &&
                       precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter infix expression: ");
        String infix = sc.nextLine();

        String postfix = convertToPostfix(infix);

        System.out.println("Postfix expression: " + postfix);

        sc.close();
    }
}
