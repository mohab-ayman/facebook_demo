package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	
	@FindBy(className="fbxWelcomeBoxName")
	public WebElement profileUserName;
	
	public homePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

}
