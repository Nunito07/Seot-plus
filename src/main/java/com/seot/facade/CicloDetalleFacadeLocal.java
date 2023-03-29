/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.facade;

import com.seot.modelos.entities.CicloDetalle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Freddy Gonzalez
 */
@Local
public interface CicloDetalleFacadeLocal {

    void create(CicloDetalle cicloDetalle);

    void edit(CicloDetalle cicloDetalle);

    void remove(CicloDetalle cicloDetalle);

    CicloDetalle find(Object id);

    List<CicloDetalle> findAll();

    List<CicloDetalle> findRange(int[] range);

    int count();
    
}
