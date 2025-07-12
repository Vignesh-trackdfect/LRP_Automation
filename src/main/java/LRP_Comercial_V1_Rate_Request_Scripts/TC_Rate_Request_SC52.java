package LRP_Comercial_V1_Rate_Request_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Common_Cost_Class;
import commonMethods.Keywords;



public class TC_Rate_Request_SC52 extends Keywords{


	public void Rate_Request_SC52(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url){


		String testCase_Name="TC_Rate_Request_SC52";
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String rateRequestModule = Excel_data.get("ModuleRateRequest");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String commodity = Excel_data.get("commodity");
		String requestStatus = Excel_data.get("RequestStatus");
		String gridRequestStatus = Excel_data.get("GridRequestStatus");
		String submittedPopup = Excel_data.get("SubmittedPopup");
		String wantToProceedPopup = Excel_data.get("WantToProceedPopup");
		String wantToSavePopup = Excel_data.get("WantToSavePopup");
		String OFR1 = Excel_data.get("OFR1");
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
		String To_Date_Input1 = Excel_data.get("To_Date_Input1");
		String date_Picker = Excel_data.get("date_Picker");
		String From_Date_Input1 = Excel_data.get("From_Date_Input1");
		String Pre_Carriage_Radiobtn = Excel_data.get("pre_Carriage_Radiobtn");
		String On_Carriage_Radiobtn = Excel_data.get("On_Carriage_Radiobtn");
		String tService=Excel_data.get("T_Service");
		String TOS=Excel_data.get("TOS_Option");
		String srr_Status_exp=Excel_data.get("srr_Status");
		String moduleSRRGate = Excel_data.get("ModuleSRRGate");
		String date_Perform = Excel_data.get("date_Perform");
		String Flexi_CheckBox = Excel_data.get("Flexi_CheckBox");
		String MTY_CheckBox = Excel_data.get("MTY_CheckBox");
		String payment_Mode = Excel_data.get("payment_Mode");
		String Select_type_location = Excel_data.get("Select_type_location");
		String condition = Excel_data.get("condition");
		String payLocation =Excel_data.get("payLocation");

		String Cust_code2=Excel_data.get("Cust_code2");
		String Customer_code_Value2=Excel_data.get("Customer_code_Value2");
		String Cust_code3=Excel_data.get("Cust_code3");
		String Customer_code_Value3=Excel_data.get("Customer_code_Value3");



		Extent_Start(testCase_Name, test, test1);

		navigateUrl(driver, url);
		//Login
		LRP_Login(driver, username, password);

		//Switch User
		SwitchProfile(driver, agencyUser);

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
			rateRequestDateSelect(driver, date_Perform, date_Picker, From_Date_Input1, To_Date_Input1);

		Step_Start(2, " Enter the customer name", test, test1);

		waitForElement(driver, Customer_Name_search_button);
		click(driver, Customer_Name_search_button);

		globalValueSearchWindow(driver, Condition_Value, Cust_code, Customer_code_Value, Cust_code2, Customer_code_Value2, Cust_code3, Customer_code_Value3);
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
waitForDisplay(driver, flexi_Checkbox_RR);
if(isdisplayed(driver, flexi_Checkbox_RR)) {
	checkBox(driver, flexi_Checkbox_RR, Flexi_CheckBox);
}
waitForDisplay(driver, empty_Checkbox_RR);
if(isdisplayed(driver, empty_Checkbox_RR)) {
	checkBox(driver, empty_Checkbox_RR, MTY_CheckBox);
}

			checkBox(driver, soc_checkbox, SOC_checkbox);

			//Pre Carriage radio btn
			if(!Pre_Carriage_Radiobtn.equals("")) {
	formatLocatorClick(driver, pre_Carriage_Radiobtn, Pre_Carriage_Radiobtn);
}
			if(!On_Carriage_Radiobtn.equals("")) {
	formatLocatorClick(driver, on_Carriage_Radiobtn, On_Carriage_Radiobtn);
}
			rateRequestRoutingDays(driver, Exp_Det_Days_Input, Imp_Det_Days_Input, Exp_Demmurage_Input, Imp_Demmurage_Input);

			Step_Start(9, "Click routing", test, test1);

			waitForElement(driver, Routing_Button);
			click(driver, Routing_Button);
			Step_End(9, "Click routing", test, test1);


			Step_Start(10, "Select the routing", test, test1);

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
			Step_End(10, "Select the routing", test, test1);
										rateRequestPaymentMode_Select(driver, payment_Mode,Select_type_location, condition, payLocation);
										Step_Start(15, "Enter the OFR", test, test1);
			waitForElement(driver, OFR_Txt_Field);
			safeclick(driver, OFR_Txt_Field);
			sendKeys(driver, OFR_Txt_Field, OFR1);

			Step_End(15, "Enter the OFR", test, test1);

			Step_Start(16, "Click Add", test, test1);
			waitForElement(driver, Rate_AddBtn);
			click(driver, Rate_AddBtn);

			Step_End(16, "Click Add", test, test1);
			Step_Start(17, "Click Save button in th	e tool bar", test, test1);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);

