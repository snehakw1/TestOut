package baseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Constants.PageConstants;

public class projectMethods {
	
		public void clickOnSettings(WebDriver driver) {
			WebElement settings = driver.findElement(By.xpath(PageConstants.SETTINGS_ICON));			
		    settings.click();
		    	
		}
		
		public void clickOnMailCalendarContacts(WebDriver driver) {
			WebElement mailCalendars=driver.findElement(By.id(PageConstants.CALENDARS));
	    	mailCalendars.click();
		}
		
		public void clickAccounts(WebDriver driver) throws InterruptedException {
			Thread.sleep(3000);
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
			WebElement accountMBrown = driver.findElement(By.id(PageConstants.ACCOUNT_MBROWN));
	    	js1.executeScript("arguments[0].scrollIntoView(true);", accountMBrown);
			accountMBrown.click();
		}
		
		public void clickMaggieBrownsAccount(WebDriver driver) throws InterruptedException {
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
			Thread.sleep(3000);
			WebElement maggieBrownGmail=
				    driver.findElement(By.id(PageConstants.MAGGIE_BROWN_GMAIL));
					js1.executeScript("arguments[0].scrollIntoView(true);", maggieBrownGmail);
					maggieBrownGmail.click();
		}
		
		public void clickOnAdvanced(WebDriver driver) {
			WebElement advanced=driver.findElement(By.id(PageConstants.ADVANCED));
			advanced.click();
		}
		
		public void clickAndEnableSSL(WebDriver driver) {
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
			WebElement ssl=driver.findElement(
				By.xpath(PageConstants.SSL));
			js1.executeScript("arguments[0].scrollIntoView(true);", ssl);
			Actions ac=new Actions(driver);
			ac.dragAndDropBy(ssl,19,0).perform();
		}
		
		public void verifyPortNo(WebDriver driver) {
			WebElement verify=driver.findElement(By.xpath(PageConstants.VERIFY));
			verify.click();
			String strPort=verify.getAttribute("value");
			Assert.assertTrue(strPort.equals("993"));
		}
		
		public void clickBackButton(WebDriver driver) {
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
			js1.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");		
			
			WebElement backButtonForAccounts=driver.findElement(By.id(PageConstants.BACK_BUTTON_FOR_ACCOUNTS));
			//Click on back button
			js1.executeScript("arguments[0].scrollIntoView(true);", backButtonForAccounts);
			backButtonForAccounts.click();
			js1.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");		
			
		}
		
		public void doneButton(WebDriver driver) throws InterruptedException 
		{
			Thread.sleep(3000);
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
			WebElement done=driver.findElement(By.id(PageConstants.DONEID));
			js1.executeScript("arguments[0].scrollIntoView(true);", done);
			done.click();
		}
		
		public void clickWIFI(WebDriver driver) {
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
			js1.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
			
			WebElement wifi = driver.findElement(By.id(PageConstants.WIFI));
			js1.executeScript("arguments[0].scrollIntoView(true);", wifi);
			
			
			wifi.click(); 
			js1.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 3000);");
			
		}
		
		public void clickCORP(WebDriver driver) throws InterruptedException {
			WebElement corp = driver.findElement(By.id(PageConstants.CORP));
			corp.click();
			Thread.sleep(2000);
		}
		
		public void clickAndVerifyFormClosed(WebDriver driver) throws InterruptedException {
			WebElement r=driver.findElement(By.id(PageConstants.DONE));
       		
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
			js1.executeScript("arguments[0].scrollIntoView(true);", r);
			r.click();
			Thread.sleep(2000);
			driver.findElement(By.id(PageConstants.DONE_BUTTON)).click();
			//driver.findElement(By.id("btDone.Grid.MouseOverElement")).click();
			
			
			 WebDriverWait wait=new WebDriverWait(driver,100);
			  
			 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath
					 (PageConstants.TABLET)));
			 js1.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");		
				
		}
}
