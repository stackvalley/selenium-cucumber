package Steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Googlesearch {

    private WebDriver driver;


    @Given("^User navigates to \"([^\"]*)\"$")
    public void userNavigatesTo(String url) {
        System.setProperty("webdriver.chrome.driver", "chromedriver path here");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @And("^User enters \"([^\"]*)\" in the search field$")
    public void userEntersInTheSearchField(String value) throws Throwable {
        WebElement search_Field = driver.findElement(By.name("q"));
        search_Field.click();
        search_Field.sendKeys(value);


    }


    @And("^User clicks on search button$")
    public void userClicksOnSearchButton() throws InterruptedException {
        WebElement searchbtn = driver.findElement(By.name("btnK"));
        searchbtn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^Search results should be displayed successfully and user selects the top result$")
    public void searchResultsShouldBeDisplayedSuccessfully() {
        WebElement search_result = driver.findElement(By.className("TbwUpd"));
        search_result.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String act_Title = driver.getTitle();
        String exp_Title = "\"Hello, World!\" program - Wikipedia";
        if (act_Title.equalsIgnoreCase(exp_Title)) {

            System.out.println("Test has passed");
        } else {

            System.out.println("Test failed!!");
        }

        driver.manage().deleteAllCookies();
        driver.close();
    }

}


