package data.structure.tree;

import org.junit.jupiter.api.Test;

public class TestBinarySearchTree {

    private BinarySearchTree<Integer> binarySearchTree = new LinkedBinarySearchTree<>();

    {
        binarySearchTree.insert(5);
        binarySearchTree.insert(3);
        binarySearchTree.insert(8);
        binarySearchTree.insert(1);
        binarySearchTree.insert(9);
        binarySearchTree.insert(2);
        binarySearchTree.insert(7);
    }

    @Test
    public void testSearch() {
        TreeNode<Integer> node = binarySearchTree.find(2);
        System.out.println(node);
    }

    @Test
    public void deleteLeaf() {
        binarySearchTree.delete(2);
        System.out.println(binarySearchTree);
    }

    @Test
    public void deleteSingleLeaf() {
        binarySearchTree.delete(3);
        binarySearchTree.delete(8);
        System.out.println(binarySearchTree);
    }

    @Test
    public void deleteNodeWhenDoubleLeaf() {
        binarySearchTree.delete(8);
        System.out.println(binarySearchTree);
    }

    @Test
    public void testDeleteRoot() {
        binarySearchTree.delete(5);
        System.out.println(binarySearchTree);
    }
}
