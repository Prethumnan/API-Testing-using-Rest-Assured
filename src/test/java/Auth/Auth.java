package Auth;

import API.EndPoints;
import API.request;
import Base.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Auth extends Base{

    //API 7: POST To Verify Login with valid details
    @Test
    public void PostToVerifyLoginWithValidDetails(){
        HashMap<String, Object> map = new HashMap<>();

        map.put("email",data.get("email"));
        map.put("password",data.get("password"));

        Response response = request.sendPost(EndPoints.VERIFY_LOGIN,map);

        Integer actualResponseCode = response.jsonPath().getInt("responseCode");
        String actualResponseMessage = response.jsonPath().getString("message");

        Integer expectedResponseCode = 200;
        String expectedResponseMessage = "User exists!";

        Assert.assertEquals(actualResponseCode,expectedResponseCode);
        Assert.assertEquals(actualResponseMessage,expectedResponseMessage);
    }

    //API 8: POST To Verify Login without email parameter
    @Test
    public void PostToVerifyLoginWithoutEmailParameter(){
        HashMap<String, Object> map = new HashMap<>();


        map.put("password",data.get("password"));

        Response response = request.sendPost(EndPoints.VERIFY_LOGIN,map);

        Integer actualResponseCode = response.jsonPath().getInt("responseCode");
        String actualResponseMessage = response.jsonPath().getString("message");

        Integer expectedResponseCode = 400;
        String expectedResponseMessage = "Bad request, email or password parameter is missing in POST request.";

        Assert.assertEquals(actualResponseCode,expectedResponseCode);
        Assert.assertEquals(actualResponseMessage,expectedResponseMessage);
    }

    //API 9: DELETE To Verify Login
    @Test
    public void DeleteToVerifyLogin(){

        Response response = request.sendDelete(EndPoints.VERIFY_LOGIN);

        Integer actualResponseCode = response.jsonPath().getInt("responseCode");
        String actualResponseMessage = response.jsonPath().getString("message");

        Integer expectedResponseCode = 405;
        String expectedResponseMessage = "This request method is not supported.";

        Assert.assertEquals(actualResponseCode,expectedResponseCode);
        Assert.assertEquals(actualResponseMessage,expectedResponseMessage);
    }

    //API 10: POST To Verify Login with invalid details
    @Test
    public void PostToVerifyLoginWithInvalidDetails(){

        HashMap<String, Object> map = new HashMap<>();

        map.put("email",data.get("email"));
        map.put("password",data.get("password")+"12");

        Response response = request.sendPost(EndPoints.VERIFY_LOGIN,map);

        Integer actualResponseCode = response.jsonPath().getInt("responseCode");
        String actualResponseMessage = response.jsonPath().getString("message");

        Integer expectedResponseCode = 404;
        String expectedResponseMessage = "User not found!";

        Assert.assertEquals(actualResponseCode,expectedResponseCode);
        Assert.assertEquals(actualResponseMessage,expectedResponseMessage);

    }

}
