package LRP_Phase_1A_NFR_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Ports_SC002  extends Keywords{
	
	public void Ports_SC002(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Ports_SC002";
		String username = Excel_data.get("Username");
		String pass_word = Excel_data.get("Password");
		String Ports_Module = Excel_data.get("Ports_Module");
		String From_date_popup = Excel_data.get("From_date_popup");
		String From_date_input = Excel_data.get("From_date_input");
		String To_date_input = Excel_data.get("To_date_input");
		String Location_Code_Popup = Excel_data.get("Location_Code_Popup");
		String Location_Code_input = Excel_data.get("Location_Code_input");
		String Location_Name_popUp = Excel_data.get("Location_Name_popUp");
		String Location_Name_Input = Excel_data.get("Location_Name_Input");
		String To_Date_popup = Excel_data.get("To_Date_popup");
		String Location_Type = Excel_data.get("Location_Type");
		String Location_Type_Input = Excel_data.get("Location_Type_Input");
		String Country_popup = Excel_data.get("Country_popup");
		String Country_Code_Header = Excel_data.get("Country_Code_Header");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Country_Input = Excel_data.get("Country_Input");
		String Sector_Popup = Excel_data.get("Sector_Popup");
		String Sector_Code_Header = Excel_data.get("Sector_Code_Header");
		String Sector_Code_Input = Excel_data.get("Sector_Code_Input");
		String TCA_popup = Excel_data.get("TCA_popup");
		String TCA_Header = Excel_data.get("TCA_Header");
		String TCA_Input = Excel_data.get("TCA_Input");
		String Latitude_Popup = Excel_data.get("Latitude_Popup");
		String Latitude_Input = Excel_data.get("Latitude_Input");
		String Longitude_Popup = Excel_data.get("Longitude_Popup");
		String Longitude_input = Excel_data.get("Longitude_input");
		String Hemisphere_popup = Excel_data.get("Hemisphere_popup");
		String Hemisphere_Input = Excel_data.get("Hemisphere_Input");
		String Meridian_Popup = Excel_data.get("Meridian_Popup");
		String Meridian_Input = Excel_data.get("Meridian_Input");
		String Region_popup = Excel_data.get("Region_popup");
		String Region_Header = Excel_data.get("Region_Header");
		String Region_Input = Excel_data.get("Region_Input");
		String Time_Off_Set_popup = Excel_data.get("Time_Off_Set_popup");
		
		
		
		Extent_Start(testcase_Name, test, test1);
		 
		navigateUrl(driver, url);
		
		LRP_Login(driver, username, pass_word);
		verifyMainMenu(driver);

		moduleNavigate(driver, Ports_Module);
		
		newButton(driver);
		
		
		Step_Start(1, "If user left the valid From  field as blank and click on save button, the validation message  of \" Enter the valid From Date\" should be shown.", test, test1);

		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, From_date_popup);
		String Act_From_date =getText(driver, popup_Message);
		
		
		if(Act_From_date.equals(From_date_popup)) {
			System.out.println("Matched || " + " Expected POPUP is : " + From_date_popup + " || Actual  POPUP message is : " + Act_From_date);
			Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + From_date_popup + " || Actual  POPUP message is : " + Act_From_date, test, test1);

		}else {
			System.out.println("Not Matched || " + " Expected POPUP is : " + From_date_popup + " || Actual  POPUP message is : " + Act_From_date);
			Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + From_date_popup + " || Actual  POPUP message is : " + Act_From_date, test, test1);

		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		Step_End(1, "If user left the valid From  field as blank and click on save button, the validation message  of \" Enter the valid From Date\" should be shown.", test, test1);

		Step_Start(2, "If user left the valid From  field as blank and click on save button, the validation message  of \" Enter the valid From Date\" should be shown.", test, test1);

		
		selectDatePicker(driver, Valid_From_date_field,From_date_input);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		
		waitForPopup(driver, popup_Message, To_Date_popup);
		String Act_To_date =getText(driver, popup_Message);
		
		if(Act_To_date.equals(To_Date_popup)) {
			System.out.println("Matched || " + " Expected POPUP is : " + To_Date_popup + " || Actual  POPUP message is : " + Act_To_date);
			Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + To_Date_popup + " || Actual  POPUP message is : " + Act_To_date, test, test1);

		}else {
			System.out.println("Not Matched || " + " Expected POPUP is : " + To_Date_popup + " || Actual  POPUP message is : " + Act_To_date);
			Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + To_Date_popup + " || Actual  POPUP message is : " + Act_To_date, test, test1);

		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);	
		
		
		Step_End(2, "If user left the valid From  field as blank and click on save button, the validation message  of \" Enter the valid From Date\" should be shown.", test, test1);

		Step_Start(3, ".If user left the Location Code  field as blank and click on save button,  the validation message  of \"Enter the Location Code\" should be shown.       ", test, test1);

		selectDatePicker(driver, Valid_To_date_field,To_date_input);
		
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		
		waitForPopup(driver, popup_Message, Location_Code_Popup);
		String Act_Location_Code =getText(driver, popup_Message);
		
		
		if(Act_Location_Code.equals(Location_Code_Popup)) {
			System.out.println("Matched || " + " Expected POPUP is : " + Location_Code_Popup + " || Actual  POPUP message is : " + Act_Location_Code);
			Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + Location_Code_Popup + " || Actual  POPUP message is : " + Act_Location_Code, test, test1);

		}else {
			System.out.println("Not Matched || " + " Expected POPUP is : " + Location_Code_Popup + " || Actual  POPUP message is : " + Act_Location_Code);
			Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + Location_Code_Popup + " || Actual  POPUP message is : " + Act_Location_Code, test, test1);

		}
		
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);	
		
		
		Step_End(3, ".If user left the Location Code  field as blank and click on save button,  the validation message  of \"Enter the Location Code\" should be shown.       ", test, test1);

		waitForElement(driver, Ports_Loc_Code_Field);
		sendKeys(driver, Ports_Loc_Code_Field, Location_Code_input);
		
		Step_Start(4, ".If user left the Location Name  field as blank and click on save button,  the validation message  of \"Enter the Location Name\" should be shown.   ", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Location_Name_popUp);
		String Act_Location_Name=getText(driver, popup_Message);
		
		if(Act_Location_Name.equals(Location_Name_popUp)) {
			System.out.println("Matched || " + " Expected POPUP is : " + Location_Name_popUp + " || Actual  POPUP message is : " + Act_Location_Name);
			Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + Location_Name_popUp + " || Actual  POPUP message is : " + Act_Location_Name, test, test1);

		}else {
			System.out.println("Not Matched || " + " Expected POPUP is : " + Location_Name_popUp + " || Actual  POPUP message is : " + Act_Location_Name);
			Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + Location_Name_popUp + " || Actual  POPUP message is : " + Act_Location_Name, test, test1);

		}
		
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);		
		
		Step_End(4, ".If user left the Location Name  field as blank and click on save button,  the validation message  of \"Enter the Location Name\" should be shown.   ", test, test1);

		
		waitForElement(driver, Port_Loc_Name_Field);
		sendKeys(driver, Port_Loc_Name_Field, Location_Name_Input);
		
		Step_Start(5, "If user left the  Location Type  field as blank and click on save button,  the validation message  of \"Enter the Location Type\" should be shown.", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		
		
		waitForPopup(driver, popup_Message, Location_Type);
		String Act_Location_Type=getText(driver, popup_Message);
		
		if(Act_Location_Type.equals(Location_Type)) {
			System.out.println("Matched || " + " Expected POPUP is : " + Location_Type + " || Actual  POPUP message is : " + Act_Location_Type);
			Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + Location_Type + " || Actual  POPUP message is : " + Act_Location_Type, test, test1);

		}else {
			System.out.println("Not Matched || " + " Expected POPUP is : " + Location_Type + " || Actual  POPUP message is : " + Act_Location_Type);
			Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + Location_Type + " || Actual  POPUP message is : " + Act_Location_Type, test, test1);

		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);		
		
		
		Step_End(5, "If user left the  Location Type  field as blank and click on save button,  the validation message  of \"Enter the Location Type\" should be shown.", test, test1);
		
		waitForElement(driver, Port_Loc_Type_Dropdown);
		click(driver,Port_Loc_Type_Dropdown);
		formatLocatorClick(driver, Port_Dropdown_Select, Location_Type_Input);
		
		Step_Start(6, "If user left the Country  field as blank and click on save button,  the validation message  of \"Enter the Country\" should be shown", test, test1);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Country_popup);
		String Act_Country=getText(driver, popup_Message);
		
		
		if(Act_Country.equals(Country_popup)) {
			System.out.println("Matched || " + " Expected POPUP is : " + Country_popup + " || Actual  POPUP message is : " + Act_Country);
			Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + Country_popup + " || Actual  POPUP message is : " + Act_Country, test, test1);

		}else {
			System.out.println("Not Matched || " + " Expected POPUP is : " + Country_popup + " || Actual  POPUP message is : " + Act_Country);
			Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + Country_popup + " || Actual  POPUP message is : " + Act_Country, test, test1);

		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);	
		
		
		waitForElement(driver, Country_Search_btn);
		click(driver,Country_Search_btn);	
		
		twoColumnSearchWindow(driver, Country_Code_Header, Condition_Filter, Country_Input);
		
		
		Step_End(6, "If user left the Country  field as blank and click on save button,  the validation message  of \"Enter the Country\" should be shown", test, test1);
		Step_Start(7, "If user left the Sector  field as blank and click on save button,  the validation message  of \"Enter the Sector\" should be shown", test, test1);

		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Sector_Popup);
		String Act_Sector_Popup=getText(driver, popup_Message);
		
		if(Act_Sector_Popup.equals(Sector_Popup)) {
			System.out.println("Matched || " + " Expected POPUP is : " + Sector_Popup + " || Actual  POPUP message is : " + Act_Sector_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + Sector_Popup + " || Actual  POPUP message is : " + Act_Sector_Popup, test, test1);

		}else {
			System.out.println("Not Matched || " + " Expected POPUP is : " + Sector_Popup + " || Actual  POPUP message is : " + Act_Sector_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + Sector_Popup + " || Actual  POPUP message is : " + Act_Sector_Popup, test, test1);

		}
		
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		Step_End(7, "If user left the Sector  field as blank and click on save button,  the validation message  of \"Enter the Sector\" should be shown", test, test1);
		Step_Start(8, "If user left the TCA  field as blank and click on save button,  the validation message  of \"Enter the TCA\" should be shown", test, test1);
		
		waitForElement(driver, Sector_Search_Btn);
		click(driver,Sector_Search_Btn);
		
		twoColumnSearchWindow(driver, Sector_Code_Header, Condition_Filter, Sector_Code_Input);
		
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, TCA_popup);
		String Act_TCA=getText(driver, popup_Message);
		
		if(Act_TCA.equals(TCA_popup)) {
			System.out.println("Matched || " + " Expected POPUP is : " + TCA_popup + " || Actual  POPUP message is : " + Act_TCA);
			Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + TCA_popup + " || Actual  POPUP message is : " + Act_TCA, test, test1);

		}else {
			System.out.println("Not Matched || " + " Expected POPUP is : " + TCA_popup + " || Actual  POPUP message is : " + Act_TCA);
			Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + TCA_popup + " || Actual  POPUP message is : " + Act_TCA, test, test1);

		}
		
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		Step_End(8, "If user left the TCA  field as blank and click on save button,  the validation message  of \"Enter the TCA\" should be shown", test, test1);

		Step_Start(9, "f user left the Latitude  field as blank and click on save button,  the validation message  of \" Enter the Latitude\" should be shown.", test, test1);

		waitForElement(driver, TCA_Search_Btn);
		click(driver,TCA_Search_Btn);

		twoColumnSearchWindow(driver, TCA_Header, Condition_Filter, TCA_Input);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Latitude_Popup);
		String Act_Latitude_Popup=getText(driver, popup_Message);
		
		
		if(Act_Latitude_Popup.equals(Latitude_Popup)) {
			System.out.println("Matched || " + " Expected POPUP is : " + Latitude_Popup + " || Actual  POPUP message is : " + Act_Latitude_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + Latitude_Popup + " || Actual  POPUP message is : " + Act_Latitude_Popup, test, test1);

		}else {
			System.out.println("Not Matched || " + " Expected POPUP is : " + Latitude_Popup + " || Actual  POPUP message is : " + Act_Latitude_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + Latitude_Popup + " || Actual  POPUP message is : " + Act_Latitude_Popup, test, test1);

		}
		
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		Step_End(9, "f user left the Latitude  field as blank and click on save button,  the validation message  of \" Enter the Latitude\" should be shown.", test, test1);

		Step_Start(10, "f user left the Latitude  field as blank and click on save button,  the validation message  of \" Enter the Latitude\" should be shown.", test, test1);

		waitForElement(driver, Latitute_Text_Field);
		sendKeys(driver, Latitute_Text_Field, Latitude_Input);
		
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Longitude_Popup);
		String Act_Longitude_Popup=getText(driver, popup_Message);
		

		if(Act_Longitude_Popup.equals(Longitude_Popup)) {
			System.out.println("Matched || " + " Expected POPUP is : " + Longitude_Popup + " || Actual  POPUP message is : " + Act_Longitude_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + Longitude_Popup + " || Actual  POPUP message is : " + Act_Longitude_Popup, test, test1);

		}else {
			System.out.println("Not Matched || " + " Expected POPUP is : " + Longitude_Popup + " || Actual  POPUP message is : " + Act_Longitude_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + Longitude_Popup + " || Actual  POPUP message is : " + Act_Longitude_Popup, test, test1);

		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		Step_End(10, "f user left the Latitude  field as blank and click on save button,  the validation message  of \" Enter the Latitude\" should be shown.", test, test1);
		Step_Start(11, "If user left the Hemisphere  field as blank and click on save button,  the validation message  of \"Enter the Hemisphere\" should be shown.", test, test1);

		
		waitForElement(driver, Longitute_Text_Field);
		sendKeys(driver, Longitute_Text_Field, Longitude_input);
		
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Hemisphere_popup);
		String Act_Hemisphere_popup=getText(driver, popup_Message);
		
		if(Act_Hemisphere_popup.equals(Hemisphere_popup)) {
			System.out.println("Matched || " + " Expected POPUP is : " + Hemisphere_popup + " || Actual  POPUP message is : " + Act_Hemisphere_popup);
			Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + Hemisphere_popup + " || Actual  POPUP message is : " + Act_Hemisphere_popup, test, test1);

		}else {
			System.out.println("Not Matched || " + " Expected POPUP is : " + Hemisphere_popup + " || Actual  POPUP message is : " + Act_Hemisphere_popup);
			Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + Hemisphere_popup + " || Actual  POPUP message is : " + Act_Hemisphere_popup, test, test1);

		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		Step_End(11, "If user left the Hemisphere  field as blank and click on save button,  the validation message  of \"Enter the Hemisphere\" should be shown.", test, test1);
		Step_Start(12, ".If user left the Meridian  field as blank and click on save button,  the validation message  of \"Enter the Meridian\" should be shown.", test, test1);

		
		waitForElement(driver, Hemisphere_Dropdown);
		click(driver,Hemisphere_Dropdown);
		
		formatLocatorClick(driver, Hemisphere_Dropdown_Sel, Hemisphere_Input);
		
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Meridian_Popup);
		String Act_Meridian_Popup=getText(driver, popup_Message);
		
		if(Act_Meridian_Popup.equals(Meridian_Popup)) {
			System.out.println("Matched || " + " Expected POPUP is : " + Meridian_Popup + " || Actual  POPUP message is : " + Act_Meridian_Popup);
			Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + Meridian_Popup + " || Actual  POPUP message is : " + Act_Meridian_Popup, test, test1);

		}else {
			System.out.println("Not Matched || " + " Expected POPUP is : " + Meridian_Popup + " || Actual  POPUP message is : " + Act_Meridian_Popup);
			Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + Meridian_Popup + " || Actual  POPUP message is : " + Act_Meridian_Popup, test, test1);

		}
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		Step_End(12, ".If user left the Meridian  field as blank and click on save button,  the validation message  of \"Enter the Meridian\" should be shown.", test, test1);

		Step_Start(13, "If user left the Region  field as blank and click on save button,  the validation message  of \"Enter the Region\" should be shown.", test, test1);

		
		waitForElement(driver, Meridian_Dropdown);
		click(driver,Meridian_Dropdown);
		
		formatLocatorClick(driver, Meridian_Dropdown_Sel, Meridian_Input);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Region_popup);
		String Act_Region_popup=getText(driver, popup_Message);
		
		if(Act_Region_popup.equals(Region_popup)) {
			System.out.println("Matched || " + " Expected POPUP is : " + Region_popup + " || Actual  POPUP message is : " + Act_Region_popup);
			Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + Region_popup + " || Actual  POPUP message is : " + Act_Region_popup, test, test1);

		}else {
			System.out.println("Not Matched || " + " Expected POPUP is : " + Region_popup + " || Actual  POPUP message is : " + Act_Region_popup);
			Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + Region_popup + " || Actual  POPUP message is : " + Act_Region_popup, test, test1);

		}
		
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		Step_End(13, "If user left the Region  field as blank and click on save button,  the validation message  of \"Enter the Region\" should be shown.", test, test1);
		Step_Start(14, "If user left the  Time off set  field as blank and click on save button,  the validation message  of \"Enter the Time off set\" should be shown.", test, test1);

		
		waitForElement(driver, Region_Search_btn);
		click(driver,Region_Search_btn);
		
		twoColumnSearchWindow(driver, Region_Header, Condition_Filter, Region_Input);
		
		waitForElement(driver, SaveButton_ToolBar);
		click(driver,SaveButton_ToolBar);
		
		waitForPopup(driver, popup_Message, Time_Off_Set_popup);
		String Act_Time_Off_Set_popup=getText(driver, popup_Message);
		
		
		if(Act_Time_Off_Set_popup.equals(Time_Off_Set_popup)) {
			System.out.println("Matched || " + " Expected POPUP is : " + Time_Off_Set_popup + " || Actual  POPUP message is : " + Act_Time_Off_Set_popup);
			Extent_pass_New(driver, "Matched || " + " Expected POPUP is : " + Time_Off_Set_popup + " || Actual  POPUP message is : " + Act_Time_Off_Set_popup, test, test1);

		}else {
			System.out.println("Not Matched || " + " Expected POPUP is : " + Time_Off_Set_popup + " || Actual  POPUP message is : " + Act_Time_Off_Set_popup);
			Extent_fail(driver, "Not Matched || " + " Expected POPUP is : " + Time_Off_Set_popup + " || Actual  POPUP message is : " + Act_Time_Off_Set_popup, test, test1);

		}
		
		
		waitForElement(driver, popup_Message_Ok_Button);
		click(driver,popup_Message_Ok_Button);
		
		
		Step_End(14, "If user left the  Time off set  field as blank and click on save button,  the validation message  of \"Enter the Time off set\" should be shown.", test, test1);
		Extent_completed(testcase_Name, test, test1);
		
}
}