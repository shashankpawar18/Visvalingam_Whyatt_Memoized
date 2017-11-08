package com.company;

public class Triangle {

    private Side side1;
    private Side side2;
    private Side side3;
    private float semi_perimeter;
    private float area;
    private String triangle_name;

    public String getTriangle_name() {
        return triangle_name;
    }

    public void setTriangle_name(String triangle_name) {
        this.triangle_name = triangle_name;
    }

    public Side getSide1() {
        return side1;
    }

    public void setSide1(Side side1) {
        this.side1 = side1;
    }

    public Side getSide2() {
        return side2;
    }

    public void setSide2(Side side2) {
        this.side2 = side2;
    }

    public Side getSide3() {
        return side3;
    }

    public void setSide3(Side side3) {
        this.side3 = side3;
    }

    public float getSemi_perimeter() {
        return semi_perimeter;
    }

    public void setSemi_perimeter(float semi_perimeter) {
        this.semi_perimeter = semi_perimeter;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public Triangle(Side side1, Side side2, Side side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        this.triangle_name = side1.getPt1().getNode_name() + side2.getPt1().getNode_name() + side3.getPt2().getNode_name();

        Memo obj = new Memo();
        float a = obj.getMemoMap(this.triangle_name);

        if (a > 0) {
            this.area = a;

        } else {
            this.semi_perimeter = (side1.getSide_length() + side2.getSide_length() + side3.getSide_length()) / 2;

            this.area = (float) Math.sqrt((this.semi_perimeter) *
                    (this.semi_perimeter - side1.getSide_length()) *
                    (this.semi_perimeter - side2.getSide_length()) *
                    (this.semi_perimeter - side3.getSide_length()));

            obj.setMemoMap(this.triangle_name,this.area);
        }


    }
}
