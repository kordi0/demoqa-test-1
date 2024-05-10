import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.textCheck;
import static com.codeborne.selenide.Selenide.*;

public class findJUnitExamples {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }
// - Откройте страницу Selenide в Github
// - Перейдите в раздел Wiki проекта
// - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
// - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5

    @Test
    void openWikiPage() {
        //find selenide repository and open it
        open(baseUrl);
        $(".search-input-container").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $("[data-testid=\"results-list\"] div").$("a").click();
        $("#repository-container-header").shouldHave(Condition.text("selenide / selenide"));

        //go to wiki page
        $("a#wiki-tab").click();
        //expand right-menu list
        $("button.js-wiki-more-pages-link").click();
        //SoftAssertions should be the last list item
        $(".wiki-rightbar ul.list-style-none")
                .$$("li.wiki-more-pages").last()
                .shouldHave(Condition.text("SoftAssertions"));

        //click to this menu item
        $(".wiki-rightbar ul.list-style-none")
                .$$("li.wiki-more-pages").last()
                .$("a").click();
        //find the junit5 examples
        $(".markdown-heading a#user-content-3-using-junit5-extend-test-class").parent()
                .$("h4").shouldHave(Condition.text("JUnit5"));
    }

}
