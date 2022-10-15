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


/**
 * Clase utilizada para visualizar los experimentos con gráficos.
 */
public class Plot extends JFrame {
    private XYSeriesCollection dataset;
    final private String graphTitle;
    final private String xLabel;
    final private String yLabel;


    /**
     * Constructor de los gráficos.
     * @param graphTitle título del gráfico
     * @param xLabel etiqueta del eje 'x'
     * @param yLabel etiqueta del eje 'y'
     */
    public Plot(String graphTitle, String xLabel, String yLabel) {
        dataset = new XYSeriesCollection();
        this.graphTitle = graphTitle;
        this.xLabel = xLabel;
        this.yLabel = yLabel;
    }

    /**
     * Agrega una serie de datos al gráfico para mostrar.
     * @param seriesName nombre de la serie
     * @param x lista con valores del eje x
     * @param y lista con valores del eje y
     */
    public void addSerie(String seriesName, int[] x, int[] y) {
        XYSeries newSeries = new XYSeries(seriesName);

        for (int i=0; i<x.length; i++) {
            newSeries.add(x[i], y[i]);            
        }

        dataset.addSeries(newSeries);
    }

    /**
     * Método utilizado para finalizar la creación del gráfico,
     * se llama luego de agregar todos los datos al gráfico.
     */
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

    /**
     * Método auxiliar para crear el gráfico,
     * establece los parámetros e inserta las series en este.
     * @param dataset colección de series a gráficar
     * @return Un objeto que incluye el gráfico
     */
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
