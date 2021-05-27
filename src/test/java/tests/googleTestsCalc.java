package tests;

import Pages.Buttons;
import Pages.CalcPage;
import Pages.SearchPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertAll;
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

    @BeforeEach
    public void setup() {
        driver.get("http://google.com");
        searchPage.search("калькулятор");
    }

    @Test
    @DisplayName("Проверка операций с целыми числами")
    public void test1() {
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

        assertAll(
                () -> assertEquals("(1 + 2) × 3 - 40 ÷ 5 =", calcPage.getMemoryString()),
                () -> assertEquals("1", calcPage.getResult())
        );
    }

    @Test
    @DisplayName("Проверка деления на ноль")
    public void test2() {
        calcPage.pressButton(Buttons.SIX);
        calcPage.pressButton(Buttons.DIV);
        calcPage.pressButton(Buttons.ZERO);
        calcPage.pressButton(Buttons.EQUAL);

        assertAll(
                () -> assertEquals("6 ÷ 0 =", calcPage.getMemoryString()),
                () -> assertEquals("Infinity", calcPage.getResult())
        );
    }

    @Test
    @DisplayName("Проверка ошибки при отсутствии значения")
    public void test3() {
        calcPage.pressButton(Buttons.SIN);
        calcPage.pressButton(Buttons.EQUAL);

        assertAll(
                () -> assertEquals("sin() =", calcPage.getMemoryString()),
                () -> assertEquals("Error", calcPage.getResult())
        );
    }

    @AfterAll
    public static void teardown () {
    driver.quit();
    }
}
