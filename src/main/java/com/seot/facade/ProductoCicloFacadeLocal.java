/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.facade;

import com.seot.modelos.entities.ProductoCiclo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Freddy Gonzalez
 */
@Local
public interface ProductoCicloFacadeLocal {

    void create(ProductoCiclo productoCiclo);

    void edit(ProductoCiclo productoCiclo);

    void remove(ProductoCiclo productoCiclo);

    ProductoCiclo find(Object id);

    List<ProductoCiclo> findAll();

    List<ProductoCiclo> findRange(int[] range);

    int count();
    
}
