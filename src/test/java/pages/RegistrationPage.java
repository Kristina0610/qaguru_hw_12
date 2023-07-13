package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
  // SelenideElements / locator / etc

  CalendarComponent calendarComponent = new CalendarComponent();

  ResultsModal resultsModal = new ResultsModal();

  SelenideElement
          firstNameInput = $("#firstName"),
          lastNameInput = $("#lastName"),
          userEmailInput = $("#userEmail"),
          gender = $("#genterWrapper"),
          userNumber = $("#userNumber"),
          dateOfBirthInput = $("#dateOfBirthInput"),
          hobby = $("#hobbiesWrapper"),
          subjectInput = $("#subjectsInput"),
          fileUpload = $("#uploadPicture"),
          currentAddress = $("#currentAddress"),
          state = $("#state"),
          city = $("#city"),
          button = $("#submit");

  // Actions
  public RegistrationPage openPage() {
    open("/automation-practice-form");

    return this;
  }

  public RegistrationPage removeHeader() {

    executeJavaScript("$('header').remove()");

    return this;
  }

  public RegistrationPage removeFooter() {

    executeJavaScript("$('footer').remove()");

    return this;
  }

  public RegistrationPage setFirstNameInput(String value) {
    firstNameInput.setValue(value);

    return this;
  }

  public RegistrationPage setLastNameInput(String value) {
    lastNameInput.setValue(value);

    return this;
  }

  public RegistrationPage setUserEmailInput(String value) {
    userEmailInput.setValue(value);

    return this;
  }

  public RegistrationPage setGender(String value) {
    gender.$(byText(value)).click();

    return this;
  }

  public RegistrationPage setNumber(String value) {
    userNumber.setValue(value);

    return this;
  }


  public RegistrationPage setBirthDate(String day, String month, String year) {
    dateOfBirthInput.click();
    calendarComponent.setDate(day,month,year);

    return this;
  }

  public RegistrationPage setHobby(String value) {
    hobby.$(byText(value)).click();

    return this;
  }

  public RegistrationPage setSubjectInput(String value) {
    subjectInput.setValue(value).pressEnter();

    return this;
  }

  public RegistrationPage uploadFile() {
    fileUpload.uploadFile(new File("src/test/resources/screenshot_1.png"));

    return this;
  }

  public RegistrationPage setCurrentAddress(String value) {
    currentAddress.setValue(value);

    return this;
  }

  public RegistrationPage setState(String value) {
    state.click();
    $(byText(value)).click();

    return this;
  }


  public RegistrationPage setCity(String value) {
    city.click();
    $(byText(value)).click();

    return this;
  }

  public RegistrationPage clickButton() {
    button.click();

    return this;
  }

  public RegistrationPage verifyRegistrationResultsModalAppears() {
    resultsModal.verifyModalAppears();
    return this;
  }

  public RegistrationPage verifyResult(String key, String value) {
    resultsModal.verifyResult(key, value);

    return this;
  }
}


