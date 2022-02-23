package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll

    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "3072x1920";
    }
    @Test
    void successFillTest() {

        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));
        $("#userName").setValue("Alex");
        $("#userEmail").setValue("alexcompany@gmail.com");
        $("#currentAddress").setValue("address1");
        $("#permanentAddress").setValue("address2");
        $("#submit").click();

        $("#output").shouldHave(text("Alex") , text("alexcompany@gmail.com"), text("address1"), text("address2"));

        $("#name").shouldHave(text("Alex"));
        $("#currentAddress", 1).shouldHave(text("address1"));
        $("#output #currentAddress").shouldHave(text("address1"));


    }
}
