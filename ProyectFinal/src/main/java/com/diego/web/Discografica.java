package com.diego.web;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "discografica")
@NamedQueries({
    @NamedQuery(name = "Discografica.findAll", query = "SELECT d FROM Discografica d")})
public class Discografica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_discografica")
    private Integer idDiscografica;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "pais")
    private String pais;
    @OneToMany(mappedBy = "discografica")
    private Collection<Banda> bandaCollection;

    public Discografica(Integer idDiscografica, String nombre, String pais, Collection<Banda> bandaCollection) {
        this.idDiscografica = idDiscografica;
        this.nombre = nombre;
        this.pais = pais;
        this.bandaCollection = bandaCollection;
    }
    
    

    public Discografica() {
    }

    public Discografica(Integer idDiscografica) {
        this.idDiscografica = idDiscografica;
    }

    public Integer getIdDiscografica() {
        return idDiscografica;
    }

    public void setIdDiscografica(Integer idDiscografica) {
        this.idDiscografica = idDiscografica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Collection<Banda> getBandaCollection() {
        return bandaCollection;
    }

    public void setBandaCollection(Collection<Banda> bandaCollection) {
        this.bandaCollection = bandaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiscografica != null ? idDiscografica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discografica)) {
            return false;
        }
        Discografica other = (Discografica) object;
        if ((this.idDiscografica == null && other.idDiscografica != null) || (this.idDiscografica != null && !this.idDiscografica.equals(other.idDiscografica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diego.web.Discografica[ idDiscografica=" + idDiscografica + " ]";
    }
    
}
