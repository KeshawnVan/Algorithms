package data.structure.tree;

public class BinarySearchTree<T extends Comparable> implements BinaryTree<T>{

    private BinaryTree<T> binaryTree = new ArrayBinaryTree<>();

    @Override
    public TreeNode<T> getLeft(TreeNode<T> node) {
        return binaryTree.getLeft(node);
    }

    @Override
    public TreeNode<T> getRight(TreeNode<T> node) {
        return binaryTree.getRight(node);
    }

    @Override
    public TreeNode<T> setLeft(TreeNode<T> parent, TreeNode<T> left) {
        return binaryTree.setLeft(parent, left);
    }

    @Override
    public TreeNode<T> setRight(TreeNode<T> parent, TreeNode<T> right) {
        return binaryTree.setRight(parent, right);
    }

    @Override
    public TreeNode<T> getRoot() {
        return binaryTree.getRoot();
    }

    @Override
    public TreeNode<T> setRoot(TreeNode<T> node) {
        return binaryTree.setRoot(node);
    }

    @Override
    public TreeNode<T> getParent(TreeNode<T> node) {
        return binaryTree.getParent(node);
    }
}
