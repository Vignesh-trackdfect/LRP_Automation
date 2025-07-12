package LRP_Import_Documentation_Scripts;


import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import commonMethods.Keywords;

public class TC_Import_Documentation_SC027 extends Keywords{
	public void Import_Documentation_SC027(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Import_Documentation_SC027";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String bl_Number = Excel_data.get("bl_Number");
		String ID_Container_Table_Name=Excel_data.get("ID_Container_Table_Name");
		String ID_Containers_Table_Headers=Excel_data.get("ID_Containers_Table_Headers");
		String ID_Commodity_Table_Name=Excel_data.get("ID_Commodity_Table_Name");
		String ID_Commodity_Table_Headers=Excel_data.get("ID_Commodity_Table_Headers");
		String HBL_Container_Table_Name=Excel_data.get("HBL_Container_Table_Name");
		String HBL_Container_Table_Headers=Excel_data.get("HBL_Container_Table_Headers");
		String HBL_Commodity_Table_Name=Excel_data.get("HBL_Commodity_Table_Name");
		String HBL_Commodity_Table_Headers=Excel_data.get("HBL_Commodity_Table_Headers");
		String House_BL_Status_Exp=Excel_data.get("House_BL_Status_Exp");
		
		String ImportDoc_Select_Type1=Excel_data.get("ImportDoc_Select_Type1");
		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		

		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);
		
		Extent_call(test, test1, "********** Switch the Profile - Start **********");
		SwitchProfile(driver, AgencyUser);
		
		Extent_call(test, test1, "********** Switch the Profile - End **********");	
		Extent_call(test, test1, "********** Enter Import Documentation Module **********");
		moduleNavigate(driver, ImportDocumentationModule);
		Step_Start(1, "open the import documentation module click on search field and enter the BL no", test, test1);
		//bl
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(1, "open the import documentation module click on search field and enter the BL no", test, test1);

		Step_Start(2, "Retrive the  NEW bill using tool bar search", test, test1);
		
