/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.controllers;

import com.seot.facade.RolFacadeLocal;

import com.seot.facade.UsuarioFacadeLocal;
import com.seot.modelos.entities.Rol;
import com.seot.modelos.entities.Usuario;
import com.seot.utils.MessagesUtil;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController implements Serializable {

    @EJB
    private UsuarioFacadeLocal userFa;
    @EJB
    private RolFacadeLocal rolFa;

    private Usuario nuevoUser;
    private Rol rolUser;
    private Usuario usuarioSeleccionado;

    private String clave;
    private String confClave;

    private List<Usuario> userList;
    private List<Rol> rolList;

    public UsuarioController() {
    }

    @PostConstruct
    public void init() {
        nuevoUser = new Usuario();
        rolUser = new Rol();
    }

    public Usuario getNuevoUser() {
        return nuevoUser;
    }

    public void setNuevoUser(Usuario nuevoUser) {
        this.nuevoUser = nuevoUser;
    }

    public Rol getRolUser() {
        return rolUser;
    }

    public void setRolUser(Rol rolUser) {
        this.rolUser = rolUser;
    }

    public List<Usuario> getUserList() {
        if (userList == null || userList.isEmpty()) {

            userList = userFa.findAll();
        }
        return userList;
    }

    public void setUserList(List<Usuario> userList) {
        this.userList = userList;
    }

    public List<Rol> getRolList() {
        if (rolList == null || rolList.isEmpty()) {

            rolList = rolFa.findByRol();
        }
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getConfClave() {
        return confClave;
    }

    public void setConfClave(String confClave) {
        this.confClave = confClave;
    }

    public void crearUser() {
        rolUser = rolFa.find(1112);
        nuevoUser.setUsuEstado(2);
        nuevoUser.setTblrolesRolId(rolUser);
        userFa.create(nuevoUser);
        System.out.println("LLEGAROOOON!!");

        MessagesUtil.info(null, "Registro exitoso", "Se ha registrado correctamente el nuevo usuario.", true);
    }

    public void regEmpleado() {
        System.out.println("Entro");
        rolUser = (Rol) rolFa.findByRol();
        nuevoUser.setUsuContrasena(generarContraseña());
        nuevoUser.setUsuEstado(2);
        nuevoUser.setTblrolesRolId(rolUser);
        System.out.println("Si asigno bien");
        userFa.create(nuevoUser);
        System.out.println("LLEGAROOOON!!");

        MessagesUtil.info(null, "Registro exitoso", "Se ha registrado correctamente el nuevo usuario.", true);
    }

    public void eliminarUser() {
        userFa.remove(usuarioSeleccionado);
        userList = null;

    }

    public void usuarioSeleccionado(Usuario user) {
        usuarioSeleccionado = user;
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public void editarUsuario() {
        try {
            userFa.edit(usuarioSeleccionado);
            userList = null;
            MessagesUtil.info(null, "Éxito al editar", "Usuario modificado correctamente.", true);
        } catch (Exception e) {
            MessagesUtil.error(null, "Error al editar", e.getMessage(), true);
            e.printStackTrace();
        }
    }

    public String editarEstado() {
        try {
            System.out.println("Se va a editar el usuario");
            System.out.println("Id:" + usuarioSeleccionado.getUsuId());

            if (usuarioSeleccionado.getUsuEstado() == 1) {
                usuarioSeleccionado.setUsuEstado(2);
                userFa.edit(usuarioSeleccionado);
                MessagesUtil.info(null, "Usuario Bloqueado", "", Boolean.TRUE);

            } else if (usuarioSeleccionado.getUsuEstado() == 2) {
                usuarioSeleccionado.setUsuEstado(1);
                userFa.edit(usuarioSeleccionado);
                MessagesUtil.info(null, "Usuario Activado", "", Boolean.TRUE);
            }
            userList = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        usuarioSeleccionado = null;
        return "/Administrador/admin-usuarios.xhtml?faces-redirect=true";
    }

    public String generarContraseña() {
        String contrasenaa = UUID.randomUUID().toString().substring(0, 9);
        return contrasenaa;
    }

}
