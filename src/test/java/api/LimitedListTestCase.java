package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

import pojo.limitedList.ResponseData;

public class LimitedListTestCase {
    private final Integer limitItemsCount = 5;
    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://pokeapi.co/api/v2/pokemon/")
            .addQueryParam("limit", limitItemsCount)
            .setContentType(ContentType.JSON)
            .build();

    @Test
    @DisplayName("CLR-1, check the list restriction with the query parameter limit")
    public void checkTheListRestriction() {

        ResponseData limitedListData = given()
                .when()
                .spec(requestSpec)
                .get()
                .then()
                .extract().as(ResponseData.class);

        Assertions.assertEquals((int) limitItemsCount, limitedListData.getResults().size());
    }

    @Test
    @DisplayName("CLR-2, check if each pokemon has a name on the restricted list")
    public void checkEveryPokemonHasName () {

        ResponseData limitedListData = given()
                .when()
                .spec(requestSpec)
                .get()
                .then()
                .extract().as(ResponseData.class);

        Assertions.assertTrue(limitedListData.getResults().stream().allMatch(x-> x.getName() != null));
    }

}