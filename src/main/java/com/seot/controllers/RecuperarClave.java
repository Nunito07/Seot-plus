/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.controllers;

import com.seot.facade.UsuarioFacade;
import com.seot.facade.UsuarioFacadeLocal;
import com.seot.mail.Mail;
import com.seot.modelos.entities.Usuario;
import com.seot.utils.MessagesUtil;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author APRENDIZ
 */
@Named(value = "recuperarClave")
@SessionScoped
public class RecuperarClave implements Serializable {

    @EJB
    private UsuarioFacadeLocal uFacade;

    private String correo;
    private String newClave;
    private String confirClave;

    /**
     * Creates a new instance of RecuperarClave
     */
    public RecuperarClave() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public void recuperar() {
        Usuario u = uFacade.findByCorreo(correo);
        if (u != null) {
            Mail.sendMailHTML(correo, "Recuperación de clave.",
                    "<h2>Recuperación de clave</h2><p>Ud ha solicitado recuperar su clave, visite el siguiente link: </p>"
                    + "<form action='http://localhost:8080/SEOT_1.0/usuarios/recuperacionclave/index'>"
                            + "<input type='hidden' name='id' value='" + u.getUsuId() + "'/>"
                            + "<input type='hidden' name='codigo' value='" + "dhsagdhsjadajdghasd" + "'/>"
                            + "<button type='submit'>Recuperar</button>"
                            + "</form>");
        } else {
            MessagesUtil.info("formRecuperaClave", "Cuenta incorrecta", "No se reconoce la cuenta de correo ingresada, cerifique sus datos y vuelva a intentar.", Boolean.FALSE);
        }
    }

    public String editPass() {
        Usuario u = uFacade.findByCorreo(correo);
        String rta = "";
        if (u != null) {
            if (newClave == null && newClave.trim().length() == 0
                    && confirClave == null && confirClave.trim().length() == 0) {
                MessagesUtil.info(null, "campos requeridos", "", Boolean.TRUE);
            } else if (!newClave.equals(confirClave)) {
                MessagesUtil.info(null, "las claves no coinciden", "", Boolean.TRUE);
            } else {
                System.out.println("djksakanskdkasdnkalsnkldnkalsnkldnlasnkldnklasnkdkals");
                System.out.println("Vamo a cambiar la contraseña por: " + newClave);
                u.setUsuContrasena(newClave);
                uFacade.edit(u);
                MessagesUtil.info(null, "Contraseña actualizada", "", Boolean.TRUE);
                rta = "/Registro.xhtml?faces-redirect=true";
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("codigoOk");
                newClave=null;
                confirClave=null;
            }
        }
        return rta;
    }
}
