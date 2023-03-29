/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.controllers;

import com.seot.facade.ProductoFacadeLocal;
import com.seot.modelos.entities.Lineas;
import com.seot.modelos.entities.Producto;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Freddy Gonzalez
 */
@Named(value = "productocontroller")
@RequestScoped
public class Productocontroller implements Serializable{

    /**
     * Creates a new instance of Productocontroller
     */
    
    @EJB
    private ProductoFacadeLocal pfl;
    
    private Integer referencia;
    private String modelo; 
    private String pulgadas;
    private String diametro;
    private String potencia;
    private String caudal;
    private String amperios;
    private String observaciones;
    private Double valorUnitario;
    private Lineas linea;
    
     List<Producto> productos;
    
    
    public Productocontroller() {
    }
    
    
    @PostConstruct
    public void init() {
   
    }

    public Integer getReferencia() {
        return referencia;
    }

    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(String pulgadas) {
        this.pulgadas = pulgadas;
    }

    public String getDiametro() {
        return diametro;
    }

    public void setDiametro(String diametro) {
        this.diametro = diametro;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getCaudal() {
        return caudal;
    }

    public void setCaudal(String caudal) {
        this.caudal = caudal;
    }

    public String getAmperios() {
        return amperios;
    }

    public void setAmperios(String amperios) {
        this.amperios = amperios;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Lineas getLinea() {
        return linea;
    }

    public void setLinea(Lineas linea) {
        this.linea = linea;
    }

    public List<Producto> getProductos() {
        if (productos == null || productos.isEmpty()) {
            productos=pfl.findAll();
        }
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    
    
   
    
}
