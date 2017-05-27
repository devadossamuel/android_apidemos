package com.qagroup.app;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Step;

public class AlertDialogsScreen {

	@AndroidFindBy(accessibility = "Text Entry dialog")
	private MobileElement textEntryDialog;

	@AndroidFindBy(id = "android:id/parentPanel")
	private List<MobileElement> dialogs;

	private AppiumDriver<MobileElement> driver;

	public AlertDialogsScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	@Step("Select 'Text Entry Dialog' tab")
	public AlertDialogsScreen selectTextEntryDialog() {
		textEntryDialog.click();
		return this;
	}

	@Step("Check 'Text Entry dialog' is displayed")
	public boolean isDialogDisplayed() {
		return dialog().isDisplayed();
	}

	private MobileElement dialog() {
		if (dialogs.size() > 1)
			throw new RuntimeException("Not unique locator for Dialog element!");
		if (dialogs.size() == 0)
			throw new RuntimeException("Incorrect locator for Dialog element!");
		return dialogs.get(0);
	}

}
