/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.modelos.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "tbl_planeacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planeacion.findAll", query = "SELECT p FROM Planeacion p")
    , @NamedQuery(name = "Planeacion.findByPlaneacionId", query = "SELECT p FROM Planeacion p WHERE p.planeacionId = :planeacionId")
    , @NamedQuery(name = "Planeacion.findByFechaInicioCiclo", query = "SELECT p FROM Planeacion p WHERE p.fechaInicioCiclo = :fechaInicioCiclo")
    , @NamedQuery(name = "Planeacion.findByFechaFinCiclo", query = "SELECT p FROM Planeacion p WHERE p.fechaFinCiclo = :fechaFinCiclo")})
public class Planeacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "planeacion_id")
    private Integer planeacionId;
    @Basic(optional = false)
    @Column(name = "fecha_inicio_ciclo")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioCiclo;
    @Basic(optional = false)
    @Column(name = "fecha_fin_ciclo")
    @Temporal(TemporalType.DATE)
    private Date fechaFinCiclo;
    @JoinColumn(name = "tb_lineas_lin_codigo", referencedColumnName = "lin_codigo")
    @ManyToOne(optional = false)
    private Lineas tbLineasLinCodigo;
    @JoinColumn(name = "ciclo", referencedColumnName = "ciclo_Id")
    @ManyToOne(optional = false)
    private Ciclo ciclo;
    @JoinColumn(name = "tbl_pedidos_ped_codigo_unico", referencedColumnName = "ped_codigo_unico")
    @ManyToOne(optional = false)
    private Pedido tblPedidosPedCodigoUnico;

    public Planeacion() {
    }

    public Planeacion(Integer planeacionId) {
        this.planeacionId = planeacionId;
    }

    public Planeacion(Integer planeacionId, Date fechaInicioCiclo, Date fechaFinCiclo) {
        this.planeacionId = planeacionId;
        this.fechaInicioCiclo = fechaInicioCiclo;
        this.fechaFinCiclo = fechaFinCiclo;
    }

    public Integer getPlaneacionId() {
        return planeacionId;
    }

    public void setPlaneacionId(Integer planeacionId) {
        this.planeacionId = planeacionId;
    }

    public Date getFechaInicioCiclo() {
        return fechaInicioCiclo;
    }

    public void setFechaInicioCiclo(Date fechaInicioCiclo) {
        this.fechaInicioCiclo = fechaInicioCiclo;
    }

    public Date getFechaFinCiclo() {
        return fechaFinCiclo;
    }

    public void setFechaFinCiclo(Date fechaFinCiclo) {
        this.fechaFinCiclo = fechaFinCiclo;
    }

    public Lineas getTbLineasLinCodigo() {
        return tbLineasLinCodigo;
    }

    public void setTbLineasLinCodigo(Lineas tbLineasLinCodigo) {
        this.tbLineasLinCodigo = tbLineasLinCodigo;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Pedido getTblPedidosPedCodigoUnico() {
        return tblPedidosPedCodigoUnico;
    }

    public void setTblPedidosPedCodigoUnico(Pedido tblPedidosPedCodigoUnico) {
        this.tblPedidosPedCodigoUnico = tblPedidosPedCodigoUnico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planeacionId != null ? planeacionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planeacion)) {
            return false;
        }
        Planeacion other = (Planeacion) object;
        if ((this.planeacionId == null && other.planeacionId != null) || (this.planeacionId != null && !this.planeacionId.equals(other.planeacionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.Planeacion[ planeacionId=" + planeacionId + " ]";
    }
    
}
