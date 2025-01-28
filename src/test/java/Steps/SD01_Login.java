package Steps;

import Utilities.Utility;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.zh_cn.假如;
import org.junit.Assert;
import pages.P01_Login;
import pages.P02_Home;

import java.io.IOException;
import java.text.ParseException;

import static Steps.Hooks.driver;



public class SD01_Login {
    String Username = Utility.getExcelData(0,1,"Sheet1");
    String UsernameII = Faker.instance().name().firstName();
    String PasswordII=Faker.instance().number().digit();

    String Password = Utility.getExcelData(0, 0, "Sheet1");

    public SD01_Login() throws IOException, ParseException, org.json.simple.parser.ParseException {
    }


    @Given("User Enter Valid Username and Password")

    public void fillusernameandpassword_P() {

        new P01_Login(driver).fillusername(this.Username).fillpassword(this.Password);
    }

    @When("User Click Button")
    public void userClickButton() {
        Utility.captureScreenshot(driver, "P_Login");
        new P01_Login(driver).clickonloginbutton();

    }


    @Then("User Shall Navigate to Home Page")
    public void usernavigatetohomepage(){


        Assert.assertTrue(new P02_Home(driver).checkvisabilityofdashboard());
        Utility.captureScreenshot(driver, "P_Login");
    }


    @Given("User Enter Invalid Username and Valid Password")
    public void loginwithinvaliduserandvalidpadd_N(){

        new P01_Login(driver).fillusername(this.UsernameII).fillpassword(this.Password);
    }

    @When("User click login Button")
    public void userClickButtonfornegative(){
        new P01_Login(driver).clickonloginbutton();


    }

    @Then("Error Message should be displayed")
    public void checkinvalidcredentialvisability(){
        Assert.assertTrue(new P01_Login(driver).checkinvalidcredentialvisability());
        Utility.captureScreenshot(driver, "N_Login");
    }

    @Given("User Enter Invalid Password and Valid Username")
    public void loginwithinvalidpassword_N()
    {
        new P01_Login(driver).fillusername(this.Username).fillpassword(this.PasswordII);
    }

    @When("User click on login Button")
    public void clickonloginbutton(){
        Utility.captureScreenshot(driver, "P_Login");
        new P01_Login(driver).clickonloginbutton();

    }

    @Then("Error Message should be displayed II")
    public void checkinvalidcredential(){
        Assert.assertTrue(new P01_Login(driver).checkinvalidcredentialvisability());
        Utility.captureScreenshot(driver, "N_Login");
    }
}
