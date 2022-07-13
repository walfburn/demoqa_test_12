package qa.guru;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import qa.guru.pages.RegistrationPageObject;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    Faker faker = new Faker();
    Faker fakerRu = new Faker(new Locale("ru"));
    RegistrationPageObject registrationPageObject = new RegistrationPageObject();

    String file = "123.png";
    String firstName = fakerRu.name().firstName();
    String lastName = fakerRu.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String dateOfBirth = "11 June,1994";
    String userNumber = "1234567891";
    String subject = "Maths";
    String currentAddress = faker.address().fullAddress();
    String state = "NCR";
    String city = "Delhi";
    String gender = "Male";
    String hobbie = "Reading";
    String page = "/automation-practice-form";
    String fullName = firstName + " " + lastName;
    String fullLocation = state + " " + city;


    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void fillFormTest() {

        registrationPageObject.openPage(page)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender()
                .setUserNumber(userNumber)
                .setDateOfBirth("11", "June", "1994")
                .setSubject(subject)
                .setHobbies()
                .uploadPicture()
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city);


        $("#submit").click();

        registrationPageObject.checkResult(fullName, fullName);
        registrationPageObject.checkResult(userEmail, userEmail);
        registrationPageObject.checkResult(gender, gender);
        registrationPageObject.checkResult(userNumber, userNumber);
        registrationPageObject.checkResult(dateOfBirth, dateOfBirth);
        registrationPageObject.checkResult(subject, subject);
        registrationPageObject.checkResult(hobbie, hobbie);
        registrationPageObject.checkResult(file, file);
        registrationPageObject.checkResult(currentAddress, currentAddress);
        registrationPageObject.checkResult(fullLocation, fullLocation);

    }
}
