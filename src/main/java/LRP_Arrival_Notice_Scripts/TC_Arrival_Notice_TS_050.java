package LRP_Arrival_Notice_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;



public class TC_Arrival_Notice_TS_050 extends Keywords {
	public void  Arrival_Notice_TS_050(WebDriver driver, ExtentTest test, ExtentTest test1,String selected_dataset,Map<String, String> Excel_data,String url) {

		String testCaseName="TC_Arrival_Notice_TS_050";
		// Get data from test data
		

		String username = Excel_data.get("Username");
		String password = Excel_data.get("Password");
		String agencyUser = Excel_data.get("AgencyUser");
		String module_AgencyConfiguration=Excel_data.get("Module_AgencyConfiguration");
		String Agency_Code_search = Excel_data.get("Agency_Code_search");
		String Attribute_Search = Excel_data.get("Attribute_Search");
		String condition_Filter = Excel_data.get("Condition_Filter");
		String attribute=Excel_data.get("Attribute");
		String description=Excel_data.get("AttributeDescription");
		String value1=Excel_data.get("Value1");
		String module_ArrivalNotice = Excel_data.get("Module_ArrivalNotice");
		String dropdownCondition1 = Excel_data.get("GlobalSearchDropdownCondition1");
		String Search_Number = Excel_data.get("Search_Number");
		String bl_Number=Excel_data.get("BL_Number");
		String columnHeaders = Excel_data.get("ColumnHeaders");
		String value2=Excel_data.get("Value2");
		String Header_scroll_number=Excel_data.get("Header_scroll_number");
		
		
		
		
		
	
		


		navigateUrl(driver, url);

		Extent_Start(testCaseName, test, test1);


		// Login

		LRP_Login(driver, username, password);


// Agency Configuration

		Extent_cal(test, test1, module_AgencyConfiguration);
		Step_Start(1, "Open Agency configuration screen", test, test1);


		setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Code_search, Attribute_Search, condition_Filter, agencyUser, attribute, description, value1);
		
		

			

		// Switch Agency
		Step_Start(4, "Open \"Arrival Notice / Freight Memo\" screen", test, test1);

		SwitchProfile(driver, agencyUser);


		//		Arrival Notice 

		
		moduleNavigate(driver, module_ArrivalNotice);

		
		Extent_cal(test, test1, module_ArrivalNotice);

		waitForElement(driver, arrivalNotice_Module);
	
		Step_End(4, "Open \"Arrival Notice / Freight Memo\" screen", test, test1);
		Step_Start(5, "Fetch the mentioned Bl in search option", test, test1);
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		
		
		
		
		globalValueSearchWindow(driver, dropdownCondition1, Search_Number, bl_Number, "","", "","");
	
		Step_End(5, "Fetch the mentioned Bl in search option", test, test1);
		Step_Start(6, "Verify  Additional notify customer column has not shown", test, test1);
		
		waitForDisplay(driver, additionalNotifyNotice_Checkbox);
		if(!isdisplayed(driver, additionalNotifyNotice_Checkbox)) {
			
			Extent_pass(driver, "Matched || Expected Result is : System not showing  Additional notify Notice CheckBox || Actual Result is : System not showing  Additional notify Notice CheckBox ", test, test1);
			System.out.println("Matched || Expected Result is : System not showing  Additional notify Notice CheckBox  || Actual Result is :System not showing  Additional notify Notice CheckBox ");
		}else {
			System.out.println("Not Matched || Expected Result is : System not showing  Additional notify Notice CheckBox  || Actual Result is : System  showing  Additional notify Notice CheckBox ");
			Extent_fail(driver,"Not Matched || Expected Result is : System not showing  Additional notify Notice CheckBox  || Actual Result is : System  showing  Additional notify Notice CheckBox ", test, test1);
		}
		
		

		
		List<String> headers = splitAndExpand(columnHeaders);
		ArrayList<String> clumnheaders = new ArrayList<String>();
		

			int start=1;
			List<WebElement> columnvalues=listOfElements(driver, column_Headers);
			
			boolean loopCell=false;
			if(columnvalues.size()>0) {
				loopCell=true; 
			}
			while(loopCell==true) {
				String eleRowTest=String.format(column, start);
				String col_Id=getTextwithoutfail(driver,eleRowTest);
				clumnheaders.add(col_Id);
				System.out.println("clumnheaders : "+clumnheaders);
				if(start>8) {
					int Header_number = Integer.parseInt(Header_scroll_number);
					horizontalscroll(driver, scrollBar_AN_Table, Header_number);
				}
				 if(col_Id.equals("null")) {
						break;
					}
				start++;
			}
			
			for(String header : headers) {
				for(String clumnheader : clumnheaders) {
				if(clumnheader.equals(header)) {
				
					System.out.println(
							"NotMatched || Expected column should be displayed  : " + header + " || Actual column displayed: " + header);
					Extent_fail(driver,
							"NotMatched || Expected column should be displayed   : " + header + " || Actual column displayed : " + header,
							test, test1);
				}
				}
				System.out.println(
						"NotMatched || Expected column should not be displayed  : " + header + " || Actual column not displayed: " + header);
				Extent_pass(driver,
						"NotMatched || Expected column should not be displayed   : " + header + " || Actual column not  displayed : " + header,
						test, test1);
				
			}
		Step_End(6, "Verify  Additional notify customer column has not shown", test, test1);
		// Agency Configuration
		setAgencyConfiguration(driver, module_AgencyConfiguration, Agency_Code_search, Attribute_Search, condition_Filter, agencyUser, attribute, description, value2);

		Extent_completed(testCaseName, test, test1);
	}
}
