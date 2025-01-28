package Steps;

import com.github.javafaker.Faker;
import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import static drivers.DriverHolder.setDriver;

public class Hooks {
    static WebDriver driver;

Faker faker=new Faker();
    @Before
    public void setupdriver(){


        this.driver = DriverFactory.getNewInstance("");

        setDriver(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }


    @After
    public void tearDown(){
        this.driver.quit();

    }
}
