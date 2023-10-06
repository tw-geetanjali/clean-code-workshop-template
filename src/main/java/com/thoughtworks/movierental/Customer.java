package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return header() + body() + footer();
    }

    private String footer() {
        String result = "";
        double totalAmount = getTotalAmount();
        int frequentRenterPoints = getFrequentRenterPoints();

        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints
                + " frequent renter points";
        return result;
    }

    private String body() {
        String result = "";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    rental.amount() + "\n";
        }
        return result;
    }

    private int getFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            totalAmount += rental.amount();
        }
        return totalAmount;
    }

    private String header() {
        return "Rental Record for " + getName() + "\n";
    }

    public String htmlStatement() {
        return htmlHeader() + htmlBody() + htmlFooter();
    }

    private String htmlFooter() {
        String result = "";
        double totalAmount = getTotalAmount();
        int frequentRenterPoints = getFrequentRenterPoints();

        result += "Amount owed is <b>" + totalAmount + "</b><br>";
        result += "You earned <b>" + frequentRenterPoints
                + "</b> frequent renter points";
        return result;
    }

    private String htmlBody() {
        String result = "";
        for (Rental rental : rentals) {
            result += rental.getMovie().getTitle() +
                    rental.amount() + "<br>";
        }
        return result;
    }

    private String htmlHeader() {
        return "<h1>Rental Record for <b>" + getName() + "</b> </h1> <br>";
    }

}