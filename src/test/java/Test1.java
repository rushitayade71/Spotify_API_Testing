import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.given;


public class Test1 {
 String Auth = "Bearer BQDTjx-t6exqrRDI_zFynHqrQmAP0Tp1l4LJxcHcX1P1B-n90zKfkgaVMHMkcsynXBq8CU0hM-j0rYvR2-XEEKffQY3bnhHVvVXE22j-SL2Idq_2Q5lPoREfyELzAZY7xvaxazkMePF0lPXm8V6r0_6IggAocfjNKLChJfdw-rEnU_V2Uv9_LJ296RorpHT5WIvP3r5MXzOZYDiSBmHyP5Iw6hino1NiClvO4KMz2j-xj8X51Rp0V2qY05aZPkhBTatzH9kw_a4VeWAfyfL9SzDpi63o7CWk6P0Bcn_i";

 @Test
    public void TestGETShowPlaylist() {
     String URL = "https://api.spotify.com/v1/me/playlists";

     int statusCode = given()
             .header("Content-Type", "application/json")
             .header("Authorization", Auth)
             .when()
             .get(URL).statusCode();
      System.out.println("The Response Code is :- " +statusCode);
      given()
             .header("Authorization", Auth)
             .when().get(URL).then().assertThat().statusCode(200);
 }
 @Test
 public void getTestShowPlaylist(){
    String URL = "https://api.spotify.com/v1/playlists/5inDVtXMiJuxshYC57MEtW";

    RequestSpecification requestSpecification = RestAssured.given();  //interface ref variable -requestSpecification
    requestSpecification.header("Authorization", Auth);
    Response response = requestSpecification.get(URL);
    System.out.println("Response Code is :- " +response.getStatusCode());
    System.out.println("Response Time Is :- " +response.getTimeIn(TimeUnit.MILLISECONDS) +" MILLISECONDS");
    Assert.assertEquals(response.getStatusCode(), 200);
 }

 @Test
 public void postTestCreatePlaylist() {
  String URL = "https://api.spotify.com/v1/users/x86m5jkdemvdas03tybw4v54m/playlists";

  RequestSpecification requestSpecification = RestAssured.given();
  requestSpecification.body("{\"name\":\"Arjit New\",\"description\":\"All New Songs\",\"public\":false}");
  requestSpecification.header("Authorization", Auth);
  Response response = requestSpecification.post(URL);
  System.out.println("Response Code is :- " +response.getStatusCode());
  System.out.println("Response Time is :- " +response.getTimeIn(TimeUnit.MILLISECONDS) +"MILLISECONDS");
  Assert.assertEquals(response.getStatusCode(),201);
 }

 @Test
    public void postTestAddTrack() {
     String URL = "https://api.spotify.com/v1/playlists/2MOxuWFL9bRgXjIu7fvW60/tracks?uris=spotify:track:7L5f7f89fGs2LaFHGwFoCj";

     RequestSpecification requestSpecification = RestAssured.given();
     requestSpecification.queryParam("uris", "spotify:track:7L5f7f89fGs2LaFHGwFoCj");
     requestSpecification.header("Authorization", Auth);
     Response response = requestSpecification.post(URL);
     System.out.println("Response Code is :- " +response.getStatusCode());
     System.out.println("Response Time is :- " +response.getTimeIn(TimeUnit.MILLISECONDS) +"MILLISECONDS");
     Assert.assertEquals(response.getStatusCode(),201);
 }

 @Test
    public void deleteTestDeleteTrackFromPlaylist() {
     String URL ="https://api.spotify.com/v1/playlists/2MOxuWFL9bRgXjIu7fvW60/tracks";


     RequestSpecification requestSpecification = RestAssured.given();
//     requestSpecification.body("{\"tracks\":[{\"uri\":\"spotify:track:7L5f7f89fGs2LaFHGwFoCj\",\"positions\":[2]}]}");
     requestSpecification.header("Content-Type", "application/json");
     requestSpecification.header("Authorization", Auth);
     JSONObject json = new JSONObject();
     json.put("tracks", Arrays.asList(new HashMap<String, Object>() {
           {
             put("uri", "spotify:track:7L5f7f89fGs2LaFHGwFoCj");
             put("positions", Arrays.asList(2));
           }
     }));
     System.out.println(json);
     requestSpecification.body(json.toJSONString());
     Response response = requestSpecification.delete(URL);
     System.out.println("Response Code is :- " +response.getStatusCode());
     System.out.println("Response Time is :- " +response.getTimeIn(TimeUnit.MILLISECONDS) +"MILLISECONDS");
     Assert.assertEquals(response.getStatusCode(),200);
 }

 @Test
 public void putTestUpdatePlaylistName() {
  String URL = "https://api.spotify.com/v1/playlists/2MOxuWFL9bRgXjIu7fvW60";

  RequestSpecification requestSpecification = RestAssured.given();
  requestSpecification.header("Authorization", Auth);
  requestSpecification.header("Content-Type", "application/json");
//  requestSpecification.body("{\"name\":\"Songs Collecton\",\"description\":\"New Songs\",\"public\":false}");
  JSONObject jsonObject = new JSONObject();
  jsonObject.put("name", "Songs");
  jsonObject.put("description", "New Songs");
  requestSpecification.body(jsonObject.toJSONString());
  Response response = requestSpecification.put(URL);
  System.out.println("Response Code is :- " +response.getStatusCode());
  System.out.println("Response Time is :- " +response.getTimeIn(TimeUnit.MILLISECONDS) +"MILLISECONDS");
  Assert.assertEquals(response.getStatusCode(), 200);
 }
}
