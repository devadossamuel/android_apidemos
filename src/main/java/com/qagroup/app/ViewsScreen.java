package com.qagroup.app;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Step;

public class ViewsScreen {
	
	@AndroidFindBy(accessibility = "Date Widgets")
	private MobileElement dateWidgets;

	private AppiumDriver<MobileElement> driver;

	public ViewsScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}
	
	@Step
	public DateWidgetsScreen selectDateWidgets() {
		dateWidgets.click();
		return new DateWidgetsScreen(driver);
	}
}
