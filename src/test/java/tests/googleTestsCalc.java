package tests;

import Pages.CalcPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class googleTestsCalc {

    private static WebDriver driver;
    private static CalcPage calcPage;

    @BeforeAll
    public static void init () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        calcPage = new CalcPage(driver);
    }


    @Test
    public void test1() {
        driver.get("http://google.com");
        calcPage.search("калькулятор");
        calcPage.calc("(1+2)*3-40/5");
        assertEquals("(1 + 2) × 3 - 40 ÷ 5 =", calcPage.getMemoryString());
        assertEquals("1", calcPage.getResult());
    }

    @AfterAll
    public static void teardown () {
    driver.quit();
    }
}
