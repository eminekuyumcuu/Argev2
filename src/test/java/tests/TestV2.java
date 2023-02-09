package tests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.Common.Common;
import pages.KullaniciGirisi;
import pages.ProjeEkle;
import pages.ProjeEkleme.*;
import pages.SolMenu;
import utilities.ConfigReader;
import utilities.Driver;

import javax.imageio.ImageIO;

public class TestV2 {

    @Test
    public void projeEkle() throws InterruptedException, IOException, TesseractException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        KullaniciGirisi kullaniciGirisSayfasi = new KullaniciGirisi();
        SolMenu solMenuListesi = new SolMenu();
        ProjeEkle projeEklemeElement = new ProjeEkle();
        ProjeGenelBilgileri projeGenelBilgileriElement = new ProjeGenelBilgileri();
        Common commonElement = new Common();
        ProjeAmaci projeAmaciElement = new ProjeAmaci();
        ProjedenBeklenenSonuc projedenBeklenenSonucElement = new ProjedenBeklenenSonuc();
        ProjedenEtkilenenler projedenEtkilenenlerElement = new ProjedenEtkilenenler();
        ProjeninOzgunlugu projeninOzgunluguElement = new ProjeninOzgunlugu();
        ProjeEkleAdimlari  projeAdimlariElement = new ProjeEkleAdimlari();
        PaydaslarVeTeknikYeterlilik paydaslarVeTeknikYeterlilikElement = new PaydaslarVeTeknikYeterlilik();
        ProjeAlani projeAlaniElement = new ProjeAlani();
        ProjeKapsami projeKapsamiElement = new ProjeKapsami();
        DigerAlanlar digerAlanlarElement = new DigerAlanlar();
        RisklerVeAlternatifCozumleri risklerVeAlternatifCozumleriElement = new RisklerVeAlternatifCozumleri();
        IsPaketi isPaketiElement = new IsPaketi();
        ButceVeFinansmanKaynaklar butceVeFinansmanKaynaklarElement = new ButceVeFinansmanKaynaklar();
        EkDosyalar ekDosyalarElement = new EkDosyalar();


        kullaniciGirisSayfasi.kullaniciAdiInput.sendKeys(ConfigReader.getProperty("kullanici_adi"));
        kullaniciGirisSayfasi.sifreInput.sendKeys(ConfigReader.getProperty("sifre"));

        commonElement.bekle();

        getCaptchaImage();

        commonElement.bekle();

        kullaniciGirisSayfasi.guvenlikKoduInput.sendKeys(startConversion());

        if(!kullaniciGirisSayfasi.girisYapButonu.isEnabled()){
            commonElement.bekle();
            while(!kullaniciGirisSayfasi.girisYapButonu.isEnabled())
            {
                kullaniciGirisSayfasi.guvenlikKoduInput.clear();

                projeEklemeElement.reCaptchaButton.click();

                commonElement.bekle();

                getCaptchaImage();

                commonElement.bekle();

                kullaniciGirisSayfasi.guvenlikKoduInput.sendKeys(startConversion());
            }
        }


        kullaniciGirisSayfasi.girisYapButonu.click();

        solMenuListesi.projeIslemleriButton.click();

        solMenuListesi.projeEkleButton.click();
        commonElement.bekle();

