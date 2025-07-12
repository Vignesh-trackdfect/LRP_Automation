package LRP_PartBL_Scripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commonMethods.Keywords;
import commonMethods.PartBL_Common_Creation;

public class TC_PartBL_TC034 extends Keywords {

	public void PartBL_TC034(WebDriver driver, ExtentTest test, ExtentTest test1, String selected_dataset,
			Map<String, String> Excel_data, String url) throws Exception {

		String testCaseName = "TC_PartBL_TC034";

		String Username = Excel_data.get("Username");
		String Password = Excel_data.get("Password");
		String Agency_Name = Excel_data.get("Agency_Name");
		String PartBL_Modulename = Excel_data.get("PartBL_Modulename");
		String Search_Condition1 = Excel_data.get("Search_Condition1");
		String Global_BL_Search_Header = Excel_data.get("Global_BL_Search_Header");
		String Quatity_Text_Field = Excel_data.get("Quatity_Text_Field");
		String No_Of_parts_TextField = Excel_data.get("No_Of_parts_TextField");
		String Eqp_ID = Excel_data.get("Eqp_ID");
		String PBL_Avl_Header = Excel_data.get("PBL_Avl_Header");
		String PBL_Eqp_Header = Excel_data.get("PBL_Eqp_Header");
		String PBL_Avl_Volume_Header = Excel_data.get("PBL_Avl_Volume_Header");
		String PBL_Avl_Weight_Header = Excel_data.get("PBL_Avl_Weight_Header");
		String Remove_Container_popup = Excel_data.get("Remove_Container_popup");

		Extent_Start(testCaseName, test, test1);

		Step_Start(1, "Open the Part BL module", test, test1);

		navigateUrl(driver, url);

		LRP_Login(driver, Username, Password);

		verifyMainMenu(driver);

		SwitchProfile(driver, Agency_Name);

		PartBL_Common_Creation partBL_Data_Creation = new PartBL_Common_Creation();

		Map<String, String> BL_MCN_Numbers = partBL_Data_Creation.Common_PartBL(driver, test, test1, Excel_data);

		System.out.println("BL_Number:" + BL_MCN_Numbers.get("BL_Number"));
		String BLNumber = BL_MCN_Numbers.get("BL_Number");

		moduleNavigate(driver, PartBL_Modulename);

		Step_End(1, "Open the Part BL module", test, test1);

		Step_Start(2, ".Click the Create button.", test, test1);

		newButton(driver);

		Step_End(2, ".Click the Create button.", test, test1);

		Step_Start(3, "Use the BL number search to retrieve the data.", test, test1);

		waitForElement(driver, PBL_No_SearchBtn);
		click(driver, PBL_No_SearchBtn);

		globalValueSearchWindow(driver, Search_Condition1, Global_BL_Search_Header, BLNumber, "", "", "", "");

		Step_End(3, "Use the BL number search to retrieve the data.", test, test1);

		Step_Start(4, "Enter the number of parts", test, test1);

		waitForElement(driver, PBL_No_Of_parts_Field);
		sendKeys(driver, PBL_No_Of_parts_Field, No_Of_parts_TextField);

		Step_End(4, "Enter the number of parts", test, test1);

		Step_Start(5, "Click the Create button.", test, test1);

		waitForElement(driver, PBL_Create_Btn);
		click(driver, PBL_Create_Btn);

		Step_End(5, "Click the Create button.", test, test1);

		Step_Start(6, "Select Move all charges to master", test, test1);

		waitForElement(driver, PBL_Move_All_Charges_Checkbox);
		click(driver, PBL_Move_All_Charges_Checkbox);

		Step_End(6, "Select Move all charges to master", test, test1);

		Step_Start(7, "Enter the quantity", test, test1);

		waitForElement(driver, PBL_CommodityGrid_Headers);
		List<Map<String, String>> commoditydatas_ChildBl = getTableData(driver, PBL_CommodityGrid_Headers,
				PBL_CommodityGrid_Row);

		String EquipID = "";
		String Total_Qty = "";
		String Total_Volume = "";
		String Total_Weight = "";

		for (Map<String, String> griddatas : commoditydatas_ChildBl) {

			EquipID = griddatas.get(PBL_Eqp_Header);
			Total_Qty = griddatas.get(PBL_Avl_Header);
			Total_Volume = griddatas.get(PBL_Avl_Volume_Header);
			Total_Weight = griddatas.get(PBL_Avl_Weight_Header);
		}

		System.out.println("Equipment id is" + EquipID);
		System.out.println("Before adding the quantity,the total qty is" + Total_Qty);
		System.out.println("Actual volume  is : " + Total_Volume);
		System.out.println("Actual weight is : " + Total_Weight);

		int Total_qty = Integer.parseInt(Total_Qty);
		double Total_Vol = Double.parseDouble(Total_Volume);
		double Total_Wght = Double.parseDouble(Total_Weight);

		if (!Eqp_ID.equals("")) {

			waitForElement(driver, PBL_EqpIdDropdown);
			click(driver, PBL_EqpIdDropdown);

			formatLocatorClick(driver, DropDown_Select, Eqp_ID);
		}

		waitForElement(driver, PBL_Quantity_Field);
		sendKeys(driver, PBL_Quantity_Field, Quatity_Text_Field);

		Step_End(7, "Enter the quantity", test, test1);

		Step_Start(8, "Add the quantity using the (+) symbol", test, test1);

		waitForElement(driver, PBL_Weight_Add_Btn);
		click(driver, PBL_Weight_Add_Btn);

		Step_End(8, "Add the quantity using the (+) symbol", test, test1);

		Step_Start(9, ".Click in grid.", test, test1);

		waitForElement(driver, PBL_Container_Grid_Row);
		doubleClick(driver, PBL_Container_Grid_Row);

		Step_End(9, ".Click in grid.", test, test1);

		Step_Start(10, "Click - simbol.", test, test1);

		waitForElement(driver, PBL_CARGO_Remove_Btn);
		click(driver, PBL_CARGO_Remove_Btn);

		Step_End(10, "Click - simbol.", test, test1);

		Step_Start(11, "Are you sure want to remove the selected Container And Commodity ? popup message shown.", test,
				test1);

		waitForPopup(driver, popup_Message, Remove_Container_popup);
		String Actual_Remove_Conn_Popup = getText(driver, popup_Message);
		System.out.println("Actual_Remove_Container_Popup  is :" + Actual_Remove_Conn_Popup);

		if (Remove_Container_popup.equals(Actual_Remove_Conn_Popup)) {

			System.out
					.println("Matched || Excepted :After The container Removed from the Grid, The value should be is :"
							+ Remove_Container_popup
							+ "|| Actual :After The container Removed from the Grid, The value was :"
							+ Actual_Remove_Conn_Popup);
			Extent_pass_New(driver,
					"Matched || Excepted :After The container Removed from the Grid, The value should be is :"
							+ Remove_Container_popup
							+ "|| Actual :After The container Removed from the Grid, The value was :"
							+ Actual_Remove_Conn_Popup,
					test, test1);
		}

		else {
			System.out.println(
					"NotMatched || Excepted :After The container Removed from the Grid, The value should be is :"
							+ Remove_Container_popup
							+ "|| Actual :After The container Removed from the Grid, The value was:"
							+ Actual_Remove_Conn_Popup);
			Extent_fail(driver,
					"NotMatched || Excepted :After The container Removed from the Grid, The value should be is :"
							+ Remove_Container_popup
							+ "|| Actual : After The container Removed from the Grid, The value was :"
							+ Actual_Remove_Conn_Popup,
					test, test1);
		}

		Step_End(11, "Are you sure want to remove the selected Container And Commodity ? popup message shown.", test,
				test1);

		Step_Start(12, "Click yes.", test, test1);

		waitForElement(driver, popup_Message_Yes_Button);
		click(driver, popup_Message_Yes_Button);

		Step_End(12, "Click yes.", test, test1);

		Step_Start(13, "Avail QTY, Volume and Weight column values added based on removed quantity..", test, test1);

		waitForElement(driver, PBL_CommodityGrid_Headers);
		List<Map<String, String>> commoditydatas_After_ChildBl = getTableData(driver, PBL_CommodityGrid_Headers,
				PBL_CommodityGrid_Row);

		String After_Add_EqpID = "";
		String After_Added_avai_Qty = "";
		String After_Added_Avail_Weight = "";
		String After_Added_Avail_Volume = "";

		for (Map<String, String> griddatas : commoditydatas_After_ChildBl) {

			After_Add_EqpID = griddatas.get(PBL_Eqp_Header);
			After_Added_avai_Qty = griddatas.get(PBL_Avl_Header);
			After_Added_Avail_Volume = griddatas.get(PBL_Avl_Volume_Header);
			After_Added_Avail_Weight = griddatas.get(PBL_Avl_Weight_Header);

		}

		System.out.println("After_Add_EqpID is : " + After_Add_EqpID);
		System.out.println("Available_Qties_After_ChildBl is  : " + After_Added_avai_Qty);
		System.out.println("After_Added_Volume_ChildBl is : " + After_Added_Avail_Volume);
		System.out.println("After_Added_Weight_ChildBl is : " + After_Added_Avail_Weight);

		int Actual_Qty = Integer.parseInt(After_Added_avai_Qty);

		double Actual_Volume = Double.parseDouble(After_Added_Avail_Volume);
		double Actual_Weight = Double.parseDouble(After_Added_Avail_Weight);

		if (Total_qty == Actual_Qty) {

			System.out.println(
					"Excepted Result || After Removing the Container from grid ,The value should be :" + Total_qty
							+ "Actual Result ||After Removing the Container from grid ,The value was : " + Actual_Qty);

			Extent_pass_New(driver,
					"Excepted Result || After Removing the Container from grid ,The value should be :" + Total_qty
							+ "Actual Result ||After Removing the Container from grid ,The value was : " + Actual_Qty,
					test, test1);

		} else {
			System.out.println(
					"Excepted Result || After Removing the Container from grid ,The value should be :" + Total_qty
							+ "Actual Result ||After Removing the Container from grid ,The value was : " + Actual_Qty);

			Extent_fail(driver,
					"Excepted Result || After Removing the Container from grid ,The value should be :" + Total_qty
							+ "Actual Result ||After Removing the Container from grid ,The value was : " + Actual_Qty,
					test, test1);

		}

		if (Total_Wght == Actual_Weight) {

			System.out.println("Excepted Result || After Removing the Container from grid ,The Weight should be :"
					+ Total_Wght + "Actual Result ||After Removing the Container from grid ,The Weight was : "
					+ Actual_Weight);

			Extent_pass_New(driver,
					"Excepted Result || After Removing the Container from grid ,The Weight should be :" + Total_Wght
							+ "Actual Result ||After Removing the Container from grid ,The Weight was : "
							+ Actual_Weight,
					test, test1);

		} else {
			System.out.println("Excepted Result || After Removing the Container from grid ,The Weight should be :"
					+ Total_Wght + "Actual Result ||After Removing the Container from grid ,The Weight was : "
					+ Actual_Weight);

			Extent_fail(driver,
					"Excepted Result || After Removing the Container from grid ,The Weight should be :" + Total_Wght
							+ "Actual Result ||After Removing the Container from grid ,The Weight was : "
							+ Actual_Weight,
					test, test1);

		}

		if (Total_Vol == Actual_Volume) {

			System.out.println("Excepted Result || After Removing the Container from grid ,The Volume should be :"
					+ Total_Vol + "Actual Result ||After Removing the Container from grid ,The Volume was : "
					+ Actual_Volume);

			Extent_pass_New(driver,
					"Excepted Result || After Removing the Container from grid ,The Volume should be :" + Total_Vol
							+ "Actual Result ||After Removing the Container from grid ,The Volume was : "
							+ Actual_Volume,
					test, test1);

		} else {
			System.out.println("Excepted Result || After Removing the Container from grid ,The Volume should be :"
					+ Total_Vol + "Actual Result ||After Removing the Container from grid ,The Volume was : "
					+ Actual_Volume);

			Extent_fail(driver,
					"Excepted Result || After Removing the Container from grid ,The Volume should be :" + Total_Vol
							+ "Actual Result ||After Removing the Container from grid ,The Volume was : "
							+ Actual_Volume,
					test, test1);

		}

		Step_End(13, "Avail QTY, Volume and Weight column values added based on removed quantity.", test, test1);

		Extent_completed(testCaseName, test, test1);
	}

}
