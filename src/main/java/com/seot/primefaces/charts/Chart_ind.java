package com.seot.primefaces.charts;
 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;
 
@ManagedBean
public class Chart_ind implements Serializable {
 
    private HorizontalBarChartModel horizontalBarModel;
 
    @PostConstruct
    public void init() {
        createBarModels();
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
 
     
    private void createBarModels() {
        createHorizontalBarModel();
    }
      
     
    private void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();
 
        ChartSeries ciclo1 = new ChartSeries();
        ciclo1.setLabel("Ciclo 1");
        ciclo1.set("7779", 60);
        ciclo1.set("7783", 45);
        ciclo1.set("7789", 60);
        
        ChartSeries ciclo2 = new ChartSeries();
        ciclo2.setLabel("Ciclo 2");
        ciclo2.set("7779", 60);
        ciclo2.set("7783", 45);
        ciclo2.set("7789", 60);

 
        ChartSeries ciclo3 = new ChartSeries();
        ciclo3.setLabel("Ciclo 3");
        ciclo3.set("7779", 60);
        ciclo3.set("7783", 45);
        ciclo3.set("7789", 60);
 
        ChartSeries ciclo4 = new ChartSeries();
        ciclo4.setLabel("Ciclo 4");
        ciclo4.set("7779", 60);
        ciclo4.set("7783", 45);
        ciclo4.set("7789", 60);
        
        horizontalBarModel.addSeries(ciclo1);
        horizontalBarModel.addSeries(ciclo2);
        horizontalBarModel.addSeries(ciclo3);
        horizontalBarModel.addSeries(ciclo4);
         
        horizontalBarModel.setTitle("Linea Industrial");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
         
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Tiempo (Minutos)");
        xAxis.setMin(0);
        xAxis.setMax(400);
         
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Pedido");        
    }
 
}