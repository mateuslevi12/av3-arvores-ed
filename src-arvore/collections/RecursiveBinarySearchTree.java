package collections;

public class RecursiveBinarySearchTree<E> extends AbstractTree<E> {

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    private Node minNode(Node current) {
        if (current.left == null) {
            return current.right;
        }
        return minNode(current.left);

    }

    private Node maxNode(Node current) {
        if (current.right == null) {
            return current.left;
        }
        return minNode(current.right);
    }

    private Node contains(E value, Node current) {
        if (current == null) {
            return null;
        }
        
        int comparacao = compare(value, current);
        if (comparacao < 0) {
            current = contains(value, current.left);
        } else if (comparacao > 0) {
            current = contains(value, current.right);
        }

        return current;

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
                current.value = minNode(current.right).value;
                current.right = delete(current.value, current.right);

            } else {
                size--;
                current = current.left != null ? current.left : current.right;
            }
        }
        return current;
    }

    @Override
    public E delete(E value) {
        int previousSize = size;
        root = delete(value, root);
        if (previousSize != size) {
            return value;
        }
        return null;
    }

    @Override
    public E get(E value) {
        return contains(value, root).value;
    }

    public E getMinNode() {
        return minNode(root).value;
    }

    public E getMaxNode() {
        return maxNode(root).value;
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

    @Override
    public void insert(E value) {
        root = insert(value, root);
    }

    private void postOrder(Node current) {
        if (current != null) {
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(current.value + " ");
        }
    }

    private void preOrder(Node current) {
        if (current != null) {
            System.out.print(current.value + " ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    private void inOrder(Node current) {
        if (current != null) {
            inOrder(current.left);
            System.out.print(current.value + " ");
            inOrder(current.right);
        }
    }

    public void treeTraversal(String type) {
        if (type.equals("postOrder")) {
            postOrder(root);
        } else if (type.equals("inOrder")) {
            inOrder(root);
        } else {
            treeTraversal();
        }
    }

    @Override
    public void treeTraversal() {
        preOrder(root);

    }

    @Override
    public String toString() {
        return "RecursiveBinarySearchTree []";
    }

    private Node deleteMinNode(Node current) {
        if (current.left == null) {
            return current.right;
        }
        current.left = deleteMinNode(current.left);

        return current;
    }

    public void deleteMinNode() {
        if (root != null) {
            root = deleteMinNode(root);
        }
    }

    private Node deleteMaxNode(Node current) {
        if (current.right == null) {
            return current.left;
        }
        current.right = deleteMinNode(current.right);

        return current;
    }

    public void deleteMaxNode() {
        if (root != null) {
            root = deleteMaxNode(root);
        }
    }

    public void deleteInOrder() {
        deleteMaxNode(root.left);
    }

    public int size() {
        return size;
    }

}
