Feature: Adding products to Favourotes

Background:
Given User is on BStackDemo HomePage
When User clicks on "Sign In" link
Then User is redirected to Sign In Page
When User selects "demouser" username from dropdown
And User selects "testingisfun99" password from dropdown
And User clicks on "LOG IN" button

Scenario: Adding and Unadding products to favourites
When User Clicks the heart icon on the "iphone 12" product 
And User clicks on the heart icon of the "Galaxy s10" and "One Plus 8T" products
When User clicks on the "Favourites" tab in the NavBar 
Then User is redirected to the Favourites page and can see the products added
When User clicks on the heart icon again of the "iphone 12" 
Then "iphone12" product gets removed from the favourites list

Scenario: Adding to cart from favourites
When User clicks on "Add to cart" of the product "iPhone 12"
Then Shopping cart side panel pops up showing added "iPhone 12" product only
