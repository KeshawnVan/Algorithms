package data.structure.tree;

import org.junit.jupiter.api.Test;

public class TestLinkedBinaryTree {

    private BinaryTree<String> binaryTree = new LinkedBinaryTree<>();

    {
        TreeNode<String> root = binaryTree.setRoot("A");

        TreeNode<String> b = binaryTree.setLeft(root, "B");
        TreeNode<String> c = binaryTree.setRight(root, "C");

        binaryTree.setLeft(b, "D");
        binaryTree.setRight(b, "E");

        binaryTree.setLeft(c, "F");
        binaryTree.setRight(c, "G");
    }

    @Test
    public void testLinkedPreTraversing() {
        binaryTree.preTraversing(binaryTree.getRoot());
    }

    @Test
    public void testLinkedInTraversing() {
        binaryTree.inTraversing(binaryTree.getRoot());
    }

    @Test
    public void testLinkedPostTraversing() {
        binaryTree.postTraversing(binaryTree.getRoot());
    }
}
