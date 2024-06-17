package collections;

public class RecursiveBinarySearchTree<E> extends AbstractTree<E> {

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        clear(root);
        System.out.println(root.value);
        size = 0;
        root = null;
    }

    private void clear(Node current) {
        if (current.left != null) {
            clear(current.left);
            System.out.println(current.left.value);
            current.left = null;
        }
        if (current.right != null) {
            clear(current.right);
            System.out.println(current.right.value);
            current.right = null;
        }
        
    }

    private Node contains(E value, Node current) {
        if (current == null) {
            return null;
        }

        if (compare(value, current) < 0) {
            current = contains(value, current.left);
        } else if (compare(value, current) > 0) {
            current = contains(value, current.right);
        }
        return current;
    }

    private Node minNode(Node current){
        if(current.left == null){
            return current;
        }
        return minNode(current.left);
    }

    private Node maxNode(Node current){
        if(current.right == null){
            return current;
        }
        return maxNode(current.right);
    }

    @Override
    public boolean contains(E value) {

        return contains(value, root) != null;
    }

    private Node delete(E value, Node current) {
        if (current == null) {
            return null;
        }

        if (compare(value, current) < 0) {
            current.left = delete(value, current.left);
        } else if (compare(value, current) > 0) {
            current.right = delete(value, current.right);
        } else {
            if (current.left == null && current.right == null) {
                size--;
                current = null;
            } else if (current.left != null && current.right != null) {
                //CIRILICA
                //current.value = minNode(current.right).value;
                //current.right = delete(current.value, current.right);

                current.value = this.maxNode(current.left).value;
                current.left = delete(current.value, current.left);
                
            } else {
                size--;
                current = current.left != null ? current.left : current.right;
            }
        }
        return current;
    }

    public void printNodesInLevel(int level) {
        printNodesInLevel(level, 0, root);
    }

    private void printNodesInLevel(int level, int currentLevel, Node current) {
        if (current == null) {
            return;
        }

        if (currentLevel == level) {
            System.out.println(current.value);
        }
        else {
            printNodesInLevel(level, currentLevel + 1, current.left);
            printNodesInLevel(level, currentLevel + 1, current.right);
        }
    }

    @Override
    public E delete(E value) {
        int previousSize = size;
        root = delete(value, root);
        if(previousSize!=size){
            return value;
        }
        return null;
    }

    @Override
    public E get(E value) {
        return get(value, root);
    }

    public E get(E value, Node current) {
        if (current == null) {
            return null;
        }

        if (compare(value, current.value) < 0) {
            return get(value, current.left);
        }
        else if (compare(value, current.value) > 0) {
            return get(value, current.right);
        }
        else {
            return value;
        }
    }

    private Node insert(E value, Node current) {
        if (current == null) {
            size++;
            return new Node(value);
        }
        if (compare(value, current) < 0) {
            current.left = insert(value, current.left);
        } else if (compare(value, current) > 0) {
            current.right = insert(value, current.right);
        }
        return current;
    }

    private void preOrder(Node current){
        if(current!=null){
            System.out.print(current.value + " ");
            preOrder(current.left);
            preOrder(current.right);
            
        }
    }
    private void postOrder(Node current){
        if(current!=null){
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(current.value + " ");
            
        }
    }
    private void inOrder(Node current){
        if(current!=null){
            inOrder(current.right);
            System.out.print(current.value + " ");            
            inOrder(current.left);
        }
    }

    public void treeTraversal(String type){
        if(type.equals("inOrder")){
            inOrder(root);
        }else if(type.equals("postOrder")){
            postOrder(root);
        }else{
            treeTraversal();
        }
    }
    
    @Override
    public void insert(E value) {
        root = insert(value, root);
    }

    @Override
    public void treeTraversal() {
        preOrder(root);

    }

    @Override
    public String toString() {
        return "RecursiveBinarySearchTree []";
    }

}
