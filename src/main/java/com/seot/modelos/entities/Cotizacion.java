/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.modelos.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Freddy Gonzalez
 */
@Entity
@Table(name = "tbl_cotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotizacion.findAll", query = "SELECT c FROM Cotizacion c")
    , @NamedQuery(name = "Cotizacion.findByCotCod", query = "SELECT c FROM Cotizacion c WHERE c.cotCod = :cotCod")
    , @NamedQuery(name = "Cotizacion.findByCotFechaConsulta", query = "SELECT c FROM Cotizacion c WHERE c.cotFechaConsulta = :cotFechaConsulta")
    , @NamedQuery(name = "Cotizacion.findByCotValortotal", query = "SELECT c FROM Cotizacion c WHERE c.cotValortotal = :cotValortotal")})
public class Cotizacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cot_cod")
    private Integer cotCod;
    @Basic(optional = false)
    @Column(name = "cot_fecha_consulta")
    @Temporal(TemporalType.DATE)
    private Date cotFechaConsulta;
    @Basic(optional = false)
    @Column(name = "cot_valortotal")
    private double cotValortotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cotizacion", fetch = FetchType.LAZY)
    private List<CotizacionDetalle> cotizacionDetalleList;
    @JoinColumn(name = "tbl_sucursales_usu_id", referencedColumnName = "usu_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sucursal tblSucursalesUsuId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblcotizacionCotCod", fetch = FetchType.LAZY)
    private List<Pedido> pedidoList;

    public Cotizacion() {
    }

    public Cotizacion(Integer cotCod) {
        this.cotCod = cotCod;
    }

    public Cotizacion(Integer cotCod, Date cotFechaConsulta, double cotValortotal) {
        this.cotCod = cotCod;
        this.cotFechaConsulta = cotFechaConsulta;
        this.cotValortotal = cotValortotal;
    }

    public Integer getCotCod() {
        return cotCod;
    }

    public void setCotCod(Integer cotCod) {
        this.cotCod = cotCod;
    }

    public Date getCotFechaConsulta() {
        return cotFechaConsulta;
    }

    public void setCotFechaConsulta(Date cotFechaConsulta) {
        this.cotFechaConsulta = cotFechaConsulta;
    }

    public double getCotValortotal() {
        return cotValortotal;
    }

    public void setCotValortotal(double cotValortotal) {
        this.cotValortotal = cotValortotal;
    }

    @XmlTransient
    public List<CotizacionDetalle> getCotizacionDetalleList() {
        return cotizacionDetalleList;
    }

    public void setCotizacionDetalleList(List<CotizacionDetalle> cotizacionDetalleList) {
        this.cotizacionDetalleList = cotizacionDetalleList;
    }

    public Sucursal getTblSucursalesUsuId() {
        return tblSucursalesUsuId;
    }

    public void setTblSucursalesUsuId(Sucursal tblSucursalesUsuId) {
        this.tblSucursalesUsuId = tblSucursalesUsuId;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cotCod != null ? cotCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotizacion)) {
            return false;
        }
        Cotizacion other = (Cotizacion) object;
        if ((this.cotCod == null && other.cotCod != null) || (this.cotCod != null && !this.cotCod.equals(other.cotCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.Cotizacion[ cotCod=" + cotCod + " ]";
    }
    
}
