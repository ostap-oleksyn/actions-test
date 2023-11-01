package org.example;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class AppPage {

    private final SelenideElement dropdown = $("#dropdown");

    @Step("Selected dropdown option {text}")
    public AppPage selectOption(String text) {
        dropdown.selectOption(text);

        return this;
    }

    public String getSelectedOption() {
        return dropdown.getSelectedOptionText();
    }
}
