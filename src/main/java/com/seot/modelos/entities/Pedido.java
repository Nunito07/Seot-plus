/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.modelos.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Freddy Gonzalez
 */
@Entity
@Table(name = "tbl_pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findByPedCodigoUnico", query = "SELECT p FROM Pedido p WHERE p.pedCodigoUnico = :pedCodigoUnico")
    , @NamedQuery(name = "Pedido.findByPedFechaSolicitud", query = "SELECT p FROM Pedido p WHERE p.pedFechaSolicitud = :pedFechaSolicitud")
    , @NamedQuery(name = "Pedido.findByPedFechaEntrega", query = "SELECT p FROM Pedido p WHERE p.pedFechaEntrega = :pedFechaEntrega")
    , @NamedQuery(name = "Pedido.findByPedFechaMgarantia", query = "SELECT p FROM Pedido p WHERE p.pedFechaMgarantia = :pedFechaMgarantia")
    , @NamedQuery(name = "Pedido.findByPedNovedad", query = "SELECT p FROM Pedido p WHERE p.pedNovedad = :pedNovedad")})
public class Pedido implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblPedidosPedCodigoUnico")
    private List<Planeacion> planeacionList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ped_codigo_unico")
    private Integer pedCodigoUnico;
    @Basic(optional = false)
    @Column(name = "ped_fecha_solicitud")
    @Temporal(TemporalType.DATE)
    private Date pedFechaSolicitud;
    @Column(name = "ped_fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date pedFechaEntrega;
    @Column(name = "ped_fecha_mgarantia")
    @Temporal(TemporalType.DATE)
    private Date pedFechaMgarantia;
    @Basic(optional = false)
    @Column(name = "ped_novedad")
    private String pedNovedad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblpedidosPedCodigoUnico", fetch = FetchType.LAZY)
    private List<Stock> stockList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contratimePedCodunic", fetch = FetchType.LAZY)
    private List<Contratiempo> contratiempoList;
    @JoinColumn(name = "tbl_Estado_Pedido_cod_estad_ped", referencedColumnName = "cod_estad_ped")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoPedido tblEstadoPedidocodestadped;
    @JoinColumn(name = "tblcotizacion_cot_cod", referencedColumnName = "cot_cod")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cotizacion tblcotizacionCotCod;

    public Pedido() {
    }

    public Pedido(Integer pedCodigoUnico) {
        this.pedCodigoUnico = pedCodigoUnico;
    }

    public Pedido(Integer pedCodigoUnico, Date pedFechaSolicitud) {
        this.pedCodigoUnico = pedCodigoUnico;
        this.pedFechaSolicitud = pedFechaSolicitud;
 
    }

    public Integer getPedCodigoUnico() {
        return pedCodigoUnico;
    }

    public void setPedCodigoUnico(Integer pedCodigoUnico) {
        this.pedCodigoUnico = pedCodigoUnico;
    }

    public Date getPedFechaSolicitud() {
        return pedFechaSolicitud;
    }

    public void setPedFechaSolicitud(Date pedFechaSolicitud) {
        this.pedFechaSolicitud = pedFechaSolicitud;
    }

    public Date getPedFechaEntrega() {
        return pedFechaEntrega;
    }

    public void setPedFechaEntrega(Date pedFechaEntrega) {
        this.pedFechaEntrega = pedFechaEntrega;
    }

    public Date getPedFechaMgarantia() {
        return pedFechaMgarantia;
    }

    public void setPedFechaMgarantia(Date pedFechaMgarantia) {
        this.pedFechaMgarantia = pedFechaMgarantia;
    }

    public String getPedNovedad() {
        return pedNovedad;
    }

    public void setPedNovedad(String pedNovedad) {
        this.pedNovedad = pedNovedad;
    }

    @XmlTransient
    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }

    @XmlTransient
    public List<Contratiempo> getContratiempoList() {
        return contratiempoList;
    }

    public void setContratiempoList(List<Contratiempo> contratiempoList) {
        this.contratiempoList = contratiempoList;
    }

    public EstadoPedido getTblEstadoPedidocodestadped() {
        return tblEstadoPedidocodestadped;
    }

    public void setTblEstadoPedidocodestadped(EstadoPedido tblEstadoPedidocodestadped) {
        this.tblEstadoPedidocodestadped = tblEstadoPedidocodestadped;
    }

    public Cotizacion getTblcotizacionCotCod() {
        return tblcotizacionCotCod;
    }

    public void setTblcotizacionCotCod(Cotizacion tblcotizacionCotCod) {
        this.tblcotizacionCotCod = tblcotizacionCotCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedCodigoUnico != null ? pedCodigoUnico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.pedCodigoUnico == null && other.pedCodigoUnico != null) || (this.pedCodigoUnico != null && !this.pedCodigoUnico.equals(other.pedCodigoUnico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.Pedido[ pedCodigoUnico=" + pedCodigoUnico + " ]";
    }

    @XmlTransient
    public List<Planeacion> getPlaneacionList() {
        return planeacionList;
    }

    public void setPlaneacionList(List<Planeacion> planeacionList) {
        this.planeacionList = planeacionList;
    }
    
}
