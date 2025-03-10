package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;

public class P02_Home {
    WebDriver driver;

    public P02_Home(WebDriver driver) {
        this.driver = driver;
    }

    //TODO: click on Admin

    private final By admin = By.xpath("//li[1]//a[1]//span[1]");

    public P02_Home openadmin() {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(admin));
        driver.findElement(this.admin).click();
        return this;
    }

    //TODO: Fill Username


    private final By pim = By.xpath("(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[2]");

    public P02_Home clickonpim() {
        driver.findElement(this.pim).click();
        return this;
    }

    private final By dashboard = By.xpath("//h6");

    public Boolean checkvisabilityofdashboard() {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated((dashboard) ));
        return driver.findElement(this.dashboard).isDisplayed();
    }
}
