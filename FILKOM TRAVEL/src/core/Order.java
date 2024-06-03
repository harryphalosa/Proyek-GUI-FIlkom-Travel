package core;

import core.vehicle.*;

import java.time.LocalDate;

public class Order {
    private LocalDate bookingDate;
    private int duration;
    private int totalPrice;
    private Vehicle vehicle;
    private String menuID;
    private String menuName;
    private String string = "";

    public Order(String menuID, String menuName, String numberPlate, int price) {
        this.menuID = menuID;
        this.menuName = menuName;
        this.vehicle = new Motorcycle(numberPlate, price);
        // jenis kendaran, id, plat, harga
        string = getMenuID() + " - " + getNumberPlate() + " - " + getPricePerDuration() + " ==> Car";
    }

    public Order(String menuID, String menuName, String numberPlate, int price, String customType) {
        this.menuID = menuID;
        this.menuName = menuName;
        this.vehicle = new Car(numberPlate, price, customType);
        string = getMenuID() + " - " + getNumberPlate() + " - " + getPricePerDuration() + " ==> Motorcycle";
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getPricePerDuration() {
        return vehicle.getPrice();
    }

    public int calculatePrice() {
        totalPrice = vehicle.getPrice() * duration;
        return totalPrice;
    }

    public String getMenuID() {
        return menuID;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void updateDuration(int duration) {
        this.duration += duration;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getDuration() {
        return duration;
    }

    public String getNumberPlate() {
        if (vehicle != null) {
            return vehicle.getvehicleNumber();
        }
        return "";
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getStartDate() {
        return bookingDate;
    }

    public LocalDate getEndDate() {
        return bookingDate.plusDays(duration);
    }

    @Override
    public String toString() {
        return this.string;
    }
}