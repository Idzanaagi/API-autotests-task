package helpers;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
public class RequestWrapperHelper {
    public static ValidatableResponseOptions<ValidatableResponse, Response> setRequest(RequestSpecification spec, String url) {
        return given()
                .when()
                .spec(spec)
                .get(url)
                .then();
    }
}