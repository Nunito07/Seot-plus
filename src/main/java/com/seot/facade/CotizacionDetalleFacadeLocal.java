/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.facade;

import com.seot.modelos.entities.CotizacionDetalle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Freddy Gonzalez
 */
@Local
public interface CotizacionDetalleFacadeLocal {

    void create(CotizacionDetalle cotizacionDetalle);

    void edit(CotizacionDetalle cotizacionDetalle);

    void remove(CotizacionDetalle cotizacionDetalle);

    CotizacionDetalle find(Object id);

    List<CotizacionDetalle> findAll();

    List<CotizacionDetalle> findRange(int[] range);

    int count();
    
}
