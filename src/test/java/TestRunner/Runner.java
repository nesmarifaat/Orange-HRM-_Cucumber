package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.*;



@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/Features", glue = { "Steps" }, monochrome = true, plugin = {
        "pretty", "html:target/HtmlReports/report.html", "json:target/JsonReport/report.json",
        "junit:target/JunitReport/report.xml" },
        tags = "@LoginTest or @SearchEmployee or @AddNewEmployee"


)


public class Runner {

}


