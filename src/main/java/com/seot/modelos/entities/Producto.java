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
 * @author Freddy Gonzalez
 */
@Entity
@Table(name = "tbl_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByProdReferencia", query = "SELECT p FROM Producto p WHERE p.prodReferencia = :prodReferencia")
    , @NamedQuery(name = "Producto.findByProdModelo", query = "SELECT p FROM Producto p WHERE p.prodModelo = :prodModelo")
    , @NamedQuery(name = "Producto.findByProdPulgadas", query = "SELECT p FROM Producto p WHERE p.prodPulgadas = :prodPulgadas")
    , @NamedQuery(name = "Producto.findByProdDiametro", query = "SELECT p FROM Producto p WHERE p.prodDiametro = :prodDiametro")
    , @NamedQuery(name = "Producto.findByProdPotencia", query = "SELECT p FROM Producto p WHERE p.prodPotencia = :prodPotencia")
    , @NamedQuery(name = "Producto.findByProdCaudal", query = "SELECT p FROM Producto p WHERE p.prodCaudal = :prodCaudal")
    , @NamedQuery(name = "Producto.findByProdAmperios", query = "SELECT p FROM Producto p WHERE p.prodAmperios = :prodAmperios")
    , @NamedQuery(name = "Producto.findByProdObservaciones", query = "SELECT p FROM Producto p WHERE p.prodObservaciones = :prodObservaciones")
    , @NamedQuery(name = "Producto.findByProdvalorUnitario", query = "SELECT p FROM Producto p WHERE p.prodvalorUnitario = :prodvalorUnitario")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prod_referencia")
    private Integer prodReferencia;
    @Basic(optional = false)
    @Column(name = "prod_modelo")
    private String prodModelo;
    @Column(name = "prod_imagen")
    private String prodImagen;
    @Basic(optional = false)
    @Column(name = "prod_pulgadas")
    private String prodPulgadas;
    @Basic(optional = false)
    @Column(name = "prod_diametro")
    private String prodDiametro;
    @Basic(optional = false)
    @Column(name = "prod_potencia")
    private String prodPotencia;
    @Basic(optional = false)
    @Column(name = "prod_caudal")
    private String prodCaudal;
    @Basic(optional = false)
    @Column(name = "prod_amperios")
    private String prodAmperios;
    @Basic(optional = false)
    @Column(name = "prod_observaciones")
    private String prodObservaciones;
    @Basic(optional = false)
    @Column(name = "prod_valor_Unitario")
    private double prodvalorUnitario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblproductosProdReferencia", fetch = FetchType.LAZY)
    private List<Materialproducto> materialproductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<ProductoCiclo> productoCicloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblproductosProdReferencia", fetch = FetchType.LAZY)
    private List<Stock> stockList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<CotizacionDetalle> cotizacionDetalleList;
    @JoinColumn(name = "tbllineas_lin_codigo", referencedColumnName = "lin_codigo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Lineas tbllineasLinCodigo;

    public Producto() {
    }

    public Producto(Integer prodReferencia) {
        this.prodReferencia = prodReferencia;
    }

    public Producto(Integer prodReferencia, String prodModelo,String prodImagen, String prodPulgadas, String prodDiametro, String prodPotencia, String prodCaudal, String prodAmperios, String prodObservaciones, double prodvalorUnitario) {
        this.prodReferencia = prodReferencia;
        this.prodModelo = prodModelo;
        this.prodImagen = prodImagen;
        this.prodPulgadas = prodPulgadas;
        this.prodDiametro = prodDiametro;
        this.prodPotencia = prodPotencia;
        this.prodCaudal = prodCaudal;
        this.prodAmperios = prodAmperios;
        this.prodObservaciones = prodObservaciones;
        this.prodvalorUnitario = prodvalorUnitario;
    }

    public Integer getProdReferencia() {
        return prodReferencia;
    }

    public void setProdReferencia(Integer prodReferencia) {
        this.prodReferencia = prodReferencia;
    }

    public String getProdModelo() {
        return prodModelo;
    }

    public void setProdModelo(String prodModelo) {
        this.prodModelo = prodModelo;
    }

    public String getProdImagen() {
        return prodImagen;
    }

    public void setProdImagen(String prodImagen) {
        this.prodImagen = prodImagen;
    }
    
    

    public String getProdPulgadas() {
        return prodPulgadas;
    }

    public void setProdPulgadas(String prodPulgadas) {
        this.prodPulgadas = prodPulgadas;
    }

    public String getProdDiametro() {
        return prodDiametro;
    }

    public void setProdDiametro(String prodDiametro) {
        this.prodDiametro = prodDiametro;
    }

    public String getProdPotencia() {
        return prodPotencia;
    }

    public void setProdPotencia(String prodPotencia) {
        this.prodPotencia = prodPotencia;
    }

    public String getProdCaudal() {
        return prodCaudal;
    }

    public void setProdCaudal(String prodCaudal) {
        this.prodCaudal = prodCaudal;
    }

    public String getProdAmperios() {
        return prodAmperios;
    }

    public void setProdAmperios(String prodAmperios) {
        this.prodAmperios = prodAmperios;
    }

    public String getProdObservaciones() {
        return prodObservaciones;
    }

    public void setProdObservaciones(String prodObservaciones) {
        this.prodObservaciones = prodObservaciones;
    }

    public double getProdvalorUnitario() {
        return prodvalorUnitario;
    }

    public void setProdvalorUnitario(double prodvalorUnitario) {
        this.prodvalorUnitario = prodvalorUnitario;
    }

    @XmlTransient
    public List<Materialproducto> getMaterialproductoList() {
        return materialproductoList;
    }

    public void setMaterialproductoList(List<Materialproducto> materialproductoList) {
        this.materialproductoList = materialproductoList;
    }

    @XmlTransient
    public List<ProductoCiclo> getProductoCicloList() {
        return productoCicloList;
    }

    public void setProductoCicloList(List<ProductoCiclo> productoCicloList) {
        this.productoCicloList = productoCicloList;
    }

    @XmlTransient
    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }

    @XmlTransient
    public List<CotizacionDetalle> getCotizacionDetalleList() {
        return cotizacionDetalleList;
    }

    public void setCotizacionDetalleList(List<CotizacionDetalle> cotizacionDetalleList) {
        this.cotizacionDetalleList = cotizacionDetalleList;
    }

    public Lineas getTbllineasLinCodigo() {
        return tbllineasLinCodigo;
    }

    public void setTbllineasLinCodigo(Lineas tbllineasLinCodigo) {
        this.tbllineasLinCodigo = tbllineasLinCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodReferencia != null ? prodReferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.prodReferencia == null && other.prodReferencia != null) || (this.prodReferencia != null && !this.prodReferencia.equals(other.prodReferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.Producto[ prodReferencia=" + prodReferencia + " ]";
    }
    
}
