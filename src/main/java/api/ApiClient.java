package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiClient {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com";

    //get all users
    public Response getUsers() {
        return RestAssured.get(BASE_URL + "/users");
    }

    //get todos for a specific user based on userId
    public Response getTodos(int userId){
        return RestAssured.given()
                .queryParam("userId", userId)
                .get(BASE_URL + "/todos");
    }
}
