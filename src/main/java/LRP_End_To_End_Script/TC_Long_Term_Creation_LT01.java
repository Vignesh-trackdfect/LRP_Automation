package LRP_End_To_End_Script;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Long_Term_Creation_LT01 extends Keywords {

	public void Long_Term_Creation_LT01(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {
		String testcase_Name = "TC_Long_Term_Creation_LT01";

		String Search = Excel_data.get("Search_input");
		String Service_Code_new = Excel_data.get("Service_Code_new");
		String New_Proforma_code = Excel_data.get("New_Proforma_code");
		String To_Cycle = Excel_data.get("To_Cycle");
		String All_proforma_perform = Excel_data.get("All_proforma_perform");
		String Add_Vessels_Perform = Excel_data.get("Add_Vessels_Perform");
		String Add_TBN_Vessels_Perform = Excel_data.get("Add_TBN_Vessels_Perform");
		String Add_Empty_Vessels_Perform = Excel_data.get("Add_Empty_Vessels_Perform");
		String Add_Vessels = Excel_data.get("Add_Vessels");
		String Add_TBN_Vessels = Excel_data.get("Add_TBN_Vessels");
		String Add_Empty_Vessels = Excel_data.get("Add_Empty_Vessels");
		String Add_Voyage_Number = Excel_data.get("Add_Voyage_Number");
		String Increment_Voyage = Excel_data.get("Increment_Voyage");
		String Long_term_saved_pop_exp = Excel_data.get("Long_term_saved_pop_exp");
		String Vessels_verify_perform = Excel_data.get("Vessels_verify_perform");
		String Search_input_1 = Excel_data.get("Search_input_1");
		String dropdown_Condition = Excel_data.get("dropdown_Condition");
		String Vessel_Code_Search = Excel_data.get("Vessel_Code_Search");
		String Service_Code_Header = Excel_data.get("Service_Code_Header");
		String Condition_Filter = Excel_data.get("Condition");
		String Proforma_Code_Header = Excel_data.get("Proforma_Code_Header");
		String Vessel_Code_Header = Excel_data.get("Vessel_Code_Header");
		String Pop_up_for_confirm  = Excel_data.get("Pop_up_for_confirm");
		String Voyage_Confirmed_popEXP  = Excel_data.get("Voyage_Confirmed_pop");

		Extent_Start(testcase_Name, test, test1);
		moduleNavigate(driver, Search_input_1);
		waitForElement(driver, switchButton);
		safeclick(driver, switchButton);
		if (Vessels_verify_perform.equals("YES")) {
			List<String> datas = splitAndExpand(Add_Vessels);
			for (String data1 : datas) {
				waitForElement(driver, SearchButton_Toolbar);
				safeclick(driver, SearchButton_Toolbar);
				globalValueSearchWindow(driver, dropdown_Condition, Vessel_Code_Search, data1, "", "", "", "");
				waitForElement(driver, vesselCode_In_Vessel);
				String Vesselscode = getAttribute(driver, vesselCode_In_Vessel, "value");
				System.out.println(Vesselscode);
				waitForElement(driver, statusDropDown);
				String Vesselscodestatus = getText(driver, statusDropDown);
				System.out.println(Vesselscodestatus);
			}
		} else {
			System.out.println("Expected Result is : Equipment type should not be added || Actual Result is : Equipment type is not  added");
		}
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		// searching for module
		moduleNavigate(driver, Search);
		Step_Start(1, "click on new button ", test, test1);
		newButton(driver);
		Step_End(1, "click on new button ", test, test1);
		waitForElement(driver, Globalsearchservice);
		safeclick(driver, Globalsearchservice);
		Step_Start(2, "Enter the service code in service field ", test, test1);
		twoColumnSearchWindow(driver, Service_Code_Header,Condition_Filter, Service_Code_new);
		Step_End(2, "Enter the service code in service field ", test, test1);
		// selecting all proforma box
		Step_Start(3, "Select the proforma code from the Proforma code drop down ", test, test1);
		waitForElement(driver, Allproformabox);
		checkBox(driver, Allproformabox, All_proforma_perform);
		waitForElement(driver, PerformaCodeSearch);
		safeclick(driver, PerformaCodeSearch);
		twoColumnSearchWindow(driver,Proforma_Code_Header, Condition_Filter, New_Proforma_code);
		Step_End(3, "Select the proforma code from the Proforma code drop down", test, test1);
		Step_Start(4, "Enter the number of cycles that each vessel has to be run in the To cycle field", test, test1);
		waitForElement(driver, ToCycle);
		clearAndType(driver, ToCycle, To_Cycle);
		Step_End(4, "Enter the number of cycles that each vessel has to be run in the To cycle field", test, test1);
		Step_Start(5, "safeclick on Vessel Add icon and choose the number of actual vessels needed ", test, test1);
		if (Add_Vessels_Perform.equals("YES")) {
			List<String> datas = splitAndExpand(Add_Vessels);
			for (String data1 : datas) {
				waitForElement(driver, AddVessels);
				safeclick(driver, AddVessels);
				twoColumnSearchWindow(driver,Vessel_Code_Header, Condition_Filter, data1);
			}
		} else {
			System.out.println("Expected Result is : Vessels should not selected || Actual Result is : Vessel is not selected ");
		}
		Step_End(5, "safeclick on Vessel Add icon and choose the number of actual vessels needed ", test, test1);
		Step_Start(6,
				"If the voyage needs To-be Notifed vessels. Enter the number of TBN vessels in the field and safeclick on Add icon",
				test, test1);
		if (Add_TBN_Vessels_Perform.equals("YES")) {
			waitForElement(driver, NOOFTBM);
			safeclick(driver, NOOFTBM);
			waitForElement(driver, NOOFTBMInput);
			clearAndType(driver, NOOFTBMInput, Add_TBN_Vessels);
			waitForElement(driver, NOOFTBMInputAdd);
			safeclick(driver, NOOFTBMInputAdd);
		} else {
			System.out.println("Expected Result is : TBM Vessels should not selected || Actual Result is : TBM Vessel is not selected ");
		}
		Step_End(6,
				"If the voyage needs To-be Notifed vessels. Enter the number of TBN vessels in the field and safeclick on Add icon",
				test, test1);
		Step_Start(7,
				"f the voyage needs blank vessels. Enter the number of Blank vessels in the field and safeclick on Add icon",
				test, test1);
		if (Add_Empty_Vessels_Perform.equals("YES")) {
			waitForElement(driver, NOOFTBMEMTY);
			safeclick(driver, NOOFTBMEMTY);
			waitForElement(driver, NOOFTBMInputEMTY);
			clearAndType(driver, NOOFTBMInputEMTY, Add_Empty_Vessels);
			waitForElement(driver, NOOFTBMInputAddEMTY);
			safeclick(driver, NOOFTBMInputAddEMTY);
		} else {
			System.out.println("Expected Result is : Empty Vessels should not selected || Actual Result is : Empty Vessel is not selected ");
		}
		Step_End(7,
				"f the voyage needs blank vessels. Enter the number of Blank vessels in the field and safeclick on Add icon",
				test, test1);
		Step_Start(8, "Enter the Voyage number for the each vessel added ", test, test1);
		waitForElement(driver, Voyagenumberinput);
		try {
			List<WebElement> Selected_Data = listOfElements(driver, voyage_input);
			List<String> datas = splitAndExpand(Add_Voyage_Number);
			for (int i = 0; i < Selected_Data.size(); i++) {
				waitForElement(driver, Voyagenumberinput);
				Click(driver, Selected_Data.get(i));
				Selected_Data.get(i).sendKeys(datas.get(i));
				waitForElement(driver, Voyagenumberinput);
				Click(driver, Selected_Data.get(i));
			}
		} catch (Exception e) {
			Extent_fail(driver,  " Element is not present "+ e.getLocalizedMessage(), test,test1);
		}
		Step_End(8, "Enter the Voyage number for the each vessel added ", test, test1);
		waitForElement(driver, afterclick);
		safeclick(driver, afterclick);
		Step_Start(9, "Enter the number to be added to the voyage number for the next cycle voyage of the same vessel ",
				test, test1);
		waitForElement(driver, Voyagenumberinput);
		try {
			List<WebElement> Selected_Data1 = listOfElements(driver, INcrement_voyage_input);
			List<String> datas1 = splitAndExpand(Increment_Voyage);
			System.out.println("data: " + datas1.get(0));
			for (int i = 0; i < Selected_Data1.size(); i++) {
				Click(driver, Selected_Data1.get(i));
				Newclear_Type(driver);
				Selected_Data1.get(i).sendKeys(Keys.ENTER);
				waitForElement(driver, Voyagenumberinput);
				Selected_Data1.get(i).sendKeys(datas1.get(i) + Keys.ENTER);
				waitForElement(driver, Voyagenumberinput);
			}
		} catch (Exception e) {
			Extent_fail(driver,  " Element is not present "+ e.getLocalizedMessage(), test,test1);
		}
		Step_End(9, "Enter the number to be added to the voyage number for the next cycle voyage of the same vessel ",
				test, test1);
		Step_Start(10, "safeclick on Make Long Term", test, test1);
		waitForElement(driver, Makelongterm);
		safeclick(driver, Makelongterm);
		Step_End(10, "safeclick on Make Long Term", test, test1);
		Step_Start(12, "safeclick on save button", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		safeclick(driver, SaveButton_ToolBar);
		scrollBottom(driver);
		Step_End(12, "safeclick on save button", test, test1);
		waitForPopup(driver, popup_Message, Long_term_saved_pop_exp);
		String savedpopAct = getText(driver, popup_Message);
		System.out.println(savedpopAct);
		if (Long_term_saved_pop_exp.equals(savedpopAct)) {
			System.out.println("Matched || " + " Expected popup is : " + Long_term_saved_pop_exp
					+ " || Actual popup is : " + savedpopAct);
			Extent_pass_New(driver, "Matched || " + " Expected popup is : " + Long_term_saved_pop_exp
					+ " || Actual popup is : " + savedpopAct, test, test1);
		} else {
			System.out.println("Not matched || " + " Expected popup is : " + Long_term_saved_pop_exp
					+ " || Actual popup is : " + savedpopAct);
			Extent_fail(driver, "Not matched || " + " Expected popup is : " + Long_term_saved_pop_exp
					+ " || Actual popup is : " + savedpopAct, test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		String Long_number = getAttribute(driver, Long_term_Number, "value");
		System.out.println(Long_number);
		Extent_call(test, test1, "****Long_term number was created as*** " + Long_number);
		scrollBottom(driver);
		Step_Start(11,
				"System should create the number of voyages which equals total number of cycles multiplied with the total number of vessels",
				test, test1);
		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);
		scrollBottom(driver);
		waitForElement(driver, vessels_code);
		List<WebElement> vessel_Codes11 = listOfElements(driver, vessels_code);
		for (int i = 0;i<vessel_Codes11.size();i++) {
			String vessel_Code = String.format(LT_Vessel_Codes, i+1);
			waitForElement(driver, vessel_Code);
			mouseOverToElement(driver, vessel_Code);
			waitForElement(driver, vessel_Code);
			click(driver, vessel_Code);
			waitForElement(driver, vessel_Code);
			RightClick(driver, vessel_Code);
			waitForElement(driver, Conformbtnlongterm);
			safeclick(driver, Conformbtnlongterm);
			waitForPopup(driver, popup_Message, Pop_up_for_confirm);
			String wantconformAct=getText(driver, popup_Message);
			System.out.println(wantconformAct);
			if (wantconformAct.equals(Pop_up_for_confirm)) {
				System.out
				.println("Matched || " + " Expected Popup is : " + Pop_up_for_confirm + " || Actual Popup is : " + wantconformAct);
				Extent_pass_New(driver,
						"Matched || " + " Expected Popup is : " + Pop_up_for_confirm + " || Actual Popup is : " + wantconformAct,test,test1);
			} else {
				System.out.println(
						"Not matched || " + " Expected Popup is : " + Pop_up_for_confirm + " || Actual Popup is : " + wantconformAct);
				Extent_fail(driver,
						"Not matched || " + " Expected Popup is : " + Pop_up_for_confirm + " || Actual Popup is : " + wantconformAct,test,test1);

			}
			waitForElement(driver, popup_Message_Yes_Button);
			safeclick(driver, popup_Message_Yes_Button);
			waitForDisplay(driver, continuebutton);
			if(isdisplayed(driver, continuebutton)) {
				waitForElement(driver, continuebutton);
				safeclick(driver, continuebutton);
			}else {
				System.out.println("Expected Result is : Continue Button should not diplayed ||  Actual Result is : Continue Button is not diplayed");
			}
			Step_End(7, "System should show a pop message of confirming to user to change the status  ",test, test1);

			waitForElement(driver, popup_Message_Ok_Button);
			Step_Start(9, "System should show a pop up message of “Voyage Confirmed”",test, test1);
			Step_Start(10, "verify that that should be white colour ang have popup for that validation.",test, test1);
			waitForPopup(driver, popup_Message, Voyage_Confirmed_popEXP);
			String Voyage_Confirmed_popAct =getText(driver, popup_Message);
			System.out.println(Voyage_Confirmed_popAct);
			if (Voyage_Confirmed_popEXP.equals(Voyage_Confirmed_popAct)) {
				System.out
				.println("Matched || " + " Expected popup is : " + Voyage_Confirmed_popEXP + " || Actual popup is : " + Voyage_Confirmed_popAct);
				Extent_pass_New(driver,
						"Matched || " + " Expected popup is : " + Voyage_Confirmed_popEXP + " || Actual popup is : " + Voyage_Confirmed_popAct,test,test1);
				Extent_pass_New(driver, "**********Voyage was conformed and background was changed to white colour********", test, test1);
			} else {
				System.out.println(
						"Not matched || " + " Expected popup is : " + Voyage_Confirmed_popEXP + " || Actual popup is : " + Voyage_Confirmed_popAct);
				Extent_fail(driver,
						"Not matched || " + " Expected popup is : " + Voyage_Confirmed_popEXP + " || Actual popup is : " + Voyage_Confirmed_popAct,test,test1);

			}
			Step_End(9, "System should show a pop up message of “Voyage Confirmed” ",test, test1);
			waitForElement(driver, popup_Message_Ok_Button);
			safeclick(driver, popup_Message_Ok_Button);	
		}
		Step_End(11,
				"System should create the number of voyages which equals total number of cycles multiplied with the total number of vessels",
				test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}