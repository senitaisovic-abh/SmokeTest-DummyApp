package StepDefinitions;

import Utilities.SomeSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ClassStepsDefinition {

    @Steps
    SomeSteps someSteps;

    @Given("create a new user")
    public void create_a_new_user() {
        someSteps.postNewUser();
    }

    @When("user creates a new post")
    public void user_creates_a_new_post() {
        someSteps.postNewPost();
    }

    @Then("user is able to see all posts, comments and album with photos")
    public void user_is_able_to_see_all_posts_comments_and_album_with_photos() {
        someSteps.getAllPosts();
        someSteps.getAPost();
        someSteps.getComment();
        someSteps.getAlbums();
        someSteps.getPhotos();

    }

    @Then("user is able to leave a comment")
    public void user_is_able_to_leave_a_comment() {
        someSteps.postNewComment();
    }

    @Then("user updates their post")
    public void user_updates_their_post() {
        someSteps.updatePost();
    }

    @Then("user delete their post")
    public void user_delete_their_post() {
        someSteps.deletePost();
    }

}
