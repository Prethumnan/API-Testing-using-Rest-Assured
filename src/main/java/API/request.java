package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class request {

    public static final String baseUrl = "https://automationexercise.com";

    public static Response sendGet(String endpoint) {
        return RestAssured
                .given()
                .baseUri(baseUrl)
                .when()
                .get("/api/"+endpoint)
                .then()
                .extract().response();
    }


    public static Response sendGetWithQuery(String endpoint, Map<String, Object> queryParams) {
        return RestAssured.given()
                .baseUri(baseUrl)
                .queryParams(queryParams)
                .when()
                .get("/api/"+endpoint)
                .then()
                .extract().response();
    }





    public static Response sendPost(String endpoint, Map<String, Object> formParams) {
        return RestAssured
                .given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParams(formParams)
                .when()
                .post("/api/"+endpoint)
                .then()
                .extract().response();
    }

    public static Response sendPostWithoutQuery(String endpoint) {
        return RestAssured
                .given()
                .baseUri(baseUrl)
                .when()
                .post("/api/"+endpoint)
                .then()
                .extract().response();
    }



    public static Response sendPut(String endpoint, Map<String, Object> formParams) {
        return RestAssured
                .given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParams(formParams)
                .when()
                .put("/api/"+endpoint)
                .then()
                .extract().response();
    }

    public static Response sendPutWithoutQuery(String endpoint) {
        return RestAssured
                .given()
                .baseUri(baseUrl)
                .when()
                .put("/api/"+endpoint)
                .then()
                .extract().response();
    }



    public static Response sendDelete(String endpoint) {
        return RestAssured
                .given()
                .baseUri(baseUrl)
                .when()
                .delete("/api/"+endpoint)
                .then()
                .extract().response();
    }
    public static Response sendDeleteWithQuery(String endpoint,Map<String, Object> formParams) {
        return RestAssured
                .given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParams(formParams)
                .when()
                .delete("/api/"+endpoint)
                .then()
                .extract().response();
    }


}

