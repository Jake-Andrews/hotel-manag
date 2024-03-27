package com.school.hotelmanagment.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProvidedService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String description;
    private double price;

    protected ProvidedService() {
    }

    public ProvidedService(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProvidedService id(int id) {
        setId(id);
        return this;
    }

    public ProvidedService name(String name) {
        setName(name);
        return this;
    }

    public ProvidedService description(String description) {
        setDescription(description);
        return this;
    }

    public ProvidedService price(double price) {
        setPrice(price);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProvidedService)) {
            return false;
        }
        ProvidedService providedService = (ProvidedService) o;
        return id == providedService.id && Objects.equals(name, providedService.name)
                && Objects.equals(description, providedService.description) && price == providedService.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", description='" + getDescription() + "'" +
                ", price='" + getPrice() + "'" +
                "}";
    }
}
