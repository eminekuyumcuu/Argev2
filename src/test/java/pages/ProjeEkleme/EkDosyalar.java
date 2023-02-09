package pages.ProjeEkleme;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EkDosyalar {

    public EkDosyalar()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath ="//*[@id=\"projectAttachmentFilesForm\"]/div/div/div/button")
    public WebElement dosyaEkleButton;

    @FindBy (id = "files_type_id")
    public WebElement dosyaTuru;

    @FindBy (id = "files_content")
    public WebElement dosyaAciklamasi;

    @FindBy (id ="file_url")
    public WebElement dosyaSecme;

    @FindBy  (xpath = "//*[@id=\"project_attachment_files_save_btn\"]")
    public WebElement dosyaEklemeKaydetButton;


}
