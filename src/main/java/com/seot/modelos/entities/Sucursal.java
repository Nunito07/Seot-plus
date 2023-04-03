/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.modelos.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Freddy Gonzalez
 */
@Entity
@Table(name = "tbl_sucursales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s")
    , @NamedQuery(name = "Sucursal.findByUsuId", query = "SELECT s FROM Sucursal s WHERE s.usuId = :usuId")
    , @NamedQuery(name = "Sucursal.findBySucurNombre", query = "SELECT s FROM Sucursal s WHERE s.sucurNombre = :sucurNombre")
    , @NamedQuery(name = "Sucursal.findBySucurFechaRegistro", query = "SELECT s FROM Sucursal s WHERE s.sucurFechaRegistro = :sucurFechaRegistro")})
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usu_id")
    private Integer usuId;
    @Column(name = "sucur_nombre")
    private String sucurNombre;
    @Basic(optional = false)
    @Column(name = "sucur_fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sucurFechaRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblSucursalesUsuId", fetch = FetchType.LAZY)
    private List<Cotizacion> cotizacionList;
    @JoinColumn(name = "usu_id", referencedColumnName = "usu_id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;
    @JoinColumn(name = "tblciudad_ciud_codigo", referencedColumnName = "ciud_codigo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ciudad tblciudadCiudCodigo;
    @JoinColumn(name = "tbldistribuidor_dist_cod", referencedColumnName = "dist_cod")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Distribuidor tbldistribuidorDistCod;

    public Sucursal() {
    }

    public Sucursal(String sucurNombre, Date sucurFechaRegistro) {
        this.sucurNombre = sucurNombre;
        this.sucurFechaRegistro = sucurFechaRegistro;
    }
    
    public Sucursal(Integer usuId) {
        this.usuId = usuId;
    }

    public Sucursal(Integer usuId, Date sucurFechaRegistro) {
        this.usuId = usuId;
        this.sucurFechaRegistro = sucurFechaRegistro;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getSucurNombre() {
        return sucurNombre;
    }

    public void setSucurNombre(String sucurNombre) {
        this.sucurNombre = sucurNombre;
    }

    public Date getSucurFechaRegistro() {
        return sucurFechaRegistro;
    }

    public void setSucurFechaRegistro(Date sucurFechaRegistro) {
        this.sucurFechaRegistro = sucurFechaRegistro;
    }

    @XmlTransient
    public List<Cotizacion> getCotizacionList() {
        return cotizacionList;
    }

    public void setCotizacionList(List<Cotizacion> cotizacionList) {
        this.cotizacionList = cotizacionList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ciudad getTblciudadCiudCodigo() {
        return tblciudadCiudCodigo;
    }

    public void setTblciudadCiudCodigo(Ciudad tblciudadCiudCodigo) {
        this.tblciudadCiudCodigo = tblciudadCiudCodigo;
    }

    public Distribuidor getTbldistribuidorDistCod() {
        return tbldistribuidorDistCod;
    }

    public void setTbldistribuidorDistCod(Distribuidor tbldistribuidorDistCod) {
        this.tbldistribuidorDistCod = tbldistribuidorDistCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.Sucursal[ usuId=" + usuId + " ]";
    }
    
}
