package com.coreSyntax.stepdefs;

import com.coreSyntax.coreSyntax.coreSyntaxPages;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class coreSyntaxStepDef {
	coreSyntaxPages coreSyntaxOb = new coreSyntaxPages();
	@Given("Load Test Data from {string}")
	public void load_Test_Data_from(String testCaseID) {
		coreSyntaxOb.getSheetData(testCaseID);
	}

	@When("use navigates to Deutschland Amazon URL")
	public void use_navigates_to_Deutschland_Amazon_URL() {
		coreSyntaxOb.launchAmazonWebsite(); 
	}

	@When("user enters valid username and password details")
	public void user_enters_valid_username_and_password_details() {
		coreSyntaxOb.enterEmailandPassword(); 
	}

	@Then("user should search for the required item")
	public void user_should_search_for_the_required_item() {
		coreSyntaxOb.searchItem();
	}

	@Then("user should add the first seen product to basket")
	public void user_should_add_the_first_seen_product_to_basket() {
		coreSyntaxOb.firstProduct();
	}

	@When("user searched for the same product")
	public void user_searched_for_the_same_product() {
		coreSyntaxOb.searchItem();
	}

	@Then("user should add the second seen product to basket")
	public void user_should_add_the_second_seen_product_to_basket() {
		coreSyntaxOb.secondProduct();
	}

	@Then("user navigates to shopping cart")
	public void user_navigates_to_shopping_cart() {
		coreSyntaxOb.openCart();
	}

	@Then("user clicks on Save for later and again clicks on add to shopping cart")
	public void user_clicks_on_Save_for_later_and_again_clicks_on_add_to_shopping_cart() {
		coreSyntaxOb.saveForLaterAndAdd();
		coreSyntaxOb.closeBrowser();
	}

}
