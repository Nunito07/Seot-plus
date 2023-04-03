/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.modelos.entities;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "tbl_cotizacion_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CotizacionDetalle.findAll", query = "SELECT c FROM CotizacionDetalle c")
    , @NamedQuery(name = "CotizacionDetalle.findByCotDetalleCodigo", query = "SELECT c FROM CotizacionDetalle c WHERE c.cotizacionDetallePK.cotDetalleCodigo = :cotDetalleCodigo")
    , @NamedQuery(name = "CotizacionDetalle.findByCotDetalleProdRef", query = "SELECT c FROM CotizacionDetalle c WHERE c.cotizacionDetallePK.cotDetalleProdRef = :cotDetalleProdRef")
    , @NamedQuery(name = "CotizacionDetalle.findByCotDetalleCantidad", query = "SELECT c FROM CotizacionDetalle c WHERE c.cotDetalleCantidad = :cotDetalleCantidad")})
public class CotizacionDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CotizacionDetallePK cotizacionDetallePK;
    @Basic(optional = false)
    @Column(name = "cot_detalle_cantidad")
    private int cotDetalleCantidad;
    @Column (name= "cot_detalle_precioUnit")
    private Double cotDetallePrecioUnit;
    @JoinColumn(name = "cot_detalle_prod_ref", referencedColumnName = "prod_referencia", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;
    @JoinColumn(name = "cot_detalle_codigo", referencedColumnName = "cot_cod", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cotizacion cotizacion;

    public CotizacionDetalle() {
    }

    public CotizacionDetalle(CotizacionDetallePK cotizacionDetallePK) {
        this.cotizacionDetallePK = cotizacionDetallePK;
    }

    public CotizacionDetalle(CotizacionDetallePK cotizacionDetallePK, int cotDetalleCantidad) {
        this.cotizacionDetallePK = cotizacionDetallePK;
        this.cotDetalleCantidad = cotDetalleCantidad;
    }

    public CotizacionDetalle(int cotDetalleCodigo, int cotDetalleProdRef) {
        this.cotizacionDetallePK = new CotizacionDetallePK(cotDetalleCodigo, cotDetalleProdRef);
    }

    public CotizacionDetallePK getCotizacionDetallePK() {
        return cotizacionDetallePK;
    }

    public void setCotizacionDetallePK(CotizacionDetallePK cotizacionDetallePK) {
        this.cotizacionDetallePK = cotizacionDetallePK;
    }

    public int getCotDetalleCantidad() {
        return cotDetalleCantidad;
    }

    public void setCotDetalleCantidad(int cotDetalleCantidad) {
        this.cotDetalleCantidad = cotDetalleCantidad;
    }

    public Double getCotDetallePrecioUnit() {
        return cotDetallePrecioUnit;
    }

    public void setCotDetallePrecioUnit(Double cotDetallePrecioUnit) {
        this.cotDetallePrecioUnit = cotDetallePrecioUnit;
    }

    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cotizacionDetallePK != null ? cotizacionDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CotizacionDetalle)) {
            return false;
        }
        CotizacionDetalle other = (CotizacionDetalle) object;
        if ((this.cotizacionDetallePK == null && other.cotizacionDetallePK != null) || (this.cotizacionDetallePK != null && !this.cotizacionDetallePK.equals(other.cotizacionDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.CotizacionDetalle[ cotizacionDetallePK=" + cotizacionDetallePK + " ]";
    }
    
}
