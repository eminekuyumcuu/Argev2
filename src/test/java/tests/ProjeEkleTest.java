package tests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.KullaniciGirisi;
import pages.ProjeEkle;
import pages.SolMenu;
import utilities.ConfigReader;
import utilities.Driver;

import javax.imageio.ImageIO;

public class ProjeEkleTest {

    @Test
    public void projeEkle() throws InterruptedException, IOException, TesseractException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        KullaniciGirisi kullaniciGirisSayfasi = new KullaniciGirisi();
        SolMenu solMenuListesi = new SolMenu();
        ProjeEkle projeEklemeElement = new ProjeEkle();

        kullaniciGirisSayfasi.kullaniciAdiInput.sendKeys(ConfigReader.getProperty("kullanici_adi"));
        kullaniciGirisSayfasi.sifreInput.sendKeys(ConfigReader.getProperty("sifre"));

        projeEklemeElement.bekle();

        getCaptchaImage();

        projeEklemeElement.bekle();

        kullaniciGirisSayfasi.guvenlikKoduInput.sendKeys(startConversion());

        if(!kullaniciGirisSayfasi.girisYapButonu.isEnabled()){
            projeEklemeElement.bekle();
            while(!kullaniciGirisSayfasi.girisYapButonu.isEnabled())
            {
                kullaniciGirisSayfasi.guvenlikKoduInput.clear();

                projeEklemeElement.reCaptchaButton.click();

                projeEklemeElement.bekle();

                getCaptchaImage();

                projeEklemeElement.bekle();

                kullaniciGirisSayfasi.guvenlikKoduInput.sendKeys(startConversion());
            }
        }


        kullaniciGirisSayfasi.girisYapButonu.click();

        solMenuListesi.projeIslemleriButton.click();

        solMenuListesi.projeEkleButton.click();
        projeEklemeElement.bekle();

        // 1.ADIM PROJE GENEL BİLGİLERİ
        projeEklemeElement.dagitimTuruSecme(1);
        projeEklemeElement.bekle();

        projeEklemeElement.dagitimSirketiSecme(80);
        projeEklemeElement.bekle();

        projeEklemeElement.projeAdiInput.sendKeys(ConfigReader.getProperty("proje_adi"));
        projeEklemeElement.bekle();

        projeEklemeElement.projeKategoriSecme(1);
        projeEklemeElement.bekle();

        projeEklemeElement.projeTuruSecme(1);
        projeEklemeElement.bekle();

        projeEklemeElement.projeSorumlusuSecme(1);
        projeEklemeElement.bekle();

        for (int bolgeindex =0; bolgeindex < 22; bolgeindex++)
        {
            projeEklemeElement.projeBolgesiSecimi(bolgeindex);
        }
        projeEklemeElement.bolgeSecimButton.click();
        projeEklemeElement.bekle();

        for (int ortakindex = 0; ortakindex < 21; ortakindex++)
        {
            projeEklemeElement.projeOrtakSecme(ortakindex);
        }
        projeEklemeElement.ortakSecimButton.click();
        projeEklemeElement.bekle();

        projeEklemeElement.projeSuresiInput.sendKeys(ConfigReader.getProperty("proje_suresi"));
        projeEklemeElement.takvimButton.clear();
        projeEklemeElement.takvimButton.click();
        projeEklemeElement.baslangicAySecme(1);
        projeEklemeElement.baslangicYilSecme(97);
        projeEklemeElement.tahminiBaslangicTarihiCalender.click();
        projeEklemeElement.projeDonemiInput.sendKeys(ConfigReader.getProperty("proje_donemi_Ay"));
        projeEklemeElement.projeDonemiInput.sendKeys(Keys.ARROW_RIGHT);
        projeEklemeElement.projeDonemiInput.sendKeys(ConfigReader.getProperty("proje_donemi_Yil"));
        projeEklemeElement.adim1KaydetButton.click();
        projeEklemeElement.HERYERDEGECERLITAMAMBUTONU.click();

        System.out.println("1.Adim Proje Genel Bilgileri Dolduruldu.");

        // 2. ADIM PROJE AMACI

