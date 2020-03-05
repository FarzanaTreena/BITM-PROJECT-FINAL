package com.tigerit.TestProjectByTreena.DataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.tigerit.TestProjectByTreena.Utils.ExcelUtils;


public class LoginDataProvider {

	//value will pass as login data
	@DataProvider(name="loginData")
	//gets login data object
	public static Object [][] getLoginData(){
		try {
			return new Object[][]{
					{
						ExcelUtils.getLoginData()
					},
				};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	        
    }
}