package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import utils.DriverManager;

public class flipkartTest {

	private HomePage homePage;

	@BeforeClass
	public void setup() {
		DriverManager.initializeDriver();
		homePage = new HomePage();
		// searchResultsPage = new SearchResultsPage();
	}

	@Test(priority = 2, enabled = true, description = "Verify the functionality of search product in mobile category", groups = {
			"regression" })
	public void testSearchProductInMobileCategory() throws InterruptedException {
		String product = "iPhone 13";
//   homePage.searchForProduct(product, "Mobile");
		homePage.searchForProduct(product);
		//Assert.assertTrue(searchResultsPage.isSearchResultsDisplayed(), "Search results are displayed.");
	}

}
