package LRP_Detention_Waiver_Scripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Detention_Waiver_TS_022 extends Keywords {

	public void Detention_Waiver_TS_022(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws EncryptedDocumentException, InvalidFormatException, IOException {

		String testcase_Name = "TC_Detention_Waiver_TS_022";
		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String Detention_Module = Excel_data.get("Detention_Module");
		String BookingSearch_Condition = Excel_data.get("BookingSearch_Condition");
		String BookingSearch_Option = Excel_data.get("BookingSearch_Option");
		String BL_Number = Excel_data.get("BL_Number");
		String Free_Days_Input = Excel_data.get("Free_Days_Input");
		String Value = Excel_data.get("Value");
		String Global_Attribute = Excel_data.get("Global_Attribute");
		String Global_Configration = Excel_data.get("Global_Configration");
		String Waiver_Reason_Header = Excel_data.get("Waiver_Reason_Header");
		String Search_Condition = Excel_data.get("Search_Condition");
		String Reason = Excel_data.get("Reason");
		String Remark = Excel_data.get("Remark");
		String Submitted_Popup = Excel_data.get("Submitted_Popup");
		String Approved_Popup = Excel_data.get("Approved_Popup");
		String Validation_pop_expected = Excel_data.get("Validation_pop_expected");
		String Value_Reset = Excel_data.get("Value_Reset");
		String Value_Reset_Perform = Excel_data.get("Value_Reset_Perform");
		String Expected_Status = Excel_data.get("Expected_Status");
		String Seletct_Container_All = Excel_data.get("Seletct_Container_All");
		String Container_number_Add = Excel_data.get("Container_number_Add");
		String DetentionStorage_Option = Excel_data.get("DetentionStorage_Option");
		String Weiver_For = Excel_data.get("Weiver_For");
		String Incl_Excl_Dropdown_Value = Excel_data.get("Incl_Excl_Dropdown_Value");
		String GlobalSearch_Condition = Excel_data.get("GlobalSearch_Condition");
		String WantToCancel_Waiver = Excel_data.get("WantToCancel_Waiver");
		String SearchType_WaiverNumer = Excel_data.get("SearchType_WaiverNumer");
		String Reset_Global_Configuration = Excel_data.get("Reset_Global_Configuration");

		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		SwitchProfile(driver, AgencyName);

		verifyMainMenu(driver);
		setGlobalConfiguration(driver, Global_Configration, Global_Attribute, Value);

		Step_Start(1, "Open Detention weiver Module", test, test1);
		
		moduleNavigate(driver, Detention_Module);
		Step_End(1, "Open Detention weiver Module", test, test1);


		newButton(driver);
		String Waiveroption = String.format(DW_WaiverOption, Weiver_For);

		waitForElement(driver, DW_WaiverFor);
		click(driver, DW_WaiverFor);
		waitForElement(driver, Waiveroption);
		click(driver, Waiveroption);
		Step_Start(2, "Click on BL No Search Field", test, test1);
		waitForElement(driver, DW_BookingNo_Search);
		click(driver, DW_BookingNo_Search);

		Step_End(2, "Click on BL No Search Field", test, test1);

		Step_Start(3, "Input your Confirm BL No", test, test1);

		globalValueSearchWindow(driver, BookingSearch_Condition, BookingSearch_Option, BL_Number, "", "", "", "");

		Step_End(3, "Input your Confirm BL No", test, test1);

		Step_Start(4, " Click on show Button select the Row in Container Section", test, test1);
		String selectoptions = String.format(DW_DetentionStorageOption, DetentionStorage_Option);

		waitForElement(driver, selectoptions);
		click(driver, selectoptions);

		waitForElement(driver, DW_Show);
		click(driver, DW_Show);
		Step_End(4, " Click on show Button select the Row in Container Section", test, test1);

		scrollElementToView(driver, Detention_container_Filter);
		List<String> ContainersList = new ArrayList<String>();

		if (Seletct_Container_All.equalsIgnoreCase("Yes")) {
			List<WebElement> containerTable = listOfElements(driver, DW_Containers_Column);
			for (WebElement ele : containerTable) {
				String eletext = ele.getText();
				ContainersList.add(eletext);
			}

			waitForDisplay(driver, DW_Select_All_Checkbox);
			jsClick(driver, DW_Select_All_Checkbox);

		} else {


			waitForElement(driver, Detention_container_Filter);
			click(driver, Detention_container_Filter);
			List<String> Containers_Select = splitAndExpand(Container_number_Add);
			for (String container : Containers_Select) {
				waitForElement(driver, Detention_container_Filter_input);
				clear(driver, Detention_container_Filter_input);
			
				waitForElement(driver, Detention_container_Filter_input);
				sendKeys(driver, Detention_container_Filter_input, container);
				
				String containerInput = String.format(DW_Select_Container_Checkbox, container);
				mouseOverToElement(driver, containerInput);
				waitForDisplay(driver, containerInput);
				jsClick(driver, containerInput);
				waitForElement(driver, Detention_container_Filter_input);
				clear(driver, Detention_container_Filter_input);
			
			}
			ContainersList.addAll(Containers_Select);
		
		}

		Step_Start(5, "Click on Free time Radio Button ", test, test1);
		scrollBottom(driver);
		
		
		waitForElement(driver, Addtional_free_days_radio_button);
		click(driver, Addtional_free_days_radio_button);


		Step_End(5, "Click on Free time Radio Button ", test, test1);

		isElementEnabled(driver, DW_Additional_Free_Days);
		waitForElement(driver, DW_Additional_Free_Days);
		doubleClick(driver, DW_Additional_Free_Days);

		Step_Start(6, "add the max value in the Free time ", test, test1);

		Newclear(driver, DW_Additional_Free_Days);

		sendKeys(driver, DW_Additional_Free_Days, Free_Days_Input);

		Step_End(6, "add the max value in the Free time ", test, test1);

		waitForElement(driver, EX_IN_Field);
		click(driver, EX_IN_Field);

		formatLocatorClick(driver, DropDown_Select, Incl_Excl_Dropdown_Value);

		Step_Start(7, "click on (+) Button", test, test1);
		waitForElement(driver, DW_Add_button);
		click(driver, DW_Add_button);
		Step_End(7, "click on (+) Button", test, test1);

		scrollTop(driver);
		scrollUsingElement(driver, DW_Remarks);

		waitForElement(driver, DW_Remarks);
		click(driver, DW_Remarks);

		sendKeys(driver, DW_Remarks, Remark);
		scrollTop(driver);
		if (isdisplayed(driver, DW_ReasonSearch)) {

			waitForElement(driver, DW_ReasonSearch);
			click(driver, DW_ReasonSearch);

			twoColumnSearchWindow(driver, Waiver_Reason_Header, Search_Condition, Reason);

		}

		scrollTop(driver);

		scrollElementToCenter(driver, DW_Submitted);
		waitForElement(driver, DW_Submitted);
		click(driver, DW_Submitted);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, Submitted_Popup);
		String Submit_popup_Message = getText(driver, Popup_Message);

		if (Submit_popup_Message.equals(Submitted_Popup)) {

			System.out.println("Detention Waiver submitted successfully || Expected popup : " + Submitted_Popup
					+ " || Actual popup : " + Submit_popup_Message);
			Extent_pass_New(driver, "Detention Waiver submitted successfully || Expected popup : " + Submitted_Popup
					+ " || Actual popup : " + Submit_popup_Message, test, test1);

		} else {
			System.out.println("Detention Waiver not submitted || Expected popup : " + Submitted_Popup
					+ " || Actual popup : " + Submit_popup_Message);
			Extent_fail(driver, "Detention Waiver not submitted || Expected popup : " + Submitted_Popup
					+ " || Actual popup : " + Submit_popup_Message, test, test1);

		}

		waitForElement(driver, DW_WaiverNo);
		String waiverNumbers=getAttribute(driver, DW_WaiverNo, "value");
		System.out.println("DW_WaiverNo : "+waiverNumbers);
		
		String [] waiverNumber =waiverNumbers.split(" ~~");
		System.out.println("waiverNumber :"+waiverNumber[0]);
		
		ResetProfile(driver);

		moduleNavigate(driver, Detention_Module);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);

		globalValueSearchWindow1(driver, BookingSearch_Condition, BookingSearch_Option, BL_Number, "", "", "", "");

		Scroll_ElementVisible(driver, DW_Waiverstatus_SearchInput, DW_SearchScroll);

		waitForElement(driver, DW_Waiverstatus_SearchInput);
		sendKeys(driver, DW_Waiverstatus_SearchInput, Expected_Status);

		waitForElement(driver, retrivedGlobalValue);
		click(driver, retrivedGlobalValue);
		waitForElement(driver, SelectButton);
		click(driver, SelectButton);
		elementnotvisible1(driver, SelectButton);

		scrollTop(driver);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		scrollElementToView(driver, Detention_container_Filter);

		List<String> ContainersList1 = new ArrayList<String>();

		if (Seletct_Container_All.equalsIgnoreCase("Yes")) {
			List<WebElement> containerTable = listOfElements(driver, DW_Containers_Column);
			for (WebElement ele : containerTable) {
				String eletext = ele.getText();
				ContainersList1.add(eletext);
			}

			waitForDisplay(driver, DW_Select_All_Checkbox);
			jsClick(driver, DW_Select_All_Checkbox);

		} else {
			
			waitForElement(driver, Detention_container_Filter);
			click(driver, Detention_container_Filter);
			List<String> Containers_Select = splitAndExpand(Container_number_Add);
			for (String container : Containers_Select) {
				waitForElement(driver, Detention_container_Filter_input);
				clear(driver, Detention_container_Filter_input);
			
				waitForElement(driver, Detention_container_Filter_input);
				sendKeys(driver, Detention_container_Filter_input, container);
				
				String containerInput = String.format(DW_Select_Container_Checkbox, container);
				mouseOverToElement(driver, containerInput);
				waitForDisplay(driver, containerInput);
				jsClick(driver, containerInput);
				waitForElement(driver, Detention_container_Filter_input);
				clear(driver, Detention_container_Filter_input);
			
			}
			
			ContainersList1.addAll(Containers_Select);
		}
		waitForElement(driver, DW_Remarks);
		click(driver, DW_Remarks);

		sendKeys(driver, DW_Remarks, Remark);
		scrollTop(driver);

		if (isdisplayed(driver, DW_ReasonSearch)) {

			waitForElement(driver, DW_ReasonSearch);
			click(driver, DW_ReasonSearch);

			twoColumnSearchWindow(driver, Waiver_Reason_Header, Search_Condition, Reason);

		}
		Step_Start(8,
				"Verify the MsgThis is Additional Waiver kindly use Exclusive option for Container(s) ( Container No )\r\n"
						+ "",
				test, test1);
		waitForElement(driver, DW_Approved);
		click(driver, DW_Approved);

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		waitForElement(driver, Popup_Message);
		String Submit_popup_Message_LINE = getText(driver, Popup_Message);
		System.out.println(Submit_popup_Message_LINE);
		if (Approved_Popup.equals(Submit_popup_Message_LINE)) {

			System.out.println("Detention Waiver Approved successfully || Expected popup : " + Submit_popup_Message_LINE
					+ " || Actual popup : " + Approved_Popup);
			Extent_pass_New(driver, "Detention Waiver Approved successfully || Expected popup : "
					+ Submit_popup_Message_LINE + " || Actual popup : " + Approved_Popup, test, test1);

		} else {
			System.out.println("Detention Waiver not Approved || Expected popup : " + Submit_popup_Message_LINE
					+ " || Actual popup : " + Approved_Popup);
			Extent_fail(driver, "Detention Waiver not Approved || Expected popup : " + Submit_popup_Message_LINE
					+ " || Actual popup : " + Approved_Popup, test, test1);

		}

		waitForElement(driver, Switch_Profile);
		safeclick(driver, Switch_Profile);

		waitForElement(driver, Profile_Dropdown);
		safeclick(driver, Profile_Dropdown);

		waitForElement(driver, Corporate_Profile);
		safeclick(driver, Corporate_Profile);

		waitForElement(driver, Profile_Dropdown);
		safeclick(driver, Profile_Dropdown);

		waitForElement(driver, Location_Profile);
		safeclick(driver, Location_Profile);

		waitForElement(driver, Switch_Profile);
		safeclick(driver, Switch_Profile);

		SwitchProfile(driver, AgencyName);

		moduleNavigate(driver, Detention_Module);

		newButton(driver);

		waitForElement(driver, DW_WaiverFor);
		click(driver, DW_WaiverFor);

		formatLocatorClick(driver, DW_WaiverOption, Weiver_For);

		waitForElement(driver, DW_BookingNo_Search);
		click(driver, DW_BookingNo_Search);

		globalValueSearchWindow(driver, BookingSearch_Condition, BookingSearch_Option, BL_Number, "", "", "", "");

		waitForElement(driver, DW_Show);
		click(driver, DW_Show);

		scrollElementToView(driver, Detention_container_Filter);
		List<String> ContainersList11 = new ArrayList<String>();

		if (Seletct_Container_All.equalsIgnoreCase("Yes")) {
			List<WebElement> containerTable = listOfElements(driver, DW_Containers_Column);
			for (WebElement ele : containerTable) {
				String eletext = ele.getText();
				ContainersList11.add(eletext);
			}

			waitForDisplay(driver, DW_Select_All_Checkbox);
			jsClick(driver, DW_Select_All_Checkbox);

		} else {

			waitForElement(driver, Detention_container_Filter);
			click(driver, Detention_container_Filter);
			List<String> Containers_Select = splitAndExpand(Container_number_Add);
			for (String container : Containers_Select) {
				waitForElement(driver, Detention_container_Filter_input);
				clear(driver, Detention_container_Filter_input);
			
				waitForElement(driver, Detention_container_Filter_input);
				sendKeys(driver, Detention_container_Filter_input, container);
				
				String containerInput = String.format(DW_Select_Container_Checkbox, container);
				mouseOverToElement(driver, containerInput);
				waitForDisplay(driver, containerInput);
				jsClick(driver, containerInput);
				waitForElement(driver, Detention_container_Filter_input);
				clear(driver, Detention_container_Filter_input);
			
			}
			ContainersList.addAll(Containers_Select);
		
		}

		scrollUsingElement(driver, Addtional_free_days_radio_button);
		waitForElement(driver, Addtional_free_days_radio_button);
		click(driver, Addtional_free_days_radio_button);

		isElementEnabled(driver, DW_Additional_Free_Days);
		waitForElement(driver, DW_Additional_Free_Days);
		doubleClick(driver, DW_Additional_Free_Days);

		Newclear(driver, DW_Additional_Free_Days);
		sendKeys(driver, DW_Additional_Free_Days, Free_Days_Input);

		waitForElement(driver, EX_IN_Field);
		click(driver, EX_IN_Field);

		formatLocatorClick(driver, DropDown_Select, Incl_Excl_Dropdown_Value);

		waitForElement(driver, DW_Add_button);
		click(driver, DW_Add_button);

		waitForPopup(driver, popup_Message, Validation_pop_expected);

		String Submit_popup_Message_LINE1 = getText(driver, popup_Message);
		System.out.println(Submit_popup_Message_LINE1);
		if (Submit_popup_Message_LINE1.contains(Validation_pop_expected)) {

			System.out.println("Matched  || Expected popup : " + Validation_pop_expected + " || Actual popup : "
					+ Submit_popup_Message_LINE1);
			Extent_pass_New(driver, "Matched || Expected popup : " + Validation_pop_expected + " || Actual popup : "
					+ Submit_popup_Message_LINE1, test, test1);

		} else {
			System.out.println("Matched  || Expected popup : " + Validation_pop_expected + " || Actual popup : "
					+ Submit_popup_Message_LINE1);
			Extent_fail(driver, "Matched  || Expected popup : " + Validation_pop_expected + " || Actual popup : "
					+ Submit_popup_Message_LINE1, test, test1);

		}

		Step_End(8,
				"Verify the MsgThis is Additional Waiver kindly use Exclusive option for Container(s) ( Container No )\r\n"
						+ "",
				test, test1);

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		
		if (WantToCancel_Waiver.equalsIgnoreCase("Yes")) {

			scrollTop(driver);
			waitForElement(driver, cancel_Common_btn);
			click(driver, cancel_Common_btn);
			
			waitForElement(driver, SearchButton_Toolbar);
			click(driver, SearchButton_Toolbar);
			
			globalValueSearchWindow(driver, GlobalSearch_Condition, SearchType_WaiverNumer, waiverNumber[0], "", "", "", "");

			String waiverValue = getAttribute(driver, DW_Waiver_Reference_input, "value");

			waitForElement(driver, DW_WaiverStatus);
			String waiverstatus = getText(driver, DW_WaiverStatus);
			
			Reversewaiver(driver, GlobalSearch_Condition, SearchType_WaiverNumer, waiverValue, Remark, waiverstatus, AgencyName,
					Detention_Module);

		}
		if (Reset_Global_Configuration.equalsIgnoreCase("Yes")) {

		reSetGlobalConfiguration(driver, Value_Reset_Perform, Global_Configration, Global_Attribute, Value_Reset);
		}
		Extent_completed(testcase_Name, test, test1);

	}
}
