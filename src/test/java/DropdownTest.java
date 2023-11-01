import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.example.AppPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

public class DropdownTest {

    @BeforeEach
    void setup() {
        Configuration.browser = "chrome";
        Configuration.headless = true;
    }

    @BeforeEach
    void tearDown() {
        Selenide.closeWebDriver();
    }


    @Test
    void test1() throws FileNotFoundException {
        var appPage = Selenide.open("https://the-internet.herokuapp.com/dropdown", AppPage.class);

        var text = "Option 1";
        var selectedOptionText = appPage
                .selectOption(text)
                .getSelectedOption();


        var screenshot = Selenide.screenshot(OutputType.FILE);
        Allure.addAttachment("screenshot", new FileInputStream(screenshot));

        assertThat(selectedOptionText)
                .as("Incorrect dropdown text")
                .isEqualTo(text);
    }

    @Test
    void test2() throws FileNotFoundException {
        var appPage = Selenide.open("https://the-internet.herokuapp.com/dropdown", AppPage.class);

        var text = "Option 1";
        var selectedOptionText = appPage
                .selectOption(text)
                .getSelectedOption();

        var screenshot = Selenide.screenshot(OutputType.FILE);
        Allure.addAttachment("screenshot", new FileInputStream(screenshot));

        assertThat(selectedOptionText)
                .as("Incorrect dropdown text")
                .isEqualTo("sadsd");
    }
}
