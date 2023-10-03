import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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

    @BeforeMethod
    public void driverSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.pollingEvery(Duration.ofMillis(250));
        wait.withTimeout(Duration.ofSeconds(5));
    }


    @Test
    @Parameters ({"username", "password"})
    public void positiveLoginTest (String username, String password){

        System.out.println(username + password);
       // driver.get(BASE_URL);

    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }

}
