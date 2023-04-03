/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.facade;

import com.seot.modelos.entities.Garantia;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 *
 * @author Freddy Gonzalez
 */
@Stateless
public class GarantiaFacade extends AbstractFacade<Garantia> implements GarantiaFacadeLocal {

    @PersistenceContext(unitName = "SPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GarantiaFacade() {
        super(Garantia.class);
    }
    
        @Override
    public List<Object[]> findBytotalgarantia() {

        List<Object[]> maximo;
        Query q = em.createNativeQuery("select lin_nombre,count(lin_nombre) from tbl_productos inner join tb_lineas on tbl_productos.tbllineas_lin_codigo = tb_lineas.lin_codigo group by lin_nombre;");
        maximo = q.getResultList();
        return maximo;
    }
    
    @Override
    public List<Object[]> findByGarantiaUser(Integer id){
        
            Query user=em.createNativeQuery("SELECT garant_codigo,cot_valortotal,ped_fecha_entrega,prod_modelo"
                    + " FROM `tbl_garantias` INNER JOIN "
                    + "tbl_stock ON stock_Id=garant_prodcon_codigo_recibido INNER JOIN"
                    + " tbl_pedidos ON tblpedidos_ped_codigo_unico=ped_codigo_unico INNER JOIN "
                    + "tbl_cotizacion ON tblcotizacion_cot_cod=cot_cod "
                    + "INNER JOIN tbl_productos ON prod_referencia=tblproductos_prod_referencia WHERE tbl_sucursales_usu_id=?");
            user.setParameter(1,id );
            List<Object[]>garantUs=user.getResultList();
            return garantUs;
            }
    
}
