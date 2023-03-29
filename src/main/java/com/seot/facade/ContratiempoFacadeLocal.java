/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.facade;

import com.seot.modelos.entities.Contratiempo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Freddy Gonzalez
 */
@Local
public interface ContratiempoFacadeLocal {

    void create(Contratiempo contratiempo);

    void edit(Contratiempo contratiempo);

    void remove(Contratiempo contratiempo);

    Contratiempo find(Object id);

    List<Contratiempo> findAll();

    List<Contratiempo> findRange(int[] range);

    int count();
    
}
