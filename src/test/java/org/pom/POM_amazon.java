package org.pom;

import org.Utilities.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class POM_amazon<WebElements> extends BaseClass{
	
	public POM_amazon() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//input[@type=\"text\"]")
	private WebElement search;

	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement submit;
	
	@FindBy(xpath="class=\"JFPqaw\"")
	private WebElement close;
	
	@FindBy(xpath="//div[@class=\"_4rR01T\"]")
	private WebElements mobiles;
	
	public WebElement getSubmit() {
		return submit;
	}
	public WebElement getSearch() {
		return search;
	}
	public WebElement getClose() {
		return close;
	}
	public WebElements getMobiles() {
		return  mobiles;
	}
}