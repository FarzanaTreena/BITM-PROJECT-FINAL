package com.tigerit.TestProjectByTreena.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tigerit.TestProjectByTreena.DTO.FlightFinderDTO;
import com.tigerit.TestProjectByTreena.DataProvider.FlightFinderDataProvider;
import com.tigerit.TestProjectByTreena.Utils.DriverManager;
import com.tigerit.TestProjectByTreena.Utils.UrlTextUtils;
import com.tigerit.TestProjectByTreena.Utils.XpathUtils;

public class FlightFinderTest {
	
	private WebDriver driver = null;
	
	@Test (priority = 1)
	public void checkTitle() {
		driver = DriverManager.driver;
				
		//explicitely wait 40miliseconds
		WebDriverWait wait = new WebDriverWait(driver, 40);
		@SuppressWarnings("unused")
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XpathUtils.FlightFinder.OneWay_BTN)));
		Assert.assertEquals(driver.getTitle(), UrlTextUtils.TEXT.FlightFinder_PAGE_TITLE);
		System.out.println("Flight Finder Page Title Verified.");
	}
	
	@Test (priority = 2, dataProvider="flightFinderData",dataProviderClass=FlightFinderDataProvider.class)
	public void FlightFindingTest(List<FlightFinderDTO> flightfinderdata) {
		for(FlightFinderDTO flightfinder : flightfinderdata) {
		driver.findElement(By.xpath(XpathUtils.FlightFinder.OneWay_BTN)).click();
		driver.findElement(By.xpath(XpathUtils.FlightFinder.DROPDOWN_PASSENGERS)).sendKeys(flightfinder.getPassenger());
		driver.findElement(By.xpath(XpathUtils.FlightFinder.Departing)).sendKeys(flightfinder.getDepart());
		driver.findElement(By.xpath(XpathUtils.FlightFinder.Continue)).click();
		}
	}

}
