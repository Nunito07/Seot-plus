/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.facade;

import com.seot.modelos.entities.Stock;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Freddy Gonzalez
 */
@Stateless
public class StockFacade extends AbstractFacade<Stock> implements StockFacadeLocal {

    @PersistenceContext(unitName = "SPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StockFacade() {
        super(Stock.class);
    }
    
}
