package com.pages;

import com.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertFalse;


public class HomePage extends TestBase {


    @FindBy(xpath = "//img[@class='gb_Ia gbii']")
    WebElement accountB;
    @FindBy(xpath = "//*[@id=\"gb_71\"]")
    WebElement logout;
    @FindBy(xpath = "//div[@class='T-I T-I-KE L3']")
    WebElement NewLetter;
    @FindBy(name = "to")
    WebElement To;
    @FindBy(name = "subjectbox")
    WebElement Subject;
    @FindBy(xpath = "//div[@class='Am Al editable LW-avf tS-tW']")
    WebElement Content;
    @FindBy(xpath = "//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")
    WebElement SendB;
    @FindBy(xpath = "//div[@class= 'J-J5-Ji']")
    WebElement Alert;
    @FindBy(xpath = "//*[contains(text(), 'Task number 3')]")
    List<WebElement> LetterGrid;

    // Initializing the Page Objects:
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public SignInPage logOut() {
        accountB.click();
        logout.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.titleIs("Gmail"));
        assertThat(driver.getCurrentUrl(), containsString("accounts.google.com"));

        return new SignInPage();
    }

    public HomePage sendMail() {
        NewLetter.click();
        To.sendKeys(prop.getProperty("username"));
        Subject.sendKeys("Task number 3");
        Content.sendKeys("This is a message for myself");
        SendB.click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.textToBePresentInElement(Alert, "Письмо отправлено"));

        List<WebElement> letters = LetterGrid;
        assertFalse(letters.isEmpty());

        return new HomePage();
    }

}
