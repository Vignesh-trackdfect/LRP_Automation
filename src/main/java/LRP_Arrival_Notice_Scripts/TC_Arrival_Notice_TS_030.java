package LRP_Arrival_Notice_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Arrival_Notice_Locators;

public class TC_Arrival_Notice_TS_030 extends Keywords {
public void Arrival_Notice_TS_030(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

//	To Check system allows to save the record by customer option in transhipment location and match the consignee ,notify customer details with import documentation screen
	
	String testCaseName="TC_Arrival_Notice_TS_030";

		// Get data from test data

		
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_AgencyConfiguration=Excel_data.get("Module_AgencyConfiguration");
		String Agency_Code_search=Excel_data.get("Agency_Code_search");
		String condition_Filter=Excel_data.get("Condition_Filter");
		String Attribute_Search=Excel_data.get("Attribute_Search");
		String attribute1=Excel_data.get("Attribute1");
		String description1=Excel_data.get("AttributeDescription1");
		String AAN_value1=Excel_data.get("AAN_value1");
		String module_ArrivalNotice = Excel_data.get("Module_ArrivalNotice");
		String dropdownCondition = Excel_data.get("GlobalSearchDropdownCondition1");
		String Search_Number=Excel_data.get("Search_Number");
		String Customer_code_search=Excel_data.get("Customer_code_search");
		String customerCode=Excel_data.get("CutomerCode");
		String Customer_Name_Search=Excel_data.get("Customer_Name_Search");
		String customer_Name = Excel_data.get("Customer_Name");
		String bl_Number = Excel_data.get("BL_Number");
		String arrivalNoticeSavedMsg=Excel_data.get("ArrivalNoticeSavedMsg");
		String pinkColorCode=Excel_data.get("PinkColorCode");
		String columnHeaders=Excel_data.get("ColumnHeaders");
		String module_ImportDocumentation = Excel_data.get("Module_ImportDocumentation");
		String Delete_Perform=Excel_data.get("Delete_Perform");
		String AAN_value2=Excel_data.get("AAN_value2");

		
		navigateUrl(driver, url);
		Extent_Start(testCaseName, test, test1);


		// Login


		LRP_Login(driver, username, password);


	// Switch User
		Step_Start(1, "Select Transhipment agency", test, test1);
		
		
		SwitchProfile(driver, agencyUser);

		Step_End(1, "Select Transhipment agency", test, test1);
		
// Agency Configuration
		Extent_cal(test, test1, module_AgencyConfiguration);
		Step_Start(2, "Search the module name  ( \"Arrival Notice / Freight Memo\" ) in module search (Make sure AAN configuration set as Y in agency configuration screen)", test, test1);
		setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Code_search, Attribute_Search, condition_Filter, agencyUser, attribute1, description1, AAN_value1);
	
		
				

				
				moduleNavigate(driver, module_ArrivalNotice);

				

				Step_End(2, "Search the module name  ( \"Arrival Notice / Freight Memo\" ) in module search (Make sure AAN configuration set as Y in agency configuration screen)", test, test1);
				
			Extent_cal(test, test1, module_ArrivalNotice);	
			Step_Start(3, "Click the new button on tool bar", test, test1);

				
			newButton(driver);
				Step_End(3, "Click the new button on tool bar", test, test1);
				Step_Start(4, "Choose the option of customer option", test, test1);
				
				waitForElement(driver, byCustomer_RadioButton);
				click(driver, byCustomer_RadioButton);
				
				Step_End(4, "Choose the option of customer option", test, test1);
				Step_Start(5, "Enter the valid customer code", test, test1);
				
				waitForElement(driver, customer_SearchButton);
				click(driver, customer_SearchButton);
				
				

				globalValueSearchWindow(driver, dropdownCondition, Customer_code_search, customerCode,Customer_Name_Search,customer_Name, "","");
			
				
				Step_End(5, "Enter the valid customer code", test, test1);
				Step_Start(6, "Click the Show button", test, test1);
				
				waitForElement(driver, show_Btn_An);
				click(driver, show_Btn_An);
				
				Step_End(6, "Click the Show button", test, test1);
				Step_Start(7, "Select the displayed Bl number in below grid", test, test1);
				
				waitForElement(driver, Nine_Dotted_Icon);
				click(driver, Nine_Dotted_Icon);
				waitForElement(driver, condition_Filter_AN);
				click(driver, condition_Filter_AN);
				waitForElement(driver, blNumber_Filter_AN);
				sendKeys(driver, blNumber_Filter_AN,bl_Number );
				
				String select_checkboxx1 =  String.format(Arrival_Notice_Locators.select_Checkbox1,bl_Number); 
				waitForElement(driver, select_checkboxx1);
				click(driver, select_checkboxx1);
				Step_End(7, "Select the displayed Bl number in below grid", test, test1);
				Step_Start(8, "Click edit button on tool bar", test, test1);
				
				scrollTop(driver);

				waitForElement(driver, Edit_Button_toolBar);
				click(driver, Edit_Button_toolBar);
				
				Step_End(8, "Click edit button on tool bar", test, test1);

