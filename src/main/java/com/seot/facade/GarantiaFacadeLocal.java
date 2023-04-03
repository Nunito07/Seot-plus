/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.facade;

import com.seot.modelos.entities.Garantia;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author Freddy Gonzalez
 */
@Local
public interface GarantiaFacadeLocal {

    void create(Garantia garantia);

    void edit(Garantia garantia);

    void remove(Garantia garantia);

    Garantia find(Object id);

    List<Garantia> findAll();

    List<Garantia> findRange(int[] range);

    int count();
    
     List<Object[]>findBytotalgarantia();
     List<Object[]>findByGarantiaUser(Integer id);
    
}
