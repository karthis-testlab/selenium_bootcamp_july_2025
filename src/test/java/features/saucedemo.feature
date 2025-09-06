Feature: Sauce Demo is site used to cart sauce lab merchandise product 

Scenario: User able to the checkout the product which added into the cart
Given User want to purchase the sauce lab merchandise product on the offical cart site
And Regitered user able to login with valid user credentials "standard_user" and "secret_sauce"
When User want to purchase "Test.allTheThings() T-Shirt (Red)" product and add to the cart
And User confirm the added product and checkout the product to purchase with details
Then And User confirm the added product and checkout the product to purchase with details