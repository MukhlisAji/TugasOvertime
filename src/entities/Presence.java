/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author Mukhlish
 */
@Entity
@Table(name = "PRESENCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presence.findAll", query = "SELECT p FROM Presence p")
    , @NamedQuery(name = "Presence.findByPresenceId", query = "SELECT p FROM Presence p WHERE p.presenceId = :presenceId")
    , @NamedQuery(name = "Presence.findByCheckIn", query = "SELECT p FROM Presence p WHERE p.checkIn = :checkIn")
    , @NamedQuery(name = "Presence.findByCheckOut", query = "SELECT p FROM Presence p WHERE p.checkOut = :checkOut")
    , @NamedQuery(name = "Presence.findByPresenceDate", query = "SELECT p FROM Presence p WHERE p.presenceDate = :presenceDate")})
public class Presence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRESENCE_ID")
    private Integer presenceId;
    @Column(name = "CHECK_IN")
    private String checkIn;
    @Column(name = "CHECK_OUT")
    private String checkOut;
    @Column(name = "PRESENCE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date presenceDate;
    @JoinColumn(name = "NIK", referencedColumnName = "NIK")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee nik;

    public Presence() {
    }

    public Presence(Integer presenceId,  Employee nik, String checkIn, String checkOut, Date presenceDate) {
        this.presenceId = presenceId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.presenceDate = presenceDate;
        this.nik = nik;
    }

    public Presence(Integer presenceId) {
        this.presenceId = presenceId;
    }

    public Presence(String id) {
        
    }

    public Integer getPresenceId() {
        return presenceId;
    }

    public void setPresenceId(Integer presenceId) {
        this.presenceId = presenceId;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public Date getPresenceDate() {
        return presenceDate;
    }

    public void setPresenceDate(Date presenceDate) {
        this.presenceDate = presenceDate;
    }

    public Employee getNik() {
        return nik;
    }

    public void setNik(Employee nik) {
        this.nik = nik;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (presenceId != null ? presenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presence)) {
            return false;
        }
        Presence other = (Presence) object;
        if ((this.presenceId == null && other.presenceId != null) || (this.presenceId != null && !this.presenceId.equals(other.presenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Presence[ presenceId=" + presenceId + " ]";
    }
    
}
