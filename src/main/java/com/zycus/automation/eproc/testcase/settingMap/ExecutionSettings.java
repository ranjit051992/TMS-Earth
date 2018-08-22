package com.zycus.automation.eproc.testcase.settingMap;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.zycus.automation.constants.SettingMapConstants;
import com.zycus.automation.eproc.businessflow.settingMapFlow.FlowSettingMap;
import com.zycus.automation.eproc.excelDatabaseReader.SettingMapReader;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;

public class ExecutionSettings extends TestDataProvider
{
	static Logger logger = Logger.getLogger(ExecutionSettings.class);

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.DefaultSet)
	public void sudoDefaultSet()
	{
		logger.info("Sudo Test for Default Set Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set1, dependsOnGroups = SettingMapConstants.DefaultSet)
	public void sudoSet1()
	{
		logger.info("Sudo Test for Set1 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set2, dependsOnGroups = SettingMapConstants.Set1)
	public void sudoSet2()
	{
		logger.info("Sudo Test for Set2 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set3, dependsOnGroups = SettingMapConstants.Set2)
	public void sudoSet3()
	{
		logger.info("Sudo Test for Set3 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set4, dependsOnGroups = SettingMapConstants.Set3)
	public void sudoSet4()
	{
		logger.info("Sudo Test for Set4 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set5, dependsOnGroups = SettingMapConstants.Set4)
	public void sudoSet5()
	{
		logger.info("Sudo Test for Set5 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set6, dependsOnGroups = SettingMapConstants.Set5)
	public void sudoSet6()
	{
		logger.info("Sudo Test for Set6 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set7, dependsOnGroups = SettingMapConstants.Set6)
	public void sudoSet7()
	{
		logger.info("Sudo Test for Set7 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set8, dependsOnGroups = SettingMapConstants.Set7)
	public void sudoSet8()
	{
		logger.info("Sudo Test for Set8 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set9, dependsOnGroups = SettingMapConstants.Set8)
	public void sudoSet9()
	{
		logger.info("Sudo Test for Set9 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set10, dependsOnGroups = SettingMapConstants.Set9)
	public void sudoSet10()
	{
		logger.info("Sudo Test for Set10 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set11, dependsOnGroups = SettingMapConstants.Set10)
	public void sudoSet11()
	{
		logger.info("Sudo Test for Set11 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set12, dependsOnGroups = SettingMapConstants.Set11)
	public void sudoSet12()
	{
		logger.info("Sudo Test for Set12 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set13, dependsOnGroups = SettingMapConstants.Set12)
	public void sudoSet13()
	{
		logger.info("Sudo Test for Set13 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set14, dependsOnGroups = SettingMapConstants.Set13)
	public void sudoSet14()
	{
		logger.info("Sudo Test for Set14 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set15, dependsOnGroups = SettingMapConstants.Set14)
	public void sudoSet15()
	{
		logger.info("Sudo Test for Set15 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set16, dependsOnGroups = SettingMapConstants.Set15)
	public void sudoSet16()
	{
		logger.info("Sudo Test for Set16 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set17, dependsOnGroups = SettingMapConstants.Set16)
	public void sudoSet17()
	{
		logger.info("Sudo Test for Set17 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set18, dependsOnGroups = SettingMapConstants.Set17)
	public void sudoSet18()
	{
		logger.info("Sudo Test for Set18 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set19, dependsOnGroups = SettingMapConstants.Set18)
	public void sudoSet19()
	{
		logger.info("Sudo Test for Set91 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set20, dependsOnGroups = SettingMapConstants.Set19)
	public void sudoSet20()
	{
		logger.info("Sudo Test for Set20 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set21, dependsOnGroups = SettingMapConstants.Set20)
	public void sudoSet21()
	{
		logger.info("Sudo Test for Set21 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set22, dependsOnGroups = SettingMapConstants.Set21)
	public void sudoSet22()
	{
		logger.info("Sudo Test for Set22 Settings");
	}

	@Test(dataProvider = "dataProvider", groups = SettingMapConstants.Set23, dependsOnGroups = SettingMapConstants.Set22)
	public void sudoSet23()
	{
		logger.info("Sudo Test for Set23 Settings");
	}

	@BeforeGroups(groups = SettingMapConstants.DefaultSet)
	public void beforeGroupDefaultSet() throws Exception
	{
		TestCase demotestCase = new TestCase();
		demotestCase.setTestMethodName("Setting Map Impl for Default Set");
		FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, SettingMapReader.settingMap, DriverSelector.getDriver(demotestCase));
	}

	@BeforeGroups(groups = SettingMapConstants.Set1)
	public void beforeSet1()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set2)
	public void beforeSet2()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set3)
	public void beforeSet3()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set4)
	public void beforeSet4()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set5)
	public void beforeSet5()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set6)
	public void beforeSet6()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set7)
	public void beforeSet7()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set8)
	public void beforeSet8()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set9)
	public void beforeSet9()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set10)
	public void beforeSet10()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set11)
	public void beforeSet11()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set12)
	public void beforeSet12()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set13)
	public void beforeSet13()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set14)
	public void beforeSet14()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set15)
	public void beforeSet15()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set16)
	public void beforeSet16()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set17)
	public void beforeSet17()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set18)
	public void beforeSet18()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set19)
	public void beforeSet19()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set20)
	public void beforeSet20()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set21)
	public void beforeSet21()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set22)
	public void beforeSet22()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

	@BeforeGroups(groups = SettingMapConstants.Set23)
	public void beforeSet23()
	{
		//				FlowSettingMap.changeAllSettings(SettingMapConstants.DefaultSet, settingMap, driver);
	}

}
