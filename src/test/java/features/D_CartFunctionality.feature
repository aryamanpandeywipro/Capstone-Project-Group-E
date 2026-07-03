Feature: Cart Functionality

Background:
Given User is on BStackDemo HomePage
When User clicks on "Sign In" link
Then User is redirected to Sign In Page
When User selects "demouser" username from dropdown
And User selects "testingisfun99" password from dropdown
And User clicks on "LOG IN" button

Scenario: Add a single product to cart
When User clicks on "Add to cart" of the product "iPhone 12"
Then Shopping cart side panel pops up showing added "iPhone 12" product only

Scenario: Remove a product from the cart
Given User has added "iPhone 12" to the cart 
When User clicks on X icon next to the "iPhone 12"
Then The cart should show "Add some products to bag"
And Continue Shopping button is visible 

Scenario: Add multiple products to cart
When User clicks on "Add to cart" of the product "iPhone 12"
And User clicks on the "Add to cart" of the products "Galaxy S10" and "One Plus 8T"
Then Shopping cart side panel pops up showing all the added products

