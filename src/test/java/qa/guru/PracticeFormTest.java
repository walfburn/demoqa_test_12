package qa.guru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void fillFormTest() {
        File file = new File("C:\\Users\\Vladimir\\Desktop\\photo_2019-02-11_16-39-08.jpg");
        String firstName = "VV";
        String lastName = "SS";
        String userEmail = "VS@asldalsdjklas.com";
        String dateOfBirth = "11 June,1994";
        String userNumber = "1234567899";
        String subject = "Maths";
        String currentAddress = "Street 1";
        String state = "NCR";
        String city = "Delhi";

        open("/automation-practice-form");

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(userEmail);
        $(byText("Male")).click();
        $("[id=userNumber]").setValue(userNumber);
        $("[id=dateOfBirthInput]").click(); // Ввод даты рождения
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1994");
        $("[aria-label$='June 11th, 1994']").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFile(file);
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=react-select-3-input]").setValue(state).pressEnter();
        $("[id=react-select-4-input]").setValue(city).pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName),
                text(userEmail),
                text("Male"),
                text(userNumber),
                text(dateOfBirth),
                text(subject),
                text("Reading"),
                text("photo_2019-02-11_16-39-08.jpg"),
                text(currentAddress),
                text(state + " " + city)
        );
    }
}
