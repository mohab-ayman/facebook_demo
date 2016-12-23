package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import pageObjects.landingPage;
import testData.xmlDataLoader;
import pageObjects.homePage;
import pageObjects.loginErrorPage;

public class LoginTest {
	
  // Webdriver is a part of Selenium library
  public WebDriver _driver;
  
  // Annotations for methods @BeforeClass, @AfterClass, @BeforeTest, @AfterTest & @Test are part of TestNG library
  @BeforeSuite
  public void testSuiteSetup() {
	  
  }
  
  @BeforeMethod
  public void testSetup() {
	  _driver = new FirefoxDriver();
	  _driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  _driver.get("https://www.facebook.com");
	  System.out.println("Finished Test Setup ..");
  }
  
  // This test uses a data provider, which runs several test runs based on the test data in the XML file
  
  @Test(dataProvider="validLoginCredentials")
  public void LoginWithValidCredentials(String user_name, String password, String profile_name) {
	  
	  System.out.println("Entering Test Method ..");
	  // This is done using the page object model
	  landingPage landing_page = new landingPage(_driver);
	  homePage home_page = landing_page.Login(user_name, password);
	  
	  // Assertion is part of TestNG
	  Assert.assertEquals(home_page.profileUserName.getText(), profile_name);
  }

  @Test(dataProvider="invalidLoginCredentials")
  public void LoginWithInvalidCredentials(String user_name, String password, String profile_name) {
	  
	  System.out.println("Entering Test Method with username: " + user_name + " and password: " + password);
	  // This is done using the page object model
	  landingPage landing_page = new landingPage(_driver);
	  loginErrorPage LEP = landing_page.InvalidLogin(user_name, password);
	  
	  // Assertion is part of TestNG
	  Assert.assertTrue(LEP.recoverAccountButton.isDisplayed());
  }
  
  @AfterMethod
  public void testTeardown() {
	  System.out.println("Entering Test Teardown ..");
	  _driver.close();
  }
  
  @AfterSuite
  public void testSuiteTeardown() {
  }

  // DataProvider is a TestNG annotation that marks a method that returns test data to a test method
  
  @DataProvider
  public Object[][] validLoginCredentials(){
	  xmlDataLoader data_loader = new xmlDataLoader();
	  return data_loader.getValidLoginData();
  }
  
  @DataProvider
  public Object[][] invalidLoginCredentials(){
	  xmlDataLoader data_loader = new xmlDataLoader();
	  return data_loader.getInvalidLoginData();
  }
}
