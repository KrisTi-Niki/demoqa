package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void PracticeFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Петр");
        $("#lastName").setValue("Петров");
        $("#userEmail").setValue("petr@petrov.com");
        $(".custom-control-label").click();
        $("#userNumber").setValue("89271111111");
        $("#dateOfBirthInput").shouldHave(text("15 Aug 2025"));
        $(".css-1hwfws3").setValue("Комментарий");
        $(".custom-control-label").click();
        $("#currentAddress").setValue("Комментари");
        $(".css-tlfecz-indicatorContainer").click();
        $(".css-1uccc91-singleValue").click();
        $(".css-19bqh2r").click();
        $(".1uccc91-singleValue").click();
        $(".btn btn-primary").click();
    }

