package tests;

import Pages.Buttons;
import Pages.CalcPage;
import Pages.SearchPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class googleTestsCalc {

    private static WebDriver driver;
    private static SearchPage searchPage;
    private static CalcPage calcPage;

    @BeforeAll
    public static void init () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        searchPage = new SearchPage(driver);
        calcPage = new CalcPage(driver);
    }


    @Test
    public void test1() {
        driver.get("http://google.com");
        searchPage.search("калькулятор");
        calcPage.pressButton(Buttons.OPENED_PARENTHESIS);
        calcPage.pressButton(Buttons.ONE);
        calcPage.pressButton(Buttons.PLUS);
        calcPage.pressButton(Buttons.TWO);
        calcPage.pressButton(Buttons.CLOSED_PARENTHESIS);
        calcPage.pressButton(Buttons.MUL);
        calcPage.pressButton(Buttons.THREE);
        calcPage.pressButton(Buttons.MINUS);
        calcPage.pressButton(Buttons.FOUR);
        calcPage.pressButton(Buttons.ZERO);
        calcPage.pressButton(Buttons.DIV);
        calcPage.pressButton(Buttons.FIVE);
        calcPage.pressButton(Buttons.EQUAL);
        assertEquals("(1 + 2) × 3 - 40 ÷ 5 =", calcPage.getMemoryString());
        assertEquals("1", calcPage.getResult());
    }

    @AfterAll
    public static void teardown () {
    driver.quit();
    }
}
