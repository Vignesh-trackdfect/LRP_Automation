package LRP_Comercial_V1_Rate_Request_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Common_Cost_Class;
import commonMethods.Keywords;




public class TC_Rate_Request_SC68 extends Keywords{

	public void Rate_Request_SC68(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

		String testcase_Name="TC_Rate_Request_SC68";
		
		
		


		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String search_module = Excel_data.get("Search_module");
		String delivery=Excel_data.get("Delivery");
		String Eqp_Quantity_Input =Excel_data.get("Eqp_Quantity_Input");
		String DG_checkboxs = Excel_data.get("DG_checkboxs");
		String NOR_checkbox = Excel_data.get("NOR_checkbox");
		String SOC_checkbox = Excel_data.get("SOC_checkbox");
		String OOG_checkbox = Excel_data.get("OOG_checkbox");
		String agencyUser = Excel_data.get("AgencyUser");
		
		String routing_Service = Excel_data.get("Routing_Service");

		String From_Date_Input =Excel_data.get("From_Date_Input");
		String To_Date_Input =Excel_data.get("To_Date_Input");
		String customerCode_Option =Excel_data.get("CustomerCode_Option");
		String condition_Option =Excel_data.get("Condition_Option");
		String customerCode =Excel_data.get("CustomerCode");
		String datePicker =Excel_data.get("DatePicker");
		String service =Excel_data.get("Service");
		String Origin_Input=Excel_data.get("Origin_Input");
		String Commodity_Input_Txt=Excel_data.get("Commodity_Input");
		String Eqp_Type_Input=Excel_data.get("Eqp_Type_Input");	
		String Gross_Weight_Input=Excel_data.get("Gross_Weight_Input");
		String Length_Field_Input=Excel_data.get("Length_Field_Input");
		String Width_Field_Input=Excel_data.get("Width_Field_Input");
		String Height_Field_Input=Excel_data.get("Height_Field_Input");
		String Exp_Det_Days_Input=Excel_data.get("Exp_Det_Days_Input");
		String Imp_Det_Days_Input=Excel_data.get("Imp_Det_Days_Input");
		String Exp_Demmurage_Input=Excel_data.get("Exp_Demmurage_Input");
		String Imp_Demmurage_Input=Excel_data.get("Imp_Demmurage_Input");
		String OFR_Txt_Field_Input=Excel_data.get("OFR_Txt_Field_Input");
		String Req_Submit_Popup_Txt=Excel_data.get("Req_Submit_Popup_Txt");
		String Rate_Req_Submitted_Popup_Txt=Excel_data.get("Rate_Req_Submitted_Popup_Txt");
		String Req_Status_Exp=Excel_data.get("Req_Status_Exp");
		String Module_SRR_Gate=Excel_data.get("Module_SRR_Gate");
		String srrRequestType=Excel_data.get("SRR_RequestType");

		String Request_Input=Excel_data.get("Request_Type_Input");
		String Pre_Carriage_Radiobtn = Excel_data.get("pre_Carriage_Radiobtn");
		String On_Carriage_Radiobtn = Excel_data.get("on_Carriage_Radiobtn");

		String SRR_Grid_Status = Excel_data.get("SRR_Grid_Status");
		String SRR_Status = Excel_data.get("SRR_Status");
		String tService=Excel_data.get("T_Service");
		String TOS=Excel_data.get("TOS_Option");
		String paymentMode=Excel_data.get("PaymentMode");
		String flexi_checkbox=Excel_data.get("Flexi_checkbox");
		String MTY_checkbox=Excel_data.get("MTY_checkbox");

		String search2=Excel_data.get("search2");
		String input2=Excel_data.get("input2");
		String search3=Excel_data.get("search3");
		String input3=Excel_data.get("input3");

		String payLocation=Excel_data.get("PayLocation");
		String condition=Excel_data.get("Condition");
		String Select_type_location = Excel_data.get("Select_type_location");
		String date_Perform = Excel_data.get("date_Perform");
		String Flexi_CheckBox = Excel_data.get("Flexi_CheckBox");
		String MTY_CheckBox = Excel_data.get("MTY_CheckBox");



		navigateUrl(driver, url);

		Extent_Start(testcase_Name, test, test1);

		//Login
		LRP_Login(driver, username, password);

		//Switch Profile

		SwitchProfile(driver, agencyUser);

		moduleNavigate(driver, search_module);

		Step_Start(1, "Click on the new button in the toolbar", test, test1);

		waitForElement(driver, Requet_Type);
newButton(driver);
		Step_End(1, "Click on the new button in the toolbar", test, test1);

		waitForElement(driver, Requet_Type);
click(driver,Requet_Type);
formatLocatorClick(driver, RequestType, Request_Input);

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

		Step_Start(2, "Enter the customer name", test, test1);


		waitForElement(driver, Customer_Name_search_button);
		click(driver, Customer_Name_search_button);

		globalValueSearchWindow(driver, condition_Option, customerCode_Option, customerCode, search2, input2, search3, input3);

			rateRequestCustomerExistOption(driver);

			Step_Start(3, "Enter the origin", test, test1);
			waitForElement(driver, Orgin_Input);
			sendKeys(driver, Orgin_Input, Origin_Input);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);
			Step_End(3, "Enter the origin", test, test1);

