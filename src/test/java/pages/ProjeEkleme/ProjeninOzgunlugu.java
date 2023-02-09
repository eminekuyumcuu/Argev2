package pages.ProjeEkleme;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProjeninOzgunlugu

{
    public ProjeninOzgunlugu()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "innovativeAspect-tab")
    public WebElement projeninOzgunluguTabi;

    @FindBy (xpath = "//*[@id=\"innovativeAspectTab\"]/div[1]/div[3]/div[2]")
    public WebElement projeninOzgunluguMetinEditoru;

    @FindBy (id = "addedValue-tab")
    public WebElement projeninBeklenenKatmaDegeriTabi;

    @FindBy (xpath = "//*[@id=\"addedValueTab\"]/div[1]/div[3]/div[2]")
    public WebElement projeninBeklenenKatmaDegeriMetinEditoru;

    @FindBy (xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/div[2]/section[5]/form/div/div/div/div[2]/div[2]/div[2]/div[2]/button")
    public WebElement adim5KaydetButton;

}
