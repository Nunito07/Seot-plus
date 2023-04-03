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
