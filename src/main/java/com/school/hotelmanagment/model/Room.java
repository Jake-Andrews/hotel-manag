package com.school.hotelmanagment.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "roomNumber cannot be null")
    private int roomNumber;
    @NotNull(message = "type cannot be null")
    private String type;
    @NotNull(message = "price cannot be null")
    private double price;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;

    public Room() {
    }

    public Room(int id, int roomNumber, String type, double price, List<Booking> bookings) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.bookings = bookings;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Booking> getBookings() {
        return this.bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Room id(int id) {
        setId(id);
        return this;
    }

    public Room roomNumber(int roomNumber) {
        setRoomNumber(roomNumber);
        return this;
    }

    public Room type(String type) {
        setType(type);
        return this;
    }

    public Room price(double price) {
        setPrice(price);
        return this;
    }

    public Room bookings(List<Booking> bookings) {
        setBookings(bookings);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Room)) {
            return false;
        }
        Room room = (Room) o;
        return id == room.id && roomNumber == room.roomNumber && Objects.equals(type, room.type) && price == room.price
                && Objects.equals(bookings, room.bookings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNumber, type, price, bookings);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", roomNumber='" + getRoomNumber() + "'" +
                ", type='" + getType() + "'" +
                ", price='" + getPrice() + "'" +
                ", bookings='" + (getBookings() != null ? getBookings().toString() : "") + "'" +
                "}";
    }
}
