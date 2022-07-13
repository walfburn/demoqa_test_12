package qa.guru.pages;

import com.codeborne.selenide.SelenideElement;
import qa.guru.components.CalendarComponents;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPageObject {

    CalendarComponents calendarComponents = new CalendarComponents();
    //locators

    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement genderInput = $("#gender-radio-1");
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement hobbieInput = $("#hobbies-checkbox-2");
    SelenideElement uploadPictureInput = $("#uploadPicture");
    SelenideElement currentAddressInput = $("#currentAddress");
    SelenideElement stateInput = $("#react-select-3-input");
    SelenideElement cityInput = $("#react-select-4-input");
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    SelenideElement tableResponsiveInput = $(".table-responsive");


    //actions

    public RegistrationPageObject openPage(String page) {
        open(page);
        return this;
    }

    public RegistrationPageObject setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;

    }

    public RegistrationPageObject setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;

    }

    public RegistrationPageObject setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;

    }

    public RegistrationPageObject setGender() {
        genderInput.parent().click();
        return this;

    }

    public RegistrationPageObject setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;

    }

    public RegistrationPageObject setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;

    }

    public RegistrationPageObject setHobbies() {
        hobbieInput.parent().click();
        return this;

    }

    public RegistrationPageObject uploadPicture() {
        uploadPictureInput.uploadFromClasspath("img/123.png");
        return this;

    }

    public RegistrationPageObject setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;

    }

    public RegistrationPageObject setState(String state) {
        stateInput.setValue(state).pressEnter();
        return this;

    }

    public RegistrationPageObject setCity(String city) {
        cityInput.setValue(city).pressEnter();
        return this;

    }

    public RegistrationPageObject setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click(); // Ввод даты рождения
        calendarComponents.setDate(day, month ,year);
        return this;

    }

    public RegistrationPageObject checkResult(String key, String value) {
        tableResponsiveInput.$(byText(key)).parent().shouldHave(text(value));
        return this;

    }
}
