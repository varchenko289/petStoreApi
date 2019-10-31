package io.swagger.tests.api.pet.service;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import io.swagger.petstore.dto.pet.Pet;
import io.swagger.petstore.utils.EntityBuilderUtil;
import io.swagger.petstore.utils.PetUtil;
import io.swagger.tests.api.BaseTest;

import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.swagger.petstore.endpoints.PetServicePath.*;
import static io.swagger.petstore.utils.Constants.QueryParams.*;
import static io.swagger.petstore.utils.PetUtil.createNewPetRequest;
import static io.swagger.petstore.utils.PetUtil.getPetById;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.assertj.core.api.Assertions.assertThat;


public class CreatePetTest extends BaseTest {

    @BeforeClass
    public static void loadFixtures() {
        FixtureFactoryLoader.loadTemplates("io.swagger.petstore.fixtures.templates");

    }

    @Test()
    public void createNewPet() {
        Pet newPet = Fixture.from(Pet.class).gimme("newPet");
        var petResponse = given()
                .body(newPet)
                .when().post(PET)
                .then().log().all()
                .assertThat().statusCode(HTTP_OK)
                .extract().as(Pet.class);
        var createdPet = getPetById(petResponse.getId());

        assertThat(newPet).isEqualToComparingFieldByFieldRecursively(createdPet);
    }

    @Test()
    public void userIsAbleGetPetById() {
        Pet newPet = Fixture.from(Pet.class).gimme("newPet");

        createNewPetRequest(newPet);
        var createdPet = getPetById(newPet.getId());

        assertThat(newPet).isEqualToComparingFieldByFieldRecursively(createdPet);
    }

    @Test()
    public void createPetViaConstructor() {
        PetUtil petUtil = new PetUtil();
        Pet pet = new Pet(
                null,
                EntityBuilderUtil.generateEntityId(),
                petUtil.getCategory(),
                "Sold",
                null,
                null
        );
        createNewPetRequest(pet);
        var testPet = getPetById(pet.getId());

        assertThat(pet).isEqualToComparingFieldByFieldRecursively(testPet);
    }

    @Test()
    public void createNewPetAndValidateResponse() {
        Pet newPet = Fixture.from(Pet.class).gimme("newPet");
        var petResponse = createNewPetRequest(newPet);

        assertThat(newPet).isEqualToComparingFieldByFieldRecursively(petResponse);
    }

    @Test()
    public void petSchemaValidationTest() {
        Pet newPet = Fixture.from(Pet.class).gimme("newPet");
        createNewPetRequest(newPet);

        given()
                .get(PET_BY_ID, newPet.getId())
                .then()
                .body(matchesJsonSchemaInClasspath("schemas/pet.json"));
    }


    @Test()
    public void getListOfPetsWitPendingStatus() {
        given()
                .log().all()
                .when().get(PET_FIND_BY_STATUS, PENDING)
                .then().assertThat().statusCode(HTTP_OK);
    }

    @Test()
    public void getListOfPetsWitSoldStatus() {
        given()
                .log().all()
                .when().get(PET_FIND_BY_STATUS, SOLD)
                .then().assertThat().statusCode(HTTP_OK);
    }

    @Test()
    public void getListOfPetsWitAvailableStatus() {
        given()
                .log().all()
                .when().get(PET_FIND_BY_STATUS, AVAILABLE)
                .then().assertThat().statusCode(HTTP_OK);
    }
}
