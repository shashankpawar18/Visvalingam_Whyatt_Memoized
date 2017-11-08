package com.company;

public class DoublyLinkedList<X, Y> {

    private Node head;
    private Node tail;
    private int size;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public DoublyLinkedList() {
        size = 0;
    }

    public int size() {
        return size;
    }


    public void addFirst(X x_coordinate, Y y_coordinate, String node_name) {
        Node tmp = new Node(x_coordinate, y_coordinate, node_name, head, null);
        if (head != null) {
            head.setPrev(tmp);
        }
        head = tmp;
        if (tail == null) {
            tail = tmp;
        }
        size++;
        System.out.println("Adding: " + node_name + " (" + x_coordinate + "," + y_coordinate + ")");
    }


    public void addLast(X x_coordinate, Y y_coordinate, String node_name) {

        Node tmp = new Node(x_coordinate, y_coordinate, node_name, null, tail);
        if (tail != null) {
            tail.setNext(tmp);
        }
        tail = tmp;
        if (head == null) {
            head = tmp;
        }
        size++;
        System.out.println("Adding: " + node_name + " (" + x_coordinate + "," + y_coordinate + ")");
    }

    public void iterateForward() {

        System.out.println("Head to Tail...");
        Node tmp = head;
        while (tmp != null) {
            System.out.print("[" + tmp.getNode_name() + "]  ");
            tmp = tmp.getNext();
        }
        System.out.println();
    }


    public void removeNode(String nodeName) {
        if (size != 0) {
            Node start = head;
            while (start != null) {
                if (nodeName == start.getNode_name() && nodeName == head.getNode_name()) {
                    //Removing the head node
                    Node tmp = head;
                    head = head.getNext();
                    head.setPrev(null);
                    size--;
                    System.out.println("Deleted Node: " + tmp.getNode_name());
                    break;

                } else if (nodeName == start.getNode_name() && nodeName == tail.getNode_name()) {
                    //Removing the tail node
                    Node tmp = tail;
                    tail = tail.getPrev();
                    tail.setNext(null);
                    size--;
                    System.out.println("Deleted Node: " + tmp.getNode_name());
                    break;

                } else if (nodeName == start.getNode_name()) {//Removing any other intermediate node
                    Node prevNode = start.getPrev();
                    Node nextNode = start.getNext();

                    prevNode.setNext(nextNode);
                    nextNode.setPrev(prevNode);
                    size--;

                    start.setPrev(null);
                    start.setNext(null);
                    System.out.println("Deleted Node: " + start.getNode_name());
                    break;

                } else {
                    start = start.getNext();
                }
            }
        }
    }
}
