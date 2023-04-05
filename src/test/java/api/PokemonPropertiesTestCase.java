package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;
import static io.restassured.RestAssured.given;

import pojo.main.ResponseData;

public class PokemonPropertiesTestCase {
    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://pokeapi.co/api/v2/")
            .setContentType(ContentType.JSON)
            .build();
    @Test
    @DisplayName("CPC-1, compare pokemon weight")
    public void comparePokemonWeight() {

        ResponseData rattataPokemonData = given()
                .when()
                .spec(requestSpec)
                .get("pokemon/rattata")
                .then()
                .extract().as(ResponseData.class);

        ResponseData pidgeottoPokemonData = given()
                .when()
                .spec(requestSpec)
                .get("pokemon/pidgeotto")
                .then()
                .extract().as(ResponseData.class);

        Assertions.assertTrue(rattataPokemonData.getWeight() < pidgeottoPokemonData.getWeight());
    }

    @Test
    @DisplayName("CPC-2, compare pokemon ability: run-away")
    public void comparePokemonAbility() {
        String expectedAbility = "run-away";

        ResponseData rattataPokemonData = given()
                .when()
                .spec(requestSpec)
                .get("pokemon/rattata")
                .then()
                .extract().as(ResponseData.class);

        ResponseData pidgeottoPokemonData = given()
                .when()
                .spec(requestSpec)
                .get("pokemon/pidgeotto")
                .then()
                .extract().as(ResponseData.class);

        List<String> getRattataAbility = rattataPokemonData.getAbilities().stream().map(x -> x.getAbility().getName()).collect(Collectors.toList()) // получение способностей
                .stream().filter(x-> x.contains(expectedAbility)).collect(Collectors.toList()); // фильтрация

        List<String> getPidgeottoAbility = pidgeottoPokemonData.getAbilities().stream().map(x -> x.getAbility().getName()).collect(Collectors.toList())
                .stream().filter(x-> x.contains(expectedAbility)).collect(Collectors.toList());

        Assertions.assertTrue(getRattataAbility.size() > 0); // проверка, что rattata имеет способность run-away
        Assertions.assertEquals(0, getPidgeottoAbility.size()); // проверка, что pidgeotto не имеет способность run-away
    }

}
