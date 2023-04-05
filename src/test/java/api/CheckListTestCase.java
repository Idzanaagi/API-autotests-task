package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.limitItems.ResponseData;

import static io.restassured.RestAssured.given;

public class CheckListTestCase {
    public Integer limitItemsCount = 5;
    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://pokeapi.co/api/v2//pokemon/")
            .addQueryParam("limit", limitItemsCount)
            .setContentType("ContentType.JSON")
            .build();

    @Test
    @DisplayName("CLR-1, check the list restriction with the query parameter limit")
    public void checkTheListRestriction() {

        ResponseData limit = given()
                .when()
                .spec(requestSpec)
                .get()
                .then()
                .extract().as(ResponseData.class);

        Assertions.assertEquals((int) limitItemsCount, limit.getResults().size());
    }

    @Test
    @DisplayName("CLR-2, check if each pokemon has a name on the restricted list")
    public void checkPokemonHasName () {

        ResponseData limit = given()
                .when()
                .spec(requestSpec)
                .get()
                .then()
                .extract().as(ResponseData.class);

        Assertions.assertTrue(limit.getResults().stream().allMatch(x-> x.getName() != null));
    }

}