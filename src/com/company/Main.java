package com.company;

import org.jfree.ui.RefineryUtilities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        DoublyLinkedList<Integer, Integer> polyLine = new DoublyLinkedList<>();

        polyLine.addFirst(1, 12, "A");
        polyLine.addLast(2, 8, "B");
        polyLine.addLast(4, 6, "C");
        polyLine.addLast(9, 4, "D");
        polyLine.addLast(12, 1, "E");
        polyLine.addLast(14, 11, "F");

       /* polyLine.addFirst(554, 93, "1");
        polyLine.addFirst(532, 72, "2");
        polyLine.addFirst(482, 48, "3");
        polyLine.addFirst(455, 45, "4");
        polyLine.addFirst(409, 45, "5");
        polyLine.addFirst(377, 54, "6");
        polyLine.addFirst(331, 78, "7");
        polyLine.addFirst(316, 88, "8");
        polyLine.addFirst(314, 106, "9");
        polyLine.addFirst(339, 139, "10");
        polyLine.addFirst(392, 158, "11");
        polyLine.addFirst(431, 174, "12");
        polyLine.addFirst(454, 181, "13");
        polyLine.addFirst(491, 189, "14");
        polyLine.addFirst(497, 201, "15");
        polyLine.addFirst(497, 211, "16");
        polyLine.addFirst(481, 220, "17");
        polyLine.addFirst(440, 221, "18");
        polyLine.addFirst(380, 222, "19");
        polyLine.addFirst(346, 219, "20");
        polyLine.addFirst(256, 216, "21");
        polyLine.addFirst(240, 214, "22");
        polyLine.addFirst(183, 215, "23");
        polyLine.addFirst(155, 219, "24");
        polyLine.addFirst(108, 238, "25");
        polyLine.addFirst(93, 262, "26");
        polyLine.addFirst(82, 285, "27");
        polyLine.addFirst(107, 304, "28");
        polyLine.addFirst(143, 313, "29");
        polyLine.addFirst(188, 321, "30");
        polyLine.addFirst(274, 337, "31");
        polyLine.addFirst(341, 351, "32");
        polyLine.addFirst(437, 372, "33");
        polyLine.addFirst(489, 380, "34");
        polyLine.addFirst(435, 436, "35");
        polyLine.addFirst(372, 449, "36");
        polyLine.addFirst(341, 461, "37");
        polyLine.addFirst(307, 467, "38");
        polyLine.addFirst(261, 479, "39");
        polyLine.addFirst(188, 488, "40");
        polyLine.addFirst(141, 493, "41");
        polyLine.addFirst(73, 502, "42");*/

        //plotPolyLine(polyLine);
        //TimeUnit.SECONDS.sleep(1);

        List<Triangle> triangleList = new ArrayList<>();

        while (polyLine.size() > 3) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            polyLine.iterateForward();

            createTriangleList(polyLine, triangleList);

            printTriangleList(triangleList);

            findDeletableNode(polyLine, triangleList);
            //plotPolyLine(polyLine);

            //Thread.sleep(250);

            System.out.println();
            System.out.println();

            triangleList.clear();
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        polyLine.iterateForward();

    }

    private static void plotPolyLine(DoublyLinkedList<Integer, Integer> polyLine) {
        PlotChart polyChart = new PlotChart("Visvalingam Algorithm", polyLine);
        polyChart.pack();
        RefineryUtilities.centerFrameOnScreen(polyChart);
        polyChart.setVisible(true);
    }

    private static void findDeletableNode(DoublyLinkedList<Integer, Integer> polyLine, List<Triangle> triangleList) {
        Triangle minTriangle = triangleList.get(0);

        for (Triangle t : triangleList) {
            if (t.getArea() < minTriangle.getArea()) {
                minTriangle = t;
            }
        }

        System.out.println("Min. Triangle: " + minTriangle.getTriangle_name());

        polyLine.removeNode(minTriangle.getSide1().getPt2().getNode_name());
    }

    private static void createTriangleList(DoublyLinkedList<Integer, Integer> polyLine, List<Triangle> triangleList) {
        if (polyLine.size() != 0) {
            Node start = polyLine.getHead().getNext();

            while (start.getNext() != null) {

                Side s1 = new Side(start.getPrev(), start);
                Side s2 = new Side(start, start.getNext());
                Side s3 = new Side(start.getPrev(), start.getNext());

                Triangle t = new Triangle(s1, s2, s3);

                triangleList.add(t);

                start = start.getNext();

            }
        }
    }

    private static void printTriangleList(List<Triangle> triangleList) {
        for (Triangle t : triangleList) {
            System.out.println();
            System.out.println("Triangle " + t.getTriangle_name());
            System.out.println(t.getSide1().getSide_name() + " : " + t.getSide1().getSide_length());
            System.out.println(t.getSide2().getSide_name() + " : " + t.getSide2().getSide_length());
            System.out.println(t.getSide3().getSide_name() + " : " + t.getSide3().getSide_length());
            System.out.println("Semi-perimeter: " + t.getSemi_perimeter());
            System.out.println("Area: " + t.getArea());
            System.out.println();

        }
    }
}
