/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.converters;

import com.seot.facade.CotizacionFacadeLocal;

import com.seot.modelos.entities.Cotizacion;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Cotizacion.class)
public class CotizacionConverter implements Converter {

    private CotizacionFacadeLocal cfl;

    public CotizacionConverter() {
        cfl = CDI.current().select(CotizacionFacadeLocal.class).get();
    }

    @Override
    public Cotizacion getAsObject(FacesContext fc, UIComponent uic, String value) {
        try {
            Integer id = Integer.valueOf(value);
            return cfl.find(id);
        } catch (NumberFormatException numberFormatException) {
            return null;
        }
    }
    
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Cotizacion) {
            Cotizacion cotizacion = (Cotizacion) obj;
            return cotizacion.getCotCod().toString();
        } else {
            throw new IllegalArgumentException("Object " + obj + " is not of type Cotizacion");
        }
    }

}
