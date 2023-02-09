package pages.ProjeEkleme;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.nio.file.WatchEvent;

public class ProjeGenelBilgileri
{

    public ProjeGenelBilgileri()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (id = "company_kind")
    public WebElement dagitimSirketiTuruSelect;

    @FindBy (id = "company_id")
    public WebElement dagitimSirketiSelect;

    @FindBy (id = "name")
    public WebElement projeAdiInput;

    @FindBy (id = "project_category_id")
    public WebElement projeKategoriSelect;

    @FindBy (id = "project_kind_id")
    public WebElement projeTuruSelect;

    @FindBy (id = "project_responsible_id")
    public WebElement projeSorumlusuSelect;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div/div/div/div[2]/section[1]/form/div/div[3]/div[1]/div/div/div[1]/select")
    public WebElement projeBolgesiSelect;

    @FindBy (xpath = "//*[@id=\"projectGeneralInformationForm\"]/div/div[3]/div[1]/div/div/div[1]/div/button[2]")
    public WebElement bolgeSecimButton;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div/div/div/div[2]/section[1]/form/div/div[3]/div[2]/div/div/div[1]/select")
    public WebElement projeOrtaklariSelect;

    @FindBy (xpath = "//*[@id=\"project_partner\"]/div/div/div[1]/div/button[2]")
    public WebElement ortakSecimButton;

    @FindBy (id = "time")
    public WebElement projeSuresiInput;

    @FindBy (id = "start_date")
    public WebElement takvimButton;

    @FindBy (className = "monthselect")
    public WebElement takvimAySecim;

    @FindBy (className = "yearselect")
    public WebElement takvimYilSecim;

    @FindBy (css = "body > div.daterangepicker.ltr.auto-apply.single.opensright.show-calendar > div.drp-calendar.left.single > div.calendar-table > table > tbody > tr:nth-child(3) > td:nth-child(4)")
    public WebElement tahminiBaslangicTarihiCalender;

    @FindBy (id = "project_period")
    public WebElement projeDonemiInput;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div/div/div/div[2]/section[1]/form/div/div[5]/div[2]/button")
    public WebElement adim1KaydetButton;



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

}
