package api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.limitItems.ResponseData;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;

public class CheckListTestCase {
    private final String URL = "https://pokeapi.co/api/v2/ability/";
    private final Integer limitItemsCount = 5;

    @Test
    @DisplayName("CLR-1, check the list restriction with the query parameter limit")
    public void checkTheListRestriction() {

        ResponseData limit = given()
                .param("limit", limitItemsCount)
                .when()
                .contentType(ContentType.JSON)
                .get(URL)
                .then()
                .extract().as((Type) ResponseData.class);

        Assertions.assertEquals((int) limitItemsCount, limit.getResults().size());
    }

    @Test
    @DisplayName("CLR-2, check if each pokemon has a name on the restricted list")
    public void checkPokemonHasName () {

        ResponseData limit = given()
                .param("limit", limitItemsCount)
                .when()
                .contentType(ContentType.JSON)
                .get(URL)
                .then()
                .extract().as((Type) ResponseData.class);

        Assertions.assertTrue(limit.getResults().stream().allMatch(x-> x.getName() != null));
    }

}