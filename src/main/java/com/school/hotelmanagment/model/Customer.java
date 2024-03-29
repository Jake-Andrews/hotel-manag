package com.school.hotelmanagment.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String phoneNumber;
    private String email;

    // mappedBy = "customer" indicates that the customer field in the
    // Booking entity owns the relationship. This means that the Booking
    // table in the database will contain a foreign key column pointing to the
    // Customer table

    // customer class variable was created instead of customerId, since the ORM
    // Object Relational Mapping needs objects to be used in the relationships not
    // fields
    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings;

    public Customer() {
    }

    public Customer(int id, String name, String phoneNumber, String email, List<Booking> bookings) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bookings = bookings;
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

    public List<Booking> getBookings() {
        return this.bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Customer id(int id) {
        setId(id);
        return this;
    }

    public Customer name(String name) {
        setName(name);
        return this;
    }

    public Customer phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    public Customer email(String email) {
        setEmail(email);
        return this;
    }

    public Customer bookings(List<Booking> bookings) {
        setBookings(bookings);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(name, customer.name)
                && Objects.equals(phoneNumber, customer.phoneNumber) && Objects.equals(email, customer.email)
                && Objects.equals(bookings, customer.bookings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, email, bookings);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", phoneNumber='" + getPhoneNumber() + "'" +
                ", email='" + getEmail() + "'" +
                ", bookings='" + getBookings() + "'" +
                "}";
    }
}