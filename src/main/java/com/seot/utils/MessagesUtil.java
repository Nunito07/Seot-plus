/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.utils;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;


/**
 *
 * @author ismael
 */
public class MessagesUtil {
    
    public final static void message(String clientId, String mensaje, String detalle, 
            FacesMessage.Severity severity, Boolean propagar){
        if(propagar){
            propagarMessage();
        }
        FacesMessage fm = new FacesMessage(severity, mensaje, detalle);
        FacesContext.getCurrentInstance().addMessage(clientId, fm);
    }
    
    public final static void error(String clientId, String mensaje, String detalle, Boolean propagar){
        message(clientId, mensaje, detalle, FacesMessage.SEVERITY_ERROR, propagar);
    }
    
    public final static void info(String clientId, String mensaje, String detalle, Boolean propagar){
        message(clientId, mensaje, detalle, FacesMessage.SEVERITY_INFO, propagar);
    }
    
    public final static void warn(String clientId, String mensaje, String detalle, Boolean propagar){
        message(clientId, mensaje, detalle, FacesMessage.SEVERITY_WARN, propagar);
    }
    public final static void fatal(String clientId, String mensaje, String detalle, Boolean propagar){
        message(clientId, mensaje, detalle, FacesMessage.SEVERITY_FATAL, propagar);
    }
    
    public final static void propagarMessage(){
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
}
