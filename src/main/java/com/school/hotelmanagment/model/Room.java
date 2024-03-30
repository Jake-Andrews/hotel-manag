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
 * Represents a room in a hotel.
 */
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

    /**
     * Default constructor.
     */
    public Room() {
    }

    /**
     * Parameterized constructor.
     * 
     * @param id       The ID of the room.
     * @param roomNumber The room number.
     * @param type     The type of the room.
     * @param price    The price of the room.
     * @param bookings The list of bookings associated with the room.
     */
    public Room(int id, int roomNumber, String type, double price, List<Booking> bookings) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.bookings = bookings;
    }

    /**
     * Get the ID of the room.
     * 
     * @return The ID of the room.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Set the ID of the room.
     * 
     * @param id The ID of the room.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the room number.
     * 
     * @return The room number.
     */
    public int getRoomNumber() {
        return this.roomNumber;
    }

    /**
     * Set the room number.
     * 
     * @param roomNumber The room number.
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Get the type of the room.
     * 
     * @return The type of the room.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Set the type of the room.
     * 
     * @param type The type of the room.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the price of the room.
     * 
     * @return The price of the room.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Set the price of the room.
     * 
     * @param price The price of the room.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get the list of bookings associated with the room.
     * 
     * @return The list of bookings associated with the room.
     */
    public List<Booking> getBookings() {
        return this.bookings;
    }

    /**
     * Set the list of bookings associated with the room.
     * 
     * @param bookings The list of bookings associated with the room.
     */
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    /**
     * Set the ID of the room and return the updated Room object.
     * 
     * @param id The ID of the room.
     * @return The updated Room object.
     */
    public Room id(int id) {
        setId(id);
        return this;
    }

    /**
     * Set the room number and return the updated Room object.
     * 
     * @param roomNumber The room number.
     * @return The updated Room object.
     */
    public Room roomNumber(int roomNumber) {
        setRoomNumber(roomNumber);
        return this;
    }

    /**
     * Set the type of the room and return the updated Room object.
     * 
     * @param type The type of the room.
     * @return The updated Room object.
     */
    public Room type(String type) {
        setType(type);
        return this;
    }

    /**
     * Set the price of the room and return the updated Room object.
     * 
     * @param price The price of the room.
     * @return The updated Room object.
     */
    public Room price(double price) {
        setPrice(price);
        return this;
    }

    /**
     * Set the list of bookings associated with the room and return the updated Room object.
     * 
     * @param bookings The list of bookings associated with the room.
     * @return The updated Room object.
     */
    public Room bookings(List<Booking> bookings) {
        setBookings(bookings);
        return this;
    }

    /**
     * Check if this Room object is equal to another object.
     * 
     * @param o The object to compare.
     * @return true if the objects are equal, false otherwise.
     */
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

    /**
     * Get the hash code of this Room object.
     * 
     * @return The hash code of this Room object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, roomNumber, type, price, bookings);
    }

    /**
     * Get a string representation of this Room object.
     * 
     * @return A string representation of this Room object.
     */
    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", roomNumber='" + getRoomNumber() + "'" +
                ", type='" + getType() + "'" +
                ", price='" + getPrice() + "'" +
                // ", bookings='" + (getBookings() != null ? getBookings().toString() : "") +
                // "'" +
                "}";
    }
}
