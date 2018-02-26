package by.dbarkova.steps;

import by.dbarkova.driver.DriverSingleton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.dbarkova.pages.LoginPage;
import by.dbarkova.pages.MainPage;
import by.dbarkova.pages.NewMessagePage;
import by.dbarkova.pages.SentMessagesPage;

public class Steps {
	private WebDriver driver;

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void loginMailRu(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

	public boolean isLoggedIn(String username) throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		// Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PH_user-email")));

		String actualUserName = mainPage.getUserAccountName();
		System.out.println(actualUserName);

		return username.equalsIgnoreCase(actualUserName);
	}

	public void sendNewMessage(String recipientName, String topic, String messageText) throws InterruptedException {
		NewMessagePage newMessagePage = new NewMessagePage(driver);
		Thread.sleep(5000);
		newMessagePage.openPage();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'composeForm')]/div[1]/div/div[3]/div[4]/div/div/div[2]/div/input")));
		
		newMessagePage.inputTopic(topic);
		newMessagePage.inputRecipient(recipientName);
		newMessagePage.inputMessageText(messageText);
		newMessagePage.sendMessage();
	}

	public String checkLastRecipient() {
		SentMessagesPage sentMessagesPage = new SentMessagesPage(driver);
		sentMessagesPage.openPage();
		return sentMessagesPage.getLastRecipient();
	}
	
	public String checkLastText() {
		SentMessagesPage sentMessagesPage = new SentMessagesPage(driver);
		sentMessagesPage.openPage();
		return sentMessagesPage.getLastText();
	}
	
}
