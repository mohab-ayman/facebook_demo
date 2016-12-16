package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import pageObjects.landingPage;
import testData.xmlDataLoader;
import pageObjects.homePage;

public class LoginTest {
	
  // Webdriver is a part of Selenium library
  public WebDriver _driver;
  
  // Annotations for methods @BeforeClass, @AfterClass, @BeforeTest, @AfterTest & @Test are part of TestNG library
  @BeforeSuite
  public void testSuiteSetup() {
	  
  }
  
  @BeforeTest
  public void testSetup() {
	  _driver = new FirefoxDriver();
	  _driver.get("https://www.facebook.com");
  }
  
  // This test uses a data provider, which runs several test runs based on the test data in the XML file
  
  @Test(dataProvider="LoginCredentials")
  public void LoginWithValidCredentials(String user_name, String password, String profile_name) {
	  
	  // This is done using the page object model
	  landingPage landing_page = new landingPage(_driver);
	  homePage home_page = landing_page.Login(user_name, password);
	  
	  // Assertion is part of TestNG
	  Assert.assertEquals(home_page.profileUserName.getText(), profile_name);
  }

  @AfterTest
  public void testTeardown() {
	  _driver.close();
  }
  
  @AfterSuite
  public void testSuiteTeardown() {
  }

  // DataProvider is a TestNG annotation that marks a method that returns test data to a test method
  
  @DataProvider
  public Object[][] LoginCredentials(){
	  xmlDataLoader data_loader = new xmlDataLoader();
	  return data_loader.getLoginData();
  }
}