				Step_Start(9, "Click the save button on tool bar ", test, test1);
				
				waitForElement(driver, SaveButton_ToolBar);
				click(driver, SaveButton_ToolBar);
				waitForPopup(driver, Popup_Message, arrivalNoticeSavedMsg);     
				String actualSavedMsg=getText(driver, Popup_Message);
				System.out.println("actualSavedMsg:"+actualSavedMsg);
				if(actualSavedMsg.equals(arrivalNoticeSavedMsg)) {
					Extent_pass(driver, "Matched || Expected  popup : "+arrivalNoticeSavedMsg+" || Actual popup: "+actualSavedMsg, test, test1);
					System.out.println("Matched || Expected popup: "+arrivalNoticeSavedMsg+" || Actual popup: "+actualSavedMsg);
				}else {
					System.out.println("Not Matched || Expected popup: "+arrivalNoticeSavedMsg+" || Actual popup: "+actualSavedMsg);
					Extent_fail(driver, "Not Matched || Expected popup: "+arrivalNoticeSavedMsg+" || Actual popup: "+actualSavedMsg, test, test1);
				}
				
				
				waitForElement(driver, Nine_Dotted_Icon);
				click(driver, Nine_Dotted_Icon);
				waitForElement(driver, condition_Filter_AN);
				click(driver, condition_Filter_AN);
				waitForElement(driver, blNumber_Filter_AN);
				sendKeys(driver, blNumber_Filter_AN,bl_Number );
				
				waitForDisplay(driver, arrivalNotice_Number);
				if(isdisplayed(driver, arrivalNotice_Number)){
				String generated_AN_Number=getText(driver, arrivalNotice_Number);
				if(!generated_AN_Number.equals("")) {
					Extent_pass(driver, "Generated Arrival Notice Number as : "+generated_AN_Number, test, test1);
					System.out.println("Generated Arrival Notice Number as : "+generated_AN_Number);
				}
				}
				
				waitForElement(driver, select_checkboxx1);
				click(driver, select_checkboxx1);
				
				waitForElement(driver, arrivalNotice_Number_Row);
				String actualColour1=getTextBackgroundColor(driver, arrivalNotice_Number_Row);
				String actualColour=getColorName(actualColour1);
				System.out.println("actualColour:"+actualColour);

				if(actualColour.equalsIgnoreCase(pinkColorCode)) {
					
					
					Extent_pass(driver, "Matched || Expected The background color of the row should be: "+pinkColorCode+" || Actual The background color of the row be : "+actualColour, test, test1);
					System.out.println("Matched || Expected The background color of the row should be: "+pinkColorCode+" || Actual The background color of the row be : "+actualColour);
				}else {
					System.out.println("Matched || Expected The background color of the row should be: "+pinkColorCode+" || Actual The background color of the row not same be : "+actualColour);
					Extent_fail(driver, "Matched || Expected The background color of the row should be: "+pinkColorCode+" || Actual The background color of the row not same be : "+actualColour, test, test1);
					
				}
					
			
				
				waitForElement(driver, select_checkboxx1);
				click(driver, select_checkboxx1);
				
				reArrangeAG_GridColumnsNew(driver, AN_COLOUM, columnHeaders);
				
				waitForDisplay(driver, consignee_Code_AN_Grid);
				String actualConsigneeCode_AN=getText(driver, consignee_Code_AN_Grid);
				String actualConsignee_AN=getText(driver, consignee_AN_Grid);
				
				ArrayList<String> consigneeDetails_AN=new ArrayList<>();
				consigneeDetails_AN.add(actualConsigneeCode_AN.trim());
				consigneeDetails_AN.add(actualConsignee_AN.trim());
				
				String actualNotifyCode_AN=getText(driver, notify_Code_AN_Grid);
				String actualNotifyName_AN=getText(driver, notifyName_AN_Grid);
				
				ArrayList<String> notifyDeatils_AN=new ArrayList<String>();
				notifyDeatils_AN.add(actualNotifyCode_AN.trim());
				notifyDeatils_AN.add(actualNotifyName_AN.trim());

				ArrayList<String> expected_customerDetails=new ArrayList<>();
				expected_customerDetails.add(customerCode.trim());
				expected_customerDetails.add(customer_Name.trim());
				
				if(consigneeDetails_AN.equals(expected_customerDetails)) {
					Extent_pass(driver, "Matched || Expected customer detials: "+expected_customerDetails+" || Actual customer detials shown: "+consigneeDetails_AN, test, test1);
					System.out.println("Matched || Expected customer detials: "+expected_customerDetails+" || Actual customer detials shown: "+consigneeDetails_AN);
				}else {
					System.out.println("Not Matched || Expected customer detials: "+expected_customerDetails+" || Actual customer detials not shown: "+consigneeDetails_AN);
					Extent_fail(driver, "Not Matched || Expected customer detials: "+expected_customerDetails+" || Actual customer detials not shown: "+consigneeDetails_AN, test, test1);
				}
				
				Step_End(9, "Click the save button on tool bar", test, test1);
				
				Step_Start(10, "Open import documentation click search button", test, test1);
				
//				Import Documentation
		
