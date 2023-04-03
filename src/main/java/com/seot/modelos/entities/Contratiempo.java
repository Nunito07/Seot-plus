/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.modelos.entities;

import java.io.Serializable;
import jakarta.persistence.Basic;
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
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Freddy Gonzalez
 */
@Entity
@Table(name = "tbl_contratiempos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contratiempo.findAll", query = "SELECT c FROM Contratiempo c")
    , @NamedQuery(name = "Contratiempo.findByContratimeId", query = "SELECT c FROM Contratiempo c WHERE c.contratimeId = :contratimeId")
    , @NamedQuery(name = "Contratiempo.findByContratimeNombre", query = "SELECT c FROM Contratiempo c WHERE c.contratimeNombre = :contratimeNombre")
    , @NamedQuery(name = "Contratiempo.findByContratimeDescripcion", query = "SELECT c FROM Contratiempo c WHERE c.contratimeDescripcion = :contratimeDescripcion")})
public class Contratiempo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contratime_id")
    private Integer contratimeId;
    @Basic(optional = false)
    @Column(name = "contratime_nombre")
    private String contratimeNombre;
    @Basic(optional = false)
    @Column(name = "contratime_descripcion")
    private String contratimeDescripcion;
    @JoinColumn(name = "contratime_ped_codunic", referencedColumnName = "ped_codigo_unico")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pedido contratimePedCodunic;

    public Contratiempo() {
    }

    public Contratiempo(Integer contratimeId) {
        this.contratimeId = contratimeId;
    }

    public Contratiempo(Integer contratimeId, String contratimeNombre, String contratimeDescripcion) {
        this.contratimeId = contratimeId;
        this.contratimeNombre = contratimeNombre;
        this.contratimeDescripcion = contratimeDescripcion;
    }

    public Integer getContratimeId() {
        return contratimeId;
    }

    public void setContratimeId(Integer contratimeId) {
        this.contratimeId = contratimeId;
    }

    public String getContratimeNombre() {
        return contratimeNombre;
    }

    public void setContratimeNombre(String contratimeNombre) {
        this.contratimeNombre = contratimeNombre;
    }

    public String getContratimeDescripcion() {
        return contratimeDescripcion;
    }

    public void setContratimeDescripcion(String contratimeDescripcion) {
        this.contratimeDescripcion = contratimeDescripcion;
    }

    public Pedido getContratimePedCodunic() {
        return contratimePedCodunic;
    }

    public void setContratimePedCodunic(Pedido contratimePedCodunic) {
        this.contratimePedCodunic = contratimePedCodunic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contratimeId != null ? contratimeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contratiempo)) {
            return false;
        }
        Contratiempo other = (Contratiempo) object;
        if ((this.contratimeId == null && other.contratimeId != null) || (this.contratimeId != null && !this.contratimeId.equals(other.contratimeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.Contratiempo[ contratimeId=" + contratimeId + " ]";
    }
    
}
