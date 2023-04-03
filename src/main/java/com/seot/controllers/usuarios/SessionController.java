/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.controllers.usuarios;

import com.seot.facade.RolFacadeLocal;
import com.seot.facade.UsuarioFacade;
import com.seot.facade.UsuarioFacadeLocal;
import com.seot.modelos.entities.Rol;
import com.seot.modelos.entities.Usuario;
import com.seot.utils.MessagesUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 *
 * @author ismael
 */
@Named(value = "sessionController")
@SessionScoped
public class SessionController implements Serializable {

    @EJB
    private UsuarioFacadeLocal userFa;
    
    private String correo;
    private String clave;
    private Integer sucursal;

    private Usuario user;
    private Rol rol;

    private String newClave;
    private String confirClave;

    public SessionController() {

    }

    @PostConstruct
    public void init() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getNewClave() {
        return newClave;
    }

    public void setNewClave(String newClave) {
        this.newClave = newClave;
    }

    public String getConfirClave() {
        return confirClave;
    }

    public void setConfirClave(String confirClave) {
        this.confirClave = confirClave;
    }

    public String iniciarSesion() {

        System.out.println("Correo:" + correo);
        System.out.println("Clave:" + clave);

        user = userFa.findByDocClv(correo, clave);
        try {
            if (user != null) {
                if (user.getUsuEstado() == 2) {
                    MessagesUtil.info(null, "Usuario bloqueado", "", Boolean.TRUE);
                } else {
                    if (user.getTblrolesRolId().getRolId() == 1111) {
                        System.out.println("Pasoooo");
                        return "administrador/admin-inicio.xhtml?faces-redirect=true";
                    } else if (user.getTblrolesRolId().getRolId() == 1112) {
                        System.out.println("Pasoooo");
                        return "distribuidor/dist-usuario.xhtml?faces-redirect=true";
                    } else if (user.getTblrolesRolId().getRolId() == 1113) {
                        System.out.println("Pasoooo");
                        return "empleado/jefe-prod.xhtml?faces-redirect=true";
                    } else if (user.getTblrolesRolId().getRolId() == 1114) {
                        System.out.println("Pasoooo");
                        return "empleado/jefe-emp.xhtml?faces-redirect=true";
                    } else {
                        System.out.println("Algo con el rol");
                        MessagesUtil.info(null, "Usuario bloqueado", "", Boolean.TRUE);
                    }
                }
                user = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            MessagesUtil.error(null, "Error", "Campos vacios", Boolean.TRUE);
        }

        return "/Registro.xhtml?faces-redirect=true";
    }

    public void cerrarSesion() throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        user = null;
        correo = null;
        clave = null;
        ec.invalidateSession();
        String page = ec.getRequestContextPath() + "/HomePage.xhtml";
        ec.redirect(page);

    }

    public boolean isSessionStart() {
        return user != null;
    }

    public void validarSesion() throws IOException {
        if (!isSessionStart()) {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath());
        }
    }

    public void validarRol(Integer idRol) throws IOException {
        if (isSessionStart()) {
            if (rol.getRolId() != idRol.intValue()) {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect(ec.getRequestContextPath() + "/app/index.xhtml");
            }
        } else {
            validarSesion();
        }
    }

    public void actualizarUserAdmin() {
        userFa.edit(user);
    }

    public void editPass() {
        if (clave == null && clave.trim().length() == 0 && newClave == null && newClave.trim().length() == 0
                && confirClave == null && confirClave.trim().length() == 0) {
            MessagesUtil.info(null, "campos requeridos", "", Boolean.TRUE);
        } else if (!user.getUsuContrasena().equals(clave) && newClave != null && newClave.trim().length() != 0
                && confirClave != null && confirClave.trim().length() != 0) {
            MessagesUtil.info(null, "clave actual incorrecta", "", Boolean.TRUE);
        } else if (user.getUsuContrasena().equals(clave) && newClave.equals(confirClave)) {
            user.setUsuContrasena(newClave);
            userFa.edit(user);
            MessagesUtil.info(null, "Contraseña actualizada", "", Boolean.TRUE);

        }
    }
}
