/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.facade;

import com.seot.modelos.entities.Ciclo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Freddy Gonzalez
 */
@Stateless
public class CicloFacade extends AbstractFacade<Ciclo> implements CicloFacadeLocal {

    @PersistenceContext(unitName = "SPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CicloFacade() {
        super(Ciclo.class);
    }
    
}
