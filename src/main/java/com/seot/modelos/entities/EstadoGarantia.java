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
@Table(name = "tbl_est_garant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoGarantia.findAll", query = "SELECT e FROM EstadoGarantia e")
    , @NamedQuery(name = "EstadoGarantia.findByCodEstGarant", query = "SELECT e FROM EstadoGarantia e WHERE e.codEstGarant = :codEstGarant")
    , @NamedQuery(name = "EstadoGarantia.findByTipoEstGarant", query = "SELECT e FROM EstadoGarantia e WHERE e.tipoEstGarant = :tipoEstGarant")})
public class EstadoGarantia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_est_garant")
    private Integer codEstGarant;
    @Column(name = "tipo_est_garant")
    private String tipoEstGarant;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblEstGarantCodEstGarant", fetch = FetchType.LAZY)
    private List<Garantia> garantiaList;

    public EstadoGarantia() {
    }

    public EstadoGarantia(Integer codEstGarant) {
        this.codEstGarant = codEstGarant;
    }

    public Integer getCodEstGarant() {
        return codEstGarant;
    }

    public void setCodEstGarant(Integer codEstGarant) {
        this.codEstGarant = codEstGarant;
    }

    public String getTipoEstGarant() {
        return tipoEstGarant;
    }

    public void setTipoEstGarant(String tipoEstGarant) {
        this.tipoEstGarant = tipoEstGarant;
    }

    @XmlTransient
    public List<Garantia> getGarantiaList() {
        return garantiaList;
    }

    public void setGarantiaList(List<Garantia> garantiaList) {
        this.garantiaList = garantiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstGarant != null ? codEstGarant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoGarantia)) {
            return false;
        }
        EstadoGarantia other = (EstadoGarantia) object;
        if ((this.codEstGarant == null && other.codEstGarant != null) || (this.codEstGarant != null && !this.codEstGarant.equals(other.codEstGarant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.EstadoGarantia[ codEstGarant=" + codEstGarant + " ]";
    }
    
}
