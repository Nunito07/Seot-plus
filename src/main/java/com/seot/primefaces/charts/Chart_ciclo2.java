package com.seot.primefaces.charts;
 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartSeries;
 
@ManagedBean
public class Chart_ciclo2 implements Serializable {
 
    private CartesianChartModel combinedModel;
 
    @PostConstruct
    public void init() {
        createCombinedModel();
    }
 
    public CartesianChartModel getCombinedModel() {
        return combinedModel;
    }
     
    private void createCombinedModel() {
        combinedModel = new BarChartModel();
 
        BarChartSeries comp = new BarChartSeries();
        comp.setLabel("Linea");
 
        comp.set("Pedido 1 - Domestico", 52);
        comp.set("Pedido 1 - Semi-Industrial", 69);
        comp.set("Pedido 1 - Industrial", 33);
        comp.set("Pedido 1 - Metalica", 44);
        comp.set("Pedido 2 - Domestico", 60);
        comp.set("Pedido 2 - Semi-Industrial", 30);
        comp.set("Pedido 2 - Industrial", 43);
        comp.set("Pedido 2 - Metalica", 51);
        comp.set("Pedido 3 - Domestico", 82);
        comp.set("Pedido 3 - Semi-Industrial", 74);
        comp.set("Pedido 3 - Industrial", 66);
        comp.set("Pedido 3 - Metalica", 76);

        LineChartSeries dom = new LineChartSeries();
        dom.setLabel("Domestica");
 
        dom.set("Pedido 1 - Domestico", 52);
        dom.set("Pedido 1 - Semi-Industrial", null);
        dom.set("Pedido 1 - Industrial", null);
        dom.set("Pedido 1 - Metalica", null);
        dom.set("Pedido 2 - Domestico", 60);
        dom.set("Pedido 2 - Semi-Industrial", null);
        dom.set("Pedido 2 - Industrial", null);
        dom.set("Pedido 2 - Metalica", null);
        dom.set("Pedido 3 - Domestico", 82);
        dom.set("Pedido 3 - Semi-Industrial", null);
        dom.set("Pedido 3 - Industrial", null);
        dom.set("Pedido 3 - Metalica", null);
  
        LineChartSeries semi = new LineChartSeries();
        semi.setLabel("Semi-Industrial");
 
        semi.set("Pedido 1 - Domestico", null);
        semi.set("Pedido 1 - Semi-Industrial", 69);
        semi.set("Pedido 1 - Industrial", null);
        semi.set("Pedido 1 - Metalica", null);
        semi.set("Pedido 2 - Domestico", null);
        semi.set("Pedido 2 - Semi-Industrial", 30);
        semi.set("Pedido 2 - Industrial", null);
        semi.set("Pedido 2 - Metalica", null);
        semi.set("Pedido 3 - Domestico", null);
        semi.set("Pedido 3 - Semi-Industrial", 74);
        semi.set("Pedido 3 - Industrial", null);
        semi.set("Pedido 3 - Metalica", null);
         
        LineChartSeries ind = new LineChartSeries();
        ind.setLabel("Industrial");
 
        ind.set("Pedido 1 - Domestico", null);
        ind.set("Pedido 1 - Semi-Industrial", null);
        ind.set("Pedido 1 - Industrial", 33);
        ind.set("Pedido 1 - Metalica", null);
        ind.set("Pedido 2 - Domestico", null);
        ind.set("Pedido 2 - Semi-Industrial", null);
        ind.set("Pedido 2 - Industrial", 43);
        ind.set("Pedido 2 - Metalica", null);
        ind.set("Pedido 3 - Domestico", null);
        ind.set("Pedido 3 - Semi-Industrial", null);
        ind.set("Pedido 3 - Industrial", 66);
        ind.set("Pedido 3 - Metalica", null);
         
        LineChartSeries meta = new LineChartSeries();
        meta.setLabel("Metalica");
 
        meta.set("Pedido 1 - Domestico", null);
        meta.set("Pedido 1 - Semi-Industrial", null);
        meta.set("Pedido 1 - Industrial", null);
        meta.set("Pedido 1 - Metalica", 44);
        meta.set("Pedido 2 - Domestico", null);
        meta.set("Pedido 2 - Semi-Industrial", null);
        meta.set("Pedido 2 - Industrial", null);
        meta.set("Pedido 2 - Metalica", 51);
        meta.set("Pedido 3 - Domestico", null);
        meta.set("Pedido 3 - Semi-Industrial", null);
        meta.set("Pedido 3 - Industrial", null);
        meta.set("Pedido 3 - Metalica", 76);
 
        combinedModel.addSeries(comp);
        combinedModel.addSeries(dom);
        combinedModel.addSeries(semi);
        combinedModel.addSeries(ind);
        combinedModel.addSeries(meta);
         
        combinedModel.setTitle("Comparación por ciclos");
        combinedModel.setLegendPosition("ne");
        combinedModel.setMouseoverHighlight(true);
        combinedModel.setShowDatatip(false);
        combinedModel.setShowPointLabels(true);
        Axis yAxis = combinedModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
     
}