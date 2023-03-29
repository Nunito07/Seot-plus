package com.seot.controllers;

import com.seot.facade.CicloFacadeLocal;
import com.seot.facade.LineasFacadeLocal;
import com.seot.facade.PedidoFacadeLocal;
import com.seot.facade.PlaneacionFacadeLocal;
import com.seot.facade.PlaneacionFacade;
import com.seot.modelos.entities.Ciclo;
import com.seot.modelos.entities.Lineas;
import com.seot.modelos.entities.Pedido;
import com.seot.modelos.entities.Planeacion;
import java.io.Serializable;
import java.util.Date;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author dax-0
 */
@Named(value = "planeacionController")
@ViewScoped
public class planeacionController implements Serializable {
        
    
    @EJB
    private PlaneacionFacadeLocal pfl;
    
    private PlaneacionFacade pf;
    
    private List<Planeacion> listado;
    
    private BarChartModel barra;
    
    private CartesianChartModel Comparacion;
    
    @EJB
    private LineasFacadeLocal lfl;
    @EJB
    private PedidoFacadeLocal pefl;
    @EJB
    private CicloFacadeLocal cfl;

    private Integer codigoPlaneacion;
    private Integer cicloPlaneacion;
    private Integer idPedido;
    private Integer idlinea;
    private Date fechaInicio;
    
    
    private Lineas nuevalinea;
    private Pedido nuevopedido;
    private Ciclo nuevociclo;
    private Planeacion nuevaplaneacion;
    
    
     List<Planeacion> Listarplaneacion;
     
     
        @PostConstruct
    public void init() {
        
        nuevaplaneacion = new Planeacion(); 
        nuevalinea = new Lineas();
        nuevopedido = new Pedido();
        nuevociclo = new Ciclo();
        

    }
     
     
    
    
    public Lineas getNuevalinea() {
        return nuevalinea;
    }

    public void setNuevalinea(Lineas nuevalinea) {
        this.nuevalinea = nuevalinea;
    }

    public Pedido getNuevopedido() {
        return nuevopedido;
    }

    public void setNuevopedido(Pedido nuevopedido) {
        this.nuevopedido = nuevopedido;
    }

    public Ciclo getNuevociclo() {
        return nuevociclo;
    }

    public void setNuevociclo(Ciclo nuevociclo) {
        this.nuevociclo = nuevociclo;
    }

    public planeacionController() {
    }


    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    private Date fechaFin;

    public Planeacion getNuevaplaneacion() {
        return nuevaplaneacion;
    }

    public void setNuevaplaneacion(Planeacion nuevaplaneacion) {
        this.nuevaplaneacion = nuevaplaneacion;
    }

   

    
    

 

    public Integer getCodigoPlaneacion() {
        return codigoPlaneacion;
    }

    public void setCodigoPlaneacion(Integer codigoPlaneacion) {
        this.codigoPlaneacion = codigoPlaneacion;
    }

    public Integer getCicloPlaneacion() {
        return cicloPlaneacion;
    }

