package graph;

public class DLinkedList {
    private DLinkedListNode head;
    private int size;

    public DLinkedList() {
        head = new DLinkedListNode(null);
        head.next = head;
        head.prev = head;
        size = 0;
    }

    public void insertBack(Object item) {
        DLinkedListNode node = new DLinkedListNode(item);
        node.prev = head.prev;
        node.next = head;
        head.prev.next = node;
        head.prev = node;
        size++;
    }

    public DLinkedListNode back() {
        if (head.next == head) return null;
        return head.prev;
    }

    public DLinkedListNode front() {
        if (head.next == head) return null;
        return head.next;
    }

    public DLinkedListNode next(DLinkedListNode node) {
        if (node.next == head) return null;
        return node.next;
    }

    public void remove(DLinkedListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        size--;
    }

    public int size() {
        return size;
    }
}
