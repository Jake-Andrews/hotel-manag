# Hotel Management Project

This is a project for managing a hotel.

## Screenshots

Homepage
![index.png](images/index.png)

Customers
![customers.png](images/customers.png)
![customers1.png](images/customers1.png)

Room
![room.png](images/room.png)
![room1.png](images/room1.png)

Booking page, note the customer name and room number map onto the customer ID and room ID in the code and are used instead for the users convenience.

An email is as unique as a customer ID, but easier for the user to distinguish/remember. And room numbers are as unique as a room ID, but easier to remember.

The dropdown menus contain a list of every customer and room that has been added so far.

![booking.png](images/booking.png)
![booking1.png](images/booking1.png)
![booking2.png](images/booking2.png)

Services
![services.png](images/services.png)
![services1.png](images/services.png)

## Installation

1. Clone the repository.
2. Run `mvn package`

## Usage

1. Run the jar file that was generated from the last step.
   `java -jar ./target/hotel-manag-0.0.1-SNAPSHOT.jar`
   Or
   `mvn spring-boot:run`
2. Open your browser and navigate to `localhost:8080`.
