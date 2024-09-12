package com.tricentis.testes;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.tricentis.core.BaseTest;
import com.tricentis.core.Propriedades.Gender;
import com.tricentis.core.Propriedades.Hobbies;
import com.tricentis.pages.InsurantDataPage;

public class EnterInsurantDataTest extends BaseTest{
	
	EnterVehicleDataTest vehiclePage = new EnterVehicleDataTest();
	InsurantDataPage page = new InsurantDataPage();
	
	@Test
	public void TestSetInsurantData() throws IOException {
		vehiclePage.TestSetVehicleData();
		page.setFirstName("Lorena");
		page.setLastName("Silva");
		page.setDateOfBirth("12/04/1987");
		page.setGender(Gender.Female);
		page.selectCountry("Brazil");
		page.setZipCode("06246032");
		page.selectOccupation("Selfemployed");
		page.selectHobbies(Hobbies.Speeding, Hobbies.Skydiving);
		Assert.assertEquals("0", page.getTextInsurantDatatab());
		page.clickNext();
	}

}
