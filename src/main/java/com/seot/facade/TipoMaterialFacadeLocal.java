/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.facade;

import com.seot.modelos.entities.TipoMaterial;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Freddy Gonzalez
 */
@Local
public interface TipoMaterialFacadeLocal {

    void create(TipoMaterial tipoMaterial);

    void edit(TipoMaterial tipoMaterial);

    void remove(TipoMaterial tipoMaterial);

    TipoMaterial find(Object id);

    List<TipoMaterial> findAll();

    List<TipoMaterial> findRange(int[] range);

    int count();
    
}
