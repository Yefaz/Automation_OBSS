Feature: Trendyol login Page

  Scenario: Login with invalid user
    Given Go To Trendyol Homepage
    When Click The Login Button
    And Enter The invalid E-posta
    And Enter The invalid Password
    And Click Sign-in button
    Then I see warning


