package LinkedLists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void isEmpty() {
        //given
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();
        //when
        boolean result = linkedList.isEmpty();
        //then
        assertTrue(result);
        //when
        linkedList.addToFront(5);
        result = linkedList.isEmpty();
        assertFalse(result);
    }

    @Test
    void addToFront() {
        //given
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        //when
        linkedList.addToFront(5);
        assertEquals(5, linkedList.head.data);
        linkedList.addToFront(10);
        assertEquals(10, linkedList.head.data);
    }

    @Test
    void insertAfter(){
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.addToFront(10);
        linkedList.addToFront(20);
        linkedList.addToFront(30);
        assertEquals(10, linkedList.head.next.next.data);
        linkedList.insertAfter(linkedList.head, 25);
        assertEquals(25, linkedList.head.next.data);
    }

    @Test
    void deleteAtValue(){
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.addToFront(10);
        linkedList.addToFront(20);
        linkedList.addToFront(30);
        //when
        linkedList.deleteAtValue(20);
        //then
        assertEquals(10, linkedList.head.next.data);
    }
}