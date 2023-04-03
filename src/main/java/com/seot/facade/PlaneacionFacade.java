package com.seot.facade;

import com.seot.modelos.entities.Planeacion;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class PlaneacionFacade extends AbstractFacade<Planeacion> implements PlaneacionFacadeLocal {

    @PersistenceContext(unitName = "SPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlaneacionFacade() {
        super(Planeacion.class);
    }
    public List<Planeacion> listarDomestico(){
        Query q=em.createNativeQuery("SELECT seotcito FROM seotcito.tbl_planeacion where tbl_lineas_lin_codigo = \"111\";", Planeacion.class);
        List<Planeacion> lpc=q.getResultList();
        return lpc;
    }
    public List<Planeacion> listarSemi(){
        Query q=em.createNativeQuery("SELECT seotcito FROM seotcito.tbl_planeacion where tbl_lineas_lin_codigo = \"112\";", Planeacion.class);
        List<Planeacion> lpc=q.getResultList();
        return lpc;
    }
    public List<Planeacion> listarIndustrial(){
        Query q=em.createNativeQuery("SELECT seotcito FROM seotcito.tbl_planeacion where tbl_lineas_lin_codigo = \"113\";", Planeacion.class);
        List<Planeacion> lpc=q.getResultList();
        return lpc;
    }
    public List<Planeacion> listarMetalica(){
        Query q=em.createNativeQuery("SELECT seotcito FROM seotcito.tbl_planeacion where tbl_lineas_lin_codigo = \"114\";", Planeacion.class);
        List<Planeacion> lpc=q.getResultList();
        return lpc;
    }

    @Override
    public List<Object[]> listarMetalico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}