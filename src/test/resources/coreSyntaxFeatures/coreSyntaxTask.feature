Feature: Login, add items to basket and perform save for later and add to basket.

Scenario Outline: User should click observe the items being saved for later and added again to basket.
Given Load Test Data from "<Test_ID>"
When use navigates to Deutschland Amazon URL
And user enters valid username and password details
Then user should search for the required item
Then user should add the first seen product to basket
When user searched for the same product
Then user should add the second seen product to basket
And user navigates to shopping cart
Then user clicks on Save for later and again clicks on add to shopping cart

Examples:
			|Test_ID|
			|TC_01|