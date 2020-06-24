package com.google.qa.tests;

import com.base.TestBase;
import com.pages.HomePage;
import com.pages.SignInPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


public class GoogleSignInTest extends TestBase {

    SignInPage signinPage;
    HomePage homePage;



    @BeforeMethod
    public void setUp() {
        initialization();
        signinPage = new SignInPage();
    }

    @Test
    public void loginTest() {
        homePage = signinPage.login(prop.getProperty("username"), prop.getProperty("password"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
