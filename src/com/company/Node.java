package com.company;

public class Node<X, Y> {
    private X x_coordinate;
    private Y y_coordinate;
    private String node_name;
    private Node next;
    private Node prev;

    public X getX_coordinate() {
        return x_coordinate;
    }

    public void setX_coordinate(X x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public Y getY_coordinate() {
        return y_coordinate;
    }

    public void setY_coordinate(Y y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    public String getNode_name() {
        return node_name;
    }

    public void setNode_name(String node_name) {
        this.node_name = node_name;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node(X x_coordinate, Y y_coordinate, String node_name, Node next, Node prev) {
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
        this.node_name = node_name;
        this.next = next;
        this.prev = prev;
    }
}
