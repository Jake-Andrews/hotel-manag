package com.school.hotelmanagment.model;

import java.util.Objects;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int customerId;
    private int roomId;
    private Date startDate;
    private Date endDate;

    protected Customer() {
    }

    public Customer(int id, int customerId, int roomId, Date startDate, Date endDate) {
        this.id = id;
        this.customerId = customerId;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Customer id(int id) {
        setId(id);
        return this;
    }

    public Customer customerId(int customerId) {
        setCustomerId(customerId);
        return this;
    }

    public Customer roomId(int roomId) {
        setRoomId(roomId);
        return this;
    }

    public Customer startDate(Date startDate) {
        setStartDate(startDate);
        return this;
    }

    public Customer endDate(Date endDate) {
        setEndDate(endDate);
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
        return id == customer.id && customerId == customer.customerId && roomId == customer.roomId
                && Objects.equals(startDate, customer.startDate) && Objects.equals(endDate, customer.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, roomId, startDate, endDate);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", customerId='" + getCustomerId() + "'" +
                ", roomId='" + getRoomId() + "'" +
                ", startDate='" + getStartDate() + "'" +
                ", endDate='" + getEndDate() + "'" +
                "}";
    }
}