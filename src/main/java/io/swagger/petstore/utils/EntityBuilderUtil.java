package io.swagger.petstore.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class EntityBuilderUtil {

    public static int generateEntityId() {
        var randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(50) + 1;

        return randomInt;
    }

    public static String generateEntityName(String predicate) {

        var name = predicate + RandomStringUtils.randomAlphabetic(8);
        randomNumeric(7);

        return name;
    }
}
