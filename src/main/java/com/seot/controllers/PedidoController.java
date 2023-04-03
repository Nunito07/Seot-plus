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
import com.seot.modelos.entities.EstadoPedido;
import com.seot.modelos.entities.Pedido;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;


/**
 *
 * @author WILLY
 */
@Named(value = "pedidoController")
@ViewScoped
public class PedidoController implements Serializable {

    @EJB
    private PedidoFacadeLocal pfl;

    @EJB
    private EstadoPedidoFacadeLocal epfl;

    @EJB
    private CotizacionFacadeLocal cfl;
    
    @Inject
    private SessionController sc;

    private List<Pedido> pedidos;
    private Pedido nuevoPedido;
    private Pedido pedidoSeleccionado;
    private Date fechaIni;
    private Date fechaFin;
    private EstadoPedido estadoPed;

    private List<Pedido> pedFechas;
    private List<Pedido> pedEstado;
    private List<Pedido> pedRecepcion;
    private List<Pedido> pedSession;
            
    private List<Object[]> countCancel;
    private List<Object[]> countRecep;
    private List<Object[]> countProduc;
    private List<Object[]> countEmp;
    private List<Object[]> countEnv;




    public PedidoController() {
    }

    @PostConstruct
    public void init() {
        nuevoPedido = new Pedido();
    }

    public List<Pedido> getPedSession() {
        if (pedSession == null || pedSession.isEmpty()) {
            pedSession=pfl.pedsXsesion(sc.getUser().getUsuId());
        }
        return pedSession;
    }

    public void setPedSession(List<Pedido> pedSession) {
        this.pedSession = pedSession;
    }

    
    public List<Pedido> getPedidos() {
        if (pedidos == null || pedidos.isEmpty()) {
            pedidos = pfl.findAll();
            
        }
        return pedidos;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<Pedido> getPedFechas() {
        if (pedFechas == null || pedFechas.isEmpty()) {
            pedFechas = pfl.findAll();
        }
        return pedFechas;
    }

    public void setPedFechas(List<Pedido> pedFechas) {
        this.pedFechas = pedFechas;
    }

    public List<Pedido> getPedEstado() {
        if (pedEstado == null || pedEstado.isEmpty()) {
            pedEstado = pfl.findAll();
        }
        return pedEstado;
    }

    public void setPedEstado(List<Pedido> pedEstado) {
        this.pedEstado = pedEstado;
    }

    public List<Pedido> getPedRecepcion() {
        if (pedRecepcion == null || pedRecepcion.isEmpty()) {
            pedRecepcion = pfl.findXestadoRecep();
        }
        return pedRecepcion;
    }

    public List<Object[]> getCountRecep() {
        if (countRecep== null || countRecep.isEmpty()) {
            countRecep=pfl.countXRecep();
        }
        return countRecep;
    }

    public void setCountRecep(List<Object[]> countRecep) {
        this.countRecep = countRecep;
    }

    public List<Object[]> getCountCancel() {
        if (countCancel== null || countCancel.isEmpty()) {
            countCancel=pfl.countXCanceladas();
        }
        return countCancel;
    }

    public void setCountCancel(List<Object[]> countCancel) {
        this.countCancel = countCancel;
    }

    public List<Object[]> getCountProduc() {
        if (countProduc== null || countProduc.isEmpty()) {
            countProduc=pfl.countXProduccion();
        }
        return countProduc;
    }

    public void setCountProduc(List<Object[]> countProduc) {
        this.countProduc = countProduc;
    }

    public List<Object[]> getCountEmp() {
        if (countEmp== null || countEmp.isEmpty()) {
            countEmp=pfl.countXEmpaque();
        }
        return countEmp;
    }

    public void setCountEmp(List<Object[]> countEmp) {
        this.countEmp = countEmp;
    }

    public List<Object[]> getCountEnv() {
        if (countEnv== null || countEnv.isEmpty()) {
            countEnv=pfl.countXEnviadas();
        }
        return countEnv;
    }

    public void setCountEnv(List<Object[]> countEnv) {
        this.countEnv = countEnv;
    }
    
    public void setPedRecepcion(List<Pedido> pedRecepcion) {
        this.pedRecepcion = pedRecepcion;
    }
    public EstadoPedido getEstadoPed() {
        return estadoPed;
    }

    public void setEstadoPed(EstadoPedido estadoPed) {
        this.estadoPed = estadoPed;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Pedido getNuevoPedido() {
        return nuevoPedido;
    }

    public void setNuevoPedido(Pedido nuevoPedido) {
        this.nuevoPedido = nuevoPedido;
    }

    public Pedido getPedidoSeleccionado() {
        return pedidoSeleccionado;
    }

    public void setPedidoSeleccionado(Pedido pedidoSeleccionado) {
        this.pedidoSeleccionado = pedidoSeleccionado;
        System.out.println(pedidoSeleccionado);
    }

    public void seleccionarPedido(Pedido ped) {
        System.out.println("Se seleccionó el pedido:");
        System.out.println("CodigoUnico:" + ped.getPedCodigoUnico());
        pedidoSeleccionado = ped;
    }

    public void registrarPedido() {
        pfl.create(nuevoPedido);
    }

    public String editarPedido() {

        try {
            pfl.edit(pedidoSeleccionado);
            pedidos = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        pedidoSeleccionado = null;
        return "admin-pedidos.xhtml";
    }

    public void eliminar() {
        pfl.remove(pedidoSeleccionado);
        pedidos = null;
    }

    public void filtrarPedidos() {

        try {

            System.out.println("Date 1: " + fechaIni);
            pedFechas = pfl.findXfechaConsulta(fechaIni, fechaFin);
            for (Pedido pedido : pedFechas) {
                System.out.println(pedido);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void filtrarPedidosXEstado() {

        try {
            System.out.println("Estado:" + estadoPed);
            pedEstado = pfl.findXestadoPedido(estadoPed);
            for (Pedido pedido : pedEstado) {
                System.out.println(pedido);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enviarProduccion() {
        try {
            
            pedidoSeleccionado.getTblEstadoPedidocodestadped().setCodEstadPed(8883);
            System.out.println("Ahora el estado es :" + pedidoSeleccionado.getTblEstadoPedidocodestadped().getCodEstadPed());
            pfl.edit(pedidoSeleccionado);
            pedidoSeleccionado = null;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void cancelarPedido(){
        pedidoSeleccionado.getTblEstadoPedidocodestadped().setCodEstadPed(8881);
        System.out.println("Ahora el pedido esta cancelado");
        pfl.edit(pedidoSeleccionado);
        pedidoSeleccionado=null;
    }
}
