package com.app.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "certificate")

/**
 * Certificate model definition used for jpa and javax.
 * The table name is certificate. The object has the following fields:
 * certificate(isin,certType,participationRate, barrierLevel, market,currency,issuer, issuingPrice, currPrice)
 * barrier level and participation rate are optional fields.
 * The class implements Serializable for object serialization on database side and overrides toString, equals and hashCode.
 * **/
public class Certificate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "certType", nullable = false)
    private int certType;

    @NotEmpty
    @Column(name = "isin", nullable = false)
    private String isin;

    @Column(name = "barrierLevel")
    private String barrierLevel;

    @Column(name = "participationRate")
    private String participationRate;

    @NotEmpty
    @Column(name = "market", nullable = false)
    private String market;


    @NotEmpty
    @Column(name = "currency")
    private String currency;

    @NotEmpty
    @Column(name = "issuer", nullable = false)
    private String issuer;

    @Column(name = "issuingPrice", nullable = false)
    private double issuePrice;

    @Column(name = "currPrice", nullable = false)
    private double currentPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public String getIssuer() {return issuer; }
    public void setIssuer(String issuer) { this.issuer = issuer; }
    public double getIssuePrice() {
        return issuePrice;
    }

    public void setIssuePrice(double issuePrice) {
        this.issuePrice = issuePrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getCertType() {
        return certType;
    }
    public String getTypeValue() {
        return CertificateType.values()[getCertType()].toString();
    }

    public void setCertType(int certType) {
        this.certType = certType;
    }

    public String getBarrierLevel() {
        return barrierLevel;
    }

    public void setBarrierLevel(String barrierLevel) {
        this.barrierLevel = barrierLevel;
    }

    public String getParticipationRate() {
        return participationRate;
    }

    public void setParticipationRate(String participationRate) {
        this.participationRate = participationRate;
    }

    /**
     * Function for object comparison, if the id is the same, the objects are the same.
     * **/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Certificate certificate = ( Certificate) o;
        return (id != null && id != certificate.id ) ? true : false;
    }

    /**
     * Hashcode overrided for safe duplicate checks.
     * **/
    @Override
    public int hashCode() {
        int result;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (isin != null ? isin.hashCode() : 0) + (isin != null ? isin.hashCode() : 0);
        return result;
    }

    /**
     * Certificate object's String representation.
     * **/
    @Override
    public String toString() {
        return "[ id," + id + ", isin " + isin + ", market " + market + ", currency " + currency
                + ", issuer " + issuer + ", issuing price " + issuePrice
                + ", current price " + currentPrice + " , typeValue " + this.getTypeValue() +" , certType " + certType +" ]";
    }
}
