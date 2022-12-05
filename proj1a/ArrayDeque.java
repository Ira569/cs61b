/** a data structure that using array to achieve deque.*/
public class ArrayDeque<T> {
    /** index before the first item.*/
    private int nextFirst;
    /** index after the last item.*/
    private int nextLast;
    /** size of items.*/
    private int  size;
    /** items.*/
    private  T[] items;
    public ArrayDeque() {
        nextFirst = 0;
        nextLast = 1;
        size = 0;
        items = (T[]) new Object[8];
    }
    /** resize the array.*/
    private void resize(int size2) {
        T[] items2 = (T[]) new Object[size2];
        for (int i = 0, j = 0; i < size; i++, j++) {
            items2[j] = items[(nextFirst + 1 + i) % items.length];
        }
        nextFirst = items2.length - 1;
        nextLast = size;
        items = items2;
    }



    public void addFirst(T item) {
        if (size == items.length) {
            resize(2 * size);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(2 * size);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public int size() {
        return size;
    }
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[(nextFirst + 1 + i) % items.length] + " ");
        }
    }

    public T  removeFirst() {
        if (size == 0) {
            return  null;
        }
        int firstItem = (nextFirst + 1) % items.length;
        T item = items[firstItem];
        items[firstItem] = null;
        nextFirst = firstItem;
        size -= 1;
        while (size >= 16 && (double) size / items.length < 0.25) {
            resize(items.length / 2);
        }
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return  null;
        }
        int lastItem = (nextLast - 1 + items.length) % items.length;
        T item = items[lastItem];
        items[lastItem] = null;
        nextLast = lastItem;
        size -= 1;
        while (size >= 16 && (double) size / items.length < 0.25) {
            resize(items.length / 2);
        }
        return item;
    }
    /** get the index item in arrays.*/
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        else {
            return items[(nextFirst + 1 + index) % items.length];
        }
    }
}
