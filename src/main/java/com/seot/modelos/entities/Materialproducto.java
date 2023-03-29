/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.modelos.entities;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Freddy Gonzalez
 */
@Entity
@Table(name = "tbl_materiales_tblproductos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materialproducto.findAll", query = "SELECT m FROM Materialproducto m")
    , @NamedQuery(name = "Materialproducto.findByMatProdId", query = "SELECT m FROM Materialproducto m WHERE m.matProdId = :matProdId")
    , @NamedQuery(name = "Materialproducto.findByMatProdCantidad", query = "SELECT m FROM Materialproducto m WHERE m.matProdCantidad = :matProdCantidad")})
public class Materialproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mat_prod_id")
    private Integer matProdId;
    @Basic(optional = false)
    @Column(name = "mat_prod_cantidad")
    private String matProdCantidad;
    @JoinColumn(name = "tblmateriales_mat_referencia", referencedColumnName = "mat_referencia")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Material tblmaterialesMatReferencia;
    @JoinColumn(name = "tblproductos_prod_referencia", referencedColumnName = "prod_referencia")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto tblproductosProdReferencia;

    public Materialproducto() {
    }

    public Materialproducto(Integer matProdId) {
        this.matProdId = matProdId;
    }

    public Materialproducto(Integer matProdId, String matProdCantidad) {
        this.matProdId = matProdId;
        this.matProdCantidad = matProdCantidad;
    }

    public Integer getMatProdId() {
        return matProdId;
    }

    public void setMatProdId(Integer matProdId) {
        this.matProdId = matProdId;
    }

    public String getMatProdCantidad() {
        return matProdCantidad;
    }

    public void setMatProdCantidad(String matProdCantidad) {
        this.matProdCantidad = matProdCantidad;
    }

    public Material getTblmaterialesMatReferencia() {
        return tblmaterialesMatReferencia;
    }

    public void setTblmaterialesMatReferencia(Material tblmaterialesMatReferencia) {
        this.tblmaterialesMatReferencia = tblmaterialesMatReferencia;
    }

    public Producto getTblproductosProdReferencia() {
        return tblproductosProdReferencia;
    }

    public void setTblproductosProdReferencia(Producto tblproductosProdReferencia) {
        this.tblproductosProdReferencia = tblproductosProdReferencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matProdId != null ? matProdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materialproducto)) {
            return false;
        }
        Materialproducto other = (Materialproducto) object;
        if ((this.matProdId == null && other.matProdId != null) || (this.matProdId != null && !this.matProdId.equals(other.matProdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.Materialproducto[ matProdId=" + matProdId + " ]";
    }
    
}
