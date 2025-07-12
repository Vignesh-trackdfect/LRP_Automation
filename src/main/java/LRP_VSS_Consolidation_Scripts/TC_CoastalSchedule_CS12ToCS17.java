package LRP_VSS_Consolidation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;
import commonMethods.TestNgXml;
import commonMethods.Utils;
import locators.Coastal_Schedule_Locators;

public class TC_CoastalSchedule_CS12ToCS17 extends Keywords {
	public static String Remark_Type_CS13;
	public static String ServiceCode_CS13;
	public static String VesselCode_CS13;
	public static String voyageNumber_CS13;
	public static String portName_CS13;
	public static String remark_Button_CS13;
	public static String Copy_Button;
	public static String ServiceCode_CS16;
	public static String VesselCode_CS16;
	public static String voyageNumber_CS16;
	public static String paste_Button_CS15;
	public static String Cycle_Number_Input;
	public static String Voyage_Number_Inputs;


	public void CoastalSchedule12To17(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset) {
		
		int i =1;
		if(i==1) {
			String testCaseName="TC_Coastal_Schedule_CS12";
			String File_Path_CS12 = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_CS12 = TestNgXml.getsheetName_FromExecution().get(testCaseName);	
			String url = TestNgXml.getdatafromExecution().get(testCaseName);
			Map<String, String> Excel_data_12 = Utils.GetAllData(Sheet_Name_CS12, testCaseName, "Dataset"+selected_dataset, File_Path_CS12);

			String Change_Call_Type_CS12 =Excel_data_12.get( "Change_Call_Type");
			String voyage_green_color_CS12 =Excel_data_12.get( "voyage_greencolor");
			String marooncolor_Voyage_CS12 =Excel_data_12.get( "Voyage_marooncolor");
			String verify_commercial_CS12 =Excel_data_12.get( "Commerical_Verify");
			String graycolor_Voyage_CS12 =Excel_data_12.get( "Voyage_graycolor");
			String Current_Verify_CS12 =Excel_data_12.get("Current_Verify_CS12");
			String Change_Future_Voyages_CS12 = Excel_data_12.get("Change_Future_Voyages");
			String Username_CS12 =Excel_data_12.get("Username");
			String Password_CS12 =Excel_data_12.get("Password");
			String ModuleSearch_CS12 =Excel_data_12.get("Module_Search");
			String ServiceCode_CS12 =Excel_data_12.get("Service_Code"); 
			String VesselCode_CS12 =Excel_data_12.get("Vessel_Code");
			String voyageNumber_CS12 =Excel_data_12.get("Voyage_Number");
			String portName_CS12 =Excel_data_12.get("Port_Name");
			String Change_Call_Type =Excel_data_12.get("Button");

			String condition = Excel_data_12.get("Condition");
			String service_Search_Header = Excel_data_12.get("Service_Search_Header");
			String vessel_Search_Header = Excel_data_12.get("Vessel_Search_Header");
			
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


			scrollTop(driver);

		Extent_completed(testCaseName, test, test1);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCaseName="TC_Coastal_Schedule_CS13";
			String File_Path_CS13 = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_CS13 = TestNgXml.getsheetName_FromExecution().get(testCaseName);	
			Map<String, String> Excel_data_13 = Utils.GetAllData(Sheet_Name_CS13, testCaseName, "Dataset"+selected_dataset, File_Path_CS13);

			String Remark_Type_CS13 = Excel_data_13.get("Remark_Type");
			String Remark_Input_CS13 = Excel_data_13.get("Remark_Input");
			String move_coastal_CS13 = Excel_data_13.get("Moveto_Coastal");
			String remark_updated_CS13 = Excel_data_13.get("Remark_Updated");
			String ModuleSearch_CS13 =Excel_data_13.get("Module_Search");
			String ServiceCode_CS13 =Excel_data_13.get("Service_Code"); 
			String VesselCode_CS13 =Excel_data_13.get("Vessel_Code");
			String voyageNumber_CS13 =Excel_data_13.get("Voyage_Number");
			String portName_CS13 =Excel_data_13.get("Port_Name");
			String remark_Button_CS13 =Excel_data_13.get("Button");
			String Phase_Out_Popup =Excel_data_13.get("Phase_Out_Popup");
			String condition = Excel_data_13.get("Condition");
			String service_Search_Header = Excel_data_13.get("Service_Search_Header");
			String vessel_Search_Header = Excel_data_13.get("Vessel_Search_Header");

			String Voyage_Toggler = String.format(Coastal_Schedule_Locators.Voyage_Toggler, voyageNumber_CS13);
			String port_Select = String.format(Coastal_Schedule_Locators.port_Select, voyageNumber_CS13,portName_CS13);
			String button_Select =  String.format(Coastal_Schedule_Locators.button_Select, remark_Button_CS13);
			String remark_Type_Select =  String.format(Coastal_Schedule_Locators.remark_Type_Select, Remark_Type_CS13);


			Extent_Start(testCaseName, test, test1);

			
			moduleNavigate(driver, ModuleSearch_CS13);


			Step_Start(1, "Enter the Service Code  in the service code field", test, test1);
			
			waitForElement(driver, Service_Search_Btn);
			click(driver, Service_Search_Btn);
			
			twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS13);
			

			Step_End(1, "Enter the Service Code  in the service code field", test, test1);

			waitForElement(driver, Vessel_Search_Btn);
			click(driver, Vessel_Search_Btn);

			twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS13);

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
			waitForElement(driver, Voyage_Toggler);
			String status = getAttribute(driver, Voyage_Toggler, "class");

