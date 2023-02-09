package pages.ProjeEkleme;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProjeEkleAdimlari
    {
        public ProjeEkleAdimlari()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (id = "newProjectForm-t-0")
    public WebElement projeGenelBilgileriAdimi;

    @FindBy (id = "newProjectForm-t-1")
    public WebElement projeAmaciAdimi;

    @FindBy (id = "newProjectForm-t-2")
    public WebElement projedenBeklenenSonucAdimi;

    @FindBy (id = "newProjectForm-t-3")
    public WebElement projedenEtkilenenlerAdimi;

    @FindBy (id = "newProjectForm-t-4")
    public WebElement projeninOzgunluguAdimi;

    @FindBy (id = "newProjectForm-t-5")
    public WebElement paydaslarVeTeknikYeterlilikAdimi;

    @FindBy (id = "newProjectForm-t-6")
    public WebElement projeAlaniAdimi;

    @FindBy (id = "newProjectForm-t-7")
    public WebElement projeKapsamiAdimi;

    @FindBy (id = "newProjectForm-t-8")
    public WebElement digerAlanlarAdimi;

    @FindBy (id = "newProjectForm-t-9")
    public WebElement projeKapsamindaBeklenenRisklerAdimi;

    @FindBy (id = "newProjectForm-t-10")
    public WebElement isPlaniAdimi;

    @FindBy (id = "newProjectForm-t-11")
    public WebElement butceVeFinansmanKaynaklarAdimi;

    @FindBy (id = "newProjectForm-t-12")
    public WebElement projeHareketKayitlariAdimi;

    @FindBy (id = "newProjectForm-t-13")
    public WebElement yetkiliFirmalarAdimi;

    @FindBy (id = "newProjectForm-t-14")
    public WebElement projeEkDosyalarAdimi;


    }
