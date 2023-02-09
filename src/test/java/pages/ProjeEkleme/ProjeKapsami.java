package pages.ProjeEkleme;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProjeKapsami {


    public ProjeKapsami()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"keywordsTab\"]/button")
    public WebElement kelimeEkleButton;

    @FindBy (id = "keyword_title")
    public WebElement kelimeAdiInput;

    @FindBy (id = "project_keyword_save_btn")
    public WebElement kelimeKaydetButton;

    @FindBy (id = "projectDetail-tab")
    public WebElement projeKapsamiTabi;

    @FindBy (xpath = "//*[@id=\"projectDetailTab\"]/div[1]/div[3]/div[2]")
    public WebElement projeKapsamiMetinEditoru;

    @FindBy (id = "projectInspiredBySource-tab")
    public WebElement faydalanilanKaynaklarTabi;

    @FindBy (xpath = "//*[@id=\"projectInspiredBySourceTab\"]/div[1]/div[3]/div[2]")
    public WebElement faydalanilanKaynaklarMetinEditoru;

    @FindBy (id = "projectTechnicalDetail-tab")
    public WebElement projeTeknikAciklamasiTabi;

    @FindBy (xpath = "//*[@id=\"projectTechnicalDetailTab\"]/div[1]/div[3]/div[2]")
    public WebElement projeTeknikAciklamasiMetinEditoru;

    @FindBy (id = "projectExpectedData-tab")
    public WebElement projedenBeklenenVerilerTabi;

    @FindBy (xpath = "//*[@id=\"projectExpectedDataTab\"]/div[1]/div[3]/div[2]")
    public WebElement projedenBeklenenVerilerMetinEditoru;

    @FindBy (xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/div[2]/section[8]/form/div/div/div/div[3]/div[4]/div[2]/div[2]/button")
    public WebElement adim8KaydetButton;



}
