package data.structure.tree;

public interface BinarySearchTree<T extends Comparable> extends BinaryTree<T>{

    TreeNode<T> find(T data);

    TreeNode<T> insert(T data);

    void delete(T data);
}
