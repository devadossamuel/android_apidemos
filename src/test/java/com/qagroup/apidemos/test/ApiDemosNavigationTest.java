package com.qagroup.apidemos.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.qagroup.app.AlertDialogsScreen;
import com.qagroup.app.ApiDemos;
import com.qagroup.app.MainScreen;

public class ApiDemosNavigationTest {

	private MainScreen onMainScreen;
	private AlertDialogsScreen onAlertDialogsScreen;

	@Test
	public void test() {
		onMainScreen = ApiDemos.openMainScreen();
		onAlertDialogsScreen = onMainScreen.selectAppTab().thenOnAppScreen().selectAlertDialogsTab()
				.selectTextEntryDialog();
		Assert.assertTrue(onAlertDialogsScreen.isDialogDisplayed(), "Dialog is not displayed");
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		ApiDemos.close();
	}

}
