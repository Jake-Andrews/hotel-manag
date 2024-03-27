package com.school.hotelmanagment.model;

import java.util.Objects;

public class Room {
    private int id;

    private int roomNumber;
    private String type;
    private double price;

    public Room() {
    }

    public Room(int id, int roomNumber, String type, double price) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Room)) {
            return false;
        }
        Room room = (Room) o;
        return id == room.id && roomNumber == room.roomNumber && Objects.equals(type, room.type) && price == room.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNumber, type, price);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", roomNumber='" + getRoomNumber() + "'" +
                ", type='" + getType() + "'" +
                ", price='" + getPrice() + "'" +
                "}";
    }
}
