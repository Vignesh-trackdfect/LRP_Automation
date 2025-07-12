package LRP_Phase_1A_Comercial_Rate_Request_Scripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Common_Cost_Class;
import commonMethods.Keywords;

public class TC_Rate_Request_SC095 extends Keywords{

	
	public void Rate_Request_SC095(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {
		String testCaseName = "TC_Rate_Request_SC095";

		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String agencyUser = Excel_data.get("agencyUser");
		String rateRequestModule = Excel_data.get("rateRequestModule");
		String tService = Excel_data.get("T_Service");
		String TOS = Excel_data.get("TOS_Option");
		String Cust_code = Excel_data.get("Cust_code");
		String Cust_code2 = Excel_data.get("Cust_code2");
		String Cust_code3 = Excel_data.get("Cust_code3");
		String Condition_Value = Excel_data.get("Condition_Value");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Customer_code_Value2 = Excel_data.get("Customer_code_Value2");
		String Customer_code_Value3 = Excel_data.get("Customer_code_Value3");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String commodity = Excel_data.get("commodity");
		String eqpTypes = Excel_data.get("eqpTypes");
		String DG_eqpTypes = Excel_data.get("DG_eqpTypes");
		String SOC_eqpTypes = Excel_data.get("SOC_eqpTypes");
		String Eqp_Quantity_Input = Excel_data.get("Eqp_Quantity_Input");
		String grossWeight = Excel_data.get("GrossWeight");
		String DG_checkboxs = Excel_data.get("DG_checkboxs");
		String NOR_checkbox = Excel_data.get("NOR_checkbox");
		String SOC_checkbox = Excel_data.get("SOC_checkbox");
		String OOG_checkbox = Excel_data.get("OOG_checkbox");
		String Flexi_CheckBox = Excel_data.get("Flexi_CheckBox");
		String MTY_CheckBox = Excel_data.get("MTY_CheckBox");
		String Pre_Carriage_Radiobtn = Excel_data.get("pre_Carriage_Radiobtn");
		String On_Carriage_Radiobtn = Excel_data.get("On_Carriage_Radiobtn");
		String Routing_Service = Excel_data.get("Routing_Service");
		String oFR = Excel_data.get("oFR");
		String wantToProceedPopup = Excel_data.get("WantToProceedPopup");
		String wantToSavePopup = Excel_data.get("WantToSavePopup");
		String submittedPopup = Excel_data.get("SubmittedPopup");
		String dGDetailsFrame = Excel_data.get("dGDetailsFrame");
		String DG_Columnn_Header = Excel_data.get("DG_Columnn_Header");
		String UN_Number_Column_Header = Excel_data.get("UN_Number_Column_Header");
		String unno = Excel_data.get("unno");
		String dG_Class = Excel_data.get("dG_Class");
		String SRR_Module_Name = Excel_data.get("SRR_Module_Name");
		String GridRequestStatus = Excel_data.get("GridRequestStatus");
		String RequestStatus = Excel_data.get("RequestStatus");
		String SRR_Grid_Status = Excel_data.get("SRR_Grid_Status");
		String SRR_Status = Excel_data.get("SRR_Status");
		String Non_Containerized = Excel_data.get("Non_Containerized");

		
		
		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, username, password);

		SwitchProfile(driver, agencyUser);

		moduleNavigate(driver, rateRequestModule);

		Step_Start(1, "Click on the new button in the toolbar", test, test1);

		waitForElement(driver, Requet_Type);
		newButton(driver);

		Step_End(1, "Click on the new button in the toolbar", test, test1);

		if (Non_Containerized.equals("YES")) {
			waitForElement(driver, non_containradio_btn);
			safeclick(driver, non_containradio_btn);
		}
		if (!tService.equals("")) {
			waitForElement(driver, tService_Dropdown);
			click(driver, tService_Dropdown);
			formatLocatorClick(driver, DropDown_Select, tService);
		}
		if (!TOS.equals("")) {
			waitForElement(driver, RR_TOS_Dropdown);
			click(driver, RR_TOS_Dropdown);
			formatLocatorClick(driver, DropDown_Select, TOS);
		}

		Step_Start(2, "Enter the customer name", test, test1);

		waitForElement(driver, Customer_Name_search_button);
		click(driver, Customer_Name_search_button);

		globalValueSearchWindow(driver, Condition_Value, Cust_code, Customer_code_Value, Cust_code2,
				Customer_code_Value2, Cust_code3, Customer_code_Value3);

		rateRequestCustomerExistOption(driver);

		Step_End(2, "Enter the customer name", test, test1);

		Step_Start(3, "Enter the origin", test, test1);
		waitForElement(driver, Orgin_Input);
		sendKeys(driver, Orgin_Input, origin);
		waitForElement(driver, Auto_Panel_First);
		safeclick(driver, Auto_Panel_First);

		Step_End(3, "Enter the origin", test, test1);

		Step_Start(4, "Enter the Delivery", test, test1);

		waitForElement(driver, Delivery_Input_Field);
		sendKeys(driver, Delivery_Input_Field, delivery);

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
		List<String> EquipTypes = splitAndExpand(eqpTypes, ",");
		for(int i=0;i<EquipTypes.size();i++) {
		waitForElement(driver, Eqp_Type);
		click(driver, Eqp_Type);
		clear(driver,Eqp_Type);
		sendKeys(driver, Eqp_Type, EquipTypes.get(i));
		
		waitForElement(driver, Auto_Panel_First);
		safeclick(driver, Auto_Panel_First);
		Step_End(6, "Enter the Equipment type.", test, test1);

		Step_Start(7, " Enter the Quantity", test, test1);

		waitForElement(driver, Eqp_Quantity);
		click(driver, Eqp_Quantity);
		Newclear(driver, Eqp_Quantity);
		Actionsendkeys(driver, Eqp_Quantity, Eqp_Quantity_Input);
		

		Step_End(7, " Enter the Quantity", test, test1);

		Step_Start(8, "Enter the Gross Weight", test, test1);

		waitForElement(driver, RR_Gross_Weight);
		Newclear(driver, RR_Gross_Weight);
		Actionsendkeys(driver, RR_Gross_Weight, grossWeight);

		Step_End(8, "Enter the Gross Weight", test, test1);
		checkBox(driver, oog_checkbox, OOG_checkbox);

		checkBox(driver, nor_checkbox, NOR_checkbox);
		waitForDisplay(driver, flexi_Checkbox_RR);
		if (isdisplayed(driver, flexi_Checkbox_RR)) {
			checkBox(driver, flexi_Checkbox_RR, Flexi_CheckBox);
		}
		waitForDisplay(driver, empty_Checkbox_RR);
		if (isdisplayed(driver, empty_Checkbox_RR)) {
			checkBox(driver, empty_Checkbox_RR, MTY_CheckBox);
		}

		// Pre Carriage radio btn
				if (!Pre_Carriage_Radiobtn.equals("")) {
					formatLocatorClick(driver, pre_Carriage_Radiobtn, Pre_Carriage_Radiobtn);
				}
				if (!On_Carriage_Radiobtn.equals("")) {
					formatLocatorClick(driver, on_Carriage_Radiobtn, On_Carriage_Radiobtn);
				}

				Step_Start(9, "Click routing", test, test1);

				waitForElement(driver, Routing_Button);
				click(driver, Routing_Button);

				Step_End(9, "Click routing", test, test1);

				Step_Start(10, "Select the routing", test, test1);

				waitForElement(driver, routingSearch_Frame);
				String actRoutingFrame = getText(driver, routingSearch_Frame);
				if (isDisplayed(driver, routingSearch_Frame)) {
					Extent_pass_New(driver, actRoutingFrame + " is displayed", test, test1);
					System.out.println(actRoutingFrame + " is displayed");
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

				} else {
					System.out.println(actRoutingFrame + " is not displayed");

					Extent_fail(driver, actRoutingFrame + " is not displayed", test, test1);
				}
				Step_End(10, "Select the routing", test, test1);

				Step_Start(11, "Enter the OFR", test, test1);

				waitForElement(driver, OFR_Txt_Field);
				safeclick(driver, OFR_Txt_Field);
				sendKeys(driver, OFR_Txt_Field, oFR);

				Step_End(11, "Enter the OFR", test, test1);

				Step_Start(12, "Click Add", test, test1);
				waitForElement(driver, Rate_AddBtn);
				click(driver, Rate_AddBtn);

				Step_End(12, "Click Add", test, test1);
		}
		
		waitForElement(driver, soc_checkbox);
		checkBox(driver, soc_checkbox, SOC_checkbox);

		List<String> SOC_EquipTypes = splitAndExpand(SOC_eqpTypes, ",");
		for(int i=0;i<SOC_EquipTypes.size();i++) {
		waitForElement(driver, Eqp_Type);
		click(driver, Eqp_Type);
		clear(driver,Eqp_Type);
		sendKeys(driver, Eqp_Type, SOC_EquipTypes.get(i));
		waitForElement(driver, Auto_Panel_First);
		safeclick(driver, Auto_Panel_First);


		waitForElement(driver, Eqp_Quantity);
		click(driver, Eqp_Quantity);
		Newclear(driver, Eqp_Quantity);
		Actionsendkeys(driver, Eqp_Quantity, Eqp_Quantity_Input);
		



		waitForElement(driver, RR_Gross_Weight);
		Newclear(driver, RR_Gross_Weight);
		Actionsendkeys(driver, RR_Gross_Weight, grossWeight);

				if (!Pre_Carriage_Radiobtn.equals("")) {
					formatLocatorClick(driver, pre_Carriage_Radiobtn, Pre_Carriage_Radiobtn);
				}
				if (!On_Carriage_Radiobtn.equals("")) {
					formatLocatorClick(driver, on_Carriage_Radiobtn, On_Carriage_Radiobtn);
				}
				checkBox(driver, oog_checkbox, OOG_checkbox);

				checkBox(driver, nor_checkbox, NOR_checkbox);
				waitForDisplay(driver, flexi_Checkbox_RR);
				if (isdisplayed(driver, flexi_Checkbox_RR)) {
					checkBox(driver, flexi_Checkbox_RR, Flexi_CheckBox);
				}
				waitForDisplay(driver, empty_Checkbox_RR);
				if (isdisplayed(driver, empty_Checkbox_RR)) {
					checkBox(driver, empty_Checkbox_RR, MTY_CheckBox);
				}

				checkBox(driver, soc_checkbox, SOC_checkbox);
				Step_Start(9, "Click routing", test, test1);

				waitForElement(driver, Routing_Button);
				click(driver, Routing_Button);

				Step_End(9, "Click routing", test, test1);

				Step_Start(10, "Select the routing", test, test1);

				waitForElement(driver, routingSearch_Frame);
				String actRoutingFrame = getText(driver, routingSearch_Frame);
				if (isDisplayed(driver, routingSearch_Frame)) {
					Extent_pass_New(driver, actRoutingFrame + " is displayed", test, test1);
					System.out.println(actRoutingFrame + " is displayed");
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

				} else {
					System.out.println(actRoutingFrame + " is not displayed");

					Extent_fail(driver, actRoutingFrame + " is not displayed", test, test1);
				}
				Step_End(10, "Select the routing", test, test1);

				Step_Start(11, "Enter the OFR", test, test1);

				waitForElement(driver, OFR_Txt_Field);
				safeclick(driver, OFR_Txt_Field);
				sendKeys(driver, OFR_Txt_Field, oFR);

				Step_End(11, "Enter the OFR", test, test1);

				Step_Start(12, "Click Add", test, test1);
				waitForElement(driver, Rate_AddBtn);
				click(driver, Rate_AddBtn);

				Step_End(12, "Click Add", test, test1);
		}
		
		
		List<String> DG_EquipTypes = splitAndExpand(DG_eqpTypes, ",");
		for(int i=0;i<DG_EquipTypes.size();i++) {
		waitForElement(driver, Eqp_Type);
		click(driver, Eqp_Type);
		clear(driver,Eqp_Type);
		sendKeys(driver, Eqp_Type, DG_EquipTypes.get(i));
		
		waitForElement(driver, Auto_Panel_First);
		safeclick(driver, Auto_Panel_First);


		waitForElement(driver, Eqp_Quantity);
		click(driver, Eqp_Quantity);
		Newclear(driver, Eqp_Quantity);
		Actionsendkeys(driver, Eqp_Quantity, Eqp_Quantity_Input);
		



		waitForElement(driver, RR_Gross_Weight);
		Newclear(driver, RR_Gross_Weight);
		Actionsendkeys(driver, RR_Gross_Weight, grossWeight);
		

		checkBox(driver, DG_checkbox, DG_checkboxs);
		waitForElement(driver, dgDetails_Frame);
		String actDGDetailsFrame=getText(driver, dgDetails_Frame);
		if(actDGDetailsFrame.equals(dGDetailsFrame)) {
			Extent_pass_New(driver,"Matched || Expected : "+dGDetailsFrame+" Actual : "+ actDGDetailsFrame, test,test1);
			System.out.println("Matched || Expected : "+dGDetailsFrame+" Actual : "+ actDGDetailsFrame);
			Extent_pass_New(driver, dGDetailsFrame+" is displayed", test,test1);
			System.out.println(dGDetailsFrame+" is displayed");

			waitForElement(driver, class_Search_Button);
			click(driver, class_Search_Button);

			twoColumnSearchWindow(driver, DG_Columnn_Header, Condition_Value, dG_Class);
			
			waitForElement(driver, RR_UNNO_Search);
			click(driver, RR_UNNO_Search);
			twoColumnSearchWindow(driver, UN_Number_Column_Header, Condition_Value, unno);
			
			waitForElement(driver, RR_plus_Button);
			click(driver, RR_plus_Button);
		}else {
			System.out.println("Not Matched || Expected : "+dGDetailsFrame+" Actual : "+ actDGDetailsFrame);
			Extent_fail(driver,"Not Matched || Expected : "+dGDetailsFrame+" Actual : "+ actDGDetailsFrame, test,test1);
		}

		waitForElement(driver, ok_Button_DG_Details);
		click(driver, ok_Button_DG_Details);
		checkBox(driver, oog_checkbox, OOG_checkbox);

		checkBox(driver, nor_checkbox, NOR_checkbox);
		waitForDisplay(driver, flexi_Checkbox_RR);
		if (isdisplayed(driver, flexi_Checkbox_RR)) {
			checkBox(driver, flexi_Checkbox_RR, Flexi_CheckBox);
		}
		waitForDisplay(driver, empty_Checkbox_RR);
		if (isdisplayed(driver, empty_Checkbox_RR)) {
			checkBox(driver, empty_Checkbox_RR, MTY_CheckBox);
		}

				if (!Pre_Carriage_Radiobtn.equals("")) {
					formatLocatorClick(driver, pre_Carriage_Radiobtn, Pre_Carriage_Radiobtn);
				}
				if (!On_Carriage_Radiobtn.equals("")) {
					formatLocatorClick(driver, on_Carriage_Radiobtn, On_Carriage_Radiobtn);
				}

				waitForElement(driver, Routing_Button);
				click(driver, Routing_Button);
				
				waitForElement(driver, routingSearch_Frame);
				String actRoutingFrame = getText(driver, routingSearch_Frame);
				if (isDisplayed(driver, routingSearch_Frame)) {
					Extent_pass_New(driver, actRoutingFrame + " is displayed", test, test1);
					System.out.println(actRoutingFrame + " is displayed");
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

				} else {
					System.out.println(actRoutingFrame + " is not displayed");

					Extent_fail(driver, actRoutingFrame + " is not displayed", test, test1);
				}


				waitForElement(driver, OFR_Txt_Field);
				safeclick(driver, OFR_Txt_Field);
				sendKeys(driver, OFR_Txt_Field, oFR);


				waitForElement(driver, Rate_AddBtn);
				click(driver, Rate_AddBtn);

		}
		
		Step_Start(13, "Click Save button in the tool bar", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);

		Step_End(13, "Click Save button in the tool bar", test, test1);

		waitForPopup(driver, Rate_Sub_Popup_Msg, wantToSavePopup);

		String actSubmitPopup=getText(driver, Rate_Sub_Popup_Msg);
		if(actSubmitPopup.equals(wantToSavePopup)) {
			Extent_pass_New(driver,"Matched || Expected : popup message should be shown as : "+wantToSavePopup+" || Actual : popup message is shown as : "+ actSubmitPopup, test,test1);
			System.out.println("Matched || Expected : popup message should be shown as :  "+wantToSavePopup+" || Actual : popup message is shown as : "+ actSubmitPopup);
			Extent_pass_New(driver, wantToSavePopup+" is displayed", test,test1);
			System.out.println(wantToSavePopup+" is displayed");

		}else {
			System.out.println("Not Matched || Expected : popup message should be shown as :  "+wantToSavePopup+" || Actual : popup message is shown as : "+ actSubmitPopup);

			Extent_fail(driver,"Not Matched || Expected : popup message should be shown as : "+wantToSavePopup+" || Actual : popup message is shown as : "+ actSubmitPopup, test,test1);
		}
		
		Step_Start(14, "Click submit", test, test1);

		waitForElement(driver, Rate_SubmitBtn);
		click(driver, Rate_SubmitBtn);
		Step_End(14, "Click submit", test, test1);

		waitForPopup(driver, popup_Message, wantToProceedPopup);

		String actualPopup=getText(driver, popup_Message);
		if(actualPopup.equals(wantToProceedPopup)) {
			Extent_pass_New(driver,"Matched || Expected : popup message should be shown as :  "+wantToProceedPopup+" || Actual : popup message is shown as : "+ actualPopup, test,test1);
			System.out.println("Matched || Expected : popup message should be shown as :  "+wantToProceedPopup+" || Actual : popup message is shown as : "+ actualPopup);
			Extent_pass_New(driver, wantToProceedPopup+" popup is displayed", test,test1);
			System.out.println(wantToProceedPopup+" popup is displayed");


		}else {
			System.out.println("Not Matched || Expected : popup message should be shown as :  "+wantToProceedPopup+" || Actual : popup message is shown as : "+ actualPopup);

			Extent_fail(driver,"Not Matched || Expected : popup message should be shown as : "+wantToProceedPopup+" || Actual : popup message is shown as : "+ actualPopup, test,test1);
		}
		
		Step_Start(14, "Click Ok", test, test1);

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);
		Step_End(14, "Click Ok", test, test1);