		globalValueSearchWindow(driver, dropdownCondition1, ImportDoc_Select_Type1, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

		//service
		Step_End(2, "Retrive the  NEW bill using tool bar search", test, test1);
		Step_Start(3, "after retrive the bl ,Master and House Bl button has avaliable plz click House Button", test, test1);
		
		deleteSavedBL(driver,House_BL_Status_Exp,dropdownCondition1,bl_Number);
		
		Step_End(3, "after retrive the bl ,Master and House Bl button has avaliable plz click House Button", test, test1);
		Step_Start(3, "A.. Capture below information from Container and Commodity tab,  \r\n"
				+ "---------Verify-----------\r\n"
				+ "container no,container type,tare wt,cargo wt,gross wt\r\n"
				+ "ii,container no,comm code,desc quantity ,volume,avail weight", test, test1);
		waitForElement(driver, Container_Tab_IMD);
		click(driver, Container_Tab_IMD);
		
		// Locate the headers table
		List<Map<String, String>> container_Tabledata = getTableDatawithscroll(driver, Container_Table_Header, Container_Table_Row,Container_Table_Scroll, 80, -3600);
		List<String> container_columnheaders = splitAndExpand(ID_Containers_Table_Headers);
		String container_Table = TableDataForReport(driver, container_Tabledata,ID_Container_Table_Name,container_columnheaders);
		
		List<List<String>> BL_Container_Table = getValuesByHeaders(container_Tabledata, container_columnheaders);

		mouseOverToElement(driver, Commodity_Tab);
		waitForElement(driver, Commodity_Tab);
		click(driver, Commodity_Tab);
		scrollBottom(driver);
		waitForElement(driver, Commodity_Table_Row);
		List<Map<String, String>> commodity_Tabledata = getTableDatawithscroll(driver, Commodity_Table_Header, Commodity_Table_Row,Commodity_Table_Scroll, 80, -2500);
		List<String> Commodity_columnheaders = splitAndExpand(ID_Commodity_Table_Headers);
		String Commodity_Table = TableDataForReport(driver, commodity_Tabledata,ID_Commodity_Table_Name,Commodity_columnheaders);

		List<List<String>> BL_Commodity_Table = getValuesByHeaders(commodity_Tabledata, Commodity_columnheaders);
		
		Step_End(3, "A.. Capture below information from Container and Commodity tab,  \r\n ---------Verify----------- \r\n container no,container type,tare wt,cargo wt,gross wt \r\n ii,container no,comm code,desc quantity ,volume,avail weight", test, test1);
		Step_Start(4, "click the housebl button", test, test1);
		mouseOverToElement(driver, House_Button_Imp_DOC);
		waitForElement(driver, House_Button_Imp_DOC);
		click(driver, House_Button_Imp_DOC);
		Step_End(4, "click the housebl button", test, test1);
		Step_Start(5, "House bl updation tab-container details  below value has to be shown for that bl \r\n i.container no,container type,tare wt,cargo wt,gross wt \r\n ii,container no,comm code,desc quantity ,volume,avail weight ", test, test1);
		waitForElement(driver, HBL_Container_Table_Row);
		List<Map<String, String>> HBL_container_Tabledata = getTableData(driver, HBL_Container_Table_Header, HBL_Container_Table_Row);
		List<String> HBL_container_columnheaders = splitAndExpand(HBL_Container_Table_Headers);
		String HBL_Container_Table = TableDataForReport(driver, HBL_container_Tabledata,HBL_Container_Table_Name,HBL_container_columnheaders);
		
		List<List<String>> HBL_Container_TableValues = getValuesByHeaders(HBL_container_Tabledata, HBL_container_columnheaders);
	
		waitForElement(driver, HBL_Commodity_Table_Row);
		List<Map<String, String>> HBL_commodity_Tabledata = getTableData(driver, HBL_Commodity_Table_Header, HBL_Commodity_Table_Row);
		List<String> HBL_Commodity_columnheaders = splitAndExpand(HBL_Commodity_Table_Headers);
		String HBL_Commodity_Table = TableDataForReport(driver, HBL_commodity_Tabledata,HBL_Commodity_Table_Name,HBL_Commodity_columnheaders);
		
		List<List<String>> HBL_Commodity_TableValues = getValuesByHeaders(HBL_commodity_Tabledata, HBL_Commodity_columnheaders);

		if (compareTableData(BL_Container_Table,HBL_Container_TableValues)) {
			Extent_pass_New(driver,"Matched || Expexted : \n"+ "<pre>" +container_Table + "</pre>" +"|| Actual : \n"+ "<pre>" +HBL_Container_Table+ "</pre>"  , test, test1);
		} else {
			Extent_fail(driver,"Not Matched || Expexted : \n"+ "<pre>" +container_Table + "</pre>" +"|| Actual : \n"+ "<pre>" +HBL_Container_Table+ "</pre>"  , test, test1);
		}
		if (compareTableData(BL_Commodity_Table,HBL_Commodity_TableValues)) {
			Extent_pass_New(driver,"Matched || Expexted : \n"+ "<pre>" +Commodity_Table + "</pre>" +"|| Actual : \n"+ "<pre>" +HBL_Commodity_Table+ "</pre>"  , test, test1);
		} else {                                                                                                                                                                                                                                                 
			Extent_fail(driver,"Not Matched || Expexted : \n"+ "<pre>" +Commodity_Table + "</pre>" +"|| Actual : \n"+ "<pre>" +HBL_Commodity_Table+ "</pre>"  , test, test1);
		}
		Step_End(5, "House bl updation tab-container details  below value has to be shown for that bl <br> i.container no,container type,tare wt,cargo wt,gross wt<br> ii,container no,comm code,desc quantity ,volume,avail weight ", test, test1);
		Extent_completed(testcase_Name, test, test1);
	} 
}

