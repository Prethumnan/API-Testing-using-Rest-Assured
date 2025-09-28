package User;

import API.EndPoints;
import API.request;
import Base.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class SuiteCleanup extends Base {

    //API 12: DELETE METHOD To Delete User Account
    @Test
    public void deleteUserAccount() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("email", data.get("email"));
        map.put("password", data.get("password"));

        Response response = request.sendDeleteWithQuery(EndPoints.DELETE_ACCOUNT, map);

        Integer actualResponseCode = response.jsonPath().getInt("responseCode");
        String actualResponseMessage = response.jsonPath().getString("message");

        Assert.assertEquals(actualResponseCode, 200, "Delete user failed!");
        Assert.assertEquals(actualResponseMessage, "Account deleted!");

    }
}

