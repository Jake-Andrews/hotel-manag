package com.school.hotelmanagment.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class ProvidedServiceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "bookingId cannot be null")
    private int bookingId;
    @NotNull(message = "name cannot be null")
    private String name;
    @NotNull(message = "description cannot be null")
    private String description;
    @NotNull(message = "price cannot be null")
    private double price;

    @ManyToOne
    @JoinColumn(name = "bookingId", insertable = false, updatable = false, referencedColumnName = "id")
    private Booking booking;

    public ProvidedServiceModel() {
    }

    public ProvidedServiceModel(int id, int bookingId, String name, String description, double price, Booking booking) {
        this.id = id;
        this.bookingId = bookingId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.booking = booking;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookingId() {
        return this.bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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

    public Booking getBooking() {
        return this.booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public ProvidedServiceModel id(int id) {
        setId(id);
        return this;
    }

    public ProvidedServiceModel bookingId(int bookingId) {
        setBookingId(bookingId);
        return this;
    }

    public ProvidedServiceModel name(String name) {
        setName(name);
        return this;
    }

    public ProvidedServiceModel description(String description) {
        setDescription(description);
        return this;
    }

    public ProvidedServiceModel price(double price) {
        setPrice(price);
        return this;
    }

    public ProvidedServiceModel booking(Booking booking) {
        setBooking(booking);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProvidedServiceModel)) {
            return false;
        }
        ProvidedServiceModel providedService = (ProvidedServiceModel) o;
        return id == providedService.id && bookingId == providedService.bookingId
                && Objects.equals(name, providedService.name)
                && Objects.equals(description, providedService.description) && price == providedService.price
                && Objects.equals(booking, providedService.booking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookingId, name, description, price, booking);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", bookingId='" + getBookingId() + "'" +
                ", name='" + getName() + "'" +
                ", description='" + getDescription() + "'" +
                ", price='" + getPrice() + "'" +
                ", booking='" + getBooking() + "'" +
                "}";
    }
}
