package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
        $("#uploadPicture").click();
        $("#uploadPicture").uploadFromClasspath("Files/img/png/img/png/img.png");

        //Current Address
        $("#currentAddress").setValue("Комментарий");

        $("#stateCity-label").scrollTo().click();

        //State and City
        $(".css-19bqh2r").click();
        $(byText("Uttar Pradesh")).click();

        $(".css-19bqh2r").click();
        $(byText("Select City")).click();

        //submit
        $("#submit").click();
    }

}

