package projectTests;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Test;

import Constants.PageConstants;
import baseClass.projectMethods;


public class SetUpAnAccount {
	WebDriver driver;
	@BeforeSuite
	public void setUp() {
		
		//Open the URL
		System.setProperty("webdriver.chrome.driver","D:\\MS\\Spring-Semester 2 2019\\JavaTutorial\\libs\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://testoutlivecontent.blob.core.windows.net/netpro2018v5-en-us/en-us/sims/typescriptv1/netpro2018v5/simstartup_webpack.html?package=netpro2018v5windowspackage&sim=ipademail_np5&dev=true&automation=true");
		
		//Wait until the simulated form opens
		WebDriverWait wait=new WebDriverWait(driver,100);  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
					 ("//*[@id='gTablet.Image']")));
		
		//Maximize the window
		driver.manage().window().maximize();
	}
	@Test
	public void setUpAccount() throws InterruptedException {
		// Scroll Down
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement settings = driver.findElement(By.id(PageConstants.SETTINGS));
		js.executeScript("arguments[0].scrollIntoView(true);", settings);
		//Adding wait
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");		
		
		//Click on settings
		projectMethods p=new projectMethods();
		p.clickOnSettings(driver);
	    
		Thread.sleep(3000);
	    //Click on Mail, calendars and contacts
    	p.clickOnMailCalendarContacts(driver);
    	
    	//Click on accounts
    	p.clickAccounts(driver);
		
		//Adding wait
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");		
		
		//Clicking on Maggie Bown account
		p.clickMaggieBrownsAccount(driver);
		
		
		//Click on Advanced option
		p.clickOnAdvanced(driver);
		
		//Enable SSL
		Thread.sleep(3000);
		p.clickAndEnableSSL(driver);
		
		//Verify if port is 993
		p.verifyPortNo(driver);
		
		//Back button
		p.clickBackButton(driver);
		
		
		//Click on done button
		p.doneButton(driver);
		
	}
	
	@Test
	public void testWIFI2() throws InterruptedException
	{
		//Enable this code if they are two different test cases
		
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement settings = driver.findElement(By.id("wpDesktop.DesktopIcon15.Grid.gContent.imImage"));
		js.executeScript("arguments[0].scrollIntoView(true);", settings);
		 
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

			 settings = driver.findElement(By.xpath("//div[@id='wpDesktop.DesktopIcon15']"));			
			 settings.click();
		 */
		Thread.sleep(3000);
		
		//Click on wifi option and click on corp
		projectMethods p=new projectMethods();
		p.clickWIFI(driver);
		
		p.clickCORP(driver);
		//Click on password and type the password
		
		WebElement pass=driver.findElement(By.id(PageConstants.PASSWORD));
		//js1.executeScript("arguments[0].scrollIntoView(true);", pass);

		
		pass.sendKeys("@CorpNetWeRSecure!&");
		
		//Click on Join button
		driver.findElement(By.id(PageConstants.JOIN)).click();
		Thread.sleep(3000);
		
			
		 //Click on done and verify if the simulation form is closed
		  p.clickAndVerifyFormClosed(driver);
	}
	@AfterSuite
	public void quitWindow() {
		driver.quit();
	}
	
}