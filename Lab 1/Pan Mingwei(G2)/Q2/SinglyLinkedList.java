/*
 * Name:Pan Mingwei
 * Email ID:mingwei.pan.2022
 */

public class SinglyLinkedList<E> {

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

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

    // Write your codes below
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        String output = "";
        Node<E> curr = head;
        while (curr.getNext() != null) {
            output += curr.getElement().toString();
            curr = curr.getNext();
        }
        // print the tail element
        if (curr.getElement() != null) {
            output += curr.getElement().toString();
        }
        return output;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node<E> curr = head;
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return null;
        }
        // go to second last
        for (int i = 1; i < size - 1; i++) {
            curr = curr.getNext();
        }

        //set the tail to be second last node
        tail = curr;
        tail.setNext(null);
        size--;

        if (isEmpty()) {
            tail = null;
        }
        return curr.getElement();
    }

    public void reverse() {
        Node<E> prev = null;
        Node<E> current = head;
        Node<E> next = null;
        tail = head;
        while (current != null) {
            next = current.getNext(); 
            current.setNext(prev);

            prev = current;
            current = next;
        }

        head = prev;
    }
}