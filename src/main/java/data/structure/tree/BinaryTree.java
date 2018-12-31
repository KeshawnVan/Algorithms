package data.structure.tree;

public interface BinaryTree<T> extends Tree<T> {

    TreeNode<T> getLeft(TreeNode<T> node);

    TreeNode<T> getRight(TreeNode<T> node);

    TreeNode<T> setLeft(TreeNode<T> parent, T data);

    TreeNode<T> setRight(TreeNode<T> parent, T data);

    default void preTraversing(TreeNode<T> node) {
        if (node == null) return;
        System.out.println(node.data);
        preTraversing(getLeft(node));
        preTraversing(getRight(node));
    }

    default void inTraversing(TreeNode<T> node) {
        if (node == null) return;
        inTraversing(getLeft(node));
        System.out.println(node.data);
        inTraversing(getRight(node));
    }

    default void postTraversing(TreeNode<T> node) {
        if (node == null) return;
        postTraversing(getLeft(node));
        postTraversing(getRight(node));
        System.out.println(node.data);
    }

}
