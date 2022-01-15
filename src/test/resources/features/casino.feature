Feature: CasinoGames
  @casino
    Scenario: User attempt to load all games through search functionality
    Given the user is logged in
    And the user navigates to Casino page
    When the user view search dialogue
    And the user uses wild card to load all games
    And the users scrolls and saves all game names
    Then the user is confirms all the games accessed have loaded
    And the user exits with logout