        projeEklemeElement.projeOzetiMetinEditoru.sendKeys(ConfigReader.getProperty("proje_ozeti"));
        projeEklemeElement.bekle();

        projeEklemeElement.projeAmaciTabi.click();
        projeEklemeElement.bekle();

        projeEklemeElement.projeAmaciMetinEditoru.sendKeys(ConfigReader.getProperty("proje_amaci"));
        projeEklemeElement.bekle();

        projeEklemeElement.adim2KaydetButton.click();
        projeEklemeElement.bekle();

        projeEklemeElement.HERYERDEGECERLITAMAMBUTONU.click();

        System.out.println("2.Adim Proje Amaci Dolduruldu.");

        // 3. ADIM PROJEDEN BEKLENEN SONUÇ

        projeEklemeElement.projedenBeklenenSonucMetinEditoru.sendKeys(ConfigReader.getProperty("projeden_beklenen_sonuc"));
        projeEklemeElement.bekle();

        projeEklemeElement.adim3KaydetButton.click();
        projeEklemeElement.bekle();

        projeEklemeElement.HERYERDEGECERLITAMAMBUTONU.click();
        projeEklemeElement.bekle();

        System.out.println("3.Adim Projeden Beklenen Sonuc Dolduruldu.");

        // 4. ADIM PROJEDEN ETKİLENENLER

        projeEklemeElement.projedenEtkilenenlerEkleButton.click();
        projeEklemeElement.bekle();

        projeEklemeElement.etkilenenKurumInput.sendKeys(ConfigReader.getProperty("etkilenen_kurum"));
        projeEklemeElement.bekle();

        projeEklemeElement.etkilenenAktifPasifStatus.click();
        projeEklemeElement.bekle();

        projeEklemeElement.etkilenenKaydetButton.click();
        projeEklemeElement.bekle();

        projeEklemeElement.HERYERDEGECERLITAMAMBUTONU.click();
        projeEklemeElement.bekle();

        System.out.println("4.Adim Projeden Etkilenenler Dolduruldu.");

        // 5.ADIM PROJENIN OZGUNLUGU

        projeEklemeElement.projeninOzgunluguAdimi.click();
        projeEklemeElement.bekle();

        projeEklemeElement.projeninOzgunluguMetinEditoru.sendKeys(ConfigReader.getProperty("projenin_ozgunlugu"));
        projeEklemeElement.bekle();

        projeEklemeElement.projeninBeklenenKatmaDegeriTabi.click();
        projeEklemeElement.bekle();

        projeEklemeElement.projeninBeklenenKatmaDegeriMetinEditoru.sendKeys(ConfigReader.getProperty("projenin_beklenen_katma_degeri"));
        projeEklemeElement.bekle();

        projeEklemeElement.adim5KaydetButton.click();
        projeEklemeElement.bekle();

        projeEklemeElement.HERYERDEGECERLITAMAMBUTONU.click();
        projeEklemeElement.bekle();

        System.out.println("5.Adim Projenin Ozgunlugu Dolduruldu.");

        // 6. ADIM PAYDASLAR VE TEKNIK YETERLILIK
        projeEklemeElement.bekle();
        projeEklemeElement.paydaslarVeTeknikYeterlilikAdimi.click();
        projeEklemeElement.bekle();

        projeEklemeElement.paydasEkleButton.click();
        projeEklemeElement.bekle();

        projeEklemeElement.paydasTuruSecme(1); //Proje Yurutucusu
        projeEklemeElement.bekle();

        projeEklemeElement.projeYurutucusuAdiInput.sendKeys(ConfigReader.getProperty("proje_Yurutucusu"));
        projeEklemeElement.bekle();

        projeEklemeElement.paydasAktifPasifStatus.click();
        projeEklemeElement.bekle();

        projeEklemeElement.paydasKaydetButton.click();
        projeEklemeElement.bekle();

        projeEklemeElement.HERYERDEGECERLITAMAMBUTONU.click();
        projeEklemeElement.bekle();

        projeEklemeElement.paydasEkleButton.click();
        projeEklemeElement.bekle();

        projeEklemeElement.paydasTuruSecme(2); //Proje Ortaklari