        // 1.ADIM PROJE GENEL BİLGİLERİ
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
            projeEklemeElement.projeBolgesiSecimi(bolgeindex);
        }
        projeGenelBilgileriElement.bolgeSecimButton.click();
        commonElement.bekle();

        for (int ortakindex = 0; ortakindex < 21; ortakindex++)
        {
            projeEklemeElement.projeOrtakSecme(ortakindex);
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

        // 2. ADIM PROJE AMACI

        projeAmaciElement.projeOzetiMetinEditoru.sendKeys(ConfigReader.getProperty("proje_ozeti"));
        commonElement.bekle();

        projeAmaciElement.projeAmaciTabi.click();
        commonElement.bekle();

        projeAmaciElement.projeAmaciMetinEditoru.sendKeys(ConfigReader.getProperty("proje_amaci"));
        commonElement.bekle();

        projeAmaciElement.adim2KaydetButton.click();
        commonElement.bekle();

        commonElement.HERYERDEGECERLITAMAMBUTONU.click();

        System.out.println("2.Adim Proje Amaci Dolduruldu.");

        // 3. ADIM PROJEDEN BEKLENEN SONUÇ

        projedenBeklenenSonucElement.projedenBeklenenSonucMetinEditoru.sendKeys(ConfigReader.getProperty("projeden_beklenen_sonuc"));
        commonElement.bekle();

        projedenBeklenenSonucElement.adim3KaydetButton.click();
        commonElement.bekle();

        commonElement.HERYERDEGECERLITAMAMBUTONU.click();
        commonElement.bekle();

        System.out.println("3.Adim Projeden Beklenen Sonuc Dolduruldu.");

        // 4. ADIM PROJEDEN ETKİLENENLER

        projedenEtkilenenlerElement.projedenEtkilenenlerEkleButton.click();
        commonElement.bekle();

        projedenEtkilenenlerElement.etkilenenKurumInput.sendKeys(ConfigReader.getProperty("etkilenen_kurum"));
        commonElement.bekle();

        commonElement.aktifPasifCheckbox.click();
        commonElement.bekle();

        projedenEtkilenenlerElement.etkilenenKaydetButton.click();
        commonElement.bekle();

        commonElement.HERYERDEGECERLITAMAMBUTONU.click();
        commonElement.bekle();

        System.out.println("4.Adim Projeden Etkilenenler Dolduruldu.");

        // 5.ADIM PROJENIN OZGUNLUGU

        projeAdimlariElement.projeninOzgunluguAdimi.click();
        commonElement.bekle();

        projeninOzgunluguElement.projeninOzgunluguMetinEditoru.sendKeys(ConfigReader.getProperty("projenin_ozgunlugu"));
        commonElement.bekle();

        projeninOzgunluguElement.projeninBeklenenKatmaDegeriTabi.click();
        commonElement.bekle();

        projeninOzgunluguElement.projeninBeklenenKatmaDegeriMetinEditoru.sendKeys(ConfigReader.getProperty("projenin_beklenen_katma_degeri"));
        commonElement.bekle();

        projeninOzgunluguElement.adim5KaydetButton.click();
        commonElement.bekle();

        commonElement.HERYERDEGECERLITAMAMBUTONU.click();
        commonElement.bekle();

        System.out.println("5.Adim Projenin Ozgunlugu Dolduruldu.");

        // 6. ADIM PAYDASLAR VE TEKNIK YETERLILIK
        commonElement.bekle();
        projeAdimlariElement.paydaslarVeTeknikYeterlilikAdimi.click();
        commonElement.bekle();

        paydaslarVeTeknikYeterlilikElement.paydasEkleButton.click();
        commonElement.bekle();

        paydaslarVeTeknikYeterlilikElement.paydasTuruSecme(1); //Proje Yurutucusu
        commonElement.bekle();

        paydaslarVeTeknikYeterlilikElement.projeYurutucusuAdiInput.sendKeys(ConfigReader.getProperty("proje_Yurutucusu"));
        commonElement.bekle();

        commonElement.aktifPasifCheckbox.click();
        commonElement.bekle();

        paydaslarVeTeknikYeterlilikElement.paydasKaydetButton.click();
        commonElement.bekle();

        commonElement.HERYERDEGECERLITAMAMBUTONU.click();
        commonElement.bekle();

        paydaslarVeTeknikYeterlilikElement.paydasEkleButton.click();
        commonElement.bekle();

        projeEklemeElement.paydasTuruSecme(2); //Proje Ortaklari

        for (int paydasortak =0; paydasortak < 21; paydasortak++)
        {
            projeEklemeElement.paydasProjeOrtakSecme(paydasortak);
        }
        paydaslarVeTeknikYeterlilikElement.paydasOrtakSecmeButton.click();
        commonElement.bekle();

        commonElement.aktifPasifCheckbox.click();
        commonElement.bekle();

        paydaslarVeTeknikYeterlilikElement.paydasKaydetButton.click();
        commonElement.bekle();

        commonElement.HERYERDEGECERLITAMAMBUTONU.click();
        commonElement.bekle();

        paydaslarVeTeknikYeterlilikElement.paydasEkleButton.click();
        commonElement.bekle();

        paydaslarVeTeknikYeterlilikElement.paydasTuruSecme(3); //Danisman
        commonElement.bekle();

        paydaslarVeTeknikYeterlilikElement.danismanAdiInput.sendKeys(ConfigReader.getProperty("danisman"));
        commonElement.bekle();

        commonElement.aktifPasifCheckbox.click();
        commonElement.bekle();

        paydaslarVeTeknikYeterlilikElement.paydasKaydetButton.click();
        commonElement.bekle();

        commonElement.HERYERDEGECERLITAMAMBUTONU.click();
        commonElement.bekle();

        System.out.println("5.Adim Paydaslar ve Teknik Yeterlilik Dolduruldu.");


        // 7. ADIM PROJE ALANI

        projeAdimlariElement.projeAlaniAdimi.click();
        commonElement.bekle();

        projeAlaniElement.sektorSecimIletisimTeknolojisiStatus.click();
        commonElement.bekle();

        commonElement.popupUyariMesajiOnayla.click();
        commonElement.bekle();

        commonElement.HERYERDEGECERLITAMAMBUTONU.click();
        commonElement.bekle();

        System.out.println("7.Adim Proje Alani Dolduruldu.");


        // 8. ADIM PROJE KAPSAMİ

        projeAdimlariElement.projeKapsamiAdimi.click();

        for (int sayi = 1; sayi < 5; sayi++)
        {
            commonElement.bekle();
            projeKapsamiElement.kelimeEkleButton.click();
            projeKapsamiElement.kelimeAdiInput.sendKeys(ConfigReader.getProperty("anahtar_kelime") + " " + sayi);
            commonElement.bekle();
            projeKapsamiElement.kelimeKaydetButton.click();
            commonElement.HERYERDEGECERLITAMAMBUTONU.click();
        }

        commonElement.bekle();
        commonElement.bekle();
        projeKapsamiElement.projeKapsamiTabi.click();
        projeKapsamiElement.projeKapsamiMetinEditoru.sendKeys(ConfigReader.getProperty("proje_kapsami"));

        projeKapsamiElement.faydalanilanKaynaklarTabi.click();
        projeKapsamiElement.faydalanilanKaynaklarMetinEditoru.sendKeys(ConfigReader.getProperty("faydalanilan_kaynaklar"));

        projeKapsamiElement.projeTeknikAciklamasiTabi.click();
        projeKapsamiElement.projeTeknikAciklamasiMetinEditoru.sendKeys(ConfigReader.getProperty("proje_teknik_aciklamasi"));

        projeKapsamiElement.projedenBeklenenVerilerTabi.click();
        projeKapsamiElement.projedenBeklenenVerilerMetinEditoru.sendKeys(ConfigReader.getProperty("projeden_beklenen_veriler"));

        projeKapsamiElement.adim8KaydetButton.click();
        commonElement.HERYERDEGECERLITAMAMBUTONU.click();
        commonElement.bekle();


        // 9. ADIM DIGER ALANLAR
        digerAlanlarElement.projeninSektoreOlasiEtkileriMetinEditoru.sendKeys(ConfigReader.getProperty("projenin_sektore_olasi_etkileri"));
        commonElement.bekle();

        digerAlanlarElement.projeninSirketCalisanlarinaOlasiEtkileriTabi.click();
        commonElement.bekle();

        digerAlanlarElement.projeninSirketCalisanlarinaOlasiEtkileriMetinEditoru.sendKeys(ConfigReader.getProperty("projenin_sirket_calisanlarina_olasi_etkileri"));
        commonElement.bekle();

        digerAlanlarElement.projeninOlasiSosyalEtkileriTabi.click();
        commonElement.bekle();

        digerAlanlarElement.projeninOlasiSosyalEtkileriMetinEditoru.sendKeys(ConfigReader.getProperty("projenin_olasi_sosyal_etkileri"));
        commonElement.bekle();

        digerAlanlarElement.adim9KaydetButton.click();
        commonElement.bekle();

        commonElement.HERYERDEGECERLITAMAMBUTONU.click();
        commonElement.bekle();

        // 10.ADIM RISKLER VE ALTENATİF COZUMLERI

        risklerVeAlternatifCozumleriElement.risklerVeAlternatifCozumleriMetinEditoru.sendKeys(ConfigReader.getProperty("riskler_ve_alternatif_cozumleri"));
        commonElement.bekle();

        risklerVeAlternatifCozumleriElement.adim10KaydetButton.click();
        commonElement.bekle();

        commonElement.HERYERDEGECERLITAMAMBUTONU.click();
        commonElement.bekle();

        // 11.ADIM IS PLANI
        commonElement.bekle();
        projeAdimlariElement.isPlaniAdimi.click();

        int kaldigimAy = 0;

        for(int i = 1; i < 3; i++)
        {
            commonElement.bekle();

            isPaketiElement.isPlaniEkleButton.click();
            commonElement.bekle();

            isPaketiElement.isPaketiFirmaSecme(1);
            commonElement.bekle();

            isPaketiElement.isPaketiNoInput.sendKeys(Integer.toString(i));
            commonElement.bekle();

            isPaketiElement.faliyetTuruSecme(i);
            commonElement.bekle();

            isPaketiElement.faliyetTuruSecimButton.click();
            commonElement.bekle();

            String isPaketiAdi = i + ". " + ConfigReader.getProperty("is_paketi_adi");
            isPaketiElement.isPaketiAdiInput.sendKeys(isPaketiAdi);
            commonElement.bekle();

            isPaketiElement.isPaketiLideriSecme(1);
            commonElement.bekle();

            if(kaldigimAy == 0)
            {
                isPaketiElement.isPaketiBaslangicTarihiInput.sendKeys(Integer.toString(i));
                isPaketiElement.isPaketiBitisTarihiInput.sendKeys(Integer.toString(isPaketiAyGetir(i)));
            }else{
                isPaketiElement.isPaketiBaslangicTarihiInput.sendKeys(Integer.toString(kaldigimAy));
                isPaketiElement.isPaketiBitisTarihiInput.sendKeys(Integer.toString(isPaketiAyGetir(kaldigimAy)));
            }

            kaldigimAy = isPaketiAyGetir(i);
            commonElement.bekle();
            commonElement.bekle();

            isPaketiElement.isPaketiDurumuStatus.click();
            commonElement.bekle();

            isPaketiElement.isPaketiIleriButton.click();
            commonElement.bekle();

            isPaketiElement.isPaketiDetayMetinEditoru.sendKeys("fsdfsdfsd");
            commonElement.bekle();


            isPaketiElement.isPaketiTamamlanacakGorevlerMetinEditoru.sendKeys("fsdfsdfsdfsdf");
            commonElement.bekle();

            isPaketiElement.isPaketiIleriButton.click();
            commonElement.bekle();

            for (int paydasekle = 1; paydasekle< 4; paydasekle++ )
            {
                isPaketiElement.isPaketinePaydasEkleButton.click();
            }

            commonElement.bekle();

            isPaketiElement.paydasSectir();

            commonElement.bekle();

            isPaketiElement.isPaketiIleriButton.click();

            for (int paydasekle = 1; paydasekle< 4; paydasekle++ )
            {
                isPaketiElement.ciktiEkleButton.click();
            }

            commonElement.bekle();

            isPaketiElement.ciktiSectir();

            commonElement.bekle();

            isPaketiElement.ciktiTarihSectir();

            commonElement.bekle();

            isPaketiElement.isPaketiIleriKaydetButton.click();

            commonElement.bekle();

            commonElement.HERYERDEGECERLITAMAMBUTONU.click();

            commonElement.bekle();
        }


        // 12.ADIM BUTCE VE FINANSMAN KAYNAKLAR


      //  for (int butceindexler = 1; butceindexler < 4; butceindexler++) {
            projeAdimlariElement.butceVeFinansmanKaynaklarAdimi.click();
            commonElement.bekle();

            butceVeFinansmanKaynaklarElement.butceEkleButton.click();
            commonElement.bekle();

            butceVeFinansmanKaynaklarElement.butceFirmaSecme(1);
            commonElement.bekle();

            butceVeFinansmanKaynaklarElement.butceTuruSecme(1);
            commonElement.bekle();

            butceVeFinansmanKaynaklarElement.butceIsPaketiSecme(1);
            commonElement.bekle();

            butceVeFinansmanKaynaklarElement.butceIsPaketiPaydasSecme(1); //Proje Yürütücüsü
            commonElement.bekle();

            butceVeFinansmanKaynaklarElement.butceAdamAyInput.sendKeys("1");
            commonElement.bekle();

            butceVeFinansmanKaynaklarElement.butceTutarInput.sendKeys("100000");
            commonElement.bekle();

            commonElement.aktifPasifCheckbox.click();
            commonElement.bekle();

            butceVeFinansmanKaynaklarElement.butceKaydetButton.click();
            commonElement.bekle();

            commonElement.HERYERDEGECERLITAMAMBUTONU.click();
      //  }





        projeAdimlariElement.projeHareketKayitlariAdimi.click();
        commonElement.bekle();
        projeAdimlariElement.yetkiliFirmalarAdimi.click();
        commonElement.bekle();
        projeAdimlariElement.projeEkDosyalarAdimi.click();

        WebElement dosyaTuruSecimi = ekDosyalarElement.dosyaTuru;
        new Select(dosyaTuruSecimi).selectByValue("2"); //Proje Algoritmasi

        ekDosyalarElement.dosyaAciklamasi.sendKeys(ConfigReader.getProperty("dosya_aciklamasi"));

        WebElement dosyasecimi = ekDosyalarElement.dosyaSecme;
        dosyasecimi.sendKeys("C:/Users/emine.kuyumcu/Desktop/ARGETEST/deneme.pdf");

        commonElement.aktifPasifCheckbox.click();

        ekDosyalarElement.dosyaEklemeKaydetButton.click();
        commonElement.HERYERDEGECERLITAMAMBUTONU.click();


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