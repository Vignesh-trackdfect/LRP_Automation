package LRP_Cost_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Cost_Activity_Report_TS009 extends Keywords {

	public void Cost_Activity_Report_TS009(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name = "TC_Cost_Activity_Report_TS009";
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String Cost_Activity_Report_Module = Excel_data.get("Cost_Activity_Report_Module");
		String GivenContract_Type = Excel_data.get("GivenContract_Type");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Port = Excel_data.get("Port");
		String Terminal = Excel_data.get("Terminal");
		String Arrival_Date = Excel_data.get("Arrival_Date");
		String Condition1 = Excel_data.get("Condition1");
		String GivenMode = Excel_data.get("GivenMode");
		String Save_Popup = Excel_data.get("Save_Popup");
		String Quantity = Excel_data.get("Quantity");
		String EqpType = Excel_data.get("EqpType");
		String Vendor_Code = Excel_data.get("Vendor_Code");
		String Amount = Excel_data.get("Amount");
		String Service_Filter_Header = Excel_data.get("Service_Filter_Header");
		String Vessel_Filter_Header = Excel_data.get("Vessel_Filter_Header");
		String Port_Filter_Header = Excel_data.get("Port_Filter_Header");
		String Terminal_Filter_Header = Excel_data.get("Terminal_Filter_Header");
		String ArrivalDate_Filter_Header = Excel_data.get("ArrivalDate_Filter_Header");
		String EqpType_Filter_Header = Excel_data.get("EqpType_Filter_Header");
		String VendorCode_Filter_Header = Excel_data.get("VendorCode_Filter_Header");
		String Agency = Excel_data.get("Agency");

		String Contract_option = String.format(Select_ContractType, GivenContract_Type);
		String Mode_option = String.format(Select_ModeOption, GivenMode);

		String Two_Column_Condition = Excel_data.get("Two_Column_Condition");
		String Activities_Add_CAR = Excel_data.get("Activities_Add_CAR");
		String Activity_Header_CAR = Excel_data.get("Activity_Header_CAR");
		String Currency_Select = Excel_data.get("Currency_Select");

		String Delete_CAR = Excel_data.get("Delete_CAR");

		
		Extent_Start(tc_Name, test, test1);

		navigateUrl(driver, url);

		Step_Start(1,	"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);

		LRP_Login(driver, username, password);
		
		SwitchProfile(driver, Agency);

		verifyMainMenu(driver);

		Step_End(1,	"Once login to the application and click on switch profile option and select for the required agency",
				test, test1);
		Step_Start(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		moduleNavigate(driver, Cost_Activity_Report_Module);

		Step_End(2, "Enter the screen name as Cost Activity Report in module search field", test, test1);

		Step_Start(3, "Click on the Contract type field and Select the drop down as \"MSC\"", test, test1);

		waitForElement(driver, Contract_type);
		click(driver, Contract_type);

		waitForElement(driver, Contract_option);
		click(driver, Contract_option);

		waitForElement(driver, Select_Mode);
		click(driver, Select_Mode);

		waitForElement(driver, Mode_option);
		click(driver, Mode_option);
		Step_End(3, "Click on the Contract type field and Select the drop down as \"MSC\"", test, test1);

		Step_Start(4, "Click on the Service search button and select the required service code", test, test1);

		waitForElement(driver, Service_Search);
		click(driver, Service_Search);

		twoColumnSearchWindow(driver, Service_Filter_Header, Condition1, Service);

		Step_End(4, "Click on the Service search button and select the required service code", test, test1);

		Step_Start(5, "Click on the Vessel search button and select the required vessel code", test, test1);

		waitForElement(driver, Vessel_Search);
		click(driver, Vessel_Search);

		twoColumnSearchWindow(driver, Vessel_Filter_Header, Condition1, Vessel);

		Step_End(5, "Click on the Vessel search button and select the required vessel code", test, test1);

		Step_Start(6, "Click on the Port search button and select the required port code", test, test1);

		waitForElement(driver, port_Search);
		click(driver, port_Search);

		twoColumnSearchWindow(driver, Port_Filter_Header, Condition1, Port);

		Step_End(6, "Click on the Port search button and select the required port code", test, test1);

		Step_Start(7, "Click on the Terminal search button and select the required terminal code", test, test1);

		waitForElement(driver, CAR_Terminal_Search);
		click(driver, CAR_Terminal_Search);

		twoColumnSearchWindow(driver, Terminal_Filter_Header, Condition1, Terminal);

		Step_End(7, "Click on the Terminal search button and select the required terminal code", test, test1);

		Step_Start(8, "Click on the Arrival date search button and select the required date", test, test1);

		waitForElement(driver, ArrivalDate_Search);
		click(driver, ArrivalDate_Search);

		twoColumnSearchWindow(driver, ArrivalDate_Filter_Header, Condition1, Arrival_Date);

		Step_End(8, "Click on the Arrival date search button and select the required date", test, test1);

		Step_Start(9, "Click on the Show button", test, test1);

		waitForElement(driver, Show_Button_CAR);
		click(driver, Show_Button_CAR);

		Step_End(9, "Click on the Show button", test, test1);

		Step_Start(10, "Click on the Add button and system will list down the activities in new window", test, test1);

		waitForElement(driver, ADD_button_MSC_CAR);
		click(driver, ADD_button_MSC_CAR);
		Step_End(10, "Click on the Add button and system will list down the activities in new window", test, test1);

		Step_Start(11, "Select the activities by clicking on the check box.", test, test1);
		Step_Start(12, "Click on the select button", test, test1);

		twoColumnSearchWindowMultipleValue(driver,Activity_Header_CAR,Two_Column_Condition,Activities_Add_CAR);
		elementnotvisible1(driver, select_Button);
		Step_End(11, "Select the activities by clicking on the check box.", test, test1);		
		Step_End(12, "Click on the select button", test, test1);

		Step_Start(13, "The selected activities will set in the AG Grid", test, test1);
		List<String> Activities=splitAndExpand(Activities_Add_CAR);
		for(String act:Activities) {
			String UpdatedActivity=String.format(MSC_table_Activity_Column_CAR_New, act);
			if(isDisplayed(driver, UpdatedActivity)) {
				System.out.println("Expected : Selected Activity '"+act+"' Should Updated in the Table || Actual : Selected Activity '"+act+"' is Updated in the Table");
				Extent_pass_New(driver, "Expected : Selected Activity '"+act+"' Should Updated in the Table || Actual : Selected Activity '"+act+"' is Updated in the Table", test, test1);
			}else {
				System.out.println("Expected : Selected Activity '"+act+"' Should Updated in the Table || Actual : Selected Activity '"+act+"' is not Updated in the Table");
				Extent_fail(driver, "Expected : Selected Activity '"+act+"' Should Updated in the Table || Actual : Selected Activity '"+act+"' is not Updated in the Table", test, test1);
			}
		}
		Step_End(13, "The selected activities will set in the AG Grid", test, test1);

		List<String> EqpTypeList=splitAndExpand(EqpType);
		List<String> QuantityList=splitAndExpand(Quantity);
		List<String> Vendor_Code_List=splitAndExpand(Vendor_Code);
		List<String> Amount_List=splitAndExpand(Amount);
		
		List<String> CurrencyValue=splitAndExpand(Currency_Select);

		
		for(int i=0;i<Activities.size();i++) {
			Step_Start(14, "Then select the activities in AG grid and Enter the required quantity", test, test1);
			String UpdatedActivityQuantColumn=String.format(MSC_table_Quantity_Column_CAR_New, Activities.get(i));
			waitForElement(driver, UpdatedActivityQuantColumn);
			doubleClick(driver, UpdatedActivityQuantColumn);
			
			String UpdatedActivityQuan=String.format(MSC_table_Quantity_input_CAR_New, Activities.get(i));
			waitForElement(driver, UpdatedActivityQuan);
			sendKeys(driver, UpdatedActivityQuan, QuantityList.get(i));
			Step_End(14, "Then select the activities in AG grid and Enter the required quantity", test, test1);
			
			Step_Start(15, "Click on the Eqp. type button and system will list down the activities in new window", test, test1);
			formatLocatorClick(driver, MSC_table_Activity_Column_CAR_New, Activities.get(i));
			
			waitForElement(driver, MSC_Equipment_Type_Button_CAR);
			click(driver,MSC_Equipment_Type_Button_CAR);
			Step_End(15, "Click on the Eqp. type button and system will list down the activities in new window", test, test1);

			Step_Start(16, ".Select the required Equipment type and click on the select button", test, test1);
			twoColumnSearchWindow(driver,EqpType_Filter_Header,Condition1,EqpTypeList.get(i));
			Step_End(16, ".Select the required Equipment type and click on the select button", test, test1);

			Step_Start(17, "Check whether the equipment type is set in the activity and click on the vendor code button,system will listdown the vendor details in new window", test, test1);
			String Selected_EqpType=String.format(MSC_Table_EqpType_Column_CAR_New, Activities.get(i));
			waitForElement(driver, Selected_EqpType);
			String Updated_EpqType=getText(driver, Selected_EqpType);
			if(Updated_EpqType.equals(EqpTypeList.get(i))) {
				System.out.println("Expected : Selected Eqp Type '"+EqpTypeList.get(i)+"' Should updated Correctly in the Table || Actual : Selected Eqp Type is updated Correctly in the Table");
				Extent_pass_New(driver, "Expected : Selected Eqp Type '"+EqpTypeList.get(i)+"' Should updated Correctly in the Table || Actual : Selected Eqp Type is updated Correctly in the Table", test, test1);
			}else {
				System.out.println("Expected : Selected Eqp Type '"+EqpTypeList.get(i)+"' Should updated Correctly in the Table || Actual : Selected Eqp Type is not updated Correctly in the Table");
				Extent_fail(driver, "Expected : Selected Eqp Type '"+EqpTypeList.get(i)+"' Should updated Correctly in the Table || Actual : Selected Eqp Type is not updated Correctly in the Table", test, test1);
			}
			
			waitForElement(driver, MSC_Vendor_Code_Button_CAR);
			click(driver,MSC_Vendor_Code_Button_CAR);
			Step_End(17, "Check whether the equipment type is set in the activity and click on the vendor code button,system will listdown the vendor details in new window", test, test1);

			Step_Start(18, "Select the required vendor code", test, test1);
			twoColumnSearchWindow(driver,VendorCode_Filter_Header,Condition1,Vendor_Code_List.get(i));
			Step_End(18, "Select the required vendor code", test, test1);

			Step_Start(19, "Enter the required amount by selecting each activity one by one", test, test1);
			String Selected_VendorCode=String.format(MSC_Table_Vendor_Code_Column_CAR_New, Activities.get(i));
			waitForElement(driver, Selected_VendorCode);
			String Updated_VendorCode=getText(driver, Selected_VendorCode);
			if(Updated_VendorCode.equals(Vendor_Code_List.get(i))) {
				System.out.println("Expected : Selected Vendor Code '"+Vendor_Code_List.get(i)+"' Should updated Correctly in the Table || Actual : Selected Vendor Code is updated Correctly in the Table");
				Extent_pass_New(driver, "Expected : Selected Vendor Code '"+Vendor_Code_List.get(i)+"' Should updated Correctly in the Table || Actual : Selected Vendor Code is updated Correctly in the Table", test, test1);
			}else {
				System.out.println("Expected : Selected Vendor Code '"+Vendor_Code_List.get(i)+"' Should updated Correctly in the Table || Actual : Selected Vendor Code is not updated Correctly in the Table");
				Extent_fail(driver, "Expected : Selected Vendor Code '"+Vendor_Code_List.get(i)+"' Should updated Correctly in the Table || Actual : Selected Vendor Code is not updated Correctly in the Table", test, test1);
			}
			
			String Activity_Amount_Col=String.format(MSC_Table_Amount_Column_CAR_New, Activities.get(i));
			waitForElement(driver, Activity_Amount_Col);
			doubleClick(driver,Activity_Amount_Col);
			
			String Activity_Amount_Input=String.format(MSC_Table_Amount_Input_CAR_New, Activities.get(i));
			System.out.println("Amount_List : "+Amount_List.get(i));
			waitForElement(driver, Activity_Amount_Input);
			clear(driver,Activity_Amount_Input);
			waitForElement(driver, Activity_Amount_Input);
			sendKeys(driver, Activity_Amount_Input,Amount_List.get(i));
		    UpdatedActivityQuantColumn=String.format(MSC_table_Activity_Column_CAR_New, Activities.get(i));
			waitForElement(driver, UpdatedActivityQuantColumn);
			click(driver,UpdatedActivityQuantColumn);
			Step_End(19, "Enter the required amount by selecting each activity one by one", test, test1);
			
			
			Extent_call(test, test1, "Select  the Currency - start ");
			
			if(!CurrencyValue.get(i).trim().equals("")) {
				String Activity_CurrencyColumn=String.format(MSC_Table_Cuurency_Column_CAR_New, Activities.get(i));
				waitForElement(driver, Activity_CurrencyColumn);
				doubleClick(driver, Activity_CurrencyColumn);
				
				String valString=""+CurrencyValue.get(i).charAt(0);
				Actions action=new Actions(driver);
				
				action.sendKeys(valString).build().perform();
				String CurrencySelect=String.format(Currency_List_Option_CAR, CurrencyValue.get(i));
				
				for(int k=0;k<20;k++) {
					
					if(isdisplayed(driver, CurrencySelect)) {
						formatLocatorClick(driver, Currency_List_Option_CAR, CurrencyValue.get(i));
						break;
					}
					action.sendKeys(Keys.DOWN).build().perform();
				}
				
			}
			
			Extent_call(test, test1, "Select  the Currency - start ");

		}
		
		
		Step_Start(20,
				"Click on the tool bar save button and check whether the system shows the information message as \"Container Activity Report Saved\".",
				test, test1);

		scrollTop(driver);

		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		waitForPopup(driver, popup_Message, Save_Popup);
		String SavePopupmessage = getText(driver, popup_Message);

		if (SavePopupmessage.equals(Save_Popup)) {

			System.out.println(
					"Activity report is saved || Expected : " + Save_Popup + " || Actual : " + SavePopupmessage);
			Extent_pass_New(driver,
					"Activity report is saved || Expected : " + Save_Popup + " || Actual : " + SavePopupmessage, test,
					test1);
		} else {

			System.out.println(
					"Activity report is not saved || Expected : " + Save_Popup + " || Actual : " + SavePopupmessage);
			Extent_fail(driver,
					"Activity report is not saved || Expected : " + Save_Popup + " || Actual : " + SavePopupmessage,
					test, test1);
		}

		waitForElement(driver, popup_Message_Ok_Button);
		click(driver, popup_Message_Ok_Button);

		Step_End(20,
				"Click on the tool bar save button and check whether the system shows the information message as \"Container Activity Report Saved\".",
				test, test1);

		
		if(Delete_CAR.equalsIgnoreCase("Yes")) {
			scrollTop(driver);
			waitForElement(driver, Delete_button_toolBar);
			click(driver,Delete_button_toolBar);
			
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver,popup_Message_Yes_Button);
			
			waitForElement(driver, popup_Message_Ok_Button);
			click(driver,popup_Message_Ok_Button);
			
		}
		
		
		
		Extent_completed(tc_Name, test, test1);

	}

}
