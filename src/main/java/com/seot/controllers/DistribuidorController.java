/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.controllers;

import com.seot.facade.DistribuidorFacadeLocal;
import com.seot.facade.UsuarioFacadeLocal;
import com.seot.modelos.entities.Distribuidor;
import com.seot.modelos.entities.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Administrador
 */
@Named(value = "distribuidorController")
@ViewScoped
public class DistribuidorController implements Serializable {

    @EJB
    private DistribuidorFacadeLocal dfl;
    @EJB 
    private UsuarioFacadeLocal ufl;

    private Distribuidor nuevoDistri;
    private List<Distribuidor> distriList;
    private List<Usuario> userList;

    private Integer nit;
    private String nombEmp;

    public DistribuidorController() {
    }

    public void init() {
        nuevoDistri = new Distribuidor();
        distriList = dfl.findAll();
    }

    public Distribuidor getNuevoDistri() {
        return nuevoDistri;
    }

    public void setNuevoDistri(Distribuidor nuevoDistri) {
        this.nuevoDistri = nuevoDistri;
    }

    public List<Distribuidor> getDistriList() {
        return distriList;
    }

    public void setDistriList(List<Distribuidor> distriList) {
        this.distriList = distriList;
    }

    public List<Usuario> getUserList() {
        if (userList == null || userList.isEmpty()) {
            userList = ufl.findAll();
        }
        return userList;
    }

    public void setUserList(List<Usuario> userList) {
        this.userList = userList;
    }
    
    

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public String getNombEmp() {
        return nombEmp;
    }

    public void setNombEmp(String nombEmp) {
        this.nombEmp = nombEmp;
    }

    public String regDistri() {
        String page = "/Distribuidor/dist-usuario.xhtml";

        nuevoDistri.setDistNit(getNit());
        nuevoDistri.setDistNombreEmpresa(getNombEmp());
        dfl.create(nuevoDistri);

        return page;
    }
}
