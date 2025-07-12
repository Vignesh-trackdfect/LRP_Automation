package LRP_Arrival_Notice_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_034  extends Keywords {

	public void Arrival_Notice_TS_034(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Throwable {

		String testcase_Name="TC_Arrival_Notice_TS_034";

		String username =Excel_data.get("Username");
		String password =Excel_data.get("Password");
		String agencyUser =Excel_data.get("AgencyUser");
		String arrival_Module_Search =Excel_data.get("Arrival_Module_Search");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String Search_Number = Excel_data.get("Search_Number");
		String bl_Number = Excel_data.get("bl_Number");
		String columnHeaders = Excel_data.get("columnHeaders");
	
	
	

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		// Login to the Application

		LRP_Login(driver, username, password);
		Step_Start(1, "Select the transhipment agency ", test, test1);

		
		SwitchProfile(driver, agencyUser);
		Step_End(1, "Select the transhipment agency ", test, test1);

		Step_Start(2, "Search the module name ( \"Arrival Notice / Freight Memo\" ) in module search", test, test1);


		
		moduleNavigate(driver, arrival_Module_Search);
		Step_End(2, "Search the module name ( \"Arrival Notice / Freight Memo\" ) in module search", test, test1);

		Step_Start(3, "Click the search button", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(3, "Click the search button", test, test1);

		Step_Start(4, "Enter the Bl number/ Arrival Notice number", test, test1);
		globalValueSearchWindow(driver, dropdownCondition1, Search_Number, bl_Number, "","", "","");
		
		
		Step_End(6, "Select the respected bl/ Arrival Notice number and double click", test, test1);

		Step_Start(7, "after fetching BL copy the arrival notice number & BL number", test, test1);

		waitForElement(driver, Nine_Dotted_Icon);
		click(driver, Nine_Dotted_Icon);
		click(driver, condition_Filter_AN);
		sendKeys(driver, blNumber_Filter_AN,bl_Number );
		
		reArrangeAG_GridColumnsNew(driver,AN_COLOUM, columnHeaders);
	
		Step_End(7, "after fetching BL copy the arrival notice number & BL number", test, test1);

		Step_Start(8, "Click the Print button verify the Arrival notice number should be match with PDF.", test, test1);

	
		Step_End(8, "Click the Print button verify the Arrival notice number should be match with PDF.", test, test1);

		Step_Start(9, "Then Click the Download button ( Make sure download in system )", test, test1);

	
		waitForElement(driver, consigneeAddress_AN_Grid);
		String actualConsigneeAddress_AN=getText(driver, consigneeAddress_AN_Grid);
		String actualConsignee_AN=getText(driver, consignee_AN_Grid);
		//String actualConsignee_AN = getText(driver, consignee_AN_Grid).toUpperCase();
		System.out.println("AAAAAAAA"+actualConsignee_AN);
		
		String actualConsigneeCity_AN=getText(driver, consigneeCity_AN_Grid);
		String actualConsigneeCountry_AN=getText(driver, consigneeCountry_AN_Grid);
		Extent_call(test, test1, "clicking on particular bl_numbers checkbox");

		String click_Chckbox_By_Bl_Number=String.format(Arrival_Notice_Locators.click_Chckbox_By_Bl_Number, bl_Number);
		waitForElement(driver, click_Chckbox_By_Bl_Number);
		click(driver, click_Chckbox_By_Bl_Number);
		scrollTop(driver);

		waitForElement(driver, print_Btn_Toolbar_AN);
		safeclick(driver, print_Btn_Toolbar_AN);

		Extent_call(test, test1, "switching to the iframe");
		waitForElement(driver, jsp_Iframe);
		switchToFrame(driver, jsp_Iframe);
		String Bl_Number=String.format(Arrival_Notice_Locators.PDF_Bl_Number, bl_Number);
	waitForElement(driver, Bl_Number) ;
		String BL_Value = getText(driver, Bl_Number);
		if(BL_Value.contains(bl_Number)) {
			Extent_pass(driver, "Matched || Expected BL Number was : "+bl_Number+" || Actual BL Number From PDF Viewer : "+BL_Value, test, test1);
			System.out.println("Matched || Expected BL Number was : "+bl_Number+" || Actual BL Number From PDF Viewer : "+BL_Value);
		}else {
			System.out.println("Not Matched || Expected BL Number was : "+bl_Number+" || Actual BL Number From PDF Viewer : "+BL_Value);
			Extent_fail(driver, "Not Matched || Expected BL Number was : "+bl_Number+" || Actual BL Number From PDF Viewer : "+BL_Value, test, test1);
		}
		String pdfText = downloadPDFAndExtract(driver, Download_Button);
		Step_End(9, "Then Click the Download button ( Make sure download in system )", test, test1);

		Step_Start(10, "Open the downloaded file match the arrival notice number, BL/HBL number/ Consignee details (Customer code, Name, Address1, email) with screen", test, test1);
		
		Map<String, String> consignee = extractConsigneeDetails(pdfText,"Consignee : Notify Party :");
		String Consignee_Name = consignee.get("Name");
		String Consignee_Address = consignee.get("Address");
		String Consignee_City = consignee.get("City");
		String Consignee_Country = consignee.get("Country");
		System.out.println("Consignee_Name: " + Consignee_Name);
		System.out.println("Consignee_Address: " + Consignee_Address);
		System.out.println("Consignee_City: " + Consignee_City);
		System.out.println("Consignee_Country: " + Consignee_Country);
	
		if(actualConsignee_AN.trim().equals(Consignee_Name.trim())) {
			Extent_pass(driver, "Matched || Expected Consignee Name From Arrival Notice Grid Value was : "+actualConsignee_AN+" || Actual Consignee Name From Downloaded PDF : "+Consignee_Name, test, test1);
			System.out.println( "Matched || Expected Consignee Name From Arrival Notice Grid Value was : "+actualConsignee_AN+" || Actual Consignee Name From Downloaded PDF : "+Consignee_Name);
		}else {
			System.out.println( "Not Matched || Expected Consignee Name From Arrival Notice Grid Value was : "+actualConsignee_AN+" || Actual Consignee Name From Downloaded PDF : "+Consignee_Name);
			Extent_fail(driver,  "Not Matched || Expected Consignee Name From Arrival Notice Grid Value was : "+actualConsignee_AN+" || Actual Consignee Name From Downloaded PDF : "+Consignee_Name, test, test1);
		}
		if(Consignee_Address.trim().contains(actualConsigneeAddress_AN.trim())) {
			Extent_pass(driver,"Matched || Expected Consignee Address From Arrival Notice Grid Value was : "+actualConsigneeAddress_AN+" || Actual Consignee Address From Downloaded PDF : "+Consignee_Address, test, test1);
			System.out.println("Matched || Expected Consignee Address From Arrival Notice Grid Value was : "+actualConsigneeAddress_AN+" || Actual Consignee Address From Downloaded PDF : "+Consignee_Address);
		}else {
			System.out.println("Not Matched || Expected Consignee Address From Arrival Notice Grid Value was : "+actualConsigneeAddress_AN+" || Actual Consignee Address From Downloaded PDF : "+Consignee_Address);
			Extent_fail(driver,"Not Matched || Expected Consignee Address From Arrival Notice Grid Value was : "+actualConsigneeAddress_AN+" || Actual Consignee Address From Downloaded PDF : "+Consignee_Address, test, test1);
		}
		if(actualConsigneeCity_AN.trim().contains(Consignee_City.trim())) {
			Extent_pass(driver, "Matched || Expected Consignee City From Arrival Notice Grid Value was : "+actualConsigneeCity_AN+" || Actual Consignee City From Downloaded PDF : "+Consignee_City, test, test1);
			System.out.println("Matched || Expected Consignee City From Arrival Notice Grid Value was : "+actualConsigneeCity_AN+" || Actual Consignee City From Downloaded PDF : "+Consignee_City);
		}else {
			System.out.println("Not Matched || Expected Consignee City From Arrival Notice Grid Value was : "+actualConsigneeCity_AN+" || Actual Consignee City From Downloaded PDF : "+Consignee_City);
			Extent_fail(driver, "Not Matched || Expected Consignee City From Arrival Notice Grid Value was : "+actualConsigneeCity_AN+" || Actual Consignee City From Downloaded PDF : "+Consignee_City, test, test1);
		}
		if(actualConsigneeCountry_AN.trim().equals(Consignee_Country.trim())) {
			Extent_pass(driver, "Matched || Expected Consignee Country From Arrival Notice Grid Value was : "+actualConsigneeCountry_AN+" || Actual Consignee Country From Downloaded PDF : "+Consignee_Country, test, test1);
			System.out.println("Matched || Expected Consignee Country From Arrival Notice Grid Value was : "+actualConsigneeCountry_AN+" || Actual Consignee Country From Downloaded PDF : "+Consignee_Country);
		}else {
			System.out.println("Not Matched || Expected Consignee Country From Arrival Notice Grid Value was : "+actualConsigneeCountry_AN+" || Actual Consignee Country From Downloaded PDF : "+Consignee_Country);
			Extent_fail(driver,"Not Matched || Expected Consignee Country From Arrival Notice Grid Value was : "+actualConsigneeCountry_AN+" || Actual Consignee Country From Downloaded PDF : "+Consignee_Country, test, test1);
		}
		Step_End(10, "Open the downloaded file match the arrival notice number, BL/HBL number/ Consignee details (Customer code, Name, Address1, email) with screen", test, test1);
		Extent_completed(testcase_Name, test, test1);

	}
}
