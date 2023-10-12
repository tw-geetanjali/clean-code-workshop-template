package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class CustomerRentals extends ArrayList<Rental> {

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : this) {
            frequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : this) {
            totalAmount += rental.amount();
        }
        return totalAmount;
    }

    public List<Rental> getRentals() {
        return this;
    }

}
