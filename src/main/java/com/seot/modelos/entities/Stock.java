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
@Table(name = "tbl_stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")
    , @NamedQuery(name = "Stock.findByStockId", query = "SELECT s FROM Stock s WHERE s.stockId = :stockId")
    , @NamedQuery(name = "Stock.findBySerial", query = "SELECT s FROM Stock s WHERE s.serial = :serial")
    , @NamedQuery(name = "Stock.findByEstado", query = "SELECT s FROM Stock s WHERE s.estado = :estado")})
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stock_Id")
    private Integer stockId;
    @Basic(optional = false)
    @Column(name = "serial")
    private String serial;
    @Basic(optional = false)
    @Column(name = "estado")
    private int estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "garantProdconCodigoRecibido", fetch = FetchType.LAZY)
    private List<Garantia> garantiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "garantProdconCodigoReposicion", fetch = FetchType.LAZY)
    private List<Garantia> garantiaList1;
    @JoinColumn(name = "tblpedidos_ped_codigo_unico", referencedColumnName = "ped_codigo_unico")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pedido tblpedidosPedCodigoUnico;
    @JoinColumn(name = "tblproductos_prod_referencia", referencedColumnName = "prod_referencia")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto tblproductosProdReferencia;
    @JoinColumn(name = "tbl_Lote_lot_identificador", referencedColumnName = "lot_identificador")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Lote tblLotelotidentificador;

    public Stock() {
    }

    public Stock(Integer stockId) {
        this.stockId = stockId;
    }

    public Stock(Integer stockId, String serial, int estado) {
        this.stockId = stockId;
        this.serial = serial;
        this.estado = estado;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Garantia> getGarantiaList() {
        return garantiaList;
    }

    public void setGarantiaList(List<Garantia> garantiaList) {
        this.garantiaList = garantiaList;
    }

    @XmlTransient
    public List<Garantia> getGarantiaList1() {
        return garantiaList1;
    }

    public void setGarantiaList1(List<Garantia> garantiaList1) {
        this.garantiaList1 = garantiaList1;
    }

    public Pedido getTblpedidosPedCodigoUnico() {
        return tblpedidosPedCodigoUnico;
    }

    public void setTblpedidosPedCodigoUnico(Pedido tblpedidosPedCodigoUnico) {
        this.tblpedidosPedCodigoUnico = tblpedidosPedCodigoUnico;
    }

    public Producto getTblproductosProdReferencia() {
        return tblproductosProdReferencia;
    }

    public void setTblproductosProdReferencia(Producto tblproductosProdReferencia) {
        this.tblproductosProdReferencia = tblproductosProdReferencia;
    }

    public Lote getTblLotelotidentificador() {
        return tblLotelotidentificador;
    }

    public void setTblLotelotidentificador(Lote tblLotelotidentificador) {
        this.tblLotelotidentificador = tblLotelotidentificador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockId != null ? stockId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.stockId == null && other.stockId != null) || (this.stockId != null && !this.stockId.equals(other.stockId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.Stock[ stockId=" + stockId + " ]";
    }
    
}
