package pages.Common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class Common
{
    public Common()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (className = "custom-control-label")
    public WebElement aktifPasifCheckbox;

    @FindBy (xpath = "/html/body/div[2]/div/div[3]/button[1]")
    public WebElement popupUyariMesajiOnayla;

    @FindBy(xpath = "//*[contains(@class,\"swal2-confirm\")]")
    public WebElement HERYERDEGECERLITAMAMBUTONU;


    public Thread bekle() throws InterruptedException {
        Thread.sleep(Long.parseLong(ConfigReader.getProperty("beklemeSuresi")));
        return null;
    }


}
