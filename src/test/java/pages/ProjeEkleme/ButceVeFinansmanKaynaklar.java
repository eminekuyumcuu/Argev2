package pages.ProjeEkleme;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class ButceVeFinansmanKaynaklar {

    public ButceVeFinansmanKaynaklar()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//*[@id=\"projectBudgetTab\"]/div/button")
    public WebElement butceEkleButton;

    @FindBy (id = "spending_company_id")
    public WebElement butceFirmaSelect;

    @FindBy (id = "spending_category_id")
    public WebElement butceTuruSelect;

    @FindBy (id = "business_package_id")
    public WebElement butceIsPaketiSelect;

    @FindBy (id = "business_package_stakeholder_id")
    public WebElement butceIsPaketiPaydasSelect;

    @FindBy (id = "personel_date")
    public WebElement butceAdamAyInput;

    @FindBy (id = "amount")
    public WebElement butceTutarInput;

    @FindBy (id = "project_spending_save_btn")
    public WebElement butceKaydetButton;

    public void butceFirmaSecme (int index) { new Select(butceFirmaSelect).selectByIndex(index);}
    public void butceTuruSecme (int index) { new Select(butceTuruSelect).selectByIndex(index);}
    public void butceIsPaketiSecme (int index) { new Select(butceIsPaketiSelect).selectByIndex(index);}
    public void butceIsPaketiPaydasSecme (int index) { new Select(butceIsPaketiPaydasSelect).selectByIndex(index);}

}
