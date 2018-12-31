package data.structure.tree;

public class LinkedBinarySearchTree<T extends Comparable> implements BinarySearchTree<T> {

    private LinkedBinaryTree<T> binaryTree = new LinkedBinaryTree<>();

    @Override
    public String toString() {
        return "LinkedBinarySearchTree{" +
                "binaryTree=" + binaryTree +
                '}';
    }

    @Override
    public TreeNode<T> find(T data) {
        return find(getRoot(), data);
    }

    private TreeNode<T> find(TreeNode<T> node, T data) {
        if (node == null || node.data.equals(data)) return node;
        return node.data.compareTo(data) > 0 ? find(getLeft(node), data) : find(getRight(node), data);
    }

    @Override
    public TreeNode<T> insert(T data) {
        return insert(getRoot(), data);
    }

    private TreeNode<T> insert(TreeNode<T> node, T data) {
        if (node == null) return setRoot(data);
        if (node.data.compareTo(data) > 0)
            return getLeft(node) == null ? setLeft(node, data) : insert(getLeft(node), data);
        if (node.data.compareTo(data) < 0)
            return getRight(node) == null ? setRight(node, data) : insert(getRight(node), data);
        throw new IllegalArgumentException();
    }

    @Override
    public void delete(T data) {
        TreeNode<T> node = find(data);
        if (node == null) return;

        TreeNode<T> left = getLeft(node);
        TreeNode<T> right = getRight(node);
        TreeNode<T> parent = getParent(node);

        removeLeafNode(data, left, right, parent);

        if (left != null && right == null) {
            if (parent == null) {
                binaryTree.setRoot(left);
            } else {
                LinkedBinaryTreeNode<T> parentNode = binaryTree.mapWithCheck(parent, x -> x);
                LinkedBinaryTreeNode<T> leftNode = binaryTree.mapWithCheck(left, x -> x);
                parentNode.setLeft(leftNode);
            }
        }

        if (left == null && right != null) {
            if (parent == null) {
                binaryTree.setRoot(right);
            } else {
                LinkedBinaryTreeNode<T> parentNode = binaryTree.mapWithCheck(parent, x -> x);
                LinkedBinaryTreeNode<T> rightNode = binaryTree.mapWithCheck(right, x -> x);
                parentNode.setRight(rightNode);
            }
        }

        if (left != null && right != null) {
            TreeNode<T> minNode = getMinNode(right);
            node.setData(minNode.data);
            removeByParent(minNode.data, getParent(minNode));
        }
    }

    private TreeNode<T> getMinNode(TreeNode<T> node) {
        TreeNode<T> left = getLeft(node);
        return left == null ? node : getMinNode(left);
    }

    private void removeLeafNode(T data, TreeNode<T> left, TreeNode<T> right, TreeNode<T> parent) {
        if (left == null && right == null) {
            if (parent == null) {
                setRoot(null);
            } else {
                removeByParent(data, parent);
            }
        }
    }

    private void removeByParent(T data, TreeNode<T> parent) {
        if (parent == null) {
            setRoot(null);
        } else if (parent.data.compareTo(data) > 0) {
            setLeft(parent, null);

        } else if (parent.data.compareTo(data) < 0) {
            setRight(parent, null);
        }
    }

    @Override
    public TreeNode<T> getLeft(TreeNode<T> node) {
        return binaryTree.getLeft(node);
    }

    @Override
    public TreeNode<T> getRight(TreeNode<T> node) {
        return binaryTree.getRight(node);
    }

    @Override
    public TreeNode<T> setLeft(TreeNode<T> parent, T data) {
        return binaryTree.setLeft(parent, data);
    }

    @Override
    public TreeNode<T> setRight(TreeNode<T> parent, T data) {
        return binaryTree.setRight(parent, data);
    }

    @Override
    public TreeNode<T> getRoot() {
        return binaryTree.getRoot();
    }

    @Override
    public TreeNode<T> setRoot(T node) {
        return binaryTree.setRoot(node);
    }

    @Override
    public TreeNode<T> getParent(TreeNode<T> node) {
        return binaryTree.getParent(node);
    }
}
