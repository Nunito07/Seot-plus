/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.modelos.entities;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Freddy Gonzalez
 */
@Entity
@Table(name = "tbl_productos_has_tbl_ciclo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoCiclo.findAll", query = "SELECT p FROM ProductoCiclo p")
    , @NamedQuery(name = "ProductoCiclo.findByTblProductosprodreferencia", query = "SELECT p FROM ProductoCiclo p WHERE p.productoCicloPK.tblProductosprodreferencia = :tblProductosprodreferencia")
    , @NamedQuery(name = "ProductoCiclo.findByTblCiclocicloId", query = "SELECT p FROM ProductoCiclo p WHERE p.productoCicloPK.tblCiclocicloId = :tblCiclocicloId")
    , @NamedQuery(name = "ProductoCiclo.findByCiclofechaIni", query = "SELECT p FROM ProductoCiclo p WHERE p.ciclofechaIni = :ciclofechaIni")
    , @NamedQuery(name = "ProductoCiclo.findByCiclofechaFin", query = "SELECT p FROM ProductoCiclo p WHERE p.ciclofechaFin = :ciclofechaFin")})
public class ProductoCiclo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductoCicloPK productoCicloPK;
    @Basic(optional = false)
    @Column(name = "ciclo_fechaIni")
    @Temporal(TemporalType.DATE)
    private Date ciclofechaIni;
    @Basic(optional = false)
    @Column(name = "ciclo_fechaFin")
    @Temporal(TemporalType.DATE)
    private Date ciclofechaFin;
    @Lob
    @Column(name = "Descripcion")
    private String descripcion;
    @JoinColumn(name = "tbl_Ciclo_ciclo_Id", referencedColumnName = "ciclo_Id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ciclo ciclo;
    @JoinColumn(name = "tbl_Productos_prod_referencia", referencedColumnName = "prod_referencia", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;

    public ProductoCiclo() {
    }

    public ProductoCiclo(ProductoCicloPK productoCicloPK) {
        this.productoCicloPK = productoCicloPK;
    }

    public ProductoCiclo(ProductoCicloPK productoCicloPK, Date ciclofechaIni, Date ciclofechaFin) {
        this.productoCicloPK = productoCicloPK;
        this.ciclofechaIni = ciclofechaIni;
        this.ciclofechaFin = ciclofechaFin;
    }

    public ProductoCiclo(int tblProductosprodreferencia, int tblCiclocicloId) {
        this.productoCicloPK = new ProductoCicloPK(tblProductosprodreferencia, tblCiclocicloId);
    }

    public ProductoCicloPK getProductoCicloPK() {
        return productoCicloPK;
    }

    public void setProductoCicloPK(ProductoCicloPK productoCicloPK) {
        this.productoCicloPK = productoCicloPK;
    }

    public Date getCiclofechaIni() {
        return ciclofechaIni;
    }

    public void setCiclofechaIni(Date ciclofechaIni) {
        this.ciclofechaIni = ciclofechaIni;
    }

    public Date getCiclofechaFin() {
        return ciclofechaFin;
    }

    public void setCiclofechaFin(Date ciclofechaFin) {
        this.ciclofechaFin = ciclofechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoCicloPK != null ? productoCicloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoCiclo)) {
            return false;
        }
        ProductoCiclo other = (ProductoCiclo) object;
        if ((this.productoCicloPK == null && other.productoCicloPK != null) || (this.productoCicloPK != null && !this.productoCicloPK.equals(other.productoCicloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.ProductoCiclo[ productoCicloPK=" + productoCicloPK + " ]";
    }
    
}
