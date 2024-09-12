package com.tricentis.core;

import static com.tricentis.core.DriverFactory.getDriver;
import static com.tricentis.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;
import com.tricentis.pages.VehicleDataPage;

public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void Initialize() {
		VehicleDataPage page = new VehicleDataPage();
		page.accessVehicleDataPage();
	}

	
	@After
	public void quitDriver() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File evidencia = ss.getScreenshotAs(OutputType.FILE);
		Files.copy(evidencia, new File("target"+File.separator+"Screenshot/"+testName.getMethodName()+".jpg"));
		
		if(Propriedades.FECHAR_BROWSER) {
			killDriver();				
		}
	}


}
