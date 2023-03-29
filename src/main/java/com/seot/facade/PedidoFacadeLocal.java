/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.facade;

import com.seot.modelos.entities.EstadoPedido;
import com.seot.modelos.entities.Pedido;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Freddy Gonzalez
 */
@Local
public interface PedidoFacadeLocal {

    void create(Pedido pedido);

    void edit(Pedido pedido);

    void remove(Pedido pedido);

    Pedido find(Object id);

    List<Pedido> findAll();

    List<Pedido> findRange(int[] range);

    int count();
    List<Pedido> findXfechaConsulta(Date fechaIni, Date fechaFin);
    List<Pedido> findXestadoPedido(EstadoPedido codEstado);
    List<Pedido> findXestadoRecep();
    List<Object[]> countXRecep();
    List<Object[]> countXProduccion();
    List<Object[]> countXEmpaque();
    List<Object[]> countXEnviadas();
    List<Object[]> countXCanceladas();
    List<Pedido> pedsXsesion(Integer id);
    


  
    
}
