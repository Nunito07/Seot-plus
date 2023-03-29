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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Freddy Gonzalez
 */
@Entity
@Table(name = "tbl_tipo_material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoMaterial.findAll", query = "SELECT t FROM TipoMaterial t")
    , @NamedQuery(name = "TipoMaterial.findByTipoCodigo", query = "SELECT t FROM TipoMaterial t WHERE t.tipoCodigo = :tipoCodigo")
    , @NamedQuery(name = "TipoMaterial.findByTipoNombre", query = "SELECT t FROM TipoMaterial t WHERE t.tipoNombre = :tipoNombre")})
public class TipoMaterial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_codigo")
    private Integer tipoCodigo;
    @Basic(optional = false)
    @Column(name = "tipo_nombre")
    private String tipoNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblMaterialTipoCodigo", fetch = FetchType.LAZY)
    private List<Material> materialList;

    public TipoMaterial() {
    }

    public TipoMaterial(Integer tipoCodigo) {
        this.tipoCodigo = tipoCodigo;
    }

    public TipoMaterial(Integer tipoCodigo, String tipoNombre) {
        this.tipoCodigo = tipoCodigo;
        this.tipoNombre = tipoNombre;
    }

    public Integer getTipoCodigo() {
        return tipoCodigo;
    }

    public void setTipoCodigo(Integer tipoCodigo) {
        this.tipoCodigo = tipoCodigo;
    }

    public String getTipoNombre() {
        return tipoNombre;
    }

    public void setTipoNombre(String tipoNombre) {
        this.tipoNombre = tipoNombre;
    }

    @XmlTransient
    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoCodigo != null ? tipoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMaterial)) {
            return false;
        }
        TipoMaterial other = (TipoMaterial) object;
        if ((this.tipoCodigo == null && other.tipoCodigo != null) || (this.tipoCodigo != null && !this.tipoCodigo.equals(other.tipoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.TipoMaterial[ tipoCodigo=" + tipoCodigo + " ]";
    }
    
}
