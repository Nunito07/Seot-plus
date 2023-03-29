/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.modelos.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "tbl_distribuidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distribuidor.findAll", query = "SELECT d FROM Distribuidor d")
    , @NamedQuery(name = "Distribuidor.findByDistCod", query = "SELECT d FROM Distribuidor d WHERE d.distCod = :distCod")
    , @NamedQuery(name = "Distribuidor.findByDistNit", query = "SELECT d FROM Distribuidor d WHERE d.distNit = :distNit")
    , @NamedQuery(name = "Distribuidor.findByDistNombreEmpresa", query = "SELECT d FROM Distribuidor d WHERE d.distNombreEmpresa = :distNombreEmpresa")})
public class Distribuidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dist_cod")
    private Integer distCod;
    @Basic(optional = false)
    @Column(name = "dist_nit")
    private int distNit;
    @Basic(optional = false)
    @Column(name = "dist_nombre_empresa")
    private String distNombreEmpresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbldistribuidorDistCod")
    private List<Sucursal> sucursalList;

    public Distribuidor() {
    }

    public Distribuidor(Integer distCod) {
        this.distCod = distCod;
    }

    public Distribuidor(Integer distCod, int distNit, String distNombreEmpresa) {
        this.distCod = distCod;
        this.distNit = distNit;
        this.distNombreEmpresa = distNombreEmpresa;
    }

    public Integer getDistCod() {
        return distCod;
    }

    public void setDistCod(Integer distCod) {
        this.distCod = distCod;
    }

    public int getDistNit() {
        return distNit;
    }

    public void setDistNit(int distNit) {
        this.distNit = distNit;
    }

    public String getDistNombreEmpresa() {
        return distNombreEmpresa;
    }

    public void setDistNombreEmpresa(String distNombreEmpresa) {
        this.distNombreEmpresa = distNombreEmpresa;
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
        hash += (distCod != null ? distCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distribuidor)) {
            return false;
        }
        Distribuidor other = (Distribuidor) object;
        if ((this.distCod == null && other.distCod != null) || (this.distCod != null && !this.distCod.equals(other.distCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.Distribuidor[ distCod=" + distCod + " ]";
    }

}
