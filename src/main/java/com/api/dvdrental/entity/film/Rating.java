package com.api.dvdrental.entity.film;

public enum Rating {

    UNRATED("UNRATED"),
    G("G"),
    PG("PG"),
    PG13("PG-13"),
    R("R"),
    NC17("NC-17");

    private String label;

    Rating(String label){
        this.label = label;
    }
}