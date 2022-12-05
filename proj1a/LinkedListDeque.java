public class  LinkedListDeque<T> {
    private class StuffNode {
        private T item;
        private StuffNode next;
        private StuffNode prev;

        StuffNode(T i, StuffNode n, StuffNode p) {
            item = i;
            next = n;
            prev = p;

        }
    }

    private int size;
    private StuffNode sentFront;
    private StuffNode sentBack;

    public LinkedListDeque() {
        sentFront = new StuffNode(null,  null, null);
        sentBack = new StuffNode(null,  null, null);
        sentFront.next = sentBack;
        sentBack.prev = sentFront;
        size = 0;
    }

    /** Adds an item of type T to the front of the deque.*/
    public void addFirst(T item) {
        StuffNode node = new StuffNode(item, sentFront.next, sentFront);
        sentFront.next.prev = node;
        sentFront.next = node;
        size += 1;
    }

    public void addLast(T item) {
        StuffNode node = new StuffNode(item, sentBack, sentBack.prev);
        sentBack.prev.next = node;
        sentBack.prev = node;
        size += 1;
    }
    public boolean isEmpty() {
        return sentFront.next == sentBack;
    }

    public void printDeque() {
        StuffNode ptr = sentFront;
        while (ptr.next != sentBack) {
            System.out.print(ptr.next.item + " ");
            ptr = ptr.next;
        }
    }
    public int size() {
        return size;
    }
    public T removeFirst() {
        if (sentFront.next == sentBack) {
            return null;
        }
        T item = sentFront.next.item;
        sentFront.next = sentFront.next.next;
        sentFront.next.prev = sentFront;
        size -= 1;
        return item;
    }

    public T removeLast() {
        if (sentBack.prev == sentFront) {
            return null;
        }
        T item = sentBack.prev.item;
        sentBack.prev = sentBack.prev.prev;
        sentBack.prev.next = sentBack;
        size -= 1;
        return item;
    }
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        StuffNode ptr = sentFront;
        for (int i = 0; i < index; i++) {
            ptr = ptr.next;
        }
        return ptr.next.item;
    }

    private T getRecursivehelper(StuffNode ptr, int index) {
        if (index == 0) {
            return ptr.next.item;
        }
        else {
            ptr = ptr.next;
            return getRecursivehelper(ptr, index - 1);
        }
    }
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursivehelper(sentFront, index);
    }

}
