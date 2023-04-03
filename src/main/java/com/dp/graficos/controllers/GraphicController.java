/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dp.graficos.controllers;

import com.google.gson.Gson;
import com.seot.facade.GarantiaFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;

/**
 *
 * @author Ismael
 */
@Named(value = "graphicController")
@RequestScoped
public class GraphicController {

    private List<DatoGrafico> datos;

    @EJB
    private GarantiaFacadeLocal gfl;

    private List<Object[]> listaobjetogarantia;

    public GraphicController() {
    }

    @PostConstruct
    public void init() {

        listaobjetogarantia = new ArrayList<>();

    }

    public List<Object[]> getListaobjetogarantia() {
        if (listaobjetogarantia == null || listaobjetogarantia.isEmpty()) {
            listaobjetogarantia = gfl.findBytotalgarantia();

        }
        return listaobjetogarantia;
    }

    public void setListaobjetogarantia(List<Object[]> listaobjetogarantia) {
        this.listaobjetogarantia = listaobjetogarantia;
    }

    public List<DatoGrafico> getDatos() {
        if (datos == null || datos.isEmpty()) {
            datos = new ArrayList<>();
            getListaobjetogarantia();
            for (int i = 0; i <4; i++) {
                datos.add(new DatoGrafico(i+1,(Long) listaobjetogarantia.get(i)[1],(String)listaobjetogarantia.get(i)[0]));

            }
        }
        return datos;
    }

    public String getDatosJson() {
        Gson gson = new Gson();
        return gson.toJson(getDatos());
    }

   /* public void nuevosDatos() {
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getPartialViewContext().getEvalScripts().add("updateDatos(" + getDatosJson() + ")");
        datos = null;
    }*/
    public void nuevosDatos() {
    FacesContext fc = FacesContext.getCurrentInstance();
    fc.getPartialViewContext().getRenderIds().add("actualizarDatos");
    datos = null;
}

    public void actualizaDatos() {
        datos = null;
    }

}
