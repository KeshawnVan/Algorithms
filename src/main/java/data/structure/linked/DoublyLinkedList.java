package data.structure.linked;

import java.util.Iterator;

/**
 * 双向链表
 *
 * @param <T>
 */
public class DoublyLinkedList<T> implements LinkedList<T> {

    protected DoublyLinkedListNode<T> header;

    protected DoublyLinkedListNode<T> footer;

    protected int lastIndex;

    @Override
    public void append(T data) {
        if (footer == null) {
            init(data);
        } else {
            appendWithFooter(data);
            lastIndex++;
        }
    }

    protected void init(T data) {
        DoublyLinkedListNode<T> node = new DoublyLinkedListNode<>(data, null, null);
        header = node;
        footer = node;
    }

    protected void appendWithFooter(T data) {
        DoublyLinkedListNode<T> node = new DoublyLinkedListNode<>(data, footer, null);
        footer.setNext(node);
        footer = node;
    }

    @Override
    public void insert(int index, T data) {
        if (index > lastIndex + 1) {
            throw new IllegalArgumentException("cannot insert data with index " + index);
        } else if (index == lastIndex + 1) {
            appendWithFooter(data);
        } else if (index == 0) {
            if (header == null) {
                init(data);
            } else {
                DoublyLinkedListNode<T> newHeader = new DoublyLinkedListNode<>(data, null, header);
                header.setPrevious(newHeader);
                header = newHeader;
            }
        } else {
            middleInsert(index, data);
        }
        lastIndex++;
    }

    protected void middleInsert(int index, T data) {
        DoublyLinkedListNode<T> previousNode = getNode(index - 1);
        DoublyLinkedListNode<T> oldNodeWithIndex = previousNode.getNext();
        DoublyLinkedListNode<T> node = new DoublyLinkedListNode<>(data, previousNode, oldNodeWithIndex);
        previousNode.setNext(node);
    }

    protected DoublyLinkedListNode<T> getNode(int index) {
        if (index == 0) return header;
        DoublyLinkedListNode<T> next = header.getNext();
        for (int i = 1; i <= index; i++) {
            if (next == null) break;
        }
        return next;
    }

    @Override
    public void removeWithIndex(int index) {
        if (index <= lastIndex) {
            if (index == 0) {
                if (header != null) {
                    DoublyLinkedListNode<T> next = header.getNext();
                    if (next != null) {
                        next.setPrevious(null);
                        header = next;
                    } else {
                        header = null;
                        footer = null;
                    }
                }
            } else {
                middleRemove(index);
            }
        }
        lastIndex--;
    }

    protected void middleRemove(int index) {
        DoublyLinkedListNode<T> previousNode = getNode(index - 1);
        DoublyLinkedListNode<T> node = previousNode.getNext();
        DoublyLinkedListNode<T> nodeNext = node.getNext();
        nodeNext.setPrevious(previousNode);
        previousNode.setNext(nodeNext);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size()) return null;
        if (index == 0) return header == null ? null : header.getData();
        DoublyLinkedListNode node;
        if (index < (size() >> 1)) {
            node = header;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
        } else {
            node = footer;
            for (int i = size(); i > index; i--) {
                node = node.getPrevious();
            }
        }
        return (T) node.getData();
    }

    /**
     * 双向链表反转
     */
    public void reverse() {
        DoublyLinkedListNode<T> node = header;
        DoublyLinkedListNode<T> prev = null;
        footer = header;
        while (node != null) {
            DoublyLinkedListNode<T> next = node.getNext();
            if (next == null) {
                node.setPrevious(null);
                header = node;
            }
            node.setNext(prev);
            if (prev != null) {
                prev.setPrevious(node);
            }
            prev = node;
            node = next;

        }
    }

    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator<>(header);
    }

    @Override
    public int size() {
        return lastIndex + 1;
    }
}
