/*
 * Name:Pan Mingwei
 * Email ID:mingwei.pan.2022
 */

import java.util.*;

public class SinglyLinkedList<E extends Comparable<E>> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    public SinglyLinkedList() {

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);

        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()) {
            tail = null;
        }
        return answer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.getElement());
            sb.append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }

    public void swap() {
        //if only one element
        if (size < 2) {
            return;
        }

        // determine how many swap needed
        int noOfSwap = size / 2;

        // putting all element into Array and sort them
        Integer[] elementArray = new Integer[size];
        Node<E> current = head;
        int position = 0;
        while (current != null) {
            elementArray[position] = (Integer) current.getElement();
            current = current.getNext();
            position++;
        }
        Arrays.sort(elementArray);

        //swapping the elements
        int frontPTR = 0;
        int backPTR = size - 1;
        for (int i = 0; i < noOfSwap; i++) {

            //sawp two given element
            Integer n1 = elementArray[frontPTR];
            Integer n2 =  elementArray[backPTR];

            Node<E> preNode1 = null;
            Node<E> preNode2 = null;

            Node<E> node1 = head;
            Node<E> node2 = head;

            //find the given element's node
            while (node1 != null && node1.getElement() != n1) {
                preNode1 = node1;
                node1 = node1.getNext();
            }

            while (node2 != null && node2.getElement() != n2) {
                preNode2 = node2;
                node2 = node2.getNext();
            }

            // swap for previous node and head
            if (preNode1 != null) {
                preNode1.setNext(node2);
            } else {
                head = node2;
            }

            if (preNode2 != null) {
                preNode2.setNext(node1);
            } else {
                head = node1;
            }
            // swap for next node && check if it is tail
            Node<E> temp = node1.getNext();
            if (node2.getNext() == null) {
                node1.setNext(null);
                tail = node1;
            } else {
                node1.setNext(node2.getNext());
            }

            if (temp == null) {
                node2.setNext(null);
                tail = node2;
            } else {
                node2.setNext(temp);
            }
            
            //move the pointer
            frontPTR ++;
            backPTR --;
        }

    }

}
