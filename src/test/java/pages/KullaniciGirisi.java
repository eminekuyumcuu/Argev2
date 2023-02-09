package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.swing.*;

public class KullaniciGirisi {
    public KullaniciGirisi() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id="inputEmail")
    public WebElement kullaniciAdiInput;

    @FindBy(id="inputSifre")
    public WebElement sifreInput;

    @FindBy (id = "fast_login")
    public WebElement girisYapButonu;

    public String manuelVeriGirisi() {
        return JOptionPane.showInputDialog("Enter");
    }

    @FindBy(xpath = "//input[@id='captcha_input']")
    public WebElement guvenlikKoduInput;


}



