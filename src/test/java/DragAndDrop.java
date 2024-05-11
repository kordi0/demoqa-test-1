import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void dragAndDropByActions() {
        open("drag_and_drop");
        SelenideElement columnA = $("div#column-a");
        SelenideElement columnB = $("div#column-b");

        actions().clickAndHold(columnA)
                .moveToElement(columnB)
                .release(columnB)
                .perform();
    }

    @Test
    void dragAndDrop() {
        open("drag_and_drop");
        $("div#column-a").dragAndDrop(DragAndDropOptions.to("div#column-b"));

    }
}
