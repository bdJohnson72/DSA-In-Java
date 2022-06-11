package lists;

public class LinkedPositionalList <E>{

    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E data, Node<E> orev, Node<E> next) {
            this.element = data;
            this.prev = orev;
            this.next = next;
        }

        public E getElement() throws IllegalStateException {
            if (next == null) {
                throw new IllegalStateException("Position no longer valid");
            }
            return element;
        }

        public void setElement(E element) throws IllegalStateException {
            this.element = element;
        }

        public Node<E> getPrevious() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void s(E e) {
            element = e;
        }

        public void setPrev(Node<E> node) {
            prev = node;
        }

        public void setNext(Node<E> node) {
            next = node;
        }
    }
    //end of Node class
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList(){
        this.header = new Node<>(null, null, null);
        this.trailer = new Node<>(null, header, null);
        this.header.setNext(trailer);
    }

    /**Validates the position and returns as a node */
    private Node<E> validate(Position<E> position){
        if(!(position instanceof  Node)){
            throw new IllegalArgumentException("Invalid position");
        }
        Node<E> node = (Node<E>)position;
        if(node.getNext() == null){
            throw  new IllegalArgumentException("Node is no longer in the list");
        }
        return node;
    }
    /** Returns the node as a position */
    private Position<E> position(Node<E> node){
        if (node == header || node == trailer){
            return null;
        }
        return node;
    }
    //public accessor methods
    public int size(){
        return size;
    }

    public Position<E> first(){
        return  position(header.getNext());
    }

    public Position<E> last(){
        return position(trailer.getPrevious());
    }

    public Position<E> before(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validate(position);
        return position(node.getPrevious());
    }

    public Position<E> after(Position<E> position){
        Node<E> node = validate(position);
        return position(node.getNext());
    }

    //positional utilities
    private Position<E> addBetween(E e, Node<E> predecessor, Node<E> successor){
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size ++;
        return newest;
    }

    public Position<E> addFirst(E e){
        return  addBetween(e, header, header.getNext());
    }

    public Position<E> addLast(E e){
        return addBetween(e, trailer.getPrevious(), trailer);
    }

    public Position<E> addBefore(Position<E> position, E e) throws IllegalArgumentException {
        Node<E> node = validate(position);
        return addBetween(e, node.getPrevious(), node);
    }

    public Position<E> addAfter(Position<E> position, E e){
        Node<E> node = validate(position);
        return addBetween(e, node, node.getNext());
    }

    //replaces the node stored at P  and returns the replaced element
    public E  set(Position<E> position, E e) throws IllegalArgumentException {
        Node<E> node =  validate(position);
        E result = node.getElement();
        node.setElement(e);
        return result;
    }

    public E remove(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validate(position);
        Node<E> successor = node.getNext();
        Node<E> predecessor = node.getPrevious();
        predecessor.setNext(successor);
        successor.setPrev(successor);
        size--;
        E result = node.getElement();
        node.setNext(null);
        node.setElement(null);
        node.setPrev(null);

        return result;
    }

}

