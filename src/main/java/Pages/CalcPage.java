package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CalcPage {

    @FindBy(css = "input.gLFyf.gsfi")
    private WebElement searchInput;

    @FindBy(css = "div[role='presentation']")
    private WebElement calcInput;

    @FindBy(css = "span[jsname='ubtiRe']")
    private WebElement memoryString;

    @FindBy(css = "#cwos")
    private WebElement result;

    public CalcPage(WebDriver driver) {
        initElements(driver, this);
    }

    public void search(String text) {
        searchInput.sendKeys(text, Keys.ENTER);
    }

    public void calc(String text) {
        calcInput.sendKeys(text, Keys.ENTER);
    }

    public String getMemoryString() {
        return memoryString.getText();
    }

    public String getResult() {
        return result.getText();
    }
}
