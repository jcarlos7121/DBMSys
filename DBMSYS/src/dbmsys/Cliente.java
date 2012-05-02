/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dbmsys;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "cliente", catalog = "dbmsys", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByNoCliente", query = "SELECT c FROM Cliente c WHERE c.noCliente = :noCliente"),
    @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cliente.findByApellidoM", query = "SELECT c FROM Cliente c WHERE c.apellidoM = :apellidoM"),
    @NamedQuery(name = "Cliente.findByApellidoP", query = "SELECT c FROM Cliente c WHERE c.apellidoP = :apellidoP"),
    @NamedQuery(name = "Cliente.findByCalle", query = "SELECT c FROM Cliente c WHERE c.calle = :calle"),
    @NamedQuery(name = "Cliente.findByCiudad", query = "SELECT c FROM Cliente c WHERE c.ciudad = :ciudad"),
    @NamedQuery(name = "Cliente.findByEstado", query = "SELECT c FROM Cliente c WHERE c.estado = :estado"),
    @NamedQuery(name = "Cliente.findByCp", query = "SELECT c FROM Cliente c WHERE c.cp = :cp"),
    @NamedQuery(name = "Cliente.findByPais", query = "SELECT c FROM Cliente c WHERE c.pais = :pais"),
    @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email"),
    @NamedQuery(name = "Cliente.findByRfc", query = "SELECT c FROM Cliente c WHERE c.rfc = :rfc"),
    @NamedQuery(name = "Cliente.findByDescuentoCliente", query = "SELECT c FROM Cliente c WHERE c.descuentoCliente = :descuentoCliente")})
public class Cliente implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NoCliente")
    private Integer noCliente;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "ApellidoM")
    private String apellidoM;
    @Column(name = "ApellidoP")
    private String apellidoP;
    @Column(name = "Calle")
    private String calle;
    @Column(name = "Ciudad")
    private String ciudad;
    @Column(name = "Estado")
    private String estado;
    @Column(name = "CP")
    private Integer cp;
    @Column(name = "Pais")
    private String pais;
    @Column(name = "Email")
    private String email;
    @Column(name = "RFC")
    private String rfc;
    @Column(name = "DescuentoCliente")
    private Float descuentoCliente;

    public Cliente() {
    }

    public Cliente(Integer noCliente) {
        this.noCliente = noCliente;
    }

    public Integer getNoCliente() {
        return noCliente;
    }

    public void setNoCliente(Integer noCliente) {
        Integer oldNoCliente = this.noCliente;
        this.noCliente = noCliente;
        changeSupport.firePropertyChange("noCliente", oldNoCliente, noCliente);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        String oldApellidoM = this.apellidoM;
        this.apellidoM = apellidoM;
        changeSupport.firePropertyChange("apellidoM", oldApellidoM, apellidoM);
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        String oldApellidoP = this.apellidoP;
        this.apellidoP = apellidoP;
        changeSupport.firePropertyChange("apellidoP", oldApellidoP, apellidoP);
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        String oldCalle = this.calle;
        this.calle = calle;
        changeSupport.firePropertyChange("calle", oldCalle, calle);
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        String oldCiudad = this.ciudad;
        this.ciudad = ciudad;
        changeSupport.firePropertyChange("ciudad", oldCiudad, ciudad);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        String oldEstado = this.estado;
        this.estado = estado;
        changeSupport.firePropertyChange("estado", oldEstado, estado);
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        Integer oldCp = this.cp;
        this.cp = cp;
        changeSupport.firePropertyChange("cp", oldCp, cp);
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        String oldPais = this.pais;
        this.pais = pais;
        changeSupport.firePropertyChange("pais", oldPais, pais);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        String oldRfc = this.rfc;
        this.rfc = rfc;
        changeSupport.firePropertyChange("rfc", oldRfc, rfc);
    }

    public Float getDescuentoCliente() {
        return descuentoCliente;
    }

    public void setDescuentoCliente(Float descuentoCliente) {
        Float oldDescuentoCliente = this.descuentoCliente;
        this.descuentoCliente = descuentoCliente;
        changeSupport.firePropertyChange("descuentoCliente", oldDescuentoCliente, descuentoCliente);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noCliente != null ? noCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.noCliente == null && other.noCliente != null) || (this.noCliente != null && !this.noCliente.equals(other.noCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbmsys.Cliente[noCliente=" + noCliente + "]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
