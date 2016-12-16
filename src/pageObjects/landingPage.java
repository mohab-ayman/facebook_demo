package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.homePage;

public class landingPage 
{
	public WebDriver _driver;
	
	@FindBy(id="email")
	public WebElement userName;
	
	@FindBy(id="pass")
	public WebElement password;
	
	@FindBy(id="u_0_l")
	public WebElement loginButton;

	public landingPage(WebDriver driver)
	{
		_driver = driver;
		PageFactory.initElements(_driver, this);
	}
	
	public homePage Login(String username, String pass)
	{
		userName.sendKeys(username);
		password.sendKeys(pass);
		loginButton.click();
		
		homePage home_page = new homePage(_driver);
		return home_page;
	}
}
