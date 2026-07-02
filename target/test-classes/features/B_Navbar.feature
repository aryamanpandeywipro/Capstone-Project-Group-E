Feature: Navbar Links Verification

Background:
Given User is on BStackDemo HomePage
When User clicks on "Sign In" link
Then User is redirected to Sign In Page
When User selects "demouser" username from dropdown
And User selects "testingisfun99" password from dropdown
And User clicks on "LOG IN" button

Scenario: Verify Navbar Links
Then User should see navbar logo
And User should see Offers link
And User should see Orders link
And User should see Favourites link