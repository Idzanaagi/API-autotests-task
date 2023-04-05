package api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.limitItems.ResponseData;

import static io.restassured.RestAssured.given;

public class CheckListTestCase {
    private final String URL = "https://pokeapi.co/api/v2/ability/";
    private final Integer limitItemsCount = 5;

    @Test
    @DisplayName("CLR-1, check the list restriction with the query parameter limit")
    public void checkTheListRestriction() {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());

        ResponseData limit = given()
                .param("limit", limitItemsCount)
                .when()
                .get()
                .then()
                .extract().as(ResponseData.class);

        Assertions.assertEquals((int) limitItemsCount, limit.getResults().size());
    }

    @Test
    @DisplayName("CLR-2, check if each pokemon has a name on the restricted list")
    public void checkPokemonHasName () {
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());

        ResponseData limit = given()
                .param("limit", limitItemsCount)
                .when()
                .get()
                .then()
                .extract().as(ResponseData.class);

        Assertions.assertTrue(limit.getResults().stream().allMatch(x-> x.getName() != null));
    }

}