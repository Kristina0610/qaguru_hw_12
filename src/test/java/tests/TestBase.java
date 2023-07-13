package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

  @BeforeAll
  static void beforeAll() {
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1520x1080";
    //Configuration.browser = "firefox";
    //Configuration.timeout = 5000;
    //Эта настройка упрощает загрузку сайтов,
    //которые зависят от плохо грузящихся ресурсов
    Configuration.pageLoadStrategy = "eager";
    //Configuration.holdBrowserOpen = true;
  }

  @BeforeEach
  void addListener() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
  }
}

