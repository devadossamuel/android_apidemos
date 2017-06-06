package com.qagroup.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class DateWidgetDialogScreen {

	@AndroidFindBy(id = "io.appium.android.apis:id/dateDisplay")
	private MobileElement dateTimeLabel;

	@AndroidFindBy(accessibility = "change the date")
	private MobileElement changeTheDateTab;

	private AppiumDriver<MobileElement> driver;

	public DateWidgetDialogScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	public DatePicker selectChangeTheDateTab() {
		changeTheDateTab.click();
		return new DatePicker(driver);
	}

	@Step("Read Date/Time")
	@Attachment("Date/Time")
	public String getDateTimeAsString() {
		return dateTimeLabel.getText();
	}

	public LocalDateTime getDateTime() {
		return LocalDateTime.parse(getDateTimeAsString(), DateTimeFormatter.ofPattern("M-d-yyyy HH:mm", Locale.US));
	}

}
