package com.seot.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value = "fechaConverter")
public class FechaConverter implements Converter {

    private SimpleDateFormat sdf;

    public FechaConverter() {
        sdf = new SimpleDateFormat("yyy-MM-dd");
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            return sdf.parse(value);
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value == null) {
            return "";
        }
        if (value instanceof Date) {
            return sdf.format((Date) value);
        } else {
            throw new IllegalArgumentException("Object " + value + " is not of type java.util.Date");
        }
    }

}
