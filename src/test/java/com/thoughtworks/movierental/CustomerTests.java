package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static com.thoughtworks.movierental.Movie.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
//characterisation test
class CustomerTest {

    @Test
    public void shouldReturnAmountWhenThreeReqularRentalsAreProvided() {
        int daysRented = 5;
        Customer batman = new Customer("batman");
        batman.addRental(new Rental(new Movie("Movie-1", REGULAR), daysRented));
        batman.addRental(new Rental(new Movie("Movie-2", REGULAR), 1));
        batman.addRental(new Rental(new Movie("Movie-3", CHILDRENS), daysRented));
        batman.addRental(new Rental(new Movie("Movie-4", CHILDRENS), 2));
        batman.addRental(new Rental(new Movie("Movie-5", NEW_RELEASE), daysRented));

        assertEquals("Rental Record for batman\n" +
                "\tMovie-1\t6.5\n" +
                "\tMovie-2\t2.0\n" +
                "\tMovie-3\t4.5\n" +
                "\tMovie-4\t1.5\n" +
                "\tMovie-5\t15.0\n" +
                "Amount owed is 29.5\n" +
                "You earned 6 frequent renter points", batman.statement());
    }
}