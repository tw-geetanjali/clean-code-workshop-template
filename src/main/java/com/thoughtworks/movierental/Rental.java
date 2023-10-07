package com.thoughtworks.movierental;

import static com.thoughtworks.movierental.MoviePriceCode.NEW_RELEASE;

public class Rental {
    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    double amount() {
        double thisAmount = 0;
        MoviePriceCode priceCode = MoviePriceCode.values()[movie.getPriceCode()];
        switch (priceCode) {
            case REGULAR:
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case CHILDRENS:
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    int getFrequentRenterPoints() {
        if ((movie.getPriceCode() == NEW_RELEASE.ordinal()) && (daysRented > 1))
            return 2;
        return 1;
    }
}