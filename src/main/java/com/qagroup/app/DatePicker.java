package com.qagroup.app;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DatePicker {

	@AndroidFindBy(id = "android:id/date_picker_header_year")
	private MobileElement year;

	@AndroidFindBy(id = "date_picker_header_date")
	//@AndroidFindBy(id = "android:id/date_picker_header_date")
	private MobileElement day;

	private AppiumDriver<MobileElement> driver;

	public DatePicker(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	public MonthDay getCurrentDay() {
		return MonthDay.parse(day.getText(), DateTimeFormatter.ofPattern("E, MMM d", Locale.US));
	}

	public Year getCurrentYear() {
		return Year.parse(year.getText(), DateTimeFormatter.ofPattern("yyyy", Locale.US));
	}

	public LocalDate getCurrentDate() {
		MonthDay monthDay = getCurrentDay();
		return LocalDate.of(getCurrentYear().getValue(), monthDay.getMonthValue(), monthDay.getDayOfMonth());
	}

	public void setDate(LocalDate date) {

	}

	public static void main(String[] args) {
		System.out.println(MonthDay.parse("Fri, Jul 1", DateTimeFormatter.ofPattern("E, MMM d", Locale.US)));
	}
}
