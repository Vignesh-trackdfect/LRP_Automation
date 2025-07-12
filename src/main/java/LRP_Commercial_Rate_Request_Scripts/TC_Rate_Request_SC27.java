package LRP_Commercial_Rate_Request_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Rate_Request_SC27 extends Keywords {


	public void rate_Request_Sc27(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

		String testcase_Name="TC_Rate_Request_SC27";



		String username = Excel_data.get("Username");
		String pass_word =Excel_data.get("PassWord");
		String Field_Names =Excel_data.get("ModuleRateRequest");
		String agencyUser = Excel_data.get("Agency_user");
		String DG_checkboxs = Excel_data.get("DG_checkboxs");
		String NOR_checkbox = Excel_data.get("NOR_checkbox");
		String SOC_checkbox = Excel_data.get("SOC_checkbox");
		String OOG_checkbox = Excel_data.get("OOG_checkbox");
		String RfertypepopEXP = Excel_data.get("RfertypepopEXP");
		String Date_Picker = Excel_data.get("Date_Picker");
		String From_Date_Input = Excel_data.get("From_Date_Input");
		String To_Date_Input = Excel_data.get("To_Date_Input");
		String On_Carriage_Radiobtn = Excel_data.get("On_Carriage_Radiobtn");
		String Pre_Carriage_Radiobtn = Excel_data.get("Pre_Carriage_Radiobtn");
		String tService=Excel_data.get("T_Service");
		String TOS=Excel_data.get("TOS_Option");
		String date_Perform = Excel_data.get("date_Perform");
		String Flexi_CheckBox = Excel_data.get("Flexi_CheckBox");
		String MTY_CheckBox = Excel_data.get("MTY_CheckBox");

		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, username, pass_word);
		//Switch User
		SwitchProfile(driver, agencyUser);


		//Module search
		moduleNavigate(driver, Field_Names);

		Step_Start(1, "Click on the new button in the toolbar", test, test1);


		waitForElement(driver, Requet_Type);
newButton(driver);
		if(!tService.equals("")) {
			waitForElement(driver, tService_Dropdown);
			click(driver, tService_Dropdown);
			formatLocatorClick(driver, DropDown_Select, tService);
		}
		if(!TOS.equals("")) {
			waitForElement(driver, RR_TOS_Dropdown);
			click(driver, RR_TOS_Dropdown);
			formatLocatorClick(driver, DropDown_Select, TOS);
		}
		Step_End(3, "Select Validity From Date range accordingly in date picker ",test, test1);
		Step_Start(4, "-Select Validity To Date range accordingly in date picker ",test, test1);
		rateRequestDateSelect(driver, date_Perform, Date_Picker, From_Date_Input, To_Date_Input);


		Step_End(1, "Click on the new button in the toolbar", test, test1);

		if(!Pre_Carriage_Radiobtn.equals("")) {
			formatLocatorClick(driver, pre_Carriage_Radiobtn, Pre_Carriage_Radiobtn);
		}

		if(!On_Carriage_Radiobtn.equals("")) {
			formatLocatorClick(driver, on_Carriage_Radiobtn, On_Carriage_Radiobtn);
		}

		checkBox(driver, DG_checkbox, DG_checkboxs);

		checkBox(driver, oog_checkbox, OOG_checkbox);

		waitForDisplay(driver, flexi_Checkbox_RR);
		if(isdisplayed(driver, flexi_Checkbox_RR)) {
			checkBox(driver, flexi_Checkbox_RR, Flexi_CheckBox);
		}
		waitForDisplay(driver, empty_Checkbox_RR);
		if(isdisplayed(driver, empty_Checkbox_RR)) {
			checkBox(driver, empty_Checkbox_RR, MTY_CheckBox);
		}

		checkBox(driver, soc_checkbox, SOC_checkbox);


		checkBox(driver, nor_checkbox, NOR_checkbox);
		waitForPopup(driver, Popup_Message, RfertypepopEXP);
		String PopUp_Msg3=getText(driver, Popup_Message);    
		System.out.println(PopUp_Msg3);
		if(RfertypepopEXP.equals(PopUp_Msg3)) {                                                                                                                  
			System.out.println("Matched || " + "Expected : popup message should be shown as : " + RfertypepopEXP + " || Actual : popup message is shown as : " + PopUp_Msg3);            
			Extent_pass_New(driver, "Matched || " + "Expected : popup message should be shown as : " + RfertypepopEXP + " || Actual : popup message is shown as : " + PopUp_Msg3, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + "Expected : popup message should be shown as : " + RfertypepopEXP + " || Actual : popup message is shown as : " + PopUp_Msg3);        
			Extent_fail(driver, "Not Matched || " + "Expected : popup message should be shown as : " + RfertypepopEXP + " || Actual : popup message is shown as : " + PopUp_Msg3, test,test1); 

		} 
		Extent_completed(testcase_Name, test, test1);
	}
}
