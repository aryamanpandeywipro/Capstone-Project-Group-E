Feature: Search functionality on BStackDemo
 
Scenario: Verify search fails for any keyword
  Given User is on BStackDemo HomePage
  When User enters "iphone" in search bar
  And User clicks on Search icon
  Then Search results should not be displayed
  And User should see no matching products message