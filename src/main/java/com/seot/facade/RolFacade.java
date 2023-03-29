/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.facade;

import com.seot.modelos.entities.Rol;
import com.seot.utils.MessagesUtil;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Freddy Gonzalez
 */
@Stateless
public class RolFacade extends AbstractFacade<Rol> implements RolFacadeLocal {

    @PersistenceContext(unitName = "SPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolFacade() {
        super(Rol.class);
    }

    @Override
    public List<Rol> findByRol() {
        Query q = getEntityManager().createQuery("SELECT r FROM Rol r WHERE r.rolId !=:id");
        q.setParameter("id", 1111);
        List<Rol> rolList = q.getResultList();
        for (Rol rol : rolList) {
            System.out.println(rol.getRolNombre());
        }
        return rolList;
    }
}
