package textdatamining;

import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class JFreeChartBar extends ApplicationFrame {

    AllFinalsVariables f = new AllFinalsVariables();
    private ArrayList<Float> freqList;
    private float sumALL;
    private int height;

    int width;
    
    public JFreeChartBar(String applicationTitle, String chartTitle, ArrayList<Float> freqList, float sumALL, int height) {
        super(applicationTitle);
        this.freqList = freqList;
        this.sumALL = sumALL;
        this.height = height;

        JFreeChart barChart = ChartFactory.createBarChart3D(
                  chartTitle,
                  "Category",
                  "Score",
                  createDataset(),
                  PlotOrientation.VERTICAL,
                  true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(width, height));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset() {
        String rate = "RATE";

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        width = 400;
        if (freqList.get(0) != 0) {
            dataset.addValue(Rates(sumALL, freqList.get(0)), rate, f.sunt);
            width +=100;
        }
        if (freqList.get(1) != 0) {
            dataset.addValue(Rates(sumALL, freqList.get(1)), rate, f.sdoe);
            width +=100;
        }
        if (freqList.get(2) != 0) {
            dataset.addValue(Rates(sumALL, freqList.get(2)), rate, f.kPold);
            width +=100;
        }
        if (freqList.get(3) != 0) {
            dataset.addValue(Rates(sumALL, freqList.get(3)), rate, f.daspd);
            width +=100;
        }
        if (freqList.get(4) != 0) {
            dataset.addValue(Rates(sumALL, freqList.get(4)), rate, f.esda1);
            width +=100;
        }
        if (freqList.get(5) != 0) {
            dataset.addValue(Rates(sumALL, freqList.get(5)), rate, f.pk);
            width +=100;
        }
        if (freqList.get(6) != 0) {
            dataset.addValue(Rates(sumALL, freqList.get(6)), rate, f.kpd);
            width +=100;
        }
        if (freqList.get(7) != 0) {
            dataset.addValue(Rates(sumALL, freqList.get(7)), rate, f.n);
            width +=100;
        }
        if (freqList.get(8) != 0) {
            dataset.addValue(Rates(sumALL, freqList.get(8)), rate, f.ndotd);
            width +=100;
        }
        if (freqList.get(9) != 0) {
            dataset.addValue(Rates(sumALL, freqList.get(9)), rate, f.dikasthriou);
            width +=100;
        }
        if (freqList.get(10) != 0) {
            dataset.addValue(Rates(sumALL, freqList.get(10)), rate, f.plhmmleiodikeiou);
            width +=100;
        }
        if (freqList.get(11) != 0) {
            dataset.addValue(Rates(sumALL, freqList.get(11)), rate, f.efeteiou1);
            width +=100;
        }
        if (freqList.get(12) != 0) {
            dataset.addValue(Rates(sumALL, freqList.get(12)), rate, f.protodikeiou);
            width +=100;
        }
        if (freqList.get(13) != 0) {
            dataset.addValue(Rates(sumALL, freqList.get(13)), rate, f.eurvpaikhsSumvasews);
            width +=100;
        }
        if (freqList.get(14) != 0) {
            dataset.addValue(Rates(sumALL, freqList.get(14)), rate, f.Ak1);
            width +=100;
        }

        return dataset;
    }
    
    private float Rates(float sum1, float sum2) { //Ypologizei to pososto emfanishs ths kathe kathgorias
        float rate = (sum2 * 100) / sum1;
        return rate;
    }
}
