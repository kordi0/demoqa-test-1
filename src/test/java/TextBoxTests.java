import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Dmitrii");
        $("#userEmail").setValue("test@mail.com");
        $("#currentAddress").setValue("pushkina street");
        $("#permanentAddress").setValue("kolotooshkina house");
        $("#submit").click();

        $("#output #name").shouldHave(text("Dmitrii"));
        $("#output #email").shouldHave(text("test@mail.com"));
        $("#output #currentAddress").shouldHave(text("pushkina street"));
        $("#output #permanentAddress").shouldHave(text("kolotooshkina house"));
    }
}