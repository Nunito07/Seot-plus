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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

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
