package by.dbarkova.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SentMessagesPage extends AbstractPage{
	
	private final String BASE_URL = "https://e.mail.ru/messages/sent/";
	
	@FindBy(xpath = "//*[@id=\"b-letters\"]/div/div[2]/div/div[2]/div[1]/div/a/div[4]/div[2]/div[2]")
	private WebElement lastSentMessage;
	
	@FindBy(xpath = "//*[@id='b-letters']/div/div[2]/div/div[2]/div[1]/div/a/div[4]/div[2]/div[1]/div")
	private WebElement lastSentText;
	
	public SentMessagesPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		System.out.println("Login page opened");
	}
	
	public String getLastRecipient() {
		return lastSentMessage.getText();
	}
	
	public String getLastText() {
		return lastSentText.getText();
	}

}


