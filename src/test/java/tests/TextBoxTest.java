package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll

    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void successFillTest() {

        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("alexpetrov@gmail.com");
        $(byText("Other")).click();
        $("#userNumber").setValue("9008000908");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__month-select").selectOption("October");
        $(byText("5")).click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("picture.jpeg");
        $("#currentAddress").setValue("India, NCR, Delhi");
        $(("#state")).click();
        $(byText("NCR")).click();
        $(("#city")).click();
        $(byText("Delhi")).click();
        $("#submit").click();

        //Проверки что поля были заполнены верно:
        $(".table-responsive").shouldHave(text("Alex Petrov"));
        $(".table-responsive").shouldHave(text("alexpetrov@gmail.com"));
        $(".table-responsive").shouldHave(text("Other"));
        $(".table-responsive").shouldHave(text("05 October,1995"));
        $(".table-responsive").shouldHave(text("Math"));
        $(".table-responsive").shouldHave(text("picture.jpeg"));
        $(".table-responsive").shouldHave(text("India, NCR, Delhi"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));

    }
}

