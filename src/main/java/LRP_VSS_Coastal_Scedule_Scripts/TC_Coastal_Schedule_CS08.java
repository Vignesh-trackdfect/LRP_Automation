package LRP_VSS_Coastal_Scedule_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS08 extends Keywords {

	public void Coastal_Schedule_CS08(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Coastal_Schedule_CS08";
		String Username_CS08 =Excel_data.get("Username");
		String Password_CS08 =Excel_data.get("Password");
		String ModuleSearch_CS08 =Excel_data.get("Module_Search");
		String ServiceCode_CS08 =Excel_data.get("Service_Code"); 
		String VesselCode_CS08 =Excel_data.get("Vessel_Code");
		String voyageNumber_CS08 =Excel_data.get("Voyage_Number");
		String portName_CS08 =Excel_data.get("Port_Name");
		String EditBound_Button_CS08 =Excel_data.get("Button");
		String after_Bound_1 =Excel_data.get("after_Bound_1");
		String after_Bound_2 =Excel_data.get("after_Bound_2");
		String after_Bound_3 =Excel_data.get("after_Bound_3");
		String Sub_Bound =Excel_data.get("Sub_Bound");
		String PF_Bound =Excel_data.get("PF_Bound");
		String Bound_1 =Excel_data.get("Bound_1");
		String Bound_2 =Excel_data.get("Bound_2");
		String Bound_3 =Excel_data.get("Bound_3");
		String Bound_4 =Excel_data.get("Sub_Bound_field");
		String Bound_5 =Excel_data.get("PF_Bound_field");
		String renamed_Popup =Excel_data.get("Renamed_Popup");
		String not_Same_Popup =Excel_data.get("Not_Same_Popup");
		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");

		String Voyage_Toggler = String.format(Coastal_Schedule_Locators.Voyage_Toggler8,voyageNumber_CS08);
		String Port_Select = String.format(Coastal_Schedule_Locators.Port_Select8,voyageNumber_CS08,portName_CS08);
		String edit_Bound_1 = String.format(Coastal_Schedule_Locators.edit_Bound,after_Bound_1);
		String edit_Bound_2= String.format(Coastal_Schedule_Locators.edit_Bound,after_Bound_2);
		String edit_Bound_3 =String.format(Coastal_Schedule_Locators.edit_Bound,after_Bound_3);
		String Sub_Bound_edit=String.format(Coastal_Schedule_Locators.Sub_Bound_edit,Sub_Bound);
		String PF_Bound_Edit = String.format(Coastal_Schedule_Locators.PF_Bound_Edit,PF_Bound);
		String editbutton_Select =String.format(Coastal_Schedule_Locators.editbutton_Select,EditBound_Button_CS08);
		String edit_Bound_Button_1 =String.format(Coastal_Schedule_Locators.edit_Bound_Button8,Bound_1);
		String edit_Bound_Button_2 = String.format(Coastal_Schedule_Locators.edit_Bound_Button8,Bound_2);
		String edit_Bound_Button_3 = String.format(Coastal_Schedule_Locators.edit_Bound_Button8,Bound_3);
		String sub_Bound_Button = String.format(Coastal_Schedule_Locators.sub_Bound_Button,Bound_4);
		String PF_Bound_Button =String.format(Coastal_Schedule_Locators.PF_Bound_Button,Bound_5);

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);
		
		LRP_Login(driver, Username_CS08, Password_CS08);
		
		moduleNavigate(driver, ModuleSearch_CS08);
		
		Step_Start(1, "Enter the Service Code in the service code field", test, test1);

		waitForElement(driver, Service_Search_Btn);
		click(driver, Service_Search_Btn);
		
		twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS08);
		
		Step_End(1, "Enter the Service Code in the service code field", test, test1);

		Step_Start(2, "Enter the Vessel ", test, test1);

		waitForElement(driver, Vessel_Search_Btn);
		click(driver, Vessel_Search_Btn);

		twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS08);


		Step_End(2, "Enter the Vessel ", test, test1);

		Step_Start(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForDisplay(driver, Tree_Structure);
		if(isdisplayed(driver,Tree_Structure)) {
			Extent_pass_New(driver, "Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed", test, test1);
			System.out.println("Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed");
		}else {
			System.out.println("Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed");

			Extent_fail(driver, "Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed", test, test1);
		}

		waitForElement(driver, Voyage_Toggler);
		String status = getAttribute(driver, Voyage_Toggler, "class");
		if(!status.contains("s")) {
			click(driver, Voyage_Toggler);
		}
		Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);

		Step_Start(4, "Right click on the port which the bound of the port should be adjusted ", test, test1);
		waitForElement(driver, Port_Select);
		click(driver, Port_Select);	

		waitForElement(driver, Port_Select);
		RightClick(driver, Port_Select);
		waitForElement(driver, editbutton_Select);
		click(driver, editbutton_Select);

		Step_End(4, "Right click on the port which the bound of the port should be adjusted ", test, test1);
		waitForElement(driver, PF_Bound_Button);
		click(driver, PF_Bound_Button);

		Step_Start(5, "Choose Edit Bound Option", test, test1);
		waitForElement(driver, PF_Bound_Edit);
		click(driver, PF_Bound_Edit);
		Step_End(5, "Choose Edit Bound Option", test, test1);

		Step_Start(6, "Update the Bound for the Respective Bound(s)", test, test1);
		waitForElement(driver, sub_Bound_Button);
		click(driver, sub_Bound_Button);
		waitForElement(driver, Sub_Bound_edit);
		click(driver, Sub_Bound_edit);

		waitForElement(driver, edit_Bound_Button_1);
		click(driver, edit_Bound_Button_1);
		waitForElement(driver, edit_Bound_1);
		click(driver, edit_Bound_1);	

		waitForElement(driver, edit_Bound_Button_2);
		click(driver, edit_Bound_Button_2);
		waitForElement(driver, edit_Bound_2);
		click(driver, edit_Bound_2);

		waitForElement(driver, edit_Bound_Button_3);
		click(driver, edit_Bound_Button_3);
		waitForElement(driver, edit_Bound_3);
		click(driver, edit_Bound_3);

		Step_End(6, "Update the Bound for the Respective Bound(s)", test, test1);

		Step_Start(7, "Click on Move to Coastal", test, test1);
		waitForElement(driver, editboundOk);
		click(driver, editboundOk);
		
		waitForDisplay(driver, popup_Message_Yes_Button);
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
			click(driver, popup_Message_Yes_Button);
			}
		
		waitForPopup(driver, popup_Message, renamed_Popup);
		String renamed_Bound_Name = getText(driver, popup_Message);
		if(renamed_Bound_Name.contains(not_Same_Popup)) {
			Extent_pass_New(driver, "Matched || Expected popup is : "+not_Same_Popup+" Actual popup is : "+ renamed_Bound_Name, test, test1);
			System.out.println("Matched || Expected popup is : "+not_Same_Popup+" Actual popup is : "+ renamed_Bound_Name);
		}
		else if (renamed_Popup.equals(renamed_Bound_Name)) {
			Extent_pass_New(driver, "Matched || Expected popup is : "+renamed_Popup+" Actual popup is : "+ renamed_Bound_Name, test, test1);
			System.out.println("Matched || Expected popup is : "+renamed_Popup+" Actual popup is : "+ renamed_Bound_Name);
			click(driver, popup_Message_Ok_Button);
			waitForElement(driver, Port_Select);
			String pivotbound1 = getText(driver, Port_Select);
			String act_Bound_Value = "[" + Sub_Bound + "B]";
			if (pivotbound1.contains(act_Bound_Value)) {
				System.out.println("Matched || Expected Pivot bound : "+act_Bound_Value+" || Actual Pivot bound : "+pivotbound1);
				Extent_pass_New(driver, "Matched || Expected Pivot bound : "+act_Bound_Value+" || Actual Pivot bound : "+pivotbound1, test,test1);
			} else {
				System.out.println("Not Matched || Expected Pivot bound : "+act_Bound_Value+" || Actual Pivot bound : "+pivotbound1);
				Extent_fail(driver, "Not Matched || Expected Pivot bound : "+act_Bound_Value+" || Actual Pivot bound : "+pivotbound1, test,test1);
				
			}
			click(driver, Port_Select);			
		}
		else {
			System.out.println("Bound Renamed text is not displayed");
			Extent_fail(driver, "Bound Renamed text is not displayed", test,test1);
		}
		Step_End(7, "Click on Move to Coastal", test, test1);
		Extent_completed(testCaseName, test, test1);
	}
}