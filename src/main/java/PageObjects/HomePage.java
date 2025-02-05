package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import utils.DriverManager;

public class HomePage {

	private WebDriver driver;

	private final String baseUrl = "https://www.flipkart.com/";
	private final By searchButton = By.cssSelector("button[type='submit']");
	private final By searchInput = By.cssSelector("input[name='q']");
	String searchOptions = "(//div[contains(text(),'" + "PRODUCT_SEARCH_OPTION" + "')]/parent::a/parent::div)[1]";

	public HomePage() {

		this.driver = DriverManager.getDriver();

	}

	public void searchForProduct(String productName) throws InterruptedException {
		driver.get(baseUrl);
		driver.findElement(searchInput).sendKeys(Keys.chord(Keys.ESCAPE));
		System.out.println("Pressed escape key to close the login popup if it is displayed");

		driver.findElement(searchInput).sendKeys(productName);
		System.out.println("Search text is entered as : " + productName);

		String searchOptionsProductXpathString = searchOptions.replaceAll("PRODUCT_SEARCH_OPTION",
				productName.toLowerCase());
		Thread.sleep(5000);
		String searchProduct = driver.findElement(By.xpath(searchOptionsProductXpathString)).getText();
		driver.findElement(By.xpath(searchOptionsProductXpathString)).click();
		System.out.println("Searched product is selected form list option as: " + searchProduct);

		Thread.sleep(4000);
		driver.findElement(searchButton).click();
		System.out.println("Search button is clicked on to find the product results");
	}

}
