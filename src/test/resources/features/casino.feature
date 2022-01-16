Feature: CasinoGames
  @casino
    Scenario Outline: User attempt to search a game through search functionality by <GameName>
    Given the user is logged in
    And the user navigates to Casino page
    When the user view search dialogue
    And the user searches for <GameName>
    And the user opens the game
    Then the user is confirms the game has loaded
    And the user exits game
    And the user exits with logout
    Examples:
      | GameName                  |
      #Valid
#      | Fat Rabbit                |
#      | Cash Truck                |
#      | Book of Dead              |
#      | Congo Cash                |
      | Temple Tumble             |
      | 10001 Nights              |
      | Tombstone R.I.P           |
      | Legion X                  |
      | Wild Depths               |
      #Test Validator (Test Expected to fail)
      #| InvalidName              |
