Feature: Navbar Links Verification

Background:
Given User is on BStackDemo HomePage
When User clicks on "Sign In" link
Then User is redirected to Sign In Page
When User selects "demouser" username from dropdown
And User selects "testingisfun99" password from dropdown
And User clicks on "LOG IN" button

@NavbarLinks
Scenario: Verify Navbar Links
Then User should see navbar logo
And User should see Offers link
And User should see Orders link
And User should see Favourites link

@Search
Scenario: Verify search fails for any keyword
Given User is on BStackDemo HomePage
When User enters "iphone" in search bar
And User clicks on Search icon
Then Search results should not be displayed
And User should see no matching products message

@Favourites
Scenario: Adding and Unadding products to favourites
When User Clicks the heart icon on the "iphone 12" product 
And User clicks on the heart icon of the "Galaxy s10" and "One Plus 8T" products
When User clicks on the "Favourites" tab in the NavBar 
Then User is redirected to the Favourites page and can see the products added
When User clicks on the heart icon again of the "iphone 12" 
Then "iphone12" product gets removed from the favourites list

@AddToCartFromFavourites
Scenario: Adding to cart from favourites
When User clicks on "Add to cart" of the product "iPhone 12"
Then Shopping cart side panel pops up showing added "iPhone 12" product only

@SingleVendorFilter
Scenario: Filter Products By a single Vendor
When User clicks on "Apple" filter checkbox
Then Products with only "Apple" vendor should be displayed

@ClearFilter
Scenario: Clear Applied Filters
Given User has filtered products by vendor "Apple"
When User unchecks the "Apple" filter checkbox
Then All the products should be displayed again

@multipleVendorFilter
Scenario Outline: Filter Products By Multiple Vendors
When User clicks on "<Vendor_a>" filter 
And User clicks on "<Vendor_b>" filter
Then Products from only "<Vendor_a>" or "<Vendor_b>" should be displayed

Examples:
|Vendor_a|Vendor_b|
|Apple|Google|
|OnePlus|Samsung|

@SortProduct
Scenario: Sorting Products
When User clicks on the sort filter
And User selects the "<Filter>" from the dropdown
Then Products are sorted in "<Result>" order

Examples: 
|Filter|Result|
|Select|Default|
|Lowest to highest|Ascending|
|Highest to lowest|Descending|

@AddSingleProductToCart
Scenario: Add a single product to cart
When User clicks on "Add to cart" of the product "iPhone 12"
Then Shopping cart side panel pops up showing added "iPhone 12" product only

@RemoveProductFromCart
Scenario: Remove a product from the cart
Given User has added "iPhone 12" to the cart 
When User clicks on X icon next to the "iPhone 12"
Then The cart should show "Add some products to bag"
And Continue Shopping button is visible 

@Checkout
Scenario: Add multiple products to cart and Checking Out
When User clicks on "Add to cart" of the product "iPhone 12"
And User clicks on the "Add to cart" of the product "Galaxy S10"
Then Shopping cart side panel pops up showing all the added products
When User clicks on "Checkout" button in the cart panel
Then User is redirected to Checkout page
When User fills all the details and clicks on "SUBMIT" button
Then User is redirected to order confirmation page
And User clicks on Download order reciept link
And User clicks on "CONTINUE SHOPPING" button and is redirected to Home Page
When User clicks on "Orders" in NavBar 
Then User can see the order placed

@Logout
Scenario: Log Out 
When User clicks on Log Out
Then User is Logged Out