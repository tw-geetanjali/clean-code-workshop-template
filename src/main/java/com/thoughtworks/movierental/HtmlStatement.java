package com.thoughtworks.movierental;

class HtmlStatement {

    private final double totalAmount;
    private final int frequentRenterPoints;
    private final CustomerRentals rentals;
    private final String name;

    public HtmlStatement(String name, CustomerRentals rentals) {
        this.totalAmount = rentals.getTotalAmount();
        this.frequentRenterPoints = rentals.getFrequentRenterPoints();
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
        for (Rental rental : rentals.getRentals()) {
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