		waitForPopup(driver, Popup_Message, submittedPopup);
		String actSubmittedPopup=getText(driver,Popup_Message);
		System.out.println("Submitted Popup: "+actSubmittedPopup);

		if(actSubmittedPopup.equals(submittedPopup)) {
			Extent_pass_New(driver,"Matched || Expected : popup message should be shown as :  "+submittedPopup+" || Actual : popup message is shown as : "+ actSubmittedPopup, test,test1);
			System.out.println("Matched || Expected : popup message should be shown as : "+submittedPopup+" || Actual : popup message is shown as : "+ actSubmittedPopup);
			Extent_pass_New(driver, submittedPopup+" popup is displayed", test,test1);
			System.out.println(submittedPopup+" popup is displayed");

		}else {
			System.out.println("Not Matched || Expected : popup message should be shown as : "+submittedPopup+" || Actual : popup message is shown as : "+ actSubmittedPopup);
			System.out.println(submittedPopup+ " popup is not displayed");
			Extent_fail(driver,"Not Matched || Expected : popup message should be shown as : "+submittedPopup+" || Actual : popup message is shown as : "+ actSubmittedPopup, test,test1);

		}
		waitForDisplay(driver, Mail_Cancel_button);
		if(isdisplayed(driver, Mail_Cancel_button)) {
		click(driver, Mail_Cancel_button);
		}
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
			if (actGridRequestStatus.equals(GridRequestStatus)) {
			System.out.println("Matched || " + " Expected Report Activity is : " + GridRequestStatus+ " || Actual Report Activity is : " + actGridRequestStatus);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + GridRequestStatus+ " || Actual Report Activity is : " + actGridRequestStatus, test,test1);
		} else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + GridRequestStatus+ " || Actual Report Activity is : " + actGridRequestStatus);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + GridRequestStatus+ " || Actual Report Activity is : " + actGridRequestStatus, test,test1);
		}
		waitForElement(driver, Request_Status);
		String actRequestStatus = getAttribute(driver, Request_Status, "value");
		if (actRequestStatus.equals(RequestStatus)) {
			System.out.println("Matched || " + " Expected Report Activity is : " + RequestStatus+ " || Actual Report Activity is : " + actRequestStatus);
			Extent_pass_New(driver, "Matched || " + " Expected Report Activity is : " + RequestStatus+ " || Actual Report Activity is : " + actRequestStatus, test,test1);
		} else {
			System.out.println("Not Matched || " + " Expected Report Activity is : " + RequestStatus+ " || Actual Report Activity is : " + actRequestStatus);
			Extent_fail(driver, "Not Matched || " + " Expected Report Activity is : " + RequestStatus+ " || Actual Report Activity is : " + actRequestStatus, test,test1);
		}
		ResetProfile(driver);
		moduleNavigate(driver, SRR_Module_Name);

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
		
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);
		
		waitForElement(driver, SRR_Port_Pair_Details_Rows);
		List<WebElement> total_Rows = listOfElements(driver, SRR_Port_Pair_Details_Rows);
		for(int i = 1;i<=total_Rows.size();i++) {
			scrollTop(driver);
			String row = String.format(SRR_Port_Pair_Details_Row, i);
			waitForElement(driver, row);
			click(driver, row);
			waitForElement(driver, refresh_contribution_Srr);
			if(isElementEnabled(driver, SRR_Approve_Button)) {
				click(driver, refresh_contribution_Srr);
			}
			waitForElement(driver, Special_RR_Row);
			click(driver, Special_RR_Row);
			scrollBottom(driver);
			waitForElement(driver, SRR_Approve_Button);
			if(isElementEnabled(driver, SRR_Approve_Button)) {
				click(driver, SRR_Approve_Button);
			}else {
				scrollTop(driver);
				waitForElement(driver, SRR_Contribution);
				click(driver, SRR_Contribution);
				String missingCost = getText(driver, SRR_Missing_Cost_Value);
				waitForElement(driver, Srr_missing_cost_exit_button);
				click(driver, Srr_missing_cost_exit_button);
				scrollTop(driver);
				Common_Cost_Class cost =new Common_Cost_Class();
				cost.parseEquipmentData(driver, missingCost, test, test1, selected_dataset);
				waitForElement(driver, Special_Rate_Request_Module);
				click(driver, Special_Rate_Request_Module);
				waitForElement(driver, refresh_contribution_Srr);
				click(driver, refresh_contribution_Srr);
				scrollBottom(driver);
				waitForElement(driver, SRR_Approve_Button);
				click(driver, SRR_Approve_Button);
			}
		}
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);
		String actualStatus_Grid=getText(driver,Filed_val );

		if(SRR_Status.equals(actualStatus_Grid)) {
			Extent_pass_New(driver,"Matched || Expected Result is : After click on save button The Status should be : "+SRR_Grid_Status+" || Actual Result is : : click on save button The Status is : "+ actualStatus_Grid, test,test1);
			System.out.println("Matched || Expected Result is : After click on save button The Status should be : "+SRR_Grid_Status+" || Actual Result is : : click on save button The Status is : "+ actualStatus_Grid);
		}else {
			System.out.println("Not Matched || Expected Result is : After click on save button The Status should be : "+SRR_Grid_Status+" || Actual Result is : : click on save button The Status is : "+ actualStatus_Grid);
			Extent_fail(driver,"Not Matched || Expected Result is : After click on save button The Status should be : "+SRR_Grid_Status+" || Actual Result is : : click on save button The Status is : "+ actualStatus_Grid, test,test1);
		}

	
		
		Extent_completed(testCaseName, test, test1);

	}
	

}