        for (int paydasortak =0; paydasortak < 21; paydasortak++)
        {
            projeEklemeElement.paydasProjeOrtakSecme(paydasortak);
        }
        projeEklemeElement.paydasOrtakSecmeButton.click();
        projeEklemeElement.bekle();

        projeEklemeElement.paydasAktifPasifStatus.click();
        projeEklemeElement.bekle();

        projeEklemeElement.paydasKaydetButton.click();
        projeEklemeElement.bekle();

        projeEklemeElement.HERYERDEGECERLITAMAMBUTONU.click();
        projeEklemeElement.bekle();

        projeEklemeElement.paydasEkleButton.click();
        projeEklemeElement.bekle();

        projeEklemeElement.paydasTuruSecme(3); //Danisman
        projeEklemeElement.bekle();

        projeEklemeElement.danismanAdiInput.sendKeys(ConfigReader.getProperty("danisman"));
        projeEklemeElement.bekle();

        projeEklemeElement.paydasAktifPasifStatus.click();
        projeEklemeElement.bekle();

        projeEklemeElement.paydasKaydetButton.click();
        projeEklemeElement.bekle();

        projeEklemeElement.HERYERDEGECERLITAMAMBUTONU.click();
        projeEklemeElement.bekle();

        System.out.println("5.Adim Paydaslar ve Teknik Yeterlilik Dolduruldu.");


        // 7. ADIM PROJE ALANI

        projeEklemeElement.projeAlaniAdimi.click();
        projeEklemeElement.bekle();

        projeEklemeElement.sektorSecimIletisimTeknolojisiStatus.click();
        projeEklemeElement.bekle();

        projeEklemeElement.popupUyariMesajiOnayla.click();
        projeEklemeElement.bekle();

        projeEklemeElement.HERYERDEGECERLITAMAMBUTONU.click();
        projeEklemeElement.bekle();

        System.out.println("7.Adim Proje Alani Dolduruldu.");


        // 8. ADIM PROJE KAPSAMİ

        projeEklemeElement.projeKapsamiAdimi.click();

        for (int sayi = 1; sayi < 5; sayi++)
        {
            projeEklemeElement.bekle();
            projeEklemeElement.kelimeEkleButton.click();
            projeEklemeElement.kelimeAdiInput.sendKeys(ConfigReader.getProperty("anahtar_kelime") + " " + sayi);
            projeEklemeElement.bekle();
            projeEklemeElement.kelimeKaydetButton.click();
            projeEklemeElement.HERYERDEGECERLITAMAMBUTONU.click();
        }

        projeEklemeElement.bekle();
        projeEklemeElement.bekle();
        projeEklemeElement.projeKapsamiTabi.click();
        projeEklemeElement.projeKapsamiMetinEditoru.sendKeys(ConfigReader.getProperty("proje_kapsami"));

        projeEklemeElement.faydalanilanKaynaklarTabi.click();
        projeEklemeElement.faydalanilanKaynaklarMetinEditoru.sendKeys(ConfigReader.getProperty("faydalanilan_kaynaklar"));

        projeEklemeElement.projeTeknikAciklamasiTabi.click();
        projeEklemeElement.projeTeknikAciklamasiMetinEditoru.sendKeys(ConfigReader.getProperty("proje_teknik_aciklamasi"));

        projeEklemeElement.projedenBeklenenVerilerTabi.click();
        projeEklemeElement.projedenBeklenenVerilerMetinEditoru.sendKeys(ConfigReader.getProperty("projeden_beklenen_veriler"));

        projeEklemeElement.adim8KaydetButton.click();
        projeEklemeElement.HERYERDEGECERLITAMAMBUTONU.click();
        projeEklemeElement.bekle();


        // 9. ADIM DIGER ALANLAR
        projeEklemeElement.projeninSektoreOlasiEtkileriMetinEditoru.sendKeys(ConfigReader.getProperty("projenin_sektore_olasi_etkileri"));
        projeEklemeElement.bekle();

        projeEklemeElement.projeninSirketCalisanlarinaOlasiEtkileriTabi.click();
        projeEklemeElement.bekle();

