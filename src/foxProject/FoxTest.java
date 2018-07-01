package foxProject;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FoxTest {

	static WebDriver driver;
	static WebDriverWait wait;
	static ArrayList<String> foxShows = new ArrayList<>();
	static JavascriptExecutor jse;
	static DataTable datatable;

	public static void main(String[] args) throws Exception {

		try {
			setUp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// signUp();
		// logOut();
		signIn();

		// Capturing last 4 Shows
		captureShows();
		// Clicking FX link
		verifyigFX();
		// verifying National Geographic
		verifyingNationalGeographic();
		// verifying Fox Shows
		verifyingFoxSport();
		// verifying All Shows
		verifyingAllShows();
		tearDown();
	}

	public static void setUp() throws Exception {

		datatable = new DataTable("foxData.xlsx", "./data/");

		datatable.setActiveSheet("Credential");

		System.setProperty("webdriver.chrome.driver", "./Config/chromedriver.exe");
		driver = new ChromeDriver();
		// System.setProperty("webdriver.gecko.driver", "./Config/geckodriver.exe");
		// driver = new FirefoxDriver();

		wait = new WebDriverWait(driver, 10);

		driver.get(datatable.getCellData(1, "URL").toString().trim());

		driver.manage().window().maximize();
		jse = (JavascriptExecutor) driver;

	}

	public static void signIn() {

		driver.findElement(By.id("path-1")).click();

		jse.executeScript(
				"document.evaluate(\"/html/body/div[1]/div/div[2]/div[2]/div/div[4]/button[2]\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click()");

		driver.findElement(By.name("signinEmail")).sendKeys(datatable.getCellData(1, "UserId").trim());
		driver.findElement(By.name("signinPassword")).sendKeys(datatable.getCellData(1, "Password").trim());

		driver.findElement(By.xpath("//div[@class='Account_signinButtonDesktop_2SO1g']/button")).click();

		driver.findElement(By.xpath("//a[@class='Account_close_3KPcR']")).click();
	}

	public static void captureShows() {

		datatable.setActiveSheet("Shows");
		jse.executeScript(
				"document.evaluate(\"//div[@class='Header_navLinks_1WBD8']/a[@href='/shows/']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click()");
		int j = 1;
		int showCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("/html/body/div[1]/div/main/div/div/div[2]/div/div/div/div/div"))).size();
		for (int i = showCount; i > showCount - 4; i--) {
			String showName = driver.findElement(By.xpath(
					"/html/body/div[1]/div/main/div/div/div[2]/div/div/div/div/div[" + i + "]/div[2]/div/a/div/div[1]"))
					.getText();
			datatable.setShowsData(j, "Show", showName);
			j++;
		}
	}

	public static void verifyigFX() {
		// /html/body/div[1]/div/main/div/div/div[1]/div[2]/div/div/div/div[2]/div[1]/a[3]
		datatable.setActiveSheet("FoxDataSheet");
		jse.executeScript(
				"document.evaluate(\"//div[2]/div/div/div/div[2]/div[1]/a[3]\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click()");

		// foxShows.add("24 Hours to Hell & Back");
		// foxShows.add("So You Think You Can Dance");
		// foxShows.add("Meghan Markle: An American Princess");
		// foxShows.add("Hypnotize Me");

		// for(String expectedShows: datatable.get)

		for (int i = 1; i <= datatable.getActiveSheet().getLastRowNum(); i++)
			foxShows.add(datatable.getActiveSheet().getRow(i).getCell(0).getStringCellValue());

		int fxShowCount = driver.findElements(By.xpath("//main/div/div/div[2]/div/div/div/div/div")).size();

		wait.until(driver -> jse.executeScript("return document.readyState").toString().equals("complete"));

		String found = "";

		for (int j = 0; j < foxShows.size(); j++) {

			for (int i = 1; i <= fxShowCount; i++) {

				String showName = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("/html/body/div[1]/div/main/div/div/div[2]/div/div/div/div/div[" + i
								+ "]/div[2]/div/a/div/div[1]")))
						.getText().toLowerCase();
				if (showName.equals(foxShows.get(j))) {
					found = foxShows.get(j);

					break;
				}

				// Assert.assertEquals(showName, foxShows.get(j).toString().toLowerCase());

			}

			if (found.isEmpty())
				datatable.setOtherData(j + 1, "FX", "Not found");
			// System.out.println(foxShows.get(j) + " not found");
			else
				datatable.setOtherData(j + 1, "FX", "Duplicate Record");
			// System.out.println(foxShows.get(j) + " Found");
			found = "";
		}

	}

	public static void verifyingNationalGeographic() {

		jse.executeScript(
				"document.evaluate(\"//div[2]/div/div/div/div[2]/div[1]/a[4]\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click()");

		int fxShowCount = driver.findElements(By.xpath("//main/div/div/div[2]/div/div/div/div/div")).size();

		wait.until(driver -> jse.executeScript("return document.readyState").toString().equals("complete"));

		String found = "";

		for (int j = 0; j < foxShows.size(); j++) {

			for (int i = 1; i <= fxShowCount; i++) {

				String showName = wait
						.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("//div[2]/div/div/div/div/div[" + i + "]/div[2]/div/a/div/div[1]")))

						.getText().toLowerCase();
				if (showName.equals(foxShows.get(j))) {
					found = foxShows.get(j);

					break;
				}

				// Assert.assertEquals(showName, foxShows.get(j).toString().toLowerCase());

			}

			if (found.isEmpty())
				datatable.setOtherData(j + 1, "NationalGeographic", "Not found");
			// System.out.println(foxShows.get(j) + " not found");
			else
				datatable.setOtherData(j + 1, "NationalGeographic", "Duplicate Record");
			// System.out.println(foxShows.get(j) + " Found");
			found = "";
		}

	}

	public static void verifyingFoxSport() {
		jse.executeScript(
				"document.evaluate(\"//div[2]/div/div/div/div[2]/div[1]/a[5]\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click()");

		int fxShowCount = driver.findElements(By.xpath("//main/div/div/div[2]/div/div/div/div/div")).size();

		wait.until(driver -> jse.executeScript("return document.readyState").toString().equals("complete"));

		String found = "";

		for (int j = 0; j < foxShows.size(); j++) {

			for (int i = 1; i <= fxShowCount; i++) {

				String showName = "";

				String verify = driver
						.findElement(By.xpath("//div[2]/div/div/div/div/div[\"+i+\"]/div[1]/a/div/div[2]")).getText();

				if (verify == "LIVE" || verify == "UP NEXT") {

					wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//div[2]/div/div/div/div/div[" + i + "]/div[2]/div/a/div/div/span"))).getText()
							.toLowerCase();

				} else {
					wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//div[2]/div/div/div/div/div[" + i + "]/div[2]/div/a/div"))).getText()
							.toLowerCase();

				}

				if (showName.equals(foxShows.get(j))) {
					found = foxShows.get(j);

					break;
				}

				// Assert.assertEquals(showName, foxShows.get(j).toString().toLowerCase());

			}

			if (found.isEmpty())
				datatable.setOtherData(j + 1, "FoxSports", "Not found");
			// System.out.println(foxShows.get(j) + " not found");
			else
				datatable.setOtherData(j + 1, "FoxSports", "Duplicate Record");
			// System.out.println(foxShows.get(j) + " Found");
			found = "";
		}
	}

	public static void verifyingAllShows() {

		jse.executeScript(
				"document.evaluate(\"//div[2]/div/div/div/div[2]/div[1]/a[6]\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click()");

		int fxShowCount = driver.findElements(By.xpath("//main/div/div/div[2]/div/div/div/div/div")).size();

		wait.until(driver -> jse.executeScript("return document.readyState").toString().equals("complete"));

		String found = "";

		for (int j = 0; j < foxShows.size(); j++) {

			for (int i = 1; i <= fxShowCount; i++) {

				String showName = wait
						.until(ExpectedConditions.visibilityOfElementLocated(
								By.xpath("//div[2]/div/div/div/div/div[" + i + "]/div[2]/div/a/div/div[1]")))

						.getText().toLowerCase();
				if (showName.equals(foxShows.get(j))) {
					found = foxShows.get(j);

					break;
				}

				// Assert.assertEquals(showName, foxShows.get(j).toString().toLowerCase());

			}

			if (found.isEmpty())
				datatable.setOtherData(j + 1, "AllShows", "Not found");
			// System.out.println(foxShows.get(j) + " not found");
			else
				datatable.setOtherData(j + 1, "AllShows", "Duplicate record");
			// System.out.println(foxShows.get(j) + " Found");
			found = "";
		}
	}

	// Create a profile
	public static void signUp() {
		driver.findElement(By.id("path-1")).click();

		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[4]/button[1]")).click();

		driver.findElement(By.name("signupFirstName")).sendKeys("endl");
		driver.findElement(By.name("signupLastName")).sendKeys("ksa");

		driver.findElement(By.name("signupEmail")).sendKeys("kidestsamuel@aol.com");
		driver.findElement(By.name("signupPassword")).sendKeys("soccer123");

		// Select Gender
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[10]/div[1]/div/div/div/a"))
				.click();

		//
		driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[10]/div[1]/div/div[2]/a[1]/div"))
				.click();
		driver.findElement(By.xpath("//input[@placeholder='Birthdate']")).sendKeys("10/20/2000");

		// Done button
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[12]/button")).click();

		// Clicking Done button
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[3]/button"))).click();
		driver.findElement(By.xpath("//*[@id=\"path-1\"]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/a[4]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[3]/button[1]")).click();

		driver.findElement(By.id("path-1")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Sign In')]")).click();

		driver.findElement(By.name("signinEmail")).sendKeys("samamycopper@gmail.com");
		driver.findElement(By.name("signinPassword")).sendKeys("soccer123");

		driver.findElement(By.xpath("//div[@class='Account_signinButtonDesktop_2SO1g']/button")).click();

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "document.getElementsByClassName(\"Header_categoryItem_2_wKp\")[0].click();";
		jse.executeScript(script);
		driver.findElement(By.xpath("//a[@class='Account_close_3KPcR']")).click();

	}

	public static void logOut() {
		driver.findElement(By.id("path-1")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Sign Out')]")).click();

		driver.findElement(By.xpath("//button[contains(text(), 'Sign Out')]")).click();

	}

	public static void tearDown() {
		datatable.closeDataFile();
		driver.close();
		// driver.quit();
	}

}