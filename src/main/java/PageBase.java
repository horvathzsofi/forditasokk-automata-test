import org.openqa.selenium.WebDriver;

public class PageBase {
    WebDriver webDriver;

    protected PageBase(WebDriver driver) {
        this.webDriver = driver;
    }
}
