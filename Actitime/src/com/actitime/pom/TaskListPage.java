package com.actitime.pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;

public class TaskListPage extends BaseClass {
	@FindBy(xpath = "//div[text()='Add New']")
	private WebElement addNewBtn;
	@FindBy(xpath = "//div[text()='+ New Customer']")
	private WebElement newCustBtn;
	@FindBy(xpath = "//input[@autocomplete='off' and @placeholder='Enter Customer Name']")
    private WebElement custNmaeTxtBox;
	
	public TaskListPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
		}
	public void setAddNewBtn() {
		addNewBtn.click();
	}
	public void setNewCustBtn() {
		newCustBtn.click();
	}
	public void setCustNameTxtBox() throws EncryptedDocumentException, IOException, InterruptedException {
		FileLib f=new FileLib();
		String data = f.getExcelData("CreateCustomer", 1, 2);
		custNmaeTxtBox.sendKeys(data);
		Thread.sleep(2000);
	}

}

