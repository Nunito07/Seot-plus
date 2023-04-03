/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.modelos.entities;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 *
 * @author Freddy Gonzalez
 */
@Embeddable
public class ProductoCicloPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "tbl_Productos_prod_referencia")
    private int tblProductosprodreferencia;
    @Basic(optional = false)
    @Column(name = "tbl_Ciclo_ciclo_Id")
    private int tblCiclocicloId;

    public ProductoCicloPK() {
    }

    public ProductoCicloPK(int tblProductosprodreferencia, int tblCiclocicloId) {
        this.tblProductosprodreferencia = tblProductosprodreferencia;
        this.tblCiclocicloId = tblCiclocicloId;
    }

    public int getTblProductosprodreferencia() {
        return tblProductosprodreferencia;
    }

    public void setTblProductosprodreferencia(int tblProductosprodreferencia) {
        this.tblProductosprodreferencia = tblProductosprodreferencia;
    }

    public int getTblCiclocicloId() {
        return tblCiclocicloId;
    }

    public void setTblCiclocicloId(int tblCiclocicloId) {
        this.tblCiclocicloId = tblCiclocicloId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tblProductosprodreferencia;
        hash += (int) tblCiclocicloId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoCicloPK)) {
            return false;
        }
        ProductoCicloPK other = (ProductoCicloPK) object;
        if (this.tblProductosprodreferencia != other.tblProductosprodreferencia) {
            return false;
        }
        if (this.tblCiclocicloId != other.tblCiclocicloId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.ProductoCicloPK[ tblProductosprodreferencia=" + tblProductosprodreferencia + ", tblCiclocicloId=" + tblCiclocicloId + " ]";
    }
    
}
