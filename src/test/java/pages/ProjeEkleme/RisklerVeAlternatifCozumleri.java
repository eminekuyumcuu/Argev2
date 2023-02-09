package pages.ProjeEkleme;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RisklerVeAlternatifCozumleri {

    public RisklerVeAlternatifCozumleri()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "technicalRisk-tab")
    public WebElement risklerVeAlternatifCozumleriTabi;

    @FindBy (xpath = "//*[@id=\"technicalRiskTab\"]/div[1]/div[3]/div[2]")
    public WebElement risklerVeAlternatifCozumleriMetinEditoru;

    @FindBy (xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/div[2]/section[10]/form/div/div/div/div[2]/div[1]/div[2]/div[2]/button")
    public WebElement adim10KaydetButton;



}
