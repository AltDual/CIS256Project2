package graph;

public class DLinkedListNode {
    public Object item;
    public DLinkedListNode next;
    public DLinkedListNode prev;

    public DLinkedListNode(Object item) {
        this.item = item;
        this.next = null;
        this.prev = null;
    }
}
