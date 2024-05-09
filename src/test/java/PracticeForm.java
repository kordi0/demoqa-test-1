import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {
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
        //open tha page
        open("/automation-practice-form");

        //fill in the form
        $("#firstName").setValue("Dmitrii");
        $("#lastName").setValue("Korolev");
        $("#userEmail").setValue("testmail@ggggg.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("88005553535");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("November")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("1993")).click();
        $(".react-datepicker__month-container").$(byText("29")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbies-checkbox-3").parent().$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("#currentAddress").setValue("Address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();
        $(".modal-open").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Dmitrii Korolev"));
        $(".modal-body").shouldHave(text("testmail@ggggg.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("8800555353"));
        $(".modal-body").shouldHave(text("29 November,1993"));
        $(".modal-body").shouldHave(text("English"));
        $(".modal-body").shouldHave(text("Music"));
        $(".modal-body").shouldHave(text("Address"));
        $(".modal-body").shouldHave(text("Uttar Pradesh Agra"));
        $("#closeLargeModal").click();


    }
}
