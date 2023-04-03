/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.facade;

import com.seot.modelos.entities.Lineas;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author Freddy Gonzalez
 */
@Local
public interface LineasFacadeLocal {

    void create(Lineas lineas);

    void edit(Lineas lineas);

    void remove(Lineas lineas);

    Lineas find(Object id);

    List<Lineas> findAll();

    List<Lineas> findRange(int[] range);

    int count();
    
}
