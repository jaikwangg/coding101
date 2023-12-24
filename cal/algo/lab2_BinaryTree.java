import java.util.Scanner;

class TreeNode {
    int data;
    TreeNode left, right, parent;

    public TreeNode(int data) {
        this.data = data;
        left = right = parent = null;
    }
}

public class lab2_BinaryTree {
    TreeNode root;

    public lab2_BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            insertRecursive(root, data);
        }
    }

    private void insertRecursive(TreeNode node, int data) {
        if (data < node.data) {
            if (node.left != null) {
                insertRecursive(node.left, data);
            } else {
                node.left = new TreeNode(data);
                node.left.parent = node;
            }
        } else {
            if (node.right != null) {
                insertRecursive(node.right, data);
            } else {
                node.right = new TreeNode(data);
                node.right.parent = node;
            }
        }
    }

    public void printInOrder() {
        printInOrderRecursive(root);
        System.out.println();
    }

    private void printInOrderRecursive(TreeNode node) {
        if (node != null) {
            printInOrderRecursive(node.left);
            System.out.print(node.data + " ");
            printInOrderRecursive(node.right);
        }
    }

    public int findMax() {
        return findMaxRecursive(root);
    }

    private int findMaxRecursive(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE; 
        }
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    public int findMin() {
        return findMinRecursive(root);
    }

    private int findMinRecursive(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE; 
        }
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    public static void main(String[] args) {
        lab2_BinaryTree binaryTree = new lab2_BinaryTree();

        //65050776
        // int[] data = {12 ,76 ,32 ,75 ,16 ,45 ,39 ,86 ,23 ,77};

        Scanner scanner = new Scanner(System.in);

        // Input
        int[] data = new int[10];
        System.out.println("input data : (12 ,76 ,32 ,75 ,16 ,45 ,39 ,86 ,23 ,77)");
        for (int i = 0; i < data.length; i++) {
            data[i] = scanner.nextInt();
        }
        
        System.out.println("insert data to binary tree :");
        for (int value : data) {
            binaryTree.insert(value);
            binaryTree.printInOrder();
        }
        
        System.out.println("Max value: " + binaryTree.findMax());
        System.out.println("Min value: " + binaryTree.findMin());
        scanner.close();
    }
}
