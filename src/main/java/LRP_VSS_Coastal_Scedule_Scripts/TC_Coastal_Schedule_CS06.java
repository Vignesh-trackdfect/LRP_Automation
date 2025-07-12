package LRP_VSS_Coastal_Scedule_Scripts;

import java.util.Map;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS06 extends Keywords {


	public void Coastal_Schedule_CS06(WebDriver driver,ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Coastal_Schedule_CS06";

		String permanentDeleteText=Excel_data.get("PermanentDeleteText");
		String ExpectedCA =Excel_data.get("ExpectedCA");
		String PermanentdelePopup=Excel_data.get("DeletedPopup");
		String Username_CS06 =Excel_data.get("Username");
		String Password_CS06 =Excel_data.get("Password");
		String ModuleSearch_CS06 =Excel_data.get("Module_Search");
		String ServiceCode_CS06 =Excel_data.get("Service_Code"); 
		String VesselCode_CS06 =Excel_data.get("Vessel_Code");
		String voyageNumber_CS06 =Excel_data.get("Voyage_Number");
		String portName_CS06 =Excel_data.get("Port_Name");
		String Remove_Voyage_page_Txt_CS06 = Excel_data.get("Remove_Voyage_page");
		String EnterReason_Popup_Exp_CS06= Excel_data.get("Enter_the_Reason_Popup");
		String enterReason_TxtField_Inuput_CS06= Excel_data.get("enterReason_TxtField_Inuput");
		String moveToCoastal_PopUp_Txt_Exp_CS06= Excel_data.get("MoveToCoastal_PopUp_Txt");
		String updateCoastal_PopUp_Exp_CS06= Excel_data.get("UpdateCoastal_PopUp");
		String remove_Button_CS06 =Excel_data.get("Button");
		String Per_Delete_Btn_CS06 =Excel_data.get("Per_Delete_Btn");
		String RollBack_CS06 =Excel_data.get("Do_You_Want_Rollback");
		String add_Button_CS06 =Excel_data.get("Add_Button");
		String speed_Pre_port= Excel_data.get("Speed_Pre_port");
		String distance_nextport= Excel_data.get("distance_nextport");
		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");
		String Cycle_Search_Header = Excel_data.get("Cycle_Search_Header");
		String Cycle_Number = Excel_data.get("Cycle_Number");



		String Voyage_Toggler =String.format(Coastal_Schedule_Locators.Voyage_Toggler, voyageNumber_CS06);
		String Port_Select =String.format(Coastal_Schedule_Locators.Port_Select6,voyageNumber_CS06,portName_CS06);
		String remove_Select =String.format(Coastal_Schedule_Locators.remove_Select,remove_Button_CS06);
		String Remove_Element =String.format(Coastal_Schedule_Locators.removeElement,portName_CS06,portName_CS06);
		String port_select =String.format(Coastal_Schedule_Locators.port_select6,portName_CS06);
		String Voyage =String.format(Coastal_Schedule_Locators.Voyage6,voyageNumber_CS06);
		String Permenent_Delete = String.format(Coastal_Schedule_Locators.Permenent_Delete,Per_Delete_Btn_CS06);
		String Select_Port = String.format(Coastal_Schedule_Locators.Select_Port6,portName_CS06);
		String button_Select =String.format(Coastal_Schedule_Locators.button_Select6,add_Button_CS06);

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);
		
		
		LRP_Login(driver, Username_CS06, Password_CS06);
		
		moduleNavigate(driver, ModuleSearch_CS06);
		
	
		Step_Start(1, "Enter the Service Code in the service code field", test, test1);

		waitForElement(driver, Service_Search_Btn);
		click(driver, Service_Search_Btn);
		
		twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS06);
		
		Step_End(1, "Enter the Service Code in the service code field", test, test1);

		Step_Start(2, "Enter the Vessel ", test, test1);

		waitForElement(driver, Vessel_Search_Btn);
		click(driver, Vessel_Search_Btn);

		twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS06);
		
		Step_End(2, "Enter the Vessel ", test, test1);

		Step_Start(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForDisplay(driver, Tree_Structure);
		if(isdisplayed(driver,Tree_Structure)) {
			Extent_pass_New(driver, "Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed", test, test1);
			System.out.println("Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed");
		}else {
			System.out.println("Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed");

			Extent_fail(driver, "Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed", test, test1);
		}
		Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
		Step_Start(4, "Choose the first voyage", test, test1);
		waitForElement(driver, Voyage_Toggler);
		String status = getAttribute(driver, Voyage_Toggler, "class");
		if(!status.contains("s")) {
			click(driver, Voyage_Toggler);
		}
		Step_End(4, "Choose the first voyage", test, test1);
		Step_Start(5, "click on the port after which the port needed to be Removed from the voyage ", test, test1);
		waitForElement(driver, Port_Select);
		click(driver, Port_Select);	

		Step_End(5, "click on the port after which the port needed to be Removed from the voyage ", test, test1);
		Step_Start(6,"Right click on it ", test, test1);
		waitForElement(driver, Port_Select);
		RightClick(driver, Port_Select);
		Step_End(6,"Right click on it ", test, test1);
		Step_Start(7, "Choose Remove(Omit) Option from the menu ", test, test1);
		waitForElement(driver, remove_Select);
		click(driver, remove_Select);
		Step_End(7, "Choose Remove(Omit) Option from the menu ", test, test1);
		Step_Start(8, "Remove(omit) window appears", test, test1);


		waitForElement(driver, remove_Voyage_Page);
		String text=getText(driver, remove_Voyage_Page);
		if(Remove_Voyage_page_Txt_CS06.equals(text)) {

			System.out.println("Matched || " + " Expected Text is : " + Remove_Voyage_page_Txt_CS06 + " || Actual Text is : " + text);
			Extent_pass_New(driver, "Matched || " + " Expected Text is : " + Remove_Voyage_page_Txt_CS06 + " || Actual Text is : " + text, test,test1);
		}
		else {
			System.out.println("Not Matched || " + " Expected Text is : " + Remove_Voyage_page_Txt_CS06 + " || Actual Text is : " + text);
			Extent_fail(driver, "Not Matched || " + " Expected Text is : " + Remove_Voyage_page_Txt_CS06 + " || Actual Text is : " + text, test,test1);
		}

		Step_End(8, "Remove(omit) window appears", test, test1);

		Step_Start(9, "Select the port row that needed to be removed", test, test1);
		waitForElement(driver, Remove_Element);
		click(driver, Remove_Element);

		Step_End(9, "Select the port row that needed to be removed", test, test1);
		Step_Start(10, "click on Remove button", test, test1);

		waitForElement(driver, remove_Voyage_Page_Btn);
		click(driver, remove_Voyage_Page_Btn);

		waitForPopup(driver, enterReason_PopUP, EnterReason_Popup_Exp_CS06);
		String reasonPopupText=getText(driver, enterReason_PopUP);
		if(EnterReason_Popup_Exp_CS06.equals(reasonPopupText)) {
			System.out.println("Matched || " + " Expected Popup is : " + EnterReason_Popup_Exp_CS06 + " || Actual Popup is : " + reasonPopupText);
			Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + EnterReason_Popup_Exp_CS06 + " || Actual Popup is : " + reasonPopupText, test,test1);
		}
		else {
			System.out.println("Not Matched || " + " Expected Popup is : " + EnterReason_Popup_Exp_CS06 + " || Actual Popup is : " + reasonPopupText);
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + EnterReason_Popup_Exp_CS06 + " || Actual Popup is : " + reasonPopupText, test,test1);
		}
		waitForElement(driver, enterReason_TxtField);
		sendKeys(driver, enterReason_TxtField, enterReason_TxtField_Inuput_CS06);
		waitForElement(driver, enterReason_OkBtn);
		click(driver, enterReason_OkBtn);
		elementnotvisible(driver, enterReason_OkBtn);
		Step_End(10, "click on Remove button", test, test1);
		Step_Start(12, "click on Move to Coastal Schedule button", test, test1);
		waitForElement(driver, moveTOCoastalSchedule_Btn);
		click(driver, moveTOCoastalSchedule_Btn);
		
		Step_End(12, "click on Move to Coastal Schedule button", test, test1);
		Step_Start(13, "System should remove the omitted port from the voyage", test, test1);

		waitForPopup(driver, popup_Message, moveToCoastal_PopUp_Txt_Exp_CS06);

		String moveToCostalMsg=getText(driver, popup_Message);
		if(moveToCoastal_PopUp_Txt_Exp_CS06.equals(moveToCostalMsg)) {
			click(driver, popup_Message_Yes_Button);
			System.out.println("Matched || " + " Expected Popup is : " + moveToCoastal_PopUp_Txt_Exp_CS06 + " || Actual Popup is : " + moveToCostalMsg);
			Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + moveToCoastal_PopUp_Txt_Exp_CS06 + " || Actual Popup is : " + moveToCostalMsg, test,test1);
		}
		else {
			System.out.println("Not Matched || " + " Expected Popup is : " + moveToCoastal_PopUp_Txt_Exp_CS06 + " || Actual Popup is : " + moveToCostalMsg);
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + moveToCoastal_PopUp_Txt_Exp_CS06 + " || Actual Popup is : " + moveToCostalMsg, test,test1);
		}

		waitForPopup(driver, popup_Message, updateCoastal_PopUp_Exp_CS06);
		String updatePopupMsg=getText(driver, popup_Message);
		if(updateCoastal_PopUp_Exp_CS06.equals(updatePopupMsg)) {
			click(driver, popup_Message_Ok_Button);
			System.out.println("Matched || " + " Expected Popup is : " + updateCoastal_PopUp_Exp_CS06 + " || Actual Popup is : " + updatePopupMsg);
			Extent_pass_New(driver, "Matched || " + " Expected Popup is : " + updateCoastal_PopUp_Exp_CS06 + " || Actual Popup is : " + updatePopupMsg, test,test1);
		}
		else {
			System.out.println("Not Matched || " + " Expected Popup is : " + updateCoastal_PopUp_Exp_CS06 + " || Actual Popup is : " + updatePopupMsg);
			Extent_fail(driver, "Not Matched || " + " Expected Popup is : " + updateCoastal_PopUp_Exp_CS06 + " || Actual Popup is : " + updatePopupMsg, test,test1);
		}
		Step_End(13, "System should remove the omitted port from the voyage", test, test1);
		waitForElement(driver, Voyage);
		click(driver, Voyage);
		Step_Start(14, "Right click either on the port or In the voyage", test, test1);
		waitForElement(driver, Voyage);
		RightClick(driver, Voyage);
		Step_End(14, "Right click either on the port or In the voyage", test, test1);
		Step_Start(15, "Choose permanently delete option from the menu", test, test1);
		waitForElement(driver, Permenent_Delete);
		click(driver, Permenent_Delete);
		Step_End(15, "Choose permanently delete option from the menu", test, test1);
		Step_Start(16, "Choose the voyage from From Voyage field ", test, test1);
		waitForElement(driver, permanentDeleteFrame);
		String frameText=getText(driver,permanentDeleteFrame);
		if(frameText.equals(permanentDeleteText)) {
			System.out.println("Matched || " + " Expected Text : " + permanentDeleteText + " || Actual Text : " + frameText);
			Extent_pass_New(driver,"Matched || " + " Expected Text : " + permanentDeleteText + " || ActualText : " + frameText,test,test1);
			Extent_pass_New(driver, "Permanent delete frame is displayed", test,test1);
			
			waitForElement(driver, fromVoyageSearchButton);
			click(driver, fromVoyageSearchButton);
			
			twoColumnSearchWindow(driver, Cycle_Search_Header, condition, Cycle_Number);

			Step_End(16, "Choose the voyage from From Voyage field", test, test1);
			Step_Start(17, "Choose To Voyage value", test, test1);
			waitForElement(driver, toVoyageSearchButton);
			click(driver, toVoyageSearchButton);
			
			twoColumnSearchWindow(driver, Cycle_Search_Header, condition, Cycle_Number);

			Step_End(17, "Choose To Voyage value", test, test1);
			Step_Start(18, "Click on Show deleted Calls", test, test1);
			waitForElement(driver, showDelCallsButton);
			click(driver, showDelCallsButton);
			Step_End(18, "Click on Show deleted Calls", test, test1);
			Step_Start(19, "System should list out the Deleted calls from the Voyage range selected in From and To voyage", test, test1);
			Step_Start(20, "Select the Port Row which needed to be deleted", test, test1);
			waitForElement(driver, port_select);
			click(driver, port_select);
			Step_End(19, "System should list out the Deleted calls from the Voyage range selected in From and To voyage", test, test1);
			Step_End(20, "Select the Port Row which needed to be deleted", test, test1);
			Step_Start(21, "Click on permanently delete button", test, test1);

			waitForElement(driver, permanentDelButton);
			click(driver, permanentDelButton);
			Step_End(21, "Click on permanently delete button", test, test1);
			Step_Start(22, "Now Clicking on the “Deleted(omit) calls “ button should not show the Omitted ports", test, test1);


			waitForPopup(driver, popup_Message, "Permanent delete");
			if(isdisplayed(driver, popup_Message)) {
				click(driver, popup_Message_Yes_Button);
			}
		}else {
			System.out.println("Not matched || " + " Expected Text : " + permanentDeleteText + " || Actual Text : " + frameText+" || Permanent delete frame is not displayed");
			Extent_fail(driver,"Not matched || " + " Expected Text : " + permanentDeleteText + " || Actual Text : " + frameText+" || Permanent delete frame is not displayed",test,test1);
		}
		waitForPopup(driver, popup_Message, PermanentdelePopup);
		String actText=getText(driver, popup_Message);
		if(actText.equals(PermanentdelePopup)) {
			System.out.println("Matched || " + " Expected Popup : " + PermanentdelePopup + " || Actual Popup : " + actText);
			Extent_pass_New(driver,"Matched || " + " Expected Popup : " + PermanentdelePopup + " || ActualPopup : " + actText,test,test1);
			click(driver, popup_Message_Ok_Button);
		}else {
			System.out.println("Not matched || " + " Expected Popup : " + PermanentdelePopup + " || Actual Value  is : " + actText+" || Selected Call(s) Deleted. popup is not displayed");
			Extent_fail(driver,"Not matched || " + " Expected Popup : " + PermanentdelePopup + " || Actual Popup : " + actText+" || Selected Call(s) Deleted. popup is not displayed",test,test1);
		}
		Step_End(22, "Now Clicking on the “Deleted(omit) calls “ button should not show the Omitted ports", test, test1);

		if(RollBack_CS06.equalsIgnoreCase("Yes")) {

			waitForElement(driver, Voyage);
			click(driver, Voyage);
			waitForElement(driver, Voyage);
			RightClick(driver, Voyage);
			waitForElement(driver, button_Select);
			click(driver, button_Select);

			waitForElement(driver, Select_Port);
			click(driver, Select_Port);
			waitForElement(driver, Roll_Back_Btn);
			click(driver, Roll_Back_Btn);

			Actions action = new Actions(driver);

			waitForElement(driver,speed_PreviousPort_P);
			if(isClickable(driver, speed_PreviousPort_P)) {
				click(driver,speed_PreviousPort_P);

				action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
				action.sendKeys(speed_Pre_port).perform();
			}
			waitForElement(driver,distance_NextPort_P);
			if(isClickable(driver, distance_NextPort_P)) {
				click(driver,distance_NextPort_P);
				action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
				action.sendKeys(distance_nextport).perform();
			}
			waitForElement(driver, Coastal_Schedule_Move);
			click(driver,Coastal_Schedule_Move);
			waitForDisplay(driver, popup_Message_Yes_Button);
			if(isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
			}
			waitForPopup(driver, popup_Message, ExpectedCA);
				String ActualCA = getText(driver,popup_Message);
				System.out.println(ExpectedCA);
				System.out.println(ActualCA);
				if(ExpectedCA.equals(ActualCA)) {
					System.out.println("Matched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA);
					Extent_pass_New(driver, "Matched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA, test,test1);
					click(driver,popup_Message_Ok_Button);

				}else {
					System.out.println("NotMatched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA);
					Extent_fail(driver,  "NotMatched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA, test,test1);
				}
			}
			
		Extent_completed(testCaseName, test, test1);
	}

}