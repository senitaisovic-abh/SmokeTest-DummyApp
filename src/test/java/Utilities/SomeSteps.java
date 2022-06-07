package Utilities;

import io.cucumber.java.BeforeStep;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.testng.Assert;


public class SomeSteps {
    Util util = new Util();

    @Steps
    HttpsRequest httpsRequest;

    @Step("Get all posts")
    public void getAllPosts() {
        Response response = httpsRequest.getRequest("/posts");
        //Check status code
        util.checkStatusCodeOk(response);
    }

    @Step("Get post with Id 1")
    public void getAPost() {
        Response response = httpsRequest.getRequest("/posts/1");

        util.checkStatusCodeOk(response);
        Assert.assertEquals(response.jsonPath().get("id"), util.expectedId, util.badResponse("post id"));
        Assert.assertEquals(response.jsonPath().get("userId"), util.expectedId, util.badResponse("user id"));

    }

    @Step("Get first comment in post with Id 1")
    public void getComment() {
        Response response = httpsRequest.getRequest("posts/1/comments");

        util.checkStatusCodeOk(response);
        Assert.assertEquals(response.jsonPath().get("[0].'postId'"), util.expectedId, util.badResponse("post id"));
        Assert.assertEquals(response.jsonPath().get("[0].'id'"), util.expectedId, util.badResponse("comment id"));

    }

    @Step("Get albums")
    public void getAlbums() {
        Response response = httpsRequest.getRequest("/albums");

        util.checkStatusCodeOk(response);
    }

    @Step("Get photos in album with Id 1")
    public void getPhotos() {
        Response response = httpsRequest.getRequest("/albums/1/photos");

        util.checkStatusCodeOk(response);
        Assert.assertEquals(response.jsonPath().get("[0].'albumId'"), util.expectedId, util.badResponse("album id"));
    }

    @Step("Create a new user")
    public void postNewUser() {
        Response response = httpsRequest.PostRequestCreateUser("/users");

        util.checkStatusCodeCreated(response);
        Assert.assertEquals(response.jsonPath().get("id"), util.newUserId, util.badResponse("userId"));
        Assert.assertEquals(response.jsonPath().get("name"), util.name, util.badResponse("name"));
        Assert.assertEquals(response.jsonPath().get("email"), util.email, util.badResponse("email"));
    }

    @Step("Create a new post")
    public void postNewPost() {
        Response response = httpsRequest.PostRequestCreatePost("/posts");

        util.checkStatusCodeCreated(response);
        Assert.assertEquals(response.jsonPath().get("id"), util.newPostId, util.badResponse("id"));
        Assert.assertEquals(response.jsonPath().get("title"), util.title, util.badResponse("title"));
        Assert.assertEquals(response.jsonPath().get("body"), util.body, util.badResponse("body"));
    }

    @Step("Create a new comment on post with postId 1")
    public void postNewComment() {
        Response response = httpsRequest.PostRequestCreateComment("/posts/1/comments");

        util.checkStatusCodeCreated(response);
        Assert.assertEquals(response.jsonPath().get("id"), util.newCommentId, util.badResponse("id"));
        Assert.assertEquals(response.jsonPath().get("name"), util.name, util.badResponse("name"));
        Assert.assertEquals(response.jsonPath().get("body"), util.body, util.badResponse("body"));
    }

    @Step("Update title and body elements on post with id 1")
    public void updatePost() {
        Response response = httpsRequest.PutRequestUpdatePost("/posts/1");

        util.checkStatusCodeOk(response);

        Assert.assertEquals(response.jsonPath().get("title"), util.title, util.badResponse("title"));
        Assert.assertEquals(response.jsonPath().get("body"), util.body, util.badResponse("body"));
    }

    @Step("Update title and body elements on post with id 1")
    public void deletePost() {
        Response response = httpsRequest.DeleteRequestDeletePost("/posts/1");

        util.checkStatusCodeOk(response);
        Assert.assertNull(response.jsonPath().get("postId"), "Post is not deleted");
    }
}
