/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.facade;

import com.seot.modelos.entities.EstadoGarantia;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Freddy Gonzalez
 */
@Stateless
public class EstadoGarantiaFacade extends AbstractFacade<EstadoGarantia> implements EstadoGarantiaFacadeLocal {

    @PersistenceContext(unitName = "SPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoGarantiaFacade() {
        super(EstadoGarantia.class);
    }
    
}
