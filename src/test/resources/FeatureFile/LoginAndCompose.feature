@SendMail
Feature: Feature is to
  1. To login in Upskill site
  2. Verify if used logged in correctly
  3. Compose and send mail

  Background: 
    Given Upskill home page should be open

  @Login
  Scenario Outline: Login to upskill
    When I enter Username as "<username>"
    And I enter Password as "<password>"
    And I click on Login Button
    And I wait for 2 seconds
    And I click on user drop down Button
    And I wait for 2 seconds
    Then I Validate if login was successful by checking "<email>"
    And I close browser

    Examples: Credentials
      | username    | password | email          |
      | kunal.raool | Kunal123 | Kunal@test.com |

  @ComposeEmail
  Scenario Outline: Compose email and send
    Given I logged in to upskill site using "<username>" and "<password>"
    And I validated logged in inormation using "<email>"
    And I wait for 2 seconds
    When I clicked on Compose Button
    And I wait for 2 seconds
    And I enter "<emailId>" address
    And I wait for 2 seconds
    And I enter "<subject>" in subject field
    And I enter "<Message>" in message section
    And I clicked on send message Button
    Then I validate "<SuccessMessage>" send successfully
    And I close browser

    Examples: Credentials and Email
      | username    | password | email          | emailId  | subject        | Message                                                           | SuccessMessage                                      |
      | kunal.raool | Kunal123 | Kunal@test.com | kunraool | Hi For Testing | Hello Mr. Kunal, \n \n \\t This is for testing \n\n From \n Kunal | The message has been sent to Kunal Raool (kunraool) |
