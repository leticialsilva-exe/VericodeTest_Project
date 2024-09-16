package com.tricentis.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import com.tricentis.core.BasePage;
import com.tricentis.core.DriverFactory;
import com.tricentis.core.Propriedades.RightHandDriverEnum;

public class VehicleDataPage extends BasePage {
	
	//Locators
	private By cmbMake = By.id("make");
	private By cmbModel = By.id("model");
	private By txtCylinderCpcty = By.id("cylindercapacity");
	private By txtEnginePerform = By.id("engineperformance");
	private By dtManufacture = By.id("dateofmanufacture");
	private By cmbNumSeats = By.id("numberofseats");
	private By rdRightHandYes = By.xpath("//*[@id='righthanddriveyes']/../span");
	private By rdRightHandNo = By.xpath("//*[@id='righthanddriveno']/../span");
	private By cmbNumSeatsMoto = By.id("numberofseatsmotorcycle");
	private By cmbFuelType = By.id("fuel");
	private By txtPayload = By.id("payload");
	private By txtTotalWeight = By.id("totalweight");
	private By txtListPrice = By.id("listprice");
	private By txtLicensePlateNum = By.id("licenseplatenumber");
	private By txtAnnualMileage = By.id("annualmileage");
	private By btnNext = By.id("nextenterinsurantdata");
	
	private By stringIndiceTab = By.xpath("//*[@id='entervehicledata']/span");
	
	//variables
	private LocalDate today =  LocalDate.now();
	private LocalDate tomorrow = LocalDate.now().plusDays(1);
		
	//Page actions
	public void accessVehicleDataPage() {
		DriverFactory.getDriver().get("http://sampleapp.tricentis.com/101/app.php");
		
	}

	public void selectMake (String option) {
		selectComboOption(cmbMake, option);
	}
	
	public void selectModel(String model) {
		selectComboOption(cmbModel, model);
		
	}
	
	public void setCylinderCapacity(String capacity) {
		write(txtCylinderCpcty, capacity);
		
	}
	
	public void setEnginePerformance (String performanceKW) {
		write(txtEnginePerform, performanceKW);
	}
	
	 
	/**@param date MM/DD/YYYY*/
	public void setDateOfManufacture (String date) {
		write(dtManufacture, date);
	}
	
	public void setDataManufactureToday() {
		setDateOfManufacture(today.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
	}
	
	public void setDataManufactureTomorrow() {
		setDateOfManufacture(tomorrow.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
	}

	
	public void selectNumberOfSeats (String number) {
		selectComboOption(cmbNumSeats, number);
	}
	
	public void selectRightHandDriver(RightHandDriverEnum rightHand) {
		switch (rightHand) {
			case YES: click(rdRightHandYes); break;
			case NO: click(rdRightHandNo); break;
		}
	}
	
	public void selectNumberOfSeatsMoto(String option) {
		selectComboOption(cmbNumSeatsMoto, option);
		
	}
	
	public void selectFuelType (String type) {
		selectComboOption(cmbFuelType, type);
	}
	
	public void setPayload(String number) {
		write(txtPayload, number);
		
	}
	
	public void setTotalWeight(String number) {
		write(txtTotalWeight, number);
		
	}
	
	public void setListPrice (String price) {
		write(txtListPrice, price);
	}

	public void setLicensePlateNumber (String number) {
		write(txtLicensePlateNum, number);
	}

	public void setAnnualMileage (String mileage) {
		write(txtAnnualMileage, mileage);
	}

	public void clickNext () {
		click(btnNext);
	}

	public String getTextIndiceTab() {
		return getText(stringIndiceTab);
	}

	public String getMsgErrorFutureDateOfManfacture() {
		return getTextError("dateofmanufacture");
		
	}

	public String getMsgErrorCylinderCapacity() {
		return getTextError("cylindercapacity");
	}
}
