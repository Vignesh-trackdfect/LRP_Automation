package LRP_Delivery_Order_Scripts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Delivery_Order_TS_019 extends Keywords{
	public void Delivery_Order_TS_019(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws EncryptedDocumentException, InvalidFormatException, IOException{

		String testcase_Name="TC_Delivery_Order_TS_019";
		
		
		


		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String AgencyConfigurationModule = Excel_data.get("AgencyConfigurationModule");
		String value = Excel_data.get("value");
		String description = Excel_data.get("description");
		String DeliveryOrderModule = Excel_data.get("DeliveryOrderModule");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Condition = Excel_data.get("BL_Condition");
		String bl_Number = Excel_data.get("bl_Number");
		String Cargo_type = Excel_data.get("Cargo_type");
		String DO_Status = Excel_data.get("DO_Status");
		String DO_Delete = Excel_data.get("DO_Delete");
		String delete_Yes_No = Excel_data.get("delete_Yes_No");
		String DO_Delete_Background_Colour_Code = Excel_data.get("DO_Delete_Background_Colour_Code");
		String attribute = Excel_data.get("attribute");
		String GlobalSearchFilterOption_ID = Excel_data.get("GlobalSearchFilterOption_ID");
		String GlobalSearchFilterOption_DO = Excel_data.get("GlobalSearchFilterOption_DO");
		String status_Filer_Data = Excel_data.get("status_Filer_Data");
		String Agency_Search_Column_Header = Excel_data.get("Agency_Search_Column_Header");
		String Attribute_Search_Column_Header = Excel_data.get("Attribute_Search_Column_Header");
		String Value_To_Reset = Excel_data.get("Value_To_Reset");
		String reset_Attribute = Excel_data.get("reset_Attribute");
		String TwoColumn_Condition = Excel_data.get("TwoColumn_Condition");

		navigateUrl(driver, url);
		Extent_Start(testcase_Name, test, test1);
		LRP_Login(driver, Username, Password);
		Step_Start(1, "Switch to  transhipment agency ", test, test1);
		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Switch to  transhipment agency ", test, test1);
		List<Boolean> newlyadded = setAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header,Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser, attribute, description, value);
		moduleNavigate(driver, ImportDocumentationModule);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		globalValueSearchWindow(driver, BL_Condition, GlobalSearchFilterOption_ID, bl_Number, "", "", "", "");
		waitForElement(driver, Cargo_Type);
		String Cargo_Type_Value=getText(driver, Cargo_Type);
		if (Cargo_Type_Value.equals(Cargo_type)) {
			System.out.println("Matched || Expected Cargo Type value was : " + Cargo_Type_Value + " || Actual Cargo Type value was : " + Cargo_type);
			Extent_pass_New(driver,"Matched || Expected Cargo Type value was : " + Cargo_Type_Value + " || Actual Cargo Type value was : " + Cargo_type, test,test1);
		} else {
			System.out.println("Not Matched || Expected Cargo Type value was : " + Cargo_Type_Value + " || Actual Cargo Type value was : " + Cargo_type);
			Extent_fail(driver,"Not Matched || Expected Cargo Type value was : " + Cargo_Type_Value + " || Actual Cargo Type value was  : " + Cargo_type,test, test1);
		}
		scrollTop(driver);
		waitForElement(driver, Module_Close);
		click(driver, Module_Close);
		Step_Start(5, "Open Delivery order module", test, test1);
		moduleNavigate(driver, DeliveryOrderModule);
		Step_End(5, "Open Delivery order module", test, test1);
		Step_Start(6, "Click the search icon in Tool bar.", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(6, "Click the search icon in Tool bar.", test, test1);
		Step_Start(7, "Paste the Delivery order number/BL number  then click search ", test, test1);
		globalValueSearchWindow1(driver, BL_Condition, GlobalSearchFilterOption_DO, bl_Number, "", "", "", "");
		globalValueSearchWindowScrollAndSelect(driver, status_Filter_DO,status_Filer_Data);
		Step_End(7, "Paste the Delivery order number/BL number  then click search ", test, test1);
		scrollTop(driver);
		Step_Start(8, "After fetching the records click  Delete button in Tool bar ", test, test1);
		waitForElement(driver, Delete_button_toolBar);
		click(driver, Delete_button_toolBar);
		Step_End(8, "After fetching the records click  Delete button in Tool bar ", test, test1);
		Step_Start(9, "Ensure system Validates as \"  Are you sure want to delete the Delivery Order? \"", test, test1);
		waitForPopup(driver, popup_Message,delete_Yes_No);
		String Delete_Yes_No_Popup=getText(driver, popup_Message);
		if (delete_Yes_No .equals(Delete_Yes_No_Popup)) {
			System.out.println("Matched || Expected Pop-up value was : " + delete_Yes_No  + " || Actual Pop-up value was : " + Delete_Yes_No_Popup);
			Extent_pass_New(driver,"Matched || Expected Pop-up value was : " + delete_Yes_No  + " || Actual Pop-up value was : " + Delete_Yes_No_Popup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Pop-up value was : " + delete_Yes_No  + " || Actual Pop-up value was : " + Delete_Yes_No_Popup);
			Extent_fail(driver,"Not Matched || Expected Pop-up value was : " + delete_Yes_No  + " || Actual Pop-up value was  : " + Delete_Yes_No_Popup,test, test1);
		}
		Step_End(9, "Ensure system Validates as \"  Are you sure want to delete the Delivery Order? \"", test, test1);
		Step_Start(10, "Click Yes", test, test1);
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		Step_End(10, "Click Yes", test, test1);
		Step_Start(11, "Ensure\" Delivery order deleted\" validation should be displayed", test, test1);
		waitForPopup(driver,Popup_Message,DO_Delete);
		String DO_Delete_Popup=getText(driver, Popup_Message);
		if (DO_Delete .equals(DO_Delete_Popup)) {
			System.out.println("Matched || Expected Pop-up value was : " + DO_Delete  + " || Actual Pop-up value was : " + DO_Delete_Popup);
			Extent_pass_New(driver,"Matched || Expected Pop-up value was : " + DO_Delete  + " || Actual Pop-up value was : " + DO_Delete_Popup, test,test1);
		} else {
			System.out.println("Not Matched || Expected Pop-up value was : " + DO_Delete  + " || Actual Pop-up value was : " + DO_Delete_Popup);
			Extent_fail(driver,"Not Matched || Expected Pop-up value was : " + DO_Delete  + " || Actual Pop-up value was  : " + DO_Delete_Popup,test, test1);
		}
		Step_End(11, "Ensure\" Delivery order deleted\" validation should be displayed", test, test1);
		waitForElement(driver, Deliver_Order_No_TF);
		String DO_No_Delete_Background_Colour_Code=getTextBackgroundColor(driver, Deliver_Order_No_TF);
		String DO_No_Delete_Background_Colour = getColorName(DO_No_Delete_Background_Colour_Code);
		System.out.println("delete clr:"+DO_No_Delete_Background_Colour);
		if (DO_Delete_Background_Colour_Code .equals(DO_No_Delete_Background_Colour)) {
			System.out.println("Matched || Expected Color value was : " + DO_Delete_Background_Colour_Code  + " || Actual Color value was : " + DO_No_Delete_Background_Colour);
			Extent_pass_New(driver,"Matched || Expected Color value was : " + DO_Delete_Background_Colour_Code  + " || Actual Color value was : " + DO_No_Delete_Background_Colour, test,test1);
		} else {
			System.out.println("Not Matched || Expected Color value was : " + DO_Delete_Background_Colour_Code  + " || Actual Color value was : " + DO_No_Delete_Background_Colour);
			Extent_fail(driver,"Not Matched || Expected Color value was : " + DO_Delete_Background_Colour_Code  + " || Actual Color value was  : " + DO_No_Delete_Background_Colour,test, test1);
		}
		waitForElement(driver, DO_Status_Value);
		String DO_status_Val=getText(driver, DO_Status_Value);
		if (DO_status_Val .contains(DO_Status)) {
			System.out.println("Matched || Expected Status value was : " + DO_Status  + " || Actual Status value was : " + DO_status_Val);
			Extent_pass_New(driver,"Matched || Expected Status value was : " + DO_Status  + " || Actual Status value was : " + DO_status_Val, test,test1);
		} else {
			System.out.println("Not Matched || Expected Status value was : " + DO_Status  + " || Actual Status value was : " + DO_status_Val);
			Extent_fail(driver,"Not Matched || Expected Status value was : " + DO_Status  + " || Actual Status value was  : " + DO_status_Val,test, test1);
		}
		reSetAgencyConfiguration(driver, AgencyConfigurationModule, Agency_Search_Column_Header, Attribute_Search_Column_Header, TwoColumn_Condition, AgencyUser,description, Value_To_Reset, newlyadded, reset_Attribute);
		Extent_completed(testcase_Name, test, test1);
	}
}