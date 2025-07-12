package LRP_Import_Documentation_Scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;

public class TC_Import_Documentation_SC055 extends Keywords {

	public void Import_Documentation_SC055(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,Map<String, String> Excel_data,String url) {
		String testcase_Name="TC_Import_Documentation_SC055";
		
		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String AgencyUser = Excel_data.get("AgencyUser");
		String ImportDocumentationModule = Excel_data.get("ImportDocumentationModule");
		String BL_Condition = Excel_data.get("BL_Condition");
		String BL_Num = Excel_data.get("BL_Num");
		String SavedPopup = Excel_data.get("SavedPopup");
		String Non_Containerized_Import_Tab_Header = Excel_data.get("Non_Containerized_Import_Tab_Header");
		String Normal_Container__Headers = Excel_data.get("Normal_Container__Headers");
		String Bill_Of_Lading_Module = Excel_data.get("Bill_Of_Lading_Module");
		String ImportDoc_Select_Type1=Excel_data.get("ImportDoc_Select_Type1");
		String ImportDoc_Select_Type2=Excel_data.get("ImportDoc_Select_Type2");
		String ImportDoc_Select_Type3=Excel_data.get("ImportDoc_Select_Type3");
		String ImportDoc_Select_Value2=Excel_data.get("ImportDoc_Select_Value2");
		String ImportDoc_Select_Value3=Excel_data.get("ImportDoc_Select_Value3");
		String BOL_Select_Type1=Excel_data.get("BOL_Select_Type1");
		String BOL_Select_Type2=Excel_data.get("BOL_Select_Type2");
		String BOL_Select_Value2=Excel_data.get("BOL_Select_Value2");
		String BOL_Select_Type3=Excel_data.get("BOL_Select_Type3");
		String BOL_Select_Value3=Excel_data.get("BOL_Select_Value3");
		String Delete_Perform=Excel_data.get("Delete_Perform");
		String Delete_Confirmation_Popup = Excel_data.get("Delete_Confirmation_Popup");
		String Delete_Success_Popup = Excel_data.get("Delete_Success_Popup");
		
		Extent_Start(testcase_Name, test, test1);
		navigateUrl(driver, url);
		LRP_Login(driver, Username, Password);
		SwitchProfile(driver, AgencyUser);
		Step_Start(1, "open the import documentation and  retrieve the bill using tool bar search", test, test1);	
		moduleNavigate(driver, Bill_Of_Lading_Module);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, BL_Condition, BOL_Select_Type1, BL_Num, BOL_Select_Type2, BOL_Select_Value2, BOL_Select_Type3, BOL_Select_Value3);
		
		Step_End(1, "Open Import Documentation module and load the BL. using global search", test, test1);
		
		Step_Start(2, "below following tabs datas fetched from bill  i.Non-containerized ii.Non -containerized Details", test, test1);
		
		List<String> Non_ContainerHeaders=splitAndExpand2(Non_Containerized_Import_Tab_Header);
		List<String> Normal_ContainerHeaders=splitAndExpand2(Normal_Container__Headers);
		
		waitForElement(driver, ContainerTypeInput);
		String Shipment_Type_Act=getAttribute(driver, ContainerTypeInput, "value");
		System.out.println("Shipment Type In Bill of Lading : "+Shipment_Type_Act);
		
		moduleNavigate(driver, ImportDocumentationModule);
		
		waitForElement(driver, SearchButton_Toolbar);
		click(driver, SearchButton_Toolbar);
		
		globalValueSearchWindow(driver, BL_Condition, ImportDoc_Select_Type1, BL_Num, ImportDoc_Select_Type2, ImportDoc_Select_Value2, ImportDoc_Select_Type3, ImportDoc_Select_Value3);

		waitForElement(driver, ImportDocTableHeaders);
		List<WebElement> ImportDocHeader=listOfElements(driver,ImportDocTableHeaders);
		List<String> Act_Imp_Doc_Headers=new ArrayList<String>();
		
		for(WebElement header:ImportDocHeader) {
			String headerText=header.getText();
			Act_Imp_Doc_Headers.add(headerText);
		}
		
