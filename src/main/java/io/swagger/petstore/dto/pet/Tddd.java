package io.swagger.petstore.dto.pet;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Tddd {
    public static void main(String[] args) {
        usingRandomClass();
    }

    public static void usingRandomClass() {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(500000) + 1;
        System.out.println("Random number generated is : " + randomInt);
    }



}
