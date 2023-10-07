package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class CustomerRentals {
    private final List<Rental> rentals = new ArrayList<>();

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.amount();
        }
        return totalAmount;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void add(Rental rental) {
        rentals.add(rental);
    }
}
