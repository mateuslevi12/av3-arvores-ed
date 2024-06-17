
import collections.RecursiveBinarySearchTree;
import collections.RecursiveBinarySearchTree;
import collections.BinarySearchTree;

public class App {
    public static void main(String[] args) throws Exception {
        RecursiveBinarySearchTree<Integer> bst = new RecursiveBinarySearchTree<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(80);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(90);
        bst.insert(10);
        bst.insert(11);

        bst.treeTraversal();
        bst.deleteInOrder();
        System.out.println();
        bst.treeTraversal();

    }
}
