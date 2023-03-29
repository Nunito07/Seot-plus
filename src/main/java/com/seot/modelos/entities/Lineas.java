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
@Table(name = "tb_lineas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineas.findAll", query = "SELECT l FROM Lineas l")
    , @NamedQuery(name = "Lineas.findByLinCodigo", query = "SELECT l FROM Lineas l WHERE l.linCodigo = :linCodigo")
    , @NamedQuery(name = "Lineas.findByLinNombre", query = "SELECT l FROM Lineas l WHERE l.linNombre = :linNombre")
    , @NamedQuery(name = "Lineas.findByLinDescripcion", query = "SELECT l FROM Lineas l WHERE l.linDescripcion = :linDescripcion")})
public class Lineas implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbLineasLinCodigo")
    private List<Planeacion> planeacionList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lin_codigo")
    private Integer linCodigo;
    @Basic(optional = false)
    @Column(name = "lin_nombre")
    private String linNombre;
    @Basic(optional = false)
    @Column(name = "lin_descripcion")
    private String linDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbllineasLinCodigo", fetch = FetchType.LAZY)
    private List<Producto> productoList;

    public Lineas() {
    }

    public Lineas(Integer linCodigo) {
        this.linCodigo = linCodigo;
    }

    public Lineas(Integer linCodigo, String linNombre, String linDescripcion) {
        this.linCodigo = linCodigo;
        this.linNombre = linNombre;
        this.linDescripcion = linDescripcion;
    }

    public Integer getLinCodigo() {
        return linCodigo;
    }

    public void setLinCodigo(Integer linCodigo) {
        this.linCodigo = linCodigo;
    }

    public String getLinNombre() {
        return linNombre;
    }

    public void setLinNombre(String linNombre) {
        this.linNombre = linNombre;
    }

    public String getLinDescripcion() {
        return linDescripcion;
    }

    public void setLinDescripcion(String linDescripcion) {
        this.linDescripcion = linDescripcion;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (linCodigo != null ? linCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineas)) {
            return false;
        }
        Lineas other = (Lineas) object;
        if ((this.linCodigo == null && other.linCodigo != null) || (this.linCodigo != null && !this.linCodigo.equals(other.linCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.Lineas[ linCodigo=" + linCodigo + " ]";
    }

    @XmlTransient
    public List<Planeacion> getPlaneacionList() {
        return planeacionList;
    }

    public void setPlaneacionList(List<Planeacion> planeacionList) {
        this.planeacionList = planeacionList;
    }
    
}
