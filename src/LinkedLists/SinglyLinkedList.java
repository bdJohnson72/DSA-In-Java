package LinkedLists;

public class SinglyLinkedList<T> {

    public Node head;
    public int size;


    public SinglyLinkedList(){
        this.head = null;
        this.size = 0;
    }
    public boolean isEmpty(){
        return this.head == null;
    }

    public void addToFront(T data ){
        Node newNode = new Node();
        newNode.data = data;
        if (isEmpty()){
            this.head = newNode;
            head.next = null;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }


    public class Node {
        public T data;
        public Node next;
    }

    public void insertAtEnd(T data){
        Node newNode = new Node();
        newNode.data = data;
        if (isEmpty()){
           addToFront(data);
        }
        Node currentNode = head;
        while(currentNode.next != null ){
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        size++;
    }

    public void insertAfter(Node previous, T data){
        Node tempNode = previous.next;
        Node newNode = new Node();
        newNode.data = data;
        previous.next = newNode;
        newNode.next = tempNode;
    }

    public void deleteFromFront(){
        if (head != null){
            head = head.next;
        }else {
            head = null;
        }
    }

    public void deleteAtValue(T value){
        if (head.data == value){
            deleteFromFront();;
        }else {
            Node currentNode = head;
            while(head.next.data != value ){
                currentNode = currentNode.next;
            }
            //after loop
            currentNode.next = currentNode.next.next;
        }
    }


}
