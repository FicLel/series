/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fic
 */
@Entity
@Table(name = "serie", catalog = "series", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serie.findAll", query = "SELECT s FROM Serie s"),
    @NamedQuery(name = "Serie.findByIdSeri", query = "SELECT s FROM Serie s WHERE s.idSeri = :idSeri"),
    @NamedQuery(name = "Serie.findByNombreSeri", query = "SELECT s FROM Serie s WHERE s.nombreSeri = :nombreSeri")})
public class Serie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_seri")
    private Integer idSeri;
    @Size(max = 255)
    @Column(name = "nombre_seri")
    private String nombreSeri;
    @JoinColumn(name = "gene_seri", referencedColumnName = "id_gene")
    @ManyToOne(fetch = FetchType.LAZY)
    private Genero geneSeri;

    public Serie() {
    }

    public Serie(Integer idSeri) {
        this.idSeri = idSeri;
    }

    public Integer getIdSeri() {
        return idSeri;
    }

    public void setIdSeri(Integer idSeri) {
        this.idSeri = idSeri;
    }

    public String getNombreSeri() {
        return nombreSeri;
    }

    public void setNombreSeri(String nombreSeri) {
        this.nombreSeri = nombreSeri;
    }

    public Genero getGeneSeri() {
        return geneSeri;
    }

    public void setGeneSeri(Genero geneSeri) {
        this.geneSeri = geneSeri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeri != null ? idSeri.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serie)) {
            return false;
        }
        Serie other = (Serie) object;
        if ((this.idSeri == null && other.idSeri != null) || (this.idSeri != null && !this.idSeri.equals(other.idSeri))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sv.udb.modelo.Serie[ idSeri=" + idSeri + " ]";
    }
    
}
