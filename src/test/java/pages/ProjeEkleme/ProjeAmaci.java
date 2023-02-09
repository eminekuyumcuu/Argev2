package pages.ProjeEkleme;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProjeAmaci
{
    public ProjeAmaci()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//*[@id=\"projectInfoDetailTab\"]/div[1]/div[3]/div[2]")
    public WebElement projeOzetiMetinEditoru;

    @FindBy (id = "projectPurpose-tab")
    public WebElement projeAmaciTabi;

    @FindBy (xpath = "//*[@id=\"projectPurposeTab\"]/div[1]/div[3]/div[2]")
    public WebElement projeAmaciMetinEditoru;

    @FindBy (id = "projectInfoSector-tab")
    public WebElement sektorTabi;

    @FindBy (xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/div[2]/section[2]/form/div/div/div/div[3]/div[2]/div[2]/div[2]/button")
    public WebElement adim2KaydetButton;

}
