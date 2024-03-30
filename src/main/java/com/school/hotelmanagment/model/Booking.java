package com.school.hotelmanagment.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

/**
 * Represents a booking made by a customer for a room in a hotel.
 */
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "startDate cannot be null")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "endDate cannot be null")
    private Date endDate;

    @Column(insertable = false, updatable = false)
    private int customerId;

    @Column(insertable = false, updatable = false)
    private int roomId;

    @ManyToOne
    @JoinColumn(name = "roomId", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    @OneToMany
    private List<ProvidedServiceModel> providedServices;

    /**
     * Default constructor.
     */
    public Booking() {
    }

    /**
     * Parameterized constructor.
     * 
     * @param id               The ID of the booking.
     * @param customerId       The ID of the customer making the booking.
     * @param roomId           The ID of the room being booked.
     * @param startDate        The start date of the booking.
     * @param endDate          The end date of the booking.
     * @param room             The room being booked.
     * @param customer         The customer making the booking.
     * @param providedServices The list of provided services for the booking.
     */
    public Booking(int id, int customerId, int roomId, Date startDate, Date endDate, Room room, Customer customer,
            List<ProvidedServiceModel> providedServices) {
        this.id = id;
        this.customerId = customerId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.customer = customer;
        this.providedServices = providedServices;
    }

    /**
     * Get the ID of the booking.
     * 
     * @return The ID of the booking.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Set the ID of the booking.
     * 
     * @param id The ID of the booking.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the ID of the customer making the booking.
     * 
     * @return The ID of the customer making the booking.
     */
    public int getCustomerId() {
        return this.customerId;
    }

    /**
     * Set the ID of the customer making the booking.
     * 
     * @param customerId The ID of the customer making the booking.
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Get the ID of the room being booked.
     * 
     * @return The ID of the room being booked.
     */
    public int getRoomId() {
        return this.roomId;
    }

    /**
     * Set the ID of the room being booked.
     * 
     * @param roomId The ID of the room being booked.
     */
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    /**
     * Get the start date of the booking.
     * 
     * @return The start date of the booking.
     */
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * Set the start date of the booking.
     * 
     * @param startDate The start date of the booking.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Get the end date of the booking.
     * 
     * @return The end date of the booking.
     */
    public Date getEndDate() {
        return this.endDate;
    }

    /**
     * Set the end date of the booking.
     * 
     * @param endDate The end date of the booking.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Get the room being booked.
     * 
     * @return The room being booked.
     */
    public Room getRoom() {
        return this.room;
    }

    /**
     * Set the room being booked.
     * 
     * @param room The room being booked.
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Get the customer making the booking.
     * 
     * @return The customer making the booking.
     */
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * Set the customer making the booking.
     * 
     * @param customer The customer making the booking.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Get the list of provided services for the booking.
     * 
     * @return The list of provided services for the booking.
     */
    public List<ProvidedServiceModel> getProvidedServices() {
        return this.providedServices;
    }

    /**
     * Set the list of provided services for the booking.
     * 
     * @param providedServices The list of provided services for the booking.
     */
    public void setProvidedServices(List<ProvidedServiceModel> providedServices) {
        this.providedServices = providedServices;
    }

    /**
     * Set the ID of the booking and return the updated booking object.
     * 
     * @param id The ID of the booking.
     * @return The updated booking object.
     */
    public Booking id(int id) {
        setId(id);
        return this;
    }

    /**
     * Set the ID of the customer making the booking and return the updated booking
     * object.
     * 
     * @param customerId The ID of the customer making the booking.
     * @return The updated booking object.
     */
    public Booking customerId(int customerId) {
        setCustomerId(customerId);
        return this;
    }

    /**
     * Set the ID of the room being booked and return the updated booking object.
     * 
     * @param roomId The ID of the room being booked.
     * @return The updated booking object.
     */
    public Booking roomId(int roomId) {
        setRoomId(roomId);
        return this;
    }

    /**
     * Set the start date of the booking and return the updated booking object.
     * 
     * @param startDate The start date of the booking.
     * @return The updated booking object.
     */
    public Booking startDate(Date startDate) {
        setStartDate(startDate);
        return this;
    }

    /**
     * Set the end date of the booking and return the updated booking object.
     * 
     * @param endDate The end date of the booking.
     * @return The updated booking object.
     */
    public Booking endDate(Date endDate) {
        setEndDate(endDate);
        return this;
    }

    /**
     * Set the room being booked and return the updated booking object.
     * 
     * @param room The room being booked.
     * @return The updated booking object.
     */
    public Booking room(Room room) {
        setRoom(room);
        return this;
    }

    /**
     * Set the customer making the booking and return the updated booking object.
     * 
     * @param customer The customer making the booking.
     * @return The updated booking object.
     */
    public Booking customer(Customer customer) {
        setCustomer(customer);
        return this;
    }

    /**
     * Set the list of provided services for the booking and return the updated
     * booking object.
     * 
     * @param providedServices The list of provided services for the booking.
     * @return The updated booking object.
     */
    public Booking providedServices(List<ProvidedServiceModel> providedServices) {
        setProvidedServices(providedServices);
        return this;
    }

    /**
     * Check if this booking is equal to another object.
     * 
     * @param o The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) o;
        return id == booking.id && customerId == booking.customerId && roomId == booking.roomId
                && Objects.equals(startDate, booking.startDate) && Objects.equals(endDate, booking.endDate)
                && Objects.equals(room, booking.room) && Objects.equals(customer, booking.customer)
                && Objects.equals(providedServices, booking.providedServices);
    }

    /**
     * Get the hash code of this booking.
     * 
     * @return The hash code of this booking.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, roomId, startDate, endDate, room, customer, providedServices);
    }

    /**
     * Get a string representation of this booking.
     * 
     * @return A string representation of this booking.
     */
    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                // ", customerId='" + getCustomerId() + "'" +
                // ", roomId='" + getRoomId() + "'" +
                ", startDate='" + getStartDate() + "'" +
                ", endDate='" + getEndDate() + "'" +
                // ", room='" + (getRoom() != null ? getRoom().toString() : null) + "'" +
                // ", customer='" + (getCustomer() != null ? getCustomer().toString() : null) +
                // "'" +
                // ", providedServices='" + (getProvidedServices() != null ?
                // getProvidedServices().toString() : null) + "'"
                // +
                "}";
    }
}