package com.school.hotelmanagment.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String phoneNumber;
    private String email;

    // exists for jpa
    protected Booking() {
    }

    public Booking(int id, String name, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Booking id(int id) {
        setId(id);
        return this;
    }

    public Booking name(String name) {
        setName(name);
        return this;
    }

    public Booking phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    public Booking email(String email) {
        setEmail(email);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) o;
        return id == booking.id && Objects.equals(name, booking.name)
                && Objects.equals(phoneNumber, booking.phoneNumber) && Objects.equals(email, booking.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, email);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", phoneNumber='" + getPhoneNumber() + "'" +
                ", email='" + getEmail() + "'" +
                "}";
    }
}
