package LRP_Arrival_Notice_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_033 extends Keywords{
	public void Arrival_Notice_TS_033(WebDriver driver, ExtentTest test,ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) throws Exception {
		String testCaseName = "TC_Arrival_Notice_TS_033";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String Service = Excel_data.get("Service");
		String Vessel = Excel_data.get("Vessel");
		String Voyage = Excel_data.get("Voyage");
		String Bound = Excel_data.get("Bound");
		String Port = Excel_data.get("Port");
		String Terminal = Excel_data.get("Terminal");
		String Label_Select_1 = Excel_data.get("Label_Select_1");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String Search_Number = Excel_data.get("Search_Number");
		String bl_Number = Excel_data.get("bl_Number");
		String Coloum_Heder = Excel_data.get("Coloum_Heder");
		
		
		
		

		String select_Option_1 = String.format(DropDown_Select, Label_Select_1);

		Extent_Start(testCaseName, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		Step_Start(1, "Select the transshipment agency ", test, test1);

		SwitchProfile(driver, AgencyUser);
		Step_End(1, "Select the transshipment agency ", test, test1);

		Step_Start(2, "Open import documentation screen", test, test1);

		
		Step_Start(1,"Open import documentation screen", test, test1);
	
		moduleNavigate(driver, ImportDocumentationModule);
		Step_End(2, "Click search button and fetch the BL", test, test1);

		Step_Start(3, "Click search button and fetch the BL", test, test1);

	newButton(driver);
		waitForElement(driver, servicename);
		sendKeys(driver, servicename, Service);
		Step_End(3, "Click search button and fetch the BL", test, test1);

		Step_Start(4, "Click edit button ", test, test1);

		waitForElement(driver, ANgrid_vesselcode);
		sendKeys(driver, ANgrid_vesselcode, Vessel);
		sendKeys(driver, ANgrid_voyagecode, Voyage);
		Step_End(4, "Click edit button ", test, test1);


		sendKeys(driver, ANgrid_bound, Bound);
		sendKeys(driver, ANgrid_portcode, Port);
		waitForElement(driver, AN_scroll);
		horizontalscroll(driver, AN_scroll, 300);
		click1(driver,ANgrid_terminal);
		sendKeys(driver, ANgrid_terminal, Terminal);
		click(driver, ANgrid_selectbtn);

		Step_Start(5, "Click the Dropdown below the POL search icon", test, test1);
          scrollTop(driver);
		waitForElement(driver, slection_Label_1);
		click(driver, slection_Label_1);
		Step_End(5, "Click the Dropdown below the POL search icon", test, test1);

		Step_Start(6, "Select unsaved Bl option", test, test1);

		waitForElement(driver, select_Option_1);
		click(driver, select_Option_1);
		Step_End(6, "Select unsaved Bl option", test, test1);

		Step_Start(7, "Click show BLs", test, test1);

		waitForElement(driver, Show_BL_Button);
		click(driver, Show_BL_Button);
		Step_End(7, "Click show BLs", test, test1);
		waitForElement(driver, BlNoSearchButton);
		click(driver, BlNoSearchButton);
		List<WebElement> blNumbers = listOfElements(driver, BL_Numbers);
		List<String> IB_BL_Numbers= new ArrayList<>();
		for(WebElement bl_Num : blNumbers) {
			String number = bl_Num.getText();
			int index_Num = number.indexOf("-");
			String act_Num = number.substring(0, index_Num-1);
			IB_BL_Numbers.add(act_Num);
		}


		waitForElement(driver, CanceButtonlBLNum);
		click(driver, CanceButtonlBLNum);
		waitForElement(driver, Close_Current_tab);
		click(driver, Close_Current_tab);
		
		

		moduleNavigate(driver, ImportDocumentationModule);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		
		globalValueSearchWindow(driver, dropdownCondition1, Search_Number, bl_Number, "","", "","");
		
		

		Step_Start(10, "Click edit button ", test, test1);
		Step_End(10, "Click edit button ", test, test1);
		waitForElement(driver, AN_Arrival_notice_button);
		click(driver, AN_Arrival_notice_button);
		
		scrollBottom(driver);
		
		waitForElement(driver, total_records);
		String totalRecords = getText(driver, total_records);
		int number = Integer.parseInt(totalRecords);
		List<Map<String, String>> Arrival_notice_table = extractTableDataByRowIndex(driver, AN_Table, number);
		List<String> name_header = splitAndExpand(Coloum_Heder);
		String Table_value = TableDataForReport(driver, Arrival_notice_table, "arival notice table", name_header);
		Extent_pass(driver, "Matched || the actual Import documentation saved BL in arrival notice module <pre>"+Table_value+"</pre>", test, test1);
		waitForElement(driver, Nine_Dotted_Icon);
		click(driver, Nine_Dotted_Icon);
		click(driver, condition_Filter_AN);
		for(String bl_Num : IB_BL_Numbers) {
			waitForElement(driver, blNumber_Filter_AN);
			sendKeys(driver, blNumber_Filter_AN, bl_Num);
			waitForDisplay(driver, AN_First_Row);
			Step_Start(9, "Click BL search icon above the SPLIT MPL button", test, test1);
			if(verifyElementIsNotPresent(driver, AN_First_Row)) {
				Extent_pass(driver, "Matched || Excepted The Unsaved BL Number From Import Documentation Module : " + bl_Num + " The Unsaved BL Number Is Not Shown in Arrival Notice", test, test1);
				System.out.println("Matched || Excepted The Unsaved BL Number From Import Documentation Module : " + bl_Num + " The Unsaved BL Number Is Not Shown in Arrival Notice");
				waitForElement(driver, blNumber_Filter_AN);
				clear(driver, blNumber_Filter_AN);
			}else {
				System.out.println("Not Matched || Excepted The Unsaved BL Number From Import Documentation Module : " + bl_Num + " The Unsaved BL Number Is Shown in Arrival Notice");
				Extent_fail(driver, "Not Matched || Excepted The Unsaved BL Number From Import Documentation Module : " + bl_Num + " The Unsaved BL Number Is Shown in Arrival Notice", test,test1);
			}
			Step_End(9, "Click BL search icon above the SPLIT MPL button", test, test1);
		}
		String unsavedBls = convertListintoTableForReport("BL Number", IB_BL_Numbers);
		Extent_pass(driver, "Matched || the actual Import documentation unSaved BL Not Showed in the Arrival Notice module <pre>"+unsavedBls+"</pre>", test, test1);
		Extent_completed(testCaseName, test, test1);
	}
}
