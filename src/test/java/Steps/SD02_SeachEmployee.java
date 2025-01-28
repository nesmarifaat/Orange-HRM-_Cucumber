package Steps;

import Utilities.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;
import pages.P01_Login;
import pages.P02_Home;
import pages.P03_AdminViewSystemUser;

import static Steps.Hooks.driver;

public class SD02_SeachEmployee {
    String Username = Utility.getExcelData(0,1,"Sheet1");
    String Password = Utility.getExcelData(0, 0, "Sheet1");

    @Given("User Choose Admin From Side Menu")

    public void openadmin(){
        new P01_Login(driver).fillusername(this.Username).fillpassword(this.Password).clickonloginbutton();
        new P02_Home(driver).openadmin();
    }

    @When("User fill System User Information and search")
    public void fillinformation(){
        new P03_AdminViewSystemUser(driver).selectrole().selectstatus().clickonsearchbutton();
    }

    @Then("Data Should be Displaying inside Record Grid")
    public void checkvisabilityoftrashiocn(){
        SoftAssert softassert= new SoftAssert();
        softassert.assertTrue(new P03_AdminViewSystemUser(driver).checksearchrecord());
        Utility.captureScreenshot(driver,"Search Employee");
    }
}