			waitForPopup(driver, Rate_Sub_Popup_Msg, wantToSavePopup);

			String actSubmitPopup=getText(driver, Rate_Sub_Popup_Msg);
			if(actSubmitPopup.equals(wantToSavePopup)) {
				Extent_pass_New(driver,"Matched || Expected : popup message should be shown as : "+wantToSavePopup+" || Actual : popup message is shown as : "+ actSubmitPopup, test,test1);
				System.out.println("Matched || Expected : popup message should be shown as : "+wantToSavePopup+" || Actual : popup message is shown as : "+ actSubmitPopup);

			}else {
				System.out.println("Not Matched || Expected : popup message should be shown as : "+wantToSavePopup+" || Actual : popup message is shown as : "+ actSubmitPopup);

				Extent_fail(driver,"Not Matched || Expected : popup message should be shown as : "+wantToSavePopup+" || Actual : popup message is shown as : "+ actSubmitPopup, test,test1);
			}

			Step_End(17, "Click Save button in the tool bar", test, test1);

			Step_Start(18, "Click submit", test, test1);
			waitForElement(driver, Rate_SubmitBtn);
			click(driver, Rate_SubmitBtn);
			waitForPopup(driver, popup_Message, submittedPopup);

			String actualPopup=getText(driver, popup_Message);
			if(actualPopup.equals(wantToProceedPopup)) {
				Extent_pass_New(driver,"Matched || Expected : popup message should be shown "+wantToProceedPopup+" || Actual : popup message is shown as : "+ actualPopup, test,test1);
				System.out.println("Matched || Expected : popup message should be shown as : "+wantToProceedPopup+" || Actual : popup message is shown as : "+ actualPopup);

			}else {
				System.out.println("Not Matched || Expected : popup message should be shown as : "+wantToProceedPopup+" || Actual : popup message is shown as : "+ actualPopup);

				Extent_fail(driver,"Not Matched || Expected : popup message should be shown as : "+wantToProceedPopup+" || Actual : popup message is shown as : "+ actualPopup, test,test1);
			}
			Step_End(18, "Click submit", test, test1);
			Step_Start(19, "Click Ok", test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);

			waitForPopup(driver, Popup_Message, submittedPopup);


			String actSubmittedPopup=getText(driver, Popup_Message);
			System.out.println("Submitted Popup: "+actSubmittedPopup);

			if(actSubmittedPopup.equals(submittedPopup)) {
				Extent_pass_New(driver,"Matched || Expected : popup message should be shown as : "+submittedPopup+" || Actual : popup message is shown as : "+ actSubmittedPopup, test,test1);
				System.out.println("Matched || Expected : popup message should be shown as : "+submittedPopup+" || Actual : popup message is shown as : "+ actSubmittedPopup);
				Extent_pass_New(driver, submittedPopup+" popup is displayed", test,test1);
				System.out.println(submittedPopup+" popup is displayed");

			}else {
				System.out.println("Not Matched || Expected : popup message should be shown as : "+submittedPopup+" || Actual : popup message is shown as : "+ actSubmittedPopup);

				Extent_fail(driver,"Not Matched || Expected : popup message should be shown as : "+submittedPopup+" || Actual : popup message is shown as : "+ actSubmittedPopup, test,test1);
			}
			Step_End(19, "Click Ok", test, test1);
			waitForElement(driver, reqNo_Textfield);
			String actualReqNo=getAttribute(driver, reqNo_Textfield, "value");
			System.out.println("Request Number:"+actualReqNo);  

			if(!actualReqNo.equals(null)) {
				Extent_pass_New(driver,"Matched || "+ actualReqNo + "  is  generated", test,test1);
				System.out.println("Matched || "+actualReqNo+ "  is  generated");

			}else {
				System.out.println("Not Matched || "+ actualReqNo+ "Request Number  is not generated");

				Extent_fail(driver,"Not Matched || "+ actualReqNo + "Request Number  is not generated", test,test1);
			}


