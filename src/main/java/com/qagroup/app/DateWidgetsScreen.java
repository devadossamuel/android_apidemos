package com.qagroup.app;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Step;

public class DateWidgetsScreen {

	@AndroidFindBy(accessibility = "1. Dialog")
	private MobileElement dialogTab;

	private AppiumDriver<MobileElement> driver;

	public DateWidgetsScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}
	
	@Step
	public DateWidgetDialogScreen selectDialogTab() {
		dialogTab.click();
		return new DateWidgetDialogScreen(driver);
	}
}
