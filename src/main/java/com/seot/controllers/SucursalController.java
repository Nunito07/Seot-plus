/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.controllers;

import com.seot.facade.CiudadFacadeLocal;
import com.seot.facade.DistribuidorFacadeLocal;
import com.seot.facade.SucursalFacadeLocal;
import com.seot.facade.UsuarioFacadeLocal;
import com.seot.modelos.entities.Ciudad;
import com.seot.modelos.entities.Distribuidor;
import com.seot.modelos.entities.Sucursal;
import com.seot.modelos.entities.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;

/**
 *
 * @author Administrador
 */
@Named(value = "sucursalController")
@ViewScoped
public class SucursalController implements Serializable {

    @EJB
    private SucursalFacadeLocal sfl;
    @EJB
    private CiudadFacadeLocal cfl;
    @EJB
    private DistribuidorFacadeLocal dfl;
    @EJB
    private UsuarioFacadeLocal ufl;

    private Sucursal newSucur;
    private List<Sucursal> sucurList;
    private Ciudad ciudad;
    private List<Ciudad> ciuList;
    private Distribuidor distri;
    private List<Distribuidor> distriList;
    private Usuario user;
    private List<Usuario> userList;

    private Integer idCuidad;
    private Integer idDistri;
    private Integer idUser;
    private String nbSucur;
    private Date fechaReg;

    public SucursalController() {
    }

    @PostConstruct
    public void init() {
        ciudad = new Ciudad();
        newSucur = new Sucursal();

    }

    public SucursalFacadeLocal getSfl() {
        return sfl;
    }

    public void setSfl(SucursalFacadeLocal sfl) {
        this.sfl = sfl;
    }

    public List<Sucursal> getSucurList() {
        return sucurList;
    }

    public void setSucurList(List<Sucursal> sucurList) {
        this.sucurList = sucurList;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
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

    public Distribuidor getDistri() {
        return distri;
    }

    public void setDistri(Distribuidor distri) {
        this.distri = distri;
    }

    public List<Distribuidor> getDistriList() {
        if (distriList == null || distriList.isEmpty()) {

            distriList = dfl.findAll();
        }
        return distriList;
    }

    public void setDistriList(List<Distribuidor> distriList) {
        this.distriList = distriList;
    }

    public Integer getIdCuidad() {
        return idCuidad;
    }

    public void setIdCuidad(Integer idCuidad) {
        this.idCuidad = idCuidad;
    }

    public Integer getIdDistri() {
        return idDistri;
    }

    public void setIdDistri(Integer idDistri) {
        this.idDistri = idDistri;
    }

    public Sucursal getNewSucur() {
        return newSucur;
    }

    public void setNewSucur(Sucursal newSucur) {
        this.newSucur = newSucur;
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

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getNbSucur() {
        return nbSucur;
    }

    public void setNbSucur(String nbSucur) {
        this.nbSucur = nbSucur;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public String crearSucursal() {

        String page = "";
        newSucur.setSucurNombre(nbSucur);
        newSucur.setSucurFechaRegistro(fechaReg);
        newSucur.setTblciudadCiudCodigo(ciudad);
        newSucur.setTbldistribuidorDistCod(distri);
        sfl.create(newSucur);
        return page;
    }
    
    public String registrarSucursal(){
    
        Sucursal sucur= new Sucursal(nbSucur, fechaReg);
        try {
            sucur.setTblciudadCiudCodigo(ciudad);
            sucur.setTbldistribuidorDistCod(distri);
            System.out.println("Pasóooooo");
            sfl.create(sucur);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "dist-usuario.xhtml";
        
    }
}
