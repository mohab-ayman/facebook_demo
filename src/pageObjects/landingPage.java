package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage 
{
	@FindBy(id="email")
	public WebElement userName;
	
	@FindBy(id="pass")
	public WebElement password;
	
	@FindBy(id="u_0_l")
	public WebElement loginButton;

	public landingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Login(String username, String pass)
	{
		userName.sendKeys(username);
		password.sendKeys(pass);
		loginButton.click();
	}
}
