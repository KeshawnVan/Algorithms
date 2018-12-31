package data.structure.tree;

public interface Tree<T> {

    TreeNode<T> getRoot();

    TreeNode<T> setRoot(T node);

    TreeNode<T> getParent(TreeNode<T> node);

}
