/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.facade;

import com.seot.modelos.entities.Materialproducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Freddy Gonzalez
 */
@Local
public interface MaterialproductoFacadeLocal {

    void create(Materialproducto materialproducto);

    void edit(Materialproducto materialproducto);

    void remove(Materialproducto materialproducto);

    Materialproducto find(Object id);

    List<Materialproducto> findAll();

    List<Materialproducto> findRange(int[] range);

    int count();
    
}
