/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.modelos.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Freddy Gonzalez
 */
@Entity
@Table(name = "tbl_permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p")
    , @NamedQuery(name = "Permiso.findByPermiId", query = "SELECT p FROM Permiso p WHERE p.permiId = :permiId")
    , @NamedQuery(name = "Permiso.findByPermiNombre", query = "SELECT p FROM Permiso p WHERE p.permiNombre = :permiNombre")
    , @NamedQuery(name = "Permiso.findByPermiTipo", query = "SELECT p FROM Permiso p WHERE p.permiTipo = :permiTipo")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "permi_id")
    private Integer permiId;
    @Basic(optional = false)
    @Column(name = "permi_nombre")
    private String permiNombre;
    @Basic(optional = false)
    @Column(name = "permi_tipo")
    private String permiTipo;
    @ManyToMany(mappedBy = "permisoList", fetch = FetchType.LAZY)
    private List<Rol> rolList;

    public Permiso() {
    }

    public Permiso(Integer permiId) {
        this.permiId = permiId;
    }

    public Permiso(Integer permiId, String permiNombre, String permiTipo) {
        this.permiId = permiId;
        this.permiNombre = permiNombre;
        this.permiTipo = permiTipo;
    }

    public Integer getPermiId() {
        return permiId;
    }

    public void setPermiId(Integer permiId) {
        this.permiId = permiId;
    }

    public String getPermiNombre() {
        return permiNombre;
    }

    public void setPermiNombre(String permiNombre) {
        this.permiNombre = permiNombre;
    }

    public String getPermiTipo() {
        return permiTipo;
    }

    public void setPermiTipo(String permiTipo) {
        this.permiTipo = permiTipo;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permiId != null ? permiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.permiId == null && other.permiId != null) || (this.permiId != null && !this.permiId.equals(other.permiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.Permiso[ permiId=" + permiId + " ]";
    }
    
}
