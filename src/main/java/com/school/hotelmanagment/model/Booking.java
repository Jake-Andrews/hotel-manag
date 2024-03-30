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

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // @NotNull(message = "customerId cannot be null")
    // private int customerId;
    // @NotNull(message = "roomId cannot be null")
    // private int roomId;
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

    public Booking() {
    }

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

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getRoomId() {
        return this.roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Room getRoom() {
        return this.room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ProvidedServiceModel> getProvidedServices() {
        return this.providedServices;
    }

    public void setProvidedServices(List<ProvidedServiceModel> providedServices) {
        this.providedServices = providedServices;
    }

    public Booking id(int id) {
        setId(id);
        return this;
    }

    public Booking customerId(int customerId) {
        setCustomerId(customerId);
        return this;
    }

    public Booking roomId(int roomId) {
        setRoomId(roomId);
        return this;
    }

    public Booking startDate(Date startDate) {
        setStartDate(startDate);
        return this;
    }

    public Booking endDate(Date endDate) {
        setEndDate(endDate);
        return this;
    }

    public Booking room(Room room) {
        setRoom(room);
        return this;
    }

    public Booking customer(Customer customer) {
        setCustomer(customer);
        return this;
    }

    public Booking providedServices(List<ProvidedServiceModel> providedServices) {
        setProvidedServices(providedServices);
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
        return id == booking.id && customerId == booking.customerId && roomId == booking.roomId
                && Objects.equals(startDate, booking.startDate) && Objects.equals(endDate, booking.endDate)
                && Objects.equals(room, booking.room) && Objects.equals(customer, booking.customer)
                && Objects.equals(providedServices, booking.providedServices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, roomId, startDate, endDate, room, customer, providedServices);
    }

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