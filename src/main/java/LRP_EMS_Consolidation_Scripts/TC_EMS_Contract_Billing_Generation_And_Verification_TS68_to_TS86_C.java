package LRP_EMS_Consolidation_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;
import locators.EMS_Contract_Billing_Generation_And_Verification_Locators;

public class TC_EMS_Contract_Billing_Generation_And_Verification_TS68_to_TS86_C extends Keywords {
	public void EMS_Contract_Billing_Generation_And_Verification_TS68_to_TS86_C(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset) throws Throwable {
		int i=1;
		if(i==1) {
			String testCase_Name="TC_EMS_Contract_Billing_Generation_68";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_068 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);

			String url = TestNgXml.getdatafromExecution().get(testCase_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_068, testCase_Name, "Dataset"+selected_dataset, File_Path);
			String user_Name = data.get("Username");
			String pass_word = data.get("Password");
			String Field_Names = data.get("Field_Names");
			String Values_Should_Be_Selected_Popup_Txt = data.get("Values_Should_Be_Selected_Popup");
			String Search_Contract_No_Popup_Txt_Exp = data.get("Search_Contract_No_Popup_Txt");
			Extent_Start(testCase_Name, test, test1);
			navigateUrl(driver, url);
			// Login
			LRP_Login(driver, user_Name, pass_word);
			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			Step_Start(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			waitForDisplay(driver, P_Contract_Module_Page);
			if (isdisplayed(driver, P_Contract_Module_Page)) {
				System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
				Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
			} else {
				System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
				Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
			}
			Step_End(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			Step_Start(2, "Click (+) button from Contract No field", test, test1);
		
			waitForElement(driver, P_Contact_No_Plus_Btn);
			click(driver, P_Contact_No_Plus_Btn);
			Step_End(2, "Click (+) button from Contract No field", test, test1);
			Step_Start(3, "Ensure that system should validate if user try to click select button without selecting any checkbox from Search Contract No list", test, test1);

		
			waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
			String Act_Popup = getText(driver, P_Search_Contract_No_Popup);
			if (Search_Contract_No_Popup_Txt_Exp.equals(Act_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_pass_New(driver,
						"Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			}
			waitForElement(driver, P_Search_Contract_No_Popup_SelBtn);
			click(driver, P_Search_Contract_No_Popup_SelBtn);
		
			Step_End(3, "Ensure that system should validate if user try to click select button without selecting any checkbox from Search Contract No list", test, test1);
			Step_Start(4, "Ensure that system should validate as 'Values should be selected'.", test, test1);
			waitForPopup(driver, P_Search_Contract_Alert_Msg, Values_Should_Be_Selected_Popup_Txt);
			String alertMsg = getText(driver, P_Search_Contract_Alert_Msg);
			if (Values_Should_Be_Selected_Popup_Txt.equals(alertMsg)) {
				System.out.println("Matched || " + " Expected Popup is : "+ Values_Should_Be_Selected_Popup_Txt + " || Actual Popup is : " + alertMsg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Values_Should_Be_Selected_Popup_Txt + " || Actual Popup is : " + alertMsg, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Values_Should_Be_Selected_Popup_Txt + " || Actual Popup is : " + alertMsg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Values_Should_Be_Selected_Popup_Txt + " || Actual Popup is : " + alertMsg,test, test1);
			}
			Step_End(4, "Ensure that system should validate as 'Values should be selected'.", test, test1);
			Extent_completed(testCase_Name, test, test1);
			waitForElement(driver, P_Search_Contract_Alert_Close);
			click(driver, P_Search_Contract_Alert_Close);

			waitForElement(driver, P_Search_Contract_No_Popup_Close);
			click(driver, P_Search_Contract_No_Popup_Close);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCase_Name="TC_EMS_Contract_Billing_Generation_69";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_069 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_069, testCase_Name, "Dataset"+selected_dataset, File_Path);
			String Field_Names = data.get("Field_Names");
			String Contaract_No_input = data.get("Contaract_No");
			String Enter_Password_Popup_Txt_Exp = data.get("Enter_Password_Popup_Txt");
			String Password_Popup_Input_Txt = data.get("Password_Popup_Input");
			String Search_Contract_No_Popup_Txt_Exp = data.get("Search_Contract_No_Popup_Txt");
			String Month_Select_For69 = data.get("Month_Select_For69");
			String Year_Select_For69 = data.get("Year_Select_For69");
			String generate_Button = data.get("generate_Button");
			String Condition =data.get("Condition");
			String Search_Contract_No_Column_Header =data.get("Search_Contract_No_Column_Header");

			String month_Select69 = String.format(month_Select,  Month_Select_For69);
			String generatebutton =  String.format(Generatebutton,  generate_Button);

			Extent_Start(testCase_Name, test, test1);
			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			Step_Start(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			waitForDisplay(driver, P_Contract_Module_Page);
			if (isdisplayed(driver, P_Contract_Module_Page)) {
				System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
				Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
			} else {
				System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
				Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
			}
			
			Step_End(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			Step_Start(2, "Click (+) button from Contract No field", test, test1);

			waitForElement(driver, P_Contact_No_Plus_Btn);
			click(driver, P_Contact_No_Plus_Btn);
			Step_End(2, "Click (+) button from Contract No field", test, test1);


			waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
			String Act_Popup = getText(driver, P_Search_Contract_No_Popup);
			if (Search_Contract_No_Popup_Txt_Exp.equals(Act_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_pass_New(driver,
						"Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			}
			Step_Start(3, "Select required contract no from the field", test, test1);

			twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
			Step_End(3, "Select required contract no from the field", test, test1);
			if (!Year_Select_For69.equals("")) {

				waitForElement(driver, P_Bill_Period_Year_Field);
				System.out.println("Year_Select_For69 : " + Year_Select_For69);
				clearAndType(driver, P_Bill_Period_Year_Field, Year_Select_For69);
			}
			if (!Month_Select_For69.equals("")) {

				waitForElement(driver, P_Bill_Period_Month_DD);
				click(driver, P_Bill_Period_Month_DD);

				System.out.println("Month_Select_For69 : " + Month_Select_For69);
				waitForElement(driver, month_Select69);
				click(driver, month_Select69);
			}

			Step_Start(4, "Click on Generate Bills", test, test1);
			waitForElement(driver, generatebutton);
			click(driver, generatebutton);
			Step_Start(4, "Click on Generate Bills", test, test1);
			Step_Start(5, "Ensure that system should validate if user try to enter Incorrect password and click ok button", test, test1);

			waitForElement(driver, P_Authentication_popup);
			waitForElement(driver, P_Authentication_popup_TxtField);
			click(driver, P_Authentication_popup_TxtField);
			sendKeys(driver, P_Authentication_popup_TxtField, Password_Popup_Input_Txt);
			waitForElement(driver, P_Authentication_popup_OkBtn);
			click(driver, P_Authentication_popup_OkBtn);
			Step_End(5, "Ensure that system should validate if user try to enter Incorrect password and click ok button", test, test1);
			Step_Start(6, "Ensure that system should validate as 'Incorrect Password'.", test, test1);

			waitForPopup(driver, Popup_Message, Enter_Password_Popup_Txt_Exp);
			String act_PopUpMsg = getText(driver, Popup_Message);
			if (Enter_Password_Popup_Txt_Exp.equals(act_PopUpMsg)) {
				System.out.println("Matched || " + " Expected Popup is : " + Enter_Password_Popup_Txt_Exp
						+ " || Actual Popup is : " + act_PopUpMsg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Enter_Password_Popup_Txt_Exp
						+ " || Actual Popup is : " + act_PopUpMsg, test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "
						+ Enter_Password_Popup_Txt_Exp + " || Actual Popup is : " + act_PopUpMsg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "
						+ Password_Popup_Input_Txt + " || Actual Popup is : " + act_PopUpMsg, test,
						test1);
			}
			Step_End(6, "Ensure that system should validate as 'Incorrect Password'.", test, test1);
			Extent_completed(testCase_Name, test, test1);
			scrollTop(driver);
			waitForElement(driver, P_Authentication_popup_Close);
			click(driver, P_Authentication_popup_Close);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCase_Name="TC_EMS_Contract_Billing_Generation_70";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_070 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_070, testCase_Name, "Dataset"+selected_dataset, File_Path);
			String Field_Names = data.get("Field_Names");
			String Contaract_No_input = data.get("Contaract_No");
			String Enter_Password_Popup_Txt_Exp = data.get("Enter_Password_Popup_Txt");
			String Password_Popup_Input_Txt = data.get("Password_Popup_Input");
			String Search_Contract_No_Popup_Txt_Exp = data.get("Search_Contract_No_Popup_Txt");
			String Month_Select_For70 = data.get("Month_Select_For70");
			String Year_Select_For70 = data.get("Year_Select_For70");
			String generate_Button = data.get("generate_Button");
			String Condition =data.get("Condition");
			String Search_Contract_No_Column_Header =data.get("Search_Contract_No_Column_Header");
			String month_Select70 = String.format(month_Select,  Month_Select_For70);
			String generatebutton =  String.format(Generatebutton,  generate_Button);

			Extent_Start(testCase_Name, test, test1);
			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			Step_Start(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			waitForDisplay(driver, P_Contract_Module_Page);
			if (isdisplayed(driver, P_Contract_Module_Page)) {
				System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
				Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
			} else {
				System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
				Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
			}
			
			Step_End(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			Step_Start(2, "Click (+) button from Contract No field", test, test1);

			waitForElement(driver, P_Contact_No_Plus_Btn);
			click(driver, P_Contact_No_Plus_Btn);
			Step_End(2, "Click (+) button from Contract No field", test, test1);


			waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
			String Act_Popup = getText(driver, P_Search_Contract_No_Popup);
			if (Search_Contract_No_Popup_Txt_Exp.equals(Act_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_pass_New(driver,
						"Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			}
			Step_Start(3, "Select required contract no from the field", test, test1);

			twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
			Step_End(3, "Select required contract no from the field", test, test1);
			if (!Year_Select_For70.equals("")) {

				waitForElement(driver, P_Bill_Period_Year_Field);
				System.out.println("Year_Select_For70 : " + Year_Select_For70);
				clearAndType(driver, P_Bill_Period_Year_Field, Year_Select_For70);
			}
			if (!Month_Select_For70.equals("")) {

				waitForElement(driver, P_Bill_Period_Month_DD);
				click(driver, P_Bill_Period_Month_DD);
				System.out.println("Month_Select_For70 : " + Month_Select_For70);
				click(driver, month_Select70);
			}

			Step_Start(4, "Click on Generate Bills", test, test1);
			waitForElement(driver, generatebutton);
			click(driver, generatebutton);
			Step_Start(4, "Click on Generate Bills", test, test1);
			Step_Start(5, " Ensure that system should validate if user try to leave blank password and click ok button", test, test1);

			waitForElement(driver, P_Authentication_popup);
			waitForElement(driver, P_Authentication_popup_TxtField);
			click(driver, P_Authentication_popup_TxtField);
			sendKeys(driver, P_Authentication_popup_TxtField, Password_Popup_Input_Txt);
			waitForElement(driver, P_Authentication_popup_OkBtn);
			click(driver, P_Authentication_popup_OkBtn);
			Step_End(5, " Ensure that system should validate if user try to leave blank password and click ok button", test, test1);
			Step_Start(6, "Ensure that system should validate as 'Enter Password'.", test, test1);

			waitForPopup(driver, Popup_Message, Enter_Password_Popup_Txt_Exp);
			String act_PopUpMsg = getText(driver, Popup_Message);
			if (Enter_Password_Popup_Txt_Exp.equals(act_PopUpMsg)) {
				System.out.println("Matched || " + " Expected Popup is : " + Enter_Password_Popup_Txt_Exp
						+ " || Actual Popup is : " + act_PopUpMsg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Enter_Password_Popup_Txt_Exp
						+ " || Actual Popup is : " + act_PopUpMsg, test, test1);
			}else{
				System.out.println("Not Matched || " + " Expected Popup is : "
						+ Enter_Password_Popup_Txt_Exp + " || Actual Popup is : " + act_PopUpMsg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "
						+ Enter_Password_Popup_Txt_Exp + " || Actual Popup is : " + act_PopUpMsg, test,
						test1);
			}
			Step_End(6, "Ensure that system should validate as 'Enter Password'.", test, test1);
			Extent_completed(testCase_Name, test, test1);
			scrollTop(driver);
			waitForElement(driver, P_Authentication_popup_Close);
			click(driver, P_Authentication_popup_Close);

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCase_Name="TC_EMS_Contract_Billing_Generation_71";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_071 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_071, testCase_Name, "Dataset"+selected_dataset, File_Path);

			String Field_Names = data.get("Field_Names");
			String Contaract_No_input = data.get("Contaract_No");
			String Password_Popup_Input_Txt = data.get("Password_Popup_Input");
			String Verification_Popup_Txt_Exp = data.get("Verification_Popup_Txt");
			String Search_Contract_No_Popup_Txt_Exp = data.get("Search_Contract_No_Popup_Txt");
			String Month_Select_For71 = data.get("Month_Select_For71");
			String Year_Select_For71 = data.get("Year_Select_For71");
			String generate_Button = data.get("generate_Button");
			String Condition =data.get("Condition");
			String Search_Contract_No_Column_Header =data.get("Search_Contract_No_Column_Header");
			//locators
			String month_Select71 = String.format(month_Select,  Month_Select_For71);
			String generatebutton =  String.format(Generatebutton,  generate_Button);
			Extent_Start(testCase_Name, test, test1);

			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			Step_Start(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			waitForDisplay(driver, P_Contract_Module_Page);
			if (isdisplayed(driver, P_Contract_Module_Page)) {
				System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
				Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
			} else {
				System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
				Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
			}
			
			Step_End(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			Step_Start(2, "Click (+) button from Contract No field", test, test1);

			waitForElement(driver, P_Contact_No_Plus_Btn);
			click(driver, P_Contact_No_Plus_Btn);
			Step_End(2, "Click (+) button from Contract No field", test, test1);


			waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
			String Act_Popup = getText(driver, P_Search_Contract_No_Popup);
			if (Search_Contract_No_Popup_Txt_Exp.equals(Act_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_pass_New(driver,
						"Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			}
			Step_Start(3, "Select required contract no from the field", test, test1);
			twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
			Step_End(3, "Select required contract no from the field", test, test1);
			if (!Year_Select_For71.equals("")) {

				waitForElement(driver, P_Bill_Period_Year_Field);
				System.out.println("Year_Select_For71 : " + Year_Select_For71);
				clearAndType(driver, P_Bill_Period_Year_Field, Year_Select_For71);
			}
			if (!Month_Select_For71.equals("")) {

				waitForElement(driver, P_Bill_Period_Month_DD);
				click(driver, P_Bill_Period_Month_DD);

				System.out.println("Month_Select_For71 : " + Month_Select_For71);
				waitForElement(driver, month_Select71);
				click(driver, month_Select71);
			}

			Step_Start(4, "Click on Generate Bills", test, test1);
			waitForElement(driver, generatebutton);
			click(driver, generatebutton);
			Step_Start(4, "Click on Generate Bills", test, test1);
			Step_Start(5, "Ensure that system should show confirmation message if user try to enter valid password and click ok button", test, test1);

			waitForElement(driver, P_Authentication_popup);
			waitForElement(driver, P_Authentication_popup_TxtField);
			click(driver, P_Authentication_popup_TxtField);
			sendKeys(driver, P_Authentication_popup_TxtField, Password_Popup_Input_Txt);
			waitForElement(driver, P_Authentication_popup_OkBtn);
			click(driver, P_Authentication_popup_OkBtn);
			Step_End(5, "Ensure that system should show confirmation message if user try to enter valid password and click ok button", test, test1);
			Step_Start(6, "Ensure that system should show confirmation message as 'Do you need to run the Bill(s) for Feb 2024?.", test, test1);

			waitForPopup(driver, popup_Message, Verification_Popup_Txt_Exp);
			String actual_PopUpMsg = getText(driver, popup_Message);
			if (actual_PopUpMsg.contains(Verification_Popup_Txt_Exp)) {
				System.out.println("Matched || " + " Expected Popup is : " + Verification_Popup_Txt_Exp+ " || Actual Popup is : " + actual_PopUpMsg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Verification_Popup_Txt_Exp + " || Actual Popup is : " + actual_PopUpMsg,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Verification_Popup_Txt_Exp+ " || Actual Popup is : " + actual_PopUpMsg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Verification_Popup_Txt_Exp + " || Actual Popup is : " + actual_PopUpMsg,test, test1);
			}
			Step_End(6, "Ensure that system should show confirmation message as 'Do you need to run the Bill(s) for Feb 2024?.", test, test1);
			Extent_completed(testCase_Name, test, test1);
			scrollTop(driver);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCase_Name="TC_EMS_Contract_Billing_Generation_72";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_072 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_072, testCase_Name, "Dataset"+selected_dataset, File_Path);

			String Field_Names = data.get("Field_Names");
			String Contaract_No_input = data.get("Contaract_No");
			String Password_Popup_Input_Txt = data.get("Password_Popup_Input");
			String Verification_Popup_Txt_Exp = data.get("Verification_Popup_Txt");
			String Bills_Generated_Popup_Txt = data.get("Bills_Generated_Popup");
			String Search_Contract_No_Popup_Txt_Exp = data.get("Search_Contract_No_Popup_Txt");
			String Month_Select_For72 = data.get("Month_Select_For72");
			String Year_Select_For72 = data.get("Year_Select_For72");
			String generate_Button = data.get("generate_Button");
			String Condition =data.get("Condition");
			String Search_Contract_No_Column_Header =data.get("Search_Contract_No_Column_Header");
			//locators
			String month_Select72 = String.format(month_Select,  Month_Select_For72);
			String generatebutton =  String.format(Generatebutton,  generate_Button);
			Extent_Start(testCase_Name, test, test1);

			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			Step_Start(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			waitForDisplay(driver, P_Contract_Module_Page);
			if (isdisplayed(driver, P_Contract_Module_Page)) {
				System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
				Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
			} else {
				System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
				Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
			}
			Step_End(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			Step_Start(2, "Click (+) button from Contract No field", test, test1);

			waitForElement(driver, P_Contact_No_Plus_Btn);
			click(driver, P_Contact_No_Plus_Btn);
			Step_End(2, "Click (+) button from Contract No field", test, test1);


			waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
			String Act_Popup = getText(driver, P_Search_Contract_No_Popup);
			if (Search_Contract_No_Popup_Txt_Exp.equals(Act_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			}
			Step_Start(3, "Select required contract no from the field", test, test1);
			twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
			Step_End(3, "Select required contract no from the field", test, test1);

			if (!Year_Select_For72.equals("")) {

				waitForElement(driver, P_Bill_Period_Year_Field);
				System.out.println("Year_Select_For72 : " + Year_Select_For72);
				clearAndType(driver, P_Bill_Period_Year_Field, Year_Select_For72);
			}
			if (!Month_Select_For72.equals("")) {

				waitForElement(driver, P_Bill_Period_Month_DD);
				click(driver, P_Bill_Period_Month_DD);

				System.out.println("Month_Select_For72 : " + Month_Select_For72);
				waitForElement(driver, month_Select72);
				click(driver, month_Select72);
			}

			Step_Start(4, "Click on Generate Bills", test, test1);
			waitForElement(driver, generatebutton);
			click(driver, generatebutton);
			Step_Start(4, "Click on Generate Bills", test, test1);
			Step_Start(5, "Ensure that system should show successfull message if user generated billing after clicking 'yes' once valid password is given", test, test1);

			waitForElement(driver, P_Authentication_popup);
			waitForElement(driver, P_Authentication_popup_TxtField);
			click(driver, P_Authentication_popup_TxtField);
			sendKeys(driver, P_Authentication_popup_TxtField, Password_Popup_Input_Txt);
			waitForElement(driver, P_Authentication_popup_OkBtn);
			click(driver, P_Authentication_popup_OkBtn);
			Step_End(5, "Ensure that system should show successfull message if user generated billing after clicking 'yes' once valid password is given", test, test1);

			waitForPopup(driver, popup_Message, Verification_Popup_Txt_Exp);
			String actual_PopUpMsg = getText(driver, popup_Message);
			if (actual_PopUpMsg.contains(Verification_Popup_Txt_Exp)) {
				System.out.println("Matched || " + " Expected Popup is : " + Verification_Popup_Txt_Exp+ " || Actual Popup is : " + actual_PopUpMsg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Verification_Popup_Txt_Exp + " || Actual Popup is : " + actual_PopUpMsg,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Verification_Popup_Txt_Exp+ " || Actual Popup is : " + actual_PopUpMsg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Verification_Popup_Txt_Exp + " || Actual Popup is : " + actual_PopUpMsg,test, test1);
			}
			Step_Start(6, "Ensure that system should show confirmation message as 'Bills Successfully Generated for FEB 2024'.", test, test1);
			click(driver, popup_Message_Yes_Button);
			
			waitForPopup(driver, Popup_Message, Bills_Generated_Popup_Txt);
			String act_popUp_Msg = getText(driver, Popup_Message).trim();

			if (act_popUp_Msg.contains(Bills_Generated_Popup_Txt)) {
				System.out.println("Matched || " + " Expected Popup is : " + Bills_Generated_Popup_Txt+ " || Actual Popup is : " + act_popUp_Msg);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Bills_Generated_Popup_Txt+ " || Actual Popup is : " + act_popUp_Msg,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Bills_Generated_Popup_Txt + " || Actual Popup is : "+ act_popUp_Msg);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : "+ Bills_Generated_Popup_Txt + " || Actual Popup is : "+ act_popUp_Msg,test, test1);
			}
			Step_End(6, "Ensure that system should show confirmation message as 'Bills Successfully Generated for FEB 2024'.", test, test1);
			Extent_completed(testCase_Name, test, test1);	
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCase_Name="TC_EMS_Contract_Billing_Generation_73";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_073 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_073, testCase_Name, "Dataset"+selected_dataset, File_Path);

			String Field_Names = data.get("Field_Names");
			String Contaract_No_input = data.get("Contaract_No");
			String Search_Contract_No_Popup_Txt_Exp = data.get("Search_Contract_No_Popup_Txt");
			String Select_Contract_No_Popup_Txt_Exp = data.get("Select_Contract_No_Popup_Txt");
			String Month_Select_For73 = data.get("Month_Select_For73");
			String Year_Select_For73 = data.get("Year_Select_For73");
			String show_Bills_Button = data.get("show_Bills_Button");
			String ContractNo_CheckBox_Select = data.get("ContractNo_CheckBox_Select");
			String Condition =data.get("Condition");
			String Search_Contract_No_Column_Header =data.get("Search_Contract_No_Column_Header");
			//locators
			String month_Select73 = String.format(month_Select,  Month_Select_For73);
			String show_Bills =  String.format(Generatebutton,  show_Bills_Button);
			String ContractNo_Select_CheckBox =  String.format(ContractNo_Select_ChkBox,  Contaract_No_input);

			Extent_Start(testCase_Name, test, test1);

			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			Step_Start(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			waitForDisplay(driver, P_Contract_Module_Page);
			if (isdisplayed(driver, P_Contract_Module_Page)) {
				System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
				Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
			} else {
				System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
				Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
			}
			
			Step_End(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			Step_Start(2, "Click (+) button from Contract No field", test, test1);
			waitForElement(driver, P_Contact_No_Plus_Btn);
			click(driver, P_Contact_No_Plus_Btn);
			Step_End(2, "Click (+) button from Contract No field", test, test1);

			waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
			String Act_Popup = getText(driver, P_Search_Contract_No_Popup);
			if (Search_Contract_No_Popup_Txt_Exp.equals(Act_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			}
			Step_Start(3, "Select required contract no from the field", test, test1);
			twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
			Step_End(3, "Select required contract no from the field", test, test1);
			if (!Year_Select_For73.equals("")) {
				waitForElement(driver, P_Bill_Period_Year_Field);
				System.out.println("Year_Select_For73 : " + Year_Select_For73);
				clearAndType(driver, P_Bill_Period_Year_Field, Year_Select_For73);
			}
			if (!Month_Select_For73.equals("")) {
				waitForElement(driver, P_Bill_Period_Month_DD);
				click(driver, P_Bill_Period_Month_DD);
				System.out.println("Month_Select_For73 : " + Month_Select_For73);
				waitForElement(driver, month_Select73);
				click(driver, month_Select73);
			}
			Step_Start(4, "Click on Show bills", test, test1);
			waitForElement(driver, show_Bills);
			click(driver, show_Bills);
			Step_End(4, "Click on Show bills", test, test1);
			Step_Start(5, "Ensure that system should validate if user try to click verify button when check is not selected in summary", test, test1);
			waitForElement(driver, ContractNo_Select_CheckBox);
			checkBox(driver, ContractNo_Select_CheckBox, ContractNo_CheckBox_Select);
			waitForElement(driver, P_Verify_Btn);
			click(driver, P_Verify_Btn);
			Step_End(5, "Ensure that system should validate if user try to click verify button when check is not selected in summary", test, test1);
			Step_Start(6, "Ensure that system should show confirmation message as 'Select a Contract No.'", test, test1);
			waitForPopup(driver, Popup_Message, Select_Contract_No_Popup_Txt_Exp);
			String ActualPopup_Msg = getText(driver, Popup_Message);
			if(Select_Contract_No_Popup_Txt_Exp.equals(ActualPopup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : " + Select_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + ActualPopup_Msg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Select_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + ActualPopup_Msg, test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Select_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + ActualPopup_Msg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Select_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + ActualPopup_Msg, test,test1);
			}
			Step_End(6, "Ensure that system should show confirmation message as 'Select a Contract No.'", test, test1);
			Extent_completed(testCase_Name, test, test1);
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCase_Name="TC_EMS_Contract_Billing_Generation_74";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_074 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_074, testCase_Name,"Dataset" + selected_dataset, File_Path);
			String Field_Names = data.get("Field_Names");
			String Contaract_No_input = data.get("Contaract_No");
			String Search_Contract_No_Popup_Txt_Exp = data.get("Search_Contract_No_Popup_Txt");
			String Add_Remarks_Popup_Txt = data.get("Add_Remarks_Popup");
			String Remark_Txt_Field_input = data.get("Remark_Txt_Field");
			String Enter_Verify_Remarks_Popup_Txt_Exp = data.get("Enter_Verify_Remarks_Popup_Txt");
			String Month_Select_For74 = data.get("Month_Select_For74");
			String Year_Select_For74 = data.get("Year_Select_For74");
			String show_Bills_Button = data.get("show_Bills_Button");
			String ContractNo_CheckBox_Select = data.get("ContractNo_CheckBox_Select");
			String Condition =data.get("Condition");
			String Search_Contract_No_Column_Header =data.get("Search_Contract_No_Column_Header");

			String month_Select74 = String.format(month_Select,  Month_Select_For74);
			String show_Bills =  String.format(Generatebutton,  show_Bills_Button);
			String ContractNo_Select_CheckBox =  String.format(ContractNo_Select_ChkBox,  Contaract_No_input);

			Extent_Start(testCase_Name, test, test1);
			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			Step_Start(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			waitForDisplay(driver, P_Contract_Module_Page);
			if (isdisplayed(driver, P_Contract_Module_Page)) {
				System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
				Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
			} else {
				System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
				Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
			}
			Step_End(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			Step_Start(2, "Click (+) button from Contract No field", test, test1);
			//wait(driver, "3");
			waitForElement(driver, P_Contact_No_Plus_Btn);
			click(driver, P_Contact_No_Plus_Btn);
			Step_End(2, "Click (+) button from Contract No field", test, test1);

			waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
			String Act_Popup = getText(driver, P_Search_Contract_No_Popup);
			if (Search_Contract_No_Popup_Txt_Exp.equals(Act_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			}
			Step_Start(3, "Select required contract no from the field", test, test1);
			twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
			Step_End(3, "Select required contract no from the field", test, test1);

			if (!Year_Select_For74.equals("")) {
				waitForElement(driver, P_Bill_Period_Year_Field);
				System.out.println("Year_Select_For74 : " + Year_Select_For74);
				clearAndType(driver, P_Bill_Period_Year_Field, Year_Select_For74);
			}
			if (!Month_Select_For74.equals("")) {
				waitForElement(driver, P_Bill_Period_Month_DD);
				click(driver, P_Bill_Period_Month_DD);
				System.out.println("Month_Select_For74 : " + Month_Select_For74);
				waitForElement(driver, month_Select74);
				click(driver, month_Select74);
			}
			Step_Start(4, "Click on Show bills", test, test1);
			waitForElement(driver, show_Bills);
			click(driver, show_Bills);
			Step_End(4, "Click on Show bills", test, test1);
			Step_Start(5, "Select the checkbox from the contract summary for required contract", test, test1);
			waitForElement(driver, ContractNo_Select_CheckBox);
			checkBox(driver, ContractNo_Select_CheckBox, ContractNo_CheckBox_Select);
			Step_End(5, "Select the checkbox from the contract summary for required contract", test, test1);
			Step_Start(6, "Click verify button", test, test1);
			waitForElement(driver, P_Verify_Btn);
			click(driver, P_Verify_Btn);
			Step_End(6, "Click verify button", test, test1);
			Step_Start(7, "Ensure that system should validate if user try to click 'ok' for verify button when remarks given blank.", test, test1);
			waitForElement(driver, P_Add_Remark_Title);
			String Act_Popup_Msg = getText(driver, P_Add_Remark_Title);
			if (Add_Remarks_Popup_Txt.equals(Act_Popup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : " + Add_Remarks_Popup_Txt+ " || Actual Popup is : " + Act_Popup_Msg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg, test,test1);
			}
			waitForElement(driver, P_Remark_Txt_Field);
			click(driver, P_Remark_Txt_Field);
			waitForElement(driver, P_Remark_Txt_Field);
			sendKeys(driver, P_Remark_Txt_Field, Remark_Txt_Field_input);
			waitForElement(driver, P_Remark_Ok_Btn);
			click(driver, P_Remark_Ok_Btn);
			Step_End(7, "Ensure that system should validate if user try to click 'ok' for verify button when remarks given blank.", test, test1);
			Step_Start(8, "Ensure that system should show confirmation message as 'Enter the verify Remarks'.", test, test1);
			waitForPopup(driver, Popup_Message, Search_Contract_No_Popup_Txt_Exp);
			String Enter_verify_Remark = getText(driver, Popup_Message);
			if (Enter_Verify_Remarks_Popup_Txt_Exp.equals(Enter_verify_Remark)) {
				System.out.println("Matched || " + " Expected Popup is : "+ Enter_Verify_Remarks_Popup_Txt_Exp + " || Actual Popup is : "+ Enter_verify_Remark);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : "+ Enter_Verify_Remarks_Popup_Txt_Exp+ " || Actual Popup is : " + Enter_verify_Remark,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Enter_Verify_Remarks_Popup_Txt_Exp + " || Actual Popup is : "+ Enter_verify_Remark);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : "+ Enter_Verify_Remarks_Popup_Txt_Exp+ " || Actual Popup is : " + Enter_verify_Remark,test, test1);
			}
			Step_End(8, "Ensure that system should show confirmation message as 'Enter the verify Remarks'.", test, test1);
			Extent_completed(testCase_Name, test, test1);
			scrollTop(driver);
			waitForElement(driver, P_Verify_Remark_Close);
			click(driver, P_Verify_Remark_Close);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCase_Name="TC_EMS_Contract_Billing_Generation_75";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_075 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_075, testCase_Name, "Dataset"+selected_dataset, File_Path);
			String Field_Names = data.get("Field_Names");
			String Contaract_No_input = data.get("Contaract_No");
			String Search_Contract_No_Popup_Txt_Exp = data.get("Search_Contract_No_Popup_Txt");
			String Add_Remarks_Popup_Txt = data.get("Add_Remarks_Popup");
			String Verified_Popup_Txt = data.get("Verified_Popup");
			String Remark_Txt_Field_input = data.get("Remark_Txt_Field");
			String Month_Select_For75 = data.get("Month_Select_For75");
			String Year_Select_For75 = data.get("Year_Select_For75");
			String show_Bills_Button = data.get("show_Bills_Button");
			String ContractNo_CheckBox_Select = data.get("ContractNo_CheckBox_Select");
			String Condition =data.get("Condition");
			String Search_Contract_No_Column_Header =data.get("Search_Contract_No_Column_Header");
			//locators
			String month_Select75 = String.format(month_Select,  Month_Select_For75);
			String show_Bills =  String.format(Generatebutton,  show_Bills_Button);
			String ContractNo_Select_CheckBox =  String.format(ContractNo_Select_ChkBox,  Contaract_No_input);

			Extent_Start(testCase_Name, test, test1);
			// Login
			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			Step_Start(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			waitForDisplay(driver, P_Contract_Module_Page);
			if (isdisplayed(driver, P_Contract_Module_Page)) {
				System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
				Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
			} else {
				System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
				Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
			}
			Step_End(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			Step_Start(2, "Click (+) button from Contract No field", test, test1);
			waitForElement(driver, P_Contact_No_Plus_Btn);
			click(driver, P_Contact_No_Plus_Btn);
			Step_End(2, "Click (+) button from Contract No field", test, test1);

			waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
			String Act_Popup = getText(driver, P_Search_Contract_No_Popup);
			if (Search_Contract_No_Popup_Txt_Exp.equals(Act_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			}
			Step_Start(3, "Select required contract no from the field", test, test1);
			twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
			Step_End(3, "Select required contract no from the field", test, test1);
			if (!Year_Select_For75.equals("")) {
				waitForElement(driver, P_Bill_Period_Year_Field);
				System.out.println("Year_Select_For75 : " + Year_Select_For75);
				clearAndType(driver, P_Bill_Period_Year_Field, Year_Select_For75);
			}
			if (!Month_Select_For75.equals("")) {
				waitForElement(driver, P_Bill_Period_Month_DD);
				click(driver, P_Bill_Period_Month_DD);
				System.out.println("Month_Select_For75 : " + Month_Select_For75);
				waitForElement(driver, month_Select75);
				click(driver, month_Select75);
			}
			Step_Start(4, "Click on Show bills", test, test1);
			waitForElement(driver, show_Bills);
			click(driver, show_Bills);
			Step_End(4, "Click on Show bills", test, test1);
			Step_Start(5, "Select the checkbox from the contract summary for required contract", test, test1);
			waitForElement(driver, ContractNo_Select_CheckBox);
			checkBox(driver, ContractNo_Select_CheckBox, ContractNo_CheckBox_Select);
			Step_End(5, "Select the checkbox from the contract summary for required contract", test, test1);
			Step_Start(6, "Click verify button after entering remarks", test, test1);
			waitForElement(driver, P_Verify_Btn);
			click(driver, P_Verify_Btn);
			Step_End(6, "Click verify button after entering remarks", test, test1);
			Step_Start(7, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			waitForElement(driver, P_Add_Remark_Title);
			String Act_Popup_Msg = getText(driver, P_Add_Remark_Title);
			if (Add_Remarks_Popup_Txt.equals(Act_Popup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : " + Add_Remarks_Popup_Txt+ " || Actual Popup is : " + Act_Popup_Msg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg, test,test1);
			}
			waitForElement(driver, P_Remark_Txt_Field);
			click(driver, P_Remark_Txt_Field);
			waitForElement(driver, P_Remark_Txt_Field);
			sendKeys(driver, P_Remark_Txt_Field, Remark_Txt_Field_input);
			waitForElement(driver, P_Remark_Ok_Btn);
			click(driver, P_Remark_Ok_Btn);
			Step_End(7, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			Step_Start(8, "Ensure that system should show confirmation message as 'Verified Successfully'.", test, test1);
			waitForPopup(driver, Popup_Message, Verified_Popup_Txt);
			String act_Popup_Msg = getText(driver, Popup_Message);
			if (Verified_Popup_Txt.equals(act_Popup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg, test,test1);
			}
			Step_End(8, "Ensure that system should show confirmation message as 'Verified Successfully'.", test, test1);
			Extent_completed(testCase_Name, test, test1);
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCase_Name="TC_EMS_Contract_Billing_Generation_76";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_076 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_076, testCase_Name, "Dataset"+selected_dataset, File_Path);
			String Field_Names = data.get("Field_Names");
			String Contaract_No_input = data.get("Contaract_No");
			String Password_Popup_Input_Txt = data.get("Password_Popup_Input");
			String Search_Contract_No_Popup_Txt_Exp = data.get("Search_Contract_No_Popup_Txt");
			String Add_Remarks_Popup_Txt = data.get("Add_Remarks_Popup");
			String Verified_Popup_Txt = data.get("Verified_Popup");
			String Remark_Txt_Field_input = data.get("Remark_Txt_Field");
			String Highlighted_RedColor_txt_Exp = data.get("Highlighted_RedColor_txt");
			String Do_You_Want_Regenerate = data.get("Do_You_Want_Regenerate");
			String Month_Select_For76 = data.get("Month_Select_For76");
			String Year_Select_For76 = data.get("Year_Select_For76");
			String show_Bills_Button = data.get("show_Bills_Button");
			String ContractNo_CheckBox_Select = data.get("ContractNo_CheckBox_Select");
			String Condition =data.get("Condition");
			String Search_Contract_No_Column_Header =data.get("Search_Contract_No_Column_Header");

			//locators
			String month_Select76 = String.format(month_Select,  Month_Select_For76);
			String show_Bills =  String.format(Generatebutton,  show_Bills_Button);
			String ContractNo_Select_CheckBox =  String.format(ContractNo_Select_ChkBox,  Contaract_No_input);
			String verrified_Row =  String.format(verified_Row,  Contaract_No_input);
			Extent_Start(testCase_Name, test, test1);
			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			Step_Start(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			waitForDisplay(driver, P_Contract_Module_Page);
			if (isdisplayed(driver, P_Contract_Module_Page)) {
				System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
				Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
			} else {
				System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
				Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
			}
			Step_End(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			Step_Start(2, "Click (+) button from Contract No field", test, test1);
			waitForElement(driver, P_Contact_No_Plus_Btn);
			click(driver, P_Contact_No_Plus_Btn);
			Step_End(2, "Click (+) button from Contract No field", test, test1);

			waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
			String Act_Popup = getText(driver, P_Search_Contract_No_Popup);
			if (Search_Contract_No_Popup_Txt_Exp.equals(Act_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			}
			Step_Start(3, "Select required contract no from the field", test, test1);
			twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
			Step_End(3, "Select required contract no from the field", test, test1);

			if (!Year_Select_For76.equals("")) {
				waitForElement(driver, P_Bill_Period_Year_Field);
				System.out.println("Year_Select_For76 : " + Year_Select_For76);
				clearAndType(driver, P_Bill_Period_Year_Field, Year_Select_For76);
			}
			if (!Month_Select_For76.equals("")) {
				waitForElement(driver, P_Bill_Period_Month_DD);
				click(driver, P_Bill_Period_Month_DD);
				System.out.println("Month_Select_For76 : " + Month_Select_For76);
				waitForElement(driver, month_Select76);
				click(driver, month_Select76);
			}
			Step_Start(4, "Click on Show bills", test, test1);
			waitForElement(driver, show_Bills);
			click(driver, show_Bills);
			Step_End(4, "Click on Show bills", test, test1);
			Step_Start(5, "Select the checkbox from the contract summary for required contract", test, test1);
			waitForElement(driver, ContractNo_Select_CheckBox);
			checkBox(driver, ContractNo_Select_CheckBox, ContractNo_CheckBox_Select);
			Step_End(5, "Select the checkbox from the contract summary for required contract", test, test1);
			Step_Start(6, "Click verify button after entering remarks", test, test1);
			waitForElement(driver, P_Verify_Btn);
			click(driver, P_Verify_Btn);
			Step_End(6, "Click verify button after entering remarks", test, test1);
			Step_Start(7, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			waitForElement(driver, P_Add_Remark_Title);
			String Act_Popup_Msg = getText(driver, P_Add_Remark_Title);
			if (Add_Remarks_Popup_Txt.equals(Act_Popup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : " + Add_Remarks_Popup_Txt+ " || Actual Popup is : " + Act_Popup_Msg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg, test,test1);
			}
			waitForElement(driver, P_Remark_Txt_Field);
			click(driver, P_Remark_Txt_Field);
			waitForElement(driver, P_Remark_Txt_Field);
			sendKeys(driver, P_Remark_Txt_Field, Remark_Txt_Field_input);
			waitForElement(driver, P_Remark_Ok_Btn);
			click(driver, P_Remark_Ok_Btn);
			Step_End(7, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			Step_Start(8, "Ensure that system should show confirmation message as 'Verified Successfully'.", test, test1);
			waitForPopup(driver, Popup_Message, Verified_Popup_Txt);
			String act_Popup_Msg = getText(driver, Popup_Message);
			if (Verified_Popup_Txt.equals(act_Popup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg, test,test1);
			}
			Step_End(8, "Ensure that system should show confirmation message as 'Verified Successfully'.", test, test1);
			Step_Start(9, "Ensure that system should Highlighted red color for Total by Contract row once verified. ", test, test1);
			waitForElement(driver, verrified_Row);
			
			String red_Colour_Code = getTextBackgroundColor(driver, verrified_Row);
			String red_Colour = getColorName(red_Colour_Code);
			System.out.println("red_Colour : "+red_Colour);
			if(Highlighted_RedColor_txt_Exp.equals(red_Colour)) {
				System.out.println("Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour);
				Extent_pass_New(driver, "Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour, test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour);
				Extent_fail(driver, "Not Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour, test,test1);
			}
			Step_End(9, "Ensure that system should Highlighted red color for Total by Contract row once verified. ", test, test1);
			if (Do_You_Want_Regenerate.equalsIgnoreCase("Yes")) {
				waitForElement(driver, P_Reset_Btn);
				click(driver, P_Reset_Btn);
				waitForElement(driver, P_ReGenerate_Btn);
				click(driver, P_ReGenerate_Btn);
				waitForElement(driver, P_Regenaration_Pass_TxtField);
				click(driver, P_Regenaration_Pass_TxtField);
				sendKeys(driver, P_Regenaration_Pass_TxtField, Password_Popup_Input_Txt);
				waitForElement(driver, P_Regenaration_Pass_OkBtn);
				click(driver, P_Regenaration_Pass_OkBtn);
				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);
			}
			Extent_completed(testCase_Name, test, test1);
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCase_Name="TC_EMS_Contract_Billing_Generation_77";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_077 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_077, testCase_Name, "Dataset"+selected_dataset, File_Path);

			String Field_Names = data.get("Field_Names");
			String Contaract_No_input = data.get("Contaract_No");
			String Search_Contract_No_Popup_Txt_Exp = data.get("Search_Contract_No_Popup_Txt");
			String Bill_Not_Verified_Txt_Exp = data.get("Bill_Not_Verified_Txt");
			String Month_Select_For77 = data.get("Month_Select_For77");
			String Year_Select_For77 = data.get("Year_Select_For77");
			String show_Bills_Button = data.get("show_Bills_Button");
			String ContractNo_CheckBox_Select = data.get("ContractNo_CheckBox_Select");
			String Condition =data.get("Condition");
			String Search_Contract_No_Column_Header =data.get("Search_Contract_No_Column_Header");

			//locators
			String month_Select77 = String.format(month_Select,  Month_Select_For77);
			String show_Bills =  String.format(Generatebutton,  show_Bills_Button);
			String ContractNo_Select_CheckBox =  String.format(ContractNo_Select_ChkBox,  Contaract_No_input);

			Extent_Start(testCase_Name, test, test1);
			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			Step_Start(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			waitForDisplay(driver, P_Contract_Module_Page);
			if (isdisplayed(driver, P_Contract_Module_Page)) {
				System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
				Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
			} else {
				System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
				Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
			}
			Step_End(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			Step_Start(2, "Click (+) button from Contract No field", test, test1);
			waitForElement(driver, P_Contact_No_Plus_Btn);
			click(driver, P_Contact_No_Plus_Btn);
			Step_End(2, "Click (+) button from Contract No field", test, test1);

			waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
			String Act_Popup = getText(driver, P_Search_Contract_No_Popup);
			if (Search_Contract_No_Popup_Txt_Exp.equals(Act_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			}
			Step_Start(3, "Select required contract no from the field", test, test1);
			twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
			Step_End(3, "Select required contract no from the field", test, test1);
			if (!Year_Select_For77.equals("")) {
				waitForElement(driver, P_Bill_Period_Year_Field);
				System.out.println("Year_Select_For77 : " + Year_Select_For77);
				clearAndType(driver, P_Bill_Period_Year_Field, Year_Select_For77);
			}
			if (!Month_Select_For77.equals("")) {
				waitForElement(driver, P_Bill_Period_Month_DD);
				click(driver, P_Bill_Period_Month_DD);
				System.out.println("Month_Select_For77 : " + Month_Select_For77);
				waitForElement(driver, month_Select77);
				click(driver, month_Select77);
			}
			Step_Start(4, "Click on Show bills", test, test1);
			waitForElement(driver, show_Bills);
			click(driver, show_Bills);
			Step_End(4, "Click on Show bills", test, test1);
			Step_Start(5, "Select the checkbox from the contract summary for required contract", test, test1);
			waitForElement(driver, ContractNo_Select_CheckBox);
			checkBox(driver, ContractNo_Select_CheckBox, ContractNo_CheckBox_Select);
			Step_End(5, "Select the checkbox from the contract summary for required contract", test, test1);
			Step_Start(6, "Ensure that system should validate if user try to click approve button without verifying bill", test, test1);
			waitForElement(driver, P_ApproveBill_Btn);
			click(driver, P_ApproveBill_Btn);
			Step_End(6, "Ensure that system should validate if user try to click approve button without verifying bill", test, test1);
			Step_Start(7, "Ensure that system should show confirmation message as ' Bill not yet verified'.", test, test1);
			waitForPopup(driver, P_Bill_Not_Verify_Msg, Bill_Not_Verified_Txt_Exp);
			String Not_Verify_Popup_Msg = getText(driver, P_Bill_Not_Verify_Msg);
			System.out.println(Not_Verify_Popup_Msg);
			if (Bill_Not_Verified_Txt_Exp.equals(Not_Verify_Popup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : " + Bill_Not_Verified_Txt_Exp+ " || Actual Popup is : " + Not_Verify_Popup_Msg);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Bill_Not_Verified_Txt_Exp+ " || Actual Popup is : " + Not_Verify_Popup_Msg,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Bill_Not_Verified_Txt_Exp + " || Actual Popup is : "+ Not_Verify_Popup_Msg);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : "+ Bill_Not_Verified_Txt_Exp + " || Actual Popup is : "+ Not_Verify_Popup_Msg,test, test1);
			}
			Step_End(7, "Ensure that system should show confirmation message as ' Bill not yet verified'.", test, test1);
			Extent_completed(testCase_Name, test, test1);
			scrollTop(driver);
			waitForElement(driver, P_Bill_Run_Status_okBtn);
			click(driver, P_Bill_Run_Status_okBtn);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCase_Name="TC_EMS_Contract_Billing_Generation_78";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);

			String Sheet_Name_078 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_078, testCase_Name, "Dataset"+selected_dataset, File_Path);
			String Field_Names = data.get("Field_Names");
			String Contaract_No_input = data.get("Contaract_No");
			String Search_Contract_No_Popup_Txt_Exp = data.get("Search_Contract_No_Popup_Txt");
			String Add_Remarks_Popup_Txt = data.get("Add_Remarks_Popup");
			String Verified_Popup_Txt = data.get("Verified_Popup");
			String Remark_Txt_Field_input = data.get("Remark_Txt_Field");
			String Highlighted_RedColor_txt_Exp = data.get("Highlighted_RedColor_txt");
			String Enter_Approve_Remarks_Popup_Txt_Exp = data.get("Enter_Approve_Remarks_Popup_Txt");
			String Month_Select_For78 = data.get("Month_Select_For78");
			String Year_Select_For78 = data.get("Year_Select_For78");
			String show_Bills_Button = data.get("show_Bills_Button");
			String ContractNo_CheckBox_Select = data.get("ContractNo_CheckBox_Select");
			String approve_Remark_Txt_Field_input = data.get("approve_Remark_Txt_Field_input");
			String Condition =data.get("Condition");
			String Search_Contract_No_Column_Header =data.get("Search_Contract_No_Column_Header");
			//locators
			String verrified_Row =  String.format(verified_Row,  Contaract_No_input);
			String month_Select78 = String.format(month_Select,  Month_Select_For78);
			String show_Bills =  String.format(Generatebutton,  show_Bills_Button);
			String ContractNo_Select_CheckBox =  String.format(ContractNo_Select_ChkBox,  Contaract_No_input);
			Extent_Start(testCase_Name, test, test1);
			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			Step_Start(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			waitForDisplay(driver, P_Contract_Module_Page);
			if (isdisplayed(driver, P_Contract_Module_Page)) {
				System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
				Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
			} else {
				System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
				Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
			}
			Step_End(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			Step_Start(2, "Click (+) button from Contract No field", test, test1);
			waitForElement(driver, P_Contact_No_Plus_Btn);
			click(driver, P_Contact_No_Plus_Btn);
			Step_End(2, "Click (+) button from Contract No field", test, test1);

			waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
			String Act_Popup = getText(driver, P_Search_Contract_No_Popup);
			if (Search_Contract_No_Popup_Txt_Exp.equals(Act_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			}
			Step_Start(3, "Select required contract no from the field", test, test1);
			twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
			Step_End(3, "Select required contract no from the field", test, test1);
			if (!Year_Select_For78.equals("")) {
				waitForElement(driver, P_Bill_Period_Year_Field);
				System.out.println("Year_Select_For78 : " + Year_Select_For78);
				clearAndType(driver, P_Bill_Period_Year_Field, Year_Select_For78);
			}
			if (!Month_Select_For78.equals("")) {
				waitForElement(driver, P_Bill_Period_Month_DD);
				click(driver, P_Bill_Period_Month_DD);
				System.out.println("Month_Select_For78 : " + Month_Select_For78);
				waitForElement(driver, month_Select78);
				click(driver, month_Select78);
			}
			Step_Start(4, "Click on Show bills", test, test1);
			waitForElement(driver, show_Bills);
			click(driver, show_Bills);
			Step_End(4, "Click on Show bills", test, test1);
			Step_Start(5, "Select the checkbox from the contract summary for required contract", test, test1);
			waitForElement(driver, ContractNo_Select_CheckBox);
			checkBox(driver, ContractNo_Select_CheckBox, ContractNo_CheckBox_Select);
			Step_End(5, "Select the checkbox from the contract summary for required contract", test, test1);
			Step_Start(6, "Click verify button after entering remarks", test, test1);
			waitForElement(driver, P_Verify_Btn);
			click(driver, P_Verify_Btn);
			Step_End(6, "Click verify button after entering remarks", test, test1);
			Step_Start(7, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			waitForElement(driver, P_Add_Remark_Title);
			String Act_Popup_Msg = getText(driver, P_Add_Remark_Title);
			if (Add_Remarks_Popup_Txt.equals(Act_Popup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : " + Add_Remarks_Popup_Txt+ " || Actual Popup is : " + Act_Popup_Msg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg, test,test1);
			}
			waitForElement(driver, P_Remark_Txt_Field);
			click(driver, P_Remark_Txt_Field);
			waitForElement(driver, P_Remark_Txt_Field);
			sendKeys(driver, P_Remark_Txt_Field, Remark_Txt_Field_input);
			waitForElement(driver, P_Remark_Ok_Btn);
			click(driver, P_Remark_Ok_Btn);
			Step_End(7, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			Step_Start(8, "Ensure that system should show confirmation message as 'Verified Successfully'.", test, test1);
			waitForPopup(driver, Popup_Message, Verified_Popup_Txt);
			String act_Popup_Msg = getText(driver, Popup_Message);
			if (Verified_Popup_Txt.equals(act_Popup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg, test,test1);
			}
			Step_End(8, "Ensure that system should show confirmation message as 'Verified Successfully'.", test, test1);
			Step_Start(9, "Ensure that system should Highlighted red color for Total by Contract row once verified. ", test, test1);
			waitForElement(driver, verrified_Row);
			String red_Colour_Code = getTextBackgroundColor(driver, verrified_Row);
			String red_Colour = getColorName(red_Colour_Code);
			System.out.println("red_Colour : "+red_Colour);
			if(Highlighted_RedColor_txt_Exp.equals(red_Colour)) {
				System.out.println("Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour);
				Extent_pass_New(driver, "Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour, test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour);
				Extent_fail(driver, "Not Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour, test,test1);
			}
			Step_End(9, "Ensure that system should Highlighted red color for Total by Contract row once verified. ", test, test1);
			Step_Start(10, "Ensure that system should validate if user try to click ok for approve button when remarks given blank.", test, test1);
			waitForElement(driver, ContractNo_Select_CheckBox);
			checkBox(driver, ContractNo_Select_CheckBox, ContractNo_CheckBox_Select);
			waitForElement(driver, P_ApproveBill_Btn);
			click(driver, P_ApproveBill_Btn);
			waitForPopup(driver, P_Approve_Remark_Title, Add_Remarks_Popup_Txt);
			String Popup_Message1 = getText(driver, P_Approve_Remark_Title);
			if (Add_Remarks_Popup_Txt.equals(Popup_Message1)) {
				System.out.println("Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1,test, test1);
			}
			waitForElement(driver, P_Approve_Remarks_TxtFiled);
			click(driver, P_Approve_Remarks_TxtFiled);
			waitForElement(driver, P_Approve_Remarks_TxtFiled);
			sendKeys(driver, P_Approve_Remarks_TxtFiled, approve_Remark_Txt_Field_input);
			waitForElement(driver, P_Approve_Remarks_OkBtn);
			click(driver, P_Approve_Remarks_OkBtn);
			Step_End(10, "Ensure that system should validate if user try to click ok for approve button when remarks given blank.", test, test1);
			Step_Start(11, "Ensure that system should show confirmation message as 'Enter the approve Remarks'.", test, test1);
			waitForPopup(driver, Popup_Message, Add_Remarks_Popup_Txt);
			String ActualPopup_Message = getText(driver, Popup_Message);
			if (Enter_Approve_Remarks_Popup_Txt_Exp.equals(ActualPopup_Message)) {
				System.out.println("Matched || " + " Expected Popup is : "+ Enter_Approve_Remarks_Popup_Txt_Exp + " || Actual Popup is : "+ ActualPopup_Message);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : "+ Enter_Approve_Remarks_Popup_Txt_Exp+ " || Actual Popup is : " + ActualPopup_Message,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Enter_Approve_Remarks_Popup_Txt_Exp + " || Actual Popup is : "+ ActualPopup_Message);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : "+ Enter_Approve_Remarks_Popup_Txt_Exp+ " || Actual Popup is : " + ActualPopup_Message,test, test1);
			}
			Step_End(11, "Ensure that system should show confirmation message as 'Enter the approve Remarks'.", test, test1);
			Extent_completed(testCase_Name, test, test1);
			scrollTop(driver);
			waitForElement(driver, P_Approve_Remark_Close);
			click(driver, P_Approve_Remark_Close);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCase_Name="TC_EMS_Contract_Billing_Generation_79";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_079 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_079, testCase_Name, "Dataset"+selected_dataset, File_Path);
			String Field_Names = data.get("Field_Names");
			String Contaract_No_input = data.get("Contaract_No");
			String Search_Contract_No_Popup_Txt_Exp = data.get("Search_Contract_No_Popup_Txt");
			String Add_Remarks_Popup_Txt = data.get("Add_Remarks_Popup");
			String Verified_Popup_Txt = data.get("Verified_Popup");
			String Remark_Txt_Field_input = data.get("Remark_Txt_Field");
			String Highlighted_RedColor_txt_Exp = data.get("Highlighted_RedColor_txt");
			String Approved_Popup_Txt_Exp = data.get("Approved_Popup_Txt");
			String Month_Select_For79 = data.get("Month_Select_For79");
			String Year_Select_For79 = data.get("Year_Select_For79");
			String show_Bills_Button = data.get("show_Bills_Button");
			String ContractNo_CheckBox_Select = data.get("ContractNo_CheckBox_Select");
			String approve_Remark_Txt_Field_input = data.get("approve_Remark_Txt_Field_input");
			String Condition =data.get("Condition");
			String Search_Contract_No_Column_Header =data.get("Search_Contract_No_Column_Header");
			//locators
			String month_Select79 = String.format(month_Select,  Month_Select_For79);
			String show_Bills =  String.format(Generatebutton,  show_Bills_Button);
			String ContractNo_Select_CheckBox =  String.format(ContractNo_Select_ChkBox,  Contaract_No_input);
			String verrified_Row =  String.format(verified_Row,  Contaract_No_input);

			Extent_Start(testCase_Name, test, test1);
			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			Step_Start(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			waitForDisplay(driver, P_Contract_Module_Page);
			if (isdisplayed(driver, P_Contract_Module_Page)) {
				System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
				Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
			} else {
				System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
				Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
			}
			Step_End(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			Step_Start(2, "Click (+) button from Contract No field", test, test1);
			waitForElement(driver, P_Contact_No_Plus_Btn);
			click(driver, P_Contact_No_Plus_Btn);
			Step_End(2, "Click (+) button from Contract No field", test, test1);

			waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
			String Act_Popup = getText(driver, P_Search_Contract_No_Popup);
			if (Search_Contract_No_Popup_Txt_Exp.equals(Act_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			}
			Step_Start(3, "Select required contract no from the field", test, test1);
			twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
			Step_End(3, "Select required contract no from the field", test, test1);

			if (!Year_Select_For79.equals("")) {
				waitForElement(driver, P_Bill_Period_Year_Field);
				System.out.println("Year_Select_For79 : " + Year_Select_For79);
				clearAndType(driver, P_Bill_Period_Year_Field, Year_Select_For79);
			}
			if (!Month_Select_For79.equals("")) {
				waitForElement(driver, P_Bill_Period_Month_DD);
				click(driver, P_Bill_Period_Month_DD);
				System.out.println("Month_Select_For79 : " + Month_Select_For79);
				waitForElement(driver, month_Select79);
				click(driver, month_Select79);
			}
			Step_Start(4, "Click on Show bills", test, test1);
			waitForElement(driver, show_Bills);
			click(driver, show_Bills);
			Step_End(4, "Click on Show bills", test, test1);
			Step_Start(5, "Select the checkbox from the contract summary for required contract", test, test1);
			waitForElement(driver, ContractNo_Select_CheckBox);
			checkBox(driver, ContractNo_Select_CheckBox, ContractNo_CheckBox_Select);
			Step_End(5, "Select the checkbox from the contract summary for required contract", test, test1);
			Step_Start(6, "Click verify button after entering remarks", test, test1);
			waitForElement(driver, P_Verify_Btn);
			click(driver, P_Verify_Btn);
			Step_End(6, "Click verify button after entering remarks", test, test1);
			Step_Start(7, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			waitForElement(driver, P_Add_Remark_Title);
			String Act_Popup_Msg = getText(driver, P_Add_Remark_Title);
			if (Add_Remarks_Popup_Txt.equals(Act_Popup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : " + Add_Remarks_Popup_Txt+ " || Actual Popup is : " + Act_Popup_Msg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg, test,test1);
			}
			waitForElement(driver, P_Remark_Txt_Field);
			click(driver, P_Remark_Txt_Field);
			waitForElement(driver, P_Remark_Txt_Field);
			sendKeys(driver, P_Remark_Txt_Field, Remark_Txt_Field_input);
			waitForElement(driver, P_Remark_Ok_Btn);
			click(driver, P_Remark_Ok_Btn);
			Step_End(7, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			Step_Start(8, "Ensure that system should show confirmation message as 'Verified Successfully'.", test, test1);
			waitForPopup(driver, Popup_Message, Verified_Popup_Txt);
			String act_Popup_Msg = getText(driver, Popup_Message);
			if (Verified_Popup_Txt.equals(act_Popup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg, test,test1);
			}
			Step_End(8, "Ensure that system should show confirmation message as 'Verified Successfully'.", test, test1);
			Step_Start(9, "Ensure that system should Highlighted red color for Total by Contract row once verified. ", test, test1);
			waitForElement(driver, verrified_Row);
			String red_Colour_Code = getTextBackgroundColor(driver, verrified_Row);
			String red_Colour = getColorName(red_Colour_Code);
			System.out.println("red_Colour : "+red_Colour);
			if(Highlighted_RedColor_txt_Exp.equals(red_Colour)) {
				System.out.println("Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour);
				Extent_pass_New(driver, "Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour, test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour);
				Extent_fail(driver, "Not Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour, test,test1);
			}
			Step_End(9, "Ensure that system should Highlighted red color for Total by Contract row once verified. ", test, test1);
			Step_Start(10, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			waitForElement(driver, ContractNo_Select_CheckBox);
			checkBox(driver, ContractNo_Select_CheckBox, ContractNo_CheckBox_Select);
			waitForElement(driver, P_ApproveBill_Btn);
			click(driver, P_ApproveBill_Btn);
			waitForPopup(driver, P_Approve_Remark_Title, Add_Remarks_Popup_Txt);
			String Popup_Message1 = getText(driver, P_Approve_Remark_Title);
			if (Add_Remarks_Popup_Txt.equals(Popup_Message1)) {
				System.out.println("Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1,test, test1);
			}
			waitForElement(driver, P_Approve_Remarks_TxtFiled);
			click(driver, P_Approve_Remarks_TxtFiled);
			waitForElement(driver, P_Approve_Remarks_TxtFiled);
			sendKeys(driver, P_Approve_Remarks_TxtFiled, approve_Remark_Txt_Field_input);
			waitForElement(driver, P_Approve_Remarks_OkBtn);
			click(driver, P_Approve_Remarks_OkBtn);
			Step_End(10, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			Step_Start(11, "Ensure that system should show confirmation message as 'Approved Successfully'.", test, test1);
			waitForPopup(driver, Popup_Message, Approved_Popup_Txt_Exp);
			String approved_Message = getText(driver, Popup_Message);
			if (Approved_Popup_Txt_Exp.equals(approved_Message)) {
				System.out.println("Matched || " + " Expected Popup is : " + Approved_Popup_Txt_Exp+ " || Actual Popup is : " + approved_Message);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Approved_Popup_Txt_Exp+ " || Actual Popup is : " + approved_Message,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Approved_Popup_Txt_Exp + " || Actual Popup is : "+ approved_Message);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : "+ Approved_Popup_Txt_Exp + " || Actual Popup is : "+ approved_Message,test, test1);
			}
			Step_End(11, "Ensure that system should show confirmation message as 'Approved Successfully'.", test, test1);
			Extent_completed(testCase_Name, test, test1);
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCase_Name="TC_EMS_Contract_Billing_Generation_80";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_080 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_080, testCase_Name, "Dataset"+selected_dataset, File_Path);
			String Field_Names = data.get("Field_Names");
			String Contaract_No_input = data.get("Contaract_No");
			String Search_Contract_No_Popup_Txt_Exp = data.get("Search_Contract_No_Popup_Txt");
			String Add_Remarks_Popup_Txt = data.get("Add_Remarks_Popup");
			String Verified_Popup_Txt = data.get("Verified_Popup");
			String Remark_Txt_Field_input = data.get("Remark_Txt_Field");
			String Highlighted_RedColor_txt_Exp = data.get("Highlighted_RedColor_txt");
			String Approved_Popup_Txt_Exp = data.get("Approved_Popup_Txt");
			String Highlighted_GreenColor_Txt_Exp = data.get("Highlighted_GreenColor_txt");
			String Month_Select_For80 = data.get("Month_Select_For80");
			String Year_Select_For80 = data.get("Year_Select_For80");
			String show_Bills_Button = data.get("show_Bills_Button");
			String ContractNo_CheckBox_Select = data.get("ContractNo_CheckBox_Select");
			String approve_Remark_Txt_Field_input = data.get("approve_Remark_Txt_Field_input");
			String Condition =data.get("Condition");
			String Search_Contract_No_Column_Header =data.get("Search_Contract_No_Column_Header");

			//locators
			String month_Select80 = String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.month_Select,  Month_Select_For80);
			String show_Bills =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.Generatebutton,  show_Bills_Button);
			String ContractNo_Select_CheckBox =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.ContractNo_Select_ChkBox,  Contaract_No_input);
			String verrified_Row =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.verified_Row,  Contaract_No_input);
			Extent_Start(testCase_Name, test, test1);
			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			Step_Start(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			waitForDisplay(driver, P_Contract_Module_Page);
			if (isdisplayed(driver, P_Contract_Module_Page)) {
				System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
				Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
			} else {
				System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
				Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
			}
			Step_End(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			Step_Start(2, "Click (+) button from Contract No field", test, test1);
			waitForElement(driver, P_Contact_No_Plus_Btn);
			click(driver, P_Contact_No_Plus_Btn);
			Step_End(2, "Click (+) button from Contract No field", test, test1);

			waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
			String Act_Popup = getText(driver, P_Search_Contract_No_Popup);
			if (Search_Contract_No_Popup_Txt_Exp.equals(Act_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			}
			Step_Start(3, "Select required contract no from the field", test, test1);
			twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
			Step_End(3, "Select required contract no from the field", test, test1);

			if (!Year_Select_For80.equals("")) {
				waitForElement(driver, P_Bill_Period_Year_Field);
				System.out.println("Year_Select_For80 : " + Year_Select_For80);
				clearAndType(driver, P_Bill_Period_Year_Field, Year_Select_For80);
			}
			if (!Month_Select_For80.equals("")) {
				waitForElement(driver, P_Bill_Period_Month_DD);
				click(driver, P_Bill_Period_Month_DD);
				System.out.println("Month_Select_For80 : " + Month_Select_For80);
				waitForElement(driver, month_Select80);
				click(driver, month_Select80);
			}
			Step_Start(4, "Click on Show bills", test, test1);
			waitForElement(driver, show_Bills);
			click(driver, show_Bills);
			Step_End(4, "Click on Show bills", test, test1);
			Step_Start(5, "Select the checkbox from the contract summary for required contract", test, test1);
			waitForElement(driver, ContractNo_Select_CheckBox);
			checkBox(driver, ContractNo_Select_CheckBox, ContractNo_CheckBox_Select);
			Step_End(5, "Select the checkbox from the contract summary for required contract", test, test1);
			Step_Start(6, "Click verify button after entering remarks", test, test1);
			waitForElement(driver, P_Verify_Btn);
			click(driver, P_Verify_Btn);
			Step_End(6, "Click verify button after entering remarks", test, test1);
			Step_Start(7, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			waitForElement(driver, P_Add_Remark_Title);
			String Act_Popup_Msg = getText(driver, P_Add_Remark_Title);
			if (Add_Remarks_Popup_Txt.equals(Act_Popup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : " + Add_Remarks_Popup_Txt+ " || Actual Popup is : " + Act_Popup_Msg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg, test,test1);
			}
			waitForElement(driver, P_Remark_Txt_Field);
			click(driver, P_Remark_Txt_Field);
			waitForElement(driver, P_Remark_Txt_Field);
			sendKeys(driver, P_Remark_Txt_Field, Remark_Txt_Field_input);
			waitForElement(driver, P_Remark_Ok_Btn);
			click(driver, P_Remark_Ok_Btn);
			Step_End(7, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			Step_Start(8, "Ensure that system should show confirmation message as 'Verified Successfully'.", test, test1);
			waitForPopup(driver, Popup_Message, Verified_Popup_Txt);
			String act_Popup_Msg = getText(driver, Popup_Message);
			if (Verified_Popup_Txt.equals(act_Popup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg, test,test1);
			}
			Step_End(8, "Ensure that system should show confirmation message as 'Verified Successfully'.", test, test1);
			Step_Start(9, "Ensure that system should Highlighted red color for Total by Contract row once verified. ", test, test1);
			waitForElement(driver, verrified_Row);
			String red_Colour_Code = getTextBackgroundColor(driver, verrified_Row);
			String red_Colour = getColorName(red_Colour_Code);
			System.out.println("red_Colour : "+red_Colour);
			if(Highlighted_RedColor_txt_Exp.equals(red_Colour)) {
				System.out.println("Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour);
				Extent_pass_New(driver, "Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour, test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour);
				Extent_fail(driver, "Not Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour, test,test1);
			}
			Step_End(9, "Ensure that system should Highlighted red color for Total by Contract row once verified. ", test, test1);
			Step_Start(10, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			waitForElement(driver, ContractNo_Select_CheckBox);
			checkBox(driver, ContractNo_Select_CheckBox, ContractNo_CheckBox_Select);
			waitForElement(driver, P_ApproveBill_Btn);
			click(driver, P_ApproveBill_Btn);
			waitForPopup(driver, P_Approve_Remark_Title, Add_Remarks_Popup_Txt);
			String Popup_Message1 = getText(driver, P_Approve_Remark_Title);
			if (Add_Remarks_Popup_Txt.equals(Popup_Message1)) {
				System.out.println("Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1,test, test1);
			}
			waitForElement(driver, P_Approve_Remarks_TxtFiled);
			click(driver, P_Approve_Remarks_TxtFiled);
			waitForElement(driver, P_Approve_Remarks_TxtFiled);
			sendKeys(driver, P_Approve_Remarks_TxtFiled, approve_Remark_Txt_Field_input);
			waitForElement(driver, P_Approve_Remarks_OkBtn);
			click(driver, P_Approve_Remarks_OkBtn);
			Step_End(10, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			Step_Start(11, "Ensure that system should show confirmation message as 'Approved Successfully'.", test, test1);
			waitForPopup(driver, Popup_Message, Approved_Popup_Txt_Exp);
			String approved_Message = getText(driver, Popup_Message);
			if (Approved_Popup_Txt_Exp.equals(approved_Message)) {
				System.out.println("Matched || " + " Expected Popup is : " + Approved_Popup_Txt_Exp+ " || Actual Popup is : " + approved_Message);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Approved_Popup_Txt_Exp+ " || Actual Popup is : " + approved_Message,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Approved_Popup_Txt_Exp + " || Actual Popup is : "+ approved_Message);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : "+ Approved_Popup_Txt_Exp + " || Actual Popup is : "+ approved_Message,test, test1);
			}
			Step_End(11, "Ensure that system should show confirmation message as 'Approved Successfully'.", test, test1);
			Step_Start(12, "Ensure that system should Highlighted Total by contract row in green color once approved", test, test1);
			waitForElement(driver, verrified_Row);
			String green_ColourCode = getTextBackgroundColor(driver, verrified_Row);
			String green_Colour = getColorName(green_ColourCode);
			System.out.println("green_Colour : " + Highlighted_GreenColor_Txt_Exp);
			if (Highlighted_GreenColor_Txt_Exp.equals(green_Colour)) {
				System.out.println("Matched || " + " Expected Color is : "+ Highlighted_GreenColor_Txt_Exp + " || Actual Color is : "+ green_Colour);
				Extent_pass_New(driver,"Matched || " + " Expected Color is : "+ Highlighted_GreenColor_Txt_Exp+ " || Actual Color is : " + green_Colour,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Color is : "+ Highlighted_GreenColor_Txt_Exp + " || Actual Color is : "+ green_Colour);
				Extent_fail(driver,"Not Matched || " + " Expected Color is : "+ Highlighted_GreenColor_Txt_Exp+ " || Actual Color is : " + green_Colour,test, test1);
			}
			Step_End(12, "Ensure that system should Highlighted Total by contract row in green color once approved", test, test1);
			Extent_completed(testCase_Name, test, test1);
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCase_Name="TC_EMS_Contract_Billing_Generation_81";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_081 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);

			Map<String, String> data = Utils.GetAllData(Sheet_Name_081, testCase_Name, "Dataset"+selected_dataset, File_Path);
			String Field_Names = data.get("Field_Names");
			String Contaract_No_input = data.get("Contaract_No");
			String Search_Contract_No_Popup_Txt_Exp = data.get("Search_Contract_No_Popup_Txt");
			String Add_Remarks_Popup_Txt = data.get("Add_Remarks_Popup");
			String Verified_Popup_Txt = data.get("Verified_Popup");
			String Remark_Txt_Field_input = data.get("Remark_Txt_Field");
			String Highlighted_RedColor_txt_Exp = data.get("Highlighted_RedColor_txt");
			String Approved_Popup_Txt_Exp = data.get("Approved_Popup_Txt");
			String Highlighted_GreenColor_Txt_Exp = data.get("Highlighted_GreenColor_txt");
			String Invalid_Terms_Msg_Txt_Exp = data.get("Invalid_Terms_Msg_Txt");
			String Month_Select_For81 = data.get("Month_Select_For81");
			String Year_Select_For81 = data.get("Year_Select_For81");
			String show_Bills_Button = data.get("show_Bills_Button");
			String reGenerate_Button = data.get("reGenerate_Button");
			String ContractNo_CheckBox_Select = data.get("ContractNo_CheckBox_Select");
			String approve_Remark_Txt_Field_input = data.get("approve_Remark_Txt_Field_input");
			String Condition =data.get("Condition");
			String Search_Contract_No_Column_Header =data.get("Search_Contract_No_Column_Header");
			//locators
			String month_Select81 = String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.month_Select,  Month_Select_For81);
			String show_Bills =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.Generatebutton,  show_Bills_Button);
			String ContractNo_Select_CheckBox =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.ContractNo_Select_ChkBox,  Contaract_No_input);
			String verrified_Row =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.verified_Row,  Contaract_No_input);
			String regenerate_Button = String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.Generatebutton,  reGenerate_Button);
			Extent_Start(testCase_Name, test, test1);
			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			Step_Start(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			waitForDisplay(driver, P_Contract_Module_Page);
			if (isdisplayed(driver, P_Contract_Module_Page)) {
				System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
				Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
			} else {
				System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
				Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
			}
			Step_End(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			Step_Start(2, "Click (+) button from Contract No field", test, test1);
			waitForElement(driver, P_Contact_No_Plus_Btn);
			click(driver, P_Contact_No_Plus_Btn);
			Step_End(2, "Click (+) button from Contract No field", test, test1);

			waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
			String Act_Popup = getText(driver, P_Search_Contract_No_Popup);
			if (Search_Contract_No_Popup_Txt_Exp.equals(Act_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			}
			Step_Start(3, "Select required contract no from the field", test, test1);
			twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
			Step_End(3, "Select required contract no from the field", test, test1);

			if (!Year_Select_For81.equals("")) {
				waitForElement(driver, P_Bill_Period_Year_Field);
				System.out.println("Year_Select_For81 : " + Year_Select_For81);
				clearAndType(driver, P_Bill_Period_Year_Field, Year_Select_For81);
			}
			if (!Month_Select_For81.equals("")) {
				waitForElement(driver, P_Bill_Period_Month_DD);
				click(driver, P_Bill_Period_Month_DD);
				System.out.println("Month_Select_For81 : " + Month_Select_For81);
				waitForElement(driver, month_Select81);
				click(driver, month_Select81);
			}
			Step_Start(4, "Click on Show bills", test, test1);
			waitForElement(driver, show_Bills);
			click(driver, show_Bills);
			Step_End(4, "Click on Show bills", test, test1);
			Step_Start(5, "Select the checkbox from the contract summary for required contract", test, test1);
			waitForElement(driver, ContractNo_Select_CheckBox);
			checkBox(driver, ContractNo_Select_CheckBox, ContractNo_CheckBox_Select);
			Step_End(5, "Select the checkbox from the contract summary for required contract", test, test1);
			Step_Start(6, "Click verify button after entering remarks", test, test1);
			waitForElement(driver, P_Verify_Btn);
			click(driver, P_Verify_Btn);
			Step_End(6, "Click verify button after entering remarks", test, test1);
			Step_Start(7, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			waitForPopup(driver, P_Add_Remark_Title, Add_Remarks_Popup_Txt);
			String Act_Popup_Msg = getText(driver, P_Add_Remark_Title);
			if (Add_Remarks_Popup_Txt.equals(Act_Popup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : " + Add_Remarks_Popup_Txt+ " || Actual Popup is : " + Act_Popup_Msg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg, test,test1);
			}
			waitForElement(driver, P_Remark_Txt_Field);
			click(driver, P_Remark_Txt_Field);
			waitForElement(driver, P_Remark_Txt_Field);
			sendKeys(driver, P_Remark_Txt_Field, Remark_Txt_Field_input);
			waitForElement(driver, P_Remark_Ok_Btn);
			click(driver, P_Remark_Ok_Btn);
			Step_End(7, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			Step_Start(8, "Ensure that system should show confirmation message as 'Verified Successfully'.", test, test1);
			waitForPopup(driver, Popup_Message, Verified_Popup_Txt);
			String act_Popup_Msg = getText(driver, Popup_Message);
			if (Verified_Popup_Txt.equals(act_Popup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg, test,test1);
			}
			Step_End(8, "Ensure that system should show confirmation message as 'Verified Successfully'.", test, test1);
			Step_Start(9, "Ensure that system should Highlighted red color for Total by Contract row once verified. ", test, test1);
			waitForElement(driver, verrified_Row);
			String red_Colour_Code = getTextBackgroundColor(driver, verrified_Row);
			String red_Colour = getColorName(red_Colour_Code);
			System.out.println("red_Colour : "+red_Colour);
			if(Highlighted_RedColor_txt_Exp.equals(red_Colour)) {
				System.out.println("Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour);
				Extent_pass_New(driver, "Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour, test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour);
				Extent_fail(driver, "Not Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour, test,test1);
			}
			Step_End(9, "Ensure that system should Highlighted red color for Total by Contract row once verified. ", test, test1);
			Step_Start(10, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			waitForElement(driver, ContractNo_Select_CheckBox);
			checkBox(driver, ContractNo_Select_CheckBox, ContractNo_CheckBox_Select);
			waitForElement(driver, P_ApproveBill_Btn);
			click(driver, P_ApproveBill_Btn);
			waitForPopup(driver, P_Approve_Remark_Title, Add_Remarks_Popup_Txt);
			String Popup_Message1 = getText(driver, P_Approve_Remark_Title);
			if (Add_Remarks_Popup_Txt.equals(Popup_Message1)) {
				System.out.println("Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1,test, test1);
			}
			waitForElement(driver, P_Approve_Remarks_TxtFiled);
			click(driver, P_Approve_Remarks_TxtFiled);
			waitForElement(driver, P_Approve_Remarks_TxtFiled);
			sendKeys(driver, P_Approve_Remarks_TxtFiled, approve_Remark_Txt_Field_input);
			waitForElement(driver, P_Approve_Remarks_OkBtn);
			click(driver, P_Approve_Remarks_OkBtn);
			Step_End(10, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			Step_Start(11, "Ensure that system should show confirmation message as 'Approved Successfully'.", test, test1);
			waitForPopup(driver, Popup_Message, Approved_Popup_Txt_Exp);
			String approved_Message = getText(driver, Popup_Message);
			if (Approved_Popup_Txt_Exp.equals(approved_Message)) {
				System.out.println("Matched || " + " Expected Popup is : " + Approved_Popup_Txt_Exp+ " || Actual Popup is : " + approved_Message);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Approved_Popup_Txt_Exp+ " || Actual Popup is : " + approved_Message,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Approved_Popup_Txt_Exp + " || Actual Popup is : "+ approved_Message);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : "+ Approved_Popup_Txt_Exp + " || Actual Popup is : "+ approved_Message,test, test1);
			}
			Step_End(11, "Ensure that system should show confirmation message as 'Approved Successfully'.", test, test1);
			Step_Start(12, "Ensure that system should Highlighted Total by contract row in green color once approved", test, test1);
			waitForElement(driver, verrified_Row);
			String green_ColourCode = getTextBackgroundColor(driver, verrified_Row);
			String green_Colour = getColorName(green_ColourCode);
			System.out.println("green_Colour : " + Highlighted_GreenColor_Txt_Exp);
			if (Highlighted_GreenColor_Txt_Exp.equals(green_Colour)) {
				System.out.println("Matched || " + " Expected Color is : "+ Highlighted_GreenColor_Txt_Exp + " || Actual Color is : "+ green_Colour);
				Extent_pass_New(driver,"Matched || " + " Expected Color is : "+ Highlighted_GreenColor_Txt_Exp+ " || Actual Color is : " + green_Colour,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Color is : "+ Highlighted_GreenColor_Txt_Exp + " || Actual Color is : "+ green_Colour);
				Extent_fail(driver,"Not Matched || " + " Expected Color is : "+ Highlighted_GreenColor_Txt_Exp+ " || Actual Color is : " + green_Colour,test, test1);
			}
			Step_End(12, "Ensure that system should Highlighted Total by contract row in green color once approved", test, test1);

			Step_Start(13, "Ensure that system should show warning message if user try to click regenerate button ", test, test1);
			waitForElement(driver, P_Reset_Btn);
			click(driver, P_Reset_Btn);
			Step_End(13, "Ensure that system should show warning message if user try to click regenerate button ", test, test1);
			waitForElement(driver, regenerate_Button);
			click(driver, regenerate_Button);
			Step_Start(14, "Ensure that system should show warning message as 'Bill for approved contract cannot be regenerated'.", test, test1);
			waitForPopup(driver, P_Invalid_Terms_Popup_Msg, Invalid_Terms_Msg_Txt_Exp);
			String actualTerms_Msg = getText(driver, P_Invalid_Terms_Popup_Msg);
			System.out.println("actualTerms_Msg : " + actualTerms_Msg);
			if (Invalid_Terms_Msg_Txt_Exp.equals(actualTerms_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : "+ Invalid_Terms_Msg_Txt_Exp + " || Actual Popup is : "+ actualTerms_Msg);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : "+ Invalid_Terms_Msg_Txt_Exp + " || Actual Popup is : "+ actualTerms_Msg,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Invalid_Terms_Msg_Txt_Exp + " || Actual Popup is : "+ actualTerms_Msg);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : "	+ Invalid_Terms_Msg_Txt_Exp + " || Actual Popup is : "+ actualTerms_Msg,test, test1);
			}
			Step_End(14, "Ensure that system should show warning message as 'Bill for approved contract cannot be regenerated'.", test, test1);
			Extent_completed(testCase_Name, test, test1);
			scrollTop(driver);
			waitForElement(driver, P_Invalid_Terms_Popup_Close);
			click(driver, P_Invalid_Terms_Popup_Close);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCase_Name="TC_EMS_Contract_Billing_Generation_82";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_082 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_082, testCase_Name, "Dataset"+selected_dataset, File_Path);
			String Field_Names = data.get("Field_Names");
			String Contaract_No_input = data.get("Contaract_No");
			String Search_Contract_No_Popup_Txt_Exp = data.get("Search_Contract_No_Popup_Txt");
			String Add_Remarks_Popup_Txt = data.get("Add_Remarks_Popup");
			String Verified_Popup_Txt = data.get("Verified_Popup");
			String Remark_Txt_Field_input = data.get("Remark_Txt_Field");
			String Highlighted_RedColor_txt_Exp = data.get("Highlighted_RedColor_txt");
			String Approved_Popup_Txt_Exp = data.get("Approved_Popup_Txt");
			String Highlighted_GreenColor_Txt_Exp = data.get("Highlighted_GreenColor_txt");
			String Invalid_Terms_Msg_Txt_Exp = data.get("Invalid_Terms_Msg_Txt");
			String Month_Select_For82 = data.get("Month_Select_For82");
			String Year_Select_For82 = data.get("Year_Select_For82");
			String show_Bills_Button = data.get("show_Bills_Button");
			String reGenerate_Button = data.get("reGenerate_Button");
			String ContractNo_CheckBox_Select = data.get("ContractNo_CheckBox_Select");
			String approve_Remark_Txt_Field_input = data.get("approve_Remark_Txt_Field_input");
			String Condition =data.get("Condition");
			String Search_Contract_No_Column_Header =data.get("Search_Contract_No_Column_Header");
			//locators
			String month_Select82 = String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.month_Select,  Month_Select_For82);
			String show_Bills =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.Generatebutton,  show_Bills_Button);
			String ContractNo_Select_CheckBox =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.ContractNo_Select_ChkBox,  Contaract_No_input);
			String verrified_Row =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.verified_Row,  Contaract_No_input);
			String regenerate_Button = String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.Generatebutton,  reGenerate_Button);
			Extent_Start(testCase_Name, test, test1);

			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			Step_Start(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			waitForDisplay(driver, P_Contract_Module_Page);
			if (isdisplayed(driver, P_Contract_Module_Page)) {
				System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
				Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
			} else {
				System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
				Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
			}
			Step_End(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			Step_Start(2, "Click (+) button from Contract No field", test, test1);
			waitForElement(driver, P_Contact_No_Plus_Btn);
			click(driver, P_Contact_No_Plus_Btn);
			Step_End(2, "Click (+) button from Contract No field", test, test1);

			waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
			String Act_Popup = getText(driver, P_Search_Contract_No_Popup);
			if (Search_Contract_No_Popup_Txt_Exp.equals(Act_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			}
			Step_Start(3, "Select required contract no from the field", test, test1);
			twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
			Step_End(3, "Select required contract no from the field", test, test1);

			if (!Year_Select_For82.equals("")) {
				waitForElement(driver, P_Bill_Period_Year_Field);
				System.out.println("Year_Select_For82 : " + Year_Select_For82);
				clearAndType(driver, P_Bill_Period_Year_Field, Year_Select_For82);
			}
			if (!Month_Select_For82.equals("")) {
				waitForElement(driver, P_Bill_Period_Month_DD);
				click(driver, P_Bill_Period_Month_DD);
				System.out.println("Month_Select_For82 : " + Month_Select_For82);
				waitForElement(driver, month_Select82);
				click(driver, month_Select82);
			}
			Step_Start(4, "Click on Show bills", test, test1);
			waitForElement(driver, show_Bills);
			click(driver, show_Bills);
			Step_End(4, "Click on Show bills", test, test1);
			Step_Start(5, "Select the checkbox from the contract summary for required contract", test, test1);
			waitForElement(driver, ContractNo_Select_CheckBox);
			checkBox(driver, ContractNo_Select_CheckBox, ContractNo_CheckBox_Select);
			Step_End(5, "Select the checkbox from the contract summary for required contract", test, test1);
			Step_Start(6, "Click verify button after entering remarks", test, test1);
			waitForElement(driver, P_Verify_Btn);
			click(driver, P_Verify_Btn);
			Step_End(6, "Click verify button after entering remarks", test, test1);
			Step_Start(7, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			waitForPopup(driver, P_Add_Remark_Title, Add_Remarks_Popup_Txt);
			String Act_Popup_Msg = getText(driver, P_Add_Remark_Title);
			if (Add_Remarks_Popup_Txt.equals(Act_Popup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : " + Add_Remarks_Popup_Txt+ " || Actual Popup is : " + Act_Popup_Msg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Act_Popup_Msg, test,test1);
			}
			waitForElement(driver, P_Remark_Txt_Field);
			click(driver, P_Remark_Txt_Field);
			waitForElement(driver, P_Remark_Txt_Field);
			sendKeys(driver, P_Remark_Txt_Field, Remark_Txt_Field_input);
			waitForElement(driver, P_Remark_Ok_Btn);
			click(driver, P_Remark_Ok_Btn);
			Step_End(7, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			Step_Start(8, "Ensure that system should show confirmation message as 'Verified Successfully'.", test, test1);
			waitForPopup(driver, Popup_Message, Verified_Popup_Txt);
			String act_Popup_Msg = getText(driver, Popup_Message);
			if (Verified_Popup_Txt.equals(act_Popup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Verified_Popup_Txt + " || Actual Popup is : " + act_Popup_Msg, test,test1);
			}
			Step_End(8, "Ensure that system should show confirmation message as 'Verified Successfully'.", test, test1);
			Step_Start(9, "Ensure that system should Highlighted red color for Total by Contract row once verified. ", test, test1);
			waitForElement(driver, verrified_Row);
			String red_Colour_Code = getTextBackgroundColor(driver, verrified_Row);
			String red_Colour = getColorName(red_Colour_Code);
			System.out.println("red_Colour : "+red_Colour);
			if(Highlighted_RedColor_txt_Exp.equals(red_Colour)) {
				System.out.println("Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour);
				Extent_pass_New(driver, "Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour, test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour);
				Extent_fail(driver, "Not Matched || " + " Expected Color is : " + Highlighted_RedColor_txt_Exp + " || Actual Color is : " + red_Colour, test,test1);
			}
			Step_End(9, "Ensure that system should Highlighted red color for Total by Contract row once verified. ", test, test1);
			Step_Start(10, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			waitForElement(driver, ContractNo_Select_CheckBox);
			checkBox(driver, ContractNo_Select_CheckBox, ContractNo_CheckBox_Select);
			waitForElement(driver, P_ApproveBill_Btn);
			click(driver, P_ApproveBill_Btn);
			waitForPopup(driver, P_Approve_Remark_Title, Add_Remarks_Popup_Txt);
			String Popup_Message1 = getText(driver, P_Approve_Remark_Title);
			if (Add_Remarks_Popup_Txt.equals(Popup_Message1)) {
				System.out.println("Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Add_Remarks_Popup_Txt + " || Actual Popup is : " + Popup_Message1,test, test1);
			}
			waitForElement(driver, P_Approve_Remarks_TxtFiled);
			click(driver, P_Approve_Remarks_TxtFiled);
			waitForElement(driver, P_Approve_Remarks_TxtFiled);
			sendKeys(driver, P_Approve_Remarks_TxtFiled, approve_Remark_Txt_Field_input);
			waitForElement(driver, P_Approve_Remarks_OkBtn);
			click(driver, P_Approve_Remarks_OkBtn);
			Step_End(10, "Ensure that system should show succesfully message when user provided remarks and clicked ok button", test, test1);
			Step_Start(11, "Ensure that system should show confirmation message as 'Approved Successfully'.", test, test1);
			waitForPopup(driver, Popup_Message, Approved_Popup_Txt_Exp);
			String approved_Message = getText(driver, Popup_Message);
			if (Approved_Popup_Txt_Exp.equals(approved_Message)) {
				System.out.println("Matched || " + " Expected Popup is : " + Approved_Popup_Txt_Exp+ " || Actual Popup is : " + approved_Message);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Approved_Popup_Txt_Exp+ " || Actual Popup is : " + approved_Message,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Approved_Popup_Txt_Exp + " || Actual Popup is : "+ approved_Message);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : "+ Approved_Popup_Txt_Exp + " || Actual Popup is : "+ approved_Message,test, test1);
			}
			Step_End(11, "Ensure that system should show confirmation message as 'Approved Successfully'.", test, test1);
			Step_Start(12, "Ensure that system should Highlighted Total by contract row in green color once approved", test, test1);
			waitForElement(driver, verrified_Row);
			String green_ColourCode = getTextBackgroundColor(driver, verrified_Row);
			String green_Colour = getColorName(green_ColourCode);
			System.out.println("green_Colour : " + Highlighted_GreenColor_Txt_Exp);
			if (Highlighted_GreenColor_Txt_Exp.equals(green_Colour)) {
				System.out.println("Matched || " + " Expected Color is : "+ Highlighted_GreenColor_Txt_Exp + " || Actual Color is : "+ green_Colour);
				Extent_pass_New(driver,"Matched || " + " Expected Color is : "+ Highlighted_GreenColor_Txt_Exp+ " || Actual Color is : " + green_Colour,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Color is : "+ Highlighted_GreenColor_Txt_Exp + " || Actual Color is : "+ green_Colour);
				Extent_fail(driver,"Not Matched || " + " Expected Color is : "+ Highlighted_GreenColor_Txt_Exp+ " || Actual Color is : " + green_Colour,test, test1);
			}
			Step_End(12, "Ensure that system should Highlighted Total by contract row in green color once approved", test, test1);
			waitForElement(driver, P_Before_ReGen_ContractNo_Value);
			String before_ContNO_Value = getText(driver, P_Before_ReGen_ContractNo_Value);
			waitForElement(driver, P_Reset_Btn);
			click(driver, P_Reset_Btn);
			Step_Start(13, "Ensure that system should show warning message as Do you need to remove the above contracts and continue? if user try to click regenerate button ", test, test1);
			waitForElement(driver, regenerate_Button);
			click(driver, regenerate_Button);
			waitForPopup(driver, P_Invalid_Terms_Popup_Msg, Invalid_Terms_Msg_Txt_Exp);
			String actualTerms_Msg = getText(driver, P_Invalid_Terms_Popup_Msg);
			System.out.println("actualTerms_Msg : " + actualTerms_Msg);
			if (Invalid_Terms_Msg_Txt_Exp.equals(actualTerms_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : "+ Invalid_Terms_Msg_Txt_Exp + " || Actual Popup is : "+ actualTerms_Msg);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : "+ Invalid_Terms_Msg_Txt_Exp + " || Actual Popup is : "+ actualTerms_Msg,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Invalid_Terms_Msg_Txt_Exp + " || Actual Popup is : "+ actualTerms_Msg);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : "	+ Invalid_Terms_Msg_Txt_Exp + " || Actual Popup is : "+ actualTerms_Msg,test, test1);
			}
			Step_End(13, "Ensure that system should show warning message as Do you need to remove the above contracts and continue? if user try to click regenerate button ", test, test1);
			Step_Start(14, "Ensure that system should remove contract from field if user try to click yes button for the warning message", test, test1);
			waitForElement(driver, P_Invalid_Terms_Popup_YesBtn);
			click(driver, P_Invalid_Terms_Popup_YesBtn);
			waitForElement(driver, P_After_ReGen_ContractNo_Value);
			String after_ContNO_Value = getText(driver, P_After_ReGen_ContractNo_Value);
			if(!(before_ContNO_Value.equals(after_ContNO_Value))) {
				System.out.println("Not Matched || " + " Before click yes button the ContracNo field value is : " + before_ContNO_Value + " || After click yes button the ContracNo field value is : " + after_ContNO_Value);
				Extent_pass_New(driver, "Not Matched || " + " Before click yes button the ContracNo field value is : " + before_ContNO_Value + " || After click yes button the ContracNo field value is " + after_ContNO_Value, test,test1);
			}
			else {
				System.out.println(" Matched || " + " Before click yes button the ContracNo field value is : " + before_ContNO_Value + " || After click yes button the ContracNo field value is : " + after_ContNO_Value);
				Extent_fail(driver, " Matched || " + " Before click yes button the ContracNo field value is : " + before_ContNO_Value + " || After click yes button the ContracNo field value is : " + after_ContNO_Value, test,test1);
			}
			Step_End(14, "Ensure that system should remove contract from field if user try to click yes button for the warning message", test, test1);
			Extent_completed(testCase_Name, test, test1);
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCase_Name="TC_EMS_Contract_Billing_Generation_83";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_083 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_083, testCase_Name, "Dataset"+selected_dataset, File_Path);
			String Field_Names = data.get("Field_Names");
			String Contaract_No_input = data.get("Contaract_No");
			String Search_Contract_No_Popup_Txt_Exp = data.get("Search_Contract_No_Popup_Txt");		
			String Bill_Missing_Popup_Msg_Exp = data.get("Bill_Missing_Popup_Msg");		
			String Month_Select_For83 = data.get("Month_Select_For83");
			String Year_Select_For83 = data.get("Year_Select_For83");
			String afterMonth_Select_For83 = data.get("afterMonth_Select_For83");
			String afterYear_Select_For83 = data.get("afterYear_Select_For83");
			String show_Bills_Button = data.get("show_Bills_Button");
			String generate_Button = data.get("generate_Button");
			String Condition =data.get("Condition");
			String Search_Contract_No_Column_Header =data.get("Search_Contract_No_Column_Header");

			//locators
			String month_Select83 = String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.month_Select,  Month_Select_For83);
			String after_month_Select83 = String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.month_Select,  afterMonth_Select_For83);
			String show_Bills =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.Generatebutton,  show_Bills_Button);
			String generateButton =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.Generatebutton,  generate_Button);

			Extent_Start(testCase_Name, test, test1);
			Extent_call(test, test1, "Enter module name in searchbox & click the module");
			moduleNavigate(driver, Field_Names);
			Step_Start(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			waitForDisplay(driver, P_Contract_Module_Page);
			if (isdisplayed(driver, P_Contract_Module_Page)) {
				System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
				Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
			} else {
				System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
				Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
			}
			Step_End(1, " Open EMS Contract Billing Generation & Verification", test, test1);
			Step_Start(2, "Click (+) button from Contract No field", test, test1);
			waitForElement(driver, P_Contact_No_Plus_Btn);
			click(driver, P_Contact_No_Plus_Btn);
			Step_End(2, "Click (+) button from Contract No field", test, test1);

			waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
			String Act_Popup = getText(driver, P_Search_Contract_No_Popup);
			if (Search_Contract_No_Popup_Txt_Exp.equals(Act_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_pass_New(driver,"Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup);
				Extent_fail(driver,"Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp+ " || Actual Popup is : " + Act_Popup,test, test1);
			}
			Step_Start(3, "Select required contract no from the field", test, test1);
			twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
			Step_End(3, "Select required contract no from the field", test, test1);

			if (!Year_Select_For83.equals("")) {
				waitForElement(driver, P_Bill_Period_Year_Field);
				System.out.println("Year_Select_For83 : " + Year_Select_For83);
				clearAndType(driver, P_Bill_Period_Year_Field, Year_Select_For83);
			}
			if (!Month_Select_For83.equals("")) {
				waitForElement(driver, P_Bill_Period_Month_DD);
				click(driver, P_Bill_Period_Month_DD);
				System.out.println("Month_Select_For83 : " + Month_Select_For83);
				waitForElement(driver, month_Select83);
				click(driver, month_Select83);
			}
			Step_Start(4, "Click on Show bills", test, test1);
			waitForElement(driver, show_Bills);
			click(driver, show_Bills);
			Step_End(4, "Click on Show bills", test, test1);

			waitForElement(driver, P_Reset_Btn);
			click(driver, P_Reset_Btn);

			waitForElement(driver, P_Bill_Period_Year_Field);
			System.out.println("Year_Select1_For83 : " + afterYear_Select_For83);
			clearAndType(driver, P_Bill_Period_Year_Field, afterYear_Select_For83);
			waitForElement(driver, P_Bill_Period_Month_DD);
			click(driver, P_Bill_Period_Month_DD);
			System.out.println("Month_Select1_For83 : " + afterMonth_Select_For83);
			waitForElement(driver, after_month_Select83);
			click(driver, after_month_Select83);
			waitForElement(driver, generateButton);
			click(driver, generateButton);
			waitForPopup(driver, P_Missng_Bill_Msg, Bill_Missing_Popup_Msg_Exp);
			String Bill_Missing_Popup = getText(driver, P_Missng_Bill_Msg);
			if (Bill_Missing_Popup_Msg_Exp.equals(Bill_Missing_Popup)) {
				System.out.println("Matched || " + " Expected Popup is : " + Bill_Missing_Popup_Msg_Exp+ " || Actual Popup is : " + Bill_Missing_Popup);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Bill_Missing_Popup_Msg_Exp	+ " || Actual Popup is : " + Bill_Missing_Popup, test, test1);
			} else {
				System.out.println("Not Matched || " + " Expected Popup is : "+ Bill_Missing_Popup_Msg_Exp + " || Actual Popup is : " + Bill_Missing_Popup);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : "+ Bill_Missing_Popup_Msg_Exp + " || Actual Popup is : " + Bill_Missing_Popup,test, test1);
			}
			Extent_completed(testCase_Name, test, test1);
			waitForElement(driver, P_Missng_Bill_CloseBtn);
			click(driver, P_Missng_Bill_CloseBtn);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}

		if(i==1) {
			String testCase_Name="TC_EMS_Contract_Billing_Generation_84";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_084 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_084, testCase_Name, "Dataset"+selected_dataset, File_Path);
			String Field_Names = data.get("Field_Names");
			String Contaract_No_input = data.get("Contaract_No");
			String Search_Contract_No_Popup_Txt_Exp = data.get("Search_Contract_No_Popup_Txt");		
			String Month_Select_For84 = data.get("Month_Select_For84");
			String Year_Select_For84 = data.get("Year_Select_For84");
			String regenerate_Button = data.get("regenerate_Button");
			String Password_Popup_Input_Txt = data.get("Password_Popup_Input");
			String Already_Exist_Bill_Gate_Txt = data.get("Already_Exist_Bill_Gate").trim();
			String Condition =data.get("Condition");
			String Search_Contract_No_Column_Header =data.get("Search_Contract_No_Column_Header");
			//locators
			String regenerateButton =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.Generatebutton,  regenerate_Button);
			String month_Select84 = String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.month_Select,  Month_Select_For84);
			
			Extent_Start(testCase_Name, test, test1);
			// Login
			Step_Start(1, "Open EMS Contract BIlling screen", test, test1);
			//Enter EMS Contract Billing Generation and Verification  model
			moduleNavigate(driver, Field_Names);
			waitForDisplay(driver, P_Contract_Module_Page);
			if (isdisplayed(driver, P_Contract_Module_Page)) {
				System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
				Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
			} else {
				System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
				Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
			}
			Step_End(1, "Open EMS Contract BIlling screen", test, test1);
			Step_Start(2, "Select Contract no which is already uploaded in lessor bill & in error node for bill upload gate", test, test1);
			waitForElement(driver, P_Contact_No_Plus_Btn);
			click(driver, P_Contact_No_Plus_Btn);

			waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
			if(Search_Contract_No_Popup_Txt_Exp.equals(getText(driver, P_Search_Contract_No_Popup))) {
				System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + getText(driver, P_Search_Contract_No_Popup));
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + getText(driver, P_Search_Contract_No_Popup), test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + getText(driver, P_Search_Contract_No_Popup));
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + getText(driver, P_Search_Contract_No_Popup), test,test1);
			}
			twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
			Step_End(2, "Select Contract no which is already uploaded in lessor bill & in error node for bill upload gate", test, test1);
			Step_Start(3, "click regenerate & enter valid password for the same period as upload in bill upload gate", test, test1);
			waitForElement(driver, P_Bill_Period_Year_Field);
			clearAndType(driver, P_Bill_Period_Year_Field,Year_Select_For84);
			waitForElement(driver, P_Bill_Period_Month_DD);
			click(driver, P_Bill_Period_Month_DD);
			System.out.println("Month_Select_For84 : "+Month_Select_For84);
			waitForElement(driver, month_Select84);
			click(driver, month_Select84);

			waitForElement(driver, regenerateButton);
			click(driver, regenerateButton);
			waitForElement(driver, P_Regenaration_Pass_TxtField);
			click(driver, P_Regenaration_Pass_TxtField);
			sendKeys(driver, P_Regenaration_Pass_TxtField, Password_Popup_Input_Txt);
			waitForElement(driver, P_Regenaration_Pass_OkBtn);
			click(driver, P_Regenaration_Pass_OkBtn);
			Step_End(3, "click regenerate & enter valid password for the same period as upload in bill upload gate", test, test1);
			Step_Start(4, "Ensure that system should show warning message as 'This Contract is Already Exist in Bill Upload Gate'.", test, test1);
			waitForPopup(driver, P_Bill_Already_Exist_Popup_Msg, Already_Exist_Bill_Gate_Txt);
			String Exist_Popup_Msg= getText(driver, P_Bill_Already_Exist_Popup_Msg);
			System.out.println("Exist_Popup_Msg : "+Exist_Popup_Msg);
			if(Already_Exist_Bill_Gate_Txt.equals(Exist_Popup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : " + Already_Exist_Bill_Gate_Txt + " || Actual Popup is : " + Exist_Popup_Msg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Already_Exist_Bill_Gate_Txt + " || Actual Popup is : " + Exist_Popup_Msg, test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Already_Exist_Bill_Gate_Txt + " || Actual Popup is : " + Exist_Popup_Msg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Already_Exist_Bill_Gate_Txt + " || Actual Popup is : " + Exist_Popup_Msg, test,test1);
			}
			Step_End(4, "Ensure that system should show warning message as 'This Contract is Already Exist in Bill Upload Gate'.", test, test1);
			Extent_completed(testCase_Name, test, test1);
			waitForElement(driver, P_Bill_Already_Exist_Popup_NoBtn);
			click(driver, P_Bill_Already_Exist_Popup_NoBtn);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCase_Name="TC_EMS_Contract_Billing_Generation_86";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_086 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_086, testCase_Name, "Dataset"+selected_dataset, File_Path);
			String Field_Names = data.get("Field_Names");
			String Contaract_No_input = data.get("Contaract_No");
			String Billing_Period = data.get("Billing_Period");
			String Search_Contract_No_Popup_Txt_Exp = data.get("Search_Contract_No_Popup_Txt");		
			String Month_Select_For86 = data.get("Month_Select_For86");
			String Year_Select_For86 = data.get("Year_Select_For86");
			String regenerate_Button = data.get("regenerate_Button");
			String Password_Popup_Input_Txt = data.get("Password_Popup_Input");
			String Already_Exist_Bill_Gate_Txt = data.get("Already_Exist_Bill_Gate").trim();
			String Search1 = data.get("Search1");
			String fromDate = data.get("fromDate");
			String toDate = data.get("toDate");
			String date_Picker = data.get("date_Picker").trim();
			String Condition =data.get("Condition");
			String Search_Contract_No_Column_Header =data.get("Search_Contract_No_Column_Header");
			//locators
			String regenerateButton =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.Generatebutton,  regenerate_Button);
			String month_Select86 = String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.month_Select,  Month_Select_For86);
			String contractnumbergrid =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.element,  Contaract_No_input);

			Extent_Start(testCase_Name, test, test1);
			Step_Start(1, "Open EMS Contract BIlling screen", test, test1);
			//Enter EMS Contract Billing Generation and Verification  
			moduleNavigate(driver, Field_Names);
			waitForDisplay(driver, P_Contract_Module_Page);
			if (isdisplayed(driver, P_Contract_Module_Page)) {
				System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
				Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
			} else {
				System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
				Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
			}
			Step_End(1, "Open EMS Contract BIlling screen", test, test1);
			Step_Start(2, "Select Contract no which is already uploaded in lessor bill & in error node for bill upload gate", test, test1);
			waitForElement(driver, P_Contact_No_Plus_Btn);
			click(driver, P_Contact_No_Plus_Btn);

			waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
			if(Search_Contract_No_Popup_Txt_Exp.equals(getText(driver, P_Search_Contract_No_Popup))) {
				System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + getText(driver, P_Search_Contract_No_Popup));
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + getText(driver, P_Search_Contract_No_Popup), test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + getText(driver, P_Search_Contract_No_Popup));
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + getText(driver, P_Search_Contract_No_Popup), test,test1);
			}
			twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
			Step_End(2, "Select Contract no which is already uploaded in lessor bill & in error node for bill upload gate", test, test1);
			Step_Start(3, "click regenerate & enter valid password for the same period as upload in bill upload gate", test, test1);
			waitForElement(driver, P_Bill_Period_Year_Field);
			clearAndType(driver, P_Bill_Period_Year_Field,Year_Select_For86);
			waitForElement(driver, P_Bill_Period_Month_DD);
			click(driver, P_Bill_Period_Month_DD);
			System.out.println("Month_Select_For86 : "+Month_Select_For86);
			waitForElement(driver, month_Select86);
			click(driver, month_Select86);

			waitForElement(driver, regenerateButton);
			click(driver, regenerateButton);
			waitForElement(driver, P_Regenaration_Pass_TxtField);
			click(driver, P_Regenaration_Pass_TxtField);
			sendKeys(driver, P_Regenaration_Pass_TxtField, Password_Popup_Input_Txt);
			waitForElement(driver, P_Regenaration_Pass_OkBtn);
			click(driver, P_Regenaration_Pass_OkBtn);
			Step_End(3, "click regenerate & enter valid password for the same period as upload in bill upload gate", test, test1);
			Step_Start(4, "Ensure that system should show warning message as 'This Contract is Already Exist in Bill Upload Gate'.", test, test1);
			waitForPopup(driver, P_Bill_Already_Exist_Popup_Msg, Already_Exist_Bill_Gate_Txt);
			String Exist_Popup_Msg= getText(driver, P_Bill_Already_Exist_Popup_Msg);
			System.out.println("Exist_Popup_Msg : "+Exist_Popup_Msg);
			if(Already_Exist_Bill_Gate_Txt.equals(Exist_Popup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : " + Already_Exist_Bill_Gate_Txt + " || Actual Popup is : " + Exist_Popup_Msg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Already_Exist_Bill_Gate_Txt + " || Actual Popup is : " + Exist_Popup_Msg, test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Already_Exist_Bill_Gate_Txt + " || Actual Popup is : " + Exist_Popup_Msg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Already_Exist_Bill_Gate_Txt + " || Actual Popup is : " + Exist_Popup_Msg, test,test1);
			}
			Step_End(4, "Ensure that system should show warning message as 'This Contract is Already Exist in Bill Upload Gate'.", test, test1);
			Step_Start(5, " Click 'No' button and contract should be cleared from bill upload gate for the given period Check the same in Bill upload that contract should not be delete", test, test1);
			waitForElement(driver, P_Bill_Already_Exist_Popup_NoBtn);
			click(driver, P_Bill_Already_Exist_Popup_NoBtn);
			moduleNavigate(driver, Search1);
			waitForElement(driver, from_Date_BUG);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				click(driver, from_Date_BUG);
				selectDatePicker(driver, from_Date_BUG, fromDate);
			} else {
				clearAndType(driver, from_Date_BUG, fromDate);
			}
			waitForElement(driver, to_Date_BUG);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				click(driver, to_Date_BUG);
				selectDatePicker(driver, to_Date_BUG, toDate);
			} else {
				clearAndType(driver, to_Date_BUG, toDate);
			}
			waitForElement(driver, Arefresh);
			click(driver, Arefresh);
			waitForElement(driver, Tool_Panel_Bill_Upload_Gate);
			click(driver, Tool_Panel_Bill_Upload_Gate);
			waitForElement(driver, Condition_Filter_Bill_Upload_Gate);
			click(driver, Condition_Filter_Bill_Upload_Gate);
			waitForElement(driver, Contract_No_Filter);
			sendKeys(driver, Contract_No_Filter, Contaract_No_input);
			waitForElement(driver, Billing_Period_Filter);
			sendKeys(driver, Billing_Period_Filter, Billing_Period);

			waitForDisplay(driver, contractnumbergrid);
			if (isdisplayed(driver, contractnumbergrid)) {
				System.out
				.println("Matched || Expected "+Contaract_No_input+" Data Should be shown in grid || Actual : "+Contaract_No_input+" Data is shown in grid");
				Extent_pass_New(driver,
						"Matched || Expected "+Contaract_No_input+" Data Should be shown in grid || Actual : "+Contaract_No_input+" Data is shown in grid",test,test1);
			
				waitForElement(driver, Arowoneclick);
				String Location1=getText(driver, Arowoneclick);
				System.out.println(Location1);
				Extent_pass_New(driver,"Contract number shown as"+"****"+
						Location1,test,test1);

				String equetype45=getText(driver, Lessor_BU);
				System.out.println(equetype45);
				Extent_pass_New(driver,"Lessor shown as"
						+"****"+ equetype45,test,test1);
				String equeque=getText(driver, Bill_no_BU);
				System.out.println(equeque);
				Extent_pass_New(driver,"BillNo  shown as "+
						"***"+equeque,test,test1);
				String equequee=getText(driver, Billing_number_BU);
				System.out.println(equequee);
				Extent_pass_New(driver,"Billing Period  shown as "+
						"***"+equequee,test,test1);
				String equequee1=getText(driver, Status_BU);
				System.out.println(equequee1);
				Extent_pass_New(driver,"Status  shown as "+
						"***"+equequee1,test,test1);
			} else {
				System.out.println("Not Matched || Expected : "+Contaract_No_input+" Data should be shown in grid || Actual : "+Contaract_No_input+" Data is not shown in grid");
				Extent_fail(driver,"Not Matched || Expected : "+Contaract_No_input+" Data should be shown in grid || Actual : "+Contaract_No_input+" Data is not shown in grid",test,test1);
			}
			Step_End(5, " Click 'No' button and contract should be cleared from bill upload gate for the given period Check the same in Bill upload that contract should not be delete", test, test1);
			Extent_completed(testCase_Name, test, test1);
			scrollTop(driver);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCase_Name="TC_EMS_Contract_Billing_Generation_85";
			String File_Path = TestNgXml.getfilePath_FromExecution().get(testCase_Name);
			String Sheet_Name_085 = TestNgXml.getsheetName_FromExecution().get(testCase_Name);
			Map<String, String> data = Utils.GetAllData(Sheet_Name_085, testCase_Name, "Dataset"+selected_dataset, File_Path);
			String Field_Names = data.get("Field_Names");
			String Contaract_No_input = data.get("Contaract_No");
			String Billing_Period = data.get("Billing_Period");
			String Search_Contract_No_Popup_Txt_Exp = data.get("Search_Contract_No_Popup_Txt");		
			String Month_Select_For85 = data.get("Month_Select_For85");
			String Year_Select_For85 = data.get("Year_Select_For85");
			String regenerate_Button = data.get("regenerate_Button");
			String Password_Popup_Input_Txt = data.get("Password_Popup_Input");
			String Already_Exist_Bill_Gate_Txt = data.get("Already_Exist_Bill_Gate").trim();
			String fromDate = data.get("fromDate").trim();
			String toDate = data.get("toDate").trim();
			String date_Picker = data.get("date_Picker").trim();
			String Search1 = data.get("Search1");
			String Condition =data.get("Condition");
			String Search_Contract_No_Column_Header =data.get("Search_Contract_No_Column_Header");
			//locators
			String regenerateButton =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.Generatebutton,  regenerate_Button);
			String month_Select85 = String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.month_Select,  Month_Select_For85);
			String contractnumbergrid =  String.format(EMS_Contract_Billing_Generation_And_Verification_Locators.element,  Contaract_No_input);

			Extent_Start(testCase_Name, test, test1);

			moduleNavigate(driver, Search1);
			waitForElement(driver, from_Date_BUG);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, from_Date_BUG, fromDate);
			} else {
				clearAndType(driver, from_Date_BUG, fromDate);

			}
			waitForElement(driver, to_Date_BUG);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, to_Date_BUG, toDate);
			} else {
				clearAndType(driver, to_Date_BUG, toDate);

			}
			waitForElement(driver, Arefresh);
			click(driver, Arefresh);
			waitForElement(driver, Tool_Panel_Bill_Upload_Gate);
			click(driver, Tool_Panel_Bill_Upload_Gate);
			waitForElement(driver, Condition_Filter_Bill_Upload_Gate);
			click(driver, Condition_Filter_Bill_Upload_Gate);
			waitForElement(driver, Contract_No_Filter);
			sendKeys(driver, Contract_No_Filter, Contaract_No_input);
			waitForElement(driver, Billing_Period_Filter);
			sendKeys(driver, Billing_Period_Filter, Billing_Period);
			
			waitForElement(driver, Arowoneclick);
			String Location1=getText(driver, Arowoneclick);
			System.out.println(Location1);
			Extent_pass_New(driver,"Contract number shown as"+"****"+
					Location1,test,test1);

			String equetype45=getText(driver, Lessor_BU);
			System.out.println(equetype45);
			Extent_pass_New(driver,"Lessor shown as"
					+"****"+ equetype45,test,test1);
			String equeque=getText(driver, Bill_no_BU);
			System.out.println(equeque);
			Extent_pass_New(driver,"BillNo  shown as "+
					"***"+equeque,test,test1);
			String equequee=getText(driver, Billing_number_BU);
			System.out.println(equequee);
			Extent_pass_New(driver,"Billing Period  shown as "+
					"***"+equequee,test,test1);
			String equequee1=getText(driver, Status_BU);
			System.out.println(equequee1);
			Extent_pass_New(driver,"Status  shown as "+
					"***"+equequee1,test,test1);
			waitForDisplay(driver, contractnumbergrid);

			if (isdisplayed(driver, contractnumbergrid)) {
				System.out
				.println("Matched || Expected : "+Contaract_No_input+" Data Should be shown in grid || Actual : "+Contaract_No_input+" Data is shown in grid");
				Extent_pass_New(driver,
						"Matched || Expected : "+Contaract_No_input+" Data Should be shown in grid || Actual : "+Contaract_No_input+" Data is shown in grid",test,test1);
			} else {
				System.out.println(
						"Not Matched || Expected : "+Contaract_No_input+" Data Should be shown in grid || Actual : "+Contaract_No_input+" Data is not shown in grid");
				Extent_fail(driver,

						"Not Matched || Expected : "+Contaract_No_input+" Data Should be shown in grid || Actual : "+Contaract_No_input+" Data is not shown in grid",test,test1);
			}
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
			Step_Start(1, "Open EMS Contract BIlling screen", test, test1);
			//Enter EMS Contract Billing Generation and Verification  
			moduleNavigate(driver, Field_Names);
			waitForDisplay(driver, P_Contract_Module_Page);
			if (isdisplayed(driver, P_Contract_Module_Page)) {
				System.out.println("Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed");
				Extent_pass_New(driver, "Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is Dispalyed", test,test1);
			} else {
				System.out.println("Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed");
				Extent_fail(driver, "Not Matched || Expected : EMS Contract Billing Generation and Verification Module should be Dispalyed || Actual : EMS Contract Billing Generation and Verification Module is not Dispalyed",test, test1);
			}
			Step_End(1, "Open EMS Contract BIlling screen", test, test1);
			Step_Start(2, "Select Contract no which is already uploaded in lessor bill & in error node for bill upload gate", test, test1);
			waitForElement(driver, P_Contact_No_Plus_Btn);
			click(driver, P_Contact_No_Plus_Btn);

			waitForPopup(driver, P_Search_Contract_No_Popup, Search_Contract_No_Popup_Txt_Exp);
			if(Search_Contract_No_Popup_Txt_Exp.equals(getText(driver, P_Search_Contract_No_Popup))) {
				System.out.println("Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + getText(driver, P_Search_Contract_No_Popup));
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + getText(driver, P_Search_Contract_No_Popup), test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + getText(driver, P_Search_Contract_No_Popup));
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Search_Contract_No_Popup_Txt_Exp + " || Actual Popup is : " + getText(driver, P_Search_Contract_No_Popup), test,test1);
			}
			twoColumnSearchWindow(driver,Search_Contract_No_Column_Header, Condition, Contaract_No_input);
			Step_End(2, "Select Contract no which is already uploaded in lessor bill & in error node for bill upload gate", test, test1);
			Step_Start(3, "click regenerate & enter valid password for the same period as upload in bill upload gate", test, test1);
			waitForElement(driver, P_Bill_Period_Year_Field);
			clearAndType(driver, P_Bill_Period_Year_Field,Year_Select_For85);
			waitForElement(driver, P_Bill_Period_Month_DD);
			click(driver, P_Bill_Period_Month_DD);
			System.out.println("Month_Select_For85 : "+Month_Select_For85);
			waitForElement(driver, month_Select85);
			click(driver, month_Select85);

			waitForElement(driver, regenerateButton);
			click(driver, regenerateButton);
			waitForElement(driver, P_Regenaration_Pass_TxtField);
			click(driver, P_Regenaration_Pass_TxtField);
			sendKeys(driver, P_Regenaration_Pass_TxtField, Password_Popup_Input_Txt);
			waitForElement(driver, P_Regenaration_Pass_OkBtn);
			click(driver, P_Regenaration_Pass_OkBtn);
			Step_End(3, "click regenerate & enter valid password for the same period as upload in bill upload gate", test, test1);
			Step_Start(4, "Ensure that system should show warning message as 'This Contract is Already Exist in Bill Upload Gate'.", test, test1);
			waitForPopup(driver, P_Bill_Already_Exist_Popup_Msg, Already_Exist_Bill_Gate_Txt);
			String Exist_Popup_Msg= getText(driver, P_Bill_Already_Exist_Popup_Msg);
			System.out.println("Exist_Popup_Msg : "+Exist_Popup_Msg);
			if(Already_Exist_Bill_Gate_Txt.equals(Exist_Popup_Msg)) {
				System.out.println("Matched || " + " Expected Popup is : " + Already_Exist_Bill_Gate_Txt + " || Actual Popup is : " + Exist_Popup_Msg);
				Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + Already_Exist_Bill_Gate_Txt + " || Actual Popup is : " + Exist_Popup_Msg, test,test1);
			}
			else {
				System.out.println("Not Matched || " + " Expected Popup is : " + Already_Exist_Bill_Gate_Txt + " || Actual Popup is : " + Exist_Popup_Msg);
				Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + Already_Exist_Bill_Gate_Txt + " || Actual Popup is : " + Exist_Popup_Msg, test,test1);
			}
			Step_End(4, "Ensure that system should show warning message as 'This Contract is Already Exist in Bill Upload Gate'.", test, test1);
			Step_Start(5, "Click 'Ok' button and contract should be cleared from bill upload gate for the given period", test, test1);
			waitForElement(driver, P_Bill_Already_Exist_Popup_YesBtn);
			click(driver, P_Bill_Already_Exist_Popup_YesBtn);
			waitForDisplay(driver, Bill_Yes_Btn);
			if(isDisplayed(driver, Bill_Yes_Btn)) {
				waitForElement(driver, Bill_Yes_Btn);
				click(driver, Bill_Yes_Btn);
			}
			moduleNavigate(driver, Search1);
			waitForElement(driver, from_Date_BUG);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, from_Date_BUG, fromDate);
			} else {
				clearAndType(driver, from_Date_BUG, fromDate);

			}
			waitForElement(driver, to_Date_BUG);
			if (date_Picker.equalsIgnoreCase("Yes")) {
				selectDatePicker(driver, to_Date_BUG, toDate);
			} else {
				clearAndType(driver, to_Date_BUG, toDate);

			}
			waitForElement(driver, Arefresh);
			click(driver, Arefresh);
			waitForElement(driver, Tool_Panel_Bill_Upload_Gate);
			click(driver, Tool_Panel_Bill_Upload_Gate);
			waitForElement(driver, Condition_Filter_Bill_Upload_Gate);
			click(driver, Condition_Filter_Bill_Upload_Gate);
			waitForElement(driver, Contract_No_Filter);
			sendKeys(driver, Contract_No_Filter, Contaract_No_input);
			waitForElement(driver, Billing_Period_Filter);
			sendKeys(driver, Billing_Period_Filter, Billing_Period);
			
			waitForDisplay(driver, contractnumbergrid);
			if (!isdisplayed(driver, contractnumbergrid)) {
				System.out
				.println("Matched || Expected : "+Contaract_No_input+" Data Should not be shown in grid || Actual : "+Contaract_No_input+" Data is not shown in grid");
				Extent_pass_New(driver,
						"Matched || Expected : "+Contaract_No_input+" Data Should not be shown in grid || Actual : "+Contaract_No_input+" Data is not shown in grid",test,test1);
			} else {
				System.out.println(
						"Not Matched || Expected : "+Contaract_No_input+" Data Should not be shown in grid || Actual : "+Contaract_No_input+" Data is shown in grid");
				Extent_fail(driver,

						"Not Matched || Expected : "+Contaract_No_input+" Data Should not be shown in grid || Actual : "+Contaract_No_input+" Data is shown in grid",test,test1);
			}
			Step_End(5, "Click 'Ok' button and contract should be cleared from bill upload gate for the given period", test, test1);
			Extent_completed(testCase_Name, test, test1);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		
	}
}
