package io.swagger.petstore.utils;

import io.swagger.petstore.dto.pet.Category;
import io.swagger.petstore.dto.pet.Pet;
import io.swagger.petstore.dto.pet.Tag;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.swagger.petstore.endpoints.PetServicePath.PET;
import static io.swagger.petstore.endpoints.PetServicePath.PET_BY_ID;
import static io.swagger.petstore.utils.EntityBuilderUtil.*;
import static io.swagger.petstore.utils.EntityBuilderUtil.generateEntityName;
import static java.net.HttpURLConnection.HTTP_OK;

public class PetUtil {

    public static Pet createNewPetRequest(Pet newPet) {
        return given()
                .body(newPet)
                .when().post(PET)
                .then()
                .assertThat().statusCode(HTTP_OK).extract().as(Pet.class);
    }

    public static Pet getPetById(int id) {
        return given()
                .when().get(PET_BY_ID, id)
                .then()
                .assertThat().statusCode(HTTP_OK).extract().as(Pet.class);
    }

    public static List<Tag> getListOfTags(int counter) {

        var petUtil = new PetUtil();
        List<Tag> tags = new ArrayList<>();

        for (int i = 0; i < counter; i++) {

            tags.add(petUtil.getSingleTag());
        }
        return tags;
    }

    public Category getCategory() {
        var category = new Category();
        category.setId(generateEntityId());
        category.setName(generateEntityName("My_Test_") + "_Category");

        return category;
    }

    public Tag getSingleTag() {

        var tag = new Tag();
        tag.setName(generateEntityName(generateEntityName("My_Test_Tag")));
        tag.setId(generateEntityId());

        return tag;
    }

    public String getSinglePhotoUrl() {

        return "https://www." + generateEntityId() + "photo.com";
    }

    public List<String> getListOfPhotos(int counter) {

        List<String> photoUrls = new ArrayList<>();

        for (int i = 0; i < counter; i++) {

            photoUrls.add(getSinglePhotoUrl());
        }
        return photoUrls;
    }
}
