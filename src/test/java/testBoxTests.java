import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


import java.awt.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class testBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "edge";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1440x900";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void FillFormTest() {
        String userName = "Ivan Ivanov";
        String userEmail = "IvanIvanov@email.com";
        String currentAddress = "city of Moscow 1";
        String permanentAddress = "city of Moscow 2";

        open("/text-box");
        Selenide.executeJavaScript("document.body.style.zoom='100%'");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);
        $("#submit").shouldBe(Condition.visible);
        $("#submit").click();

        $("#output").shouldBe(Condition.visible);
        $("#output #name").shouldHave(text(userName));
        $("#output #email").shouldHave(text(userEmail));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }
}

