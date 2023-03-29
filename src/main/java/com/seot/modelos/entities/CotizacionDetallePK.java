/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.modelos.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Freddy Gonzalez
 */
@Embeddable
public class CotizacionDetallePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cot_detalle_codigo")
    private int cotDetalleCodigo;
    @Basic(optional = false)
    @Column(name = "cot_detalle_prod_ref")
    private int cotDetalleProdRef;

    public CotizacionDetallePK() {
    }

    public CotizacionDetallePK(int cotDetalleCodigo, int cotDetalleProdRef) {
        this.cotDetalleCodigo = cotDetalleCodigo;
        this.cotDetalleProdRef = cotDetalleProdRef;
    }

    public int getCotDetalleCodigo() {
        return cotDetalleCodigo;
    }

    public void setCotDetalleCodigo(int cotDetalleCodigo) {
        this.cotDetalleCodigo = cotDetalleCodigo;
    }

    public int getCotDetalleProdRef() {
        return cotDetalleProdRef;
    }

    public void setCotDetalleProdRef(int cotDetalleProdRef) {
        this.cotDetalleProdRef = cotDetalleProdRef;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cotDetalleCodigo;
        hash += (int) cotDetalleProdRef;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CotizacionDetallePK)) {
            return false;
        }
        CotizacionDetallePK other = (CotizacionDetallePK) object;
        if (this.cotDetalleCodigo != other.cotDetalleCodigo) {
            return false;
        }
        if (this.cotDetalleProdRef != other.cotDetalleProdRef) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.CotizacionDetallePK[ cotDetalleCodigo=" + cotDetalleCodigo + ", cotDetalleProdRef=" + cotDetalleProdRef + " ]";
    }
    
}
