
public class Lab10_DSA_650776{
    public static void main(String[] args) {
        System.out.println("--demo1--");
        demo1();
    }
    public static void demo1() {
        System.out.println("-insert and preOrder traversal-");
        int[] dat = { 15, 20, 10, 18, 16,
        12, 8, 25, 19, 30 };
        BST bst = new BST();
        for (int j = 0; j < dat.length; j++)
        bst.insert(dat[j]);
        // System.out.println(bst);
        bst.printPreOrder();
        //8 10 12 15 16 18 19 20 25 30
        System.out.println();
        //demo2(bst);
    }
}
class BST {
    TreeNode root;
    public BST() { root = null; }
    // public TreeNode getRoot() {
    // return root;
    // }
    public void insert(int d) {
        if (root == null) {
            root = new TreeNode(d);
        } else {
            TreeNode cur = root;
            while (cur != null) {
                if (d < cur.data) {
                    if (cur.left != null){
                        cur = cur.left;
                    }
                    else {
                        cur.left = new TreeNode(d);
                        cur.left.parent = cur;
                        return;
                    }
                } else { //! (d < p.data)
                    if (cur.right != null)
                        cur = cur.right;
                    else {
                        cur.right = new TreeNode(d);
                        cur.right.parent = cur;
                        return;
                    }
                }
            } //while
        }
    } //insert by iteration
    public void printPreOrder() {
        printPreOrderRecurse(root);
    }
    private void printPreOrderRecurse(TreeNode node) { 
        System.out.print(node.data + " ");
        if(node.left != null){
            printPreOrderRecurse(node.left);
        }
        if(node.right != null){
            printPreOrderRecurse(node.right);
        }
    }
    @Override
    public String toString() {
        return "BST [root=" + root + "]";
    }
    
}
class TreeNode {
    int data;
    TreeNode left, right, parent;
    public TreeNode(int d) {
        data = d;
    }
    @Override
    public String toString() {
        String sLeft = "null<-", sRight="->null";
        if(left != null){
            sLeft = left.toString(); 
        }
        if(right != null){
            sRight = right.toString();
        }
        // There are 4 cases no child,
        // left-child-only,
        // right-child-only,
        //and both children
        /* your code 6*/
        return sLeft + data + sRight;
        // no child
    }
}