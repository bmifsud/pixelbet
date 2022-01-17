Feature: Login
  @UI @login
  Scenario Outline: User attempt login with <Username> & <Password>, will the user be <Granted> access?
    Given a web browser is at the home page
    When the user view login dialogue
    And the user fills the <Username> and <Password> fields
    And the user press login
    Then depends on the credentials the user is or is not <Granted> access
    And the user exits with logout
    Examples:
      | Username                  | Password          | Granted |
      #Valid
      | BernardMifsud@gmail.com   | bV3etsZ5FG!QU5Z   | true    |
      #Invalid
      | BernardMifsud@gmail.com   | WrongPassword     | false   |
      | WrongUsenrame@gmail.com   | bV3etsZ5FG!QU5Z   | false   |
      #Test Validator (Test Expected to fail)
      #| BernardWrong@gmail.com    | bV3etsZ5FG!QU5Z   | true    |


  @API @login
  Scenario Outline: API User attempt login with <Username> & <Password>, will the response <StatusCode> and <ResultBody> be as expected?
    Given API User Login using <Username> and <Password> login
    Then API User should receive response with <StatusCode> and <ResultBody>
    Examples:
      | Username                  | Password          | StatusCode | ResultBody  |
      #Valid
      | BernardMifsud@gmail.com   | bV3etsZ5FG!QU5Z   | 200        |Success      |