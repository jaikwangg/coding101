package Lab10;

public class TreeNode {
    int data;
    TreeNode left, right, parent;

    public TreeNode(int d) {
        data = d;
    }

    @Override
    public String toString() {
        String leftString;
        if (left != null) {
            leftString = String.valueOf(left.data);
        } else {
            leftString = "null";
        }

        String rightString;
        if (right != null) {
            rightString = String.valueOf(right.data);
        } else {
            rightString = "null";
        }

        return leftString + "<-" + data + "->" + rightString;
    }
}
