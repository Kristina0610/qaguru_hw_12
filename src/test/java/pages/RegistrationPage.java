package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.ResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
  @Step("Открываем страницу регистрации")
  public RegistrationPage openPage() {
    open("/automation-practice-form");

    return this;
  }

  @Step("Удаляем header")
  public RegistrationPage removeHeader() {

    executeJavaScript("$('header').remove()");

    return this;
  }

  @Step("Удаляем footer")
  public RegistrationPage removeFooter() {

    executeJavaScript("$('footer').remove()");

    return this;
  }

  @Step("Удаляем окно с рекламой")
  public RegistrationPage removeBanners() {

    executeJavaScript("$('#fixedban').remove()");

    return this;
  }

  @Step("Заполняем имя")
  public RegistrationPage setFirstNameInput(String value) {
    firstNameInput.setValue(value);

    return this;
  }

  @Step("Заполняем фамилию")
  public RegistrationPage setLastNameInput(String value) {
    lastNameInput.setValue(value);

    return this;
  }

  @Step("Заполняем Email")
  public RegistrationPage setUserEmailInput(String value) {
    userEmailInput.setValue(value);

    return this;
  }

  @Step("Заполняем пол")
  public RegistrationPage setGender(String value) {
    gender.$(byText(value)).click();

    return this;
  }

  @Step("Заполняем номер телефона")
  public RegistrationPage setNumber(String value) {
    userNumber.setValue(value);

    return this;
  }


  @Step("Заполняем дату рождения")
  public RegistrationPage setBirthDate(String day, String month, String year) {
    dateOfBirthInput.click();
    calendarComponent.setDate(day, month, year);

    return this;
  }

  @Step("Выбираем хобби")
  public RegistrationPage setHobby(String value) {
    hobby.$(byText(value)).click();

    return this;
  }

  @Step("Заполняем предмет")
  public RegistrationPage setSubjectInput(String value) {
    subjectInput.setValue(value).pressEnter();

    return this;
  }

  @Step("Загружаем файл")
  public RegistrationPage uploadFile() {
    fileUpload.uploadFile(new File("src/test/resources/screenshot_1.png"));

    return this;
  }

  @Step("Заполняем адрес")
  public RegistrationPage setCurrentAddress(String value) {
    currentAddress.setValue(value);

    return this;
  }

  @Step("Выбираем из списка штат")
  public RegistrationPage setState(String value) {
    state.click();
    $(byText(value)).click();

    return this;
  }

  @Step("Выбираем из списка город {value}")
  public RegistrationPage setCity(String value) {
    city.click();
    $(byText(value)).click();

    return this;
  }

  @Step("Нажимаем кнопку Button")
  public RegistrationPage clickButton() {
    button.click();

    return this;
  }

  @Step("Проверяем, что все параметры заполнены верно")
  public RegistrationPage verifyRegistrationResultsModalAppears() {
    resultsModal.verifyModalAppears();
    return this;
  }

  @Step("Проверяем отображение модального окна")
  public RegistrationPage verifyResult(String key, String value) {
    resultsModal.verifyResult(key, value);

    return this;
  }
}


