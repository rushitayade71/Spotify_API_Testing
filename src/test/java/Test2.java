

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class Test2 {
//    @Test
//    public void deletemethod() {
//        String URL = "https://api.spotify.com/v1/playlists/2MOxuWFL9bRgXjIu7fvW60/tracks";
//        String Auth = "Bearer BQDzMHJqu1e2KwZOOdknMyPTNR-NXlWQjCr2iaFXk1HqLh2apK4KgrPOwLHygrcVCk0B0-yKawAHjfyyF8gI5Dj5kMvjJjjkqsABfbjsiWJIZvlspXHLT669xOKa2mmpt-MOylDktOzk7aB9E1rZEhNvFAoiaW9XwBFD1ReraBkkkaPH-H0kFqYPt8t0uRAUMS8hXskmeNWrlzGVOSJe8dGqk9HkK01xitxdBtL-cmpqwuknf-wa8CFWKFbB358m0y5Osx5L54dsoU1AgdmvXSEYthfu0RVuIpvMMzHk";
//        RequestSpecification requestSpecification = given();
////     requestSpecification.body("{\"tracks\":[{\"uri\":\"spotify:track:7L5f7f89fGs2LaFHGwFoCj\",\"positions\":[2]}]}");
//        requestSpecification.header("Content-Type", "application/json");
//        requestSpecification.header("Authorization", Auth);
//        Map<String,Object> map = new HashMap<>();
//        map.put("uri","spotify:track:7L5f7f89fGs2LaFHGwFoCj");
//        map.put("positions","[2]");
//        System.out.println(map);
//
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("tracks",map);
////        System.out.println(jsonObject);
////        System.out.println(jsonObject.toString());
//        requestSpecification.body(jsonObject.toJSONString());
//        Response response = requestSpecification.delete(URL);
//        System.out.println("Response Code is :- " +response.getStatusCode());
//        System.out.println("Response Time is :- " +response.getTimeIn(TimeUnit.MILLISECONDS) +"MILLISECONDS");
//        Assert.assertEquals(response.getStatusCode(),200);
//
//
//    }
    @Test
    public void delete1(){
        String URL = "https://api.spotify.com/v1/playlists/2MOxuWFL9bRgXjIu7fvW60/tracks";

        RequestSpecification requestSpecification = RestAssured.given();

//        requestSpecification.body("{\"tracks\":[{\"uri\":\"spotify:track:7L5f7f89fGs2LaFHGwFoCj\",\"positions\":[2]}]}");
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.header("Authorization", "Bearer BQBwnCudJeBodkSWE40wcDl84GMcZSph4kH-pPDFn7ZuGjd_dIPxxVbCxAuT_epCXmDWpmwysXiJmS5oFkAPWqBjwyw7e7AyNgabTOUJj-bzgKU2_hsfx9OW3_K5T5kXUafqLsc9cK4cP9vb5MZBdvc4XYuVq4gREuM_lsdFSHEVQejlf1YDAJAypMKw0L2Zw5YkT3xtesl7jB1Eefw5WCzxdgsTOX40zyavgeAjf8vfTerkXOIo52e5VFhKikc6rZ2jplte6HsxqRCwtBMwb2PQmD6q_QgDlmjLTi_5");

//        Map<String,String> map = new HashMap<>();
//        map.put("uri","spotify:track:7L5f7f89fGs2LaFHGwFoCj");
//        map.put("positions","[2]");
//        System.out.println(map);
//        Map<String, String> body = new HashMap<String, String>();
//        body.put("uri","spotify:track:7L5f7f89fGs2LaFHGwFoCj");
//        body.put("positions", "[2]");
//
//        JSONObject list = new JSONObject();
//        list.put("uri","spotify:track:7L5f7f89fGs2LaFHGwFoCj");
//        list.put("positions","[2]");
//        System.out.println(list);
//
////
        JSONObject json = new JSONObject();
        json.put("tracks", Arrays.asList(new HashMap<String, Object>() {
                                             {
                                                 put("uri", "spotify:track:7L5f7f89fGs2LaFHGwFoCj");
                                                 put("positions", Arrays.asList(2));
                                             }
                                         }));
        System.out.println(json);
//
//        json.put("tracks", body);
//        System.out.println(json);
//
        requestSpecification.body(json.toJSONString());
        Response response = requestSpecification.delete(URL);
        System.out.println("Response Code is :- " +response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test
    public void delete() {
        String URL = "https://api.spotify.com/v1/playlists/2MOxuWFL9bRgXjIu7fvW60/tracks";
        String Auth = "Bearer BQCH3YC7yRMJM_Bdyi5i6bCyVOft5eYXnbS6bBxCCjLImQv6kZ1JaXclE5k9_ByLbYo9vH3vK-MvMylaOe-JvTY8khQYaB1u7HhSPxV1PSllWb5fcNDCBz4LCjuOmFrxerioEfpfby1sHRSw8gvfAiPQTbryFR5uW1dPg60bp3kquMDx7Yw9ou024gbLgtythw0K-Avq1O55cTM3FHOfuoSz9JQLcDOmNUtvgfMBkgWlKvIz-_htyMbpdkBMvwzce-3nxGxHi9KTT92WYqZNpHGp3uEUnCpKGZRJwOFG";
        RequestSpecification requestSpecification = RestAssured.given();
//     requestSpecification.body("{\"tracks\":[{\"uri\":\"spotify:track:7L5f7f89fGs2LaFHGwFoCj\",\"positions\":[2]}]}");
        requestSpecification.header("Content-Type", "application/json");
        requestSpecification.header("Authorization", Auth);
//  JSONObject jsonObject = new JSONObject();
//  jsonObject.put("tracks", "[{\"uri\":\"spotify:track:7L5f7f89fGs2LaFHGwFoCj\",\"positions\":[2]}");
//  requestSpecification.body(jsonObject.toJSONString());
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("uri","spotify:track:7L5f7f89fGs2LaFHGwFoCj");
        map.put("positions","[2]");
        System.out.println(map);

        JSONObject request = new JSONObject();
        request.put("tracks",map);
        Response response = requestSpecification.delete(URL);
        System.out.println("Response Code is :- " +response.getStatusCode());
        System.out.println("Response Time is :- " +response.getTimeIn(TimeUnit.MILLISECONDS) +"MILLISECONDS");
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
