package LRP_Phase_1A_Comercial_Rate_Request_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Rate_Request_SC100 extends Keywords{
	public void Rate_Request_SC100(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) {

		String testcase_Name = "TC_Rate_Request_SC100";
		
		String username = Excel_data.get("username");
		String password = Excel_data.get("password");
		String Non_Containerized = Excel_data.get("Non_Containerized");
		String Eqp_Quantity_Input = Excel_data.get("Eqp_Quantity_Input");
		String Exp_Det_Days_Input = Excel_data.get("Exp_Det_Days_Input");
		String Imp_Det_Days_Input = Excel_data.get("Imp_Det_Days_Input");
		String Exp_Demmurage_Input = Excel_data.get("Exp_Demmurage_Input");
		String Imp_Demmurage_Input = Excel_data.get("Imp_Demmurage_Input");
		String DG_checkboxs = Excel_data.get("DG_checkboxs");
		String NOR_checkbox = Excel_data.get("NOR_checkbox");
		String SOC_checkbox = Excel_data.get("SOC_checkbox");
		String OOG_checkbox = Excel_data.get("OOG_checkbox");
		String From_Date_Input = Excel_data.get("From_Date_Input");
		String To_Date_Input = Excel_data.get("To_Date_Input");
		String rateRequestModule = Excel_data.get("rateRequestModule");
		String date_Picker = Excel_data.get("date_Picker");
		String agencyUser = Excel_data.get("agencyUser");
		String origin = Excel_data.get("origin");
		String delivery = Excel_data.get("delivery");
		String commodity = Excel_data.get("commodity");
		String submittedPopup = Excel_data.get("SubmittedPopup");
		String wantToProceedPopup = Excel_data.get("WantToProceedPopup");
		String wantToSavePopup = Excel_data.get("WantToSavePopup");
		String oFR = Excel_data.get("oFR");
		String eqpType = Excel_data.get("eqpType");
		String grossWeight = Excel_data.get("GrossWeight");
		String Routing_Service = Excel_data.get("Routing_Service");
		String Cust_code = Excel_data.get("Cust_code");
		String Condition_Value = Excel_data.get("Condition_Value");
		String Customer_code_Value = Excel_data.get("Customer_code_Value");
		String Pre_Carriage_Radiobtn = Excel_data.get("pre_Carriage_Radiobtn");
		String On_Carriage_Radiobtn = Excel_data.get("On_Carriage_Radiobtn");
		String tService = Excel_data.get("T_Service");
		String TOS = Excel_data.get("TOS_Option");
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
		String payLocation = Excel_data.get("payLocation");
		String Exp_Imp_Detention_Days_Input = Excel_data.get("Exp_Imp_Detention_Days_Input");
		String Exp_Exp_Detention_Days_Input = Excel_data.get("Exp_Exp_Detention_Days_Input");
		String Exp_Imp_Demurrage_Days_Input = Excel_data.get("Exp_Imp_Demurrage_Days_Input");
		String Exp_Exp_Demurrage_Days_Input = Excel_data.get("Exp_Exp_Demurrage_Days_Input");
		String Exp_Imp_Detention_Days_Input_Dropdown = Excel_data.get("Exp_Imp_Detention_Days_Input_Dropdown");
		String Exp_Exp_Detention_Days_Input_Dropdown = Excel_data.get("Exp_Exp_Detention_Days_Input_Dropdown");
		String Exp_Imp_Demurrage_Days_Input_Dropdown = Excel_data.get("Exp_Imp_Demurrage_Days_Input_Dropdown");
		String Exp_Exp_Demurrage_Days_Input_Dropdown = Excel_data.get("Exp_Exp_Demurrage_Days_Input_Dropdown");
		
		Extent_Start(testcase_Name, test, test1);

		navigateUrl(driver, url);
		// Login
		LRP_Login(driver, username, password);

		// Switch User
		SwitchProfile(driver, agencyUser);

		moduleNavigate(driver, rateRequestModule);

		// Rate Request
		Step_Start(1, "Click on the new button in the toolbar", test, test1);
		waitForElement(driver, Requet_Type);
		newButton(driver);

		Step_End(1, "Click on the new button in the toolbar", test, test1);

		
		if (Non_Containerized.equals("YES")) {
			waitForElement(driver, non_containradio_btn);
			safeclick(driver, non_containradio_btn);
		}
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
		
		Step_Start(2, " Enter the customer name", test, test1);

		rateRequestDateSelect(driver, date_Perform, date_Picker, From_Date_Input, To_Date_Input);

		waitForElement(driver, Customer_Name_search_button);
		click(driver, Customer_Name_search_button);

		globalValueSearchWindow(driver, Condition_Value, Cust_code, Customer_code_Value, Cust_code2,
				Customer_code_Value2, Cust_code3, Customer_code_Value3);

		rateRequestCustomerExistOption(driver);

		Step_End(2, " Enter the customer name", test, test1);

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
		
		rateRequestRoutingDays(driver, Exp_Det_Days_Input, Imp_Det_Days_Input, Exp_Demmurage_Input, Imp_Demmurage_Input);
		rateRequestPaymentMode_Select(driver, payment_Mode,Select_type_location, condition, payLocation);
		
		Step_Start(11, "Enter the import detention", test, test1);

		
		waitForElement(driver, RR_Imp_Detention_Days);
		clear(driver,RR_Imp_Detention_Days);
		sendKeys(driver,RR_Imp_Detention_Days,Exp_Imp_Detention_Days_Input);
		
		Step_End(11, "Enter the import detention", test, test1);
		
		Step_Start(12, "Enter the import demmurage", test, test1);

		waitForElement(driver, RR_Imp_Demurrage);
		clear(driver,RR_Imp_Demurrage);
		sendKeys(driver,RR_Imp_Demurrage,Exp_Imp_Demurrage_Days_Input);
	
	    Step_End(12, "Enter the import demmurage", test, test1);
	    
	    
	    Step_Start(13, "Enter the Export detention", test, test1);
	    
	    waitForElement(driver, RR_Exp_Demurrage);
		clear(driver,RR_Exp_Demurrage);
		sendKeys(driver,RR_Exp_Demurrage,Exp_Exp_Demurrage_Days_Input);
	    
	
		
		Step_Start(14, "Enter the Export demmurage", test, test1);
		
		waitForElement(driver, RR_Exp_Detention_Days);
		clear(driver,RR_Exp_Detention_Days);
		sendKeys(driver,RR_Exp_Detention_Days,Exp_Exp_Detention_Days_Input);
		
		Step_End(14, "Enter the Export demmurage", test, test1);
		
		
		Step_Start(15, "Enter the import detention status.", test, test1);

		waitForElement(driver, RR_Imp_Detention_Dropdown);
		click(driver, RR_Imp_Detention_Dropdown);
		formatLocatorClick(driver, DropDown_Select, Exp_Imp_Detention_Days_Input_Dropdown);
		
		Step_End(15, "Enter the import detention status.", test, test1);
		
		Step_Start(16, "Enter the import demmurage status.", test, test1);
		
		waitForElement(driver, RR_Imp_Demurrage_Dropdown);
		click(driver, RR_Imp_Demurrage_Dropdown);
		formatLocatorClick(driver, DropDown_Select, Exp_Imp_Demurrage_Days_Input_Dropdown);

		Step_End(16, "Enter the import demmurage status.", test, test1);	
		
		Step_Start(17, "Enter the Export detention status", test, test1);
		
		waitForElement(driver, RR_Exp_Detention_Dropdown);
		click(driver, RR_Exp_Detention_Dropdown);
		formatLocatorClick(driver, DropDown_Select, Exp_Exp_Detention_Days_Input_Dropdown);
		
		Step_End(17, "Enter the Export detention status", test, test1);
		
		Step_Start(18, "Enter the Export demmurage status", test, test1);

		waitForElement(driver, RR_Exp_Demurrage_Dropdown);
		click(driver, RR_Exp_Demurrage_Dropdown);
		formatLocatorClick(driver, DropDown_Select, Exp_Exp_Demurrage_Days_Input_Dropdown);
		
		Step_End(18, "Enter the Export demmurage status", test, test1);
		
		Step_Start(19, "Enter the OFR", test, test1);
		waitForElement(driver, OFR_Txt_Field);
		safeclick(driver, OFR_Txt_Field);
		sendKeys(driver, OFR_Txt_Field, oFR);

		Step_End(19, "Enter the OFR", test, test1);

		Step_Start(20, "Click Add", test, test1);
		waitForElement(driver, Rate_AddBtn);
		click(driver, Rate_AddBtn);

		Step_End(20, "Click Add", test, test1); 
		Step_Start(21, "Click Save button in the tool bar", test, test1);
		waitForElement(driver, SaveButton_ToolBar);
		click(driver, SaveButton_ToolBar);


		waitForPopup(driver, Rate_Sub_Popup_Msg, wantToSavePopup);
		String actSubmitPopup=getText(driver, Rate_Sub_Popup_Msg);
		if(actSubmitPopup.equals(wantToSavePopup)) {
			Extent_pass_New(driver,"Matched || Expected : popup message should be shown as : "+wantToSavePopup+" || Actual : popup message is shown as : "+ actSubmitPopup, test,test1);
			System.out.println("Matched || Expected : popup message should be shown as : "+wantToSavePopup+" || Actual : popup message is shown as : "+ actSubmitPopup);
			Extent_pass_New(driver, wantToSavePopup+" is displayed", test,test1);
			System.out.println(wantToSavePopup+" is displayed");

		}else {
			System.out.println("Not Matched || Expected : popup message should be shown as : "+wantToSavePopup+" || Actual : popup message is shown as : "+ actSubmitPopup);

			Extent_fail(driver,"Not Matched || Expected : popup message should be shown as : "+wantToSavePopup+" || Actual : popup message is shown as : "+ actSubmitPopup, test,test1);
		}

		Step_End(21, "Click Save button in the tool bar", test, test1);

		Step_Start(22, "Click submit", test, test1);
		waitForElement(driver, Rate_SubmitBtn);
		click(driver, Rate_SubmitBtn);

		waitForPopup(driver, popup_Message, wantToProceedPopup);
		String actualPopup=getText(driver, popup_Message);
		System.out.println("actualPopup :"+actualPopup);
		if(actualPopup.equals(wantToProceedPopup)) {
			Extent_pass_New(driver,"Matched || Expected : popup message should be shown as : "+wantToProceedPopup+" || Actual : popup message is shown as : "+ actualPopup, test,test1);
			System.out.println("Matched || Expected : popup message should be shown as : "+wantToProceedPopup+" || Actual : popup message is shown as : "+ actualPopup);
			Extent_pass_New(driver, wantToProceedPopup+" popup is displayed", test,test1);
			System.out.println(wantToProceedPopup+" popup is displayed");


		}else {
			System.out.println("Not Matched || Expected : popup message should be shown as : "+wantToProceedPopup+" || Actual : popup message is shown as : "+ actualPopup);

			Extent_fail(driver,"Not Matched || Expected : popup message should be shown as : "+wantToProceedPopup+" || Actual : popup message is shown as : "+ actualPopup, test,test1);
		}
		Step_End(22, "Click submit", test, test1);
		Step_Start(23, "Click Ok", test, test1);
		waitForElement(driver, Yes_Btn);
		click(driver, Yes_Btn);
		
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



		waitForDisplay(driver, Mail_Cancel_button);
		if(isdisplayed(driver, Mail_Cancel_button)) {
		click(driver, Mail_Cancel_button);
		}
		
		
		waitForPopup(driver, RR_Exp_Detention_Dropdown,Exp_Exp_Detention_Days_Input_Dropdown);
		String Act_Exp_Detetion =getText(driver, RR_Exp_Detention_Dropdown);
		
		if(Act_Exp_Detetion.equals(Exp_Exp_Detention_Days_Input_Dropdown)) {
			
			Extent_pass_New(driver,"Matched || Expected : Exp_Detetion value shoule be : "+Exp_Exp_Detention_Days_Input_Dropdown+" || Actual :Matched || Expected : Exp_Detetion value is : "+ Act_Exp_Detetion, test,test1);
			System.out.println("Matched || Expected : Exp_Detetion value shoule be : "+Exp_Exp_Detention_Days_Input_Dropdown+" || Actual :Matched || Expected : Exp_Detetion value is  : "+ Act_Exp_Detetion);
			
		}else {
			
			Extent_fail(driver,"NOt Matched || Expected : Exp_Detetion value shoule be : "+Exp_Exp_Detention_Days_Input_Dropdown+" || Actual :Matched || Expected : Exp_Detetion value is : "+ Act_Exp_Detetion, test,test1);
			System.out.println("Not Matched || Expected : Exp_Detetion value shoule be : "+Exp_Exp_Detention_Days_Input_Dropdown+" || Actual :Matched || Expected : Exp_Detetion value is  : "+ Act_Exp_Detetion);
		}
		
		
		
		waitForPopup(driver, RR_Imp_Detention_Dropdown,Exp_Imp_Detention_Days_Input_Dropdown);
		String Act_Imp_Detetion =getText(driver, RR_Imp_Detention_Dropdown);
		
		if(Act_Imp_Detetion.equals(Exp_Imp_Detention_Days_Input_Dropdown)) {
			
			Extent_pass_New(driver,"Matched || Expected : Exp_Detetion value shoule be : "+Exp_Imp_Detention_Days_Input_Dropdown+" || Actual :Matched || Expected : Exp_Detetion value is : "+ Act_Imp_Detetion, test,test1);
			System.out.println("Matched || Expected : Exp_Detetion value shoule be : "+Exp_Imp_Detention_Days_Input_Dropdown+" || Actual :Matched || Expected : Exp_Detetion value is  : "+ Act_Imp_Detetion);
			
		}else {
			
			Extent_fail(driver,"NOt Matched || Expected : Exp_Detetion value shoule be : "+Exp_Imp_Detention_Days_Input_Dropdown+" || Actual :Matched || Expected : Exp_Detetion value is : "+ Act_Imp_Detetion, test,test1);
			System.out.println("Not Matched || Expected : Exp_Detetion value shoule be : "+Exp_Imp_Detention_Days_Input_Dropdown+" || Actual :Matched || Expected : Exp_Detetion value is  : "+ Act_Imp_Detetion);
		}
		
		
		
		waitForPopup(driver, RR_Imp_Demurrage_Dropdown,Exp_Imp_Demurrage_Days_Input_Dropdown);
		String Act_Imp_Demurrage =getText(driver, RR_Imp_Demurrage_Dropdown);
		
		if(Act_Imp_Demurrage.equals(Exp_Imp_Demurrage_Days_Input_Dropdown)) {
			
			Extent_pass_New(driver,"Matched || Expected : Exp_Detetion value shoule be : "+Exp_Imp_Demurrage_Days_Input_Dropdown+" || Actual :Matched || Expected : Exp_Detetion value is : "+ Act_Imp_Demurrage, test,test1);
			System.out.println("Matched || Expected : Exp_Detetion value shoule be : "+Exp_Imp_Demurrage_Days_Input_Dropdown+" || Actual :Matched || Expected : Exp_Detetion value is  : "+ Act_Imp_Demurrage);
			
		}else {
			
			Extent_fail(driver,"NOt Matched || Expected : Exp_Detetion value shoule be : "+Exp_Imp_Demurrage_Days_Input_Dropdown+" || Actual :Matched || Expected : Exp_Detetion value is : "+ Act_Imp_Demurrage, test,test1);
			System.out.println("Not Matched || Expected : Exp_Detetion value shoule be : "+Exp_Imp_Demurrage_Days_Input_Dropdown+" || Actual :Matched || Expected : Exp_Detetion value is  : "+ Act_Imp_Demurrage);
		}
		
		
		waitForPopup(driver, RR_Exp_Demurrage_Dropdown,Exp_Exp_Demurrage_Days_Input_Dropdown);
		String Act_Exp_Demurrage =getText(driver, RR_Exp_Demurrage_Dropdown);
		
		if(Act_Exp_Demurrage.equals(Exp_Exp_Demurrage_Days_Input_Dropdown)) {
			
			Extent_pass_New(driver,"Matched || Expected : Exp_Detetion value shoule be : "+Exp_Exp_Demurrage_Days_Input_Dropdown+" || Actual :Matched || Expected : Exp_Detetion value is : "+ Act_Exp_Demurrage, test,test1);
			System.out.println("Matched || Expected : Exp_Detetion value shoule be : "+Exp_Exp_Demurrage_Days_Input_Dropdown+" || Actual :Matched || Expected : Exp_Detetion value is  : "+ Act_Exp_Demurrage);
			
		}else {
			
			Extent_fail(driver,"NOt Matched || Expected : Exp_Detetion value shoule be : "+Exp_Exp_Demurrage_Days_Input_Dropdown+" || Actual :Matched || Expected : Exp_Detetion value is : "+ Act_Exp_Demurrage, test,test1);
			System.out.println("Not Matched || Expected : Exp_Detetion value shoule be : "+Exp_Exp_Demurrage_Days_Input_Dropdown+" || Actual :Matched || Expected : Exp_Detetion value is  : "+ Act_Exp_Demurrage);
		}
		
		
		Step_End(23, "Click Ok", test, test1);  
		
		Extent_completed(testcase_Name, test, test1);
	
		
}
}