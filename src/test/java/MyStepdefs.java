import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import driverUtilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class MyStepdefs {


    WebDriver driver = Driver.getDriver();

    @Given("Go To Trendyol Homepage")
    public void goToTrendyolHomepage() {

        driver.manage().window().maximize();
        driver.get("https://www.trendyol.com");
        driver.findElement(By.xpath("//*[@id=\"gender-popup-modal\"]/div/div/div[1]")).click();

                    }

    @When("Click The Login Button")
    public void clickTheLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"account-navigation-container\"]/div/div[1]/div[1]/p")).click();
    }

    @And("Enter The invalid E-posta")
    public void enterTheInvalidEPosta() {
        driver.findElement(By.id("login-email")).sendKeys("a@abc.com");
    }

    @And("Enter The invalid Password")
    public void enterTheInvalidPassword() {
        driver.findElement(By.id("login-password-input")).sendKeys("123456");
    }

    @And("Click Sign-in button")
    public void clickSignInButton() {
        driver.findElement(By.xpath("//*[@id=\"login-register\"]/div[3]/div[1]/form/button")).click();
    }

    @Then("I see warning")
    public void iSeeWarning() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       String err_msg = driver.findElement(By.xpath("//*[@id=\"error-box-wrapper\"]/span[2]")).getText();

        Assert.assertEquals(err_msg,"E-posta adresiniz ve/veya şifreniz hatalı.");
    }
}
