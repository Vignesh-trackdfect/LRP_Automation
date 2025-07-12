package LRP_Vendor_Invoice_Registration_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Vendor_Invoice_Registration_SC55 extends Keywords {
	public void Vendor_Invoice_Registration_SC55(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_Excel_dataset,Map<String, String> Excel_data,String url) {
		
		String testCaseName="TC_Vendor_Invoice_Registration_SC55";
			
			
	        String username = Excel_data.get("Username");
	        String password = Excel_data.get("Password");
	        String moduleName = Excel_data.get("Module_Name");
	        String agencyCode = Excel_data.get("AgencyCode");
			String dropdownCondition =Excel_data.get("DropdownCondition");
			String Vendor_Code_Search_VM = Excel_data.get("Vendor_Code_Search_VM");
            String vendorCode = Excel_data.get("VendorCode");
            String Select_Columns=Excel_data.get("Column_name");
    		String savedpopEXP = Excel_data.get("savedpopEXP");

			Extent_Start(testCaseName, test, test1);
			navigateUrl(driver, url);

			LRP_Login(driver, username, password);
			
			SwitchProfile(driver, agencyCode);
			Step_Start(1, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);
	
			moduleNavigate(driver,moduleName);
			Step_End(1, "Enter the screen name as a \"Vendor Invoice Registration\" in the Search", test, test1);
			Step_Start(2, "Click the global search", test, test1);
			Step_Start(3,"Enter the Vendor invoice Reg no in the Vendor invoice Reg no field", test, test1);

	
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);

			globalValueSearchWindow(driver, dropdownCondition, Vendor_Code_Search_VM, vendorCode, "", "", "", "");
			Step_End(2, "Click the global search", test, test1);
			Step_End(3,"Enter the Vendor invoice Reg no in the Vendor invoice Reg no field", test, test1);
			Step_Start(4,"Check  whether Disbursement No is present or not",test, test1);
			Step_Start(5,"click on invoice reverse button",test, test1);
			Step_Start(6,"Check the popup message",test, test1);
			scrollToElement(driver,scrolldow);
			
			reArrangeAG_GridColumns(driver,Select_Columns);
			List<Map<String, String>> data = extractTableDataByColumnWithoutScroll(driver, disbursement);	
		    String ColData=getFirstValueByHeader(data,Select_Columns);
		    System.out.println(ColData);
		    if(ColData!=null) {
		    Extent_pass_New(driver, "Passed || Expected : Disbursement No should be present || Actual : Disbursement No is present", test, test1);
			System.out.println("Passed || Expected : Disbursement No should be present || Actual : Disbursement No is  present");	
		    scrollTop(driver);
			waitForElement(driver, invoice_reverse);
		    click(driver,invoice_reverse);
		    }
		    else {
			System.out.println("Failed || Expected :  Disbursement No should be present || Actual : Disbursement No is not present");
    		Extent_fail(driver, "Failed || Expected :  Disbursement No should be present || Actual : Disbursement No is not present", test, test1);
 	
		    }
		    if(ColData!=null) {
		    	
		    waitForPopup(driver, popup_Message, savedpopEXP);	
			String popupmsg = getText(driver, popup_Message);
			System.out.println("Matched || The Expected Pop-up Value is : " + savedpopEXP + " || The Actual Pop-up Value is : " + popupmsg);            
			Extent_pass_New(driver,"Matched || The Expected Pop-up Value is : " + savedpopEXP + " || The Actual Pop-up Value is : " + popupmsg, test,test1);     
		    }else {  
		    waitForPopup(driver, popup_Message, savedpopEXP);		
			String popupmsg = getText(driver, popup_Message);
			System.out.println("Not Matched || The Expected Pop-up Value is : " + savedpopEXP + " || But The Actual Pop-up Value is : " + popupmsg);        
			Extent_fail(driver,"Not Matched || The Expected Pop-up Value is : " + savedpopEXP + " || But The Actual Pop-up Value is : " + savedpopEXP, test,test1); 
		} 
		    Step_End(4,"Check  whether Disbursement No is present or not",test, test1);
		    Step_End(5,"click on invoice reverse button",test, test1);
		    Step_End(6,"Check the popup message",test, test1);
			Extent_completed(testCaseName, test, test1);

		    }
		 }
	
		    	
		
