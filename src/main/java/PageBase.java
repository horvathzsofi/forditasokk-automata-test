import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageBase {
    WebDriver webDriver;
    // private String url = "http://forditasokk.probaljaki.hu/";

    protected PageBase(WebDriver driver) {
        this.webDriver = driver;
    }

    protected void navigateToPage(String url){
        webDriver.navigate().to(url);
    }

    protected void clickOnIt(By elementIdentifier){
        webDriver.findElement(elementIdentifier).click();
    }

    protected void userInput(By elementIdentifier, String input){
        webDriver.findElement(elementIdentifier).sendKeys(input);
    }

    protected String getData(By elementIdentifier){
        String data = webDriver.findElement(elementIdentifier).getText();
        return data;
    }

    protected List<WebElement> getWebElements(By elementIdentifier){
        List<WebElement> listOfElements = webDriver.findElements(elementIdentifier);
        return listOfElements;
    }

    protected WebElement getElement(By elementIdentifier){
        return webDriver.findElement(elementIdentifier);
    }
}
