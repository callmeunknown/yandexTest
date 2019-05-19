import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class YandexTest {
    WebDriver webDriver;
    MainPage mainPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();

        mainPage = new MainPage(webDriver);

        webDriver.get("https://yandex.ru/");

    }

    @Test
    public void checkSearch() {
        mainPage.checkSearch("погода");
    }

    @Test
    public void checkSearch2() {
        mainPage.checkSearch("погода липецк");
    }

    @Test
    public void checkSearch3() {
        mainPage.checkSearch("погода лото");
    }

    @Test
    public void cheackImages() {
        List<WebElement> elements = mainPage.checkImages();
        for(WebElement el: elements) {
            Assert.assertTrue(el.isDisplayed());
        }

    }
}
