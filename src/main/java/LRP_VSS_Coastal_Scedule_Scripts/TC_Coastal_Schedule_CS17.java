package LRP_VSS_Coastal_Scedule_Scripts;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS17 extends Keywords {


	public void Coastal_Schedule_CS17(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Coastal_Schedule_CS17";

		String Username_CS17 =Excel_data.get("Username");
		String Password_CS17 =Excel_data.get("Password");
		String ModuleSearch_CS17 =Excel_data.get("Module_Search");
		String ServiceCode_CS17 =Excel_data.get("Service_Code"); 
		String VesselCode_CS17 =Excel_data.get("Vessel_Code");
		String voyageNumber_CS17 =Excel_data.get("Voyage_Number");
		String edit_Button_CS17 =Excel_data.get("Button");
		String rename_Popup = Excel_data.get("Rename_VoyagePopup");
		String rename_Confirm = Excel_data.get("Rename_Conf");
		String New_Voyage_Name = Excel_data.get("New_Voyage_Name");
		String Duplicate = Excel_data.get("Duplicate");
		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");

		String Voyage_New =  String.format(Coastal_Schedule_Locators.Voyage_New, New_Voyage_Name);
		String Voyage =  String.format(Coastal_Schedule_Locators.Voyage_New, voyageNumber_CS17);
		String button_Select =  String.format(Coastal_Schedule_Locators.button_Select, edit_Button_CS17);



		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);
		

		LRP_Login(driver, Username_CS17, Password_CS17);
		
		moduleNavigate(driver, ModuleSearch_CS17);

		Step_Start(1, "Enter the Service Code  in the service code field", test, test1);
		
		waitForElement(driver, Service_Search_Btn);
		click(driver, Service_Search_Btn);
		
		twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS17);


		Step_End(1, "Enter the Service Code  in the service code field", test, test1);
		Step_Start(2, "Enter the Vessel ", test, test1);
		
		waitForElement(driver, Vessel_Search_Btn);
		click(driver, Vessel_Search_Btn);

		twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS17);

		Step_End(2, "Enter the Vessel ", test, test1);
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_Start(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);

		waitForDisplay(driver, Tree_Structure);
		if(isdisplayed(driver,Tree_Structure)) {
			Extent_pass_New(driver, "Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed", test, test1);
			System.out.println("Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed");
		}else {
			System.out.println("Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed");

			Extent_fail(driver, "Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed", test, test1);
		}
		Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
		Step_Start(4, "click on Voyage to be renamed", test, test1);
		waitForElement(driver, Voyage);
		click(driver, Voyage);
		Step_End(4, "click on Voyage to be renamed", test, test1);

		Step_Start(5, "Right click on the voyage", test, test1);
		waitForElement(driver, Voyage);
		String	before_Voyage_Name=getText(driver, Voyage);
		RightClick(driver, Voyage);
		Step_End(5, "Right click on the voyage", test, test1);

		Step_Start(6, "click on Voyage to be renamed", test, test1);

		waitForElement(driver, button_Select);
		click(driver, button_Select);

		Step_End(6, "click on Voyage to be renamed", test, test1);


		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
			String Popup =getText(driver, popup_Message);

			Step_Start(7, "If the voyage has any Confirmed_Button Calls, System should show validation 	as ”Voyage has Confirmed_Button calls, Cannot rename the voyage”", test, test1);

			if (rename_Confirm.equals(Popup)) {
				System.out.println("Matched || Expected Popup  : " +rename_Confirm+"|| Actual Popup  :"  +Popup );

				Extent_pass_New(driver, "Matched || Expected Popup  : " +rename_Confirm+"|| Actual Popup  :"  +Popup,test,test1);
				Step_End(7, "If the voyage has any Confirmed_Button Calls, System should show validation as ”Voyage has Confirmed_Button calls, Cannot rename the voyage”", test, test1);

			} else {
				System.out.println("NotMatched || Expected Popup  : "+rename_Confirm+" || Actual Popup  : "+Popup);
				Extent_fail(driver,  "NotMatched || Expected Popup  : "+rename_Confirm+" || Actual Popup  : "+Popup, test,test1);
			}  

		}else {
			Step_Start(8, "Enter the Voyage name ", test, test1);
			waitForElement(driver, textVal);
			sendKeys(driver, textVal, New_Voyage_Name);
			Step_End(8, "Enter the Voyage name", test, test1);

			Step_Start(9, "Clicking on Ok should rename the voyage number", test, test1);
			waitForElement(driver, okOption);
			click(driver, okOption);
			Step_End(9, "Clicking on Ok should rename the voyage number", test, test1);

					waitForPopup(driver, popup_Message, rename_Popup);
			String Actual_Popup=getText(driver, popup_Message);
			if(Duplicate.equals(Actual_Popup)) {
				System.out.println("Matched || Expected Popup  : " +Duplicate+"|| Actual Popup  :"  +Actual_Popup );
				Extent_pass_New(driver, "Matched || Expected Popup  : " +Duplicate+"|| Actual Popup  :"  +Actual_Popup,test,test1);

			}else {

				Extent_call(test, test1, "*******Popup validation after renaming...********");
				if (Actual_Popup.equals(rename_Popup)) {
					System.out.println("Matched || Expected Popup  : " +rename_Popup+"|| Actual Popup  :"  +Actual_Popup );
					Extent_pass_New(driver, "Matched || Expected Popup  : " +rename_Popup+"|| Actual Popup  :"  +Actual_Popup,test,test1);
				} else {
					System.out.println("NotMatched || Expected Popup  : "+rename_Popup+" || Actual Popup  : "+Actual_Popup);
					Extent_fail(driver,  "NotMatched || Expected Popup  : "+rename_Popup+" || Actual Popup  : "+Actual_Popup, test,test1);
				}    
				Extent_call(test, test1, "Popup  confirmation");
				click(driver, popup_Message_Ok_Button);
				
				waitForDisplay(driver, Voyage_New);
				scrollUsingElement(driver, Voyage_New);
				String after_Voyage_Name=getText(driver, Voyage_New);

				Extent_call(test, test1, "Comparing the voyage names before and after renaming...");
				if (!before_Voyage_Name.equals(New_Voyage_Name)) {
					System.out.println("Matched || Before edit the voyage name was : " +before_Voyage_Name+"|| After Edit the Actual Voyage name is :"  +after_Voyage_Name );
					Extent_pass_New(driver, "Matched || Before edit the voyage name was : " +before_Voyage_Name+"|| After Edit the Actual Voyage name is :"  +after_Voyage_Name,test,test1);
				} else {
					System.out.println("NotMatched || Before edit the voyage name was : "+before_Voyage_Name+" || After Edit the Actual Voyage name is : "+after_Voyage_Name);
					Extent_fail(driver,  "NotMatched || Before edit the voyage name was : "+before_Voyage_Name+" || After Edit the Actual Voyage name is : "+after_Voyage_Name, test,test1);
				}
			}

		}
		Extent_completed(testCaseName, test, test1);

	}
}