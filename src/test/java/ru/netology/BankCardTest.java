package ru.netology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import  java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class BankCardTest {
     private WebDriver driver;


     @BeforeAll
     static void setUp() {
         System.setProperty("webdriver.chrome.driver", "driver/chrome/chromedriver.exe");
     }


     @BeforeEach
     void Init() {
         driver = new ChromeDriver();
     }


     @AfterEach
     void tearsDown() {
         driver.quit();
         driver = null;
     }

     @Test
     void shouldTestSomething() {
         driver.get("http://localhost:9999");
     }

     @Test
     void testCard(){
         driver.get("http://localhost:9999");
         List<WebElement> elements = driver.findElements(By.className("input__control"));
         elements.get(0).sendKeys("Ирова Ира");
         elements.get(1).sendKeys("+79889889898");
         driver.findElement(By.className("checkbox__box")).click();
         driver.findElement(By.className("button__text")).click();
         String text = driver.findElement(By.className("paragraph")).getText();
         assertEquals("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text);

     }
 }