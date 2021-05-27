package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static Pages.Buttons.*;
import static org.openqa.selenium.support.PageFactory.initElements;

public class CalcPage {
    @FindBy(css = "div[aria-label='открывающая скобка']")
    private WebElement openedParenthesis;

    @FindBy(css = "div[aria-label='закрывающая скобка']")
    private WebElement closedParenthesis;

    @FindBy(css = "div[jsname='bkEvMb']")
    private WebElement zeroButton;

    @FindBy(css = "div[jsname='N10B9']")
    private WebElement oneButton;

    @FindBy(css = "div[jsname='lVjWed']")
    private WebElement twoButton;

    @FindBy(css = "div[jsname='KN1kY']")
    private WebElement threeButton;

    @FindBy(css = "div[jsname='xAP7E']")
    private WebElement fourButton;

    @FindBy(css = "div[jsname='Ax5wH']")
    private WebElement fiveButton;

    @FindBy(css = "div[jsname='abcgof']")
    private WebElement sixButton;

    @FindBy(css = "div[aria-label='сложение']")
    private WebElement plusButton;

    @FindBy(css = "div[aria-label='вычитание']")
    private WebElement minusButton;

    @FindBy(css = "div[aria-label='умножение']")
    private WebElement mulButton;

    @FindBy(css = "div[aria-label='деление']")
    private WebElement divButton;

    @FindBy(css = "div[aria-label='равно']")
    private WebElement equalButton;

    @FindBy(css = "div[aria-label='синус']")
    private WebElement sinButton;

    @FindBy(css = "span[jsname='ubtiRe']")
    private WebElement memoryString;

    @FindBy(css = "#cwos")
    private WebElement result;

    public CalcPage(WebDriver driver) {
        initElements(driver, this);
    }

    public String getMemoryString() {
        return memoryString.getText();
    }

    public String getResult() {
        return result.getText();
    }

    public void pressButton(Buttons buttonID) {
        WebElement button = switch (buttonID) {
            case OPENED_PARENTHESIS -> openedParenthesis;
            case CLOSED_PARENTHESIS -> closedParenthesis;
            case ZERO -> zeroButton;
            case ONE -> oneButton;
            case TWO -> twoButton;
            case THREE -> threeButton;
            case FOUR -> fourButton;
            case FIVE -> fiveButton;
            case SIX -> sixButton;
            case PLUS -> plusButton;
            case MINUS -> minusButton;
            case MUL -> mulButton;
            case DIV -> divButton;
            case EQUAL -> equalButton;
            case SIN -> sinButton;
        };
        button.click();
    }
}
