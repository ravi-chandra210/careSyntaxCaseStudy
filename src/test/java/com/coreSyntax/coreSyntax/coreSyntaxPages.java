package com.coreSyntax.coreSyntax;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.coreSyntax.coreSyntax.coreSyntaxPages;


public class coreSyntaxPages {
	
	/**
	 * @author : Srinivasa Ravi Chandra Muktavarapu
	 * @category : Trivago case Study
	 * @Task : Automation of given Scenario
	 * @date : 04/06/2021
	 */
	
	protected static RemoteWebDriver driver;

	/************************************************ Static variables to store Excel sheet data **************************************/
	static String testCaseID; 
	static String browser;
	static String url;
	static String username;
	static String password;
	static String search;

	/************************************************** Amazon Page Elements ******************************************************/

	String cookies = "(//span[@class='a-button-text'])[1]";
	String logo = "//a[@id='nav-logo-sprites']";
	String login = "//span[@class='nav-line-2 ']";
	String emailField = "//input[@id = 'ap_email']";
	String emailEnter = "//input[@id = 'continue']";
	String passwordField = "//input[@id = 'ap_password']";
	String passwordEnter = "//input[@id = 'signInSubmit']";
	String searchField = "//input[@id = 'twotabsearchtextbox']";
	String searchIcon = "//span[@class='nav-search-submit-text nav-sprite nav-progressive-attribute']";
	String firstProduct = "(//span[@class='a-size-medium a-color-base a-text-normal'])[2]";
	String secondProduct = "(//span[@class='a-size-medium a-color-base a-text-normal'])[4]";
	String addToBasket = "//input[@id='add-to-cart-button']";
	String noThanksToInsurance = "//input[contains(@class, 'a-button-input') and contains(@aria-labelledby, 'attachSiNoCoverage-announce')]";
	String closeCart = "//a[@id='attach-close_sideSheet-link']";
	String checkOut = "//a[@id='hlb-ptc-btn-native']";
	String mainPage = "//div[@id='nav-logo']";
	String itemBasket = "//div[@id='nav-cart-count-container']";
	String saveForLater = "(//input[@value='Auf die Merkliste'])[1]";
	String addToBasketAgain = "//input[contains(@aria-label,'In den Einkaufswagen') and contains(@class, 'a-button-input')]"; //multiple elements available
	
	/*..... Required class objects .....*/
	static utils utilsOb = new utils();
	org.apache.logging.log4j.Logger log = LogManager.getLogger(coreSyntaxPages.class);
	
	/*..... Browser System properties .....*/
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
	}
	
	/*..... This Method will read test data from provided excel sheet .....*/
	public void getSheetData(String testName){
		try {
			utils.getTestData(testName);
			testCaseID=utils.storeData("Test Case Name");
			System.out.println("Executing testCaseId...." + testCaseID );
			browser = utils.storeData("BROWSER");
			url = utils.storeData("URL");
			username = utils.storeData("USERNAME");
			password = utils.storeData("PASSWORD");
			search = utils.storeData("SEARCH");
		} catch (IOException e) {
			log.error("Error occured while reading the test data from excel sheet");
		}
	}
	
	/*.....This Method will Launch browser and launching trivago weekend URl. 
	 * Browser name and Website URl is passed from Test data excel sheet .....*/
	public WebDriver launchAmazonWebsite(){
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();                      
			}
			utilsOb.waitForElm(1);
			driver.get(url);		
			driver.manage().window().maximize();
			utilsOb.waitForElm(3);
			utilsOb.waitForGivenElem(driver, logo);
		} catch (Exception e) {
			log.error("Error occured while launching the amazon website in desired browser");
		}
		return driver;
	}
	
	/*.....This Method will enter the Email and Password by gathering the data from
	 * Test data excel sheet .....*/
	public void enterEmailandPassword() {
		utilsOb.waitAndClick(driver,1,login);
		utilsOb.sendInput(driver, emailField, username);
		utilsOb.waitAndClick(driver,1,emailEnter);
		utilsOb.sendInput(driver, passwordField, password);
		utilsOb.waitAndClick(driver,1,passwordEnter);
	}
	
	/*.....This Method will search the item by gathering the data from
	 * Test data excel sheet .....*/
	public void searchItem() {
		utilsOb.waitForElm(2);
		utilsOb.sendInput(driver, searchField, search);
		utilsOb.waitAndClick(driver,1,searchIcon);
	}
	
	/*.....This Method will enter the First product to shopping cart 
	 * by gathering the data from Test data excel sheet .....*/
	public void firstProduct() {
		utilsOb.waitAndClick(driver,1,firstProduct);
		utilsOb.waitAndClick(driver,1,addToBasket);
		utilsOb.waitAndClick(driver,1,noThanksToInsurance);		
	}
	
	/*.....This Method will enter the second product to shopping cart 
	 * by gathering the data from Test data excel sheet .....*/
	public void secondProduct() {
		utilsOb.waitAndClick(driver,1,secondProduct);
		utilsOb.waitAndClick(driver,1,addToBasket);
		utilsOb.waitAndClick(driver,1,noThanksToInsurance);
	}
	
	/*.....This Method will open the basket to show the added items....*/
	public void openCart() {
		utilsOb.waitAndClick(driver,1,itemBasket);
	}
	
	/*.....This Method will select save for later and again add the item to basket....*/
	public void saveForLaterAndAdd() {
		utilsOb.waitAndClick(driver,1,saveForLater);
		utilsOb.waitAndClick(driver,1,addToBasketAgain);	
	}
	
	
	/*..... This Method will close all the active session of browser .....*/
	public void closeBrowser() {
		driver.quit();
	}

}
