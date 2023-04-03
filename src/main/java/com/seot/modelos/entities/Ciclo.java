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
@Table(name = "tbl_ciclo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciclo.findAll", query = "SELECT c FROM Ciclo c")
    , @NamedQuery(name = "Ciclo.findByCicloId", query = "SELECT c FROM Ciclo c WHERE c.cicloId = :cicloId")
    , @NamedQuery(name = "Ciclo.findByNombre", query = "SELECT c FROM Ciclo c WHERE c.nombre = :nombre")})
public class Ciclo implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciclo")
    private List<Planeacion> planeacionList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ciclo_Id")
    private Integer cicloId;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciclo", fetch = FetchType.LAZY)
    private List<ProductoCiclo> productoCicloList;

    public Ciclo() {
    }

    public Ciclo(Integer cicloId) {
        this.cicloId = cicloId;
    }

    public Ciclo(Integer cicloId, String nombre) {
        this.cicloId = cicloId;
        this.nombre = nombre;
    }

    public Integer getCicloId() {
        return cicloId;
    }

    public void setCicloId(Integer cicloId) {
        this.cicloId = cicloId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<ProductoCiclo> getProductoCicloList() {
        return productoCicloList;
    }

    public void setProductoCicloList(List<ProductoCiclo> productoCicloList) {
        this.productoCicloList = productoCicloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cicloId != null ? cicloId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciclo)) {
            return false;
        }
        Ciclo other = (Ciclo) object;
        if ((this.cicloId == null && other.cicloId != null) || (this.cicloId != null && !this.cicloId.equals(other.cicloId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.Ciclo[ cicloId=" + cicloId + " ]";
    }

    @XmlTransient
    public List<Planeacion> getPlaneacionList() {
        return planeacionList;
    }

    public void setPlaneacionList(List<Planeacion> planeacionList) {
        this.planeacionList = planeacionList;
    }
    
}
