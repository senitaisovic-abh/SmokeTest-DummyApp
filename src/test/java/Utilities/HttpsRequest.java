package Utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class HttpsRequest{
    String baseUrl = "https://jsonplaceholder.typicode.com";
    Util util = new Util();

    NewUserInfo userInfo = new NewUserInfo(util.newUserId, util.name, util.email, util.website);
    NewPostInfo postInfo = new NewPostInfo(util.body, util.title);
    NewCommentInfo commentInfo = new NewCommentInfo(util.name, util.body, util.email);


    public Response getRequest(String endpoint) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri(baseUrl)
                .get(endpoint);
        return response;
    }

    public Response PostRequestCreateUser(String endpoint) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(userInfo.userInfo().toJSONString())
                .baseUri(baseUrl)
                .post(endpoint);
        return response;
    }

    public Response PostRequestCreatePost(String endpoint) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(postInfo.postInfo().toJSONString())
                .baseUri(baseUrl)
                .post(endpoint);
        return response;
    }

    public Response PostRequestCreateComment(String endpoint) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(commentInfo.commentInfo().toJSONString())
                .baseUri(baseUrl)
                .post(endpoint);
        return response;
    }

    public Response PutRequestUpdatePost(String endpoint) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(postInfo.postInfo().toJSONString())
                .baseUri(baseUrl)
                .put(endpoint);
        return response;
    }

    public Response DeleteRequestDeletePost(String endpoint) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri(baseUrl)
                .put(endpoint);
        return response;
    }

}
