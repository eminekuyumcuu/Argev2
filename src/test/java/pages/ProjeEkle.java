package pages;

import org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;


public class ProjeEkle{

    public ProjeEkle() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    public Thread bekle() throws InterruptedException {
        Thread.sleep(Long.parseLong(ConfigReader.getProperty("beklemeSuresi")));
        return null;
    }


    @FindBy (xpath = "/html/body/div[2]/div/div[3]/button[1]")
    public WebElement popupUyariMesajiOnayla;


    // PROJE EKLEME ADIMLARI

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


    // 1.ADIM PROJE GENEL BİLGİLERİ
    @FindBy(id = "company_kind")
    public WebElement dagitimSirketiTuruSelect;

    @FindBy(id = "company_id")
    public WebElement dagitimSirketiSelect;

    @FindBy(id = "name")
    public WebElement projeAdiInput;

    @FindBy(id = "project_category_id")
    public WebElement projeKategoriSelect;

    @FindBy(id = "project_kind_id")
    public WebElement projeTuruSelect;

    @FindBy(id = "project_responsible_id")
    public WebElement projeSorumlusuSelect;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div/div/div/div[2]/section[1]/form/div/div[3]/div[1]/div/div/div[1]/select")
    public WebElement projeBolgesiSelect;

    @FindBy(xpath = "//*[@id=\"projectGeneralInformationForm\"]/div/div[3]/div[1]/div/div/div[1]/div/button[2]")
    public WebElement bolgeSecimButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div/div/div/div[2]/section[1]/form/div/div[3]/div[2]/div/div/div[1]/select")
    public WebElement projeOrtaklariSelect;

    @FindBy(xpath = "//*[@id=\"project_partner\"]/div/div/div[1]/div/button[2]")
    public WebElement ortakSecimButton;

    @FindBy(id = "time")
    public WebElement projeSuresiInput;

    @FindBy(id = "start_date")
    public WebElement takvimButton;

    @FindBy(className = "monthselect")
    public WebElement takvimAySecim;

    @FindBy(className = "yearselect")
    public WebElement takvimYilSecim;

    @FindBy(css = "body > div.daterangepicker.ltr.auto-apply.single.opensright.show-calendar > div.drp-calendar.left.single > div.calendar-table > table > tbody > tr:nth-child(3) > td:nth-child(4)")
    public WebElement tahminiBaslangicTarihiCalender;

    @FindBy(id = "project_period")
    public WebElement projeDonemiInput;

    public void dagitimTuruSecme(int index) {
        new Select(dagitimSirketiTuruSelect).selectByIndex(index);
    }

    public void dagitimSirketiSecme(int value) {
        new Select(dagitimSirketiSelect).selectByValue(Integer.toString(value));
    }

    public void projeKategoriSecme(int index) {
        new Select(projeKategoriSelect).selectByIndex(index);
    }

    public void projeTuruSecme(int index) {
        new Select(projeTuruSelect).selectByIndex(index);
    }

    public void projeSorumlusuSecme(int index) {
        new Select(projeSorumlusuSelect).selectByIndex(index);
    }

    public void projeBolgesiSecimi(int index) {
        new Select(projeBolgesiSelect).selectByIndex(index);
    }

    public void projeOrtakSecme(int index) { new Select(projeOrtaklariSelect).selectByIndex(index); }

    public void baslangicAySecme(int index) { new Select(takvimAySecim).selectByIndex(index); }

    public void baslangicYilSecme(int index) { new Select(takvimYilSecim).selectByIndex(index); }

    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div/div/div/div[2]/section[1]/form/div/div[5]/div[2]/button")
    public WebElement adim1KaydetButton;


    // 2.ADIM PROJE AMACI

