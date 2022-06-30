package qa.guru;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class SimpleTest {

    @BeforeAll
    static void beforeAll() {

    }

    @AfterAll
    static void afterAll() {

    }

    @BeforeEach
    void openPage() {
        Selenide.open("https://yandex.ru");
    }

    @AfterEach
    void closePage() {
        WebDriverRunner.closeWindow();
    }

    @Test
    void assertTest() {

    }
}
