package pages.ProjeEkleme;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class IsPaketi {

    public IsPaketi()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "projectBusinessPlan-tab")
    public WebElement projeIsPaketiTabi;

    @FindBy (xpath = "//*[@id=\"projectBusinessPlanTab\"]/button")
    public WebElement isPlaniEkleButton;

    //İs Paketi 1.Adim İs Paketi Bilgileri
    @FindBy (id = "business_package_company_id")
    public WebElement isPaketiFirmaSelect;
    public void isPaketiFirmaSecme (int index) { new Select(isPaketiFirmaSelect).selectByIndex(index); }

    @FindBy (id = "business_package_no")
    public WebElement isPaketiNoInput;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div/div/div/div[2]/section[11]/div[1]/div/div/div[2]/div/form/div/div[2]/section[1]/div/div/div[3]/div/div[1]/select")
    public WebElement isPaketiFaliyetTuruSelect;

    public void faliyetTuruSecme (int index) { new Select(isPaketiFaliyetTuruSelect).selectByIndex(index);}

    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div/div/div/div[2]/section[11]/div[1]/div/div/div[2]/div/form/div/div[2]/section[1]/div/div/div[3]/div/div[1]/div/button[2]")
    public WebElement faliyetTuruSecimButton;

    @FindBy (id = "business_package_name")
    public WebElement isPaketiAdiInput;

    @FindBy (id = "business_package_leader_id")
    public WebElement isPaketiLideriSelect;

    public void isPaketiLideriSecme (int index) { new Select(isPaketiLideriSelect).selectByIndex(index);}

    @FindBy (id = "start_date")
    public WebElement isPaketiBaslangicTarihiInput;

    @FindBy (id = "end_date")
    public WebElement isPaketiBitisTarihiInput;

    @FindBy (className = "custom-control-label")
    public WebElement isPaketiDurumuStatus;

    //İs Paketi 2.Adim Detay

    @FindBy (xpath = "//*[@id=\"newProjectBusinessPlanFormWizard-p-1\"]/div/div[1]/div/div/div[3]/div[2]")
    public WebElement isPaketiDetayMetinEditoru;

    @FindBy (xpath = "//*[@id=\"newProjectBusinessPlanFormWizard-p-1\"]/div/div[2]/div/div/div[3]/div[2]")
    public WebElement isPaketiTamamlanacakGorevlerMetinEditoru;

    //İs Paketi 3.Adim Is Paketi Paydaslari

    @FindBy (xpath = "//*[@id=\"newProjectBusinessPlanFormWizard-p-2\"]/div/div[1]/button")
    public WebElement isPaketinePaydasEkleButton;

    @FindBy (linkText = "İleri")
    public WebElement isPaketiIleriButton;

    @FindBy (linkText = "Kaydet")
    public WebElement isPaketiIleriKaydetButton;

    @FindBy(xpath = "//*[contains(@id,'stakeholder_id') and contains(@name,'stakeholder_id')]")
    public List<WebElement> stakeHolderList;

    @FindBy(xpath = "//*[contains(@id,'output') and contains(@name,'output') and contains(@placeholder,'Çıktı')]")
    public List<WebElement> outputList;

    @FindBy(xpath = "//*[contains(@id,'output_') and contains(@name,'output_')]")
    public List<WebElement> outputListDate;

    @FindBy(xpath = "//*[@id=\"newProjectBusinessPlanFormWizard-p-3\"]/div/div[1]/button")
    public WebElement ciktiEkleButton;

    @FindBy(xpath = "//*[contains(@class,\"swal2-confirm\")]")
    public WebElement HERYERDEGECERLITAMAMBUTONU;




    public void paydasSectir() throws InterruptedException {
        int ii = 0;
        for (WebElement element : stakeHolderList) {
            if(ii == 0)
            {
                new Select(element).selectByVisibleText(ConfigReader.getProperty("proje_Yurutucusu") + " (Proje Yürütücüsü)");
            }
            if(ii == 1)
            {
                new Select(element).selectByVisibleText(ConfigReader.getProperty("danisman") + " (Danışman)");
            }
            if(ii > 1)
            {
                new Select(element).selectByIndex(ii);
            }

            ii++;
            //bekle();
        }
    }

    public void ciktiSectir() throws InterruptedException {
        int i = 1;
        for (WebElement element : outputList) {
            element.sendKeys(Integer.toString(i) + ". Çıktı");
            i++;
          //  bekle();
        }
    }

    public void ciktiTarihSectir() throws InterruptedException {
        int i = 1;
        for (WebElement element : outputListDate) {
            element.sendKeys(Integer.toString(i));
            i++;
           // bekle();
        }
    }



}
