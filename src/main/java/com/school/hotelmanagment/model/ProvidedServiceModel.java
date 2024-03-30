package com.school.hotelmanagment.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

/**
 * Represents a model for a provided service in a hotel booking system.
 */
@Entity
public class ProvidedServiceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "name cannot be null")
    private String name;
    @NotNull(message = "description cannot be null")
    private String description;
    @NotNull(message = "price cannot be null")
    private double price;

    @Column(insertable = false, updatable = false)
    private int bookingId;

    @ManyToOne
    @JoinColumn(name = "bookingId", nullable = false)
    private Booking booking;

    /**
     * Default constructor.
     */
    public ProvidedServiceModel() {
    }

    /**
     * Parameterized constructor.
     * 
     * @param id          the ID of the provided service
     * @param bookingId   the ID of the booking associated with the provided service
     * @param name        the name of the provided service
     * @param description the description of the provided service
     * @param price       the price of the provided service
     * @param booking     the booking associated with the provided service
     */
    public ProvidedServiceModel(int id, int bookingId, String name, String description, double price, Booking booking) {
        this.id = id;
        this.bookingId = bookingId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.booking = booking;
    }

    /**
     * Get the ID of the provided service.
     * 
     * @return the ID of the provided service
     */
    public int getId() {
        return this.id;
    }

    /**
     * Set the ID of the provided service.
     * 
     * @param id the ID of the provided service
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the ID of the booking associated with the provided service.
     * 
     * @return the ID of the booking associated with the provided service
     */
    public int getBookingId() {
        return this.bookingId;
    }

    /**
     * Set the ID of the booking associated with the provided service.
     * 
     * @param bookingId the ID of the booking associated with the provided service
     */
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    /**
     * Get the name of the provided service.
     * 
     * @return the name of the provided service
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of the provided service.
     * 
     * @param name the name of the provided service
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the description of the provided service.
     * 
     * @return the description of the provided service
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Set the description of the provided service.
     * 
     * @param description the description of the provided service
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the price of the provided service.
     * 
     * @return the price of the provided service
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Set the price of the provided service.
     * 
     * @param price the price of the provided service
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get the booking associated with the provided service.
     * 
     * @return the booking associated with the provided service
     */
    public Booking getBooking() {
        return this.booking;
    }

    /**
     * Set the booking associated with the provided service.
     * 
     * @param booking the booking associated with the provided service
     */
    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    /**
     * Set the ID of the provided service and return the updated object.
     * 
     * @param id the ID of the provided service
     * @return the updated ProvidedServiceModel object
     */
    public ProvidedServiceModel id(int id) {
        setId(id);
        return this;
    }

    /**
     * Set the ID of the booking associated with the provided service and return the updated object.
     * 
     * @param bookingId the ID of the booking associated with the provided service
     * @return the updated ProvidedServiceModel object
     */
    public ProvidedServiceModel bookingId(int bookingId) {
        setBookingId(bookingId);
        return this;
    }

    /**
     * Set the name of the provided service and return the updated object.
     * 
     * @param name the name of the provided service
     * @return the updated ProvidedServiceModel object
     */
    public ProvidedServiceModel name(String name) {
        setName(name);
        return this;
    }

    /**
     * Set the description of the provided service and return the updated object.
     * 
     * @param description the description of the provided service
     * @return the updated ProvidedServiceModel object
     */
    public ProvidedServiceModel description(String description) {
        setDescription(description);
        return this;
    }

    /**
     * Set the price of the provided service and return the updated object.
     * 
     * @param price the price of the provided service
     * @return the updated ProvidedServiceModel object
     */
    public ProvidedServiceModel price(double price) {
        setPrice(price);
        return this;
    }

    /**
     * Set the booking associated with the provided service and return the updated object.
     * 
     * @param booking the booking associated with the provided service
     * @return the updated ProvidedServiceModel object
     */
    public ProvidedServiceModel booking(Booking booking) {
        setBooking(booking);
        return this;
    }

    /**
     * Check if the provided service is equal to another object.
     * 
     * @param o the object to compare
     * @return true if the provided service is equal to the other object, false otherwise
     */
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

    /**
     * Get the hash code of the provided service.
     * 
     * @return the hash code of the provided service
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, bookingId, name, description, price, booking);
    }

    /**
     * Get the string representation of the provided service.
     * 
     * @return the string representation of the provided service
     */
    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", bookingId='" + getBookingId() + "'" +
                ", name='" + getName() + "'" +
                ", description='" + getDescription() + "'" +
                ", price='" + getPrice() + "'" +
                ", booking='" + (getBooking() != null ? getBooking().toString() : "") + "'" +
                "}";
    }
}