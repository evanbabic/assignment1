package ca.sheridancollege.babice.assignment1.services;

import java.util.Random;

public class ProductServices {
    private final Random random = new Random();

    public Long generateId(){
        return (long) (100000000 + random.nextInt(900000000));
    }
}
