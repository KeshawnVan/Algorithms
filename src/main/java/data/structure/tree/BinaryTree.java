package data.structure.tree;

import data.structure.stack.LinkedStack;
import data.structure.stack.Stack;

import java.util.HashMap;
import java.util.Map;

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

    default void noneRecursionPre(TreeNode<T> node) {
        Stack<TreeNode<T>> stack = new LinkedStack<>();
        while (node != null || stack.peek() != null) {
            while (node != null) {
                System.out.println(node.data);
                stack.push(node);
                node = getLeft(node);
            }
            if (stack.peek() != null) {
                node = getRight(stack.pop());
            }
        }
    }

    default void noneRecursionIn(TreeNode<T> node) {
        Stack<TreeNode<T>> stack = new LinkedStack<>();
        while (node != null || stack.peek() != null) {
            while (node != null) {
                stack.push(node);
                node = getLeft(node);
            }

            if (stack.peek() != null) {
                TreeNode<T> pop = stack.pop();
                System.out.println(pop.data);
                node = getRight(pop);
            }
        }
    }

    default void noneRecursionPost(TreeNode<T> node) {
        Stack<TreeNode<T>> stack = new LinkedStack<>();
        Map<TreeNode<T>, Boolean> visited = new HashMap<>();
        while (node != null || stack.peek() != null) {
            while (node != null) {
                stack.push(node);
                node = getLeft(node);
            }
            if (stack.peek() != null) {
                TreeNode<T> peek = stack.peek();
                if (visited.get(peek) == null) {
                    node = getRight(peek);
                    visited.put(peek, Boolean.TRUE);
                } else {
                    System.out.println(stack.pop().data);
                }
            }
        }


    }
}