			Step_Start(4, "Enter the Delivery", test, test1);
			waitForElement(driver, Delivery_Input_Field);
			sendKeys(driver, Delivery_Input_Field,delivery );
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);

			Step_End(4, "Enter the Delivery", test, test1);
			rateRequestDateSelect(driver, date_Perform, datePicker, From_Date_Input, To_Date_Input);

			click(driver, service_Textfield);
			clearAndType(driver, service_Textfield, service);

			Step_Start(5, "Enter the Commodity", test, test1);
			waitForElement(driver, Commodity_Input);
			Newclear(driver, Commodity_Input);
		Actionsendkeys(driver, Commodity_Input, Commodity_Input_Txt);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);

			Step_End(5, "Enter the Commodity", test, test1);

			Step_Start(6, "Enter the Equipment type", test, test1);
			waitForElement(driver, Eqp_Type);
			click(driver, Eqp_Type);
			sendKeys(driver, Eqp_Type, Eqp_Type_Input);
			System.out.println("Eqp type:"+Eqp_Type_Input);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);

			Step_End(6, "Enter the Equipment type", test, test1);
			Step_Start(7, "Enter the Quantity", test, test1);
			waitForElement(driver, Eqp_Quantity);
			clear(driver, Eqp_Quantity);
			waitForElement(driver, Eqp_Quantity);
			click(driver, Eqp_Quantity);
			sendKeys(driver, Eqp_Quantity, Eqp_Quantity_Input);
			Step_End(7, "Enter the Quantity", test, test1);

			Step_Start(8, "Enter the Gross Weight", test, test1);
			waitForElement(driver, RR_Gross_Weight);
			click(driver, RR_Gross_Weight);
			Newclear(driver, RR_Gross_Weight);
			Actionsendkeys(driver, RR_Gross_Weight, Gross_Weight_Input);
			Step_End(8, "Enter the Gross Weight", test, test1);

			// CheckBox
			waitForElement(driver, DG_checkbox);
			checkBox(driver, DG_checkbox, DG_checkboxs);
			waitForElement(driver, oog_checkbox);
			checkBox(driver, oog_checkbox, OOG_checkbox);
			waitForElement(driver, nor_checkbox); 
			checkBox(driver, nor_checkbox, NOR_checkbox);
