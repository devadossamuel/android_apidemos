package com.qagroup.app;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Step;

public class MainScreen {

	@AndroidFindBy(accessibility = "App")
	private MobileElement app;

	private AppiumDriver<MobileElement> driver;

	public MainScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	@Step("Select 'App' tab")
	public AppScreen selectAppTab() {
		app.click();
		return new AppScreen(driver);
	}
}
