package collections;

public interface Tree<E> {
    void insert(E value); // adiciona
    boolean contains(E value); // verifica se o valor esta na arvore
    E get(E value); //pega o valor
    E delete(E value); // exclui da arvore
    int size();
    boolean isEmpty();
    void clear();
    void treeTraversal();
}