			if(!status.contains("s")) {
				waitForElement(driver, Voyage_Toggler);
				click(driver, Voyage_Toggler);
			}

			Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);

			Step_Start(4, "Choose the Port from the voyage where the Remarks to be added", test, test1);
			Step_Start(5, "Right click on it ", test, test1);
			waitForElement(driver, port_Select);
			click(driver, port_Select);
			waitForElement(driver, port_Select);
			RightClick(driver, port_Select);
			Step_End(5, "Right click on it ", test, test1);

			waitForElement(driver, button_Select);
			click(driver, button_Select);

			Step_End(4, "Choose the Port from the voyage where the Remarks to be added", test, test1);

			Step_Start(6, "Choose Remarks option", test, test1);
			waitForElement(driver, remark_Type_Select);
			click(driver, remark_Type_Select);
			Step_End(6, "Choose Remarks option", test, test1);

			Step_Start(7, "Enter the Remarks in the Field", test, test1);
			Step_Start(8, "Click on Add Button", test, test1);
			if(Remark_Type_CS13.equals("Normal Remarks")) {
				waitForElement(driver, Remarks_field);
				click(driver,Remarks_field);
				waitForElement(driver, Remarks_field);
				sendKeys(driver, Remarks_field, Remark_Input_CS13);
				waitForElement(driver, Remarks_addbtn);
				click(driver, Remarks_addbtn);

			}else if(Remark_Type_CS13.equals("Phase In Remarks")) {
				waitForElement(driver, PhaseIn_Field);
				click(driver,PhaseIn_Field);
				waitForElement(driver, PhaseIn_Field);
				sendKeys(driver, PhaseIn_Field, Remark_Input_CS13);
				waitForElement(driver, PhaseIn_Add);
				click(driver, PhaseIn_Add);

			}else {
				waitForElement(driver, PhaseOut_Field);
				click(driver,PhaseOut_Field);
				waitForElement(driver, PhaseOut_Field);
				sendKeys(driver, PhaseOut_Field, Remark_Input_CS13);
				waitForElement(driver, PhaseOut_Add);
				click(driver, PhaseOut_Add);
			}

			Step_End(7, "Enter the Remarks in the Field", test, test1);
			Step_End(8, "Click on Add Button", test, test1);

			Step_Start(9, "Click on Move to Coastal button", test, test1);
			waitForDisplay(driver, popup_Message);
			if(isdisplayed(driver, popup_Message)) {
				String Phase_Out=getText(driver, popup_Message);
				System.out.println("Matched || Expected Popup : "+Phase_Out_Popup+" || Actual Popup : "+Phase_Out);
				Extent_pass_New(driver, "Matched || Expected Popup : "+Phase_Out_Popup+" || Actual Popup : "+Phase_Out, test,test1);
				click(driver, popup_Message_Ok_Button);
			}else {
				waitForElement(driver, moveto_coastal);
				click(driver,moveto_coastal);

				waitForPopup(driver, popup_Message, move_coastal_CS13);
				String Move_Coastal= getText(driver, popup_Message);

				if(Move_Coastal.equals(move_coastal_CS13)) {
					System.out.println("Matched || Expected Popup : "+move_coastal_CS13+" || Actual Popup : "+Move_Coastal);
					Extent_pass_New(driver, "Matched || Expected Popup : "+move_coastal_CS13+" || Actual Popup : "+Move_Coastal, test,test1);
				}else {
					System.out.println("NotMatched || Expected Popup : "+move_coastal_CS13+" || Actual Popup : "+Move_Coastal);
					Extent_fail(driver,  "NotMatched || Expected Popup : "+move_coastal_CS13+" || Actual Popup : "+Move_Coastal, test,test1);
				}  

				click(driver,popup_Message_Yes_Button);
				Step_End(9, "Click on Move to Coastal button", test, test1);

				Step_Start(10, "System should add the remarks in the grid of the voyage", test, test1);

				waitForPopup(driver, popup_Message, remark_updated_CS13);
				String Updated_Remark= getText(driver, popup_Message);

				if(Updated_Remark.equals(remark_updated_CS13)) {
					System.out.println("Matched || Expected Popup : "+remark_updated_CS13+" || Actual Popup : "+Updated_Remark);
					Extent_pass_New(driver, "Matched || Expected Popup : "+remark_updated_CS13+" || Actual Popup : "+Updated_Remark, test,test1);
				}else {
					System.out.println("NotMatched || Expected Popup : "+remark_updated_CS13+" || Actual Popup : "+Updated_Remark);
					Extent_fail(driver,  "NotMatched || Expected Popup : "+remark_updated_CS13+" || Actual Popup : "+Updated_Remark, test,test1);
				}  

				Step_End(10, "System should add the remarks in the grid of the voyage", test, test1);

				click(driver,popup_Message_Ok_Button);
			}
			scrollTop(driver);

		Extent_completed(testCaseName, test, test1);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCaseName="TC_Coastal_Schedule_CS14";
			String File_Path_CS14 = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_CS14 = TestNgXml.getsheetName_FromExecution().get(testCaseName);
			Map<String, String> Excel_data = Utils.GetAllData(Sheet_Name_CS14, testCaseName, "Dataset"+selected_dataset, File_Path_CS14);
			
			String Portcode = Excel_data.get( "Portcode");
			String Change_BoundsValue = Excel_data.get( "Change_BoundValue");
			String voyage_valuefield = Excel_data.get( "voyage_fieldvalue");
			String distance_valuefield = Excel_data.get( "Distance_Value");
			String speed_valuefield = Excel_data.get( "Speed_Value");
			String buffer_valuefield = Excel_data.get( "Buffer_Value");
			String Mantimein_Valuefield = Excel_data.get( "Mantimein_Value");
			String Mantimeout_Valuefield = Excel_data.get( "Mantimeout_Value");
			String Terminaltime_Valuefield = Excel_data.get( "Terminaltime_Value");
			String Move_Coastal_schedule = Excel_data.get( "Move_Coastalschedule");
			String Voyage_Saved = Excel_data.get( "Voyage_saved");
			String ModuleSearch_CS14 =Excel_data.get("Module_Search");
			String ServiceCode_CS14 =Excel_data.get("Service_Code");
			String VesselCode_CS14 =Excel_data.get("Vessel_Code");
			String voyageNumber_CS14 =Excel_data.get("Voyage_Number");
			String add_Button_CS14 =Excel_data.get("Button");
			String condition = Excel_data.get("Condition");
			String service_Search_Header = Excel_data.get("Service_Search_Header");
			String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");
			String Voyage_Start_Date = Excel_data.get("Voyage_Start_Date");
			String Voyage_Start_Date_Perform = Excel_data.get("Voyage_Start_Date_Perform");

			String TerminalCodes = Excel_data.get("TerminalCodes");
			String TimeZone_Values = Excel_data.get("TimeZone_Values");
			String Marine_Distance = Excel_data.get("Marine_Distance");


			String Voyage =  String.format(Coastal_Schedule_Locators.Voyage_Selec, voyageNumber_CS14);
			String button_Select =  String.format(Coastal_Schedule_Locators.button_Select, add_Button_CS14);

			Extent_Start(testCaseName, test, test1);

			moduleNavigate(driver, ModuleSearch_CS14);

			Step_Start(1, "Enter the Service Code  in the service code field", test, test1);

			waitForElement(driver, Service_Search_Btn);
			click(driver, Service_Search_Btn);
			
			twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS14);
			
			Step_End(1, "Enter the Service Code  in the service code field", test, test1);

			Step_Start(2, "Enter the Vessel ", test, test1);
			
			waitForElement(driver, Vessel_Search_Btn);
			click(driver, Vessel_Search_Btn);

			twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS14);
			
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

			Step_Start(4, "Click on Any voyage ", test, test1);
			waitForElement(driver, Voyage);
			click(driver, Voyage);
			Step_End(4, "Click on Any voyage ", test, test1);

			Step_Start(5, "Right Click on it ", test, test1);
			waitForElement(driver, Voyage);
			RightClick(driver, Voyage);
			Step_End(5, "Right Click on it ", test, test1);

			Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);

			Step_Start(6, "Choose Add voyage option", test, test1);
			waitForElement(driver, button_Select);
			click(driver, button_Select);
			Step_End(6, "Choose Add voyage option", test, test1);

			Step_Start(7, "Add Voyage Window appears", test, test1);
			Step_Start(8, "Enter the voyage number in the field ", test, test1);
			waitForElement(driver, voyage_field);
			click(driver, voyage_field);
			sendKeys(driver, voyage_field, voyage_valuefield);

			if(Voyage_Start_Date_Perform.equalsIgnoreCase("Yes")) {
				selectDatePickerWith_Time(driver, voyage_Start_Date, Voyage_Start_Date);
			}
			
			Step_End(8, "Enter the voyage number in the field ", test, test1);
			List<String> port_Codes = splitAndExpand(Portcode,",");

			List<String> terminalCodes = splitAndExpand(TerminalCodes,",");

			List<String> distance_valuefields = splitAndExpand(distance_valuefield,",");
			List<String> speed_valuefields = splitAndExpand(speed_valuefield,",");
			List<String> Change_BoundsValues = splitAndExpand(Change_BoundsValue,",");
			List<String> buffer_valuefields = splitAndExpand(buffer_valuefield,",");
			List<String> Mantimein_Valuefields = splitAndExpand(Mantimein_Valuefield,",");
			List<String> Mantimeout_Valuefields = splitAndExpand(Mantimeout_Valuefield,",");
			List<String> Terminaltime_Valuefields = splitAndExpand(Terminaltime_Valuefield,",");
			for(int j = 0;j<port_Codes.size();j++) {
			Step_Start(9, "Enter the Port Code in the port field ", test, test1);
			waitForElement(driver, port_field);
			click(driver, port_field);
			String portCode=port_Codes.get(j);
			sendKeys(driver, port_field, portCode);
			
			String TerminalCode=terminalCodes.get(j);
			String select_Port_Terminal=String.format(Port_Terminal_Select, portCode,TerminalCode);
			waitForElement(driver, select_Port_Terminal);
			click(driver, select_Port_Terminal);
			
			Step_End(9, "Enter the Port Code in the port field ", test, test1);
			
			
			Actions action = new Actions(driver);
			
			Step_Start(10, "Enter the Distance field value", test, test1);
			waitForElement(driver, Distance_field);
			click(driver, Distance_field_input);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(distance_valuefields.get(j)).perform();
			Step_End(10, "Enter the Distance field value", test, test1);

			Step_Start(11, "Enter the Speed Field value ", test, test1);
			waitForElement(driver, Speed_value);
			click(driver, Speed_value_input);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(speed_valuefields.get(j)).perform();
			
			
			waitForElement(driver, Timezonefield);
			String port1timezonevalue = getAttribute(driver, Timezonefield, "value");
			System.out.println("timezonevalue :" + port1timezonevalue);

			if(!TimeZone_Values.equals("")) {
				List<String> timeZone_Values = splitAndExpand(TimeZone_Values,",");
				String TimeZone=timeZone_Values.get(j);
				clearAndType(driver, Timezonefield, TimeZone);
			}
			
			waitForElement(driver, sub_bound_dropdown);
			click(driver, sub_bound_dropdown);
			Step_End(11, "Enter the Speed Field value ", test, test1);

			Step_Start(12, "Enter the Bound value from the drop-down", test, test1);
			Extent_call(test, test1, "If the Bound is Pivot Enter the Pivot Voyage number ");
			String Bound_Value =  String.format(Coastal_Schedule_Locators.Bound_Value, Change_BoundsValues.get(j));
			waitForElement(driver, Bound_Value);
			click(driver, Bound_Value);
			waitForElement(driver, Added_Bound_Value);
			String bound1Dropdownoption=getText(driver, Added_Bound_Value);
			System.out.println(bound1Dropdownoption);
			if (bound1Dropdownoption.equals( Change_BoundsValues.get(j))) {
				System.out.println("Matched || Expected value was : " + Change_BoundsValues.get(j) + " || Actual value was : "+ bound1Dropdownoption);
				Extent_pass_New(driver, "Matched || Expected value was : " + Change_BoundsValues.get(j) + " || Actual value was : "+ bound1Dropdownoption, test,test1);
			} else {
				System.out.println("NotMatched || Expected value was : " + Change_BoundsValues.get(j)+ " || Actual value was : " + bound1Dropdownoption);
				Extent_fail(driver, "NotMatched || Expected value was : " + Change_BoundsValues.get(j)+ " || Actual value was : " + bound1Dropdownoption, test,test1);
			}
			Step_End(12, "Enter the Bound value from the drop-down", test, test1);


			Step_Start(14, "Enter the Buffer time ", test, test1);
			waitForElement(driver, buffer_timefield_input);
			click(driver, buffer_timefield);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(buffer_valuefields.get(j)).perform();
			
			Step_End(14, "Enter the Buffer time ", test, test1);

			Step_Start(15, ".Enter Man Time in field", test, test1);
			waitForElement(driver, Mantimein_field_input);
			click(driver, Mantimein_field_input);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(Mantimein_Valuefields.get(j)).perform();
			
			Step_End(15, ".Enter Man Time in field", test, test1);

			Step_Start(16, "Enter Man Time out field", test, test1);
			waitForElement(driver, Mantimeout_field_input);
			click(driver, Mantimeout_field_input);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(Mantimeout_Valuefields.get(j)).perform();
			
			Step_End(16, "Enter Man Time out field", test, test1);

			Step_Start(17, "Enter the Terminal Time Field", test, test1);
			waitForElement(driver, Terminaltime_field);
			click(driver, Terminaltime_field);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(Terminaltime_Valuefields.get(j)).perform();
			
			Step_End(17, "Enter the Terminal Time Field", test, test1);

			Step_Start(18, "Click on Add Button", test, test1);
			waitForElement(driver, Addvoyage);
			click(driver, Addvoyage);
			Step_End(18, "Click on Add Button", test, test1);

			waitForDisplay(driver, popup_Message);
			if (isdisplayed(driver, popup_Message)) {
				click(driver, popup_Message_Yes_Button);
			}
			Step_Start(19, "System should add the Port Details in the Port Grid", test, test1);

			if (formatLocatorIsDisplayed(driver, Added_Port_Value, port_Codes.get(j))) {
				System.out.println("Matched || Expected The Port Should be Added || Actual Port is added the port value is : " + port_Codes.get(j));
				Extent_pass_New(driver,"Matched || Expected The Port Should be Added || Actual Port is added the port value is : " + port_Codes.get(j), test,test1);
			} else {
				System.out.println("Matched || Expected The Port Should be Added || Actual Port is Not added ");
				Extent_fail(driver,"Matched || Expected The Port Should be Added || Actual Port is Not added ",test,test1);
			}
		}

			Step_End(19, "System should add the Port Details in the Port Grid", test, test1);

			Step_Start(20, "Time zone Should be captured from the Port Master for the Port added", test, test1);

			Step_End(21, "Repear the process from Step 9 - Step 19", test, test1);

			Step_Start(22, "Click on Move to Coastal Schedule button ", test, test1);
			waitForElement(driver, Movetocoastalschedule);
			click(driver, Movetocoastalschedule);
			Step_End(22, "Click on Move to Coastal Schedule button ", test, test1);

			Step_Start(23, "System should show Confirmation message  ”Are you sure to move to Coastal Schedule ?”", test, test1);
			waitForPopup(driver, popup_Message, Move_Coastal_schedule);
			String Costalschedule_Popupmessage = getText(driver, popup_Message);
			if (Costalschedule_Popupmessage.equals(Move_Coastal_schedule)) {
				System.out.println("Matched || Expected Popup : " + Move_Coastal_schedule + " || Actual Popup : "
						+ Costalschedule_Popupmessage);
				Extent_pass_New(driver, "Matched || Expected Popup : " + Move_Coastal_schedule + " || Actual Popup : "
						+ Costalschedule_Popupmessage, test,test1);
			} else {
				System.out.println("NotMatched || Expected Popup : " + Move_Coastal_schedule + " || Actual Popup : "
						+ Costalschedule_Popupmessage);
				Extent_fail(driver, "NotMatched || Expected Popup : " + Move_Coastal_schedule
						+ " || Actual Popup : " + Costalschedule_Popupmessage, test,test1);
			}
			Step_End(23, "System should show Confirmation message  ”Are you sure to move to Coastal Schedule ?”", test, test1);
			Step_Start(24, "Click on Yes", test, test1);
			click(driver, popup_Message_Yes_Button);
			
			waitForDisplay(driver, marineDistance_Gridcell_CS);
			if(isdisplayed(driver, marineDistance_Gridcell_CS)) {
				click(driver, marineDistance_Gridcell_CS);
				waitForElement(driver, marineDistance_Gridcell_Input_CS);
				clearAndType(driver, marineDistance_Gridcell_Input_CS, Marine_Distance);
				enter(driver);
				waitForElement(driver, marineDistance_Ok_Button_CS);
				click(driver, marineDistance_Ok_Button_CS);

				waitForElement(driver, popup_Message_Yes_Button);
				click(driver, popup_Message_Yes_Button);
			}
			
			Step_End(24, "Click on Yes", test, test1);
			waitForPopup(driver, popup_Message, Voyage_Saved);
			String Costalschedule_addedpopupmessage = getText(driver, popup_Message);
			System.out.println("Costal schedule added popup message was : " + Costalschedule_addedpopupmessage);
			if (Costalschedule_addedpopupmessage.equals(Voyage_Saved)) {
				System.out.println("Matched || Expected Popup : " + Voyage_Saved + " || Actual Popup : "+ Costalschedule_addedpopupmessage);
				Extent_pass_New(driver, "Matched || Expected Popup : " + Voyage_Saved + " || Actual Popup : "+ Costalschedule_addedpopupmessage, test,test1);
			} else {
				System.out.println("Not Matched || Expected Popup : " + Voyage_Saved + " || Actual Popup : "+ Costalschedule_addedpopupmessage);
				Extent_fail(driver, "Not Matched || Expected Popup : " + Voyage_Saved + " || Actual Popup : "+ Costalschedule_addedpopupmessage, test,test1);
			}
			click(driver, popup_Message_Ok_Button);
			Step_Start(25, "System should add the voyage with the cycle number incremented with the preivous last voyage in the vessel", test, test1);
			waitForElement(driver, Last_Added_Voyage_name);
			String Addedvoyagename = getText(driver, Last_Added_Voyage_name);
			System.out.println("Added voyage name was : " + Addedvoyagename);
			if (Addedvoyagename.contains(voyage_valuefield) ) {
				System.out.println("Matched || Added voyage sequence number was next to the previous voyage sequence number");
				Extent_pass_New(driver, "Matched || Added voyage sequence number was next to the previous voyage sequence number", test,test1);

			} else {
				System.out.println("Not Matched || Added voyage sequence number was not next to the previous voyage sequence number");
				Extent_fail(driver, "Not Matched || Added voyage sequence number was not next to the previous voyage sequence number",test,test1);
			}
			Step_End(25, "System should add the voyage with the cycle number incremented with the preivous last voyage in the vessel", test, test1);
			
