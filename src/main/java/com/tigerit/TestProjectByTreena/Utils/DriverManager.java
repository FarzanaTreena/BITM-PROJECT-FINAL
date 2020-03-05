package com.tigerit.TestProjectByTreena.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
// import org.testng.annotations.Test; 

//this class initializes the driver in browser
//test web application by initializing the web browser
public class DriverManager {

	static {
		System.setProperty("webdriver.gecko.driver", "E:\\MyWorkspace\\SELENIUM_LATEST\\geckodriver.exe");
	}

	public static WebDriver driver = new FirefoxDriver();
	
	/*
	@Test
	public void DriverExecutionTest() {
		System.out.println("Driver Executed.");
	} */
	
	private DriverManager() {

	}

}
