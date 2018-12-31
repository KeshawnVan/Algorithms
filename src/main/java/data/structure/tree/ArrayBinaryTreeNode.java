package data.structure.tree;

public class ArrayBinaryTreeNode<T> extends TreeNode<T> {

    private Integer index;

    public ArrayBinaryTreeNode() {
    }

    public ArrayBinaryTreeNode(T data) {
        this.data = data;
    }

    public ArrayBinaryTreeNode(Integer index, T data) {
        this.index = index;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ArrayBinaryTreeNode{" +
                "index=" + index +
                ", data=" + data +
                '}';
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
