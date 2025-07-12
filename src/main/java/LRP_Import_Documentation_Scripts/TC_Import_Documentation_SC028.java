package LRP_Import_Documentation_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC028 extends Keywords{
	public void Import_Documentation_SC028(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {

		String testcase_Name="TC_Import_Documentation_SC028";
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String dropdownCondition1 = Excel_data.get("dropdownCondition1");
		String bl_Number = Excel_data.get("bl_Number");
		String ID_Table_Headers=Excel_data.get("ID_Charges_Table_Headers");
		String BL_Table_Headers=Excel_data.get("Split_Charges_Table_Headers");
		String ID_Table_Name=Excel_data.get("Collect_Chareges_Table_Name");
		String BL_Table_Name=Excel_data.get("Split_Charges_Table_Name");
		String House_BL_Status_Exp=Excel_data.get("House_BL_Status_Exp");
		String Header_Type_Value=Excel_data.get("Header_Type_Value");
		String Type_Column_Value=Excel_data.get("Type_Column_Value");
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
		Step_Start(1, "open the import documentation module click on search field and enter the BL no", test, test1);
		moduleNavigate(driver, ImportDocumentationModule);

		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		Step_End(1, "open the import documentation module click on search field and enter the BL no", test, test1);

		Step_Start(2, "Retrive the  NEW bill using tool bar search", test, test1);

		globalValueSearchWindow(driver, dropdownCondition1, ImportDoc_Select_Type1, bl_Number, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

		deleteSavedBL(driver,House_BL_Status_Exp,dropdownCondition1,bl_Number);
		
		Step_End(2, "Retrive the  NEW bill using tool bar search", test, test1);
		Step_Start(3, "after retrive the bl ,Master and House Bl button has avaliable ", test, test1);
		waitForElement(driver, Collect_Charges_Tab);
		click(driver, Collect_Charges_Tab);
		scrollBottom(driver);
		Step_End(3, "after retrive the bl ,Master and House Bl button has avaliable ", test, test1);
		Step_Start(4, "A.. Capture the Below Details from Colletc charges tab <br>manifest charge -------charge code ,description ,quantity ,amount,currency,rate reference.", test, test1);

		// Locate the headers table
		List<Map<String, String>> collect_Chareges_Tabledata = getTableData(driver, Collect_Charges_Table_Header, Collect_Charges_Table_Row);
		List<String> columnheaders = splitAndExpand(ID_Table_Headers);
		// Now retrieve a specific value using the first column value and the header name
		
		List<List<String>> BL_CollectCharges_Table = getValuesByColumnAndHeaders(collect_Chareges_Tabledata,Header_Type_Value,Type_Column_Value,columnheaders);
		String container_Tabledata = TableDataForReportNew(driver, BL_CollectCharges_Table,ID_Table_Name,columnheaders);

		Step_End(4, "A.. Capture the Below Details from Colletc charges tab manifest charge -------charge code ,description ,quantity ,amount,currency,rate reference.", test, test1);
		Step_Start(5, "click the housebl button", test, test1);
		waitForElement(driver, House_Button_Imp_DOC);
		click(driver, House_Button_Imp_DOC);
		Step_End(5, "click the housebl button", test, test1);
		Step_Start(6, "go to the split charges tab", test, test1);
		waitForElement(driver, Split_Charges_Tab);
		click(driver, Split_Charges_Tab);
		Step_End(6, "go to the split charges tab", test, test1);
		Step_Start(7, "collect manifest charges has to be shown.<br>---------------verify---------<br>charge code ,description ,quantity ,amount,currency,rate reference", test, test1);
		waitForElement(driver, Split_Charges_Table_Row_1);
		List<Map<String, String>> split_Chareges_Tabledata = getTableData(driver, Split_Charges_Table_Header_1, Split_Charges_Table_Row_1);
		List<String> BL_columnheaders = splitAndExpand(BL_Table_Headers);
		String charges_Tabledata = TableDataForReport(driver, split_Chareges_Tabledata,BL_Table_Name,BL_columnheaders);
		//Assuming you have these lists
		
		List<List<String>> HBL_SplitCharges_Table = getValuesByHeaders(split_Chareges_Tabledata, BL_columnheaders);
		
		if (compareTableData(BL_CollectCharges_Table,HBL_SplitCharges_Table)) {
			Extent_pass_New(driver,"Matched || Expexted : \n"+ "<pre>" +container_Tabledata + "</pre>" +"|| Actual : \n"+ "<pre>" +charges_Tabledata+ "</pre>"  , test, test1);
		} else {
			Extent_fail(driver,"Not Matched || Expexted : \n"+ "<pre>" +container_Tabledata + "</pre>" +"|| Actual : \n"+ "<pre>" +charges_Tabledata+ "</pre>"  , test, test1);
		}
		Step_End(7, "collect manifest charges has to be shown<br>---------------verify---------<br>charge code ,description ,quantity ,amount,currency,rate reference", test, test1);
		Extent_completed(testcase_Name, test, test1);
	}
}