    public void setCicloPlaneacion(Integer cicloPlaneacion) {
        this.cicloPlaneacion = cicloPlaneacion;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdlinea() {
        return idlinea;
    }

    public void setIdlinea(Integer idlinea) {
        this.idlinea = idlinea;
    }

    public List<Planeacion> getListado() {
        return listado;
    }

    public void setListado(List<Planeacion> listado) {
        this.listado = listado;
    }

    public BarChartModel getBarra() {
        return barra;
    }

    public void setBarra(BarChartModel barra) {
        this.barra = barra;
    }
    
    
    
        public List<Planeacion> getListarplaneacion() {
        if (Listarplaneacion == null || Listarplaneacion.isEmpty()) {

            Listarplaneacion = pfl.findAll();
        }
        return Listarplaneacion;
    }
    
    
     public void setListarplaneacion(List<Planeacion> Listarplaneacion) {
        this.Listarplaneacion = Listarplaneacion;
    }


    public void crearPlan() {
        nuevalinea = lfl.find(idlinea); // mirar si se puede cambiar
        nuevopedido = pefl.find(idPedido); // mirar si se puede cambiar
        nuevociclo = cfl.find(cicloPlaneacion); // mirar si se puede cambiar
        nuevaplaneacion.setTbLineasLinCodigo(nuevalinea);
        nuevaplaneacion.setTblPedidosPedCodigoUnico(nuevopedido);
        nuevaplaneacion.setCiclo(nuevociclo);
        nuevaplaneacion.setFechaInicioCiclo(new Date());
        nuevaplaneacion.setFechaFinCiclo(new Date());
        pfl.create(nuevaplaneacion);

    }

    public void listar(){
        listado=pf.listarDomestico();
        GraficarDom();
        GraficarSemi();
        GraficarInd();
        GraficarMeta();
    }
    
    public void GraficarDom(){
        barra=new  BarChartModel();
        
        for(int i=0; i<pf.listarDomestico().size(); i++){
            ChartSeries serie=new BarChartSeries();
            serie.setLabel(pf.listarDomestico().get(i).toString());
            serie.set(pf.listarDomestico().get(i).getTblPedidosPedCodigoUnico(), pf.listarDomestico().get(i).getPlaneacionId());
           barra.addSeries(serie);
        }
        barra.setTitle("Pedidos Linea Domestica");
        barra.setLegendPosition("ne");
        barra.setAnimate(true);
        
        Axis xAxis=barra.getAxis(AxisType.X);
        xAxis.setLabel("Tiempo(Minutos)");
        Axis yAxis=barra.getAxis(AxisType.Y);
        yAxis.setLabel("Pedidos");
        yAxis.setMin(7770);
        yAxis.setMax(7790);
    }
    public void GraficarSemi(){
        barra=new  BarChartModel();
        
        for(int i=0; i<pf.listarSemi().size(); i++){
            ChartSeries serie=new BarChartSeries();
            serie.setLabel(pf.listarSemi().get(i).toString());
            serie.set(pf.listarSemi().get(i).getTblPedidosPedCodigoUnico(), pf.listarSemi().get(i).getPlaneacionId());
           barra.addSeries(serie);
        }
        barra.setTitle("Pedidos Linea Semi-Industrial");
        barra.setLegendPosition("ne");
        barra.setAnimate(true);
        
        Axis xAxis=barra.getAxis(AxisType.X);
        xAxis.setLabel("Tiempo(Minutos)");
        Axis yAxis=barra.getAxis(AxisType.Y);
        yAxis.setLabel("Pedidos");
        yAxis.setMin(7770);
        yAxis.setMax(7790);
    }
    public void GraficarInd(){
        barra=new  BarChartModel();
        
        for(int i=0; i<pf.listarIndustrial().size(); i++){
            ChartSeries serie=new BarChartSeries();
            serie.setLabel(pf.listarIndustrial().get(i).toString());
            serie.set(pf.listarIndustrial().get(i).getTblPedidosPedCodigoUnico(), pf.listarIndustrial().get(i).getPlaneacionId());
           barra.addSeries(serie);
        }
        barra.setTitle("Pedidos Linea Industrial");
        barra.setLegendPosition("ne");
        barra.setAnimate(true);
        
        Axis xAxis=barra.getAxis(AxisType.X);
        xAxis.setLabel("Tiempo(Minutos)");
        Axis yAxis=barra.getAxis(AxisType.Y);
        yAxis.setLabel("Pedidos");
        yAxis.setMin(7770);
        yAxis.setMax(7790);
    }
    public void GraficarMeta(){
        barra=new  BarChartModel();
        
        for(int i=0; i<pf.listarMetalica().size(); i++){
            ChartSeries serie=new BarChartSeries();
            serie.setLabel(pf.listarMetalica().get(i).toString());
            serie.set(pf.listarMetalica().get(i).getTblPedidosPedCodigoUnico(), pf.listarMetalico().get(i).length);
           barra.addSeries(serie);
        }
        barra.setTitle("Pedidos Linea Metalica");
        barra.setLegendPosition("ne");
        barra.setAnimate(true);
        
        Axis xAxis=barra.getAxis(AxisType.X);
        xAxis.setLabel("Tiempo(Minutos)");
        Axis yAxis=barra.getAxis(AxisType.Y);
        yAxis.setLabel("Pedidos");
        yAxis.setMin(10);
        yAxis.setMax(100);
    }
    
}