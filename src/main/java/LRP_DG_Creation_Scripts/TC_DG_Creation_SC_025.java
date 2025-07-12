package LRP_DG_Creation_Scripts;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
public class TC_DG_Creation_SC_025 extends Keywords {


	public void DG_Creation_SC_025(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		// Value are taken from excel sheet
		String testcase_Name = "TC_DG_Creation_SC_025";
		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String DG_Creation_Module = Excel_data.get("DG_Creation_Module");

		String agencyUser = Excel_data.get("AgencyUser");

		String Applied_Popup_Exp = Excel_data.get("Applied_Popup_Exp");
		String Details_Saved_Popup = Excel_data.get("Details_Saved_Popup");
		
		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);
		
		// Login

		LRP_Login(driver, username, password);
		
		SwitchProfile(driver, agencyUser);

//		Module Search
		
		moduleNavigate(driver, DG_Creation_Module);
		
		
		newButton(driver);
		
		DG_Creation_Input_Fields input_Fields=new DG_Creation_Input_Fields();
		input_Fields.dg_Creation_Input_Fields(driver,Excel_data, test, test1);
		
		Step_Start(4, "click multi apply  button.", test, test1);

		
		scrollElementToView(driver, Multi_Apply_Btn);
		waitForElement(driver, Multi_Apply_Btn);
		safeclick(driver, Multi_Apply_Btn);

		waitForPopup(driver, popup_Message,Applied_Popup_Exp);
		String Applied_Popup = getText(driver, popup_Message);
		System.out.println(Applied_Popup);
		if(Applied_Popup.equals(Applied_Popup_Exp)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp + " || Actual Report Activity is : " + Applied_Popup);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Applied_Popup_Exp + " || Actual Report Activity is : " + Applied_Popup, test,test1);     
			safeclick(driver, popup_Message_Ok_Button);
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp + " || Actual Report Activity is : " + Applied_Popup);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Applied_Popup_Exp + " || Actual Report Activity is : " + Applied_Popup, test,test1); 
		} 
	
		Step_End(4, "click multi apply  button.", test, test1);
		
		Step_Start(5, "Click save button", test, test1);
		

	waitForElement(driver, DG_Save_Btn);
	safeclick(driver, DG_Save_Btn);
	waitForPopup(driver, popup_Message,Details_Saved_Popup);
	String Saved_Popup = getText(driver, popup_Message);
	System.out.println(Applied_Popup);
	if(Saved_Popup.equals(Details_Saved_Popup)) {                                                                                                                  
		System.out.println("Matched || " + " Expected Report Activity is : " + Details_Saved_Popup + " || Actual Report Activity is : " + Saved_Popup);            
		Extent_pass_New(driver, "Matched || " + " Expected Report Activity is: " + Details_Saved_Popup + " || Actual Report Activity is : " + Saved_Popup, test,test1);     
		safeclick(driver, popup_Message_Ok_Button);
	}                                                                                                                                                                        
	else {                                                                                                                                                                   
		System.out.println("Not Matched || " + " Expected Report Activity is : " + Details_Saved_Popup + " || Actual Report Activity is : " + Saved_Popup);        
		Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Details_Saved_Popup + " || Actual Report Activity is : " + Saved_Popup, test,test1); 
		
		
	}
	
	Step_End(5, "Click save button", test, test1);
	Step_Start(6, "Click file upload button.", test, test1);
	
	
	String[] values = splitXpath(File_Chooser);
	WebElement FileUploadOpt = driver.findElement(By.xpath(values[1]));
	
	if(FileUploadOpt.isEnabled()) {
		
		waitForElement(driver, File_Chooser_Button);
		safeclick(driver, File_Chooser_Button);
		waitForElement(driver, File_Chooser_Button);
		System.out.println("Matched || " + " Expected :File location Should be displayed  || Actual  :File location is displayed ");            
		Extent_pass_New(driver, "Matched || " + " Expected :File location Should be displayed  || Actual  :File location is displayed ", test,test1);
	}else {
		
		System.out.println("Not Matched || " + " Expected :File location Should be displayed  || Actual  :File location is not displayed ");        
		Extent_fail(driver, "Not Matched || " + " Expected :File location Should be displayed  || Actual  :File location is not displayed :", test,test1);
	}
	
	Step_End(6, "Click file upload button.", test, test1);
	Extent_completed(testcase_Name, test, test1);
	
	}}