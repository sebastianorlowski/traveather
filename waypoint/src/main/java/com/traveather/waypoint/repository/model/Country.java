package com.traveather.waypoint.repository.model;

import com.traveather.common.entity.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.checkerframework.checker.units.qual.C;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "capital")
    private String capital;

    @Column(name = "area")
    private Integer area;

    @Column(name = "population")
    private Integer population;

    @Column(name = "currency")
    private String currency;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
