package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	private static WebDriver driver;

	public static void initializeDriver() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--disable-popup-blocking");
		options.setAcceptInsecureCerts(true);
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--start-maximized");

		driver = WebDriverManager.chromedriver().capabilities(options).create();
		System.out.println("Chrome Browser is launched");

		driver.manage().window().maximize();

	}

	public static WebDriver getDriver() {
		if (driver == null) {
			initializeDriver();
		}
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
