package com.thoughtworks.movierental;

public class Customer {
    private final String name;
    private final CustomerRentals rentals;

    public Customer(String name) {
        this.name = name;
        rentals = new CustomerRentals();
    }

    public void addRental(Rental rental) {
        rentals.getRentals().add(rental); //feature envy
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