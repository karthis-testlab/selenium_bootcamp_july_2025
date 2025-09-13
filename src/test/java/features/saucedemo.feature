Feature: Sauce Demo is site used to cart sauce lab merchandise product 

Background:
Given User want to purchase the sauce lab merchandise product on the offical cart site
And Regitered user able to login with valid user credentials "standard_user" and "secret_sauce"

@smoke
Scenario: User able to the checkout the product which added into the cart
When User want to purchase "Test.allTheThings() T-Shirt (Red)" product and add to the cart
And User confirm the added product and checkout the product to purchase with details
| firstName     | lastName     | postalCode |
| TestFirstName | TestLastName | 626117     |
Then User able to validate and confirm the added product is correct one or not

@smoke @e2e
Scenario Outline: User able to the checkout the multiple products which were added into the cart
When User want to the multiple products "<product_name>" purchase and add to the cart
And User confirm the added product and checkout the product to purchase with details
| firstName     | lastName     | postalCode |
| <first_name>  | <last_name>  | <zip_code> |
Then User able to validate and confirm the added product is correct one or not

Examples:
| product_name          | first_name     | last_name     | zip_code |
| Sauce Labs Backpack   | TestFirstName1 | TestLastName1 | 600001   | 
| Sauce Labs Bike Light | TestFirstName2 | TestLastName2 | 600002   |