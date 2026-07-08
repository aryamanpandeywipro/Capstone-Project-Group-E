Feature: Sorting the Products

Background:
Given User is on BStackDemo HomePage
When User clicks on "Sign In" link
Then User is redirected to Sign In Page
When User selects "demouser" username from dropdown
And User selects "testingisfun99" password from dropdown
And User clicks on "LOG IN" button

Scenario: Sorting Products
When User clicks on the sort filter
And User selects the "<Filter>" from the dropdown
Then Products are sorted in "<Result>" order

Examples: 
|Filter|Result|
|Select|Default|
|Lowest to highest|Ascending|
|Highest to lowest|Descending|