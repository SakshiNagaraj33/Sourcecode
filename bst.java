import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.data) {
            root.left = insertRecursive(root.left, value);
        } else if (value > root.data) {
            root.right = insertRecursive(root.right, value);
        }

        return root;
    }

    public boolean search(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (value == root.data) {
            return true;
        } else if (value < root.data) {
            return searchRecursive(root.left, value);
        } else {
            return searchRecursive(root.right, value);
        }
    }

    public void inorderTraversal() {
        inorderRecursive(root);
    }

    private void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.data + " ");
            inorderRecursive(root.right);
        }
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder Traversal:");
        bst.inorderTraversal();

        System.out.println("\nSearch for 30: " + bst.search(30));
        System.out.println("Search for 90: " + bst.search(90));
    }
}
