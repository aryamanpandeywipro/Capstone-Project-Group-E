Feature: BrowserStackDemo Automation Testing

Background: Given User is on BStackDemo HomePage

Scenario: Navigating to SignIn Page
When User clicks on "Sign In" link
Then User is redirected to Sign In Page

Scenario: Signing In with Valid Credentials
When User selects "demouser" username from dropdown
And User selects "testingisfun99" password from dropdown
And User clicks on "LOG IN" button
Then User is Signed In successfully and redirected to HomePage where username is visible in Navbar