package LRP_VSS_Integration_Scripts_2;

import java.util.List;
import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_CS03_Long_Term_LT12_IP extends Keywords {

	public void integration_LT12_To_CS03(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Coastal_CS03_Long_Term_LT12_IP";

		
		
		



		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String longterm_module = Excel_data.get("longterm_module");
		String coastal_module = Excel_data.get("coastal_module");
		String serviceCodeValue = Excel_data.get("serviceCodeValue");
		String Port_Name = Excel_data.get("Port_Name");
		String Voyage_Number = Excel_data.get("Voyage_Number");
		String Vessels_Code = Excel_data.get("Vessels_Code");
		String voyage_Number_Coastal = Excel_data.get("Voyage_Number_Coastal");
	     String Port_delete_pop_exp= Excel_data.get("Port_delete_pop_exp");
	     String Port_delete_colour_exp  = Excel_data.get("Port_delete_colour_exp");
	     String wantToConfirmPopup  = Excel_data.get("WantToConfirmPopup");
	     String confirmedPopup  = Excel_data.get("ConfirmedPopup");
	     
	     String condition = Excel_data.get("Condition");
			String service_Search_Header = Excel_data.get("Service_Search_Header");
			String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");
			String Service_Code_Header = Excel_data.get("Service_Code_Header");

		String voyage_Select =String.format(Coastal_Schedule_Locators.voyage_Select, voyage_Number_Coastal);

		
		

		Extent_Start(testCaseName, test, test1);
		
		navigateUrl(driver, url);
		
		LRP_Login(driver, Username, Password);

		Step_Start(1, "Open Long Term Creation", test, test1);
		
		moduleNavigate(driver, longterm_module);

		Step_End(1, "Open Long Term Creation", test, test1);
		
		Step_Start(2, "Retreive any Service", test, test1);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		waitForElement(driver, searchIconLT);
		safeclick(driver, searchIconLT);
		twoColumnSearchWindow(driver, Service_Code_Header, condition, serviceCodeValue);

		Step_End(2, "Retreive any Service", test, test1);

		waitForElement(driver, LongTermsearchOk);
		click(driver, LongTermsearchOk);
		
		Step_Start(3, "Click on Edit Button", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_End(3, "Click on Edit Button", test, test1);
	
		Step_Start(4, "Delete the port call permanently of any vessel Draft Voyage ", test, test1);
		
		
		
	scrollBottom(driver);
		
		try {
		int i=1;
		
		waitForElement(driver, vessels_code);

		List<WebElement> vessel_Codes = listOfElements(driver, vessels_code);
		for(WebElement Vessel_Code : vessel_Codes) {
			waitForElement(driver, vessels_code);
			String actual_VesselCode =Vessel_Code.getText();
			if(Vessels_Code.equals(actual_VesselCode)) {
				
				waitForElement(driver, voyage_Num_1);

				List<WebElement> voyNumbers = listOfElements(driver, voyage_Num_1);
				for(int j=1;j<=voyNumbers.size();j++) {
					String voyage_Num =  String.format(voyage_Number_Select_LT,j); 
					waitForElement(driver, voyage_Num);
					String actual_voyage_Num =getText(driver, voyage_Num);
					
				
					if(Voyage_Number.equals(actual_voyage_Num)) {
					 	String port_Cell =  String.format(port_Date_17,Port_Name,i);
					 	scrollUsingElement(driver, port_Cell);
					 	click(driver, port_Cell);
					
						waitForElement(driver, port_Cell);
					 	RightClick(driver, port_Cell);
					 	waitForElement(driver, port_Cell);

						scrollUsingElement(driver, Permanentdelete);		 	
		waitForElement(driver, Permanentdelete);
		safeclick(driver, Permanentdelete);
		
		waitForDisplay(driver, popup_Message_Yes_Button);
		if(isdisplayed(driver, popup_Message_Yes_Button)) {
		safeclick(driver, popup_Message_Yes_Button);
		}
		
		waitForPopup(driver, popup_Message, Port_delete_pop_exp);
		String deletemsgact = getText(driver, popup_Message);
		System.out.println(deletemsgact);
		if (Port_delete_pop_exp.equals(deletemsgact)) {
			System.out.println("Matched || " + " Expected Popup : " + Port_delete_pop_exp
					+ " || Actual Popup : " + deletemsgact);
			Extent_pass_New(driver, "Matched || " + " Expected Popup : " + Port_delete_pop_exp
					+ " || Actual Popup : " + deletemsgact, test,test1);
		} else {
			System.out.println("Not matched || " + " Expected Popup : " + Port_delete_pop_exp
					+ " || Actual Popup : " + deletemsgact);
			Extent_fail(driver, "Not matched || " + " Expected Popup : " + Port_delete_pop_exp
					+ " || Actual Popup : " + deletemsgact, test,test1);
		}
		safeclick(driver, popup_Message_Ok_Button);
		
		scrollBottom(driver);

		String port_Date1 =  String.format(port_Date_17,Port_Name,i); 
		waitForElement(driver, port_Date1);
	String Portdelete_Code=getTextBackgroundColor(driver, port_Date1);
	String Portdelete=getColorName(Portdelete_Code);
	System.out.println(Portdelete);
	
	
	
	if (Port_delete_colour_exp.equals(Portdelete)) {
		System.out.println("Matched || " + " Expected Color : " + Port_delete_colour_exp
				+ " || Actual Color : " + Portdelete);
		Extent_pass_New(driver, "Matched || " + " Expected Color : " + Port_delete_colour_exp
				+ " || Actual Color : " + Portdelete, test,test1);
		Extent_pass_New(driver, "**PORT COLOUR WAS CHANGED INTO WHITE COLOUR**", test, test1);
	} else {
		System.out.println("Not matched || " + " Expected Color : " + Port_delete_colour_exp
				+ " || Actual Color : " + Portdelete);
		Extent_fail(driver, "Not matched || " + " Expected Color : " + Port_delete_colour_exp
				+ " || Actual Color : " + Portdelete, test,test1);
	}
	Step_End(4, "Delete the port call permanently of any vessel Draft Voyage ", test, test1);
	Step_Start(5, "Right click to Confirm it", test, test1);
 	scrollUsingElement(driver, port_Cell);

	click(driver, port_Cell);
	waitForElement(driver, port_Cell);
 	RightClick(driver, port_Cell);
	waitForElement(driver, port_Cell);

	scrollUsingElement(driver, Conformbtnlongterm);
	waitForElement(driver, Conformbtnlongterm);
	click(driver, Conformbtnlongterm);

	waitForPopup(driver, popup_Message, wantToConfirmPopup);
	String actualWantToConfirm_popAct = getText(driver, popup_Message);
	System.out.println(actualWantToConfirm_popAct);

	if(actualWantToConfirm_popAct.equals(wantToConfirmPopup)) {
		Extent_pass_New(driver, "Matched || Expected Popup : "+wantToConfirmPopup+" || Actual Popup : "+actualWantToConfirm_popAct, test, test1);
		System.out.println("Matched || Expected Popup : "+wantToConfirmPopup+" || Actual Popup : "+actualWantToConfirm_popAct);
		click(driver, popup_Message_Yes_Button);
	}else {
		System.out.println("Not Matched || Expected Popup : "+wantToConfirmPopup+" || Actual Popup : "+actualWantToConfirm_popAct);
		Extent_fail(driver, "Not Matched || Expected Popup : "+wantToConfirmPopup+" || Actual Popup : "+actualWantToConfirm_popAct, test, test1);
	}
	
	
	waitForDisplay(driver, plannedVessels_Frame);
	if(isdisplayed(driver, plannedVessels_Frame)) {
		click(driver, continueButton);
	}
	waitForPopup(driver, popup_Message, confirmedPopup);
	String actualConfirmedPopup = getText(driver, popup_Message);
	System.out.println(actualConfirmedPopup);
	if(actualConfirmedPopup.equals(confirmedPopup)) {
		Extent_pass_New(driver, "Matched || Expected Popup : "+confirmedPopup+" || Actual Popup : "+actualConfirmedPopup, test, test1);
		System.out.println("Matched || Expected Popup : "+confirmedPopup+" || Actual Popup : "+actualConfirmedPopup);
		click(driver, popup_Message_Ok_Button);

	}else {
		System.out.println("Not Matched || Expected Popup : "+confirmedPopup+" || Actual Popup : "+actualConfirmedPopup);
		Extent_fail(driver, "Not Matched || Expected Popup : "+confirmedPopup+" || Actual Popup : "+actualConfirmedPopup, test, test1);
	}
		
	
	break;
	}
	}}
	 	i++;
			}
					
			}catch (Exception e) {
				e.printStackTrace();
			}

			Step_End(5, "Right click to Confirm it", test, test1);			
			Step_Start(6, "Open Coastal Schedule ", test, test1);
			
			scrollTop(driver);
			moduleNavigate(driver, coastal_module);
			
				Step_End(6, "Open Coastal Schedule ", test, test1);			
						Step_Start(7, "Reterieve the Schedule used previously in Long Term ", test, test1);
						
						// Enter the service code in service code text field
						waitForElement(driver, Service_Search_Btn);
						click(driver, Service_Search_Btn);
						
						twoColumnSearchWindow(driver, service_Search_Header, condition, serviceCodeValue);

						
						// Enter the vessel
						
						waitForElement(driver, Vessel_Search_Btn);
						click(driver, Vessel_Search_Btn);

						twoColumnSearchWindow(driver, vessel_Search_Header, condition, Vessels_Code);
						
						
						Step_End(7, "Reterieve the Schedule used previously in Long Term ", test, test1);

						Step_Start(8, "Click on Edit Button", test, test1);
						waitForElement(driver, Edit_Button_toolBar);
						 click(driver, Edit_Button_toolBar);
						Step_End(8, "Click on Edit Button", test, test1);
						Step_Start(9, "Right click on Any port", test, test1);
						waitForElement(driver, voyage_Select);
						click(driver, voyage_Select);
						waitForElement(driver, voyage_Select);
						RightClick(driver, voyage_Select);
						Step_End(9, "Right click on Any port", test, test1);
						Step_Start(10, "Choose Add Port", test, test1);
						waitForElement(driver, addPort_Option);
						click(driver, addPort_Option);

						Step_End(10, "Choose Add Port", test, test1);
						Step_Start(11, "Check under the Long Term/Permanently Delete Calls Grid ", test, test1);
						waitForElement(driver, addPort_Frame);
						
						if(isDisplayed(driver, permanentDelete_PortName)) {
							Extent_pass_New(driver, "Matched || Long Term/Permanently Delete Calls should be displayed in the Grid || Actual : Long Term/Permanently Delete Calls are displayed in the Grid", test, test1);
							System.out.println("Matched || Long Term/Permanently Delete Calls should be displayed in the Grid || Actual : Long Term/Permanently Delete Calls are displayed in the Grid");
						}else {
							System.out.println("Not Matched || Long Term/Permanently Delete Calls should be displayed in the Grid || Actual : Long Term/Permanently Delete Calls are not displayed in the Grid");
							Extent_fail(driver, "Not Matched || Long Term/Permanently Delete Calls should be displayed in the Grid || Actual : Long Term/Permanently Delete Calls are not displayed in the Grid", test, test1);
						}
						List<WebElement> portName_List = listOfElements(driver, permanentDelete_PortName);
						int listSize=portName_List.size();
						waitForElement(driver, permanentDelete_PortName);
						String lastPort=String.format(permanent_Delete_PortName, listSize);
						scrollUsingElement(driver, lastPort);
						String act=getText(driver, lastPort);
						System.out.println("act:"+act);
						if(act.equals(Port_Name)) {
							Extent_pass_New(driver, "Matched || Expected Port name : "+Port_Name+" || Actual Port name : "+act, test, test1);
							System.out.println("Matched || Expected Port name : "+Port_Name+" || Actual Port name : "+act);
						}else {
							System.out.println("Not Matched || Expected Port name : "+Port_Name+" || Actual Port name : "+act);
							Extent_fail(driver, "Not Matched || Expected Port name : "+Port_Name+" || Actual Port name : "+act, test, test1);
						}
		
		Step_End(11, "Check under the Long Term/Permanently Delete Calls Grid ", test, test1);

		Extent_completed(testCaseName, test, test1);

	}
}
