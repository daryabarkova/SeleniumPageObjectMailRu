package by.dbarkova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewMessagePage extends AbstractPage {
	
	private final String BASE_URL = "https://e.mail.ru/compose/";
	
	@FindBy(xpath = "//*[contains(@id,'composeForm')]/div[1]/div/div[3]/div[1]/div/div/div[2]/div/div/div/textarea[2]")
	private WebElement messageRecipient;
	
	@FindBy(xpath = "//*[contains(@id,'composeForm')]/div[1]/div/div[3]/div[4]/div/div/div[2]/div/input")
	private WebElement messageTopic;
	
	@FindBy(xpath = "//*[contains(@id,'composeEditor_ifr')]")
	private WebElement messageBody;
	
	@FindBy(xpath = "//*[@id=\'b-toolbar__right\']/div/div/div[2]/div[1]/div/span")
	private WebElement buttonSend;
	
	public NewMessagePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		System.out.println("New Message page is opened");
	}
	
	public void inputRecipient(String recipientName) {
		messageRecipient.sendKeys(recipientName);
		System.out.println("Message recepient has been input");
	}
	
	public void inputTopic(String topic) {
		messageTopic.sendKeys(topic);
		System.out.println("Message topic has been input");
	}
	
	public void inputMessageText(String messageText) {
		driver.switchTo().frame(messageBody);
		WebElement eMessageBody = driver.findElement(By.id("tinymce"));
		eMessageBody.sendKeys(messageText);
		driver.switchTo().defaultContent();
		System.out.println("Message text has been input");
	}
	
	public void sendMessage() {
		buttonSend.click();
		System.out.println("Message has been sent");
	}

}
