package com.example.HAndbook.demo.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "operator")
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operator_id") // operator
    private Long operatorId;

    @Column(name = "operator_code")
    private Integer operatorCode;

    @Column(name = "operator_country")
    private String operatorCountry;

    public Operator() {

    }


    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(Integer operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getOperatorCountry() {
        return operatorCountry;
    }

    public void setOperatorCountry(String operatorCountry) {
        this.operatorCountry = operatorCountry;
    }

    public Operator(List<Operator> operators) {

    }

    public Operator(Long operatorId, String operatorCountry) {
        this.operatorId = operatorId;
        this.operatorCountry = operatorCountry;
    }

    public Operator(Integer operatorCode,
                    Long operatorId, String operatorCountry) {
        this.operatorCode = operatorCode;
        this.operatorId = operatorId;
        this.operatorCountry = operatorCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        if (!Objects.equals(operatorId, operator.operatorId)) return false;
        if (!Objects.equals(operatorCode, operator.operatorCode))
            return false;
        return Objects.equals(operatorCountry, operator.operatorCountry);
    }

    @Override
    public int hashCode() {
        int result = operatorId != null ? operatorId.hashCode() : 0;
        result = 31 * result + (operatorCode != null ? operatorCode.hashCode() : 0);
        result = 31 * result + (operatorCountry != null ? operatorCountry.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Operator{" +
                ", operatorId=" + operatorId +
                ", operatorCode=" + operatorCode +
                ", operatorCountry='" + operatorCountry + '\'' +
                '}';
    }
}