Extent_completed(testCaseName, test, test1);
scrollTop(driver);

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCaseName="TC_Coastal_Schedule_CS15";
			String File_Path_CS15 = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_CS15 = TestNgXml.getsheetName_FromExecution().get(testCaseName);	
			Map<String, String> Excel_data_15 = Utils.GetAllData(Sheet_Name_CS15, testCaseName, "Dataset"+selected_dataset, File_Path_CS15);

			String Exist_Popup_CS15 = Excel_data_15.get("Exist_Popup");
			String New_Vessel_Name_CS15 = Excel_data_15.get("New_Vessel_Name");
			String paste_Button_CS15 = Excel_data_15.get("paste_Button");
			String Pasted_Popup_CS15 = Excel_data_15.get("Pasted_Popup");
			String date_Picker= Excel_data_15.get("date_Picker");
			String Voyage_Date= Excel_data_15.get("Voyage_Date");
			String Cycle_Number_Input_CS15= Excel_data_15.get("Cycle_Number_Input");
			String Voyage_Number_Inputs_CS15= Excel_data_15.get("Voyage_Number_Inputs");
			String ModuleSearch_CS15 =Excel_data_15.get("Module_Search");
			String ServiceCode_CS15 =Excel_data_15.get("Service_Code");
			String VesselCode_CS15 =Excel_data_15.get("Vessel_Code");
			String voyageNumber_CS15 =Excel_data_15.get("Voyage_Number");
			String Copy_Button_CS15 =Excel_data_15.get("Copy_Button");
			String Copied_Popup_CS15 =Excel_data_15.get("Copied_Popup");
			String add_Button_CS15 =Excel_data_15.get("Button");
			
			String condition = Excel_data_15.get("Condition");
			String service_Search_Header = Excel_data_15.get("Service_Search_Header");
			String vessel_Search_Header = Excel_data_15.get("Vessel_Search_Header");
			
			String Voyage =  String.format(Coastal_Schedule_Locators.Voyage_New, voyageNumber_CS15);
			String Paste_Button =  String.format(Coastal_Schedule_Locators.Paste_Button, paste_Button_CS15);
			String add_Vessel_CS15 =  String.format(Coastal_Schedule_Locators.add_Vessel_CS15, add_Button_CS15);
			String Vessel =  String.format(Coastal_Schedule_Locators.Vessel, VesselCode_CS15);
			String New_Vessel =  String.format(Coastal_Schedule_Locators.New_Vessel, New_Vessel_Name_CS15);
			String copy_Button =  String.format(Coastal_Schedule_Locators.copy_Button, Copy_Button_CS15);

			Extent_Start(testCaseName, test, test1);

			moduleNavigate(driver, ModuleSearch_CS15);


			Step_Start(1, "Enter the Service Code  in the service code field", test, test1);

			waitForElement(driver, Service_Search_Btn);
			click(driver, Service_Search_Btn);
			
			twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS15);


			Step_End(1, "Enter the Service Code  in the service code field", test, test1);

			Step_Start(2, "Enter the Vessel ", test, test1);

			waitForElement(driver, Vessel_Search_Btn);
			click(driver, Vessel_Search_Btn);

			twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS15);

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
			waitForElement(driver, Voyage);
			click(driver, Voyage);

			Step_Start(4, "Click on Vessel", test, test1);
			waitForElement(driver, Vessel);
			click(driver, Vessel);
			Step_End(4, "Click on Vessel", test, test1);

			Step_Start(5, "Right click on it", test, test1);
			waitForElement(driver, Vessel);
			RightClick(driver, Vessel);
			Step_End(5, "Right click on it", test, test1);

			Step_Start(6, "Choose Add Vessel Option", test, test1);
			waitForElement(driver, add_Vessel_CS15);
			click(driver, add_Vessel_CS15);
			waitForElement(driver, AddVesselBox);
			
			Step_End(6, "Choose Add Vessel Option", test, test1);

			Step_Start(7, "Enter Vessel to be added ", test, test1);
			waitForElement(driver, AddVessel_Search_Button);
			click(driver, AddVessel_Search_Button);

			twoColumnSearchWindow(driver, vessel_Search_Header, condition, New_Vessel_Name_CS15);

			waitForElement(driver, Add_Vessel_ok);
			click(driver, Add_Vessel_ok);
			
			Step_End(7, "Enter Vessel to be added ", test, test1);

			Step_Start(8, "If the Vessel is already presented under the same service , system should show validation as “Vessel Code already exisits”", test, test1);
			waitForDisplay(driver, popup_Message);
			if(isdisplayed(driver, popup_Message)) {
				String popup = getText(driver, popup_Message);
				if (Exist_Popup_CS15.equals(popup)) {
					System.out.println("Matched || Expected Popup Message was : "+Exist_Popup_CS15+" || Actual Popup Message was : "+popup);
					Extent_pass_New(driver, "Matched || Expected Popup Message was : "+Exist_Popup_CS15+" || Actual Popup Message was : "+popup, test,test1);
				}else {
					System.out.println("NotMatched || Expected Popup Message was : "+Exist_Popup_CS15+" || Actual Popup Message was : "+popup);
					Extent_fail(driver,  "NotMatched || Expected Popup Message was : "+Exist_Popup_CS15+" || Actual Popup Message was : "+popup, test,test1);

				}
				Step_End(8, "If the Vessel is already presented under the same service , system should show validation as “Vessel Code already exisits”", test, test1);

				Step_Start(9, "Click on Ok", test, test1);
				
				click(driver,popup_Message_Ok_Button);
				
				Step_End(9, "Click on Ok", test, test1);
			}else {

				Step_Start(10, "Add the voyage using Add voyage option or Copy paste voyage from the another vessel", test, test1);
				waitForElement(driver, Voyage);
				click(driver, Voyage);
				waitForElement(driver, Voyage);
				RightClick(driver, Voyage);
				waitForElement(driver, copy_Button);
				click(driver, copy_Button);
				Step_End(10, "Add the voyage using Add voyage option or Copy paste voyage from the another vessel", test, test1);

				waitForPopup(driver, popup_Message, Copied_Popup_CS15);
				String popup_Msg = getText(driver, popup_Message);
				if (Copied_Popup_CS15.equals(popup_Msg)) {
					System.out.println("Matched || Expected Popup Message was : "+Copied_Popup_CS15+" || Actual Popup Message was : "+popup_Msg);
					Extent_pass_New(driver, "Matched || Expected Popup Message was : "+Copied_Popup_CS15+" || Actual Popup Message was : "+popup_Msg, test,test1);
				}else {
					System.out.println("NotMatched || Expected Popup Message was : "+Copied_Popup_CS15+" || Actual Popup Message was : "+popup_Msg);
					Extent_fail(driver,  "NotMatched || Expected Popup Message was : "+Copied_Popup_CS15+" || Actual Popup Message was : "+popup_Msg, test,test1);
				}
				click(driver,popup_Message_Ok_Button);
				waitForElement(driver, Tree_Structure);
				waitForElement(driver, New_Vessel);
				click(driver, New_Vessel);

				waitForElement(driver, New_Vessel);
				RightClick(driver, New_Vessel);

				waitForElement(driver, Paste_Button);
				click(driver, Paste_Button);
				waitForElement(driver, Cycle_Number_Field);
				clearAndType(driver, Cycle_Number_Field, Cycle_Number_Input_CS15);
				waitForElement(driver, Voyage_Number_Field);
				clearAndType(driver, Voyage_Number_Field, Voyage_Number_Inputs_CS15);

				waitForElement(driver, Arrival_Pilot_Date);
				if(date_Picker.equalsIgnoreCase("Yes")) {
					
					selectDatePickerWithTime(driver, Arrival_Pilot_Date, Voyage_Date);
					
					waitForElement(driver, Cycle_Number_Field);
					click(driver, Cycle_Number_Field);
				}else {
					waitForElement(driver, Arrival_Pilot_Date);
					clearAndType(driver, Arrival_Pilot_Date,Voyage_Date);
					waitForDisplay(driver, calender_close);
					click(driver,calender_close);
				}
				waitForElement(driver, Paste_Ok_Button);
				click(driver, Paste_Ok_Button);

				waitForDisplay(driver, popup_Message);

				if(isdisplayed(driver, popup_Message_Yes_Button)) {
					click(driver, popup_Message_Yes_Button);
				}

				waitForPopup(driver, popup_Message, Pasted_Popup_CS15);
				String Popup_Msg = getText(driver, popup_Message);
				if (Pasted_Popup_CS15.equals(Popup_Msg)) {
					System.out.println("Matched || Expected Popup Message was : "+Pasted_Popup_CS15+" || Actual Popup Message was : "+Popup_Msg);
					Extent_pass_New(driver, "Matched || Expected Popup Message was : "+Pasted_Popup_CS15+" || Actual Popup Message was : "+Popup_Msg, test,test1);
				}else {
					System.out.println("NotMatched || Expected Popup Message was : "+Pasted_Popup_CS15+" || Actual Popup Message was : "+Popup_Msg);
					Extent_fail(driver,  "NotMatched || Expected Popup Message was : "+Pasted_Popup_CS15+" || Actual Popup Message was : "+Popup_Msg, test,test1);
				}
				click(driver,popup_Message_Ok_Button);
			}
			scrollTop(driver);

			Extent_completed(testCaseName, test, test1);
			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCaseName="TC_Coastal_Schedule_CS16";
			String File_Path_CS16 = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_CS16 = TestNgXml.getsheetName_FromExecution().get(testCaseName);	
			Map<String, String> Excel_data_16 = Utils.GetAllData(Sheet_Name_CS16, testCaseName, "Dataset"+selected_dataset, File_Path_CS16);

			String Copied_Popup =Excel_data_16.get("Copied_Popup");
			String AlreadyExistMsg_Txt =Excel_data_16.get("AlreadyExistMsg");
			String Copy_Button =Excel_data_16.get("Copy_Button");
			String Pasted_Popup = Excel_data_16.get("Pasted_Popup");
			String ModuleSearch_CS16 =Excel_data_16.get("Module_Search");
			String ServiceCode_CS16 =Excel_data_16.get("Service_Code");
			String VesselCode_CS16 =Excel_data_16.get("Vessel_Code");
			String voyageNumber_CS16 =Excel_data_16.get("Voyage_Number");
			String paste_Button_CS15 = Excel_data_16.get("paste_Button");
			String Cycle_Number_Input= Excel_data_16.get("Cycle_Number_Input");
			String Voyage_Number_Inputs= Excel_data_16.get("Voyage_Number_Inputs");
			String date_Picker= Excel_data_16.get("date_Picker");
			String Voyage_Date= Excel_data_16.get("Voyage_Date");

			String condition = Excel_data_16.get("Condition");
			String service_Search_Header = Excel_data_16.get("Service_Search_Header");
			String vessel_Search_Header = Excel_data_16.get("Vessel_Search_Header");
			
			String button_Select_Copy =  String.format(Coastal_Schedule_Locators.button_Select_Copy, Copy_Button);
			String Voyage =  String.format(Coastal_Schedule_Locators.Voyage_New, voyageNumber_CS16);
			String VoyageVessel =  String.format(Coastal_Schedule_Locators.VoyageVessel, VesselCode_CS16);
			String Newly_Added_Voyage =  String.format(Coastal_Schedule_Locators.Newly_Added_Voyage, Voyage_Number_Inputs,Cycle_Number_Input);
			String Vessel =  String.format(Coastal_Schedule_Locators.Vessel, VesselCode_CS16);
			String button_Select_Paste =  String.format(Coastal_Schedule_Locators.button_Select_Paste, paste_Button_CS15);

			Extent_Start(testCaseName, test, test1);

			
			moduleNavigate(driver, ModuleSearch_CS16);

			Step_Start(1, "Enter the Service Code  in the service code field", test, test1);
			
			waitForElement(driver, Service_Search_Btn);
			click(driver, Service_Search_Btn);
			
			twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS16);


			Step_End(1, "Enter the Service Code  in the service code field", test, test1);

			Step_Start(2, "Enter the Vessel ", test, test1);
			
			waitForElement(driver, Vessel_Search_Btn);
			click(driver, Vessel_Search_Btn);

			twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS16);


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
			Step_Start(4, "click on Voyage that needed to be copied", test, test1);
			
			waitForElement(driver, Voyage);
			click(driver, Voyage);
			Extent_call(test, test1, "Right click on the selected voyage");
			waitForElement(driver, Voyage);
			RightClick(driver, Voyage);
			Extent_call(test, test1, "Copy the selected voyage");
			waitForElement(driver, button_Select_Copy);
			click(driver, button_Select_Copy);
			
			Step_End(4, "click on Voyage that needed to be copied", test, test1);
			waitForPopup(driver, popup_Message, Copied_Popup);
			Step_Start(5, "System shows “Voyage Copied”message", test, test1);
			String popup_Msg = getText(driver, popup_Message);
			if (Copied_Popup.equals(popup_Msg)) {
				System.out.println("Matched || Expected Popup Message was : "+Copied_Popup+" || Actual Popup Message was : "+popup_Msg);
				Extent_pass_New(driver, "Matched || Expected Popup Message was : "+Copied_Popup+" || Actual Popup Message was : "+popup_Msg, test,test1);
			}else {
				System.out.println("Not Matched || Expected Popup Message was : "+Copied_Popup+" || Actual Popup Message was : "+popup_Msg);
				Extent_fail(driver,  "Not Matched || Expected Popup Message was : "+Copied_Popup+" || Actual Popup Message was : "+popup_Msg, test,test1);

			}
			Step_End(5, "System shows “Voyage Copied”message", test, test1);
			click(driver,popup_Message_Ok_Button);
			
			waitForElement(driver, Tree_Structure);
			Step_Start(6, "Right click on the Vessel", test, test1);
			waitForElement(driver, Vessel);
			click(driver, Vessel);
			waitForElement(driver, VoyageVessel);
			RightClick(driver, VoyageVessel);
			
			Step_End(6, "Right click on the Vessel", test, test1);
			Step_Start(7, "Choose Paste Voyage Option", test, test1);
			
			waitForElement(driver, button_Select_Paste);
			click(driver, button_Select_Paste);
			waitForElement(driver, Paste_Ok_Button);
			click(driver, Paste_Ok_Button);
			Step_End(7, "Choose Paste Voyage Option", test, test1);
			Step_Start(8, "If the Voyage has already have the same cycle number as the paste voyage, System should show validation as “Cycle number already exist for the vessel", test, test1);
			waitForPopup(driver, popup_Message, AlreadyExistMsg_Txt);
			String exist_Msg = getText(driver, popup_Message);
			if (AlreadyExistMsg_Txt.equals(exist_Msg)) {
				System.out.println("Matched || Expected Popup Message was : "+AlreadyExistMsg_Txt+" || Actual Popup Message was : "+exist_Msg);
				Extent_pass_New(driver, "Matched || Expected Popup Message was : "+AlreadyExistMsg_Txt+" || Actual Popup Message was : "+exist_Msg, test,test1);
			}else {
				Extent_call(test, test1, "it didn't show -> Cycle number already exist for the vessel");
				System.out.println("Not Matched || Expected Popup Message was : "+AlreadyExistMsg_Txt+" || Actual Popup Message was : "+exist_Msg);
				Extent_fail(driver,  "Not Matched || Expected Popup Message was : "+AlreadyExistMsg_Txt+" || Actual Popup Message was : "+exist_Msg, test,test1);
			}
			Step_End(8, "If the Voyage has already have the same cycle number as the paste voyage, System should show validation as ->Cycle number already exist for the vessel", test, test1);

			click(driver,popup_Message_Ok_Button);

			Step_Start(9, "Edit the Cycle Number", test, test1);
			waitForElement(driver, Cycle_Number_Field);
			clearAndType(driver, Cycle_Number_Field, Cycle_Number_Input);
			Step_End(9, "Edit the Cycle Number", test, test1);
			Step_Start(10, "Edit the voyage Number", test, test1);

			waitForElement(driver, Voyage_Number_Field);
			clearAndType(driver, Voyage_Number_Field, Voyage_Number_Inputs);
			Step_End(10, "Edit the voyage Number", test, test1);
			Step_Start(11, "Edit the Arrival pilot of the first port in the voyage ", test, test1);

			waitForElement(driver, Arrival_Pilot_Date);
			if(date_Picker.equalsIgnoreCase("Yes")) {
				
				selectDatePickerWithTime(driver, Arrival_Pilot_Date, Voyage_Date);
				
				waitForElement(driver, Cycle_Number_Field);
				click(driver, Cycle_Number_Field);

			}else {
				waitForElement(driver, Arrival_Pilot_Date);
				clearAndType(driver, Arrival_Pilot_Date,Voyage_Date);
				waitForDisplay(driver, calender_close);
				click(driver,calender_close);
			}
			
			Step_End(11, "Edit the Arrival pilot of the first port in the voyage ", test, test1);
			Step_Start(12, "click on Ok", test, test1);
			waitForElement(driver, Paste_Ok_Button);
			click(driver, Paste_Ok_Button);
			Step_End(12, "click on Ok", test, test1);

			Step_Start(13, "System should paste the voyage based on the cycle number ", test, test1);
			waitForDisplay(driver, popup_Message);

			if(isdisplayed(driver, popup_Message_Yes_Button)) {
				click(driver, popup_Message_Yes_Button);
			}
			waitForPopup(driver, popup_Message, Pasted_Popup);
			String Popup_Msg = getText(driver, popup_Message);
			Extent_call(test, test1, "comparing the expected and actual popup messages.....!");
			if (Pasted_Popup.equals(Popup_Msg)) {
				System.out.println("Matched || Expected Popup Message was : "+Pasted_Popup+" || Actual Popup Message was : "+Popup_Msg);
				Extent_pass_New(driver, "Matched || Expected Popup Message was : "+Pasted_Popup+" || Actual Popup Message was : "+Popup_Msg, test,test1);
			}else {
				System.out.println("Not Matched || Expected Popup Message was : "+Pasted_Popup+" || Actual Popup Message was : "+Popup_Msg);
				Extent_fail(driver,  "Not Matched || Expected Popup Message was : "+Pasted_Popup+" || Actual Popup Message was : "+Popup_Msg, test,test1);
			}

			click(driver,popup_Message_Ok_Button);

			waitForDisplay(driver, Newly_Added_Voyage);
			scrollUsingElement(driver, Newly_Added_Voyage);
			if (isdisplayed(driver, Newly_Added_Voyage)) {
				String New_Voyage = getText(driver, Newly_Added_Voyage);
				System.out.println("Matched || Expected : The voyage should be pasted based on the Cycle number || Actual : The voyage is pasted based on the Cycle number || Pasted Voyage Name is : "+New_Voyage);
				Extent_pass_New(driver, "Matched || Expected : The voyage should be pasted based on the Cycle number || Actual : The voyage is pasted based on the Cycle number || Pasted Voyage Name is : "+New_Voyage, test,test1);
			} else {
				System.out.println("Not Matched || TExpected : The voyage should be pasted based on the Cycle number || Actual : The voyage is not pasted based on the Cycle number ");
				Extent_fail(driver, "Not Matched || TExpected : The voyage should be pasted based on the Cycle number || Actual : The voyage is not pasted based on the Cycle number ", test,test1);
			}

			Step_End(13, "System should paste the voyage based on the cycle number ", test, test1);
			Extent_completed(testCaseName, test, test1);
			scrollTop(driver);

			waitForElement(driver, Close_Current_tab);
			click(driver, Close_Current_tab);
		}
		if(i==1) {
			String testCaseName="TC_Coastal_Schedule_CS17";
			String File_Path_CS17 = TestNgXml.getfilePath_FromExecution().get(testCaseName);
			String Sheet_Name_CS17 = TestNgXml.getsheetName_FromExecution().get(testCaseName);	
			Map<String, String> Excel_data_17 = Utils.GetAllData(Sheet_Name_CS17, testCaseName, "Dataset"+selected_dataset, File_Path_CS17);

			String ModuleSearch_CS17 =Excel_data_17.get("Module_Search");
			String ServiceCode_CS17 =Excel_data_17.get("Service_Code"); 
			String VesselCode_CS17 =Excel_data_17.get("Vessel_Code");
			String voyageNumber_CS17 =Excel_data_17.get("Voyage_Number");
			String edit_Button_CS17 =Excel_data_17.get("Button");
			String rename_Popup = Excel_data_17.get("Rename_VoyagePopup");
			String rename_Confirm = Excel_data_17.get("Rename_Conf");
			String New_Voyage_Name = Excel_data_17.get("New_Voyage_Name");
			String Duplicate = Excel_data_17.get("Duplicate");
			String condition = Excel_data_17.get("Condition");
			String service_Search_Header = Excel_data_17.get("Service_Search_Header");
			String vessel_Search_Header = Excel_data_17.get("Vessel_Search_Header");

			String Voyage_New =  String.format(Coastal_Schedule_Locators.Voyage_New, New_Voyage_Name);
			String Voyage =  String.format(Coastal_Schedule_Locators.Voyage_New, voyageNumber_CS17);
			String button_Select =  String.format(Coastal_Schedule_Locators.button_Select, edit_Button_CS17);



			Extent_Start(testCaseName, test, test1);

			

			moduleNavigate(driver, ModuleSearch_CS17);

			Step_Start(1, "Enter the Service Code  in the service code field", test, test1);
			
			waitForElement(driver, Service_Search_Btn);
			click(driver, Service_Search_Btn);
			
			twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS17);


			Step_End(1, "Enter the Service Code  in the service code field", test, test1);
			Step_Start(2, "Enter the Vessel ", test, test1);
			
			waitForElement(driver, Vessel_Search_Btn);
			click(driver, Vessel_Search_Btn);

			twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS17);

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
			Step_Start(4, "click on Voyage to be renamed", test, test1);
			waitForElement(driver, Voyage);
			click(driver, Voyage);
			Step_End(4, "click on Voyage to be renamed", test, test1);

			Step_Start(5, "Right click on the voyage", test, test1);
			waitForElement(driver, Voyage);
			String	before_Voyage_Name=getText(driver, Voyage);
			RightClick(driver, Voyage);
			Step_End(5, "Right click on the voyage", test, test1);

			Step_Start(6, "click on Voyage to be renamed", test, test1);

			waitForElement(driver, button_Select);
			click(driver, button_Select);

			Step_End(6, "click on Voyage to be renamed", test, test1);


			waitForDisplay(driver, popup_Message);
			if(isdisplayed(driver, popup_Message)) {
				String Popup =getText(driver, popup_Message);

				Step_Start(7, "If the voyage has any Confirmed_Button Calls, System should show validation 	as ”Voyage has Confirmed_Button calls, Cannot rename the voyage”", test, test1);

				if (rename_Confirm.equals(Popup)) {
					System.out.println("Matched || Expected Popup  : " +rename_Confirm+"|| Actual Popup  :"  +Popup );

					Extent_pass_New(driver, "Matched || Expected Popup  : " +rename_Confirm+"|| Actual Popup  :"  +Popup,test,test1);
					Step_End(7, "If the voyage has any Confirmed_Button Calls, System should show validation as ”Voyage has Confirmed_Button calls, Cannot rename the voyage”", test, test1);

				} else {
					System.out.println("NotMatched || Expected Popup  : "+rename_Confirm+" || Actual Popup  : "+Popup);
					Extent_fail(driver,  "NotMatched || Expected Popup  : "+rename_Confirm+" || Actual Popup  : "+Popup, test,test1);
				}  

			}else {
				Step_Start(8, "Enter the Voyage name ", test, test1);
				waitForElement(driver, textVal);
				sendKeys(driver, textVal, New_Voyage_Name);
				Step_End(8, "Enter the Voyage name", test, test1);

				Step_Start(9, "Clicking on Ok should rename the voyage number", test, test1);
				waitForElement(driver, okOption);
				click(driver, okOption);
				Step_End(9, "Clicking on Ok should rename the voyage number", test, test1);

						waitForPopup(driver, popup_Message, rename_Popup);
				String Actual_Popup=getText(driver, popup_Message);
				if(Duplicate.equals(Actual_Popup)) {
					System.out.println("Matched || Expected Popup  : " +Duplicate+"|| Actual Popup  :"  +Actual_Popup );
					Extent_pass_New(driver, "Matched || Expected Popup  : " +Duplicate+"|| Actual Popup  :"  +Actual_Popup,test,test1);

				}else {

					Extent_call(test, test1, "*******Popup validation after renaming...********");
					if (Actual_Popup.equals(rename_Popup)) {
						System.out.println("Matched || Expected Popup  : " +rename_Popup+"|| Actual Popup  :"  +Actual_Popup );
						Extent_pass_New(driver, "Matched || Expected Popup  : " +rename_Popup+"|| Actual Popup  :"  +Actual_Popup,test,test1);
					} else {
						System.out.println("NotMatched || Expected Popup  : "+rename_Popup+" || Actual Popup  : "+Actual_Popup);
						Extent_fail(driver,  "NotMatched || Expected Popup  : "+rename_Popup+" || Actual Popup  : "+Actual_Popup, test,test1);
					}    
					Extent_call(test, test1, "Popup  confirmation");
					click(driver, popup_Message_Ok_Button);
					
					waitForDisplay(driver, Voyage_New);
					scrollUsingElement(driver, Voyage_New);
					String after_Voyage_Name=getText(driver, Voyage_New);

					Extent_call(test, test1, "Comparing the voyage names before and after renaming...");
					if (!before_Voyage_Name.equals(New_Voyage_Name)) {
						System.out.println("Matched || Before edit the voyage name was : " +before_Voyage_Name+"|| After Edit the Actual Voyage name is :"  +after_Voyage_Name );
						Extent_pass_New(driver, "Matched || Before edit the voyage name was : " +before_Voyage_Name+"|| After Edit the Actual Voyage name is :"  +after_Voyage_Name,test,test1);
					} else {
						System.out.println("NotMatched || Before edit the voyage name was : "+before_Voyage_Name+" || After Edit the Actual Voyage name is : "+after_Voyage_Name);
						Extent_fail(driver,  "NotMatched || Before edit the voyage name was : "+before_Voyage_Name+" || After Edit the Actual Voyage name is : "+after_Voyage_Name, test,test1);
					}
				}

			}

			Extent_completed(testCaseName, test, test1);
		}
	}
}
