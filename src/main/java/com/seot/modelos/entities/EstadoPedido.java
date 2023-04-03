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
@Table(name = "tbl_estado_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoPedido.findAll", query = "SELECT e FROM EstadoPedido e")
    , @NamedQuery(name = "EstadoPedido.findByCodEstadPed", query = "SELECT e FROM EstadoPedido e WHERE e.codEstadPed = :codEstadPed")
    , @NamedQuery(name = "EstadoPedido.findByTipoEstadPed", query = "SELECT e FROM EstadoPedido e WHERE e.tipoEstadPed = :tipoEstadPed")})
public class EstadoPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_estad_ped")
    private Integer codEstadPed;
    @Basic(optional = false)
    @Column(name = "tipo_estad_ped")
    private String tipoEstadPed;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblEstadoPedidocodestadped", fetch = FetchType.LAZY)
    private List<Pedido> pedidoList;

    public EstadoPedido() {
    }

    public EstadoPedido(Integer codEstadPed) {
        this.codEstadPed = codEstadPed;
    }

    public EstadoPedido(Integer codEstadPed, String tipoEstadPed) {
        this.codEstadPed = codEstadPed;
        this.tipoEstadPed = tipoEstadPed;
    }

    public Integer getCodEstadPed() {
        return codEstadPed;
    }

    public void setCodEstadPed(Integer codEstadPed) {
        this.codEstadPed = codEstadPed;
    }

    public String getTipoEstadPed() {
        return tipoEstadPed;
    }

    public void setTipoEstadPed(String tipoEstadPed) {
        this.tipoEstadPed = tipoEstadPed;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstadPed != null ? codEstadPed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoPedido)) {
            return false;
        }
        EstadoPedido other = (EstadoPedido) object;
        if ((this.codEstadPed == null && other.codEstadPed != null) || (this.codEstadPed != null && !this.codEstadPed.equals(other.codEstadPed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.EstadoPedido[ codEstadPed=" + codEstadPed + " ]";
    }
    
}
