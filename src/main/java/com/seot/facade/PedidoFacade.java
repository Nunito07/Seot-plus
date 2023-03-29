/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.facade;

import com.seot.controllers.usuarios.SessionController;
import com.seot.modelos.entities.EstadoPedido;
import com.seot.modelos.entities.Pedido;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Freddy Gonzalez
 */
@Stateless
public class PedidoFacade extends AbstractFacade<Pedido> implements PedidoFacadeLocal {

    @Inject
    private SessionController sc;

    @PersistenceContext(unitName = "SPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoFacade() {
        super(Pedido.class);
    }

    @Override
    public List<Pedido> findXfechaConsulta(Date fechaIni, Date fechaFin) {
        Query q = em.createQuery("SELECT p FROM Pedido p WHERE p.pedFechaSolicitud BETWEEN :fechaIni AND :fechaFin");
        q.setParameter("fechaIni", fechaIni);
        q.setParameter("fechaFin", fechaFin);

        List<Pedido> pedidosFecha = q.getResultList();

        return pedidosFecha;
    }

    @Override
    public List<Pedido> findXestadoPedido(EstadoPedido codEstado) {
        Query ped = em.createQuery("SELECT p FROM Pedido p WHERE p.tblEstadoPedidocodestadped =:codEstado");
        ped.setParameter("codEstado", codEstado);
        List<Pedido> pedsEstado = ped.getResultList();
        return pedsEstado;
    }

    @Override
    public List<Pedido> findXestadoRecep() {
//        getEntityManager().getEntityManagerFactory().getCache().evictAll();
        Query pr = em.createQuery("SELECT p FROM Pedido p WHERE p.tblEstadoPedidocodestadped.codEstadPed=8882", Pedido.class);
        List srecep = pr.getResultList();
        return srecep;
    }

    @Override
    public List<Object[]> countXCanceladas() {
        Query csc = em.createNativeQuery("SELECT COUNT(*) FROM tbl_pedidos WHERE tbl_Estado_Pedido_cod_estad_ped=8881");
        List<Object[]> recep = csc.getResultList();
        return recep;
    }

    @Override
    public List<Object[]> countXRecep() {

        Query csr = em.createNativeQuery("SELECT COUNT(*) FROM tbl_pedidos WHERE tbl_Estado_Pedido_cod_estad_ped=8882");
        List<Object[]> recep = csr.getResultList();
        return recep;
    }

    @Override
    public List<Object[]> countXProduccion() {
        Query csp = em.createNativeQuery("SELECT COUNT(*) FROM tbl_pedidos WHERE tbl_Estado_Pedido_cod_estad_ped=8883");
        List<Object[]> recep = csp.getResultList();
        return recep;
    }

    @Override
    public List<Object[]> countXEmpaque() {
        Query cse = em.createNativeQuery("SELECT COUNT(*) FROM tbl_pedidos WHERE tbl_Estado_Pedido_cod_estad_ped=8884");
        List<Object[]> recep = cse.getResultList();
        return recep;
    }

    @Override
    public List<Object[]> countXEnviadas() {
        Query csenv = em.createNativeQuery("SELECT COUNT(*) FROM tbl_pedidos WHERE tbl_Estado_Pedido_cod_estad_ped=8885");
        List<Object[]> recep = csenv.getResultList();
        return recep;
    }

    @Override
    public List<Pedido> pedsXsesion(Integer id) {
      /*
        Query sess=em.createNativeQuery("SELECT p.* FROM tbl_pedidos AS p INNER JOIN tbl_cotizacion "
                    + "ON tblcotizacion_cot_cod=cot_cod WHERE tbl_sucursales_usu_id=?", Pedido.class);
        
        sess.setParameter(1, id);
        List<Pedido>session=sess.getResultList();
        return session;
        */
        TypedQuery<Pedido> q = getEntityManager().createQuery("SELECT p FROM Pedido p "
                    + "WHERE p.tblcotizacionCotCod.tblSucursalesUsuId.usuId=:sucId", Pedido.class);
        
        q.setParameter("sucId", id);
        return q.getResultList();
}
}
