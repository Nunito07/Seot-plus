/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.modelos.entities;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Freddy Gonzalez
 */
@Entity
@Table(name = "tbl_ciclo_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CicloDetalle.findAll", query = "SELECT c FROM CicloDetalle c")
    , @NamedQuery(name = "CicloDetalle.findByTblCicloDetallecol", query = "SELECT c FROM CicloDetalle c WHERE c.tblCicloDetallecol = :tblCicloDetallecol")
    , @NamedQuery(name = "CicloDetalle.findByCicloId", query = "SELECT c FROM CicloDetalle c WHERE c.cicloId = :cicloId")})
public class CicloDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tbl_Ciclo_Detallecol")
    private Integer tblCicloDetallecol;
    @Column(name = "ciclo_Id")
    private String cicloId;
    @JoinColumn(name = "tbl_Lote_lot_identificador", referencedColumnName = "lot_identificador")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Lote tblLotelotidentificador;

    public CicloDetalle() {
    }

    public CicloDetalle(Integer tblCicloDetallecol) {
        this.tblCicloDetallecol = tblCicloDetallecol;
    }

    public Integer getTblCicloDetallecol() {
        return tblCicloDetallecol;
    }

    public void setTblCicloDetallecol(Integer tblCicloDetallecol) {
        this.tblCicloDetallecol = tblCicloDetallecol;
    }

    public String getCicloId() {
        return cicloId;
    }

    public void setCicloId(String cicloId) {
        this.cicloId = cicloId;
    }

    public Lote getTblLotelotidentificador() {
        return tblLotelotidentificador;
    }

    public void setTblLotelotidentificador(Lote tblLotelotidentificador) {
        this.tblLotelotidentificador = tblLotelotidentificador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblCicloDetallecol != null ? tblCicloDetallecol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CicloDetalle)) {
            return false;
        }
        CicloDetalle other = (CicloDetalle) object;
        if ((this.tblCicloDetallecol == null && other.tblCicloDetallecol != null) || (this.tblCicloDetallecol != null && !this.tblCicloDetallecol.equals(other.tblCicloDetallecol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.CicloDetalle[ tblCicloDetallecol=" + tblCicloDetallecol + " ]";
    }
    
}
