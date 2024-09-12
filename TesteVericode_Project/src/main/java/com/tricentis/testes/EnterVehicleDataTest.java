package com.tricentis.testes;

import org.junit.Assert;
import org.junit.Test;

import com.tricentis.core.BaseTest;
import com.tricentis.core.Propriedades.RightHandDriverEnum;
import com.tricentis.pages.VehicleDataPage;


public class EnterVehicleDataTest extends BaseTest{
	
	
	VehicleDataPage page = new VehicleDataPage();
	
	@Test
	public void TestSetVehicleData() {
		page.selectMake("Honda");
		page.selectModel("Scooter");
		page.setCylinderCapacity("2000");
		page.setEnginePerformance("1000");
		page.setDataManufactureToday();
		page.selectNumberOfSeats("4");
		page.selectRightHandDriver(RightHandDriverEnum.YES);
		page.selectNumberOfSeatsMoto("2");
		page.selectFuelType("Electric Power");
		page.setPayload("1000");
		page.setTotalWeight("50000");
		page.setListPrice("500");
		page.setLicensePlateNumber("");
		page.setAnnualMileage("99999");
		Assert.assertEquals("0", page.getTextIndiceTab());
		page.clickNext();
		
	}

	@Test
	public void TestFutureDateOfManufacture() {
		page.setDataManufactureTomorrow();
		Assert.assertEquals("Must be today or somewhere in the past", page.getMsgErrorFutureDateOfManfacture());
		Assert.assertEquals("12", page.getTextIndiceTab());		
	}
	
	@Test
	public void TestRulesCylinderCapacity() {
		//mandatory field
		page.setCylinderCapacity("");
		Assert.assertEquals("This field is mandatory", page.getMsgErrorCylinderCapacity());
		// field acceptances
		page.setCylinderCapacity(" ");
		Assert.assertEquals("Must be a number between 1 and 2000", page.getMsgErrorCylinderCapacity());
		
		page.setCylinderCapacity("0");
		Assert.assertEquals("Must be a number between 1 and 2000", page.getMsgErrorCylinderCapacity());

		page.setCylinderCapacity("2001");
		Assert.assertEquals("Must be a number between 1 and 2000", page.getMsgErrorCylinderCapacity());

		Assert.assertEquals("12", page.getTextIndiceTab());
		
	}


}