			waitForElement(driver, RR_Ocean_Freight_Details_Table_Headers);
			List<Map<String, String>> table_Values = getTableData(driver, RR_Ocean_Freight_Details_Table_Headers, RR_Ocean_Freight_Details_Table_Rows);
			String actGridRequestStatus = getFirstValueByHeader(table_Values, "Request Status");
			if (actGridRequestStatus.equals(gridRequestStatus)) {
				System.out.println("Matched || " + " Expected Report Activity is : " + gridRequestStatus+ " || Actual Report Activity is : " + actGridRequestStatus);
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + gridRequestStatus+ " || Actual Report Activity is : " + actGridRequestStatus, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Report Activity is : " + gridRequestStatus+ " || Actual Report Activity is : " + actGridRequestStatus);
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + gridRequestStatus+ " || Actual Report Activity is : " + actGridRequestStatus, test,test1);
			}
			waitForElement(driver, Request_Status);
			String actRequestStatus = getAttribute(driver, Request_Status, "value");
			if (actRequestStatus.equals(requestStatus)) {
				System.out.println("Matched || " + " Expected Report Activity is : " + requestStatus+ " || Actual Report Activity is : " + actRequestStatus);
				Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + requestStatus+ " || Actual Report Activity is : " + actRequestStatus, test,test1);
			} else {
				System.out.println("Not Matched || " + " Expected Report Activity is : " + requestStatus+ " || Actual Report Activity is : " + actRequestStatus);
				Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + requestStatus+ " || Actual Report Activity is : " + actRequestStatus, test,test1);
			}
			waitForDisplay(driver, Mail_Cancel_button);
		if(isdisplayed(driver, Mail_Cancel_button)) {
		click(driver, Mail_Cancel_button);
		}


			Step_Start(16, "Switch to line profile and navigate to the special rate request screen using SRR gate screen under Submit node.", test, test1);

			ResetProfile(driver);
			moduleNavigate(driver, moduleSRRGate);
			//Submitted	
			waitForElement(driver, submit_RadioButton);
			click(driver, submit_RadioButton);



			waitForElement(driver, menu_Icon_Grid);
			click(driver, menu_Icon_Grid);

			waitForElement(driver, filter_Icon_Grid);
			click(driver, filter_Icon_Grid);

			waitForElement(driver, filter_Inputfield);
			click(driver, filter_Inputfield);
			sendKeys(driver, filter_Inputfield, actualReqNo);
			enter(driver);

			waitForElement(driver, select_Actual_ReqNo);
			doubleClick(driver, select_Actual_ReqNo);

			Step_End(16, "Switch to line profile and navigate to the special rate request screen using SRR gate screen under Submit node.", test, test1);

			Step_Start(17, "Click edit.", test, test1);

			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);
			Step_End(17, "Click edit.", test, test1);

			Step_Start(18, ".Click Approve button.", test, test1);

			scrollBottom(driver);

			waitForElement(driver, SRR_Approve_Button);
			if(isElementEnabled(driver, SRR_Approve_Button)) {
				click(driver, SRR_Approve_Button);
			}else {
				waitForElement(driver, SRR_Contribution);
				click(driver, SRR_Contribution);
				String missingCost = getText(driver, SRR_Missing_Cost_Value);
				waitForElement(driver, Srr_missing_cost_exit_button);
				click(driver, Srr_missing_cost_exit_button);
				Common_Cost_Class cost =new Common_Cost_Class();
				cost.parseEquipmentData(driver, missingCost, test, test1, selected_dataset);
				waitForElement(driver, Special_Rate_Request_Module);
				click(driver, Special_Rate_Request_Module);
				waitForElement(driver, refresh_contribution_Srr);
				click(driver, refresh_contribution_Srr);
				waitForElement(driver, SRR_Approve_Button);
				click(driver, SRR_Approve_Button);
			}

			Step_End(18, ".Click Approve button.", test, test1);



			Step_Start(19, ".click save.", test, test1);

			scrollTop(driver);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			scrollTop(driver);
			waitForElement(driver, srr_Status);
			String srr_status_actual_approval = getText(driver, srr_Status);
			if(srr_status_actual_approval.equalsIgnoreCase(srr_Status_exp)) {

				System.out.println("Matched|| expected srr status is -> "+srr_Status_exp+"||actual srr status -> "+srr_status_actual_approval);
				Extent_pass_New(driver, "Matched|| expected srr status is -> "+srr_Status_exp+"||actual srr status -> "+srr_status_actual_approval, test, test1);


			}else {


				System.out.println("Not Matched|| expected srr status is -> "+srr_Status_exp+"||actual srr status -> "+srr_status_actual_approval);
				Extent_fail(driver, "Not Matched|| expected srr status is -> "+srr_Status_exp+"||actual srr status -> "+srr_status_actual_approval, test, test1);

			}

			Step_End(19, ".click save.", test, test1);

			Step_Start(20, "Click edit.", test, test1);

			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			Step_End(20, "Click edit.", test, test1);

			Step_Start(21, "Click Recall.", test, test1);
			scrollBottom(driver);
			waitForElement(driver, recall_btn_srr);
			click(driver, recall_btn_srr);

			Step_End(21, "Click Recall.", test, test1);

			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);

			scrollTop(driver);
			waitForElement(driver, srr_Status);
			String srr_status_actual_recall = getText(driver, srr_Status);
			if(srr_status_actual_recall.equalsIgnoreCase(requestStatus)) {

				System.out.println("Matched|| expected srr status is -> "+requestStatus+"||actual srr status -> "+srr_status_actual_recall);
				Extent_pass_New(driver, "Matched|| expected srr status is -> "+requestStatus+"||actual srr status -> "+srr_status_actual_recall, test, test1);

			}else {

				System.out.println("Not Matched|| expected srr status is -> "+requestStatus+"||actual srr status -> "+srr_status_actual_recall);
				Extent_fail(driver, "Not Matched|| expected srr status is -> "+requestStatus+"||actual srr status -> "+srr_status_actual_recall, test, test1);

			}


		Extent_completed(testCase_Name, test, test1);




	}	


}
