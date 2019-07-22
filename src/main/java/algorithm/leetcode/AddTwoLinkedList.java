package algorithm.leetcode;

/**
 * 头条的笔试题：
 * 两个链表，分别表示2个整数，每个链表的节点含有数值0-9
 * 比如9->3->7 和 6->3 相加，得到1->0->0->0
 */
public class AddTwoLinkedList {

    public static IntNode add(IntNode node1, IntNode node2) {
        System.out.printf("sum %s and %s \n", node1, node2);
        IntNode revertNode1 = rRevert(node1);
        IntNode revertNode2 = rRevert(node2);
        IntNode result = null;
        int carry = 0;
        while (revertNode1 != null || revertNode2 != null) {
            int sum = getValue(revertNode1) + getValue(revertNode2) + carry;
            carry = sum / 10;
            IntNode node = new IntNode(sum % 10);
            node.next = result;
            result = node;
            if (revertNode1 != null) revertNode1 = revertNode1.next;
            if (revertNode2 != null) revertNode2 = revertNode2.next;
        }
        if (carry > 0) {
            IntNode node = new IntNode(carry);
            node.next = result;
            result = node;
        }
        return result;
    }

    private static int getValue(IntNode node) {
        return node != null ? node.value : 0;
    }

    private static IntNode revert(IntNode header) {
       IntNode prev = null;
       IntNode node = header;
       while (node != null) {
           IntNode next = node.next;
           node.next = prev;
           prev = node;
           node = next;
       }
       return prev;
    }

    private static IntNode rRevert(IntNode node) {
        if (node == null || node.next == null) return node;
        IntNode next = node.next;
        node.next = null;
        IntNode result = rRevert(next);
        next.next = node;
        return result;
    }

    static class IntNode {
        int value;
        IntNode next;

        IntNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(value);
            IntNode node = next;
            while (node != null) {
                stringBuilder.append(node.value);
                node = node.next;
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        IntNode node1 = buildNode1();
        IntNode node2 = buildNode2();
        IntNode result = add(node1, node2);
        System.out.println(result);
    }

    private static IntNode buildNode1() {
        IntNode node1 = new IntNode(1);
        IntNode node2 = new IntNode(2);
        IntNode node3 = new IntNode(3);
        node1.next = node2;
        node2.next = node3;
        return node1;
    }

    private static IntNode buildNode2() {
        IntNode node1 = new IntNode(9);
        IntNode node2 = new IntNode(8);
        IntNode node3 = new IntNode(9);
        node1.next = node2;
        node2.next = node3;
        return node1;
    }
}
