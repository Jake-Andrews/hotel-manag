package com.school.hotelmanagment.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProvidedService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int bookingId;
    private String name;
    private String description;
    private double price;

    @ManyToOne
    @JoinColumn(name = "bookingId", insertable = false, updatable = false)
    private Booking booking;

    public ProvidedService() {
    }

    public ProvidedService(int id, int bookingId, String name, String description, double price, Booking booking) {
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

    public ProvidedService id(int id) {
        setId(id);
        return this;
    }

    public ProvidedService bookingId(int bookingId) {
        setBookingId(bookingId);
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

    public ProvidedService booking(Booking booking) {
        setBooking(booking);
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
