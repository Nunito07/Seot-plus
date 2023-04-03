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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "tbl_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsuId", query = "SELECT u FROM Usuario u WHERE u.usuId = :usuId")
    , @NamedQuery(name = "Usuario.findByUsuNombres", query = "SELECT u FROM Usuario u WHERE u.usuNombres = :usuNombres")
    , @NamedQuery(name = "Usuario.findByUsuPrimerApellido", query = "SELECT u FROM Usuario u WHERE u.usuPrimerApellido = :usuPrimerApellido")
    , @NamedQuery(name = "Usuario.findByUsuSegundoApellido", query = "SELECT u FROM Usuario u WHERE u.usuSegundoApellido = :usuSegundoApellido")
    , @NamedQuery(name = "Usuario.findByUsuDireccion", query = "SELECT u FROM Usuario u WHERE u.usuDireccion = :usuDireccion")
    , @NamedQuery(name = "Usuario.findByUsuTelefono", query = "SELECT u FROM Usuario u WHERE u.usuTelefono = :usuTelefono")
    , @NamedQuery(name = "Usuario.findByUsuCorreoElectronico", query = "SELECT u FROM Usuario u WHERE u.usuCorreoElectronico = :usuCorreoElectronico")
    , @NamedQuery(name = "Usuario.findByUsuContrasena", query = "SELECT u FROM Usuario u WHERE u.usuContrasena = :usuContrasena")
    , @NamedQuery(name = "Usuario.findByUsuEstado", query = "SELECT u FROM Usuario u WHERE u.usuEstado = :usuEstado")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usu_id")
    private Integer usuId;
    @Basic(optional = false)
    @Column(name = "usu_nombres")
    private String usuNombres;
    @Basic(optional = false)
    @Column(name = "usu_primer_apellido")
    private String usuPrimerApellido;
    @Column(name = "usu_segundo_apellido")
    private String usuSegundoApellido;
    @Basic(optional = false)
    @Column(name = "usu_direccion")
    private String usuDireccion;
    @Basic(optional = false)
    @Column(name = "usu_telefono")
    private String usuTelefono;
    @Basic(optional = false)
    @Column(name = "usu_correo_electronico")
    private String usuCorreoElectronico;
    @Basic(optional = false)
    @Column(name = "usu_contrasena")
    private String usuContrasena;
    @Basic(optional = false)
    @Column(name = "usu_estado")
    private int usuEstado;
    @JoinColumn(name = "tblroles_rol_id", referencedColumnName = "rol_id")
    @ManyToOne(optional = false)
    private Rol tblrolesRolId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Sucursal sucursal;

    public Usuario() {
    }

    public Usuario(Integer usuId) {
        this.usuId = usuId;
    }

    public Usuario(Integer usuId, String usuNombres, String usuPrimerApellido, String usuDireccion, String usuTelefono, String usuCorreoElectronico, String usuContrasena, int usuEstado) {
        this.usuId = usuId;
        this.usuNombres = usuNombres;
        this.usuPrimerApellido = usuPrimerApellido;
        this.usuDireccion = usuDireccion;
        this.usuTelefono = usuTelefono;
        this.usuCorreoElectronico = usuCorreoElectronico;
        this.usuContrasena = usuContrasena;
        this.usuEstado = usuEstado;
    }

    public Integer getUsuId() {
        return usuId;
    }

    public void setUsuId(Integer usuId) {
        this.usuId = usuId;
    }

    public String getUsuNombres() {
        return usuNombres;
    }

    public void setUsuNombres(String usuNombres) {
        this.usuNombres = usuNombres;
    }

    public String getUsuPrimerApellido() {
        return usuPrimerApellido;
    }

    public void setUsuPrimerApellido(String usuPrimerApellido) {
        this.usuPrimerApellido = usuPrimerApellido;
    }

    public String getUsuSegundoApellido() {
        return usuSegundoApellido;
    }

    public void setUsuSegundoApellido(String usuSegundoApellido) {
        this.usuSegundoApellido = usuSegundoApellido;
    }

    public String getUsuDireccion() {
        return usuDireccion;
    }

    public void setUsuDireccion(String usuDireccion) {
        this.usuDireccion = usuDireccion;
    }

    public String getUsuTelefono() {
        return usuTelefono;
    }

    public void setUsuTelefono(String usuTelefono) {
        this.usuTelefono = usuTelefono;
    }

    public String getUsuCorreoElectronico() {
        return usuCorreoElectronico;
    }

    public void setUsuCorreoElectronico(String usuCorreoElectronico) {
        this.usuCorreoElectronico = usuCorreoElectronico;
    }

    public String getUsuContrasena() {
        return usuContrasena;
    }

    public void setUsuContrasena(String usuContrasena) {
        this.usuContrasena = usuContrasena;
    }

    public int getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(int usuEstado) {
        this.usuEstado = usuEstado;
    }

    public Rol getTblrolesRolId() {
        return tblrolesRolId;
    }

    public void setTblrolesRolId(Rol tblrolesRolId) {
        this.tblrolesRolId = tblrolesRolId;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuId != null ? usuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuId == null && other.usuId != null) || (this.usuId != null && !this.usuId.equals(other.usuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.Usuario[ usuId=" + usuId + " ]";
    }

}
