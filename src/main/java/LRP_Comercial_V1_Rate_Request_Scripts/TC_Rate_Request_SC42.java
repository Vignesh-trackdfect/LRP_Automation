package LRP_Comercial_V1_Rate_Request_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Common_Cost_Class;
import commonMethods.Keywords;



public class TC_Rate_Request_SC42 extends Keywords{

	public void Rate_Request_SC42(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url){

		String testcase_Name="TC_Rate_Request_SC42";
		
		
		


		
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
		String Customer_code_Value2 = Excel_data.get("Customer_code_Value2");
		String Customer_code_Value3 = Excel_data.get("Customer_code_Value3");
		String Cust_code2 = Excel_data.get("Cust_code2");
		String Cust_code3 = Excel_data.get("Cust_code3");
		String date_Perform = Excel_data.get("date_Perform");
		String Flexi_CheckBox = Excel_data.get("Flexi_CheckBox");
		String MTY_CheckBox = Excel_data.get("MTY_CheckBox");
		String payment_Mode = Excel_data.get("payment_Mode");
		String Select_type_location = Excel_data.get("Select_type_location");
		String condition = Excel_data.get("condition");
		String payLocation =Excel_data.get("payLocation");
		

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
		Step_Start(2, "Select the special rate request type.", test, test1);

		waitForElement(driver, Requet_Type);
click(driver,Requet_Type);
formatLocatorClick(driver, RequestType, Request_Input);

		Step_End(2, "Select the special rate request type.", test, test1);

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

		Step_Start(3, "Enter the customer name", test, test1);


		waitForElement(driver, Customer_Name_search_button);
		click(driver, Customer_Name_search_button);

		globalValueSearchWindow(driver, condition_Option, customerCode_Option, customerCode, Cust_code2, Customer_code_Value2,Cust_code3, Customer_code_Value3);

			rateRequestCustomerExistOption(driver);







			Step_End(3, "Enter the customer name", test, test1);

			Step_Start(4, "Enter the origin", test, test1);
			waitForElement(driver, Orgin_Input);
			sendKeys(driver, Orgin_Input, Origin_Input);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);
			Step_End(4, "Enter the origin", test, test1);

