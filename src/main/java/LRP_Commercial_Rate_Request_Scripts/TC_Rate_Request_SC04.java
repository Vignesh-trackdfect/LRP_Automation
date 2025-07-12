package LRP_Commercial_Rate_Request_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Rate_Request_SC04 extends Keywords {

	public void SOCContainer(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url)
			throws Exception {

		String tc_Name="TC_Rate_Request_SC04";

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String rateRequestModule = Excel_data.get("ModuleRateRequest");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String commodity = Excel_data.get("commodity");
		String moduleSRRGate = Excel_data.get("ModuleSRRGate");
		String requestStatus = Excel_data.get("RequestStatus");
		String gridRequestStatus = Excel_data.get("GridRequestStatus");
		String submittedPopup = Excel_data.get("SubmittedPopup");
		String wantToProceedPopup = Excel_data.get("WantToProceedPopup");
		String wantToSavePopup = Excel_data.get("WantToSavePopup");
		String oFR = Excel_data.get("oFR");
		String eqpType = Excel_data.get("eqpType");
		String grossWeight = Excel_data.get("GrossWeight");
		String Exp_Det_Days_Input = Excel_data.get("Exp_Det_Days_Input");
		String Imp_Det_Days_Input = Excel_data.get("Imp_Det_Days_Input");
		String Exp_Demmurage_Input = Excel_data.get("Exp_Demmurage_Input");
		String Imp_Demmurage_Input = Excel_data.get("Imp_Demmurage_Input");
		String agencyUser = Excel_data.get("Agency_user");
		String SOC_checkbox = Excel_data.get("SOC_checkbox");
		String NOR_checkbox = Excel_data.get("NOR_checkbox");
		String OOG_checkbox = Excel_data.get("OOG_checkbox");
		String DG_checkboxs = Excel_data.get("DG_checkboxs");
		String Routing_Service = Excel_data.get("Routing_Service");
		String Eqp_Quantity_Input = Excel_data.get("Eqp_Quantity_Input");
		String Cust_code = Excel_data.get("Cust_code");
		String Condition_Value = Excel_data.get("Condition_Value");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String To_Date_Input = Excel_data.get("To_Date_Input");
		String date_Picker = Excel_data.get("date_Picker");
		String From_Date_Input = Excel_data.get("From_Date_Input");
		String Do_You_Want_Delete = Excel_data.get("Do_You_Want_Delete");
		String Pre_Carriage_Radiobtn = Excel_data.get("pre_Carriage_Radiobtn");
		String On_Carriage_Radiobtn = Excel_data.get("On_Carriage_Radiobtn");
		String tService = Excel_data.get("T_Service");
		String TOS = Excel_data.get("TOS_Option");
		String Customer_code_Value2 = Excel_data.get("Customer_code_Value2");
		String Customer_code_Value3 = Excel_data.get("Customer_code_Value3");
		String Cust_code2 = Excel_data.get("Cust_code2");
		String Cust_code3 = Excel_data.get("Cust_code3");
		String Rate_Request_NO= Excel_data.get("Rate_Request_NO");
		String date_Perform = Excel_data.get("date_Perform");
		String Flexi_CheckBox = Excel_data.get("Flexi_CheckBox");
		String MTY_CheckBox = Excel_data.get("MTY_CheckBox");
		String payment_Mode = Excel_data.get("payment_Mode");
		String Select_type_location = Excel_data.get("Select_type_location");
		String condition = Excel_data.get("condition");
		String payLocation =Excel_data.get("payLocation");

		Extent_Start(tc_Name, test, test1);

		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, username, password);
		//Switch User
		SwitchProfile(driver, agencyUser);

		//Module search
		moduleNavigate(driver, rateRequestModule);

		// Rate Request
		Step_Start(1, "Click on the new button in the toolbar", test, test1);
		waitForElement(driver, Requet_Type);
newButton(driver);

		Step_End(1, "Click on the new button in the toolbar", test, test1);
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
		rateRequestDateSelect(driver, date_Perform, date_Picker, From_Date_Input, To_Date_Input);

		Step_Start(2, " Enter the customer name", test, test1);

		waitForElement(driver, Customer_Name_search_button);
		click(driver, Customer_Name_search_button);
		globalValueSearchWindow(driver, Condition_Value, Cust_code, Customer_code_Value, Cust_code2, Customer_code_Value2,Cust_code3, Customer_code_Value3);
		rateRequestCustomerExistOption(driver);

		Step_End(2, " Enter the customer name", test, test1);

		Step_Start(3, "Enter the origin", test, test1);
		waitForElement(driver, Orgin_Input);
		sendKeys(driver, Orgin_Input, origin);
		waitForElement(driver, Auto_Panel_First);
		safeclick(driver, Auto_Panel_First);
		Step_End(3, "Enter the origin", test, test1);

		Step_Start(4, "Enter the Delivery", test, test1);

		waitForElement(driver, RR_Delivery_Input);
		sendKeys(driver, RR_Delivery_Input, delivery);
		waitForElement(driver, Auto_Panel_First);
		safeclick(driver, Auto_Panel_First);
		System.out.println("Delivery Value:" + delivery);
		Step_End(4, "Enter the Delivery", test, test1);

		Step_Start(5, "Enter the Commodity.", test, test1);

		waitForElement(driver, Commodity_Input);
		Newclear(driver, Commodity_Input);
		Actionsendkeys(driver, Commodity_Input, commodity);
		waitForElement(driver, Auto_Panel_First);
		safeclick(driver, Auto_Panel_First);
		System.out.println("Commodity Value:" + commodity);

		Step_End(5, "Enter the Commodity.", test, test1);

		Step_Start(6, "Enter the Equipment type.", test, test1);
		waitForElement(driver, Eqp_Type);
		click(driver, Eqp_Type);
		sendKeys(driver, Eqp_Type, eqpType);
		waitForElement(driver, Auto_Panel_First);
		safeclick(driver, Auto_Panel_First);
		System.out.println("Eqp type:"+eqpType);
		Step_End(6, "Enter the Equipment type.", test, test1);

		Step_Start(7, " Enter the Quantity", test, test1);

		waitForElement(driver, Eqp_Quantity);
		click(driver, Eqp_Quantity);
		Newclear(driver, Eqp_Quantity);
		Actionsendkeys(driver, Eqp_Quantity,Eqp_Quantity_Input );
		Step_End(7, " Enter the Quantity", test, test1);

		Step_Start(8, "Enter the Gross Weight", test, test1);

		waitForElement(driver, RR_Gross_Weight);
		Newclear(driver, RR_Gross_Weight);
		Actionsendkeys(driver, RR_Gross_Weight, grossWeight);
		Step_End(8, "Enter the Gross Weight", test, test1);
		//checkboxs
		checkBox(driver, DG_checkbox, DG_checkboxs);

		checkBox(driver, oog_checkbox, OOG_checkbox);

		checkBox(driver, nor_checkbox, NOR_checkbox);

		Step_Start(9, "Click on the SOC Flag", test, test1);

		waitForElement(driver, soc_checkbox);
		checkBox(driver, soc_checkbox, SOC_checkbox);

		Step_End(9, "Click on the SOC Flag", test, test1);
		waitForDisplay(driver, flexi_Checkbox_RR);
		if(isdisplayed(driver, flexi_Checkbox_RR)) {
			checkBox(driver, flexi_Checkbox_RR, Flexi_CheckBox);
		}
		waitForDisplay(driver, empty_Checkbox_RR);
		if(isdisplayed(driver, empty_Checkbox_RR)) {
			checkBox(driver, empty_Checkbox_RR, MTY_CheckBox);
		}


		if(!Pre_Carriage_Radiobtn.equals("")) {
			formatLocatorClick(driver, pre_Carriage_Radiobtn, Pre_Carriage_Radiobtn);
		}
		if(!On_Carriage_Radiobtn.equals("")) {
			formatLocatorClick(driver, on_Carriage_Radiobtn, On_Carriage_Radiobtn);
		}


		rateRequestRoutingDays(driver, Exp_Det_Days_Input, Imp_Det_Days_Input, Exp_Demmurage_Input, Imp_Demmurage_Input);

		Step_Start(10, "Click routing", test, test1);

		waitForElement(driver, Routing_Button);
		click(driver, Routing_Button);
		Step_End(10, "Click routing", test, test1);


		Step_Start(11, "Select the routing", test, test1);

		waitForElement(driver, routingSearch_Frame);
		String actRoutingFrame=getText(driver, routingSearch_Frame);
		if(isDisplayed(driver, routingSearch_Frame)) {
			Extent_pass_New(driver, actRoutingFrame+" is displayed", test,test1);
			System.out.println(actRoutingFrame+" is displayed");
			waitForElement(driver, Routing_ToolPannel);
			safeclick(driver, Routing_ToolPannel);
			waitForElement(driver, Routing_condition_Filter);
			safeclick(driver, Routing_condition_Filter);
			waitForElement(driver, Routing_OriginTF);
			sendKeys(driver, Routing_OriginTF, origin);
			waitForElement(driver, Routing_service_TF);
			sendKeys(driver, Routing_service_TF, Routing_Service);
			waitForElement(driver, select_First_Routing);
			doubleClick(driver, select_First_Routing);

		}else {
			System.out.println(actRoutingFrame+" is not displayed");
			Extent_fail(driver, actRoutingFrame+" is not displayed", test,test1);
		}


		Step_End(11, "Select the routing", test, test1);
		rateRequestPaymentMode_Select(driver, payment_Mode,Select_type_location, condition, payLocation);
		Step_Start(12, "Enter the OFR", test, test1);
		rateRequestPaymentMode_Select(driver, payment_Mode,Select_type_location, condition, payLocation);
		waitForElement(driver, OFR_Txt_Field);
		safeclick(driver, OFR_Txt_Field);
		sendKeys(driver, OFR_Txt_Field, oFR);

		Step_End(12, "Enter the OFR", test, test1);

		Step_Start(13, "Click Add", test, test1);
		waitForElement(driver, Rate_AddBtn);
		click(driver, Rate_AddBtn);

		Step_End(13, "Click Add", test, test1);
		Step_Start(14, "Click Save button in the tool bar", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		//waitForElement(driver, Rate_Sub_Popup_Msg);


		waitForPopup(driver, Rate_Sub_Popup_Msg, wantToSavePopup);


		String actSubmitPopup=getText(driver, Rate_Sub_Popup_Msg);
		if(actSubmitPopup.equals(wantToSavePopup)) {
			Extent_pass_New(driver,"Matched || Expected : popup message should be shown as : "+wantToSavePopup+" || Actual : popup message is shown as : "+ actSubmitPopup, test,test1);
			System.out.println("Matched || Expected : popup message should be shown as :  "+wantToSavePopup+" || Actual : popup message is shown as : "+ actSubmitPopup);
			Extent_pass_New(driver, wantToSavePopup+" is displayed", test,test1);
			System.out.println(wantToSavePopup+" is displayed");

		}else {
			System.out.println(wantToSavePopup+" is not displayed");
			System.out.println("Not Matched || Expected : popup message should be shown as :  "+wantToSavePopup+" || Actual : popup message is shown as : "+ actSubmitPopup);

			Extent_fail(driver,"Not Matched || Expected : popup message should be shown as :  "+wantToSavePopup+" || Actual : popup message is shown as : "+ actSubmitPopup, test,test1);
		}

		Step_End(14, "Click Save button in the tool bar", test, test1);

		Step_Start(15, "Click submit", test, test1);
		waitForElement(driver, Rate_SubmitBtn);
		click(driver, Rate_SubmitBtn);
		waitForPopup(driver, popup_Message, wantToProceedPopup);
		String actualPopup=getText(driver, popup_Message);
		if(actualPopup.equals(wantToProceedPopup)) {
			Extent_pass_New(driver,"Matched || Expected : popup message should be shown as : "+wantToProceedPopup+" || Actual : popup message is shown as : "+ actualPopup, test,test1);
			System.out.println("Matched || Expected : popup message should be shown as : "+wantToProceedPopup+" || Actual : popup message is shown as : "+ actualPopup);
			Extent_pass_New(driver, wantToProceedPopup+" popup is displayed", test,test1);
			System.out.println(wantToProceedPopup+" popup is displayed");


		}else {
			System.out.println(wantToProceedPopup+ " popup is not displayed");
			System.out.println("Not Matched || Expected : popup message should be shown as : "+wantToProceedPopup+" || Actual : popup message is shown as : "+ actualPopup);

			Extent_fail(driver,"Not Matched || Expected : popup message should be shown as : "+wantToProceedPopup+" || Actual : popup message is shown as : "+ actualPopup, test,test1);
		}
		Step_End(15, "Click submit", test, test1);
		Step_Start(16, "Click Ok", test, test1);
		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		waitForPopup(driver, Popup_Message, submittedPopup);
		String actSubmittedPopup=getText(driver,Popup_Message);
		System.out.println("Submitted Popup: "+actSubmittedPopup);

		if(actSubmittedPopup.equals(submittedPopup)) {
			Extent_pass_New(driver,"Matched || Expected : popup message should be shown as : "+submittedPopup+" || Actual : popup message is shown as : "+ actSubmittedPopup, test,test1);
			System.out.println("Matched || Expected : popup message should be shown as : "+submittedPopup+" || Actual : popup message is shown as : "+ actSubmittedPopup);
			Extent_pass_New(driver, submittedPopup+" popup is displayed", test,test1);
			System.out.println(submittedPopup+" popup is displayed");

		}else {
			System.out.println(submittedPopup+ " popup is not displayed");

			Extent_fail(driver,"Not Matched || Expected : popup message should be shown as : "+submittedPopup+" || Actual : popup message is shown as : "+ actSubmittedPopup, test,test1);
			System.out.println("Not Matched || Expected : popup message should be shown as : "+submittedPopup+" || Actual : popup message is shown as : "+ actSubmittedPopup);
		}
		Step_End(16, "Click Ok", test, test1);
		waitForDisplay(driver, Mail_Cancel_button);
		if(isdisplayed(driver, Mail_Cancel_button)) {
		click(driver, Mail_Cancel_button);
		}
		waitForElement(driver, reqNo_Textfield);
		String actualReqNoSOC=getAttribute(driver, reqNo_Textfield, "value");
		System.out.println("Request Number:"+actualReqNoSOC);  

		if(!actualReqNoSOC.equals(null)) {
			Extent_pass_New(driver,"Matched || "+ actualReqNoSOC + "  is  generated", test,test1);
			System.out.println("Matched || "+actualReqNoSOC+ "  is  generated");

		}else {
			System.out.println("Not Matched || "+ actualReqNoSOC+ "Request Number  is not generated");

			Extent_fail(driver,"Not Matched || "+ actualReqNoSOC + "Request Number  is not generated", test,test1);
		}

		waitForElement(driver, RR_Ocean_Freight_Details_Table_Headers);
		List<Map<String, String>> table_Values = getTableData(driver, RR_Ocean_Freight_Details_Table_Headers, RR_Ocean_Freight_Details_Table_Rows);
		String actGridReqStatusSOC = getFirstValueByHeader(table_Values, "Request Status");
		if (actGridReqStatusSOC.equals(gridRequestStatus)) {
			System.out.println("Matched || " + " Expected Report Activity is : " + gridRequestStatus+ " || Actual Report Activity is : " + actGridReqStatusSOC);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + gridRequestStatus+ " || Actual Report Activity is : " + actGridReqStatusSOC, test,test1);
		} else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + gridRequestStatus+ " || Actual Report Activity is : " + actGridReqStatusSOC);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + gridRequestStatus+ " || Actual Report Activity is : " + actGridReqStatusSOC, test,test1);
		}
		waitForElement(driver, Request_Status);
		String actReqStatusSOC = getAttribute(driver, Request_Status, "value");
		if (actReqStatusSOC.equals(requestStatus)) {
			System.out.println("Matched || " + " Expected Report Activity is : " + requestStatus+ " || Actual Report Activity is : " + actReqStatusSOC);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + requestStatus+ " || Actual Report Activity is : " + actReqStatusSOC, test,test1);
		} else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + requestStatus+ " || Actual Report Activity is : " + actReqStatusSOC);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + requestStatus+ " || Actual Report Activity is : " + actReqStatusSOC, test,test1);
		}

		Extent_call(test, test1, "Checking whether the SOC flag is enabled in the screen when submitted");
		waitForElement(driver, soc_checkbox);
		if(isElementSelected(driver, soc_checkbox)){
			System.out.println(" EXPECTED RESULT IS : SOC FLAG SHOULD BE SELECTED IN THE SCREEN || ACTUAL RESULT IS : SOC FLAG IS SELECTED IN THE SCREEN");
			Extent_pass_New(driver, " EXPECTED RESULT IS : SOC FLAG SHOULD BE SELECTED IN THE SCREEN || ACTUAL RESULT IS : SOC FLAG IS SELECTED IN THE SCREEN", test, test1);

		}else {
			System.out.println(" EXPECTED RESULT IS : SOC FLAG SHOULD BE SELECTED IN THE SCREEN || ACTUAL RESULT IS : SOC FLAG IS NOT SELECTED IN THE SCREEN");
			extent_fail(driver, " EXPECTED RESULT IS : SOC FLAG SHOULD BE SELECTED IN THE SCREEN || ACTUAL RESULT IS : SOC FLAG IS NOT SELECTED IN THE SCREEN", test, test1);

		}
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);


		Extent_call(test, test1, "Rate request Delete start");
		if(Do_You_Want_Delete.equalsIgnoreCase("Yes")){
			moduleNavigate(driver, moduleSRRGate);

			//SRR Gate


			//Submitted	
			waitForElement(driver, submit_RadioButton);
			click(driver, submit_RadioButton);

			waitForElement(driver, menu_Icon_Grid);
			click(driver, menu_Icon_Grid);

			waitForElement(driver, filter_Icon_Grid);
			click(driver, filter_Icon_Grid);

			waitForElement(driver, filter_Inputfield);
			click(driver, filter_Inputfield);
			waitForElement(driver, filter_Inputfield);
			sendKeys(driver, filter_Inputfield, actualReqNoSOC);
			enter(driver);

			waitForElement(driver, select_Actual_ReqNo);
			String submitted_ReqNumSOC=getText(driver, select_Actual_ReqNo);
			if(submitted_ReqNumSOC.equals(actualReqNoSOC)) {
				System.out.println("Matched || " + " Expected Value is : " + actualReqNoSOC + " || Actual Value is : " + submitted_ReqNumSOC);
				Extent_pass_New(driver,"Matched || " + " Expected Value is : " + actualReqNoSOC + " || ActualValue is : " + submitted_ReqNumSOC,test,test1);
				Extent_pass_New(driver, actualReqNoSOC+"  is submitted", test,test1);
				System.out.println(actualReqNoSOC+" is submitted");

				click(driver, select_Actual_ReqNo);
				waitForElement(driver, select_Actual_ReqNo);
				RightClick(driver, select_Actual_ReqNo);
				waitForElement(driver, moveTo_Pending);
				click(driver, moveTo_Pending);


				waitForElement(driver, close_Moved_Pending_Popup);
				click(driver, close_Moved_Pending_Popup);

			}else {
				System.out.println(actualReqNoSOC+" is not submitted");
				System.out.println("Not matched || " + " Expected Value is : " + actualReqNoSOC + " || Actual Value  is : " + submitted_ReqNumSOC);
				Extent_fail(driver,"Not matched || " + " Expected Value is : " + actualReqNoSOC + " || Actual Value is : " + submitted_ReqNumSOC,test,test1);

			}		
			//Pending	
			waitForElement(driver, pending_RadioButton);
			click(driver, pending_RadioButton);

			waitForElement(driver, menu_Icon_Grid);
			click(driver, menu_Icon_Grid);

			waitForElement(driver, filter_Icon_Grid);
			click(driver, filter_Icon_Grid);

			waitForElement(driver, filter_Inputfield);
			click(driver, filter_Inputfield);
			waitForElement(driver, filter_Inputfield);
			sendKeys(driver, filter_Inputfield, actualReqNoSOC);
			enter(driver);

			waitForElement(driver, select_Actual_ReqNo);
			String pending_ReqNumSOC=getText(driver, select_Actual_ReqNo);
			if(pending_ReqNumSOC.equals(actualReqNoSOC)) {

				System.out.println("Matched || " + " Expected Value is : " + actualReqNoSOC + " || Actual Value is : " + pending_ReqNumSOC);
				Extent_pass_New(driver,"Matched || " + " Expected Value is : " + actualReqNoSOC + " || ActualValue is : " + pending_ReqNumSOC,test,test1);
				Extent_pass_New(driver, actualReqNoSOC+"  is moved To pending", test,test1);
				System.out.println(actualReqNoSOC+" is moved To pending");

				click(driver, select_Actual_ReqNo);
				waitForElement(driver, select_Actual_ReqNo);
				doubleClick(driver, select_Actual_ReqNo);
				//added
				waitForElement(driver, cancel_Common_btn);
				click(driver, cancel_Common_btn);
				waitForElement(driver, SearchButton_Toolbar);
				click(driver, SearchButton_Toolbar);
				globalValueSearchWindow(driver, Condition_Value,Rate_Request_NO,actualReqNoSOC,"", "", "","");


				waitForElement(driver, Delete_button_toolBar);
				click(driver, Delete_button_toolBar);

				waitForElement(driver, delete_Request_Popup);
				click(driver, delete_Request_Popup_Ok);

				waitForElement(driver, comment_Ok_Button);
				click(driver, comment_Ok_Button);

			}else {
				System.out.println(actualReqNoSOC+" is not moved To pending");
				System.out.println("Not matched || " + " Expected Value is : " + actualReqNoSOC + " || Actual Value  is : " + pending_ReqNumSOC);
				Extent_fail(driver,"Not matched || " + " Expected Value is : " + actualReqNoSOC + " || Actual Value is : " + pending_ReqNumSOC,test,test1);
			}		

		}
		Extent_call(test, test1, "Rate request Delete Ended");
		Extent_completed(tc_Name, test, test1);
	}

}
