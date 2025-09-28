package Brands;

import API.EndPoints;
import API.request;
import Base.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Brands extends Base {

    //API 3: Get All Brands List
    @Test
    public static void GetAllBrandsList(){

        Response response = request.sendGet(EndPoints.BRANDS_LIST);

        Integer actualResponseCode = response.jsonPath().getInt("responseCode");
        List<Object> products = response.jsonPath().getList("brands");

        Integer expectedResondeCode = 200;
        Boolean expectedJsonLength = true;

        Assert.assertEquals(actualResponseCode,expectedResondeCode,"Reponse code mismatch");
        Assert.assertNotNull(products, "Products list is null in response");
    }

    //API 4: PUT To All Brands List
    @Test
    public void PutToAllBrandsList(){

        Response response = request.sendPutWithoutQuery(EndPoints.BRANDS_LIST);

        Integer actualResponseCode = response.jsonPath().getInt("responseCode");
        String actualResponseMessage = response.jsonPath().getString("message");

        Integer expectedResponseCode = 405;
        String expectedResponseMessage = "This request method is not supported.";

        Assert.assertEquals(actualResponseCode,expectedResponseCode);
        Assert.assertEquals(actualResponseMessage,expectedResponseMessage);
    }
}
