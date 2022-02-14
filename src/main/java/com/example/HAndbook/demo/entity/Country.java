package com.example.HAndbook.demo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "country")
public class Country{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_area_code_id", nullable=false, unique = true)
    private Long countryAreaCodeId;

    @Column(name = "country_name", nullable=false, unique=true)
    private String countryName;

    @Column(name = "address", nullable=false)
    private String address;


    public Country() {

    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public long getCountryAreaCodeId() {
        return countryAreaCodeId;
    }

    public void setСountryAreaCodeId(Long countryAreaCodeId) {
        this.countryAreaCodeId = countryAreaCodeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void Country() {
    }

    public Country(String countryName, String address) {
        this.countryName = countryName;
        this.address = address;
    }

    public Country(String countryName, Long countryAreaCodeId, String address) {
        this.countryName = countryName;
        this.countryAreaCodeId = countryAreaCodeId;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (!Objects.equals(countryAreaCodeId, country.countryAreaCodeId))
            return false;
        if (!Objects.equals(countryName, country.countryName)) return false;
        return Objects.equals(address, country.address);
    }

    @Override
    public int hashCode() {
        int result = countryAreaCodeId != null ? countryAreaCodeId.hashCode() : 0;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "CountryAreaCodeId=" + countryAreaCodeId +
                ", CountryName='" + countryName + '\'' +
                ", Address='" + address + '\'' +
                '}';
    }
}
