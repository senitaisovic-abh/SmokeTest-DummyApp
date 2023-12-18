@smoke
Feature: Smoke test- Dummy app

  This application is a free dummy API, which represent an example of a social network app. This test verify that created user can
  make a new post, also can see comments, albums, photos... It also checks that created user can update and delete posts. Also user
  is able to create new account.


  Scenario: Verify social network functionality.
    Given create a new user
    When user creates a new post
    Then user is able to see all posts, comments and album with photos
    And user is able to leave a comment
    And user updates their post
    And user delete their post