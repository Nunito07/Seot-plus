/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.controllers;

import com.seot.facade.LoteFacadeLocal;
import com.seot.modelos.entities.Lote;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author SEOT
 */
@Named(value = "loteController")
@RequestScoped
public class LoteController {
    
    @EJB
    private LoteFacadeLocal lfl;
    
    private Lote lote;
    private List<Lote> loteList;

    /**
     * Creates a new instance of LoteController
     */
    public LoteController() {
    }
    
    @PostConstruct
    public void init(){
        Lote lote = new Lote();
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public List<Lote> getLoteList() {
        if (loteList == null || loteList.isEmpty()) {
            loteList = lfl.findAll();
        }
        return loteList;
    }

    public void setLoteList(List<Lote> loteList) {
        this.loteList = loteList;
    }
    
    
    
}
