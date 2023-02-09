package pages.ProjeEkleme;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DigerAlanlar {

    public DigerAlanlar()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "sectoralContribution-tab")
    public WebElement projeninSektoreOlasiEtkileriTabi;

    @FindBy (xpath = "//*[@id=\"sectoralContributionTab\"]/div[1]/div[3]/div[2]")
    public WebElement projeninSektoreOlasiEtkileriMetinEditoru;

    @FindBy (id = "staffContribution-tab")
    public WebElement projeninSirketCalisanlarinaOlasiEtkileriTabi;

    @FindBy (xpath = "//*[@id=\"staffContributionTab\"]/div[1]/div[3]/div[2]")
    public WebElement projeninSirketCalisanlarinaOlasiEtkileriMetinEditoru;

    @FindBy (id = "otherContribution-tab")
    public WebElement projeninOlasiSosyalEtkileriTabi;

    @FindBy (xpath = "//*[@id=\"otherContributionTab\"]/div[1]/div[3]/div[2]")
    public WebElement projeninOlasiSosyalEtkileriMetinEditoru;

    @FindBy (xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/div[2]/section[9]/form/div/div/div/div[2]/div[3]/div[2]/div[2]/button")
    public WebElement adim9KaydetButton;



}
