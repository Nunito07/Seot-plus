/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.controllers;

import com.seot.controllers.usuarios.SessionController;
import com.seot.facade.GarantiaFacadeLocal;
import com.seot.facade.PedidoFacadeLocal;
import com.seot.modelos.entities.Garantia;
import com.seot.modelos.entities.Pedido;
import com.seot.modelos.entities.Producto;
import com.seot.utils.MessagesUtil;

import java.util.Date;
import java.util.List;
import jakarta.ejb.EJB;
import java.io.Serializable;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;

import jakarta.inject.Named;




/**
 *
 * @author Freddy Gonzalez
 */
@Named(value = "garantiasControlleres")
@ViewScoped
public class GarantiasControlleres implements Serializable {
    
    
    
            
    @EJB
    private GarantiaFacadeLocal garantiaFacade;
    @EJB
    private PedidoFacadeLocal productoFacade;
    
    @Inject
    private SessionController sc;
    
    
    private List<Garantia> garantia;
    private Garantia garantiaSeleccionada;
    private List<Integer> diasDeGarantia;
    private List<Object[]> totalg;
    private List<Object[]> garantiaUser;
    
    
    private Integer codigoGarantia;
    private Date fechaVencimiento;
    private Date fechaIngreso;
    private Date fechaSalida;
    private String novedad;
    private String notificaciones;
    
    
    private Producto nuevoproducto;
    private Integer idp;


   
    public GarantiasControlleres() {
    }

    @PostConstruct
    public void init() {
        nuevoproducto = new Producto();
    }

    public List<Garantia> getGarantia() {
        if (garantia == null || garantia.isEmpty()) {
            garantia = garantiaFacade.findAll();
        }
        return garantia;
    }

    public Integer getIdp() {
        return idp;
    }

    public void setIdp(Integer idp) {
        this.idp = idp;
    }

    public Producto getNuevoproducto() {
        return nuevoproducto;
    }

    public void setNuevoproducto(Producto nuevoproducto) {
        this.nuevoproducto = nuevoproducto;
    }
    


    public Integer getCodigoGarantia() {
        return codigoGarantia;
    }

    public void setCodigoGarantia(Integer codigoGarantia) {
        this.codigoGarantia = codigoGarantia;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getNovedad() {
        return novedad;
    }

    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }

    public String getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(String notificaciones) {
        this.notificaciones = notificaciones;
    }

    public List<Object[]> getGarantiaUser() {
        
        if (garantiaUser == null || garantiaUser.isEmpty()) {
            garantiaUser = garantiaFacade.findByGarantiaUser(sc.getUser().getUsuId());
        }
        return garantiaUser;
    }

    public void setGarantiaUser(List<Object[]> garantiaUser) {
        this.garantiaUser = garantiaUser;
    }

    
    
    
    
    public Garantia getGarantiaSeleccionada() {
        return garantiaSeleccionada;
    }

        public void seleccionarGarantia(Garantia g) {
        garantiaSeleccionada = g;
    }

    public List<Object[]> getTotalg() {
        if (totalg == null || totalg.isEmpty()) {
            totalg = garantiaFacade.findBytotalgarantia();
            
        }
        return totalg;
    }

    public void setTotalg(List<Object[]> totalg) {
        this.totalg = totalg;
    }
       
    public String registrarGarantia() {

        try {
            Garantia u = new Garantia(codigoGarantia, fechaVencimiento, fechaIngreso, fechaSalida, novedad, notificaciones);
            garantiaFacade.create(u);
            MessagesUtil.info(null, "Éxito al crear garantia", "Garantia registrada correctamente.", true);
            return "listar.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            MessagesUtil.error(null, "Error al registrar", ex.getMessage(), false);
        }
        return "";
    }

    public void eliminarGarantia() {
        try {
            garantiaFacade.remove(garantiaSeleccionada);
            garantia = null;
            MessagesUtil.info(null, "Éxito  al eliminar ", "la garantia se ha eliminado correctamente.", true);
        } catch (Exception e) {
            MessagesUtil.error(null, "Error al elimnar", e.getMessage(), true);
        }
    }

    public void editarGarantia() {
        try {
            garantiaFacade.edit(garantiaSeleccionada);
            garantia = null;
            MessagesUtil.info(null, "Éxito al editar", "notificación modificada correctamente.", true);
        } catch (Exception e) {
            MessagesUtil.error(null, "Error al editar", e.getMessage(), true);
        }
    }
    

    

    


}
    
    
    
    
    
    
    
    
    
    
    
    
    
    

