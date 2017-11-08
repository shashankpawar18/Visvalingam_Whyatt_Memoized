package com.company;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;


public class PlotChart extends ApplicationFrame {

    public PlotChart(String title, DoublyLinkedList polyLine) {

        super(title);
        XYSeries series = new XYSeries("Polyline");

        String polyLineName = "Plotting ";

        Node tmp = polyLine.getHead();
        while (tmp != null) {
            series.add((double) ((Integer) tmp.getX_coordinate()).intValue(),
                    (double) ((Integer) tmp.getY_coordinate()).intValue());
            polyLineName = polyLineName + "[" + tmp.getNode_name() + "] ";
            tmp = tmp.getNext();
        }

        XYSeriesCollection data = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "",
                "X",
                "Y",
                data,
                PlotOrientation.VERTICAL,
                true,
                true,
                true
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1024, 768));
        setContentPane(chartPanel);
    }
}