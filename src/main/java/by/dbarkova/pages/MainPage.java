package by.dbarkova.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
	
	private final String BASE_URL = "https://e.mail.ru/messages/inbox/";
	
	@FindBy(id = "PH_user-email")
	private WebElement userAccountName;
	
	@FindBy(xpath = "//*[@id=\'b-toolbar__left\']/div/div/div[2]/div/a/span")
	private WebElement buttonNewMessage;
	
	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public String getUserAccountName()
	{
		System.out.println("Authorization has been performed");
		return userAccountName.getText();	
	}
	
	public void startNewMessage() {
		buttonNewMessage.click();
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
	}

}
