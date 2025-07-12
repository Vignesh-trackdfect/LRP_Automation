package LRP_EMS_Individual_Scripts;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



import locators.Bill_Upload_Gate;


public class Bill_Upload_Gate_TS_046 extends Keywords{
	
	public void BillUploadGate(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException {
		// Value are taken from excel sheet
		String testcase_Name = "Bill_Upload_Gate_TS_046";
		
	String Username = Excel_data.get("Username");// 1,2,4-6
	String Password = Excel_data.get("Password");
	String Popupforimporexp45 = Excel_data.get ("Popupforupload");
	String Search145 = Excel_data.get ("Search_input1");
	String Search45 =  Excel_data.get("Search_input");
	String excelFilePath = Excel_data.get ("excelFilePath");
	String Sheet_select = Excel_data.get ("Sheet_select");
	
	
	Extent_Start(testcase_Name, test, test1);


	navigateUrl(driver, url);

	
	LRP_Login(driver, Username, Password);
	moduleNavigate(driver, Search45);


			
	Step_Start(1, " Click Import Excel button & select Excel file accordingly ",test, test1);
			waitForElement(driver, Aimport_excelll_BU);
			click(driver, Aimport_excelll_BU);
			waitForDisplay(driver, Aselectexcelfile);
			if (isDisplayed(driver, Aselectexcelfile)) {
				System.out.println("Expected Result is: Once User Click import excel button,Import excel page should be opened   ||  Actual Result is : Once User Click import excel button,Import excel page is opened");
				Extent_pass_New(driver, "Expected Result is: Once User Click import excel button,Import excel page should be opened   ||  Actual Result is : Once User Click import excel button,Import excel page is opened", test,test1);
			} else {
				System.out.println("Expected Result is: Once User Click import excel button,Import excel page should be opened   ||  Actual Result is : Once User Click import excel button,Import excel page is not opened");
				Extent_fail(driver, "Expected Result is: Once User Click import excel button,Import excel page should be opened   ||  Actual Result is : Once User Click import excel button,Import excel page is not opened", test,test1);
				
			}
			
			uploadfile1(driver, Lessor_Bill_File_Upload, excelFilePath);

			
			waitForElement(driver, Aselectexcelfiledroupdown);
			click(driver, Aselectexcelfiledroupdown);
			
			formatLocatorClick(driver, Bill_Upload_Gate.Sheet_sel, Sheet_select);
		
			Step_End(1, " Click Import Excel button & select Excel file accordingly ",test, test1);
			Step_Start(2, "Select required file from local file manually & upload",test, test1);
			waitForElement(driver, Aloadsheet);
			click(driver, Aloadsheet);
			
		waitForElement(driver, Amapyesbutton);
		click(driver, Amapyesbutton);
		
			List<String> RGEMailId13_excelvalue = getExcelValue(excelFilePath, Sheet_select);

				System.out.println(RGEMailId13_excelvalue);
		
				
	
		
		List<WebElement> CancleReasons = listOfElements(driver, gird_val_BU);
		List<String> reasons=new ArrayList<String>();

		for(WebElement CancleReason:CancleReasons) {
			
			String Gridvalues = getText1(driver, CancleReason);
			reasons.add(Gridvalues);
			System.out.println( Gridvalues);
		}

		
		
		
		if (RGEMailId13_excelvalue.equals(reasons)) {
			System.out
					.println("Matched || " + " Expected Activity is[Container No in grid] : " + reasons + " || Actual Activity is[Container No in Excel] : " + RGEMailId13_excelvalue);
			Extent_pass_New(driver,
					"Matched || " + " Expected Activity is[Container No in grid] : " + reasons + " ||Actual Activity is[Container No in Excel] : " + RGEMailId13_excelvalue,test,test1);
		} else {
			System.out.println(
					"Not matched || " + "Expected Activity is[Container No in grid] : " + reasons + " || Expected Activity is[Container No in grid] : " + RGEMailId13_excelvalue);
			Extent_fail(driver,
					"Not matched || " + " Expected Activity is[Container No in grid] : " + reasons + " || Expected Activity is[Container No in grid]: " + RGEMailId13_excelvalue,test,test1);
			
		}
		
		

			waitForElement(driver, Auploadfile);
			click(driver, Auploadfile);
			Step_End(2, "Select required file from local file manually & upload",test, test1);

	
			Step_Start(3, "Confirmation message will be shown as Lessor Bill Uploaded",test, test1);
			
			waitForPopup(driver, popup_Message, Popupforimporexp45);
				String Popupforimporact=getText(driver, popup_Message);
			System.out.println(Popupforimporact);
			
			
		
				if (Popupforimporexp45.equals(Popupforimporact)) {
					System.out
							.println("Matched || " + " Expected Activity is : " + Popupforimporexp45 + " || Actual Activity is : " + Popupforimporact);
					Extent_pass_New(driver,
							"Matched || " + " Expected Activity is : " + Popupforimporexp45 + " ||Actual Activity is : " + Popupforimporact,test,test1);
				} else {
					System.out.println(
							"Not matched || " + "row terminal was not edited : " + Popupforimporexp45 + " || Actual Activity is : " + Popupforimporact);
					Extent_fail(driver,
							"Not matched || " + "row terminal was not edited : " + Popupforimporexp45 + " || Actual Activity is : " + Popupforimporact,test,test1);
					
				}
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver, popup_Message_Ok_Button); 
			Step_End(3, "Confirmation message will be shown as Lessor Bill Uploaded",test, test1);
		
			moduleNavigate(driver, Search145);
			
			String Location1=getText(driver, Arowoneclick);
			System.out.println(Location1);
			Extent_pass_New(driver,"Contract number shown as"+"****"+
					Location1,test,test1);
			
			String equetype45=getText(driver, Lessor_BU);
			System.out.println(equetype45);
			Extent_pass_New(driver,"Lessor shown as"
					+"****"+ equetype45,test,test1);
			String equeque=getText(driver, Bill_no_BU);
			System.out.println(equeque);
			Extent_pass_New(driver,"BillNo  shown as "+
					"***"+equeque,test,test1);
			String equequee=getText(driver, Billing_number_BU);
			System.out.println(equequee);
			Extent_pass_New(driver,"Billing Period  shown as "+
					"***"+equequee,test,test1);
			
			
			String equequee1=getText(driver, Status_BU);
			System.out.println(equequee1);
			Extent_pass_New(driver,"Status  shown as "+
					"***"+equequee1,test,test1);
			
		        
			
			waitForDisplay(driver, Acontractnumbergrid);
		        if (isDisplayed(driver, Acontractnumbergrid)) {
					System.out
							.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is shown in grid");
					Extent_pass_New(driver,
							"Expected Result is : Data should be shown in grid || Actual Result is : Data is shown in grid",test,test1);
				} else {
					System.out.println("Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid");
					Extent_fail(driver,
							"Expected Result is : Data should be shown in grid || Actual Result is : Data is not shown in grid",test,test1);
				
				}
			
			waitForElement(driver, Arowoneclick);
			click(driver, Arowoneclick);
			
			waitForElement(driver, Arowoneclick);
			RightClick(driver, Arowoneclick);
			waitForElement(driver, Aclearbills);
			click(driver, Aclearbills);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			
			waitForElement(driver, Arefresh);
			click(driver, Arefresh);
			Extent_completed(testcase_Name, test, test1);
			
}
	
}
