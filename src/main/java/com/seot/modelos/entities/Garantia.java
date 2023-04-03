/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seot.modelos.entities;

import java.io.Serializable;
import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Freddy Gonzalez
 */
@Entity
@Table(name = "tbl_garantias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Garantia.findAll", query = "SELECT g FROM Garantia g")
    , @NamedQuery(name = "Garantia.findByGarantCodigo", query = "SELECT g FROM Garantia g WHERE g.garantCodigo = :garantCodigo")
    , @NamedQuery(name = "Garantia.findByGarantFechavencimiento", query = "SELECT g FROM Garantia g WHERE g.garantFechavencimiento = :garantFechavencimiento")
    , @NamedQuery(name = "Garantia.findByGarantFechaingreso", query = "SELECT g FROM Garantia g WHERE g.garantFechaingreso = :garantFechaingreso")
    , @NamedQuery(name = "Garantia.findByGarantFechasalida", query = "SELECT g FROM Garantia g WHERE g.garantFechasalida = :garantFechasalida")
    , @NamedQuery(name = "Garantia.findByGarantNovedad", query = "SELECT g FROM Garantia g WHERE g.garantNovedad = :garantNovedad")
    , @NamedQuery(name = "Garantia.findByGarantNotificacion", query = "SELECT g FROM Garantia g WHERE g.garantNotificacion = :garantNotificacion")})
public class Garantia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "garant_codigo")
    private Integer garantCodigo;
    @Basic(optional = false)
    @Column(name = "garant_fechavencimiento")
    @Temporal(TemporalType.DATE)
    private Date garantFechavencimiento;
    @Basic(optional = false)
    @Column(name = "garant_fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date garantFechaingreso;
    @Basic(optional = false)
    @Column(name = "garant_fechasalida")
    @Temporal(TemporalType.DATE)
    private Date garantFechasalida;
    @Basic(optional = false)
    @Column(name = "garant_novedad")
    private String garantNovedad;
    @Basic(optional = false)
    @Column(name = "garant_notificacion")
    private String garantNotificacion;
    @JoinColumn(name = "garant_prodcon_codigo_recibido", referencedColumnName = "stock_Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Stock garantProdconCodigoRecibido;
    @JoinColumn(name = "garant_prodcon_codigo_reposicion", referencedColumnName = "stock_Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Stock garantProdconCodigoReposicion;
    @JoinColumn(name = "tbl_est_garant_cod_est_garant", referencedColumnName = "cod_est_garant")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoGarantia tblEstGarantCodEstGarant;

    public Garantia() {
    }

    public Garantia(Integer garantCodigo) {
        this.garantCodigo = garantCodigo;
    }

    public Garantia(Integer garantCodigo, Date garantFechavencimiento, Date garantFechaingreso, Date garantFechasalida, String garantNovedad, String garantNotificacion) {
        this.garantCodigo = garantCodigo;
        this.garantFechavencimiento = garantFechavencimiento;
        this.garantFechaingreso = garantFechaingreso;
        this.garantFechasalida = garantFechasalida;
        this.garantNovedad = garantNovedad;
        this.garantNotificacion = garantNotificacion;
    }

    public Integer getGarantCodigo() {
        return garantCodigo;
    }

    public void setGarantCodigo(Integer garantCodigo) {
        this.garantCodigo = garantCodigo;
    }

    public Date getGarantFechavencimiento() {
        return garantFechavencimiento;
    }

    public void setGarantFechavencimiento(Date garantFechavencimiento) {
        this.garantFechavencimiento = garantFechavencimiento;
    }

    public Date getGarantFechaingreso() {
        return garantFechaingreso;
    }

    public void setGarantFechaingreso(Date garantFechaingreso) {
        this.garantFechaingreso = garantFechaingreso;
    }

    public Date getGarantFechasalida() {
        return garantFechasalida;
    }

    public void setGarantFechasalida(Date garantFechasalida) {
        this.garantFechasalida = garantFechasalida;
    }

    public String getGarantNovedad() {
        return garantNovedad;
    }

    public void setGarantNovedad(String garantNovedad) {
        this.garantNovedad = garantNovedad;
    }

    public String getGarantNotificacion() {
        return garantNotificacion;
    }

    public void setGarantNotificacion(String garantNotificacion) {
        this.garantNotificacion = garantNotificacion;
    }

    public Stock getGarantProdconCodigoRecibido() {
        return garantProdconCodigoRecibido;
    }

    public void setGarantProdconCodigoRecibido(Stock garantProdconCodigoRecibido) {
        this.garantProdconCodigoRecibido = garantProdconCodigoRecibido;
    }

    public Stock getGarantProdconCodigoReposicion() {
        return garantProdconCodigoReposicion;
    }

    public void setGarantProdconCodigoReposicion(Stock garantProdconCodigoReposicion) {
        this.garantProdconCodigoReposicion = garantProdconCodigoReposicion;
    }

    public EstadoGarantia getTblEstGarantCodEstGarant() {
        return tblEstGarantCodEstGarant;
    }

    public void setTblEstGarantCodEstGarant(EstadoGarantia tblEstGarantCodEstGarant) {
        this.tblEstGarantCodEstGarant = tblEstGarantCodEstGarant;
    }
    
    
        public int getDiasRestantes() {
        /*
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ChronoLocalDate from = ChronoLocalDate.from(dtf.parse(sdf.format(garantProdconCodigoRecibido.getTblpedidosPedCodigoUnico().getPedFechaEntrega())));
        ChronoLocalDate to = ChronoLocalDate.from(dtf.parse(sdf.format(garantProdconCodigoRecibido.getTblpedidosPedCodigoUnico().getPedFechaMgarantia())));
        ChronoPeriod dif = ChronoPeriod.between(from, to);
        return (int)dif.get(ChronoUnit.DAYS);
         */
        return (int)
                (
                (garantProdconCodigoRecibido.getTblpedidosPedCodigoUnico().getPedFechaMgarantia().getTime()
                - garantProdconCodigoRecibido.getTblpedidosPedCodigoUnico().getPedFechaEntrega().getTime()
                )
                / 86400000);
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (garantCodigo != null ? garantCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Garantia)) {
            return false;
        }
        Garantia other = (Garantia) object;
        if ((this.garantCodigo == null && other.garantCodigo != null) || (this.garantCodigo != null && !this.garantCodigo.equals(other.garantCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seot.modelos.entities.Garantia[ garantCodigo=" + garantCodigo + " ]";
    }
    
}
