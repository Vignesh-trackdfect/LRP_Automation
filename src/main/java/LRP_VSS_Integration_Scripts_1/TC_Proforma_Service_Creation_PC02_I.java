package LRP_VSS_Integration_Scripts_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Proforma_Service_Creation_PC02_I extends Keywords {

	public void draftToConfirm(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String testcase_Name="TC_Proforma_Service_Creation_PC02_I";
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String ModuleSearch = Excel_data.get("Module_Search");
		String proformaCode = Excel_data.get("ProformaCode");
		String boundPopup = Excel_data.get("BoundPopup");
		String proformaUpdatedPopup = Excel_data.get("ProformaUpdatedPopup");
		String greenColor = Excel_data.get("GreenColor");
		String proforma_Status = Excel_data.get("ProformaStatus");
		String search2 = Excel_data.get("Search_Input_2");
		String search3 = Excel_data.get("Search_Input_3");
		String Ports_Status = Excel_data.get("Ports_Status");
		  String dropdownCondition = Excel_data.get("DropdownCondition");
	        String globalSearchValueType = Excel_data.get("GlobalSearchValueType");
			String To_Port_Search = Excel_data.get("To_Port_Search");
			String From_Port_Search = Excel_data.get("From_Port_Search");
			String Location_Code_Header = Excel_data.get("Location_Code_Header");
			String condition_Filter = Excel_data.get("condition_Filter");
			String bound_Select = Excel_data.get("Bound");




		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);


		moduleNavigate(driver, ModuleSearch);
		
		
//Retrieve the existing  record by Global Search		
		Step_Start(1, "Click on the search icon", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
        click(driver,SearchButton_Toolbar);
		Step_End(1, "Click on the search icon", test, test1);
		
		Step_Start(2, "Retrieve the existing record", test, test1);

		globalValueSearchWindow(driver, dropdownCondition, globalSearchValueType, proformaCode, "", "", "", "");
	
	
		 waitForDisplay(driver, Proforma_Temp_Remove);
			if(isdisplayed(driver, Proforma_Temp_Remove)){
				waitForElement(driver, Proforma_Temp_Remove);
				click(driver, Proforma_Temp_Remove);
			}	
		Step_End(2, "Retrieve the existing record", test, test1);
		
		Step_Start(3, "Select the status as “Confirmed” from the status drop down", test, test1);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
//Change status			
		
		if(!proforma_Status.equals("")) {
			waitForElement(driver, status_Dropdown_SPF);
			click(driver,status_Dropdown_SPF);
			
			String select_Status=String.format(DropDown_Select,proforma_Status);
			
			waitForElement(driver, select_Status);
			click(driver, select_Status);
		}
		
		
		waitForElement(driver, proformaStatus);
		String StatusDropdownoption=getText(driver, proformaStatus);
		System.out.println(StatusDropdownoption);
		
		if(StatusDropdownoption.equals(proforma_Status)) {
			Extent_pass_New(driver, "Matched || Expected :"+proforma_Status+" || Actual :"+StatusDropdownoption, test,test1);
			System.out.println("Matched || Expected :"+proforma_Status+" || Actual :"+StatusDropdownoption);
		}else {
			System.out.println("Not Matched || Expected :"+proforma_Status+" || Actual :"+StatusDropdownoption);

			Extent_fail(driver, "Not Matched || Expected :"+proforma_Status+" || Actual :"+StatusDropdownoption, test,test1);
		}

		Step_End(3, "Select the status as “Confirmed” from the status drop down", test, test1);
		
		Step_Start(4, "Click On Save Button", test, test1);
		
		scrollTop(driver);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		Step_End(4, "Click On Save Button", test, test1);
//Bound popup			
		Step_Start(5, "IF the proforma doesn’t have splitted the bound,System should show the validation as Enter the bound Details", test, test1);
		waitForDisplay(driver, popup_Message);
		if(isdisplayed(driver, popup_Message)) {
		String boundmessage =getText(driver, popup_Message);
		Step_Start(6, "CLick on Save button", test, test1);

		if(boundmessage.equals(boundPopup)) {
			Extent_pass_New(driver, "Matched || Expected popup :"+boundPopup+" || Actual popup :"+boundmessage, test,test1);
			System.out.println("Matched || Expected popup :"+boundPopup+" || Actual popup :"+boundmessage);
			click(driver, popup_Message_Ok_Button);
			
			
			waitForElement(driver, bound_Gridcell);
			doubleClick(driver, bound_Gridcell);
			
			String selectBound=String.format(select_Bound, bound_Select);
			waitForElement(driver, selectBound);
			click(driver, selectBound);
			
			scrollTop(driver);

			waitForElement(driver, SaveButton_ToolBar);
			click(driver,SaveButton_ToolBar);
			
		}

		}
		Step_End(5, "IF the proforma doesn’t have splitted the bound,System should show the validation as Enter the bound Details", test, test1);
		Step_End(6, "CLick on Save button", test, test1);

//Proforma updated popup
		
		Step_Start(7, "system should show the validation as the PRoforma is Confirmed ", test, test1);
		waitForPopup(driver, popup_Message, proformaUpdatedPopup);
		String actualUpdatedPopup = getText(driver, popup_Message);

		if (actualUpdatedPopup.equals(proformaUpdatedPopup)) {
			Extent_pass_New(driver, "Matched || Expected popup :"+proformaUpdatedPopup+" || Actual popup :"+actualUpdatedPopup, test,test1);
			System.out.println("Matched || Expected popup :"+proformaUpdatedPopup+" || Actual popup :"+actualUpdatedPopup);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not Matched || Expected popup :"+proformaUpdatedPopup+" || Actual popup :"+actualUpdatedPopup);

			Extent_fail(driver, "Not Matched || Expected popup :"+proformaUpdatedPopup+" || Actual popup :"+actualUpdatedPopup, test,test1);
		}
		Step_End(7, "system should show the validation as the PRoforma is Confirmed ", test, test1);
		
		Step_Start(8, "Highlighted with Green background in the proforma code", test, test1);
         
		waitForElement(driver, proforma_code);
		String actualColorCode = getTextBackgroundColor(driver, proforma_code);
		String actualColor = getColorName(actualColorCode);
		
		if (actualColor.equals(greenColor)) {
			Extent_pass_New(driver, "Matched || Expected color :"+greenColor+" || Actual color :"+actualColor, test,test1);
			System.out.println("Matched || Expected color :"+greenColor+" || Actual color :"+actualColor);	
			Extent_pass_New(driver, "The background color of Proforma code textfield is Green", test, test1);
			System.out.println("The background color of Proforma code textfield is Green");
		}else {
			System.out.println("Not Matched || Expected color :"+greenColor+" || Actual color :"+actualColor);

			Extent_fail(driver, "Not Matched || Expected color :"+greenColor+" || Actual color :"+actualColor, test,test1);
		}
		Step_End(8, "Highlighted with Green background in the proforma code", test, test1);
		
		ArrayList<String> portName = new ArrayList<String>();
		waitForDisplay(driver, Ports_codes);
		List<WebElement> Ports_code = listOfElements(driver, Ports_codes);

		for (WebElement Ports : Ports_code) {

			String name = Ports.getText();

			System.out.println(name);
			portName.add(name);
		}
		horizontalscroll(driver, scroll_P, 3500);

		ArrayList<String> Distance = new ArrayList<String>();
		waitForDisplay(driver, Distance_codes);

		List<WebElement> Distance_code = listOfElements(driver, Distance_codes);

		for (WebElement distance : Distance_code) {

			String name = distance.getText();

			System.out.println(name);

			Distance.add(name);
		}
		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);
		Extent_call(test, test1, "Open Marine Distance Module");

		moduleNavigate(driver, search2);


		for (int k = 0; k < portName.size(); k++) {
			if (k + 1 >= portName.size()) {
				break;
			}

			scrollTop(driver);
			
			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow1(driver, condition_Filter, From_Port_Search, portName.get(k), To_Port_Search, portName.get(k + 1), "", "");
			
			waitForDisplay(driver, Popup_Message);
			if (isDisplayed(driver, Popup_Message)) {

				System.out.println("***distance was not found for***" + portName.get(k) + "***" + portName.get(k + 1));
				Extent_pass_New(driver, "***distance is not available for the port pair ***" + portName.get(k) + "***"
						+ portName.get(k + 1), test, test1);
				waitForElement(driver, globalSearchCloseIcon_L);
				safeclick(driver, globalSearchCloseIcon_L);

			} else {

				System.out.println("Expected result is : distance should  be found || Actual Result is : Distance is  found");
				Extent_pass_New(driver, "Expected result is : distance should  be found || Actual Result is : Distance is  found", test, test1);
			}

			waitForDisplay(driver, retrivedGlobalValue);
			if(isdisplayed(driver, retrivedGlobalValue)) {
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);
			elementnotvisible1(driver, SelectButton);

				waitForElement(driver, Distance_GRidcell_MD);
				String distance_value = getText(driver, Distance_GRidcell_MD);
				System.out.println(distance_value);
				System.out.println(Distance.get(k));

				if (Distance.get(k).contains(distance_value)) {
					Extent_pass_New(driver,
							"***Value taken from long term***" + portName.get(k) + "***" + portName.get(k + 1)
									+ "******" + Distance.get(k) + "***Values taken from Distsnce***" + distance_value,
							test, test1);
					Extent_call(test, test1,
							"***Value taken from long term***" + portName.get(k) + "***" + portName.get(k + 1)
									+ "******" + Distance.get(k) + "***Values taken from Distsnce***" + distance_value);
					System.out.println("Expected result is : distance should  be equal || Actual Result is : Distance is  equal");

				} else {
					System.out.println("Expected result is : distance should  be equal || Actual Result is : Distance is  equal");

					Extent_pass_New(driver,
							"***Value taken from long term***" + portName.get(k) + "***" + portName.get(k + 1)
									+ "******" + Distance.get(k) + "***Values taken from Distsnce***" + distance_value,
							test, test1);

				}

			} else {

				System.out.println("Expected result is : distance should  be found || Actual Result is : Distance is  found");
				Extent_pass_New(driver, "Expected result is : distance should  be found || Actual Result is : Distance is  found", test, test1);

			}
		}
			
		
		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);
		Extent_call(test, test1, "Open Ports Module");

		moduleNavigate(driver, search3);

		
		for (int D = 0; D < portName.size(); D++) {

			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, condition_Filter, Location_Code_Header, portName.get(D), "", "", "", "");
			
			Extent_call(test, test1, "Verify the status of port code");
			waitForElement(driver, Statusforport);
			String Port_status = getText(driver, Statusforport);
			System.out.println(Port_status);
			if (Port_status.equals(Ports_Status)) {
				Extent_pass_New(driver, "**Port code of**" + portName.get(D) + "**Status shown as**" + Port_status, test,
						test1);
			} else {
				System.out.println("Expected result is : ports should  be Active || Actual Result is : Ports is active");
				Extent_fail(driver, "Expected result is : ports should  be Active || Actual Result is : Ports is active", test, test1);
			}
		}

		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);
		
		Extent_completed(testcase_Name, test, test1);

	}

}