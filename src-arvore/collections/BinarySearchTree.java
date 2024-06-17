package collections;

public class BinarySearchTree<E> extends AbstractTree<E> {

    @Override
    public void clear() {
        root = null;
        size = 0;

    }

    private Node minNode(Node current) {
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private Node maxNode(Node current) {
        while (current.right != null) {
            current = current.left;
        }
        return current;
    }

    private Node contains(E value, Node root) {
        Node current = root;
        while (current != null) {
            int comparação = compare(value, current);
            if (comparação < 0) {
                current = current.left;
            } else if (comparação > 0) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    @Override
    public boolean contains(E value) {
        return contains(value, root) != null;
    }

    private E removeMinNode(Node parent) {
        Node minNode = parent.right;
        while (minNode.left != null) {
            parent = minNode;
            minNode = minNode.left;
        }

        if (minNode.right != null) {
            if (parent.left == minNode) {
                parent.left = minNode.right;
            } else {
                parent.right = minNode.right;
            }
        } else {
            if (parent.left == minNode) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        return minNode.value;
    }

    @Override
    public E delete(E value) {
        if (isEmpty()) {
            throw new RuntimeException("Tree is empty!");
        }
        Node target = root, parent = null;

        // buscar o nó
        while (target != null && compare(value, target) != 0) {
            parent = target;
            if (compare(value, target) > 0) {
                target = target.right;
            } else {
                target = target.left;
            }
        }

        if (target == null) {
            return null;
        }

        if (target.left == null && target.right == null) {
            if (target == root) {
                root = null;
            } else {
                if (parent.left == target) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        } else if (target.left != null && target.right != null) {
            target.value = removeMinNode(target);
        } else {
            Node child = target.left != null ? target.left : target.right;

            if (target == root) {
                root = child;
            } else {
                if (parent.left == target) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }
        }
        size--;
        return target.value;
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

    @Override
    public void insert(E value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node auxNode = root;
            while (true) {
                if (compare(newNode, auxNode) < 0) {
                    if (auxNode.left == null) {
                        auxNode.left = newNode;
                        break;
                    }
                    auxNode = auxNode.left;
                } else if (compare(newNode, auxNode) > 0) {
                    if (auxNode.right == null) {
                        auxNode.right = newNode;
                        break;
                    }
                    auxNode = auxNode.right;
                } else {
                    return;
                }
            }
        }
        size++;
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private void printLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.value + " ");
        } else if (level > 1) {
            printLevel(root.left, level - 1); 
            printLevel(root.right, level - 1);
        }
    }

    @Override
    public void treeTraversal() {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printLevel(root, i);
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "BinarySearchTree []";
    }

    public int size() {
        return size;
    }

}
