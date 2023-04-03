/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.facade;

import com.seot.modelos.entities.Planeacion;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author Freddy Gonzalez
 */
@Local
public interface PlaneacionFacadeLocal {

    void create(Planeacion planeacion);

    void edit(Planeacion planeacion);

    void remove(Planeacion planeacion);

    Planeacion find(Object id);

    List<Planeacion> findAll();

    List<Planeacion> findRange(int[] range);

    int count();
 
    List<Object[]>listarMetalico();
}
