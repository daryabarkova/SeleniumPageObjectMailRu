package by.dbarkova.tests;

import org.testng.annotations.Test;

import by.dbarkova.steps.Steps;
import by.dbarkova.utils.Utils;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SendNewMessageTest {
	
	private Steps steps;
	private final String USERNAME = "bdw89";
	private final String PASSWORD = "2705223";
	private final String RECIPIENT_NAME = "a_shimanovich@inbox.ru";
	private final String TOPIC = new Utils().getRandomString(10);
	private final String MESSAGE_TEXT = new Utils().getRandomString(100);
	
	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
		steps.loginMailRu(USERNAME, PASSWORD);
	}
	
  @Test
  public void sendNewMessagePositive() throws InterruptedException {
	  steps.sendNewMessage(RECIPIENT_NAME, TOPIC, MESSAGE_TEXT);
	  Assert.assertEquals(steps.checkLastRecipient(), RECIPIENT_NAME);
	  Assert.assertEquals(steps.checkLastText(), TOPIC+MESSAGE_TEXT); 
	  
	  System.out.println("The message was sent successfully!!!");
  }
  
  @AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}
