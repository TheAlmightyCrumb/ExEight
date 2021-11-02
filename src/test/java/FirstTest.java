import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstTest {
    private static WebDriver driver;

    @BeforeClass
    public static void initialiseDriver() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /* Ex. 1 */
    @Test
    public void test01_openTwoSites() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver eagerDriver = new ChromeDriver(chromeOptions);
        eagerDriver.get("https://www.walla.co.il");
        eagerDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        eagerDriver.navigate().to("https://www.ynet.co.il");
        eagerDriver.quit();
    }

    /* Ex. 2 */
    @Test
    public void test02_getTranslateBox() {
        driver.get("https://translate.google.com/");
        WebElement textInput = driver.findElement(By.cssSelector("textarea.er8xn"));
        System.out.println(textInput.isDisplayed());
    }

    /* Ex. 3 */
    @Test
    public void test03_getYoutubeIcon() {
        driver.navigate().to("https://www.youtube.com/");
        WebElement youtubeIcon = driver.findElement(By.id("logo-icon"));
        System.out.println(youtubeIcon);
    }

    /* Ex. 4 */
    @Test
    public void test04_findSeleniumSearch() {
        driver.navigate().to("http://www.seleniumhq.org/");
        WebElement searchInput = driver.findElement(By.cssSelector(".form-control.td-search-input"));
        searchInput.sendKeys("selenium");
    }

    /* Ex. 5 */
    @Test
    public void test05_workWithAmazon() {
        driver.navigate().to("https://www.amazon.com/");
        Assert.assertEquals(driver.getTitle(), "Amazon.com. Spend less. Smile more.");
        WebElement searchBox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        searchBox.sendKeys("Leather Shoes");
        WebElement searchBtn = driver.findElement(By.cssSelector("input#nav-search-submit-button"));
        searchBtn.click();
    }

    /* Ex. 6 */
    @Test
    public void test06_translateAgain() {
        driver.navigate().to("https://translate.google.com/");
        WebElement textInput = driver.findElement(By.cssSelector("textarea.er8xn"));
        textInput.sendKeys("בואו ולימדו את שפת התכנות חווה סקריפט.");
    }

    /* Ex. 7 */
    @Test
    public void test07_searchSongInYoutube() {
        driver.navigate().to("https://www.youtube.com/");
        WebElement searchBox = driver.findElement(By.cssSelector("input#search"));
        searchBox.sendKeys("Boulevard of Broken Dreams");
        WebElement searchBtn = driver.findElement(By.cssSelector("button#search-icon-legacy"));
        searchBtn.click();
    }

    /* Ex. 8 */
    @Test
    public void test08_loginToFacebook() {
        driver.navigate().to("https://www.facebook.com/");
        WebElement emailInput = driver.findElement(By.cssSelector("input#email[name=email]"));
        emailInput.sendKeys("bla@something.mate");
        WebElement passwordInput = driver.findElement(By.cssSelector("input#pass[name=pass]"));
        passwordInput.sendKeys("1234");
        WebElement loginBtn = driver.findElement(By.cssSelector("button[name=login]"));
        loginBtn.click();
    }

    /* Ex. 9 */
    @Test
    public void test09_usingJavaScript() {
        driver.navigate().to("https://theuselessweb.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"button#button\").click();");
        System.out.println(driver.getWindowHandles().size() == 2);
    }

    /* Ex. 10 */
    /*
    Is running tests on multiple browsers in parallel is possible? Which tool can be used for it?
    --> Yes. Selenium Grid.
        Want to run tests in parallel across multiple machines? Then, Grid is for you!
    */

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
