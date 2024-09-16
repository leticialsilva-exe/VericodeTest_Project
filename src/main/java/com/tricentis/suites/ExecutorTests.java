package com.tricentis.suites;

import static com.tricentis.core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.tricentis.testes.EnterInsurantDataTest;
import com.tricentis.testes.EnterVehicleDataTest;


@RunWith(Suite.class)
@SuiteClasses({
	EnterVehicleDataTest.class,
	EnterInsurantDataTest.class,
})


public class ExecutorTests {
	@AfterClass
	public static void KillDrivers() {
		 killDriver();
	}


}
