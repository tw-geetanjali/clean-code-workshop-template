package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static com.thoughtworks.movierental.MoviePriceCode.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
//characterisation test
class CustomerTest {

    @Test
    public void shouldReturnStatementWhenRentalsAreProvided() {
        int daysRented = 5;
        Customer batman = new Customer("batman");
        batman.addRental(new Rental(new Movie("Movie-1", REGULAR.ordinal()), daysRented));
        batman.addRental(new Rental(new Movie("Movie-2", REGULAR.ordinal()), 1));
        batman.addRental(new Rental(new Movie("Movie-3", CHILDRENS.ordinal()), daysRented));
        batman.addRental(new Rental(new Movie("Movie-4", CHILDRENS.ordinal()), 2));
        batman.addRental(new Rental(new Movie("Movie-5", NEW_RELEASE.ordinal()), daysRented));

        assertEquals("Rental Record for batman\n" +
                "\tMovie-1\t6.5\n" +
                "\tMovie-2\t2.0\n" +
                "\tMovie-3\t4.5\n" +
                "\tMovie-4\t1.5\n" +
                "\tMovie-5\t15.0\n" +
                "Amount owed is 29.5\n" +
                "You earned 6 frequent renter points", batman.statement());
    }

    @Test
    public void shouldReturnHtmlStatementWhenRentalsAreProvided() {
        int daysRented = 5;
        Customer batman = new Customer("batman");
        batman.addRental(new Rental(new Movie("Movie-1", REGULAR.ordinal()), daysRented));
        batman.addRental(new Rental(new Movie("Movie-2", REGULAR.ordinal()), 1));
        batman.addRental(new Rental(new Movie("Movie-3", CHILDRENS.ordinal()), daysRented));
        batman.addRental(new Rental(new Movie("Movie-4", CHILDRENS.ordinal()), 2));
        batman.addRental(new Rental(new Movie("Movie-5", NEW_RELEASE.ordinal()), daysRented));

        assertEquals("<h1>Rental Record for <b>batman</b> </h1> <br>" +
                "Movie-16.5<br>" +
                "Movie-22.0<br>" +
                "Movie-34.5<br>" +
                "Movie-41.5<br>" +
                "Movie-515.0<br>" +
                "Amount owed is <b>29.5</b><br>" +
                "You earned <b>6</b> frequent renter points", batman.htmlStatement());
    }
}