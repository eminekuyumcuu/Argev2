package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.swing.*;

public class SolMenu {
    public SolMenu() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "navbar_dashboard")
    public WebElement dashboardButton;

    @FindBy (id = "navbar_project")
    public WebElement projeIslemleriButton;

    @FindBy (id = "collapse-new")
    public WebElement projeEkleButton;

    @FindBy (id = "collapse-revision")
    public WebElement reziyonHareketleriButton;

    @FindBy (id = "collapse-epdk")
    public WebElement devamEdenProjeleriIzlemeButton;

    @FindBy (id = "navbar_projectmanager")
    public WebElement projeYonetimButton;

    @FindBy (id = "navbar_notification")
    public WebElement iletisimDuyuruSurecleriButton;

    @FindBy (id = "collapse-template")
    public WebElement sablonListesi;

    @FindBy (id = "collapse-iys")
    public WebElement IYSEntegrasyonButton;

    @FindBy (id = "collapse-bulksms")
    public WebElement topluSmsEpostaGonderButton;

    @FindBy (id = "collapse-autonot")
    public WebElement otomatikBildirimYonetimiButton;

    @FindBy (id = "collapse-message")
    public WebElement mesajlarButton;

    @FindBy (id = "collapse-notice")
    public WebElement duyurularButton;

    @FindBy (id = "navbar_report")
    public WebElement projeIstatiskleriButton;

    @FindBy (id = "collapse-project-report")
    public WebElement projeRaporlariButton;

    @FindBy (id = "collapse-budget-report")
    public WebElement butceRaporlariButton;

    @FindBy (id = "collapse-expense-report")
    public WebElement giderRaporlariButton;

    @FindBy (id = "navbar_setting")
    public WebElement AyarlarButton;

    @FindBy (id = "collapse-user")
    public WebElement kullaniciIslemleriButton;

    @FindBy (id = "collapse-role")
    public WebElement rolIslemleriButton;

    @FindBy (id = "collapse-authority")
    public WebElement yetkiIslemleriButton;

    @FindBy (id = "collapse-department")
    public WebElement departmanIslemleriButton;

    @FindBy (id = "menu-company")
    public WebElement sirketIslemleriMenu;

    @FindBy (id = "collapse-company")
    public WebElement sirketIslemleriButton;

    @FindBy (id = "collapse-person")
    public WebElement dagitimSirketiCalisanlariButton;

    @FindBy (id = "collapse-regulation")
    public WebElement yonetmelikIslemleriButton;

    @FindBy (id = "support-definitions")
    public WebElement yardimIslemleriMenu;

    @FindBy (id = "collapse-support")
    public WebElement yardimIslemleriButton;

    @FindBy (id = "collapse-kullanim_kilavuzu")
    public WebElement kullanimKlavuzuButton;

    @FindBy (id = "collapse-definitions")
    public WebElement tanimlamalarButton;

    @FindBy (id = "collapse-category")
    public WebElement projeKategorileriButton;

    @FindBy (id = "collapse-kind")
    public WebElement projeTurleriButton;

    @FindBy (id = "collapse-sector")
    public WebElement projeSektoruButton;

    @FindBy (id = "collapse-stakeholders")
    public WebElement paydasTuruButton;

    @FindBy (xpath = "/html/body/div[1]/aside/div/nav/ul/li[6]/ul/li[8]/ul/li[5]/a")
    public WebElement tufeOranlariButton;























}



