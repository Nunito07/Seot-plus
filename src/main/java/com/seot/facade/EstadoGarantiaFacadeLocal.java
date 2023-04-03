/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.facade;

import com.seot.modelos.entities.EstadoGarantia;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author Freddy Gonzalez
 */
@Local
public interface EstadoGarantiaFacadeLocal {

    void create(EstadoGarantia estadoGarantia);

    void edit(EstadoGarantia estadoGarantia);

    void remove(EstadoGarantia estadoGarantia);

    EstadoGarantia find(Object id);

    List<EstadoGarantia> findAll();

    List<EstadoGarantia> findRange(int[] range);

    int count();
    
}
