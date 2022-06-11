package lists;

public class ArrayList<E> implements List<E>{

    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;

    public ArrayList(){
        this(CAPACITY);
    }

    public ArrayList(int capacity){
        data = (E[]) new Object[CAPACITY];;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E get(int index){
        checkIndex(index, size);
        return data[index];
    }

    public E set(int index, E element) throws IndexOutOfBoundsException{
        checkIndex(index, size);
        E temp = data[index];
        data[index] = element;
        return temp;
    }

    public void add(int index, E element) throws IndexOutOfBoundsException{
        checkIndex(index, size);
        if(size == data.length){
            resize(2 * data.length);
        }
        for(int k = size - 1; k  > index; k --){
               data[k + 1] = data[k];
        }
        data[index] = element;
        size ++;
    }
    public E remove(int index) throws IndexOutOfBoundsException{
        checkIndex(index, size + 1);
        E temp = data[index];
        //Loop invariant
        //: initialization k = index of element to be removed;
        // data[k... n -1] k = index of data[] to be shifted left
        for (int k = index; k < size - 1; k++) {
            // k = the current index of the  array location to be filled
            data[k] = data[k + 1];
            // array[k] = the next value to the right
            // k ++
        }
        // data[i...n] = data[i + 1 ... n]
        data[size - 1] = null; //help with garbage collection
        size --;
        return temp;
    }

    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException{
        if(i < 0 || i > n){
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    protected void resize(int capacity){
        E[] temp = (E[]) new Object[capacity];
        for (int k = 0; k < size; k++) {
            temp[k] = data[k];
        }
        data = temp;
    }
}
