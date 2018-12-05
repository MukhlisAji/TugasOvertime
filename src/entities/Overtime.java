/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mukhlish
 */
@Entity
@Table(name = "OVERTIME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Overtime.findAll", query = "SELECT o FROM Overtime o")
    , @NamedQuery(name = "Overtime.findByOvertimeId", query = "SELECT o FROM Overtime o WHERE o.overtimeId = :overtimeId")
    , @NamedQuery(name = "Overtime.findByOtDuration", query = "SELECT o FROM Overtime o WHERE o.otDuration = :otDuration")
    , @NamedQuery(name = "Overtime.findByFee", query = "SELECT o FROM Overtime o WHERE o.fee = :fee")
    , @NamedQuery(name = "Overtime.findByStatus", query = "SELECT o FROM Overtime o WHERE o.status = :status")})
public class Overtime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "OVERTIME_ID")
    private Integer overtimeId;
    @Column(name = "OT_DURATION")
    private Short otDuration;
    @Column(name = "FEE")
    private Long fee;
    @Column(name = "STATUS")
    private Short status;
    @JoinColumn(name = "NIK", referencedColumnName = "NIK")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee nik;
    @JoinColumn(name = "PRESENCE_ID", referencedColumnName = "PRESENCE_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Presence presenceId;

    public Overtime() {
    }

    public Overtime(Integer overtimeId) {
        this.overtimeId = overtimeId;
    }

    public Integer getOvertimeId() {
        return overtimeId;
    }

    public void setOvertimeId(Integer overtimeId) {
        this.overtimeId = overtimeId;
    }

    public Short getOtDuration() {
        return otDuration;
    }

    public void setOtDuration(Short otDuration) {
        this.otDuration = otDuration;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Employee getNik() {
        return nik;
    }

    public void setNik(Employee nik) {
        this.nik = nik;
    }

    public Presence getPresenceId() {
        return presenceId;
    }

    public void setPresenceId(Presence presenceId) {
        this.presenceId = presenceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (overtimeId != null ? overtimeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Overtime)) {
            return false;
        }
        Overtime other = (Overtime) object;
        if ((this.overtimeId == null && other.overtimeId != null) || (this.overtimeId != null && !this.overtimeId.equals(other.overtimeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Overtime[ overtimeId=" + overtimeId + " ]";
    }
    
}
