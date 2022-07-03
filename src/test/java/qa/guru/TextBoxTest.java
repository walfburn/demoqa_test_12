package qa.guru;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {

        open("/text-box");
        $("[id=userName").setValue("asdasd");
        $("[id=userEmail").setValue("vsasfasfasf87@mail.ru");
        $("[id=currentAddress").setValue("St123");
        $("[id=permanentAddress").setValue("St4123");
        $("[id=submit").click();

        $("[id=output]").$("[id=name]").shouldHave(text("asdasd"));
    }
}
