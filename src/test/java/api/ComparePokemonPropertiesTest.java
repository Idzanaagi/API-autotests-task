package api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ComparePokemonPropertiesTest {

    @Test
    @DisplayName("CPC-1, compare pokemon weight")
    public void comparePokemonWeight() {
        String URL = "https://pokeapi.co/api/v2/";

        pojo.main.ResponseData rattataData = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL+"pokemon/rattata")
                .then()
                .extract().as(pojo.main.ResponseData.class);

        pojo.main.ResponseData pidgeottoData = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL+"pokemon/pidgeotto")
                .then()
                .extract().as(pojo.main.ResponseData.class);

        Assertions.assertTrue(rattataData.getWeight() < pidgeottoData.getWeight());
    }

    @Test
    @DisplayName("CPC-2, compare pokemon ability: run-away")
    void comparePokemonAbility() {
        String URL = "https://pokeapi.co/api/v2/";
        String expectedAbility = "run-away";

        pojo.main.ResponseData rattataData = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL+"pokemon/rattata")
                .then()
                .extract().as(pojo.main.ResponseData.class);

        pojo.main.ResponseData pidgeottoData = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL+"pokemon/pidgeotto")
                .then()
                .extract().as(pojo.main.ResponseData.class);

        List<String> getRattataAbility = rattataData.getAbilities().stream().map(x -> x.getAbility().getName()).collect(Collectors.toList()) // получение способностей
                .stream().filter(x-> x.contains(expectedAbility)).collect(Collectors.toList()); // фильтрация

        List<String> getPidgeottoAbility = pidgeottoData.getAbilities().stream().map(x -> x.getAbility().getName()).collect(Collectors.toList())
                .stream().filter(x-> x.contains(expectedAbility)).collect(Collectors.toList());

        Assertions.assertTrue(getRattataAbility.size() > 0); // проверка, что rattata имеет способность run-away
        Assertions.assertEquals(0, getPidgeottoAbility.size()); // проверка, что pidgeotto не имеет способность run-away
    }

}
