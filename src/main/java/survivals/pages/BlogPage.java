package survivals.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlogPage {
    private final String className = getClass().getName();
    private final WebDriver driver;
    private final By logoButtonBy = By.className("elementor-element-f17a051");

    public BlogPage(WebDriver driver) {
        System.out.println("We assume that we're on the " + className + ".");
        this.driver = driver;
    }

    public void clickLogoAndBackToHomePage() throws InterruptedException {
        System.out.println(className + ": We click on the logo.");
        WebElement logoButton = driver.findElement(logoButtonBy);
        logoButton.click();
        Thread.sleep(1000);
    }
}