waitForDisplay(driver, flexi_Checkbox_RR);
if(isdisplayed(driver, flexi_Checkbox_RR)) {
	checkBox(driver, flexi_Checkbox_RR, Flexi_CheckBox);
}
waitForDisplay(driver, empty_Checkbox_RR);
if(isdisplayed(driver, empty_Checkbox_RR)) {
	checkBox(driver, empty_Checkbox_RR, MTY_CheckBox);
}
			waitForElement(driver, soc_checkbox); 
			checkBox(driver, soc_checkbox, SOC_checkbox);

			waitForDisplay(driver, flexi_Checkbox_RR);
			if(isdisplayed(driver, flexi_Checkbox_RR)) {
				checkBox(driver, flexi_Checkbox_RR, flexi_checkbox);
			}

			waitForDisplay(driver, empty_Checkbox_RR);
			if(isdisplayed(driver, empty_Checkbox_RR) && isElementAccessible(driver, empty_Checkbox_RR)) {

				System.out.println("Passed || MTY Checkbox enabled after click on SOC checkbox");
				Extent_pass_New(driver, "Passed || MTY Checkbox enabled after click on SOC checkbox", test, test1);

				checkBox(driver, empty_Checkbox_RR, MTY_checkbox);
			}else {
				System.out.println("Failed || MTY Checkbox disabled");
				Extent_fail(driver, "Failed || MTY Checkbox disabled", test, test1);
			}

			if(OOG_checkbox.equalsIgnoreCase("Yes")) {
				waitForElement(driver, OOG_Length_Field);
				clearAndType(driver, OOG_Length_Field,Length_Field_Input );

				waitForElement(driver, OOG_Width_Field);
				clearAndType(driver, OOG_Width_Field, Width_Field_Input);

				waitForElement(driver, OOG_Height_Field);
				clearAndType(driver, OOG_Height_Field,Height_Field_Input );			

				waitForElement(driver, OOG_Ok_Btn);
				click(driver, OOG_Ok_Btn);
			}


			//		//RadioButton
			if(!Pre_Carriage_Radiobtn.equals("")) {
				if(!Pre_Carriage_Radiobtn.equals("")) {
	formatLocatorClick(driver, pre_Carriage_Radiobtn, Pre_Carriage_Radiobtn);
}
			}
			if(!On_Carriage_Radiobtn.equals("")) {

				if(!On_Carriage_Radiobtn.equals("")) {
	formatLocatorClick(driver, on_Carriage_Radiobtn, On_Carriage_Radiobtn);
}
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
				sendKeys(driver, Routing_OriginTF, Origin_Input);
				waitForElement(driver, Routing_service_TF);
				sendKeys(driver, Routing_service_TF, routing_Service);
				waitForElement(driver, select_First_Routing);

				doubleClick(driver, select_First_Routing);

			}else {
				Extent_fail(driver, actRoutingFrame+" is not displayed", test,test1);
				System.out.println(actRoutingFrame+" is not displayed");
			}

			Step_End(10, "Select the routing", test, test1);
										Step_Start(11, "Select the payment mode as Pay At", test, test1);
										rateRequestPaymentMode_Select(driver, paymentMode,Select_type_location, condition, payLocation);
										
			Step_End(12, "search the origin location", test, test1);

			Step_Start(13, "Enter the OFR", test, test1);
			waitForElement(driver, OFR_Txt_Field);
			clear(driver, OFR_Txt_Field);
			sendKeys(driver, OFR_Txt_Field, OFR_Txt_Field_Input);
			System.out.println("OFR Value:"+OFR_Txt_Field_Input);
			Step_End(13, "Enter the OFR", test, test1);

			Step_Start(14, "Click Add", test, test1);
			waitForElement(driver, Rate_AddBtn);
			click(driver, Rate_AddBtn);
			Step_End(14, "Click Add", test, test1);


		Step_Start(15, "Click Save button in the tool bar", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		Step_End(15, "Click Save button in the tool bar", test, test1);

		waitForPopup(driver, Rate_Sub_Popup_Msg, Req_Submit_Popup_Txt);			

		String PopUp_Msg=getText(driver, Rate_Sub_Popup_Msg);                                                                                                            
		if(Req_Submit_Popup_Txt.equals(PopUp_Msg)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Req_Submit_Popup_Txt + " || Actual Report Activity is : " + PopUp_Msg);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + Req_Submit_Popup_Txt + " || Actual Report Activity is : " + PopUp_Msg, test, test1);     
			Step_Start(16, "Click submit", test, test1);
			waitForElement(driver, Rate_SubmitBtn);
			click(driver, Rate_SubmitBtn);
			Step_End(16, "Click submit", test, test1);

			Step_Start(17, "Click Ok", test, test1);
			waitForElement(driver, popup_Message_Yes_Button);
			click(driver, popup_Message_Yes_Button);
			Step_End(17, "Click Ok", test, test1);


		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Req_Submit_Popup_Txt + " || Actual Report Activity is : " + PopUp_Msg);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Req_Submit_Popup_Txt + " || Actual Report Activity is : " + PopUp_Msg, test, test1); 
		} 


		waitForPopup(driver, Popup_Message, Rate_Req_Submitted_Popup_Txt);			
		String PopUp_Msg2=getText(driver, Popup_Message);      
		System.out.println("PopUp_Msg : "+PopUp_Msg2);   
		if(Rate_Req_Submitted_Popup_Txt.equals(PopUp_Msg2)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Rate_Req_Submitted_Popup_Txt + " || Actual Report Activity is : " + PopUp_Msg2);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + Rate_Req_Submitted_Popup_Txt + " || Actual Report Activity is : " + PopUp_Msg2, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Rate_Req_Submitted_Popup_Txt + " || Actual Report Activity is : " + PopUp_Msg2);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Rate_Req_Submitted_Popup_Txt + " || Actual Report Activity is : " + PopUp_Msg2, test,test1); 
		} 

		waitForDisplay(driver, mail_Cancel_Button);
		if(isdisplayed(driver, mail_Cancel_Button)) {
			click(driver, mail_Cancel_Button);
		}

		waitForElement(driver, Req_No_Txt_Field); 
		String Act_ReqNo=getAttribute(driver, Req_No_Txt_Field, "value");                                                                                                            
		if(!Act_ReqNo.equals("")) {                                                                                                                  
			System.out.println("Matched || " + " The Generated Reference Request No is : "+Act_ReqNo);            
			Extent_pass_New(driver, "Matched || " + " The Generated Reference Request No is : "+Act_ReqNo, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || The Reference Request No is Not Generated");        
			Extent_fail(driver, "Not Matched || The Reference Request No is Not Generated", test,test1); 
		} 
		waitForElement(driver, Request_Status); 
		String act_Req_Status1 = getAttribute(driver, Request_Status,"value");
		if(Req_Status_Exp.equals(act_Req_Status1)) {                                                                                                                  
			System.out.println("Matched || " + " Expected Report Activity is : " + Req_Status_Exp + " || Actual Report Activity is : " + act_Req_Status1);            
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + Req_Status_Exp + " || Actual Report Activity is : " + act_Req_Status1, test,test1);     
		}                                                                                                                                                                        
		else {                                                                                                                                                                   
			System.out.println("Not Matched || " + " Expected Report Activity is : " + Req_Status_Exp + " || Actual Report Activity is : " + act_Req_Status1);        
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + Req_Status_Exp + " || Actual Report Activity is : " + act_Req_Status1, test,test1); 
		} 

		//			Reset profile

		ResetProfile(driver);

		//SRR Gate

		moduleNavigate(driver, Module_SRR_Gate);
		//Submitted	


		waitForElement(driver, SRR_Req_Type);
		click(driver, SRR_Req_Type);


		String select_ReqestType=String.format(DropDown_Select, srrRequestType);
		waitForElement(driver, select_ReqestType);
		click(driver, select_ReqestType);

		waitForElement(driver, SRR_Refresh_Btn);
		click(driver, SRR_Refresh_Btn);

		waitForElement(driver, submit_RadioButton);
		click(driver, submit_RadioButton);

		waitForElement(driver, menu_Icon_Grid);
		click(driver, menu_Icon_Grid);

		waitForElement(driver, filter_Icon_Grid);
		click(driver, filter_Icon_Grid);

		waitForElement(driver, filter_Inputfield);
		sendKeys(driver, filter_Inputfield, Act_ReqNo);
		enter(driver);

		waitForElement(driver, select_Actual_ReqNo);
		String submitted_ReqNum1=getText(driver, select_Actual_ReqNo);
		if(submitted_ReqNum1.equals(Act_ReqNo)) {
			System.out.println("Matched || " + " Expected Value is : " + Act_ReqNo + " || Actual Value is : " + submitted_ReqNum1);
			Extent_pass_New(driver,"Matched || " + " Expected Value is : " + Act_ReqNo + " || ActualValue is : " + submitted_ReqNum1,test,test1);
			Extent_pass_New(driver, Act_ReqNo+"  is submitted", test,test1);
			System.out.println(Act_ReqNo+" is submitted");
			waitForElement(driver, select_Actual_ReqNo);
			doubleClick(driver, select_Actual_ReqNo);
		}else {
			System.out.println("Not matched || " + " Expected Value is : " + Act_ReqNo + " || Actual Value  is : " + submitted_ReqNum1);
			Extent_fail(driver,"Not matched || " + " Expected Value is : " + Act_ReqNo + " || Actual Value is : " + submitted_ReqNum1,test,test1);
			Extent_fail(driver, Act_ReqNo+" Error is not displayed", test,test1);
			System.out.println(Act_ReqNo+" is not submitted");
		}	

		//		SRR

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

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
			waitForElement(driver, refresh_contribution_Srr);

			scrollUsingElement(driver, SRR_Approve_Button);
			waitForElement(driver, SRR_Approve_Button);
			click(driver, SRR_Approve_Button);

		}

		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);


		waitForElement(driver, specialRateRequest_Status);
		String actualStatus=getText(driver, specialRateRequest_Status);
		System.out.println("actualStatus : "+actualStatus);

		if(actualStatus.equals(SRR_Status)) {
			System.out.println("Matched || Expected status : "+SRR_Status+" || Actual status : "+actualStatus);
			Extent_pass_New(driver, "Matched || Expected status : "+SRR_Status+" || Actual status : "+actualStatus, test, test1);

		}else {
			System.out.println("Not Matched || Expected status : "+SRR_Status+" || Actual status : "+actualStatus);
			Extent_fail(driver, "Not Matched || Expected status : "+SRR_Status+" || Actual status : "+actualStatus, test, test1);

		}

		List<Map<String, String>> srr_Table_Data = getTableData(driver, specialRateRequest_Table_Headers, specialRateRequest_Table_Rows);

		List<String> actualStatus_Grid_Value = getValuesByHeader(srr_Table_Data, "Status");
		String actualStatus_Grid=actualStatus_Grid_Value.get(0);
		System.out.println("actualStatus_Grid : "+actualStatus_Grid);

		if(actualStatus_Grid.equals(SRR_Grid_Status)) {
			System.out.println("Matched || Expected status in grid  : "+SRR_Grid_Status+" || Actual status in grid : "+actualStatus_Grid);
			Extent_pass_New(driver, "Matched || Expected status in grid  : "+SRR_Grid_Status+" || Actual status in grid : "+actualStatus_Grid, test, test1);

		}else {
			System.out.println("Not Matched || Expected status in grid  : "+SRR_Grid_Status+" || Actual status in grid : "+actualStatus_Grid);
			Extent_fail(driver, "Not Matched || Expected status in grid  : "+SRR_Grid_Status+" || Actual status in grid : "+actualStatus_Grid, test, test1);

		}

		Extent_completed(testcase_Name, test, test1);


	}
}