		if(Shipment_Type_Act.equals("Un-Containerized")||Shipment_Type_Act.equals("Non-Containerized")) {
			if(containsAllValues(Non_ContainerHeaders,Act_Imp_Doc_Headers)) {
				System.out.println("Expected :'"+Non_Containerized_Import_Tab_Header+"' Headers should display in Import Documentation When Shipment Type in Bill Of Lading is 'Un-Containerized' || Actual : "+Non_Containerized_Import_Tab_Header+" headers are displayed in Import Documentation When Shipment Type in Bill Of Lading is 'Un-Containerized'");
				Extent_pass_New(driver, "Expected :'"+Non_Containerized_Import_Tab_Header+"' Headers should display in Import Documentation When Shipment Type in Bill Of Lading is 'Un-Containerized' || Actual : "+Non_Containerized_Import_Tab_Header+" headers are displayed in Import Documentation When Shipment Type in Bill Of Lading is 'Un-Containerized'", test, test1);
			}else {
				System.out.println("Expected :'"+Non_Containerized_Import_Tab_Header+"' Headers should display in Import Documentation When Shipment Type in Bill Of Lading is 'Un-Containerized' || Actual : "+Non_Containerized_Import_Tab_Header+" headers are not displayed in Import Documentation When Shipment Type in Bill Of Lading is 'Un-Containerized'");
				Extent_fail(driver, "Expected :'"+Non_Containerized_Import_Tab_Header+"' Headers should display in Import Documentation When Shipment Type in Bill Of Lading is 'Un-Containerized' || Actual : "+Non_Containerized_Import_Tab_Header+" headers are not displayed in Import Documentation When Shipment Type in Bill Of Lading is 'Un-Containerized'", test, test1);
			}
		}else {
			if(containsAllValues(Normal_ContainerHeaders,Act_Imp_Doc_Headers)) {
				System.out.println("Expected :'"+Normal_ContainerHeaders+"' Headers should display in Import Documentation When Shipment Type in Bill Of Lading is not equal to 'Un-Containerized' || Actual : "+Normal_ContainerHeaders+" headers are displayed in Import Documentation When Shipment Type in Bill Of Lading is not equal to 'Un-Containerized'");
				Extent_pass_New(driver, "Expected :'"+Normal_ContainerHeaders+"' Headers should display in Import Documentation When Shipment Type in Bill Of Lading is not equal to 'Un-Containerized' || Actual : "+Normal_ContainerHeaders+" headers are displayed in Import Documentation When Shipment Type in Bill Of Lading is not equal to 'Un-Containerized'", test, test1);
			}else {
				System.out.println("Expected :'"+Normal_ContainerHeaders+"' Headers should display in Import Documentation When Shipment Type in Bill Of Lading is not equal to 'Un-Containerized' || Actual : "+Normal_ContainerHeaders+" headers are not displayed in Import Documentation When Shipment Type in Bill Of Lading is not equal to 'Un-Containerized'");
				Extent_fail(driver, "Expected :'"+Normal_ContainerHeaders+"' Headers should display in Import Documentation When Shipment Type in Bill Of Lading is not equal to 'Un-Containerized' || Actual : "+Normal_ContainerHeaders+" headers are not displayed in Import Documentation When Shipment Type in Bill Of Lading is not equal to 'Un-Containerized'", test, test1);
			}
		}
		
		Step_End(2, "below following tabs datas fetched from bill  i.Non-containerized ii.Non -containerized Details", test, test1);
		Step_Start(3, "click the save button in import documentation toolbar..once saved the import documentation system has validate import documentation is saved.", test, test1);
		
		scrollTop(driver);
		waitForElement(driver, SaveButton_ToolBar);
		jsClick(driver, SaveButton_ToolBar);
		waitForPopup(driver, popup_Message, SavedPopup);
		String ImportDocumentationSaved=getText(driver, popup_Message);
		if (SavedPopup.equals(ImportDocumentationSaved)) {
			System.out.println("Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
			Extent_pass_New(driver, "Matched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved, test,test1);
		} else {
			System.out.println("NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved);
			Extent_fail(driver, "NotMatched || Expected Popup was : " + SavedPopup + " || Actual Popup was : " + ImportDocumentationSaved,test, test1);
		}
		waitForElement(driver, popup_Message_Ok_Button);
		safeclick(driver, popup_Message_Ok_Button);
		
		Step_End(3, "click the save button in import documentation toolbar..once saved the import documentation system has validate import documentation is saved.", test, test1);
		
		Step_Start(4, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);
		Step_Start(5, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_Start(6, "click the yes and system has validate import dcoumentation is deleted", test, test1);

		if(Delete_Perform.equalsIgnoreCase("Yes")) {
			deleteImportDocument(driver, Delete_Confirmation_Popup, Delete_Success_Popup);
		}
		Step_End(6, "click the yes and system has validate import dcoumentation is deleted", test, test1);
		Step_End(5, "click the delete icon and system has validate( Do you want to delete import documentation ?YES or NO)", test, test1);
		Step_End(4, "once saved the import documentation  new ,search,edit and delete icon has shown in tool bar", test, test1);

		Extent_completed(testcase_Name, test, test1);
		
	}
}
