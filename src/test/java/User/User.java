package User;

import API.EndPoints;
import API.request;
import Base.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class User extends Base {

    //API 11: POST To Create/Register User Account
    @Test(priority = 1)
    public void PostToCreateRegisterUserAccount(){

        Response response = request.sendPost(EndPoints.CREATE_ACCOUNT,data);

        Integer actualResponseCode = response.jsonPath().getInt("responseCode");
        String actualResponseMessage = response.jsonPath().getString("message");

        Integer expectedResponseCode = 201;
        String expectedResponseMessage = "User created!";

        Assert.assertEquals(actualResponseCode,expectedResponseCode);
        Assert.assertEquals(actualResponseMessage,expectedResponseMessage);

    }

    //API 13: PUT METHOD To Update User Account
    @Test(priority = 2)
    public void PutMethodToUpdateUserAccount(){

        data.put("mobile_number","912345679");


        Response response = request.sendPut(EndPoints.UPDATE_ACCOUNT,data);

        Integer actualResponseCode = response.jsonPath().getInt("responseCode");
        String actualResponseMessage = response.jsonPath().getString("message");

        Integer expectedResponseCode = 200;
        String expectedResponseMessage = "User updated!";

        Assert.assertEquals(actualResponseCode,expectedResponseCode);
        Assert.assertEquals(actualResponseMessage,expectedResponseMessage);
    }

    //API 14: GET user account detail by email
    @Test(priority = 3)
    public void GetUserAccountDetailByEmail(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("email", data.get("email"));


        Response response = request.sendGetWithQuery(EndPoints.GET_USER_DETAIL_BY_EMAIL,map);

        Integer actualResponseCode = response.jsonPath().getInt("responseCode");
        Map<String, Object> user = response.jsonPath().getMap("user");

        Integer expectedResondeCode = 200;


        Assert.assertEquals(actualResponseCode,expectedResondeCode);
        Assert.assertNotNull(user);

    }




    }


