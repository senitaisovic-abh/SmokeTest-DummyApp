package Utilities;


import io.restassured.response.Response;
import org.testng.Assert;

public class Util {
    //ID
    final Integer expectedId = 1;
    final Integer newUserId = 11;
    final Integer newPostId = 101;
    final Integer newCommentId = 501;
    //Response codes
    final int successfulRequest = 200;
    final int successfullyCreated = 201;
    //Information for creating a new user, new post and comment.
    String name = "Senita";
    String email = "something.random@hotmail.com";
    String website = "www.hello.com";
    String body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
    String title = "Lorem ipsum";

    public Util() {
    }

    public String badResponse(String element) {
        return "Bad response, problem with " + element;
    }

    public void checkStatusCodeOk(Response response) {
        Assert.assertEquals(response.getStatusCode(), successfulRequest, badResponse("status code"));
    }

    public void checkStatusCodeCreated(Response response) {
        Assert.assertEquals(response.getStatusCode(), successfullyCreated, badResponse("status code"));
    }


}
