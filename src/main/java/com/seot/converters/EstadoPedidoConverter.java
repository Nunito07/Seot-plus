/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.converters;

import com.seot.facade.EstadoPedidoFacadeLocal;
import com.seot.modelos.entities.EstadoPedido;
import java.util.Optional;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = EstadoPedido.class)
public class EstadoPedidoConverter implements Converter {

    private EstadoPedidoFacadeLocal epfl;

    public EstadoPedidoConverter() {
        epfl = CDI.current().select(EstadoPedidoFacadeLocal.class).get();
    }

    @Override
    public EstadoPedido getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            Integer id = Integer.valueOf(value);
            return Optional.ofNullable(epfl.find(id)).orElse(null);
        } catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof EstadoPedido) {
            EstadoPedido estPed = (EstadoPedido) obj;
            return estPed.getCodEstadPed().toString();
        } else {
            throw new IllegalArgumentException("Object " + obj + " is not of type Cotizacion");
        }
    }

}
