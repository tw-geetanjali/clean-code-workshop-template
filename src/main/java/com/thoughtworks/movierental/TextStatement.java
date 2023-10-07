package com.thoughtworks.movierental;

import java.util.List;

class TextStatement {

    private final double totalAmount;
    private final int frequentRenterPoints;
    private final String name;
    private final List<Rental> rentals;

    public TextStatement(double totalAmount, int frequentRenterPoints, String name, List<Rental> rentals) {
        this.totalAmount = totalAmount;
        this.frequentRenterPoints = frequentRenterPoints;
        this.name = name;
        this.rentals = rentals;
    }

    public String generate() {
        return header() + body() + footer();
    }

    private String header() {
        return "Rental Record for " + name + "\n";
    }

    private String body() {
        String result = "";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    rental.amount() + "\n";
        }
        return result;
    }

    private String footer() {
        String result = "";
        result += "Amount owed is " + this.totalAmount + "\n";
        result += "You earned " + this.frequentRenterPoints
                + " frequent renter points";
        return result;
    }
}
