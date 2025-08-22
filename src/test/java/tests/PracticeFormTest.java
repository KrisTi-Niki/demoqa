package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1600x900";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen =  false;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void PracticeFormTest() {
        open("/automation-practice-form");

        //Name
        $("#firstName").setValue("Петр");
        $("#lastName").setValue("Петров");

        //Email
        $("#userEmail").setValue("petr@petrov.com");

        //Gender
        $("#genterWrapper").$(byText("Male")).click();

        //Mobile
        $("#userNumber").setValue("8927111111");

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day--weekend").click();

        //Subjects
        $("#subjectsInput").setValue("E");
        $(".subjects-auto-complete__menu-list").$(byText("English")).click();


        //Hobbies
        $("#hobbiesWrapper").$(byText("Sports")).click();


        //Picture
        $("#uploadPicture").uploadFromClasspath("images.jpg");

        $("#currentAddress").scrollTo().click();

        //Current Address
        $("#currentAddress").setValue("Комментарий");


        //State and City
        $("#state").click();
        $(byText("Uttar Pradesh")).click();


        $("#city").click();
        $(byText("Agra")).shouldBe(visible).click();


        //submit
        $("#submit").click();


        //Проверка
        $(("#example-modal-sizes-title-lg")).shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Петр Петров"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("petr@petrov.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8927111111"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("27 July,2025"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("images.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Комментарий"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Agra"));

    }

}

