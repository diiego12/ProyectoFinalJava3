/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.diego.web;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "disco")
@NamedQueries({
    @NamedQuery(name = "Disco.findAll", query = "SELECT d FROM Disco d")})
public class Disco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_disco")
    private Integer idDisco;
    @Size(max = 80)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 80)
    @Column(name = "banda")
    private String banda;
    @Column(name = "a\u00f1o")
    private Integer año;
    @JoinColumn(name = "id_banda", referencedColumnName = "id_banda")
    @ManyToOne
    private Banda idBanda;

    public Disco() {
    }

    public Disco(Integer idDisco) {
        this.idDisco = idDisco;
    }

    public Integer getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(Integer idDisco) {
        this.idDisco = idDisco;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public Banda getIdBanda() {
        return idBanda;
    }

    public void setIdBanda(Banda idBanda) {
        this.idBanda = idBanda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDisco != null ? idDisco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disco)) {
            return false;
        }
        Disco other = (Disco) object;
        if ((this.idDisco == null && other.idDisco != null) || (this.idDisco != null && !this.idDisco.equals(other.idDisco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diego.web.Disco[ idDisco=" + idDisco + " ]";
    }
    
}
