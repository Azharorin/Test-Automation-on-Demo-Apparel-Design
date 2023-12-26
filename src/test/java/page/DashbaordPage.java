package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashbaordPage {
    @FindBy(xpath = "//*[@id=\"root\"]/section/main/div[2]/div[2]/section/div/h1")
    public WebElement txtDashbaord;
    @FindBy(css = "p[class='tw-text-base tw-font-semibold tw-capitalize tw-m-0'] span")
    public WebElement txtAdmin_name;

    public DashbaordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
