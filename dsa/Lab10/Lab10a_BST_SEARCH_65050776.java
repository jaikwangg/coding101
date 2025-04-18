package Lab10;

public class Lab10a_BST_SEARCH_65050776{
    public static void main(String[] args) {
        demo1();
    }

    public static void demo1() {
        System.out.println("-insert and preOrder traversal-");
        int[] dat = { 15, 20, 10, 18, 16, 12, 8, 25, 19, 30 };
        BST bst = new BST();
        for (int j = 0; j < dat.length; j++)
            bst.insert(dat[j]);
        bst.printPreOrder();
        System.out.println();
        demo2(bst);
    }

    static void demo2(BST bst) {
        System.out.println("-more traversal---");
        bst.printInOrder();
        System.out.println();
        bst.printPostOrder();
        System.out.println();
        demo3(bst);
    }

    static void demo3(BST bst) {
        System.out.println("-search recursive---");
        System.out.println(bst.search(20)); // 18<-20->25
        System.out.println(bst.search(25)); // null<-25->30
        System.out.println(bst.search(12)); // null<-12->null
        System.out.println(bst.search(1));  // null

        System.out.println(bst.searchRecurse(10, bst.getRoot()));//if searchRecurse and getRoot is available

        System.out.println("-search iterative---");
        System.out.println(bst.searchIter(20));
        System.out.println(bst.searchIter(25));
        System.out.println(bst.searchIter(12));
        System.out.println(bst.searchIter(1));
    }
}
