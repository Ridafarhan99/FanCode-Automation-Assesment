package testcases.test;

import logic.FanCodeUserChecker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;

public class TestFanCodeUser {
    FanCodeUserChecker userChecker = new FanCodeUserChecker();

    @Test
    public void validateFanCodeUsersCompletionRate() throws ParseException {
        JSONArray users = userChecker.getUsersFromFanCode();
        System.out.println("Total Users in FanCode City:"+users.size());
        //loop through each user from FanCode city
        for(Object userObj:users){
            JSONObject user = (JSONObject) userObj;
            int userID = ((Long) user.get("id")).intValue();
            String userName = (String) user.get("name");

            //calculating the completed task percentage
            double completionPercentage = userChecker.getCompletedPercentage(userID);
            System.out.println(" User Name: " + userName + ", Completion: " + completionPercentage + "%");

            //assert that the user has more than 50% tasks completed
            Assert.assertTrue("User " + userName + " has more than 50% tasks completed.",completionPercentage > 50);
        }
    }
}
