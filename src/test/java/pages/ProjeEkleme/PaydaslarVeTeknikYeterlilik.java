package pages.ProjeEkleme;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class PaydaslarVeTeknikYeterlilik
{
    public PaydaslarVeTeknikYeterlilik()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//*[@id=\"projectStakeholders\"]/div/div/div/button")
    public WebElement paydasEkleButton;

    @FindBy (id = "stakeholder_id")
    public WebElement paydasTuruSelect;

    @FindBy (id = "stakeholder_title")
    public WebElement projeYurutucusuAdiInput;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div/div/div/div[2]/section[6]/div/div/div/div[2]/form/div[2]/div/div[1]/select")
    public WebElement paydasProjeOrtakSelect;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div/div/div/div[2]/section[6]/div/div/div/div[2]/form/div[2]/div/div[1]/div/button[2]")
    public WebElement paydasOrtakSecmeButton;

    @FindBy (id = "person_in_charge")
    public WebElement danismanAdiInput;

    @FindBy (id = "project_stakeholder_save_btn")
    public WebElement paydasKaydetButton;

    public void paydasTuruSecme(int index) { new Select(paydasTuruSelect).selectByIndex(index); }
    public void paydasProjeOrtakSecme(int index) { new Select(paydasProjeOrtakSelect).selectByIndex(index); }


}
