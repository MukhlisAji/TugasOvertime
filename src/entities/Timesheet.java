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
@Table(name = "TIMESHEET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timesheet.findAll", query = "SELECT t FROM Timesheet t")
    , @NamedQuery(name = "Timesheet.findByTimesheetId", query = "SELECT t FROM Timesheet t WHERE t.timesheetId = :timesheetId")
    , @NamedQuery(name = "Timesheet.findByTsFile", query = "SELECT t FROM Timesheet t WHERE t.tsFile = :tsFile")
    , @NamedQuery(name = "Timesheet.findByTsDate", query = "SELECT t FROM Timesheet t WHERE t.tsDate = :tsDate")})
public class Timesheet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TIMESHEET_ID")
    private Integer timesheetId;
    @Column(name = "TS_FILE")
    private String tsFile;
    @Column(name = "TS_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tsDate;
    @JoinColumn(name = "NIK", referencedColumnName = "NIK")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee nik;

    public Timesheet() {
    }

    public Timesheet(Integer timesheetId) {
        this.timesheetId = timesheetId;
    }

    public Integer getTimesheetId() {
        return timesheetId;
    }

    public void setTimesheetId(Integer timesheetId) {
        this.timesheetId = timesheetId;
    }

    public String getTsFile() {
        return tsFile;
    }

    public void setTsFile(String tsFile) {
        this.tsFile = tsFile;
    }

    public Date getTsDate() {
        return tsDate;
    }

    public void setTsDate(Date tsDate) {
        this.tsDate = tsDate;
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
        hash += (timesheetId != null ? timesheetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timesheet)) {
            return false;
        }
        Timesheet other = (Timesheet) object;
        if ((this.timesheetId == null && other.timesheetId != null) || (this.timesheetId != null && !this.timesheetId.equals(other.timesheetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Timesheet[ timesheetId=" + timesheetId + " ]";
    }
    
}
