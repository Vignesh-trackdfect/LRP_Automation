package LRP_VSS_Coastal_Scedule_Scripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS12 extends Keywords {

	public void Coastal_Schedule_CS12(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
		String testCaseName="TC_Coastal_Schedule_CS12";

		String Change_Call_Type_CS12 =Excel_data.get( "Change_Call_Type");
		String voyage_green_color_CS12 =Excel_data.get( "voyage_greencolor");
		String marooncolor_Voyage_CS12 =Excel_data.get( "Voyage_marooncolor");
		String verify_commercial_CS12 =Excel_data.get( "Commerical_Verify");
		String graycolor_Voyage_CS12 =Excel_data.get( "Voyage_graycolor");
		String Current_Verify_CS12 =Excel_data.get("Current_Verify_CS12");
		String Change_Future_Voyages_CS12 = Excel_data.get("Change_Future_Voyages");
		String Username_CS12 =Excel_data.get("Username");
		String Password_CS12 =Excel_data.get("Password");
		String ModuleSearch_CS12 =Excel_data.get("Module_Search");
		String ServiceCode_CS12 =Excel_data.get("Service_Code"); 
		String VesselCode_CS12 =Excel_data.get("Vessel_Code");
		String voyageNumber_CS12 =Excel_data.get("Voyage_Number");
		String portName_CS12 =Excel_data.get("Port_Name");
		String Change_Call_Type =Excel_data.get("Button");

		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");
		
		String call_Type_button = String.format(Coastal_Schedule_Locators.call_Type_button, Change_Call_Type);
		String Voyage_Toggler =String.format(Coastal_Schedule_Locators.Voyage_Toggler,voyageNumber_CS12);
		String Port_Select=String.format(Coastal_Schedule_Locators.Port_Select12,voyageNumber_CS12,portName_CS12);
		String	Port_Icon = String.format(Coastal_Schedule_Locators.Port_Icon12,voyageNumber_CS12,portName_CS12);
		String Call_Type_Select = String.format(Coastal_Schedule_Locators.Call_Type_Select12,Change_Call_Type_CS12);

		Extent_Start(testCaseName, test, test1);

		navigateUrl(driver, url);
		
		LRP_Login(driver, Username_CS12, Password_CS12);
		
		moduleNavigate(driver, ModuleSearch_CS12);

		Step_Start(1, "Enter the Service Code  in the service code field", test, test1);

		waitForElement(driver, Service_Search_Btn);
		click(driver, Service_Search_Btn);
		
		twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS12);

		Step_End(1, "Enter the Service Code  in the service code field", test, test1);


		Step_Start(2, "Enter the Vessel ", test, test1);

		waitForElement(driver, Vessel_Search_Btn);
		click(driver, Vessel_Search_Btn);

		twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS12);


		Step_End(2, "Enter the Vessel ", test, test1);

		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		Step_Start(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
		waitForDisplay(driver, Tree_Structure);
		if(isdisplayed(driver,Tree_Structure)) {
			Extent_pass_New(driver, "Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed", test, test1);
			System.out.println("Passed || Expected : The Tree format should be displayed || Actual : The Tree format is displayed");
		}else {
			System.out.println("Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed");

			Extent_fail(driver, "Failed || Expected : The Tree format should be displayed || Actual : The Tree format is not displayed", test, test1);
		}
		Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);

		waitForElement(driver, Voyage_Toggler);
		String status = getAttribute(driver, Voyage_Toggler, "class");
		if(!status.contains("s")) {
			click(driver, Voyage_Toggler);
		}

		//pivot bound1	
		waitForElement(driver, Port_Select);
		click(driver, Port_Select);
		waitForElement(driver, Port_Icon);
		String icon_Colour_Code = getTextColor(driver, Port_Icon);
		String icon_Colour = getColorName(icon_Colour_Code);
		System.out.println("icon_Colour" + icon_Colour);

		if(Change_Call_Type_CS12.equals("Change Commercial to Physical")||Change_Call_Type_CS12.equals("Change Commercial to Canal")) {
			if (icon_Colour.equals(voyage_green_color_CS12)) {
				System.out.println("Matched || Expected Commerical Icon colour was : "+voyage_green_color_CS12+" || Actual Commerical Icon colour was : "+icon_Colour);
				Extent_pass_New(driver, "Matched || Expected Commerical Icon colour was : "+voyage_green_color_CS12+" || Actual Commerical Icon colour was : "+icon_Colour, test,test1);
				Step_Start(4, "Right click on the  port call type to be changed", test, test1);
				waitForElement(driver, Port_Select);
				RightClick(driver, Port_Select);

				Step_End(4, "Right click on the  port call type to be changed", test, test1);

				Step_Start(5, "Choose Change Call Type option", test, test1);
				waitForElement(driver, call_Type_button);
				click(driver, call_Type_button);
				Step_End(5, "Choose Change Call Type option", test, test1);

				Step_Start(6, "Choose Future voyages if the Call type of the port should be applied to future voyages of the same port in the same vessel", test, test1);
				Step_Start(7, "Choose Current voyage if the call Type should only affect the current port  in the current voyage", test, test1);
				if(Change_Future_Voyages_CS12.equalsIgnoreCase("Yes")) {
					waitForElement(driver, Change_Future_Call_Type);
					click(driver, Change_Future_Call_Type);
				}else {
					waitForElement(driver, Change_Current_Call_Type);
					click(driver, Change_Current_Call_Type);
				}
				Step_End(6, "Choose Future voyages if the Call type of the port should be applied to future voyages of the same port in the same vessel", test, test1);
				Step_End(7, "Choose Current voyage if the call Type should only affect the current port  in the current voyage", test, test1);

				Step_Start(8, "Choose the Call to be Changed from Commercial/Physical/Canal", test, test1);

				waitForElement(driver, Call_Type_Select);
				click(driver, Call_Type_Select);

				Step_End(8, "Choose the Call to be Changed from Commercial/Physical/Canal", test, test1);

				Step_Start(9, "System should show pop up as”Call type changed", test, test1);
				waitForPopup(driver, popup_Message, verify_commercial_CS12);
				String Commercialverify = getText(driver, popup_Message);
				if(Change_Future_Voyages_CS12.equalsIgnoreCase("Yes")) {
					if (Commercialverify.equals(verify_commercial_CS12)) {
						System.out.println("Matched || Expected Popup value is : "+verify_commercial_CS12+" || Actual Popup value is : "+Commercialverify);
						Extent_pass_New(driver, "Matched || Expected Popup value is : "+verify_commercial_CS12+" || Actual Popup value is : "+Commercialverify, test,test1);
						click(driver, popup_Message_Ok_Button);
					} else {
						System.out.println("Not Matched || Expected Popup value is : "+verify_commercial_CS12+" || Actual Popup value is : "+Commercialverify);
						Extent_fail(driver,  "Not Matched || Expected Popup value is : "+verify_commercial_CS12+" || Actual Popup value is : "+Commercialverify, test,test1);
					}
				}else {
					if (Commercialverify.equals(Current_Verify_CS12)) {
						System.out.println("Matched || Expected Popup value is : "+Current_Verify_CS12+" || Actual Popup value is : "+Commercialverify);
						Extent_pass_New(driver, "Matched || Expected Popup value is : "+Current_Verify_CS12+" || Actual value was : "+Commercialverify, test,test1);
						click(driver, popup_Message_Ok_Button);
					} else {
						System.out.println("Not Matched || Expected Popup value is : "+Current_Verify_CS12+" || Actual Popup value is : "+Commercialverify);
						Extent_fail(driver,  "Not Matched || Expected Popup value is : "+Current_Verify_CS12+" || Actual Popup value is : "+Commercialverify, test,test1);
					}
				}
				Step_End(9, "System should show pop up as”Call type changed", test, test1);

				Step_Start(10, "If the Port Call is Changed From Commercial to Physical Call, the port font should be changed to Grey Color", test, test1);
				waitForElement(driver, Port_Icon);
				String Icon_color_Code = getTextColor(driver, Port_Icon);
				String Icon_color = getColorName(Icon_color_Code);
				
				if(Change_Call_Type_CS12.equals("Change Commercial to Physical")) {
					if (Icon_color.equals(graycolor_Voyage_CS12)) {
						System.out.println("Matched || Expected Physical Icon colour was : "+graycolor_Voyage_CS12+" || Actual  Icon colour was : "+Icon_color);
						Extent_pass_New(driver, "Matched || Expected Physical Icon colour was : "+graycolor_Voyage_CS12+" || Actual  Icon colour was : "+Icon_color, test,test1);
					} else {
						System.out.println("Not Matched || Expected Physical Icon colour was : "+graycolor_Voyage_CS12+" || Actual  Icon colour was : "+Icon_color);
						Extent_fail(driver,  "Not Matched || Expected Physical Icon colour was : "+graycolor_Voyage_CS12+" || Actual  Icon colour was : "+Icon_color, test,test1);
					}
					Step_End(10, "If the Port Call is Changed From Commercial to Physical Call, the port font should be changed to Grey Color", test, test1);
				}else if(Change_Call_Type_CS12.equals("Change Commercial to Canal")){

					Step_Start(11, "If the Port Call is Changed From Commercial to Canal Call, the port font should be changed to Dark Red Color and The font Style to be “ITALIC”", test, test1);
					if (Icon_color.equals(marooncolor_Voyage_CS12)) {
						System.out.println("Matched || Expected Canal Icon colour was : "+marooncolor_Voyage_CS12+" || Actual  Icon colour was : "+Icon_color);
						Extent_pass_New(driver, "Matched || Expected Canal Icon colour was : "+marooncolor_Voyage_CS12+" || Actual  Icon colour wass : "+Icon_color, test,test1);
					} else {
						System.out.println("Not Matched || Expected Canal Icon colour was : "+marooncolor_Voyage_CS12+" || Actual  Icon colour was : "+Icon_color);
						Extent_fail(driver,  "Not Matched || Expected Canal Icon colour was : "+marooncolor_Voyage_CS12+" ||  Icon colour was : "+Icon_color, test,test1);
					}
					Step_End(11, "If the Port Call is Changed From Commercial to Canal Call, the port font should be changed to Dark Red Color and The font Style to be “ITALIC”", test, test1);
				} else {
					System.out.println("Not Matched || The Icon colour is not changed");
					Extent_fail(driver,  "Not Matched || The Icon colour is not changed", test,test1);
				}

			} else {
				System.out.println("Not Matched || Expected Commerical Icon colour was : "+voyage_green_color_CS12+" || Actual  Icon colour was : "+icon_Colour+" || This call is not having a Commercial Status");
				Extent_fail(driver,  "Not Matched || Expected Commerical Icon colour was : "+voyage_green_color_CS12+" || Actual  Icon colour was : "+icon_Colour+" || This call is not having a Commercial Status", test,test1);
			}

		}
		else if(Change_Call_Type_CS12.equals("Change Canal to Commercial")||Change_Call_Type_CS12.equals("Change Canal to Physical")) {

			if (icon_Colour.equals(marooncolor_Voyage_CS12)) {
				System.out.println("Matched || Expected Canal Icon colour was : "+marooncolor_Voyage_CS12+" || Actual Icon colour was : "+icon_Colour);
				Extent_pass_New(driver, "Matched || Expected Canal Icon colour was : "+marooncolor_Voyage_CS12+" || Actual Icon colour was : "+icon_Colour, test,test1);
				waitForElement(driver, Port_Select);
				RightClick(driver, Port_Select);
				waitForElement(driver, call_Type_button);
				click(driver, call_Type_button);
				if(Change_Future_Voyages_CS12.equalsIgnoreCase("Yes")) {
					waitForElement(driver, Change_Future_Call_Type);
					click(driver, Change_Future_Call_Type);
				}else {
					waitForElement(driver, Change_Current_Call_Type);
					click(driver, Change_Current_Call_Type);
				}
				Step_Start(8, "Choose the Call to be Changed from Commercial/Physical/Canal", test, test1);
				waitForElement(driver, Call_Type_Select);
				click(driver, Call_Type_Select);
				Step_End(8, "Choose the Call to be Changed from Commercial/Physical/Canal", test, test1);

				Step_Start(9, "System should show pop up as”Call type changed", test, test1);
				waitForPopup(driver, popup_Message, verify_commercial_CS12);
				String Commercialverify = getText(driver, popup_Message);
				if(Change_Future_Voyages_CS12.equalsIgnoreCase("Yes")) {
					if (Commercialverify.equals(verify_commercial_CS12)) {
						System.out.println("Matched || Expected Popup value is : "+verify_commercial_CS12+" || Actual Popup value is : "+Commercialverify);
						Extent_pass_New(driver, "Matched || Expected Popup value is : "+verify_commercial_CS12+" || Actual Popup value is : "+Commercialverify, test,test1);
						click(driver, popup_Message_Ok_Button);
					} else {
						System.out.println("Not Matched || Expected Popup value is : "+verify_commercial_CS12+" || Actual Popup value is : "+Commercialverify);
						Extent_fail(driver,  "Not Matched || Expected Popup value is : "+verify_commercial_CS12+" || Actual Popup value is : "+Commercialverify, test,test1);
					}
				}else {
					if (Commercialverify.equals(Current_Verify_CS12)) {
						System.out.println("Matched || Expected Popup value is : "+Current_Verify_CS12+" || Actual Popup value is : "+Commercialverify);
						Extent_pass_New(driver, "Matched || Expected Popup value is : "+Current_Verify_CS12+" || Actual Popup value is : "+Commercialverify, test,test1);
						click(driver, popup_Message_Ok_Button);
					} else {
						System.out.println("Not Matched || Expected Popup value is : "+Current_Verify_CS12+" || Actual Popup value is : "+Commercialverify);
						Extent_fail(driver,  "Not Matched || Expected Popup value is : "+Current_Verify_CS12+" || Actual Popup value is : "+Commercialverify, test,test1);
					}
				}
				Step_End(9, "System should show pop up as”Call type changed", test, test1);
				waitForElement(driver, Port_Icon);
				String Icon_color_Code = getTextColor(driver, Port_Icon);
				String Icon_color = getColorName(Icon_color_Code);
				
				if(Change_Call_Type_CS12.equals("Change Canal to Commercial")) {
					if (Icon_color.equals(voyage_green_color_CS12)) {
						System.out.println("Matched || Expected Commerical Icon colour was : "+voyage_green_color_CS12+" || Actual  Icon colour was : "+Icon_color);
						Extent_pass_New(driver, "Matched || Expected Commerical Icon colour was : "+voyage_green_color_CS12+" || Actual  Icon colour was : "+Icon_color, test,test1);
					} else {
						System.out.println("Not Matched || Expected Commerical Icon colour was : "+voyage_green_color_CS12+" || Actual  Icon colour was : "+Icon_color);
						Extent_fail(driver,  "Not Matched || Expected Commerical Icon colour was : "+voyage_green_color_CS12+" || Actual  Icon colour was : "+Icon_color, test,test1);
					}
				}else if(Change_Call_Type_CS12.equals("Change Canal to Physical")){
					Step_Start(10, "If the Port Call is Changed From Commercial to Physical Call, the port font should be changed to Grey Color", test, test1);
					if (Icon_color.equals(graycolor_Voyage_CS12)) {
						System.out.println("Matched || Expected Physical Icon colour was : "+graycolor_Voyage_CS12+" || Actual  Icon colour was : "+Icon_color);
						Extent_pass_New(driver, "Matched || Expected Physical Icon colour was : "+graycolor_Voyage_CS12+" || Actual  Icon colour was : "+Icon_color, test,test1);
					} else {
						System.out.println("Not Matched || Expected Physical Icon colour was : "+graycolor_Voyage_CS12+" || Actual  Icon colour was : "+Icon_color);
						Extent_fail(driver,  "Not Matched || Expected Physical Icon colour was : "+graycolor_Voyage_CS12+" || Actual  Icon colour was : "+Icon_color, test,test1);
					}
				} else {
					System.out.println("Not Matched || The Icon colour is not changed");
					Extent_fail(driver,  "Not Matched || The Icon colour is not changed", test,test1);
				}
				Step_End(10, "If the Port Call is Changed From Commercial to Physical Call, the port font should be changed to Grey Color", test, test1);

			} else {
				Step_Start(11, "If the Port Call is Changed From Commercial to Canal Call, the port font should be changed to Dark Red Color and The font Style to be “ITALIC”", test, test1);
				System.out.println("Not Matched || Expected Canal Icon colour was : "+marooncolor_Voyage_CS12+" || Actual  Icon colour was : "+icon_Colour+" || This call is not having a Canal Status");
				Extent_fail(driver,  "Not Matched || Expected Canal Icon colour was : "+marooncolor_Voyage_CS12+" || Actual  Icon colour was : "+icon_Colour+" || This call is not having a Canal Status", test,test1);
			}
			Step_End(11, "If the Port Call is Changed From Commercial to Canal Call, the port font should be changed to Dark Red Color and The font Style to be “ITALIC”", test, test1);

		}else if(Change_Call_Type_CS12.equals("Change Physical to Commercial")||Change_Call_Type_CS12.equals("Change Physical to Canal")) {
			if (icon_Colour.equals(graycolor_Voyage_CS12)) {
				System.out.println("Matched || Expected Physical Icon colour was : "+graycolor_Voyage_CS12+" || Actual  Icon colour was : "+icon_Colour);
				Extent_pass_New(driver, "Matched || Expected Physical Icon colour was : "+graycolor_Voyage_CS12+" || Actual  Icon colour was : "+icon_Colour, test,test1);
				waitForElement(driver, Port_Select);
				RightClick(driver, Port_Select);
				waitForElement(driver, call_Type_button);
				click(driver, call_Type_button);
				if(Change_Future_Voyages_CS12.equalsIgnoreCase("Yes")) {
					waitForElement(driver, Change_Future_Call_Type);
					click(driver, Change_Future_Call_Type);
				}else {
					waitForElement(driver, Change_Current_Call_Type);
					click(driver, Change_Current_Call_Type);
				}
				Step_End(8, "Choose the Call to be Changed from Commercial/Physical/Canal", test, test1);
				waitForElement(driver, Call_Type_Select);
				click(driver, Call_Type_Select);
				Step_End(8, "Choose the Call to be Changed from Commercial/Physical/Canal", test, test1);

				Step_Start(9, "System should show pop up as”Call type changed", test, test1);
				waitForPopup(driver, popup_Message, verify_commercial_CS12);
				String Commercialverify = getText(driver, popup_Message);
				if(Change_Future_Voyages_CS12.equalsIgnoreCase("Yes")) {
					if (Commercialverify.equals(verify_commercial_CS12)) {
						System.out.println("Matched || Expected Popup value is : "+verify_commercial_CS12+" || Actual Popup value is : "+Commercialverify);
						Extent_pass_New(driver, "Matched || Expected Popup value is : "+verify_commercial_CS12+" || Actual Popup value is : "+Commercialverify, test,test1);

						click(driver, popup_Message_Ok_Button);
					} else {
						System.out.println("Not Matched || Expected Popup value is : "+verify_commercial_CS12+" || Actual Popup value is : "+Commercialverify);
						Extent_fail(driver,  "Not Matched || Expected Popup value is : "+verify_commercial_CS12+" || Actual Popup value is : "+Commercialverify, test,test1);
					}

				}else {
					if (Commercialverify.equals(Current_Verify_CS12)) {
						System.out.println("Matched || Expected Popup value is : "+Current_Verify_CS12+" || Actual Popup value is : "+Commercialverify);
						Extent_pass_New(driver, "Matched || Expected Popup value is : "+Current_Verify_CS12+" || Actual Popup value is : "+Commercialverify, test,test1);
						click(driver, popup_Message_Ok_Button);
					} else {
						System.out.println("Not Matched || Expected Popup value is : "+Current_Verify_CS12+" || Actual Popup value is : "+Commercialverify);
						Extent_fail(driver,  "Not Matched || Expected Popup value is : "+Current_Verify_CS12+" || Actual Popup value is : "+Commercialverify, test,test1);
					}
				}
				Step_End(9, "System should show pop up as”Call type changed", test, test1);

				waitForElement(driver, Port_Icon);
				String Icon_color_Code = getTextColor(driver, Port_Icon);
				String Icon_color = getColorName(Icon_color_Code);
				if(Change_Call_Type_CS12.equals("Change Physical to Commercial")) {
					if (Icon_color.equals(voyage_green_color_CS12)) {
						System.out.println("Matched || Expected Commerical Icon colour was : "+voyage_green_color_CS12+" || Actual  Icon colour was : "+Icon_color);
						Extent_pass_New(driver, "Matched || Expected Commerical Icon colour was : "+voyage_green_color_CS12+" || Actual  Icon colour was : "+Icon_color, test,test1);
					} else {
						System.out.println("Not Matched || Expected Commerical Icon colour was : "+voyage_green_color_CS12+" || Actual  Icon colour was : "+Icon_color);
						Extent_fail(driver,  "Not Matched || Expected Commerical Icon colour was : "+voyage_green_color_CS12+" || Actual  Icon colour was : "+Icon_color, test,test1);
					}
				}else if(Change_Call_Type_CS12.equals("Change Physical to Canal")){

					if (Icon_color.equals(marooncolor_Voyage_CS12)) {
						Step_Start(11, "If the Port Call is Changed From Commercial to Canal Call, the port font should be changed to Dark Red Color and The font Style to be “ITALIC”", test, test1);
						System.out.println("Matched || Expected Canal Icon colour was : "+marooncolor_Voyage_CS12+" || Actual  Icon colour was : "+Icon_color);
						Extent_pass_New(driver, "Matched || Expected Canal Icon colour was : "+marooncolor_Voyage_CS12+" || Actual  Icon colour was : "+Icon_color, test,test1);
					} else {
						System.out.println("Not Matched || Expected Canal Icon colour was : "+marooncolor_Voyage_CS12+" || Actual  Icon colour was : "+Icon_color);
						Extent_fail(driver,  "Not Matched || Expected Canal Icon colour was : "+marooncolor_Voyage_CS12+" || Actual  Icon colour was : "+Icon_color, test,test1);
					}
					Step_End(11, "If the Port Call is Changed From Commercial to Canal Call, the port font should be changed to Dark Red Color and The font Style to be “ITALIC”", test, test1);
				} else {
					System.out.println("Not Matched || The Icon colour is not changed");
					Extent_fail(driver,  "Not Matched || The Icon colour is not changed", test,test1);
				}
			} else {
				Step_Start(10, "If the Port Call is Changed From Commercial to Physical Call, the port font should be changed to Grey Color", test, test1);
				System.out.println("Not Matched || Expected Physical Icon colour was : "+graycolor_Voyage_CS12+" || Actual  Icon colour was : "+icon_Colour+" || This call is not having a Physical Status");
				Extent_fail(driver,  "Not Matched || Expected Physical Icon colour was : "+graycolor_Voyage_CS12+" || Actual  Icon colour was : "+icon_Colour+" || This call is not having a Physical Status", test,test1);
			}
			Step_End(10, "If the Port Call is Changed From Commercial to Physical Call, the port font should be changed to Grey Color", test, test1);
		}else {
			System.out.println("Not Matched || Expected call was not selected");
			Extent_fail(driver,  "Not Matched || Expected call was not selected", test,test1);
		}

		Extent_completed(testCaseName, test, test1);

	}

}
