package lists;

/**
 * List ADT
 * @param <E>
 */
public interface List<E> {
    /**
     *
     * @return number of elements in list
     */
    int size();

    /**
     *
     * @return if list is empty
     */
    boolean isEmpty();

    /**
     *  returns but does not remove the element at i
     */
    E get(int i) throws IndexOutOfBoundsException;

    /** Replaces the element at i and returns the replaced element */
    E set(int i, E e) throws IndexOutOfBoundsException;
    /**
     * inserts element at index i, shifting subqequent elements
     * @param i
     * @param e
     * @throws IndexOutOfBoundsException
     */
    void add(int i, E e) throws IndexOutOfBoundsException;

    /** Removes / rturns the element at i. */
    E remove(int i) throws IndexOutOfBoundsException;
}
