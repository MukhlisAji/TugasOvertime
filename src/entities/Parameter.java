/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mukhlish
 */
@Entity
@Table(name = "PARAMETER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parameter.findAll", query = "SELECT p FROM Parameter p")
    , @NamedQuery(name = "Parameter.findByParameterId", query = "SELECT p FROM Parameter p WHERE p.parameterId = :parameterId")
    , @NamedQuery(name = "Parameter.findByParamName", query = "SELECT p FROM Parameter p WHERE p.paramName = :paramName")
    , @NamedQuery(name = "Parameter.findByValue", query = "SELECT p FROM Parameter p WHERE p.value = :value")})
public class Parameter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PARAMETER_ID")
    private Integer parameterId;
    @Column(name = "PARAM_NAME")
    private String paramName;
    @Column(name = "VALUE")
    private Long value;

    public Parameter() {
    }

    public Parameter(Integer parameterId) {
        this.parameterId = parameterId;
    }

    public Parameter(Integer parameterId, String paramName, Long value) {
        this.parameterId = parameterId;
        this.paramName = paramName;
        this.value = value;
    }


    public Integer getParameterId() {
        return parameterId;
    }

    public void setParameterId(Integer parameterId) {
        this.parameterId = parameterId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parameterId != null ? parameterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parameter)) {
            return false;
        }
        Parameter other = (Parameter) object;
        if ((this.parameterId == null && other.parameterId != null) || (this.parameterId != null && !this.parameterId.equals(other.parameterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Parameter[ parameterId=" + parameterId + " ]";
    }
    
}
