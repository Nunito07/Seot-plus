/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.modelos.entities;

import java.io.Serializable;
import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Freddy Gonzalez
 */
@Entity
@Table(name = "tbl_lote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lote.findAll", query = "SELECT l FROM Lote l")
    , @NamedQuery(name = "Lote.findByLotIdentificador", query = "SELECT l FROM Lote l WHERE l.lotIdentificador = :lotIdentificador")
    , @NamedQuery(name = "Lote.findByLotFechaFabricacion", query = "SELECT l FROM Lote l WHERE l.lotFechaFabricacion = :lotFechaFabricacion")
    , @NamedQuery(name = "Lote.findByLotCantidad", query = "SELECT l FROM Lote l WHERE l.lotCantidad = :lotCantidad")
    , @NamedQuery(name = "Lote.findByLotfechaIngresoStock", query = "SELECT l FROM Lote l WHERE l.lotfechaIngresoStock = :lotfechaIngresoStock")})
public class Lote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lot_identificador")
    private Integer lotIdentificador;
    @Basic(optional = false)
    @Column(name = "lot_fecha_fabricacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lotFechaFabricacion;
    @Basic(optional = false)
    @Column(name = "lot_cantidad")
    private int lotCantidad;
    @Column(name = "lot_fecha_Ingreso_Stock")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lotfechaIngresoStock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblLotelotidentificador", fetch = FetchType.LAZY)
    private List<Stock> stockList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblLotelotidentificador", fetch = FetchType.LAZY)
    private List<CicloDetalle> cicloDetalleList;

    public Lote() {
    }

    public Lote(Integer lotIdentificador) {
        this.lotIdentificador = lotIdentificador;
    }

    public Lote(Integer lotIdentificador, Date lotFechaFabricacion, int lotCantidad) {
        this.lotIdentificador = lotIdentificador;
        this.lotFechaFabricacion = lotFechaFabricacion;
        this.lotCantidad = lotCantidad;
    }

    public Integer getLotIdentificador() {
        return lotIdentificador;
    }

    public void setLotIdentificador(Integer lotIdentificador) {
        this.lotIdentificador = lotIdentificador;
    }

    public Date getLotFechaFabricacion() {
        return lotFechaFabricacion;
    }

    public void setLotFechaFabricacion(Date lotFechaFabricacion) {
        this.lotFechaFabricacion = lotFechaFabricacion;
    }

    public int getLotCantidad() {
        return lotCantidad;
    }

    public void setLotCantidad(int lotCantidad) {
        this.lotCantidad = lotCantidad;
    }

    public Date getLotfechaIngresoStock() {
        return lotfechaIngresoStock;
    }

    public void setLotfechaIngresoStock(Date lotfechaIngresoStock) {
        this.lotfechaIngresoStock = lotfechaIngresoStock;
    }

    @XmlTransient
    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }

    @XmlTransient
    public List<CicloDetalle> getCicloDetalleList() {
        return cicloDetalleList;
    }

    public void setCicloDetalleList(List<CicloDetalle> cicloDetalleList) {
        this.cicloDetalleList = cicloDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lotIdentificador != null ? lotIdentificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lote)) {
            return false;
        }
        Lote other = (Lote) object;
        if ((this.lotIdentificador == null && other.lotIdentificador != null) || (this.lotIdentificador != null && !this.lotIdentificador.equals(other.lotIdentificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.Lote[ lotIdentificador=" + lotIdentificador + " ]";
    }
    
}
