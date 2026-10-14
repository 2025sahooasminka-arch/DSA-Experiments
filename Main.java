import java.util.Scanner;

class Node {
    int rollNo;
    Node left, right;

    Node(int rollNo) {
        this.rollNo = rollNo;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    Node insert(Node root, int rollNo) {
        if (root == null) {
            return new Node(rollNo);
        }

        if (rollNo < root.rollNo) {
            root.left = insert(root.left, rollNo);
        } else if (rollNo > root.rollNo) {
            root.right = insert(root.right, rollNo);
        }

        return root;
    }

    boolean search(Node root, int rollNo) {
        if (root == null) {
            return false;
        }

        if (root.rollNo == rollNo) {
            return true;
        }

        if (rollNo < root.rollNo) {
            return search(root.left, rollNo);
        }

        return search(root.right, rollNo);
    }

    Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    Node delete(Node root, int rollNo) {
        if (root == null) {
            return null;
        }

        if (rollNo < root.rollNo) {
            root.left = delete(root.left, rollNo);
        } else if (rollNo > root.rollNo) {
            root.right = delete(root.right, rollNo);
        } else {
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            Node successor = findMin(root.right);
            root.rollNo = successor.rollNo;
            root.right = delete(root.right, successor.rollNo);
        }

        return root;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.rollNo + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.rollNo + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.rollNo + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        int choice, rollNo;

        do {
            System.out.println("\\n===== STUDENT BST MENU =====");
            System.out.println("1. Insert Student Roll Number");
            System.out.println("2. Search Student Roll Number");
            System.out.println("3. Delete Student Roll Number");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Preorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter roll number to insert: ");
                    rollNo = sc.nextInt();

                    if (bst.search(bst.root, rollNo)) {
                        System.out.println("Roll number already exists!");
                    } else {
                        bst.root = bst.insert(bst.root, rollNo);
                        System.out.println("Student roll number inserted successfully.");
                    }
                    break;

                case 2:
                    System.out.print("Enter roll number to search: ");
                    rollNo = sc.nextInt();

                    if (bst.search(bst.root, rollNo)) {
                        System.out.println("Student found in the BST.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter roll number to delete: ");
                    rollNo = sc.nextInt();

                    if (bst.search(bst.root, rollNo)) {
                        bst.root = bst.delete(bst.root, rollNo);
                        System.out.println("Student roll number deleted successfully.");
                    } else {
                        System.out.println("Roll number not found.");
                    }
                    break;

                case 4:
                    if (bst.root == null) {
                        System.out.println("BST is empty.");
                    } else {
                        System.out.print("Inorder Traversal: ");
                        bst.inorder(bst.root);
                        System.out.println();
                    }
                    break;

                case 5:
                    if (bst.root == null) {
                        System.out.println("BST is empty.");
                    } else {
                        System.out.print("Preorder Traversal: ");
                        bst.preorder(bst.root);
                        System.out.println();
                    }
                    break;

                case 6:
                    if (bst.root == null) {
                        System.out.println("BST is empty.");
                    } else {
                        System.out.print("Postorder Traversal: ");
                        bst.postorder(bst.root);
                        System.out.println();
                    }
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);

        sc.close();
    }
}