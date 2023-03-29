/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.controllers;

import com.seot.controllers.usuarios.SessionController;
import com.seot.facade.CotizacionFacadeLocal;
import com.seot.facade.EstadoPedidoFacadeLocal;
import com.seot.facade.PedidoFacadeLocal;
import com.seot.facade.SucursalFacadeLocal;
import com.seot.modelos.entities.Cotizacion;
import com.seot.modelos.entities.CotizacionDetalle;
import com.seot.modelos.entities.CotizacionDetallePK;
import com.seot.modelos.entities.Pedido;
import com.seot.modelos.entities.Producto;
import com.seot.modelos.entities.Sucursal;
import com.seot.utils.MessagesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author WILLY
 */
@Named(value = "cotizacionController")
@ViewScoped
public class CotizacionController implements Serializable {

    @EJB
    private CotizacionFacadeLocal cfl;

    @EJB
    private SucursalFacadeLocal sfl;
    @EJB
    private PedidoFacadeLocal pfl;
    @EJB
    private EstadoPedidoFacadeLocal epfl;

    @Inject
    private SessionController sc;

    private Producto producSeleccionado;
    private Cotizacion nuevaSolicitud;
    private CotizacionDetalle nuevoDetalle;
    private Cotizacion cotSelect;

    private Integer codigo;
    private Date fechaConsulta;
    private Double valorTotal;
    private Sucursal sucursal;

    private List<Cotizacion> cotizaciones;

    public CotizacionController() {

    }

    @PostConstruct
    public void init() {
        producSeleccionado = null;
        nuevaSolicitud = new Cotizacion();
        nuevaSolicitud.setCotizacionDetalleList(new ArrayList<>());
        cotizaciones = null;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Producto getProducSeleccionado() {
        return producSeleccionado;
    }

    public void setProducSeleccionado(Producto producSeleccionado) {
        this.producSeleccionado = producSeleccionado;
    }

    public Cotizacion getNuevaSolicitud() {
        return nuevaSolicitud;
    }

    public void setNuevaSolicitud(Cotizacion nuevaSolicitud) {
        this.nuevaSolicitud = nuevaSolicitud;
    }

    public CotizacionDetalle getNuevoDetalle() {
        return nuevoDetalle;
    }

    public void setNuevoDetalle(CotizacionDetalle nuevoDetalle) {
        this.nuevoDetalle = nuevoDetalle;
    }

    public List<Cotizacion> getCotizaciones() {
        if (cotizaciones == null || cotizaciones.isEmpty()) {
            cotizaciones = cfl.findQuotationByUser(sc.getUser().getSucursal());
        }

        return cotizaciones;
    }

    public void setCotizaciones(List<Cotizacion> cotizaciones) {
        this.cotizaciones = cotizaciones;
    }

    public Cotizacion getCotSelect() {
        return cotSelect;
    }

    public void setCotSelect(Cotizacion cotSelect) {
        this.cotSelect = cotSelect;
    }

    public void selectCot(Cotizacion cot) {
        System.out.println("Cotización selecionada");
        System.out.println("Codigo: " + cot.getCotCod());
        cotSelect = cot;

    }

    public void seleccionarproducto(Producto p) {
        nuevoDetalle = new CotizacionDetalle();
        producSeleccionado = p;
        nuevoDetalle.setProducto(p);
        nuevoDetalle.setCotizacion(nuevaSolicitud);
        CotizacionDetallePK cdpk = new CotizacionDetallePK();
        cdpk.setCotDetalleProdRef(producSeleccionado.getProdReferencia());
        cdpk.setCotDetalleCodigo(nuevaSolicitud.getCotCod());
        nuevoDetalle.setCotizacionDetallePK(cdpk);
    }

    public void agregarDetalle() {
        CotizacionDetalle temp = encontrarNuevaOrden();
        if (temp == null) {
            System.out.println("cdknzknakflsdknfsdnkfnsdnfklsdnlflsdnfsdlf");
            System.out.println(nuevaSolicitud);
            System.out.println("njknsjdknakdnkasndlsankdnasndklnalndlasnldnklasnkldnalsnd");
            System.out.println(producSeleccionado);
            System.out.println("urewriweirowueurwueourwe");
            System.out.println(nuevoDetalle);
            nuevoDetalle.setCotDetallePrecioUnit(producSeleccionado.getProdvalorUnitario());
            nuevaSolicitud.getCotizacionDetalleList().add(nuevoDetalle);
            nuevaSolicitud.setCotValortotal(nuevaSolicitud.getCotValortotal() + (nuevoDetalle.getProducto().getProdvalorUnitario() * nuevoDetalle.getCotDetalleCantidad()));
        } else {
            temp.setCotDetalleCantidad(temp.getCotDetalleCantidad() + nuevoDetalle.getCotDetalleCantidad());
        }
        System.out.println("------------------------------------------------------------");
        for (CotizacionDetalle cd : nuevaSolicitud.getCotizacionDetalleList()) {
            System.out.println(cd.getProducto().getProdModelo() + "-" + cd.getCotDetalleCantidad());
        }
    }

    public void cotizacion() {
        List<CotizacionDetalle> cotTemp = nuevaSolicitud.getCotizacionDetalleList();
        nuevaSolicitud.setCotFechaConsulta(new Date());
        if(nuevaSolicitud.getCotCod() == null){
            nuevaSolicitud.setCotizacionDetalleList(null);
            nuevaSolicitud.setTblSucursalesUsuId(sc.getUser().getSucursal());
            cfl.create(nuevaSolicitud);
            for (CotizacionDetalle cd : cotTemp) {
                cd.getCotizacionDetallePK().setCotDetalleCodigo(nuevaSolicitud.getCotCod());
            }
            nuevaSolicitud.setCotizacionDetalleList(cotTemp);
        }
        System.out.println(nuevaSolicitud.getCotizacionDetalleList().size());
        cfl.edit(nuevaSolicitud);
        init();
    }

    public CotizacionDetalle encontrarNuevaOrden() {
        for (CotizacionDetalle cd : nuevaSolicitud.getCotizacionDetalleList()) {
            if (cd.getProducto().getProdModelo().equals(producSeleccionado.getProdModelo())) {
                return cd;
            }
        }
        return null;

    }

    public void eliminarCot() {
        cfl.remove(cotSelect);
        cotizaciones = null;
    }
    
    public void preEditar(){
        nuevaSolicitud = cotSelect;
        cotSelect = null;
    }
    
    public void confirmarPedido(){
        Pedido p = new Pedido(null, new Date());
        p.setTblcotizacionCotCod(cotSelect);
        p.setTblEstadoPedidocodestadped(epfl.find(8882));
        pfl.create(p);
        MessagesUtil.info(null, "Se ha realizado su pedido", "Se le notificará cuando se realice alguna actualización sobre este.", Boolean.TRUE);
        init();
    }

}
