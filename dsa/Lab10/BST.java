package Lab10;

public class BST {
    TreeNode root;

    public BST() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int d) {
        if (root == null) {
            root = new TreeNode(d);
        } else {
            TreeNode cur = root;
            while (cur != null) {
                if (d < cur.data) {
                    if (cur.left != null) {
                        cur = cur.left;
                    } else {
                        cur.left = new TreeNode(d);
                        cur.left.parent = cur;
                        return;
                    }
                } else { // (d >= cur.data)
                    if (cur.right != null) {
                        cur = cur.right;
                    } else {
                        cur.right = new TreeNode(d);
                        cur.right.parent = cur;
                        return;
                    }
                }
            }
        }
    }

    public void printPreOrder() {
        printPreOrderRecurse(root);
        System.out.println();
    }

    private void printPreOrderRecurse(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            printPreOrderRecurse(node.left);
            printPreOrderRecurse(node.right);
        }
    }

    public void printInOrder() {
        printInOrderRecurse(root);
        System.out.println();
    }

    private void printInOrderRecurse(TreeNode node) {
        if (node != null) {
            printInOrderRecurse(node.left);
            System.out.print(node.data + " ");
            printInOrderRecurse(node.right);
        }
    }

    public void printPostOrder() {
        printPostOrderRecurse(root);
        System.out.println();
    }

    private void printPostOrderRecurse(TreeNode node) {
        if (node != null) {
            printPostOrderRecurse(node.left);
            printPostOrderRecurse(node.right);
            System.out.print(node.data + " ");
        }
    }

    public TreeNode search(int d) {
        TreeNode result = searchRecurse(d, root);
        return result;
    }

    public TreeNode searchRecurse(int d, TreeNode n) {
        if (n == null) return null;
        if (d == n.data) {
            System.out.println(n);
            return n;
        }
        if (d < n.data) {
            System.out.println(n);
            return searchRecurse(d, n.left);
        } else {
            System.out.println(n);
            return searchRecurse(d, n.right);
        }
    }

    public TreeNode searchIter(int key) {
        TreeNode current = root;
        while (current != null) {
            if (key == current.data) {
                System.out.println(current);
                return current;
            } else if (key < current.data) {
                System.out.println(current);
                current = current.left;
            } else {
                System.out.println(current);
                current = current.right;
            }
        }
        return null;
    }
}
