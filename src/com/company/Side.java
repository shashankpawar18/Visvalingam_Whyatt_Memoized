package com.company;

public class Side {
    private Node<Integer, Integer> pt1;
    private Node<Integer, Integer> pt2;
    private float side_length;
    private String side_name;

    public String getSide_name() {
        return side_name;
    }

    public void setSide_name(String side_name) {
        this.side_name = side_name;
    }

    public Node<Integer, Integer> getPt1() {
        return pt1;
    }

    public void setPt1(Node<Integer, Integer> pt1) {
        this.pt1 = pt1;
    }

    public Node<Integer, Integer> getPt2() {
        return pt2;
    }

    public void setPt2(Node<Integer, Integer> pt2) {
        this.pt2 = pt2;
    }

    public float getSide_length() {
        return side_length;
    }

    public void setSide_length(float side_length) {
        this.side_length = side_length;
    }

    public Side(Node<Integer, Integer> pt1, Node<Integer, Integer> pt2) {
        this.pt1 = pt1;
        this.pt2 = pt2;
        this.side_name = pt1.getNode_name() + pt2.getNode_name();

        Memo obj = new Memo();
        float s = obj.getMemoMap(this.side_name);

        if (s > 0) {
            this.side_length = s;

        } else {
            this.side_length = (float) Math.sqrt(Math.pow((pt2.getX_coordinate() - pt1.getX_coordinate()), 2) +
                    Math.pow((pt2.getY_coordinate() - pt1.getY_coordinate()), 2));
            obj.setMemoMap(this.side_name,this.side_length);
        }


    }
}