				moduleNavigate(driver, module_ImportDocumentation);

						waitForElement(driver, SearchButton_Toolbar);
						click(driver, SearchButton_Toolbar);
						
						Step_End(10, "Open import documentation click search button", test, test1);
						Step_Start(11, "Paste the \"Arrival Notice / Freight Memo\" saved Bl", test, test1);
						
					
						globalValueSearchWindow(driver, dropdownCondition, Search_Number, bl_Number, "","", "","");
					
					
						Step_End(11, "Paste the \"Arrival Notice / Freight Memo\" saved Bl", test, test1);
						Step_Start(12, "Click customer tab ", test, test1);
						
						
						scrollBottom(driver);
						waitForElement(driver, Customer_Tab_IMD);
						click(driver, Customer_Tab_IMD);
						
						Step_End(12, "Click customer tab ", test, test1);
						Step_Start(13, "Check consignee and Notify customer details match with saved \"Arrival Notice / Freight Memo\"", test, test1);
				
						List<Map<String, String>> customer_Tabledata = getTableData(driver, customerTab_TableHeaders, customerTab_TableRows);
						

						String customerTab_CustomerCode_CN = getValueByFirstColumnAndHeader(customer_Tabledata, "Customer Type", "CN", "Customer Code");
						String customerTab_CustomerCode_NT = getValueByFirstColumnAndHeader(customer_Tabledata, "Customer Type", "NT", "Customer Code");
						String customerTab_CustomerName_CN = getValueByFirstColumnAndHeader(customer_Tabledata, "Customer Type", "CN", "Name");
						String customerTab_CustomerName_NT = getValueByFirstColumnAndHeader(customer_Tabledata, "Customer Type", "NT", "Name");

						ArrayList<String> custDetails_CN=new ArrayList<String>();
						custDetails_CN.add(customerTab_CustomerCode_CN);
						custDetails_CN.add(customerTab_CustomerName_CN);
						ArrayList<String> custDetails_NT=new ArrayList<String>();
						custDetails_NT.add(customerTab_CustomerCode_NT);
						custDetails_NT.add(customerTab_CustomerName_NT);

				
						if(custDetails_CN.equals(consigneeDetails_AN)) {
							Extent_pass(driver, "Matched || Expected Consignee Details: "+consigneeDetails_AN+" || Actual Consignee Details: "+custDetails_CN, test, test1);
							System.out.println("Matched || Expected Consignee Details: "+consigneeDetails_AN+" || Actual Consignee Details: "+custDetails_CN);
						}else {
							System.out.println("Not Matched || Expected Consignee Details: "+consigneeDetails_AN+" || Actual Consignee Details: "+custDetails_CN);
							Extent_fail(driver, "Not Matched || Expected Consignee Details: "+consigneeDetails_AN+" || Actual Consignee Details: "+custDetails_CN, test, test1);
						}
						if(custDetails_NT.equals(notifyDeatils_AN)) {
							Extent_pass(driver, "Matched || Expected Notify Details: "+notifyDeatils_AN+" || Actual Notify Details: "+custDetails_NT, test, test1);
							System.out.println("Matched || Expected Notify Details: "+notifyDeatils_AN+" || Actual Notify Details: "+custDetails_NT);
						}else {
							System.out.println("Not Matched || Expected Notify Details: "+notifyDeatils_AN+" || Actual Notify Details: "+custDetails_NT);
							Extent_fail(driver, "Not Matched || Expected Notify Details: "+notifyDeatils_AN+" || Actual Notify Details: "+custDetails_NT, test, test1);
						}
			
						
				Step_End(13, "Check consignee and Notify customer details match with saved \"Arrival Notice / Freight Memo\"", test, test1);
				
				Step_Start(14, "Click the saved Arrival notice bl and click Delete button", test, test1);
				Extent_cal(test, test1, module_ArrivalNotice);
				scrollTop(driver);
				waitForElement(driver, arrivalNotice_Module);
				click(driver, arrivalNotice_Module);
				scrollTop(driver);
				if(Delete_Perform.equalsIgnoreCase("YES")) {
				waitForElement(driver, Delete_button_toolBar);
				click(driver, Delete_button_toolBar);
				Step_End(14, "Click the saved Arrival notice bl and click Delete button", test, test1);
				Step_Start(15, "Click Yes and system validates Arrival notice deleted.", test, test1);
				waitForElement(driver, popup_Message);
				if (isDisplayed(driver, popup_Message)) {
					click(driver, popup_Message_Yes_Button);
				} 
				waitForDisplay(driver, Popup_Message);
				if(isdisplayed(driver, Popup_Message)){
				String actualMsg=getText(driver, Popup_Message);
				System.out.println("actualMsg : "+actualMsg);
					System.out.println(actualMsg+" popup is displayed");
					Extent_pass(driver, actualMsg+" popup is displayed", test, test1);
				}}
				
				Step_End(15, "Click Yes and system validates Arrival notice deleted.", test, test1);
				setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Code_search, Attribute_Search, condition_Filter, agencyUser, attribute1, description1, AAN_value2);
				
			
						Extent_completed(testCaseName, test, test1);
}
}
