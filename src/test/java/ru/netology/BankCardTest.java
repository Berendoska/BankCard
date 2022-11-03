package ru.netology;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


 class BankCardTest {

      WebDriver driver;
      

     @BeforeEach
     public void init() {

         driver = WebDriverManager.chromedriver().create();
         driver = new ChromeDriver();
         //следующие действия для включения headless режима , ексли их убрать
         //будут видны действия в появляющемся окне (заполнение формы)
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--disable-dev-shm-usage");
         options.addArguments("--no-sandbox");
         options.addArguments("--headless");
         driver = new ChromeDriver(options);
     }


     @AfterEach
     void tearsDown() {
         driver.quit();
         driver = null;
     }

     @Test
     void test() {
         driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
         assertThat(driver.getTitle()).contains("Selenium WebDriver");
     }


     @Test
     void testCard(){
         driver.get("http://localhost:9999");
         List<WebElement> elements = driver.findElements(By.className("input__control"));
         driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Ирова-Иркина Ира");
         driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79888888888");
         driver.findElement(By.className("checkbox__box")).click();
         driver.findElement(By.className("button__text")).click();
         String text = driver.findElement(By.cssSelector("[data-test-id='order-success']")).getText();
         assertEquals("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text);

     }
 }