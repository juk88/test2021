package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class SearchPage {

    @FindBy(css = "input.gLFyf.gsfi")
    private WebElement searchInput;

    public SearchPage(WebDriver driver) {
        initElements(driver, this);
    }

    public void search(String text) {
        searchInput.sendKeys(text, Keys.ENTER);
    }
}
