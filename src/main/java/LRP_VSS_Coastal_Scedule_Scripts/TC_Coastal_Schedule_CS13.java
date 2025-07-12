package LRP_VSS_Coastal_Scedule_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS13 extends Keywords{

	public void Coastal_Schedule_CS13(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Coastal_Schedule_CS13";

		String Remark_Type_CS13 = Excel_data.get("Remark_Type");
		String Remark_Input_CS13 = Excel_data.get("Remark_Input");
		String move_coastal_CS13 = Excel_data.get("Moveto_Coastal");
		String remark_updated_CS13 = Excel_data.get("Remark_Updated");
		String Username_CS13 =Excel_data.get("Username");
		String Password_CS13 =Excel_data.get("Password");
		String ModuleSearch_CS13 =Excel_data.get("Module_Search");
		String ServiceCode_CS13 =Excel_data.get("Service_Code"); 
		String VesselCode_CS13 =Excel_data.get("Vessel_Code");
		String voyageNumber_CS13 =Excel_data.get("Voyage_Number");
		String portName_CS13 =Excel_data.get("Port_Name");
		String remark_Button_CS13 =Excel_data.get("Button");
		String Phase_Out_Popup =Excel_data.get("Phase_Out_Popup");
		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");

		String Voyage_Toggler = String.format(Coastal_Schedule_Locators.Voyage_Toggler, voyageNumber_CS13);
		String port_Select = String.format(Coastal_Schedule_Locators.port_Select, voyageNumber_CS13,portName_CS13);
		String button_Select =  String.format(Coastal_Schedule_Locators.button_Select, remark_Button_CS13);
		String remark_Type_Select =  String.format(Coastal_Schedule_Locators.remark_Type_Select, Remark_Type_CS13);


		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);
		
		LRP_Login(driver, Username_CS13, Password_CS13);
		
		moduleNavigate(driver, ModuleSearch_CS13);


		Step_Start(1, "Enter the Service Code  in the service code field", test, test1);
		
		waitForElement(driver, Service_Search_Btn);
		click(driver, Service_Search_Btn);
		
		twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS13);
		

		Step_End(1, "Enter the Service Code  in the service code field", test, test1);

		waitForElement(driver, Vessel_Search_Btn);
		click(driver, Vessel_Search_Btn);

		twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS13);

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
		waitForElement(driver, Voyage_Toggler);
		String status = getAttribute(driver, Voyage_Toggler, "class");

		if(!status.contains("s")) {
			waitForElement(driver, Voyage_Toggler);
			click(driver, Voyage_Toggler);
		}

		Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);

		Step_Start(4, "Choose the Port from the voyage where the Remarks to be added", test, test1);
		Step_Start(5, "Right click on it ", test, test1);
		waitForElement(driver, port_Select);
		click(driver, port_Select);
		waitForElement(driver, port_Select);
		RightClick(driver, port_Select);
		Step_End(5, "Right click on it ", test, test1);

		waitForElement(driver, button_Select);
		click(driver, button_Select);

		Step_End(4, "Choose the Port from the voyage where the Remarks to be added", test, test1);

		Step_Start(6, "Choose Remarks option", test, test1);
		waitForElement(driver, remark_Type_Select);
		click(driver, remark_Type_Select);
		Step_End(6, "Choose Remarks option", test, test1);

		Step_Start(7, "Enter the Remarks in the Field", test, test1);
		Step_Start(8, "Click on Add Button", test, test1);
		if(Remark_Type_CS13.equals("Normal Remarks")) {
			waitForElement(driver, Remarks_field);
			click(driver,Remarks_field);
			waitForElement(driver, Remarks_field);
			sendKeys(driver, Remarks_field, Remark_Input_CS13);
			waitForElement(driver, Remarks_addbtn);
			click(driver, Remarks_addbtn);

		}else if(Remark_Type_CS13.equals("Phase In Remarks")) {
			waitForElement(driver, PhaseIn_Field);
			click(driver,PhaseIn_Field);
			waitForElement(driver, PhaseIn_Field);
			sendKeys(driver, PhaseIn_Field, Remark_Input_CS13);
			waitForElement(driver, PhaseIn_Add);
			click(driver, PhaseIn_Add);

		}else {
			waitForElement(driver, PhaseOut_Field);
			click(driver,PhaseOut_Field);
			waitForElement(driver, PhaseOut_Field);
			sendKeys(driver, PhaseOut_Field, Remark_Input_CS13);
			waitForElement(driver, PhaseOut_Add);
			click(driver, PhaseOut_Add);
		}

		Step_End(7, "Enter the Remarks in the Field", test, test1);
		Step_End(8, "Click on Add Button", test, test1);

		Step_Start(9, "Click on Move to Coastal button", test, test1);
		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
			String Phase_Out=getText(driver, popup_Message);
			System.out.println("Matched || Expected Popup : "+Phase_Out_Popup+" || Actual Popup : "+Phase_Out);
			Extent_pass_New(driver, "Matched || Expected Popup : "+Phase_Out_Popup+" || Actual Popup : "+Phase_Out, test,test1);
			click(driver, popup_Message_Ok_Button);
		}else {
			waitForElement(driver, moveto_coastal);
			click(driver,moveto_coastal);

			waitForPopup(driver, popup_Message, move_coastal_CS13);
			String Move_Coastal= getText(driver, popup_Message);

			if(Move_Coastal.equals(move_coastal_CS13)) {
				System.out.println("Matched || Expected Popup : "+move_coastal_CS13+" || Actual Popup : "+Move_Coastal);
				Extent_pass_New(driver, "Matched || Expected Popup : "+move_coastal_CS13+" || Actual Popup : "+Move_Coastal, test,test1);
			}else {
				System.out.println("NotMatched || Expected Popup : "+move_coastal_CS13+" || Actual Popup : "+Move_Coastal);
				Extent_fail(driver,  "NotMatched || Expected Popup : "+move_coastal_CS13+" || Actual Popup : "+Move_Coastal, test,test1);
			}  

			click(driver,popup_Message_Yes_Button);
			Step_End(9, "Click on Move to Coastal button", test, test1);

			Step_Start(10, "System should add the remarks in the grid of the voyage", test, test1);

			waitForPopup(driver, popup_Message, remark_updated_CS13);
			String Updated_Remark= getText(driver, popup_Message);

			if(Updated_Remark.equals(remark_updated_CS13)) {
				System.out.println("Matched || Expected Popup : "+remark_updated_CS13+" || Actual Popup : "+Updated_Remark);
				Extent_pass_New(driver, "Matched || Expected Popup : "+remark_updated_CS13+" || Actual Popup : "+Updated_Remark, test,test1);
			}else {
				System.out.println("NotMatched || Expected Popup : "+remark_updated_CS13+" || Actual Popup : "+Updated_Remark);
				Extent_fail(driver,  "NotMatched || Expected Popup : "+remark_updated_CS13+" || Actual Popup : "+Updated_Remark, test,test1);
			}  

			Step_End(10, "System should add the remarks in the grid of the voyage", test, test1);

			click(driver,popup_Message_Ok_Button);
		}
		Extent_completed(testCaseName, test, test1);

	}

}
