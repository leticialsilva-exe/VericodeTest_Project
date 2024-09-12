package com.tricentis.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.tricentis.core.BasePage;
import com.tricentis.core.Propriedades.Gender;
import com.tricentis.core.Propriedades.Hobbies;

public class InsurantDataPage extends BasePage{
	
	//Locators
	private By txtFirstName = By.id("firstname");
	private By txtLastName = By.id("lastname");
	private By dtOfBirth = By.id("birthdate");
	private By rdGenderMale = By.xpath("//*[@id='gendermale']/../span");
	private By rdGenderFemale = By.xpath("//*[@id='genderfemale']/../span");
	private By cmbCountry = By.id("country");
	private By txtZipCode = By.id("zipcode");
	private By cmbOccupation = By.id("occupation");
	private By rdHobbieSpeeding = By.xpath("//*[@id='speeding']/../span");
	private By rdHobbieSkydiving = By.xpath("//*[@id='skydiving']/../span");
	private By btnNext = By.id("nextenterproductdata");
	
	private By stringIndiceTab = By.xpath("//*[@id='enterinsurantdata']/span");
	
	
	//Page Actions		
	public void setFirstName(String name) {
		write(txtFirstName, name);
		
	}


	public void setLastName(String name) {
		write(txtLastName, name);
		
	}


	public void setDateOfBirth(String date) throws IOException {
		write(dtOfBirth, date);
		
	}


	public void setGender(Gender gender) {
		switch (gender) {
			case Male: click(rdGenderMale);	break;
			case Female: click(rdGenderFemale);	break;
		}
	}


	public void selectCountry(String country) {
		selectComboOption(cmbCountry, country);
	}


	public void setZipCode(String zipcode) {
		write(txtZipCode, zipcode);
	}


	public void selectOccupation(String string) {
		selectComboOption(cmbOccupation, string);
		
	}


	public void selectHobbies(Hobbies...hobbies) {
		for (Hobbies hobbie : hobbies) {
			switch (hobbie) {
			case Speeding: click(rdHobbieSpeeding); break;
			case BungeeJumping: break;
			case CliffDiving: break;
			case Skydiving: click(rdHobbieSkydiving); break;
			case Other : break;
			}
		}
		
	}


	public void clickNext() throws IOException {
		click(btnNext);
		
	}


	public String getTextInsurantDatatab() {
		return getText(stringIndiceTab);
	}
	
	

}
