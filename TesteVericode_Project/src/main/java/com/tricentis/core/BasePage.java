package com.tricentis.core;

import static com.tricentis.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	/************ write and get Text **************/
	
	public void write(By by, String text) {
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(text);
	}
	
	public void write(String idElement, String text) {
		write(By.id(idElement), text);
	}

	public String getValueElement(By by) {
		return getDriver().findElement(by).getAttribute("value");
	}
	
	public String getValueElement(String idElement) {
		return getValueElement(By.id(idElement));
	}
	
	
	public String getText(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String getText(String idElement) {
		return getText(By.id(idElement));
	}
	
	public String getTextError(String idElement) {
		return getText(By.xpath("//*[@id='"+idElement+"']/../span"));
	}

	
	/************ Click **************/
	public void click (By by) {
		getDriver().findElement(by).click();
	}
	
	public void click (String idElement) {
		click(By.id(idElement));
	}
		
	/************ Radio and CheckBox **************/
	public boolean checkIfIsSelected(String idElement) {
		return getDriver().findElement(By.id(idElement)).isSelected();
	}
	
	public void selectComboOption(By by , String valor) {
		Select combo = new Select(getDriver().findElement(by));
		combo.selectByVisibleText(valor);
	}
	
	public void selectComboOption(String idElement , String valor) {
		selectComboOption(By.id(idElement), valor);
	}

	public void selectComboOptions(String idElement , String... valores) {
		Select combo = new Select(getDriver().findElement(By.id(idElement)));
		for (String string : valores) {
			combo.selectByVisibleText(string);
		}

	}
	public String getTextSelectedOption(By by) {
		Select combo = new Select(getDriver().findElement(by));
		return combo.getFirstSelectedOption().getText();
	}
	public String getTextSelectedOption(String idElement) {
		return getTextSelectedOption(By.id(idElement));
	}

	public List<WebElement> getAmountSelectedOptions(String idElement) {
		Select combo = new Select(getDriver().findElement(By.id(idElement)));
		return combo.getAllSelectedOptions();
	}
	
	public void deselectComboOption(String idElement, String valueVisible) {
		Select combo = new Select(getDriver().findElement(By.id(idElement)));
		combo.deselectByVisibleText(valueVisible);
	}
	
	/************ Alert **************/

	public String alertObterTextoEAceita() {
		Alert alert = getDriver().switchTo().alert();	
		String text = alert.getText();
		alert.accept();
		return text;
	}
	
	public String alertObterTextoEDismiss() {
		Alert alert = getDriver().switchTo().alert();	
		String text = alert.getText();
		alert.dismiss();
		return text;
	}		

}
