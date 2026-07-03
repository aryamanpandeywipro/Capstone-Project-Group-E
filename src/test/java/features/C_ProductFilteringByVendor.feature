Feature: Product Filtering By Vendors


Background:
Given User is on BStackDemo HomePage
When User clicks on "Sign In" link
Then User is redirected to Sign In Page
When User selects "demouser" username from dropdown
And User selects "testingisfun99" password from dropdown
And User clicks on "LOG IN" button

Scenario: Filter Products By a single Vendor
When User clicks on "Apple" filter checkbox
Then Products with only "Apple" vendor should be displayed

Scenario: Clear Applied Filters
Given User has filtered products by vendor "Apple"
When User unchecks the "Apple" filter checkbox
Then All the products should be displayed again

Scenario Outline: Filter Products By Multiple Vendors
When User clicks on "<Vendor_a>" filter 
And User clicks on "<Vendor_b>" filter
Then Products from only "<Vendor_a>" or "<Vendor_b>" should be displayed

Examples:
|Vendor_a|Vendor_b|
|Apple|Google|
|OnePlus|Samsung|

