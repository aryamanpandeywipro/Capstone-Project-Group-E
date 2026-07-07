Feature: Checkout Automation

Background:
Given User is on BStackDemo HomePage
When User clicks on "Sign In" link
Then User is redirected to Sign In Page
When User selects "demouser" username from dropdown
And User selects "testingisfun99" password from dropdown
And User clicks on "LOG IN" button
When User clicks on "Add to cart" of the product "iPhone 12"
And User clicks on the "Add to cart" of the products "Galaxy S10" and "One Plus 8T"
Then Shopping cart side panel pops up showing all the added products

Scenario: Checking Out
When User clicks on "Checkout" button in the cart panel
Then User is redirected to Checkout page
When User fills all the details and clicks on "SUBMIT" button
Then User is redirected to order confirmation page
And User clicks on Download order reciept link
And User clicks on "CONTINUE SHOPPING" button and is redirected to Home Page
When User clicks on "Orders" in NavBar 
Then User can see the order placed