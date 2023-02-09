package pages.ProjeEkleme;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProjedenEtkilenenler
{
    public ProjedenEtkilenenler()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//*[@id=\"projectAffected\"]/div/div/div/button")
    public WebElement projedenEtkilenenlerEkleButton;

    @FindBy (id = "stakeholder_name")
    public WebElement etkilenenKurumInput;

    @FindBy (id = "project_affected_save_btn")
    public WebElement etkilenenKaydetButton;
}
