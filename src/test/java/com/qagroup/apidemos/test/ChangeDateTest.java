package com.qagroup.apidemos.test;

import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.qagroup.app.AlertDialogsScreen;
import com.qagroup.app.ApiDemos;
import com.qagroup.app.DatePicker;
import com.qagroup.app.DateWidgetDialogScreen;
import com.qagroup.app.MainScreen;

public class ChangeDateTest {
	private MainScreen onMainScreen;
	private AlertDialogsScreen onAlertDialogsScreen;
	private DateWidgetDialogScreen dialogScreen;
	private DatePicker datePicker;

	@Test
	public void testChangeDate() throws InterruptedException {
		onMainScreen = ApiDemos.openMainScreen();
		dialogScreen = onMainScreen.selectViewsTab().selectDateWidgets().selectDialogTab();
		System.out.println(dialogScreen.getDateTimeAsString());
		
		LocalDateTime initialDateTime = dialogScreen.getDateTime();
		System.out.println(initialDateTime);
		
		LocalDateTime expectedFinalDateTime = initialDateTime.plusWeeks(1);
		System.out.println(expectedFinalDateTime);
		
		datePicker = dialogScreen.selectChangeTheDateTab();
		Thread.sleep(1000);
		System.out.println(datePicker.getCurrentDate());
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		ApiDemos.close();
	}
}
