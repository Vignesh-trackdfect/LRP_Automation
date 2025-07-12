package LRP_VSS_Integration_Scripts_2;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_LongTerm_LT03A_IP extends Keywords {

	public void LongTerm_LT03A_IP(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_LongTerm_LT03A_IP";

		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String SearchBox = Excel_data.get("SearchBox");
		String ServiceCode = Excel_data.get("ServiceCode");
		String vesselName = Excel_data.get("vesselName");
		String Vessels_Code = Excel_data.get("Vessels_Code");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Pop_up_for_confirm = Excel_data.get("Pop_up_for_confirm");
		String Voyage_Confirmed_pop = Excel_data.get("Voyage_Confirmed_pop");
		String Search_Module_Name = Excel_data.get("Search_Module_Name");
		String Service_Code_Header = Excel_data.get("Service_Code_Header");
		String Service_Code_Header_CS = Excel_data.get("Service_Code_Header_CS");
		String Vessel_code_Header_CS = Excel_data.get("Vessel_code_Header_CS");
		String Condition_Filter = Excel_data.get("Condition_Filter");




		Extent_Start(testCaseName, test, test1);
		// Login
		navigateUrl(driver, url);
		
		
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Open Long Term Module", test, test1);
		
		
		moduleNavigate(driver, SearchBox);
		Step_End(1, "Open Long Term Module", test, test1);
		scrollTop(driver);

		Step_Start(2, "Reterive the Required Schedule", test, test1);
		waitForElement(driver,SearchButton_Toolbar);
		safeclick(driver, SearchButton_Toolbar);

		waitForElement(driver, searchIconLT);
		click(driver, searchIconLT);
		twoColumnSearchWindow(driver, Service_Code_Header, Condition_Filter, ServiceCode);

		
		waitForElement(driver, LongTermsearchOk);
		safeclick(driver, LongTermsearchOk);		
		Step_End(2, "Reterive the Required Schedule", test, test1);

		Step_Start(3, "Click on Edit Button", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		safeclick(driver, Edit_Button_toolBar);

		Step_End(3, "Click on Edit Button", test, test1);
		Step_Start(4, "Right Click on the Draft voyages", test, test1);
		scrollBottom(driver);
		waitForElement(driver, longTermTab);

		String voy = null;
		try {
			int i = 1;
			waitForElement(driver, vessel_codes);

			List<WebElement> vesselCodes = listOfElements(driver, vessel_codes);
			for (WebElement Vessel_Code : vesselCodes) {
				String Vessel = getText1(driver, Vessel_Code);
				if (Vessels_Code.equals(Vessel)) {
					String voyage_Num = String.format(voyNumber, i);
					voy = getText(driver, voyage_Num);
					if (Voyage_Number.equals(voy)) {
						click(driver, voyage_Num);
						RightClick(driver, voyage_Num);

						break;
					}

				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			Extent_fail(driver,  " Element is not present "+ e.getLocalizedMessage(), test,test1);

		}
		Step_End(4, "Right Click on the Draft voyages", test, test1);

		Step_Start(5, "Choose confirm option", test, test1);

		waitForElement(driver, Conformbtnlongterm);

		safeclick(driver, Conformbtnlongterm);
		
		waitForPopup(driver, popup_Message, Pop_up_for_confirm);
		String wantconformAct = getText(driver, popup_Message);
		System.out.println(wantconformAct);
		if (Pop_up_for_confirm.equals(wantconformAct)) {
			System.out.println("Matched || " + " Expected Activity is : " + Pop_up_for_confirm
					+ " || Actual Activity is : " + wantconformAct);
			Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + Pop_up_for_confirm
					+ " || Actual Activity is : " + wantconformAct, test, test1);
		} else {
			System.out.println("Not matched || " + " Expected Activity is : " + Pop_up_for_confirm
					+ " || Actual Activity is : " + wantconformAct);
			Extent_fail(driver, "Not matched || " + " Expected Activity is : " + Pop_up_for_confirm
					+ " || Actual Activity is : " + wantconformAct, test, test1);
		}

		waitForDisplay(driver, popup_Message_Yes_Button);
		safeclick(driver, popup_Message_Yes_Button);
		if (isDisplayed(driver, continuebutton)) {
			waitForElement(driver, continuebutton);
			safeclick(driver, continuebutton);
		} 

		waitForPopup(driver, popup_Message, Voyage_Confirmed_pop);
		String Voyage_Confirmed_popAct = getText(driver, popup_Message);
		System.out.println(Voyage_Confirmed_popAct);

		if (Voyage_Confirmed_pop.equals(Voyage_Confirmed_popAct)) {
			System.out.println("Matched || " + " Expected Activity is : " + Voyage_Confirmed_pop
					+ " || Actual Activity is : " + Voyage_Confirmed_popAct);
			Extent_pass_New(driver, "Matched || " + " Expected Activity is : " + Voyage_Confirmed_pop
					+ " || Actual Activity is : " + Voyage_Confirmed_popAct, test, test1);
			Extent_pass_New(driver, "**********Voyage was deleted and background was changed to white colour********", test,
					test1);
		} else {
			System.out.println("Not matched || " + " Expected Activity is : " + Voyage_Confirmed_pop
					+ " || Actual Activity is : " + Voyage_Confirmed_popAct);
			Extent_fail(driver, "Not matched || " + " Expected Activity is : " + Voyage_Confirmed_pop
					+ " || Actual Activity is : " + Voyage_Confirmed_popAct, test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		scrollTop(driver);
		Step_End(5, "Choose confirm option", test, test1);

		Extent_call(test, test1, "Close Long Term Module");
		waitForElement(driver, Close_Current_tab);
		safeclick(driver, Close_Current_tab);

		Step_Start(6, "Open Coastal Schedule module", test, test1);
		moduleNavigate(driver, Search_Module_Name);
		Step_End(6, "Open Coastal Schedule module", test, test1);

		Step_Start(8, "Retireve the Service and Vessel which voyage , confirmed in the long term module ", test, test1);
		waitForElement(driver, Service_Search_Btn);
		safeclick(driver, Service_Search_Btn);

		twoColumnSearchWindow(driver, Service_Code_Header_CS, Condition_Filter, ServiceCode);
		// Select Serivce

		waitForElement(driver, Vessel_Search_Btn);
		safeclick(driver, Vessel_Search_Btn);

		// Select Vessel
		twoColumnSearchWindow(driver, Vessel_code_Header_CS, Condition_Filter, vesselName);

		int index = Voyage_Number.indexOf("-");
		String voyage_Name = Voyage_Number.substring(0, index - 1);
		
		String Confirmed_Voyage =  String.format(Confirmed_voyage, voyage_Name);

		if (!isDisplayed(driver, Confirmed_Voyage)) {
			waitForElement(driver, selbtn);
			safeclick(driver, selbtn);
		}
		Step_End(8, "Retireve the Service and Vessel which voyage , confirmed in the long term module ", test, test1);
		Extent_call(test, test1, " Verify the confirmed voyage in Longterm is displayed in Coastal Shedule");

		if (isDisplayed(driver, Confirmed_Voyage)) {
			System.out.println("Expected Result is :Once user Confirmed the Voyage in long term it should displayed in Coastal Schedule|| Actual Result is :Once user Confirmed the Voyage in long term is displayed in Coastal Schedule");
			Extent_pass_New(driver, "Expected Result is :Once user Confirmed the Voyage in long term it should displayed in Coastal Schedule|| Actual Result is :Once user Confirmed the Voyage in long term is displayed in Coastal Schedule", test, test1);
		} else {
			System.out.println("Expected Result is :Once user Confirmed the Voyage in long term it should displayed in Coastal Schedule|| Actual Result is :Once user Confirmed the Voyage in long term is not displayed in Coastal Schedule");
			Extent_fail(driver, "Expected Result is :Once user Confirmed the Voyage in long term it should displayed in Coastal Schedule|| Actual Result is :Once user Confirmed the Voyage in long term is not displayed in Coastal Schedule", test, test1);

		}
		Extent_call(test, test1, "After verifying draft the voyage");
		

		Extent_completed(testCaseName, test, test1);

	}
}
