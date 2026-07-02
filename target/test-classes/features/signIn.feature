Feature: BrowserStackDemo Automation Testing

Background: Given User is on BStackDemo HomePage

Scenario Outline: Navigating to SignIn Page and Signing In
When User clicks on "Sign In" link
Then User is redirected to Sign In Page
When User selects "<username>" username from dropdown
And User selects "<password>" password from dropdown
And User clicks on "LOG IN" button
Then User SignIn Status is "<signInStatus>"

Examples:
|username|password|signInStatus|
|demouser|testingisfun99|SignedIn|
|locked_user|testingisfun99|Locked|