    @FindBy (xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/div[2]/section[2]/form/div/div/div/div[3]/div[1]/div[1]/div[3]/div[2]")
    public WebElement projeOzetiMetinEditoru;

    @FindBy (id = "projectPurpose-tab")
    public WebElement projeAmaciTabi;

    @FindBy (xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/div[2]/section[2]/form/div/div/div/div[3]/div[2]/div[1]/div[3]/div[2]")
    public WebElement projeAmaciMetinEditoru;

    @FindBy (id = "projectInfoSector-tab")
    public WebElement sektorTabi;

    @FindBy (xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/div[2]/section[2]/form/div/div/div/div[3]/div[2]/div[2]/div[2]/button")
    public WebElement adim2KaydetButton;


    // 3.ADIM PROJEDEN BEKLENEN SONUC

    @FindBy (xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/div[2]/section[3]/form/div/div/div/div[2]/div[1]/div[1]/div[3]/div[2]")
    public WebElement projedenBeklenenSonucMetinEditoru;

    @FindBy (xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/div[2]/section[3]/form/div/div/div/div[2]/div[1]/div[2]/div[2]/button")
    public WebElement adim3KaydetButton;


    // 4. ADIM PROJEDEN ETKİLENENLER

    @FindBy (xpath = "//*[@id=\"projectAffected\"]/div/div/div/button")
    public WebElement projedenEtkilenenlerEkleButton;

    @FindBy (id = "stakeholder_name")
    public WebElement etkilenenKurumInput;

    @FindBy(className = "custom-control-label")
    public WebElement etkilenenAktifPasifStatus;

    @FindBy (id = "project_affected_save_btn")
    public WebElement etkilenenKaydetButton;


    // 5. ADIM PROJENIN OZGUNLUGU

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


    // 6. ADIM PAYDASLAR VE TEKNIK YETERLILIK

    @FindBy (xpath = "//*[@id=\"projectStakeholders\"]/div/div/div/button")
    public WebElement paydasEkleButton;

    @FindBy (id = "stakeholder_id")
    public WebElement paydasTuruSelect;

    public void paydasTuruSecme(int index) { new Select(paydasTuruSelect).selectByIndex(index); }

    @FindBy (id = "stakeholder_title")
    public WebElement projeYurutucusuAdiInput;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div/div/div/div[2]/section[6]/div/div/div/div[2]/form/div[2]/div/div[1]/select")
    public WebElement paydasProjeOrtakSelect;

    public void paydasProjeOrtakSecme(int index) { new Select(paydasProjeOrtakSelect).selectByIndex(index); }

    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div/div/div/div[2]/section[6]/div/div/div/div[2]/form/div[2]/div/div[1]/div/button[2]")
    public WebElement paydasOrtakSecmeButton;

    @FindBy (id = "person_in_charge")
    public WebElement danismanAdiInput;

    @FindBy (id = "project_stakeholder_save_btn")
    public WebElement paydasKaydetButton;

    @FindBy (className = "custom-control-label")
    public WebElement paydasAktifPasifStatus;


    // 7. ADIM PROJE ALANI

    @FindBy (xpath = "//*[@id=\"projectInfoSectorTable\"]/tbody/tr[3]/td[2]/div/label[2]")
    public WebElement sektorSecimIletisimTeknolojisiStatus;


    // 8. ADIM PROJE KAPSAMI

    @FindBy (xpath = "//*[@id=\"keywordsTab\"]/button")
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


    // 9. ADIM DIGER ALANLAR

    @FindBy (id = "sectoralContribution-tab")
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

    // 10.ADIM RISKLER VE ALTENATİF COZUMLERI

    @FindBy (id = "technicalRisk-tab")
    public WebElement risklerVeAlternatifCozumleriTabi;

    @FindBy (xpath = "//*[@id=\"technicalRiskTab\"]/div[1]/div[3]/div[2]")
    public WebElement risklerVeAlternatifCozumleriMetinEditoru;

    @FindBy (xpath = "/html/body/div/div[2]/div/div[2]/div/div/div/div/div[2]/section[10]/form/div/div/div/div[2]/div[1]/div[2]/div[2]/button")
    public WebElement adim10KaydetButton;

    // 11.ADIM IS PLANI

    @FindBy (id = "projectBusinessPlan-tab")
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

    // 12.ADIM BUTCE VE FINANSMAN KAYNAKLAR

    @FindBy (xpath = "//*[@id=\"projectBudgetTab\"]/div/button")
    public WebElement butceEkleButton;

    @FindBy (id = "spending_company_id")
    public WebElement butceFirmaSelect;

    public void butceFirmaSecme (int index) { new Select(butceFirmaSelect).selectByIndex(index);}


    @FindBy (id = "spending_category_id")
    public WebElement butceTuruSelect;

    public void butceTuruSecme (int index) { new Select(butceTuruSelect).selectByIndex(index);}


    @FindBy (id = "business_package_id")
    public WebElement butceIsPaketiSelect;

    public void butceIsPaketiSecme (int index) { new Select(butceIsPaketiSelect).selectByIndex(index);}


    @FindBy (id = "business_package_stakeholder_id")
    public WebElement butceIsPaketiPaydasSelect;

    public void butceIsPaketiPaydasSecme (int index) { new Select(butceIsPaketiPaydasSelect).selectByIndex(index);}


    @FindBy (id = "personel_date")
    public WebElement butceAdamAyInput;

    @FindBy (id = "amount")
    public WebElement butceTutarInput;

    @FindBy (className = "custom-control-label")
    public  WebElement butceAktifPasifStatus;

    @FindBy (id = "project_spending_save_btn")
    public WebElement butceKaydetButton;


    // EK DOSYALAR ADIMI


    @FindBy (xpath ="//*[@id=\"projectAttachmentFilesForm\"]/div/div/div/button")
    public WebElement dosyaEkleButton;

    @FindBy (id = "files_type_id")
    public WebElement dosyaTuru;

    @FindBy (id = "files_content")
    public WebElement dosyaAciklamasi;

    @FindBy (id ="file_url")
    public WebElement dosyaSecme;

    @FindBy (className = "custom-control-label")
    public WebElement dosyaAktifPasif;

    @FindBy  (xpath = "//*[@id=\"project_attachment_files_save_btn\"]")
    public WebElement dosyaEklemeKaydetButton;

    @FindBy (id = "captcha")
    public WebElement captcha;

    @FindBy (xpath = "//*[@id=\"captcha_form_input\"]/button")
    public WebElement reCaptchaButton;


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
            bekle();
        }
    }

    public void ciktiSectir() throws InterruptedException {
        int i = 1;
        for (WebElement element : outputList) {
            element.sendKeys(Integer.toString(i) + ". Çıktı");
            i++;
            bekle();
        }
    }

    public void ciktiTarihSectir() throws InterruptedException {
        int i = 1;
        for (WebElement element : outputListDate) {
            element.sendKeys(Integer.toString(i));
            i++;
            bekle();
        }
    }

}
