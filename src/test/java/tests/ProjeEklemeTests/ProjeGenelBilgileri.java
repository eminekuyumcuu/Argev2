package tests.ProjeEklemeTests;

import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.Common.Common;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.IOException;

public class ProjeGenelBilgileri {


    @Test
    public void ProjeGenelBilgileri() throws InterruptedException, IOException, TesseractException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));


        pages.ProjeEkleme.ProjeGenelBilgileri projeGenelBilgileriElement = new pages.ProjeEkleme.ProjeGenelBilgileri();
        Common commonElement = new Common();


        projeGenelBilgileriElement.dagitimTuruSecme(1);
        commonElement.bekle();

        projeGenelBilgileriElement.dagitimSirketiSecme(80);
        commonElement.bekle();

        projeGenelBilgileriElement.projeAdiInput.sendKeys(ConfigReader.getProperty("proje_adi"));
        commonElement.bekle();

        projeGenelBilgileriElement.projeKategoriSecme(1);
        commonElement.bekle();

        projeGenelBilgileriElement.projeTuruSecme(1);
        commonElement.bekle();

        projeGenelBilgileriElement.projeSorumlusuSecme(1);
        commonElement.bekle();

        for (int bolgeindex =0; bolgeindex < 22; bolgeindex++)
        {
            projeGenelBilgileriElement.projeBolgesiSecimi(bolgeindex);
        }
        projeGenelBilgileriElement.bolgeSecimButton.click();
        commonElement.bekle();

        for (int ortakindex = 0; ortakindex < 21; ortakindex++)
        {
            projeGenelBilgileriElement.projeOrtakSecme(ortakindex);
        }
        projeGenelBilgileriElement.ortakSecimButton.click();
        commonElement.bekle();

        projeGenelBilgileriElement.projeSuresiInput.sendKeys(ConfigReader.getProperty("proje_suresi"));
        projeGenelBilgileriElement.takvimButton.clear();
        projeGenelBilgileriElement.takvimButton.click();
        projeGenelBilgileriElement.baslangicAySecme(1);
        projeGenelBilgileriElement.baslangicYilSecme(97);
        projeGenelBilgileriElement.tahminiBaslangicTarihiCalender.click();
        projeGenelBilgileriElement.projeDonemiInput.sendKeys(ConfigReader.getProperty("proje_donemi_Ay"));
        projeGenelBilgileriElement.projeDonemiInput.sendKeys(Keys.ARROW_RIGHT);
        projeGenelBilgileriElement.projeDonemiInput.sendKeys(ConfigReader.getProperty("proje_donemi_Yil"));
        projeGenelBilgileriElement.adim1KaydetButton.click();
        commonElement.HERYERDEGECERLITAMAMBUTONU.click();

        System.out.println("1.Adim Proje Genel Bilgileri Dolduruldu.");


    }
}