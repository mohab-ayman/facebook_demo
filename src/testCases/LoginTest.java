package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import pageObjects.landingPage;

public class LoginTest {
	
  // Webdriver is a part of Selenium library
  public WebDriver _driver;
  
  // Annotations for methods @BeforeClass, @AfterClass, @BeforeTest, @AfterTest & @Test are part of TestNG library
  @BeforeSuite
  public void beforeClass() {
	  _driver = new FirefoxDriver();
  }
  
  @Test
  public void LoginWithValidCredentials() {
	  landingPage landing_page = new landingPage(_driver);
	  landing_page.Login("test1", "test1");
	  
  }
  
  @AfterSuite
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  _driver.get("https://www.facebook.com");
  }

  @AfterTest
  public void afterTest() {
	  _driver.close();
  }

}
