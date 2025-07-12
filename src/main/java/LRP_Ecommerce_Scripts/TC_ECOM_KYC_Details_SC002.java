package LRP_Ecommerce_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_ECOM_KYC_Details_SC002 extends Keywords {

	public void ECOM_KYC_Details_SC002(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name = "TC_ECOM_KYC_Details_SC002";

		
		

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyName = Excel_data.get("AgencyName");
		String KYC_details_Module = Excel_data.get("KYC_details_Module");
		String Condition_Filter = Excel_data.get("Condition_Filter");
		String Country_Code = Excel_data.get("Country_Code");
		String Country_Select_Header = Excel_data.get("Country_Select_Header");
		String Field_Name = Excel_data.get("Field_Name");
		String Mandatory_Type = Excel_data.get("Mandatory_Type");
		String KYC_details_Saved_popup = Excel_data.get("KYC_details_Saved_popup");
		String Ecomm_Registration = Excel_data.get("Ecomm_Registration");
		String Company_Name_Value = Excel_data.get("Company_Name_Value");
		String Country_Value = Excel_data.get("Country_Value");
		String Agency_Value_Select = Excel_data.get("Agency_Value_Select");
		String Address_Value = Excel_data.get("Address_Value");
		String City_Value = Excel_data.get("City_Value");
		String Postal_Code_Value = Excel_data.get("Postal_Code_Value");
		String Email_ID_Value = Excel_data.get("Email_ID_Value");
		String Password_Value = Excel_data.get("Password_Value");
		String FirstName_Title = Excel_data.get("FirstName_Title");
		String FirstName_Value = Excel_data.get("FirstName_Value");
		String LastName_Value = Excel_data.get("LastName_Value");
		String Country_Code_Value = Excel_data.get("Country_Code_Value");
		String Time_Zone_Value = Excel_data.get("Time_Zone_Value");
		String Mobile_Number = Excel_data.get("Mobile_Number");

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		verifyMainMenu(driver);

		if (!AgencyName.equals("")) {
			SwitchProfile(driver, AgencyName);
		}

		moduleNavigate(driver, KYC_details_Module);

		newButton(driver);
		Step_Start(1, " Click on the \"Country Search\" option and select the desired country.", test, test1);

		waitForElement(driver, Country_SearchBtn_KYC_Details);
		click(driver, Country_SearchBtn_KYC_Details);

		twoColumnMultipleSearchWindow(driver, Country_Select_Header, Condition_Filter, Country_Code);
		Step_End(1, " Click on the \"Country Search\" option and select the desired country.", test, test1);

		Step_Start(2, " Enter the field name.", test, test1);
		waitForElement(driver, FieldName_Input_KYC_Details);
		click(driver, FieldName_Input_KYC_Details);
		sendKeys(driver, FieldName_Input_KYC_Details, Field_Name);
		Step_End(2, " Enter the field name.", test, test1);

		Step_Start(3, " Select whether the field is mandatory (Yes/No)", test, test1);
		waitForElement(driver, Mandatory_Fields_KYC_Details);
		click(driver, Mandatory_Fields_KYC_Details);

		String MandatorySelect = String.format(Mandatory_Field_Select_KYC_Details, Mandatory_Type);
		waitForElement(driver, MandatorySelect);
		click(driver, MandatorySelect);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, Popup_Message, KYC_details_Saved_popup);
		String Act_popup = getText(driver, Popup_Message);
		if (KYC_details_Saved_popup.equals(Act_popup)) {
			System.out.println("Popup Matched || Expected : " + KYC_details_Saved_popup + " || Actual : " + Act_popup);
			Extent_pass_New(driver, "Popup Matched || Expected : " + KYC_details_Saved_popup + " || Actual : " + Act_popup,
					test, test1);
		} else {
			System.out.println(
					"Popup Not Matched || Expected : " + KYC_details_Saved_popup + " || Actual : " + Act_popup);
			Extent_fail(driver,
					"Popup Not Matched || Expected : " + KYC_details_Saved_popup + " || Actual : " + Act_popup, test,
					test1);
		}

		waitForElement(driver, Refresh_Btn_KYC_Details);
		click(driver, Refresh_Btn_KYC_Details);

		waitForElement(driver, Country_Filter_Input_KYC_Details);
		sendKeys(driver, Country_Filter_Input_KYC_Details, Country_Code);

		waitForElement(driver, FieldName_Filter_Input_KYC_Details);
		sendKeys(driver, FieldName_Filter_Input_KYC_Details, Field_Name);

		waitForElement(driver, Mandatory_Filter_Input_KYC_Details);
		sendKeys(driver, Mandatory_Filter_Input_KYC_Details, Mandatory_Type);

		if (isDisplayed(driver, KYC_Details_Table_Column)) {
			System.out.println(
					"Expected :  Given KYC Details Should be Added in the Table || Actual : Given KYC Details Added in the Table Successfully");
			Extent_pass_New(driver,
					"Expected :  Given KYC Details Should be Added in the Table || Actual : Given KYC Details Added in the Table Successfully",
					test, test1);
		} else {
			System.out.println(
					"Expected :  Given KYC Details Should be Added in the Table || Actual : Given KYC Details Not Added in the Table");
			Extent_fail(driver,
					"Expected :  Given KYC Details Should be Added in the Table || Actual : Given KYC Details Not Added in the Table",
					test, test1);
		}

		navigateUrl_NewTab(driver, Ecomm_Registration);

		waitForElement(driver, RegisterOption_Ecomm_Register);
		click(driver, RegisterOption_Ecomm_Register);

		waitForElement(driver, Company_Name_Input_EcommRegister);
		sendKeys(driver, Company_Name_Input_EcommRegister, Company_Name_Value);

		waitForElement(driver, Country_Value_EComm_Register);
		selectByText(driver, Country_Value_EComm_Register, Country_Value);

		waitForElement(driver, Agency_Ecomm_Register);
		click(driver, Agency_Ecomm_Register);
		System.out.println("Agency_Value_Select : " + Agency_Value_Select);
		selectByText(driver, Agency_Ecomm_Register, Agency_Value_Select);

		waitForElement(driver, Address_Field_Ecomm_Register);
		sendKeys(driver, Address_Field_Ecomm_Register, Address_Value);

		waitForElement(driver, City_Field_EComm_Register);
		sendKeys(driver, City_Field_EComm_Register, City_Value);

		waitForElement(driver, Postal_Code_Input_EComm_Register);
		sendKeys(driver, Postal_Code_Input_EComm_Register, Postal_Code_Value);

		scrollElementToCenter(driver, Next_Button_EComm_Register);
		waitForElement(driver, Next_Button_EComm_Register);
		jsClick(driver, Next_Button_EComm_Register);

		scrollTop(driver);
		waitForElement(driver, Email_ID_EComm_Register);
		sendKeys(driver, Email_ID_EComm_Register, Email_ID_Value);

		waitForElement(driver, Password_Field_EComm_Register);
		sendKeys(driver, Password_Field_EComm_Register, Password_Value);

		waitForElement(driver, ConfirmPassword_EComm_Register);
		sendKeys(driver, ConfirmPassword_EComm_Register, Password_Value);

		waitForElement(driver, FirstName_titlt_Ecomm_Register);
		selectByText(driver, FirstName_titlt_Ecomm_Register, FirstName_Title);

		waitForElement(driver, FirstName_Field_Ecomm_Register);
		sendKeys(driver, FirstName_Field_Ecomm_Register, FirstName_Value);

		waitForElement(driver, LastName_Field_Ecomm_Register);
		sendKeys(driver, LastName_Field_Ecomm_Register, LastName_Value);

		waitForElement(driver, Country_Code_Input_Ecomm_Register);
		sendKeys(driver, Country_Code_Input_Ecomm_Register, Country_Code_Value);

		waitForElement(driver, Phone_Num_Field_Ecomm_Register);
		sendKeys(driver, Phone_Num_Field_Ecomm_Register, Mobile_Number);

		waitForElement(driver, Mobile_Code_Input_Ecomm_Register);
		sendKeys(driver, Mobile_Code_Input_Ecomm_Register, Country_Code_Value);

		waitForElement(driver, Mobile_Num_Field_Ecomm_Register);
		sendKeys(driver, Mobile_Num_Field_Ecomm_Register, Mobile_Number);

		waitForElement(driver, Time_Zone_Ecomm_Register);
		selectByText(driver, Time_Zone_Ecomm_Register, Time_Zone_Value);

		scrollElementToCenter(driver, Next_Button_EComm_Register);
		waitForElement(driver, Next_Button_EComm_Register);
		jsClick(driver, Next_Button_EComm_Register);

		String Mandatory_File = String.format(Mandatory_Field_Ecomm_Register, Field_Name);
		waitForDisplay(driver, Mandatory_File);
		if (Mandatory_Type.equalsIgnoreCase("Yes")) {
			if (isDisplayed(driver, Mandatory_File)) {
				System.out.println("Expected : " + Field_Name
						+ "  Field Name should present as Mandatory in the Ecomm Registration  When it is Yes in the KYC Details || Actual : "
						+ Field_Name
						+ "' Field is present as Mandatory in the Ecomm Registration  When it is Yes in the KYC Details");
				Extent_pass_New(driver, "Expected : " + Field_Name
						+ "  Field Name should present as Mandatory in the Ecomm Registration  When it is Yes in the KYC Details || Actaul : "
						+ Field_Name
						+ "' Field is present as Mandatory in the Ecomm Registration  When it is Yes in the KYC Details",
						test, test1);
			} else {
				System.out.println("Expected : " + Field_Name
						+ "  Field Name should present as Mandatory in the Ecomm Registration  When it is Yes in the KYC Details || Actual : "
						+ Field_Name
						+ "' Field is not present as Mandatory in the Ecomm Registration  When it is Yes in the KYC Details");
				Extent_fail(driver, "Expected : " + Field_Name
						+ "  Field Name should present as Mandatory in the Ecomm Registration  When it is Yes in the KYC Details || Actual : "
						+ Field_Name
						+ "' Field is not present as Mandatory in the Ecomm Registration  When it is Yes in the KYC Details",
						test, test1);
			}

		} else {
			if (isDisplayed(driver, Mandatory_File)) {
				System.out.println("Expected : " + Field_Name
						+ "  Field Name should not present as Mandatory in the Ecomm Registration  When it is No in the KYC Details || Actual : "
						+ Field_Name
						+ "' Field is present as Mandatory in the Ecomm Registration  When it is No in the KYC Details");
				Extent_fail(driver, "Expected : " + Field_Name
						+ "  Field Name should not present as Mandatory in the Ecomm Registration  When it is No in the KYC Details || Actual : "
						+ Field_Name
						+ "' Field is present as Mandatory in the Ecomm Registration  When it is No in the KYC Details",
						test, test1);
			} else {
				System.out.println("Expected : " + Field_Name
						+ "  Field Name should not present as Mandatory in the Ecomm Registration  When it is No in the KYC Details || Actual : "
						+ Field_Name
						+ "' Field is not present as Mandatory in the Ecomm Registration  When it is No in the KYC Details");
				Extent_pass_New(driver, "Expected : " + Field_Name
						+ "  Field Name should not present as Mandatory in the Ecomm Registration  When it is No in the KYC Details || Actual : "
						+ Field_Name
						+ "' Field is not present as Mandatory in the Ecomm Registration  When it is No in the KYC Details",
						test, test1);
			}
		}
		Step_End(3, " Select whether the field is mandatory (Yes/No)", test, test1);

		Extent_completed(testcase_Name, test, test1);

	}

}
