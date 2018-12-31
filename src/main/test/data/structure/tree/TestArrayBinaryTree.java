package data.structure.tree;

import org.junit.jupiter.api.Test;

public class TestArrayBinaryTree {

    private BinaryTree<String> arrayBinaryTree = new ArrayBinaryTree<>();

    {
        TreeNode<String> root = arrayBinaryTree.setRoot("A");

        TreeNode<String> b = arrayBinaryTree.setLeft(root, "B");
        TreeNode<String> c = arrayBinaryTree.setRight(root, "C");

        arrayBinaryTree.setLeft(b, "D");
        arrayBinaryTree.setRight(b, "E");

        arrayBinaryTree.setLeft(c, "F");
        arrayBinaryTree.setRight(c, "G");
    }

    @Test
    public void preTraversing() {
        arrayBinaryTree.preTraversing(arrayBinaryTree.getRoot());
    }

    @Test
    public void inTraversing() {
        arrayBinaryTree.inTraversing(arrayBinaryTree.getRoot());
    }

    @Test
    public void postTraversing() {
        arrayBinaryTree.postTraversing(arrayBinaryTree.getRoot());
    }
}
