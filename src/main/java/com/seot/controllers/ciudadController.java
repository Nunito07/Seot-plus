/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.controllers;

import com.seot.facade.CiudadFacadeLocal;
import com.seot.modelos.entities.Ciudad;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

/**
 *
 * @author Duilia
 */
@Named(value = "ciudadController")
@RequestScoped
public class ciudadController {

    /**
     * Creates a new instance of ciudadController
     */
    
    @EJB
    private CiudadFacadeLocal cfl;
    
    private List<Ciudad> ciuList;
    private Ciudad ciudad;
    
    
    public ciudadController() {
    }
    
    @PostConstruct
    public void init(){
        Ciudad city = new Ciudad();
    }

    public List<Ciudad> getCiuList() {
        if (ciuList == null || ciuList.isEmpty()) {
            ciuList = cfl.findAll();
        }
        return ciuList;
    }

    public void setCiuList(List<Ciudad> ciuList) {
        this.ciuList = ciuList;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    
    
}
