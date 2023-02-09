package pages.ProjeEkleme;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProjeAlani {

    public ProjeAlani()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"projectInfoSectorTable\"]/tbody/tr[3]/td[2]/div/label[2]")
    public WebElement sektorSecimIletisimTeknolojisiStatus;
}
