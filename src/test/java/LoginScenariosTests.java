import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LoginScenariosTests {

    ChromeDriver driver;
    FluentWait wait;
    final String BASE_URL = "http://training.skillo-bg.com:4200";
    final String HOME_URL = BASE_URL + "/posts/all";
    final String LOGIN_URL = BASE_URL + "/users/login";
    final String USER_URL = BASE_URL + "/users/4068";

    @DataProvider(name = "validUser")
    public Object[][] getUser() {
        return new Object[][]{
                {"auto_user", "auto_pass"}
        };
    }


    @BeforeMethod
    public void driverSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.pollingEvery(Duration.ofMillis(250));
        wait.withTimeout(Duration.ofSeconds(5));
    }


    @Test(dataProvider = "validUser")
    // @Parameters ({"username", "password"})
    // public void positiveLoginTest(String username, String password) {
    public void positiveLoginTest(String username, String password) {

        System.out.println("Open home page");
        driver.get(BASE_URL);

        System.out.println("Click 'Login' button");
        WebElement loginButton = driver.findElement(By.id("nav-link-login"));
//        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
//        loginButton.click();
        clickButton(loginButton);

        System.out.println("Verify that you reach login page");




    }

    @AfterMethod
    public void closeDriver() {
        driver.close();
    }

    public void clickButton(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();

    }

}
