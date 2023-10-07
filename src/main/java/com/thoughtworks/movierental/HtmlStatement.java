package com.thoughtworks.movierental;

import java.util.List;

class HtmlStatement {

    private final double totalAmount;
    private final int frequentRenterPoints;
    private final List<Rental> rentals;
    private final String name;

    public HtmlStatement(double totalAmount, int frequentRenterPoints, List<Rental> rentals, String name) {
        this.totalAmount = totalAmount;
        this.frequentRenterPoints = frequentRenterPoints;
        this.rentals = rentals;
        this.name = name;
    }

    public String generate() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlHeader() {
        return "<h1>Rental Record for <b>" + name + "</b> </h1> <br>";
    }

    private String htmlBody() {
        String result = "";
        for (Rental rental : rentals) {
            result += rental.getMovie().getTitle() +
                    rental.amount() + "<br>";
        }
        return result;
    }

    private String htmlFooter() {
        String result = "";

        result += "Amount owed is <b>" + this.totalAmount + "</b><br>";
        result += "You earned <b>" + this.frequentRenterPoints
                + "</b> frequent renter points";
        return result;
    }
}
