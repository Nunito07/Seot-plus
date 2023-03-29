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
 * @author Freddy Gonzalez
 */
@Entity
@Table(name = "tbl_materiales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m")
    , @NamedQuery(name = "Material.findByMatReferencia", query = "SELECT m FROM Material m WHERE m.matReferencia = :matReferencia")
    , @NamedQuery(name = "Material.findByMatNombre", query = "SELECT m FROM Material m WHERE m.matNombre = :matNombre")
    , @NamedQuery(name = "Material.findByMatValorunit", query = "SELECT m FROM Material m WHERE m.matValorunit = :matValorunit")
    , @NamedQuery(name = "Material.findByMatCantStock", query = "SELECT m FROM Material m WHERE m.matCantStock = :matCantStock")})
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mat_referencia")
    private Integer matReferencia;
    @Basic(optional = false)
    @Column(name = "mat_nombre")
    private String matNombre;
    @Basic(optional = false)
    @Column(name = "mat_valorunit")
    private double matValorunit;
    @Column(name = "mat_cant_stock")
    private Integer matCantStock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblmaterialesMatReferencia", fetch = FetchType.LAZY)
    private List<Materialproducto> materialproductoList;
    @JoinColumn(name = "tbl_material_tipo_codigo", referencedColumnName = "tipo_codigo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoMaterial tblMaterialTipoCodigo;

    public Material() {
    }

    public Material(Integer matReferencia) {
        this.matReferencia = matReferencia;
    }

    public Material(Integer matReferencia, String matNombre, double matValorunit) {
        this.matReferencia = matReferencia;
        this.matNombre = matNombre;
        this.matValorunit = matValorunit;
    }

    public Integer getMatReferencia() {
        return matReferencia;
    }

    public void setMatReferencia(Integer matReferencia) {
        this.matReferencia = matReferencia;
    }

    public String getMatNombre() {
        return matNombre;
    }

    public void setMatNombre(String matNombre) {
        this.matNombre = matNombre;
    }

    public double getMatValorunit() {
        return matValorunit;
    }

    public void setMatValorunit(double matValorunit) {
        this.matValorunit = matValorunit;
    }

    public Integer getMatCantStock() {
        return matCantStock;
    }

    public void setMatCantStock(Integer matCantStock) {
        this.matCantStock = matCantStock;
    }

    @XmlTransient
    public List<Materialproducto> getMaterialproductoList() {
        return materialproductoList;
    }

    public void setMaterialproductoList(List<Materialproducto> materialproductoList) {
        this.materialproductoList = materialproductoList;
    }

    public TipoMaterial getTblMaterialTipoCodigo() {
        return tblMaterialTipoCodigo;
    }

    public void setTblMaterialTipoCodigo(TipoMaterial tblMaterialTipoCodigo) {
        this.tblMaterialTipoCodigo = tblMaterialTipoCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matReferencia != null ? matReferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.matReferencia == null && other.matReferencia != null) || (this.matReferencia != null && !this.matReferencia.equals(other.matReferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.Material[ matReferencia=" + matReferencia + " ]";
    }
    
}
