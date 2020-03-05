package com.tigerit.TestProjectByTreena.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tigerit.TestProjectByTreena.DTO.LoginDTO;
import com.tigerit.TestProjectByTreena.DataProvider.LoginDataProvider;
import com.tigerit.TestProjectByTreena.Utils.DriverManager;
import com.tigerit.TestProjectByTreena.Utils.UrlTextUtils;
import com.tigerit.TestProjectByTreena.Utils.XpathUtils;

public class LoginTest {
	
	//create browser instance here
	// nullify the browser background value
	private WebDriver driver = null;
	
	//verify the landing page/first page
	@Test (priority=1)
	public void checkLoginPageTitle()
	{
		driver = DriverManager.driver; //driver manager driver
		driver.get(UrlTextUtils.URL.BASE_URL);
		
		//use assert instead of verifyif fail, wont go to next page
		Assert.assertEquals(driver.getTitle(), UrlTextUtils.TEXT.LOGIN_PAGE_TITLE);
		System.out.println("LOGIN PAGE TITLE VERIFIED");
	}
	
	//login test next
	@Test (priority=2, dataProvider="loginData",dataProviderClass=LoginDataProvider.class)
	public void logintest(List<LoginDTO> logindata) {
		for(LoginDTO login : logindata){
			driver.findElement(By.xpath(XpathUtils.Login.USER_NAME)).sendKeys(login.getUsername());
			driver.findElement(By.xpath(XpathUtils.Login.PASSWORD)).sendKeys(login.getPassword());
			driver.findElement(By.xpath(XpathUtils.Login.SIGN_IN_BTN)).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("LOGIN SUCCESSFUL");
	
		}
	}

}
