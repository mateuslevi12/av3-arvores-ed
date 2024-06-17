import collections.AVLTree;
import collections.BinarySearchTree;
import collections.RecursiveBinarySearchTree;

public class App {
    public static void main(String[] args) throws Exception {
      RecursiveBinarySearchTree<Integer> avl = new RecursiveBinarySearchTree<>();
      avl.insert(80);
      avl.insert(25);
      avl.insert(150);
      avl.insert(5);
      avl.treeTraversal("postOrder");
      System.out.println();
      avl.clear();
      System.out.println("ddd");
      avl.treeTraversal("postOrder");
      System.out.println();

      // bst.treeTraversal();
      // System.out.println(bst);

    }
}
