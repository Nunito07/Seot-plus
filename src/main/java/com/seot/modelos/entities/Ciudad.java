/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.modelos.entities;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Freddy Gonzalez
 */
@Entity
@Table(name = "tbl_ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c")
    , @NamedQuery(name = "Ciudad.findByCiudCodigo", query = "SELECT c FROM Ciudad c WHERE c.ciudCodigo = :ciudCodigo")
    , @NamedQuery(name = "Ciudad.findByCiudNombre", query = "SELECT c FROM Ciudad c WHERE c.ciudNombre = :ciudNombre")})
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ciud_codigo")
    private Integer ciudCodigo;
    @Basic(optional = false)
    @Column(name = "ciud_nombre")
    private String ciudNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblciudadCiudCodigo", fetch = FetchType.LAZY)
    private List<Sucursal> sucursalList;

    public Ciudad() {
    }

    public Ciudad(Integer ciudCodigo) {
        this.ciudCodigo = ciudCodigo;
    }

    public Ciudad(Integer ciudCodigo, String ciudNombre) {
        this.ciudCodigo = ciudCodigo;
        this.ciudNombre = ciudNombre;
    }

    public Integer getCiudCodigo() {
        return ciudCodigo;
    }

    public void setCiudCodigo(Integer ciudCodigo) {
        this.ciudCodigo = ciudCodigo;
    }

    public String getCiudNombre() {
        return ciudNombre;
    }

    public void setCiudNombre(String ciudNombre) {
        this.ciudNombre = ciudNombre;
    }

    @XmlTransient
    public List<Sucursal> getSucursalList() {
        return sucursalList;
    }

    public void setSucursalList(List<Sucursal> sucursalList) {
        this.sucursalList = sucursalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciudCodigo != null ? ciudCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.ciudCodigo == null && other.ciudCodigo != null) || (this.ciudCodigo != null && !this.ciudCodigo.equals(other.ciudCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.Ciudad[ ciudCodigo=" + ciudCodigo + " ]";
    }
    
}