        projeEklemeElement.projeninSirketCalisanlarinaOlasiEtkileriMetinEditoru.sendKeys(ConfigReader.getProperty("projenin_sirket_calisanlarina_olasi_etkileri"));
        projeEklemeElement.bekle();

        projeEklemeElement.projeninOlasiSosyalEtkileriTabi.click();
        projeEklemeElement.bekle();

        projeEklemeElement.projeninOlasiSosyalEtkileriMetinEditoru.sendKeys(ConfigReader.getProperty("projenin_olasi_sosyal_etkileri"));
        projeEklemeElement.bekle();

        projeEklemeElement.adim9KaydetButton.click();
        projeEklemeElement.bekle();

        projeEklemeElement.HERYERDEGECERLITAMAMBUTONU.click();
        projeEklemeElement.bekle();

        // 10.ADIM RISKLER VE ALTENATİF COZUMLERI

        projeEklemeElement.risklerVeAlternatifCozumleriMetinEditoru.sendKeys(ConfigReader.getProperty("riskler_ve_alternatif_cozumleri"));
        projeEklemeElement.bekle();

        projeEklemeElement.adim10KaydetButton.click();
        projeEklemeElement.bekle();

        projeEklemeElement.HERYERDEGECERLITAMAMBUTONU.click();
        projeEklemeElement.bekle();

        // 11.ADIM IS PLANI
        projeEklemeElement.bekle();
        projeEklemeElement.isPlaniAdimi.click();

        int kaldigimAy = 0;

        for(int i = 1; i < 3; i++)
        {
            projeEklemeElement.bekle();

            projeEklemeElement.isPlaniEkleButton.click();
            projeEklemeElement.bekle();

            projeEklemeElement.isPaketiFirmaSecme(1);
            projeEklemeElement.bekle();

            projeEklemeElement.isPaketiNoInput.sendKeys(Integer.toString(i));
            projeEklemeElement.bekle();

            projeEklemeElement.faliyetTuruSecme(i);
            projeEklemeElement.bekle();

            projeEklemeElement.faliyetTuruSecimButton.click();
            projeEklemeElement.bekle();

            String isPaketiAdi = i + ". " + ConfigReader.getProperty("is_paketi_adi");
            projeEklemeElement.isPaketiAdiInput.sendKeys(isPaketiAdi);
            projeEklemeElement.bekle();

            projeEklemeElement.isPaketiLideriSecme(1);
            projeEklemeElement.bekle();

            if(kaldigimAy == 0)
            {
                projeEklemeElement.isPaketiBaslangicTarihiInput.sendKeys(Integer.toString(i));
                projeEklemeElement.isPaketiBitisTarihiInput.sendKeys(Integer.toString(isPaketiAyGetir(i)));
            }else{
                projeEklemeElement.isPaketiBaslangicTarihiInput.sendKeys(Integer.toString(kaldigimAy));
                projeEklemeElement.isPaketiBitisTarihiInput.sendKeys(Integer.toString(isPaketiAyGetir(kaldigimAy)));
            }

            kaldigimAy = isPaketiAyGetir(i);

            projeEklemeElement.bekle();

            projeEklemeElement.bekle();

            projeEklemeElement.isPaketiDurumuStatus.click();
            projeEklemeElement.bekle();

            projeEklemeElement.isPaketiIleriButton.click();
            projeEklemeElement.bekle();

            projeEklemeElement.isPaketiDetayMetinEditoru.sendKeys("fsdfsdfsd");
            projeEklemeElement.bekle();


            projeEklemeElement.isPaketiTamamlanacakGorevlerMetinEditoru.sendKeys("fsdfsdfsdfsdf");
            projeEklemeElement.bekle();

            projeEklemeElement.isPaketiIleriButton.click();
            projeEklemeElement.bekle();

            for (int paydasekle = 1; paydasekle< 4; paydasekle++ )
            {
                projeEklemeElement.isPaketinePaydasEkleButton.click();
            }

            projeEklemeElement.bekle();

            projeEklemeElement.paydasSectir();

            projeEklemeElement.bekle();

            projeEklemeElement.isPaketiIleriButton.click();

            for (int paydasekle = 1; paydasekle< 4; paydasekle++ )
            {
                projeEklemeElement.ciktiEkleButton.click();
            }

            projeEklemeElement.bekle();

            projeEklemeElement.ciktiSectir();

            projeEklemeElement.bekle();

            projeEklemeElement.ciktiTarihSectir();

            projeEklemeElement.bekle();

            projeEklemeElement.isPaketiIleriKaydetButton.click();

            projeEklemeElement.bekle();

            projeEklemeElement.HERYERDEGECERLITAMAMBUTONU.click();

            projeEklemeElement.bekle();
        }


