package utils;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class Plot extends JFrame {
    private XYSeriesCollection dataset;
    final private String graphTitle;
    final private String xLabel;
    final private String yLabel;


    public Plot(String graphTitle, String xLabel, String yLabel) {
        dataset = new XYSeriesCollection();
        this.graphTitle = graphTitle;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
    }

    public void addSerie(String seriesName, int[] x, int[] y) {
        XYSeries newSeries = new XYSeries(seriesName);

        for (int i=0; i<x.length; i++) {
            newSeries.add(x[i], y[i]);            
        }

        dataset.addSeries(newSeries);
    }

    public void finish() {
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.WHITE);

        add(chartPanel);

        pack();
        setTitle("Gráfico");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JFreeChart createChart(final XYSeriesCollection dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(
            graphTitle, 
            xLabel, 
            yLabel, 
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.WHITE);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle(graphTitle, new Font("Serif", Font.BOLD, 18)));

        return chart;
    }
}
