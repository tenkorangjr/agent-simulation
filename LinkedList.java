/*
 * Author: Michael Tenkorang
 * Title: Agent-Based Simulation
 * Date: 02/26/2023
 * CS 231
 * Section B
 * LinkedList.java
 */

import java.util.ArrayList;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    private class Node<T> {
        // Class for the Node
        T data;
        Node<T> next;

        public Node(T item, Node<T> next) {
            // Constructor for node with next
            data = item;
            this.next = next;
        }

        public T getData() {
            /*
             * Return the data in the Node
             */
            return data;
        }

        public Node<T> getNext() {
            /*
             * get the next of a Node
             */
            return next;
        }

    }

    private int size;

    private Node<T> head;

    public LinkedList() {
        /*
         * Constructor for a LinkedList
         */
        size = 0;
        head = null;
    }

    public ArrayList<T> toArrayList() {
        /*
         * Convert a LinkedList to an ArrayList
         */
        ArrayList<T> arr = new ArrayList<>();
        for (T i : this) {
            arr.add(i);
        }

        return arr;
    }

    public Iterator iterator() {
        /*
         * Return Iterator for the Iterable interface
         */
        return new LLIterator(head);
    }

    private class LLIterator implements Iterator<T> {

        Node<T> head;

        public LLIterator(Node<T> head) {
            /*
             * Constructor for Iterator
             */
            this.head = head;
        }

        public boolean hasNext() {
            /*
             * For the Iterator interface
             */
            if (head != null) {
                return true;
            }
            return false;
        }

        public T next() {
            /*
             * Next for iterator interface
             * Returns value of current next and moves to next
             */
            T temp = head.getData();
            head = head.next;
            return temp;
        }

        public void remove() {
            // Optional
            assert (true);
        }
    }

    public void add(T item) {
        /*
         * Add item to LinkedList
         */
        Node<T> newNode = new Node<T>(item, head);
        head = newNode;
        size++;
    }

    public int size() {
        // Return size of LinkedList
        return size;
    }

    public T get(int index) {
        /*
         * Get the data at a particular index
         */
        Node<T> walker = head;
        for (int i = 0; i < index; i++) {
            walker = walker.getNext();
        } // at the end of this loop, walker is at the final Node

        return walker.getData();
    }

    public void add(int index, T item) {
        /*
         * Add a particular item at a particular index in the LinkedList
         */
        if (index == 0) {
            add(item);
            return;
        }

        Node<T> walker = head;
        for (int i = 0; i < index - 1; i++) {
            walker = walker.getNext();
        }

        Node<T> temp = new Node<T>(item, walker.getNext());
        size++;
        walker.next = temp;
    }

    public void clear() {
        /*
         * Empty the LinkedList
         */
        head = null;
        size = 0;
    }

    public boolean contains(Object o) {
        /*
         * Check if a LinkedList contains an object o
         */
        for (T data : this) {
            if (data.equals(o)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object o) {
        /*
         * Check if two LinkedLists are equal
         */

        if (!(o instanceof LinkedList)) {
            return false;
        }
        // If I have reached this line, o must be a LinkedList
        LinkedList<T> oAsALinkedList = (LinkedList<T>) o;

        if (oAsALinkedList.size != size) {
            return false;
        }

        Node<T> d_walker = this.head;
        Node<T> o_walker = oAsALinkedList.head;
        for (int i = 0; i < size; i++) {
            if (!(d_walker.equals(o_walker))) {
                if (d_walker.getData().equals(o_walker.getData())) {
                    return true;
                }
                return false;
            }

            o_walker.getNext();
            d_walker.getNext();
        }
        return true;
    }

    public boolean isEmpty() {
        /*
         * Check if a LinkedList is empty
         */

        return head == null ? true : false;

    }

    public T remove() {
        /*
         * Remove head
         * Return data in head
         */
        Node<T> dummy = head;
        head = head.next;

        return dummy.getData();
    }

    public T remove(int index) {
        /*
         * Remove Node at a particular index
         */
        if (index == 0) {
            return remove();
        }

        Node<T> walker = head;
        for (int i = 0; i < index - 1; i++) {
            walker = walker.getNext();
        }

        Node<T> dummy = walker.next;
        walker.next = walker.next.next;

        return dummy.getData();
    }

    public String toString() {
        /*
         * String representation of a LinkedList
         */
        String res = "[";
        Node<T> walker = head;

        if (size == 0) {
            return "[]";
        }

        for (int i = 0; i < size - 1; i++) {
            res += walker.getData();
            res += ", ";

            walker = walker.getNext();
        }
        res += walker.getData() + "]";

        return res;
    }

}