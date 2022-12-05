
public class ArrayDeque<T> {

    private int nextFirst;
    private int nextLast;
    private int  size;
    private  T[] items;
    public ArrayDeque() {
        nextFirst = 0;
        nextLast = 1;
        size = 0;
        items = (T[]) new Object[8];
    }
    /** resize the array.*/
    private void resize(int size2){
        T[] items2 = (T[])new Object[size2];
        for(int i=0,j=0;i<size;i++,j++) {
            items2[j]=items[(nextFirst+1+i)%items.length];
        }
        nextFirst = items2.length-1;
        nextLast = size;
        items = items2;
   }



    public void addFirst(T item) {
        if (size==items.length){
            resize(2*size);
        }
        items[nextFirst]=item;
        nextFirst=(nextFirst-1+items.length)%items.length;
        size += 1;
    }

    public void addLast(T item) {
        if (size==items.length){
            resize(2*size);
        }
        items[nextLast]=item;
        nextLast=(nextLast+1)%items.length;
        size += 1;
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public int size() {
        return size;
    }
    public void printDeque() {
        for (int i=0;i<size;i++) {
            System.out.print(items[(nextFirst+1+i)% items.length]+" ");
        }
    }

    public T  removeFirst() {
        while (size>=16 && size/items.length<0.25){
            resize(items.length/2);
        }
        T item = items[(nextFirst+1)%items.length];
        items[(nextFirst+1)%items.length] = null;
        nextFirst =(nextFirst+1)%items.length;
        size -= 1;
        return item;
    }

    public T removeLast() {
        while (size>=16 && size/items.length<0.25){
            resize(items.length/2);
        }
        T item = items[(nextLast-1+items.length)%items.length];
        items[(nextLast-1+items.length)%items.length] = null;
        nextLast = (nextLast-1+items.length)%items.length;
        size -= 1;
        return item;
    }
    public T get(int index) {
        if(index<0||index>=size) {
            return null;
        }
        return items[(nextFirst+1+index)%items.length];
    }

}
