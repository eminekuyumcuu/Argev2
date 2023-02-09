package pages.ProjeEkleme;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProjedenBeklenenSonuc
{
    public ProjedenBeklenenSonuc()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//*[@id=\"targetsTab\"]/div[1]/div[3]/div[2]")
    public WebElement projedenBeklenenSonucMetinEditoru;

    @FindBy (xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/div[2]/section[3]/form/div/div/div/div[2]/div[1]/div[2]/div[2]/button")
    public WebElement adim3KaydetButton;

}
