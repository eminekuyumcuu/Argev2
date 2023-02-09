package tests;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import pages.Common.Common;
import pages.KullanıcıGiris.KullanıcıGiris2;
import pages.ProjeEkle;
import pages.SolMenu;
import utilities.ConfigReader;
import utilities.Driver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class KullaniciGirisi {

    public void KullaniciGirisi() throws InterruptedException, IOException, TesseractException {


        Common commonElement = new Common();
        KullanıcıGiris2 kullaniciGirisElement = new KullanıcıGiris2();
        SolMenu solMenuListesi = new SolMenu();

        kullaniciGirisElement.kullaniciAdiInput.sendKeys(ConfigReader.getProperty("kullanici_adi"));
        kullaniciGirisElement.sifreInput.sendKeys(ConfigReader.getProperty("sifre"));

        commonElement.bekle();

        getCaptchaImage();

        commonElement.bekle();

        kullaniciGirisElement.guvenlikKoduInput.sendKeys(startConversion());

        if (!kullaniciGirisElement.girisYapButonu.isEnabled()) {
            commonElement.bekle();
            while (!kullaniciGirisElement.girisYapButonu.isEnabled()) {
                kullaniciGirisElement.guvenlikKoduInput.clear();

                kullaniciGirisElement.reCaptchaButton.click();

                commonElement.bekle();

                getCaptchaImage();

                commonElement.bekle();

                kullaniciGirisElement.guvenlikKoduInput.sendKeys(startConversion());
            }
        }


        kullaniciGirisElement.girisYapButonu.click();

        solMenuListesi.projeIslemleriButton.click();

        solMenuListesi.projeEkleButton.click();
        commonElement.bekle();


    }

        public String startConversion() throws TesseractException {
            File imgFile = new File(Driver.getPath() + "\\src\\img\\captcha.png");
            ITesseract instance = new Tesseract();
            instance.setDatapath(Driver.getPath() + "\\src\\tessdata");
            return instance.doOCR(imgFile);
        }

        public void getCaptchaImage() throws IOException {
            ProjeEkle kullaniciGirisElement = new ProjeEkle();
            File screenshot = ((TakesScreenshot) Driver.driver).getScreenshotAs(OutputType.FILE);
            BufferedImage fullScreen = ImageIO.read(screenshot);
            Point location = kullaniciGirisElement.captcha.getLocation();
            int width = kullaniciGirisElement.captcha.getSize().getWidth();
            int height = kullaniciGirisElement.captcha.getSize().getHeight();
            BufferedImage logoImage = fullScreen.getSubimage(location.getX(), location.getY(), width, height);
            ImageIO.write(logoImage, "png", screenshot);
            FileUtils.copyFile(screenshot, new File(Driver.getPath() + "\\src\\img\\captcha.png"));

        }


    }
