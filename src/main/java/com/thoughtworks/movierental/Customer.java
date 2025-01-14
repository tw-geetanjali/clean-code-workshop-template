package com.thoughtworks.movierental;

public class Customer {
    private final String name;
    private final CustomerRentals rentals = new CustomerRentals();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return new TextStatement(name, rentals).generate();
    }

    public String htmlStatement() {
        return new HtmlStatement(name, rentals).generate();
    }

}