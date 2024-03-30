package com.school.hotelmanagment.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

/**
 * Represents a customer in the hotel management system.
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "name cannot be null")
    private String name;
    @NotNull(message = "phoneNumber cannot be null")
    private String phoneNumber;
    @NotNull(message = "email cannot be null")
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

    /**
     * Default constructor.
     */
    public Customer() {
    }

    /**
     * Parameterized constructor.
     * 
     * @param id          the customer ID
     * @param name        the customer name
     * @param phoneNumber the customer phone number
     * @param email       the customer email
     * @param bookings    the list of bookings associated with the customer
     */
    public Customer(int id, String name, String phoneNumber, String email, List<Booking> bookings) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bookings = bookings;
    }

    /**
     * Get the customer ID.
     * 
     * @return the customer ID
     */
    public int getId() {
        return this.id;
    }

    /**
     * Set the customer ID.
     * 
     * @param id the customer ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the customer name.
     * 
     * @return the customer name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the customer name.
     * 
     * @param name the customer name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the customer phone number.
     * 
     * @return the customer phone number
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Set the customer phone number.
     * 
     * @param phoneNumber the customer phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the customer email.
     * 
     * @return the customer email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Set the customer email.
     * 
     * @param email the customer email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the list of bookings associated with the customer.
     * 
     * @return the list of bookings
     */
    public List<Booking> getBookings() {
        return this.bookings;
    }

    /**
     * Set the list of bookings associated with the customer.
     * 
     * @param bookings the list of bookings
     */
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    /**
     * Fluent API method to set the customer ID.
     * 
     * @param id the customer ID
     * @return the Customer object
     */
    public Customer id(int id) {
        setId(id);
        return this;
    }

    /**
     * Fluent API method to set the customer name.
     * 
     * @param name the customer name
     * @return the Customer object
     */
    public Customer name(String name) {
        setName(name);
        return this;
    }

    /**
     * Fluent API method to set the customer phone number.
     * 
     * @param phoneNumber the customer phone number
     * @return the Customer object
     */
    public Customer phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    /**
     * Fluent API method to set the customer email.
     * 
     * @param email the customer email
     * @return the Customer object
     */
    public Customer email(String email) {
        setEmail(email);
        return this;
    }

    /**
     * Fluent API method to set the list of bookings associated with the customer.
     * 
     * @param bookings the list of bookings
     * @return the Customer object
     */
    public Customer bookings(List<Booking> bookings) {
        setBookings(bookings);
        return this;
    }

    /**
     * Checks if this Customer object is equal to another object.
     * 
     * @param o the object to compare
     * @return true if the objects are equal, false otherwise
     */
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

    /**
     * Generates the hash code for this Customer object.
     * 
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, email, bookings);
    }

    /**
     * Returns a string representation of this Customer object.
     * 
     * @return the string representation
     */
    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", phoneNumber='" + getPhoneNumber() + "'" +
                ", email='" + getEmail() + "'" +
                ", bookings='" + (getBookings() != null ? getBookings() : "") + "'" +
                "}";
    }
}