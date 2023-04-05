package api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ComparePokemonPropertiesTest {

    @Test
    @DisplayName("CPC-1, compare pokemon weight")
    public void comparePokemonWeight() {

        String URL = "https://pokeapi.co/api/v2/";
        pojo.main.ResponseData rattata = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL+"pokemon/rattata")
                .then()
                .extract().as(pojo.main.ResponseData.class);

        pojo.main.ResponseData pidgeotto = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL+"pokemon/pidgeotto")
                .then()
                .extract().as(pojo.main.ResponseData.class);

        Assertions.assertTrue(rattata.getWeight() < pidgeotto.getWeight());
    }

}
