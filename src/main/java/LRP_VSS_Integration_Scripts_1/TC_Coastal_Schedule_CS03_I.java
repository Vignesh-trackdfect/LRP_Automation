package LRP_VSS_Integration_Scripts_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;


import locators.Coastal_Schedule_Locators;

public class TC_Coastal_Schedule_CS03_I extends Keywords {

	public void coastalSchedule03_I(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {
	 	String testcase_Name="TC_Coastal_Schedule_CS03_I";
		
		

		
		
		String ExpectedCA =Excel_data.get("ExpectedCA");
		String ExpectedCS =Excel_data.get("ExpectedCS"); 
		String Term_Time =Excel_data.get("TerminalTime");
		String Bound_Input =Excel_data.get("Bound_Input");
		String DistNPort= Excel_data.get("Distance_Next_port");
		String SpNport= Excel_data.get("Speed_Next_port");
		String BuffTime= Excel_data.get("Buffer_Time");
		String ManTI= Excel_data.get("Man_TimeIn");
		String ManOUT= Excel_data.get("Man_TimeOut");
		String TimeZ= Excel_data.get("Time_Zone");
		String dist_Pre_Port= Excel_data.get("Distance_Pre_Port");
		String speed_Pre_port= Excel_data.get("Speed_Pre_port");
		String Username_CS03 =Excel_data.get("Username");
		String Password_CS03 =Excel_data.get("Password");
		String ModuleSearch_CS03 =Excel_data.get("Module_Search");
		String ServiceCode_CS03 =Excel_data.get("Service_Code");
		String VesselCode_CS03 =Excel_data.get("Vessel_Code");
		String voyageNumber_CS03 =Excel_data.get("Voyage_Number");
		String add_Button_CS03 =Excel_data.get("Add_Button");
		String portName_CS03 =Excel_data.get("Port_Name");
		String Add_portName= Excel_data.get("Add_portName");
		String RollBack_CS03= Excel_data.get("RollBack");
		String RollBack_Port= Excel_data.get("RollBack_Port");
		String search2 = Excel_data.get("Search_Input_2");
		String search3 = Excel_data.get("Search_Input_3");
		String Ports_Status = Excel_data.get("Ports_Status");
		String Select_Columns = Excel_data.get("Select_Columns");

		String condition = Excel_data.get("Condition");
		String service_Search_Header = Excel_data.get("Service_Search_Header");
		String vessel_Search_Header = Excel_data.get("Vessel_Search_Header");
		
		String dropdownCondition = Excel_data.get("DropdownCondition");
		String searchBy_From_Port = Excel_data.get("SearchBy_From_Port");
		String searchBy_To_Port = Excel_data.get("SearchBy_To_Port");
		String searchBy_Port = Excel_data.get("SearchBy_Port");

		String Voyage_Toggler = String.format(Coastal_Schedule_Locators.Voyage_Toggler, voyageNumber_CS03);
		String Port_Select1 =  String.format(Coastal_Schedule_Locators.Port_Select1, voyageNumber_CS03,portName_CS03);
		String Add_Select =  String.format(Coastal_Schedule_Locators.Add_Select, add_Button_CS03);
		String subBound_Select =  String.format(Coastal_Schedule_Locators.subBound_Select, Bound_Input);
		String Select =  String.format(Coastal_Schedule_Locators.Select, RollBack_Port);


		Extent_Start(testcase_Name, test, test1);

		
		navigateUrl(driver, url);
		
LRP_Login(driver, Username_CS03, Password_CS03);
		
		moduleNavigate(driver, ModuleSearch_CS03);
		
		Step_Start(1, "Enter the Service Code in the service code field", test, test1);

		waitForElement(driver, Service_Search_Btn);
		click(driver, Service_Search_Btn);
		
		twoColumnSearchWindow(driver, service_Search_Header, condition, ServiceCode_CS03);
		
		Step_End(1, "Enter the Service Code in the service code field", test, test1);

		Step_Start(2, "Enter the Vessel ", test, test1);

		waitForElement(driver, Vessel_Search_Btn);
		click(driver, Vessel_Search_Btn);

		twoColumnSearchWindow(driver, vessel_Search_Header, condition, VesselCode_CS03);


		Step_End(2, "Enter the Vessel ", test, test1);

		Step_Start(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);
		waitForElement(driver, Edit_Button_toolBar);
		click(driver, Edit_Button_toolBar);

		waitForElement(driver, Tree_Structure);
		Step_End(3, "System should list out the vessel voyages in the tree format in the left side ", test, test1);

		Step_Start(4, "Choose the first voyage", test, test1);
		waitForElement(driver, Voyage_Toggler);
		String status = getAttribute(driver, Voyage_Toggler, "class");
		if(!status.contains("s")) {
			click(driver, Voyage_Toggler);
		}
		Step_End(4, "Choose the first voyage", test, test1);
		Step_Start(5, "click on the port that has to be call confirmed", test, test1);

		waitForElement(driver, Port_Select1);
		click(driver, Port_Select1);	
		Step_End(5, "click on the port that has to be call confirmed", test, test1);
		Step_Start(6,"Right click on it ", test, test1);

		waitForElement(driver, Port_Select1);
		RightClick(driver, Port_Select1);
		Step_End(6,"Right click on it ", test, test1);
		Step_Start(7, "Choose Add Port Option", test, test1);
		waitForElement(driver, Add_Select);
		click(driver, Add_Select);

		Step_End(7, "Choose Add Port Option", test, test1);
		Step_Start(8, "Add port Window appears", test, test1);
		waitForDisplay(driver, Add_PortP);
		if(isdisplayed(driver,Add_PortP)) {
			Extent_pass_New(driver, "Passed || Expected : Add Port Details window should be Displayed || Actual : Add Port Details window is Displayed", test, test1);
			System.out.println("Passed || Expected : Add Port Details window should be Displayed || Actual : Add Port Details window is Displayed");
		}else {
			System.out.println("Failed || Expected : Add Port Details window should be Displayed || Actual : Add Port Details window is not Displayed");

			Extent_fail(driver, "Failed || Expected : Add Port Details window should be Displayed || Actual : Add Port Details window is not Displayed", test, test1);
		}
		Step_End(8, "Add port Window appears", test, test1);
		Step_Start(9, "Enter the port to be added in the Port Code field", test, test1);

		Actions action = new Actions(driver);
		waitForElement(driver,Port_CodeI);
		click(driver,Port_CodeI);
		sendKeys(driver, Port_CodeI, Add_portName);
		click(driver,Port_CodeSel);
		
		Step_End(9, "Enter the port to be added in the Port Code field", test, test1);
		Step_Start(10, "System should auto capture the Distance from Previous port and Distance from Next port values based on the Adding port(S) Previous port and Next port in the voyage ", test, test1);
		Step_Start(11, "IF the Distance is not presented in the system enter the distance in the fields manually", test, test1);

		waitForElement(driver, distance_PrevoiusPort_CS);
		if(isElementAccessible(driver, distance_PrevoiusPort_CS)) {
			waitForElement(driver,distance_PrevoiusPort_CS);
			click(driver,distance_PrevoiusPort_CS); 
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(dist_Pre_Port).perform();
		}
		waitForElement(driver,Distance_NextPort);
		click(driver,Distance_NextPort);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		action.sendKeys(DistNPort).perform();
		Step_End(10, "System should auto capture the Distance from Previous port and Distance from Next port values based on the Adding port(S) Previous port and Next port in the voyage ", test, test1);
		Step_End(11, "IF the Distance is not presented in the system enter the distance in the fields manually", test, test1);

		Step_Start(12, "Enter the Speed from previous port and Speed to NExt port field values", test, test1);
		waitForElement(driver,Speed_NextPort);
		click(driver,Speed_NextPort);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		action.sendKeys(SpNport).perform();
		waitForElement(driver, speed_PreviousPort_CS);
		if(isElementAccessible(driver, speed_PreviousPort_CS)) {
			waitForElement(driver,speed_PreviousPort_CS);
			click(driver,speed_PreviousPort_CS);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(speed_Pre_port).perform();
		}
		Step_End(12, "Enter the Speed from previous port and Speed to NExt port field values", test, test1);
		Step_Start(13, "Enter the bound values ", test, test1);
		waitForElement(driver,Sub_BoundD);
		click(driver,Sub_BoundD);
		waitForElement(driver,subBound_Select);
		click(driver, subBound_Select);
		Step_End(13, "Enter the bound values ", test, test1);
		Step_Start(14, "Enter the Buffer Time ", test, test1);
		waitForElement(driver,Buff_Time);
		click(driver,Buff_Time);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		action.sendKeys(BuffTime).perform();
		Step_End(14, "Enter the Buffer Time ", test, test1);

		Step_Start(15, "Enter the Man Time in ", test, test1);

		waitForElement(driver,Man_TimeInP);;
		click(driver,Man_TimeInP);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		action.sendKeys(ManTI).perform();
		Step_End(15, "Enter the Man Time in ", test, test1);
		Step_Start(16, "Enter the Man Time out ", test, test1);


		waitForElement(driver,Man_TimeoutP);
		click(driver,Man_TimeoutP);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		action.sendKeys(ManOUT).perform();
		Step_Start(17, "Enter the Man Time out ", test, test1);


		waitForElement(driver,Time_ZoneAp);
		click(driver,Time_ZoneAp);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		action.sendKeys(TimeZ).perform();

		waitForElement(driver,Terminal_TimeAP);
		click(driver,Terminal_TimeAP);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		action.sendKeys(Term_Time).perform();



		waitForElement(driver, Coastal_Schedulebtn);
		click(driver,Coastal_Schedulebtn);

		waitForPopup(driver, popup_Message, ExpectedCS);

			String ActualText = getText(driver,popup_Message);
			if(ExpectedCS.equals(ActualText)) {
				System.out.println("Matched || Expected Popup : "+ExpectedCS+" || Actual Popup : "+ActualText);
				Extent_pass_New(driver, "Matched || Expected Popup : "+ExpectedCS+" || Actual Popup : "+ActualText, test,test1);
			}else {
				System.out.println("Not Matched || Expected Popup : "+ExpectedCS+" || Actual Popup : "+ActualText);
				Extent_fail(driver,  "Not Matched || Expected Popup : "+ExpectedCS+" || Actual Popup : "+ActualText, test,test1);
			}
			click(driver,popup_Message_Yes_Button);

		

		
		waitForPopup(driver, popup_Message, ExpectedCA);
			String ActualCA = getText(driver,popup_Message);
			System.out.println(ExpectedCA);
			System.out.println(ActualCA);
			if(ExpectedCA.equals(ActualCA)) {
				System.out.println("Matched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA);
				Extent_pass_New(driver, "Matched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA, test,test1);
			}else {
				System.out.println("Not Matched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA);
				Extent_fail(driver,  "Not Matched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA, test,test1);
			}
			click(driver,popup_Message_Ok_Button);


		if(RollBack_CS03.equalsIgnoreCase("Yes")) {
			Step_Start(17, "If the user want to add a already permanently deleted call from the same voyage", test, test1);

			waitForElement(driver, Tree_Structure);
			waitForElement(driver, Voyage_Toggler);
			String status1 = getAttribute(driver, Voyage_Toggler, "class");
			if(!status1.contains("s")) {
				click(driver, Voyage_Toggler);
			}
			waitForElement(driver, Port_Select1);
			click(driver, Port_Select1);	
			waitForElement(driver, Port_Select1);
			RightClick(driver, Port_Select1);

			waitForElement(driver, Add_Select);
			click(driver, Add_Select);
			waitForDisplay(driver, Add_PortP);

			waitForElement(driver, Select);
			click(driver, Select);

			waitForElement(driver, Roll_Back_Btn);
			click(driver, Roll_Back_Btn);


			if(isElementAccessible(driver, distance_PrevoiusPort_CS)) {
				waitForElement(driver,distance_PrevoiusPort_CS);
				click(driver,distance_PrevoiusPort_CS);
				action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
				action.sendKeys(dist_Pre_Port).perform();
			}
			waitForElement(driver,Distance_NextPort);
			click(driver,Distance_NextPort);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(DistNPort).perform();
			waitForElement(driver,Speed_NextPort);
			click(driver,Speed_NextPort);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(SpNport).perform();
			if(isElementAccessible(driver, speed_PreviousPort_CS)) {
				waitForElement(driver,speed_PreviousPort_CS);
				click(driver,speed_PreviousPort_CS);
				action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
				action.sendKeys(speed_Pre_port).perform();
			}
			waitForElement(driver,Buff_Time);
			click(driver,Buff_Time);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(BuffTime).perform();


			waitForElement(driver,Man_TimeInP);;
			click(driver,Man_TimeInP);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(ManTI).perform();


			waitForElement(driver,Man_TimeoutP);
			click(driver,Man_TimeoutP);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(ManOUT).perform();


			waitForElement(driver,Time_ZoneAp);
			click(driver,Time_ZoneAp);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(TimeZ).perform();

			waitForElement(driver,Terminal_TimeAP);
			click(driver,Terminal_TimeAP);
			action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
			action.sendKeys(Term_Time).perform();
			waitForElement(driver, Coastal_Schedulebtn);
			click(driver,Coastal_Schedulebtn);

			waitForPopup(driver, popup_Message, ExpectedCS);
				 ActualText = getText(driver,popup_Message);
				if(ExpectedCS.equals(ActualText)) {
					System.out.println("Matched || Expected Popup : "+ExpectedCS+" || Actual Popup : "+ActualText);
					Extent_pass_New(driver, "Matched || Expected Popup : "+ExpectedCS+" || Actual Popup : "+ActualText, test,test1);
				}else {
					System.out.println("Not Matched || Expected Popup : "+ExpectedCS+" || Actual Popup : "+ActualText);
					Extent_fail(driver,  "Not Matched || Expected Popup : "+ExpectedCS+" || Actual Popup : "+ActualText, test,test1);
				}		
				
				click(driver,popup_Message_Yes_Button);

			


			waitForPopup(driver, popup_Message, ExpectedCA);
				 ActualCA = getText(driver,popup_Message);
				System.out.println(ExpectedCA);
				System.out.println(ActualCA);
				if(ExpectedCA.equals(ActualCA)) {
					System.out.println("Matched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA);
					Extent_pass_New(driver, "Matched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA, test,test1);
				}else {
					System.out.println("Not Matched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA);
					Extent_fail(driver,  "Not Matched || Expected Popup : "+ExpectedCA+" || Actual Popup : "+ActualCA, test,test1);
				}
				click(driver,popup_Message_Ok_Button);
			Step_End(17, "If the user want to add a already permanently deleted call from the same voyage", test, test1);
		}

		
		waitForElement(driver, Tree_Structure);
		waitForElement(driver, Voyage_Toggler);
		String status1 = getAttribute(driver, Voyage_Toggler, "class");
		if(!status1.contains("s")) {
			waitForElement(driver, Voyage_Toggler);
			safeclick(driver, Voyage_Toggler);
		}
		waitForElement(driver, Port_Select1);
		safeclick(driver, Port_Select1);						

		waitForDisplay(driver, Temp_Remove);
		if(isdisplayed(driver, Temp_Remove)){
			waitForElement(driver, Temp_Remove);
			click(driver, Temp_Remove);
		}
		reArrangeAG_Grid_Outer_Column_CS(driver, Select_Columns);

		List<WebElement> Ports_code = listOfElements(driver, portCodes_OuterGrid_CS);
		ArrayList<String> portName = new ArrayList<String> ();

		for(WebElement Ports : Ports_code) {
			String name = Ports.getText();
			if(!name.equals("")) {
			System.out.println(name);
			portName.add(name);
			}else {
				break;
			}
		}
		List<WebElement> Distance_code = listOfElements(driver, distanceList);

		ArrayList<String> Distance = new ArrayList<String> ();
		for(WebElement distance : Distance_code) {
			String name = distance.getText();
			if(!name.equals("")) {
			int dotIndex1 = name.indexOf('.');
			String Dist_Value= name.substring(0, dotIndex1);
			System.out.println(Dist_Value);
			Distance.add(Dist_Value);
			}else {
				break;
			}
		}

		
		Step_Start(18, "Check the Distance in Marine Distance module", test, test1);

		moduleNavigate(driver, search2);

		for(int k=0 ;k<portName.size();k++) {
			if(k+1 >= portName.size()) {
				break;
			}
			
			scrollTop(driver);
			
			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			globalValueSearchWindow1(driver, dropdownCondition, searchBy_From_Port, portName.get(k), searchBy_To_Port, portName.get(k+1), "", "");
			
			
			waitForDisplay(driver, retrivedGlobalValue);
			if(isdisplayed(driver, retrivedGlobalValue)) {
			click(driver, retrivedGlobalValue);
			waitForElement(driver, SelectButton);
			click(driver, SelectButton);
			elementnotvisible1(driver, SelectButton);
			
			waitForElement(driver, Distance_GRidcell_MD);
			String distance_value=getText(driver, Distance_GRidcell_MD);
			System.out.println(" Port Distance : " + distance_value);

			System.out.println(Distance.get(k));
			if(Distance.get(k).equals(distance_value)) {
				System.out.println("Matched || Distance Value taken from Coastal Schedule :  "+Distance.get(k)+" || Distance Values taken from Marine Distance : "+distance_value);
				Extent_pass_New(driver, "Matched || Distance Value taken from Coastal Schedule :  "+Distance.get(k)+" || Distance Values taken from Marine Distance : "+distance_value, test, test1);
			}else {
				System.out.println("Not Matched || Distance Value taken from Coastal Schedule :  "+Distance.get(k)+" || Distance Values taken from Marine Distance : "+distance_value);
				Extent_pass_New(driver, "Not Matched || Distance Value taken from Coastal Schedule :  "+Distance.get(k)+" || Distance Values taken from Marine Distance : "+distance_value, test, test1);
			}
			
		}else if(isdisplayed(driver, Popup_Message)) {
				System.out.println("***distance was not found for***" + portName.get(k) + "***" + portName.get(k + 1));
				Extent_pass_New(driver, "***distance is not available for the port pair ***" + portName.get(k) + "***"
						+ portName.get(k + 1), test, test1);
				
				click(driver, globalSearchCloseIcon_L);

			}
		}
		Step_End(18, "Check the Distance in Marine Distance module", test, test1);


		Step_Start(19, "Check the ports in Ports module", test, test1);

		moduleNavigate(driver, search3);

		for(int D=0 ;D<portName.size();D++) {
			if(D+1 >= portName.size()) {
				break;
			}

			waitForElement(driver, SearchButton_Toolbar);
			safeclick(driver, SearchButton_Toolbar);
			globalValueSearchWindow(driver, dropdownCondition, searchBy_Port, portName.get(D), "", "", "", "");

			waitForElement(driver, Statusforport);
			String Port_status=getText(driver, Statusforport);
			if(Port_status.equals(Ports_Status)){
				System.out.println( "Matched || The Port code "+portName.get(D)+" Status shown as "+Port_status);
				Extent_pass_New(driver, "Matched || The Port code "+portName.get(D)+" Status shown as "+Port_status , test, test1);
			}else {
				System.out.println("Not Matched || The Port code "+portName.get(D)+" Status not shown as "+Port_status);
				Extent_fail(driver, "Not Matched || The Port code "+portName.get(D)+" Status not shown as "+Port_status, test, test1);
			}
		}
		Step_End(19, "Check the ports in Ports module", test, test1);
		Extent_completed(testcase_Name, test, test1);

	}
}
