package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

  @BeforeAll
  static void beforeAll() {
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1520x1080";
    Configuration.browser = "firefox";
    //Configuration.timeout = 5000;
    //Эта настройка упрощает загрузку сайтов,
    //которые зависят от плохо грузящихся ресурсов
    Configuration.pageLoadStrategy = "eager";
    //Configuration.holdBrowserOpen = true;
  }
}

