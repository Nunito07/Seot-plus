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