        // 12.ADIM BUTCE VE FINANSMAN KAYNAKLAR


        for (int butceindexler = 1; butceindexler < 4; butceindexler++) {
            projeEklemeElement.butceVeFinansmanKaynaklarAdimi.click();
            projeEklemeElement.bekle();

            projeEklemeElement.butceEkleButton.click();
            projeEklemeElement.bekle();

            projeEklemeElement.butceFirmaSecme(butceindexler);
            projeEklemeElement.bekle();

            projeEklemeElement.butceTuruSecme(butceindexler);
            projeEklemeElement.bekle();

            projeEklemeElement.butceIsPaketiSecme(butceindexler);
            projeEklemeElement.bekle();

            projeEklemeElement.butceIsPaketiPaydasSecme(butceindexler); //Proje Yürütücüsü
            projeEklemeElement.bekle();

            projeEklemeElement.butceAdamAyInput.sendKeys("1");
            projeEklemeElement.bekle();

            projeEklemeElement.butceTutarInput.sendKeys("100000");
            projeEklemeElement.bekle();

            projeEklemeElement.butceAktifPasifStatus.click();
            projeEklemeElement.bekle();

            projeEklemeElement.butceKaydetButton.click();
            projeEklemeElement.bekle();

            projeEklemeElement.HERYERDEGECERLITAMAMBUTONU.click();
        }

            projeEklemeElement.projeHareketKayitlariAdimi.click();
            projeEklemeElement.bekle();
            projeEklemeElement.yetkiliFirmalarAdimi.click();
            projeEklemeElement.bekle();
            projeEklemeElement.projeEkDosyalarAdimi.click();

            WebElement dosyaTuruSecimi = projeEklemeElement.dosyaTuru;
            new Select(dosyaTuruSecimi).selectByValue("2"); //Proje Algoritmasi

            projeEklemeElement.dosyaAciklamasi.sendKeys(ConfigReader.getProperty("dosya_aciklamasi"));

            WebElement dosyasecimi = projeEklemeElement.dosyaSecme;
            dosyasecimi.sendKeys("C:/Users/emine.kuyumcu/Desktop/ARGETEST/deneme.pdf");

            projeEklemeElement.dosyaAktifPasif.click();

            projeEklemeElement.dosyaEklemeKaydetButton.click();
            projeEklemeElement.HERYERDEGECERLITAMAMBUTONU.click();


    }






    public String startConversion() throws TesseractException {
        File imgFile = new File(Driver.getPath() + "\\src\\img\\captcha.png");
        ITesseract instance = new Tesseract();
        instance.setDatapath(Driver.getPath() + "\\src\\tessdata");
        return instance.doOCR(imgFile);
    }

    public void getCaptchaImage() throws IOException {
        ProjeEkle projeEklemeElement = new ProjeEkle();
        File screenshot = ((TakesScreenshot) Driver.driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullScreen = ImageIO.read(screenshot);
        Point location = projeEklemeElement.captcha.getLocation();
        int width = projeEklemeElement.captcha.getSize().getWidth();
        int height = projeEklemeElement.captcha.getSize().getHeight();
        BufferedImage logoImage = fullScreen.getSubimage(location.getX(), location.getY(), width, height);
        ImageIO.write(logoImage, "png", screenshot);
        FileUtils.copyFile(screenshot, new File(Driver.getPath() + "\\src\\img\\captcha.png"));

    }

    public int isPaketiAyGetir(int sayi) {
        int generated =  ThreadLocalRandom.current().nextInt(sayi, sayi * 3);

        if(generated == sayi)
            generated++;

        return generated;
    }

}