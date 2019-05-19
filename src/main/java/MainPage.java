import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class MainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(name = "text")
    WebElement requestInput;

    @FindBy(xpath = "/html/body/div[5]/div/div/li[1]/span[3]")
    WebElement temp;

    @FindBy(xpath = "//*[@id=\"feed\"]/div/div")
    WebElement imagesResults;



    public MainPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30);

        PageFactory.initElements(webDriver, this);
    }

    public void checkSearch(String str) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("text")));
        requestInput.clear();
        requestInput.sendKeys(str);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[5]/div/div/li[1]/span[3]")));
        System.out.println(temp.getText());

    }

    public List<WebElement> checkImages() {
        webDriver.get("https://yandex.ru/images");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"feed\"]/div/div/div[2]")));
        List<WebElement> elemens = imagesResults.findElement(By.xpath("//*[@id=\"feed\"]/div/div/div[2]")).findElements(By.tagName("div"));
        return elemens;
    }
}
