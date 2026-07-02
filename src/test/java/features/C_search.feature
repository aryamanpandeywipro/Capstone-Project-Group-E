Feature: Search functionality on BStackDemo


Background:
Given User is on BStackDemo HomePage
When User clicks on "Sign In" link
Then User is redirected to Sign In Page
When User selects "demouser" username from dropdown
And User selects "testingisfun99" password from dropdown
And User clicks on "LOG IN" button
 
Scenario: Verify search fails for any keyword
Given User is on BStackDemo HomePage
When User enters "iphone" in search bar
And User clicks on Search icon
Then Search results should not be displayed
And User should see no matching products message