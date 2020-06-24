package com.google.qa.tests;

import com.base.TestBase;
import com.pages.HomePage;
import com.pages.SignInPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleSendMailTest extends TestBase {

    SignInPage signinPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp() {

        initialization();
        signinPage = new SignInPage();
        homePage = signinPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }


    @Test
    public void letter() {
        homePage.sendMail();

    }

    @AfterMethod
    public void tearDown() {
        homePage.logOut();
        driver.quit();

    }
}