			Step_Start(5, "Enter the Delivery", test, test1);
			waitForElement(driver, RR_Delivery_Input_Field);
			sendKeys(driver, RR_Delivery_Input_Field,delivery );
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);

			Step_End(5, "Enter the Delivery", test, test1);
			rateRequestDateSelect(driver, date_Perform, datePicker, From_Date_Input, To_Date_Input);


			click(driver, service_Textfield);
			clearAndType(driver, service_Textfield, service);

			Step_Start(6, "Enter the Commodity", test, test1);
			waitForElement(driver, Commodity_Input);
			Newclear(driver, Commodity_Input);
		Actionsendkeys(driver, Commodity_Input, Commodity_Input_Txt);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);

			Step_End(6, "Enter the Commodity", test, test1);

			Step_Start(7, "Enter the Equipment type", test, test1);
			waitForElement(driver, Eqp_Type);
			click(driver, Eqp_Type);
			sendKeys(driver, Eqp_Type, Eqp_Type_Input);
			System.out.println("Eqp type:"+Eqp_Type_Input);
			waitForElement(driver, Auto_Panel_First);
			click(driver, Auto_Panel_First);

			Step_End(7, "Enter the Equipment type", test, test1);
			Step_Start(8, "Enter the Quantity", test, test1);
			waitForElement(driver, Eqp_Quantity);
			clear(driver, Eqp_Quantity);
			waitForElement(driver, Eqp_Quantity);
			click(driver, Eqp_Quantity);
			sendKeys(driver, Eqp_Quantity, Eqp_Quantity_Input);
			Step_End(8, "Enter the Quantity", test, test1);

			Step_Start(9, "Enter the Gross Weight", test, test1);
			waitForElement(driver, RR_Gross_Weight);
			click(driver, RR_Gross_Weight);
			Newclear(driver, RR_Gross_Weight);
			Actionsendkeys(driver, RR_Gross_Weight, Gross_Weight_Input);
			Step_End(9, "Enter the Gross Weight", test, test1);

			Step_Start(10, "Click on the OOG check box", test, test1);
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

			Step_End(10, "Click on the OOG check box", test, test1);

			if(OOG_checkbox.equalsIgnoreCase("Yes")) {

				Step_Start(11, "Enter the Dimension details", test, test1);

				waitForElement(driver, OOG_Length_Field);
				clearAndType(driver, OOG_Length_Field,Length_Field_Input );

				waitForElement(driver, OOG_Width_Field);
				clearAndType(driver, OOG_Width_Field, Width_Field_Input);

				waitForElement(driver, OOG_Height_Field);
				clearAndType(driver, OOG_Height_Field,Height_Field_Input );			

				Step_End(11, "Enter the Dimension details", test, test1);
				Step_Start(12, "Click Ok", test, test1);

				waitForElement(driver, OOG_Ok_Btn);
				click(driver, OOG_Ok_Btn);

				Step_End(12, "Click Ok", test, test1);

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

			Step_Start(13, "Click routing", test, test1);
			waitForElement(driver, Routing_Button);
			click(driver, Routing_Button);
			Step_End(13, "Click routing", test, test1);

			Step_Start(14, "Select the routing", test, test1);

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

			Step_End(14, "Select the routing", test, test1);
										rateRequestPaymentMode_Select(driver, payment_Mode,Select_type_location, condition, payLocation);
										Step_Start(15, "Enter the OFR", test, test1);
			waitForElement(driver, OFR_Txt_Field);
			clear(driver, OFR_Txt_Field);
			sendKeys(driver, OFR_Txt_Field, OFR_Txt_Field_Input);
			System.out.println("OFR Value:"+OFR_Txt_Field_Input);
			Step_End(15, "Enter the OFR", test, test1);

			Step_Start(16, "Click Add", test, test1);
			waitForElement(driver, Rate_AddBtn);
			click(driver, Rate_AddBtn);
			Step_End(16, "Click Add", test, test1);



			Step_Start(17, "Click Save button in the tool bar", test, test1);
			waitForElement(driver, SaveButton_ToolBar);
			click(driver, SaveButton_ToolBar);
			Step_End(17, "Click Save button in the tool bar", test, test1);

			waitForElement(driver, Rate_Sub_Popup_Msg);                                                                                                                                
			String PopUp_Msg=getText(driver, Rate_Sub_Popup_Msg);                                                                                                            
			if(Req_Submit_Popup_Txt.equals(PopUp_Msg)) {                                                                                                                  
				System.out.println("Matched || " + "Expected : popup message should be shown as : " + Req_Submit_Popup_Txt + " || Actual : popup message is shown as : " + PopUp_Msg);            
				Extent_pass_New(driver, "Matched || " + "Expected : popup message should be shown as : " + Req_Submit_Popup_Txt + " || Actual : popup message is shown as : " + PopUp_Msg, test, test1);     
				Step_Start(18, "Click submit", test, test1);
				waitForElement(driver, Rate_SubmitBtn);
				click(driver, Rate_SubmitBtn);
				Step_End(18, "Click submit", test, test1);

				Step_Start(19, "Click Ok", test, test1);
				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);
				Step_End(19, "Click Ok", test, test1);


			}                                                                                                                                                                        
			else {                                                                                                                                                                   
				System.out.println("Not Matched || " + "Expected : popup message should be shown as : " + Req_Submit_Popup_Txt + " || Actual : popup message is shown as : " + PopUp_Msg);        
				Extent_fail(driver, "Not Matched || " + "Expected : popup message should be shown as : " + Req_Submit_Popup_Txt + " || Actual : popup message is shown as : " + PopUp_Msg, test, test1); 
			} 


			waitForDisplay(driver, Popup_Message); 
			if(isdisplayed(driver, Popup_Message)) {
				String PopUp_Msg2=getText(driver, Popup_Message);      
				System.out.println("PopUp_Msg : "+PopUp_Msg2);   
				if(Rate_Req_Submitted_Popup_Txt.equals(PopUp_Msg2)) {                                                                                                                  
					System.out.println("Matched || " + "Expected : popup message should be shown as : " + Rate_Req_Submitted_Popup_Txt + " || Actual : popup message is shown as : " + PopUp_Msg2);            
					Extent_pass_New(driver, "Matched || " + "Expected : popup message should be shown as : " + Rate_Req_Submitted_Popup_Txt + " || Actual : popup message is shown as : " + PopUp_Msg2, test,test1);     
				}                                                                                                                                                                        
				else {                                                                                                                                                                   
					System.out.println("Not Matched || " + "Expected : popup message should be shown as : " + Rate_Req_Submitted_Popup_Txt + " || Actual : popup message is shown as : " + PopUp_Msg2);        
					Extent_fail(driver, "Not Matched || " + "Expected : popup message should be shown as : " + Rate_Req_Submitted_Popup_Txt + " || Actual : popup message is shown as : " + PopUp_Msg2, test,test1); 
				} 
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

			Step_Start(20, "Switch to line profile and navigate to the special rate request screen using SRR gate screen under Submit node", test, test1);


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
			Step_End(20, "Switch to line profile and navigate to the special rate request screen using SRR gate screen under Submit node", test, test1);
			Step_Start(21, "Click edit", test, test1);

			waitForElement(driver, Edit_Button_toolBar);
			click(driver, Edit_Button_toolBar);

			Step_End(21, "Click edit", test, test1);
			Step_Start(22, ".Click Approve button", test, test1);

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
			Step_End(22, ".Click Approve button", test, test1);
			Step_Start(23, "click save.", test, test1);

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

			Step_End(23, "click save.", test, test1);

			Extent_completed(testcase_Name, test, test1);


	}
}

