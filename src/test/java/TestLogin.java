import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestLogin extends TestingSetup {
    Login login = null;

    private void fillForm(String username, String password){
        login.navigateToPage();
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickOnButton();
    }

    @BeforeEach
    public void createLogin() {
        login = new Login(webDriver);
    }

    @Test
    public void correctFailedLoginMessage(){
        fillForm("veloje", "asd");
        String actualMessage = login.getErrorMessage();
        String expectedMessage = "Nem megfelelő felhasználónév vagy jelszó.";
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void displayFailedLoginMessage(){
        String username = "Veloje";
        String password = "a";
        fillForm(username, password);
        String actual = login.getLoggedInUsername();
        Assertions.assertEquals(username, actual);
    }
}
