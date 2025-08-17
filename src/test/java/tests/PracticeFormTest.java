package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ISelect;

import java.io.UnsupportedEncodingException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.awt.SystemColor.menu;
import static org.openqa.selenium.By.cssSelector;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1600x900";
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void PracticeFormTest() throws UnsupportedEncodingException {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Петр");
        $("#lastName").setValue("Петров");
        $("#userEmail").setValue("petr@petrov.com");
        $(".custom-control-label").click();
        $("#userNumber").setValue("89271111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day--weekend").click();
        $("#subjectsInput").setValue("111");
        $(".custom-control-label").click();
        $("#currentAddress").setValue("Комментарий");
        $("#stateCity-label").scrollTo().click();
        $(".css-19bqh2r").click();
        $(byText("Uttar Pradesh")).click();
        $("#submit").click();
    }

}

