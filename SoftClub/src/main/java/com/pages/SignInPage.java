package com.pages;

import com.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.concurrent.TimeUnit;

public class SignInPage extends TestBase {


    //Page Factory - OR:
    @FindBy(id="identifierId")
    WebElement username;
    @FindBy(name="password")
    WebElement password;
    @FindBy(xpath="//span[@class='RveJvd snByac']")
    WebElement NextBtn;
    @FindBy(xpath="//*[@id=\"passwordNext\"]/div/span/span")
    WebElement PNextBtn;

    //Initializing the Page Objects:
    public SignInPage(){
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String un, String pwd){
        username.sendKeys(un);
        NextBtn.click();
        password.sendKeys(pwd);
        PNextBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.titleContains(prop.getProperty("username")));

        assertThat(driver.getCurrentUrl(), containsString("inbox"));

        return new HomePage();

    }
}
