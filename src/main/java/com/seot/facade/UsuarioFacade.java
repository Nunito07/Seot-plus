/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.facade;

import com.seot.modelos.entities.Usuario;
import com.seot.utils.MessagesUtil;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Freddy Gonzalez
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "SPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    /**
     *
     * @param correo
     * @param clave
     * @return
     */
    @Override
        public Usuario findByDocClv(String correo, String clave) {
        System.out.println(correo +clave);
        try {
            Usuario u ;
            TypedQuery<Usuario> q = getEntityManager().createQuery(
                    "SELECT u FROM Usuario u WHERE u.usuCorreoElectronico=:mail AND u.usuContrasena=:clave", Usuario.class);
            q.setParameter("mail", correo);
            q.setParameter("clave", clave);
            u =q.getSingleResult();
            System.out.println(u.toString());
            return u;
        } catch (Exception e) {
            System.out.println("Se perdio todooooo Alv /////////////////////////////////////");
            MessagesUtil.error(null, "Error:", "Correo y/o contraseña incorrectos.", Boolean.TRUE);
        return null;
        }
    }
    
    /**
     *
     * @param correo
     * @return
     */
    @Override
    public Usuario findByCorreo(String correo) {
        try {
            Usuario u ;
            TypedQuery<Usuario> q = getEntityManager().createQuery(
                    "SELECT u FROM Usuario u WHERE u.usuCorreoElectronico=:mail", Usuario.class);
            q.setParameter("mail", correo);
            u =q.getSingleResult();
            return u;
        } catch (Exception e) {
            System.out.println("Se perdio todooooo Alv /////////////////////////////////////");
        return null;
        }
    }
    
    
}
