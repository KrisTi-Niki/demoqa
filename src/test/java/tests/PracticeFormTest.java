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
        $("#userNumber").setValue("89271111111");

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day--weekend").click();

        //Subjects
        $("#subjectsInput").setValue("Комментарий");

        //Hobbies
        $(byText("Sports")).click();



        //Picture
//        $("#uploadPicture").uploadFromClasspath("files/images.jpg");

        $("#currentAddress").scrollTo().click();

        //Current Address
        $("#currentAddress").setValue("Комментарий");


        //State and City
        $(".css-19bqh2r").click();
        $(byText("Uttar Pradesh")).click();


        $("#city").click();
        $(byText("Agra")).shouldBe(visible).click();


        //submit
        $("#submit").click();



        //Проверка
        $(("#example-modal-sizes-title-lg")).shouldHave(text("Thanks for submitting the form"));

        $(".modal-body").find(byText("Student Name")).closest("tr").shouldHave(text("Петр Петров"));
        $(".modal-body").find(byText("Student Email")).closest("tr").shouldHave(text("petr@petrov.com"));
        $(".modal-body").find(byText("Mobile")).closest("tr").shouldHave(text("89271111111"));
        $(".modal-body").find(byText("Date of Birth")).closest("tr").shouldHave(text("27 July,2025"));
        $(".modal-body").find(byText("Subjects")).closest("tr").shouldHave(text("Комментарий"));
        $(".modal-body").find(byText("Hobbies")).closest("tr").shouldHave(text("Sports"));
//        $(".modal-body").find(byText("Picture")).closest("tr").shouldHave(text("files/images.jpg"));
        $(".modal-body").find(byText("Address")).closest("tr").shouldHave(text("Комментарий"));
        $(".modal-body").find(byText("State and City")).closest("tr").shouldHave(text("Uttar Pradesh Agra"));



    }

}

