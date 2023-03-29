/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.controllers;

import com.seot.facade.EstadoPedidoFacadeLocal;
import com.seot.modelos.entities.EstadoPedido;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Yuly Morales
 */
@Named(value = "estadoPedidoController")
@ViewScoped
public class EstadoPedidoController implements Serializable{

    @EJB
    private EstadoPedidoFacadeLocal epfl;
    
    private Integer codigo;
    private String tipo;
    private List <EstadoPedido> estados;
    
    public EstadoPedidoController() {
    }
    
    public void init(){
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<EstadoPedido> getEstados() {
        if (estados == null || estados.isEmpty()) {
          estados=epfl.findAll();
        }
        return estados;
    }

    public void setEstados(List<EstadoPedido> estados) {
        this.estados = estados;
    }
    
    
    
    
}
