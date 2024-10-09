package logic;

import api.ApiClient;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.stream.Collectors;

public class FanCodeUserChecker {
    ApiClient apiClient = new ApiClient();
    JSONParser jsonParser = new JSONParser();

    //get users from the city FanCode based on lat and long
    public JSONArray getUsersFromFanCode() throws ParseException {
        Response res = apiClient.getUsers();
        JSONArray users = (JSONArray) jsonParser.parse(res.getBody().asString());

    //users based on latitude and longitude criteria
        return (JSONArray) users.stream()
                .filter(user -> isFanCodeCity((JSONObject) user))
                .collect(Collectors.toCollection(JSONArray::new));
    }

    //check if user is from the FanCode city based on lat/lng
    public boolean isFanCodeCity(JSONObject user) {
        JSONObject address = (JSONObject) user.get("address");
        JSONObject geo = (JSONObject) address.get("geo");

        double lat = Double.parseDouble((String) geo.get("lat"));
        double lng = Double.parseDouble((String) geo.get("lng"));

        return lat >= -40 && lat <= 5 && lng >= 5 && lng <= 100;
    }


    //calculate the percentage of completed todos for a user
    public double getCompletedPercentage(int userId) throws ParseException {
        Response res = apiClient.getTodos(userId);
        JSONArray todos = (JSONArray) jsonParser.parse(res.getBody().asString());

        long totalTasks = todos.size();
        long completedTasks = todos.stream()
                .filter(task -> (Boolean) ((JSONObject) task).get("completed"))
                .count();

        return (double) completedTasks / totalTasks * 100;
    }
}
