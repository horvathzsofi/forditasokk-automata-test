import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
        fillForm("Sajt", "Alma");
        String actualMessage = login.getErrorMessage();
        String expectedMessage = "Nem megfelelő felhasználónév vagy jelszó.";
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void displayFailedLoginMessage(){
        fillForm("asd", "asdhasjhdksj");
        boolean actual = login.ErrorMessage().isDisplayed();
        Assertions.assertTrue(actual);
    }
}
