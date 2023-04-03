/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.facade;

import com.seot.modelos.entities.Cotizacion;
import com.seot.modelos.entities.Sucursal;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author Freddy Gonzalez
 */
@Local
public interface CotizacionFacadeLocal {

    void create(Cotizacion cotizacion);

    void edit(Cotizacion cotizacion);

    void remove(Cotizacion cotizacion);

    Cotizacion find(Object id);

    List<Cotizacion> findAll();

    List<Cotizacion> findRange(int[] range);

    int count();
    
    List<Cotizacion> findQuotationByUser(Sucursal sucursal);
    
}
