package Steps;

import Utilities.Utility;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.P01_Login;
import pages.P02_Home;
import pages.P03_AdminViewSystemUser;

import static Steps.Hooks.driver;

public class SD03_AddEmployee {
    String Username = Utility.getExcelData(0,1,"Sheet1");
    String Password = Utility.getExcelData(0, 0, "Sheet1");
    String Newusername = Faker.instance().name().username().substring(0, 7);
    String NewEmployeeName = Faker.instance().regexify("[a-z]{1}");
    String PasswordI = Faker.instance().internet().password(7, 12);
    @Given("User Choose TO Add New Employee")
    public void clickonaddemployee(){
        new P01_Login(driver).fillusername(this.Username).fillpassword(this.Password).clickonloginbutton();
        new P02_Home(driver).openadmin();
        new P03_AdminViewSystemUser(driver).clickonaddbutton();
    }

    @When("User fill All Mandatory Fields Required")
    public void fillnewemployeedata() throws InterruptedException {
        new P03_AdminViewSystemUser(driver).selectnewrole().selectstatus().chooseemployeename(NewEmployeeName)
                .fillusername(Newusername).fillpassword(PasswordI).fillconfirmpassword(PasswordI).clickonsavebutton();
        Utility.captureScreenshot(driver,"Fill Employee Data");
    }

    @Then("New Employee Should be Added")
    public void validateaddingnewemployee(){
        Utility.captureScreenshot(driver,"Navigation After Adding Employee");
        Assert.assertTrue(new P03_AdminViewSystemUser(driver).checkcurrenturl());
    }
}
