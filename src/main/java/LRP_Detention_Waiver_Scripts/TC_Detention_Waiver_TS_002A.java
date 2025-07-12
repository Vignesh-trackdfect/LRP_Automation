package LRP_Detention_Waiver_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Detention_Waiver_TS_002A  extends Keywords{
	
	public void Detention_Waiver_TS_002A(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name = "TC_Detention_Waiver_TS_002A";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String BL_No = Excel_data.get("BL_Number");
		String Bill_Module = Excel_data.get("Bill_Module");
		String dropdownCondition = Excel_data.get("dropdownCondition");
		String Bill_Of_Lading_BL_Number_Search_Type = Excel_data.get("Bill_Of_Lading_BL_Number_Search_Type");
		String Colour_Name = Excel_data.get("Colour_Name");
		String Detention_Module = Excel_data.get("Detention_Module");
		String Detention_Module_BL_Number_Search_Type = Excel_data.get("Detention_Module_BL_Number_Search_Type");
		String No_Record_Popup = Excel_data.get("No_Record_Popup");
		

		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		SwitchProfile(driver, AgencyName);

		List<String> Numbers = splitAndExpand(BL_No, ",");

		for (int i = 0; i < Numbers.size(); i++) {

			String number = Numbers.get(i);

			Step_Start(1, "Open Bill of Lading Module Module", test, test1);
			moduleNavigate(driver, Bill_Module);

			Step_End(1, "Open Bill of Lading Module Module", test, test1);

			Step_Start(2, "Click on Search Button and load the BL", test, test1);

			waitForElement(driver, BL_searchicon);
			click(driver, BL_searchicon);
			
			globalValueSearchWindow1(driver, dropdownCondition, Bill_Of_Lading_BL_Number_Search_Type, number, "", "",
					"", "");

			Step_End(2, "Click on Search Button and load the BL", test, test1);

			Step_Start(3, "Verify that BL is Draft (or) Cancelled status", test,
					test1);

			waitForElement(driver, BL_Global_Status);
			String StatuValue = getText(driver, BL_Global_Status);

			waitForElement(driver, retrivedGlobalValue);
			click(driver, retrivedGlobalValue);

			waitForElement(driver, SelectButton);
			click(driver, SelectButton);
			
			elementnotvisible1(driver, SelectButton);

			Step_End(3, "Verify that BL is Draft (or) Cancelled status", test,
					test1);
			if(Colour_Name.equalsIgnoreCase("Yellow")) {
			String bill_number_colour111= getTextBackgroundColor(driver, bl_draft_btn);
			String bill_number_colour11=getColorName(bill_number_colour111);
			System.out.println(bill_number_colour11);
			
			if(Colour_Name.equalsIgnoreCase(bill_number_colour11)) {                                                                                                                  
				System.out.println("Matched || " + " Expected Report Activity  colour for draft is : " + Colour_Name + " || Actual Report Activity  colour for draft is : " + bill_number_colour11);            
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity  colour for draft is : " + Colour_Name + " || Actual Report Activity  colour for draft is : " + bill_number_colour11, test,test1);     
			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + " Expected Report Activity  colour for draft is : " + Colour_Name + " || Actual Report Activity  colour for draft is : " + bill_number_colour11);        
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity  colour for draft is : " + Colour_Name + " || Actual Report Activity  colour for draft is : " + bill_number_colour11, test,test1); 
				
			}}
			if(Colour_Name.equalsIgnoreCase("Red")) {
				String bill_number_colour111= getTextBackgroundColor(driver, Cancelled_Button);
				String bill_number_colour11=getColorName(bill_number_colour111);
				System.out.println(bill_number_colour11);
				
				if(Colour_Name.equalsIgnoreCase(bill_number_colour11)) {                                                                                                                  
					System.out.println("Matched || " + " Expected Report Activity  colour for Cancelled is : " + Colour_Name + " || Actual Report Activity  colour for Cancelled is : " + bill_number_colour11);            
					Extent_pass_New(driver, "Matched || " + " Expected Report Activity  colour for Cancelled is : " + Colour_Name + " || Actual Report Activity  colour for Cancelled is : " + bill_number_colour11, test,test1);     
				}                                                                                                                                                                        
				else {                                                                                                                                                                   
					System.out.println("Not Matched || " + " Expected Report Activity  colour for Cancelled is : " + Colour_Name + " || Actual Report Activity  colour for Cancelled is : " + bill_number_colour11);        
					Extent_fail(driver, "Not Matched || " + " Expected Report Activity  colour for Cancelled is : " + Colour_Name + " || Actual Report Activity  colour for Cancelled is : " + bill_number_colour11, test,test1); 
					
				}}

			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);

			Step_Start(4, "Open Detention Waiver Module", test, test1);

			moduleNavigate(driver, Detention_Module);

			Step_End(4, "Open Detention Waiver Module", test, test1);

			Step_Start(5, "Click on New Button", test, test1);

			newButton(driver);

			Step_End(5, "Click on New Button", test, test1);

			Step_Start(6, "Click on BL No Search Field ", test, test1);

			waitForElement(driver, DW_BookingNo_Search);
			click(driver, DW_BookingNo_Search);

			Step_End(6, "Click on BL No Search Field ", test, test1);

			globalValueSearchWindow1(driver, dropdownCondition, Detention_Module_BL_Number_Search_Type, number, "", "",
					"", "");

			if (StatuValue.equalsIgnoreCase("draft") || StatuValue.equalsIgnoreCase("void")
					|| StatuValue.equalsIgnoreCase("cancelled")) {

				Step_Start(7, "Input your Draft And Void BL No and verify the same BL not to listed", test, test1);

				waitForPopup(driver, Popup_Message, No_Record_Popup);

				String PopupValue = getText(driver, Popup_Message);

				if (No_Record_Popup.equals(PopupValue)) {
					System.out.println("Matched || Expected Pop-up Value is : " + No_Record_Popup
							+ " || Actual Pop-up Value is : " + PopupValue + " The BL Status is : " + StatuValue);
					Extent_pass_New(driver, "Matched || Expected Pop-up Value is : " + No_Record_Popup
							+ " || Actual Pop-up Value is : " + PopupValue + " The BL Status is : " + StatuValue, test,
							test1);
				} else {
					System.out.println("Not Matched || Expected Pop-up Value is : " + No_Record_Popup
							+ " || Actual Pop-up Value is : " + PopupValue + " The BL Status is : " + StatuValue);
					Extent_fail(driver, "Not Matched || Expected Pop-up Value is : " + No_Record_Popup
							+ " || Actual Pop-up Value is : " + PopupValue + " The BL Status is : " + StatuValue, test,
							test1);
				}

				Step_End(7, "Input your Draft And Void BL No and verify the same BL not to listed", test, test1);

				waitForElement(driver, globalSearchCloseIcon_L);
				click(driver, globalSearchCloseIcon_L);

			
		}
			
	}
		Extent_completed(testcase_Name, test, test1);	
	
	
	
	
	}}


