package Products;

import API.EndPoints;
import API.request;
import Base.Base;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;


public class Products extends Base{

    //API 1: Get All Products List
    @Test
    public static void GetAllProductsList(){

        Response response = request.sendGet(EndPoints.PRODUCTS_LIST);

        Integer actualResponseCode = response.jsonPath().getInt("responseCode");
        List<Object> products = response.jsonPath().getList("products");

        Integer expectedResondeCode = 200;
        Boolean expectedJsonLength = true;

        Assert.assertEquals(actualResponseCode,expectedResondeCode);
        Assert.assertNotNull(products);


    }

    //API 2: POST To All Products List
    @Test
    public static void PostToAllProductsList(){

        Response response = request.sendPostWithoutQuery(EndPoints.PRODUCTS_LIST);
        Integer actualResponseCode = response.jsonPath().getInt("responseCode");
        String actualResponseMessage = response.jsonPath().getString("message");

        Integer expectedResponseCode = 405;
        String expectedResponseMessage = "This request method is not supported.";

        Assert.assertEquals(actualResponseCode,expectedResponseCode);
        Assert.assertEquals(actualResponseMessage,expectedResponseMessage);

    }

    //API 5: POST To Search Product
    @Test
    public void PostToSearchProduct(){

        HashMap<String, Object> map = new HashMap<>();

        map.put("search_product","jean");

        Response response = request.sendPost(EndPoints.SEARCH_PRODUCT,map);

        Integer actualResponseCode = response.jsonPath().getInt("responseCode");
        List<Object> products = response.jsonPath().getList("products");

        Integer expectedResondeCode = 200;
        Boolean expectedJsonLength = true;

        Assert.assertEquals(actualResponseCode,expectedResondeCode);
        Assert.assertNotNull(products);
    }

    //API 6: POST To Search Product without search_product parameter
    @Test
    public void PostToSearchProductWithoutSearch_productParameter(){

        HashMap<String, Object> map = new HashMap<>();

        map.put(" ","jean");

        Response response = request.sendPost(EndPoints.SEARCH_PRODUCT,map);

        Integer actualResponseCode = response.jsonPath().getInt("responseCode");
        String actualResponseMessage = response.jsonPath().getString("message");

        Integer expectedResponseCode = 400;
        String expectedResponseMessage = "Bad request, search_product parameter is missing in POST request.";

        Assert.assertEquals(actualResponseCode,expectedResponseCode);
        Assert.assertEquals(actualResponseMessage,expectedResponseMessage);

    }
}
