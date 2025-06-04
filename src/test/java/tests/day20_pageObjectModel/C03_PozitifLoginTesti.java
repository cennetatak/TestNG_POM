package tests.day20_pageObjectModel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestotomasyonuPage;
import utillities.Driver;
import utillities.ReusableMethods;

public class C03_PozitifLoginTesti {


    @Test
    public void pozitifLogintesti(){
        // 1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get("https://www.testotomasyonu.com/");


        // 2- account linkine basin
        TestotomasyonuPage testotomasyonuPage = new TestotomasyonuPage();
        ReusableMethods.tumSayfaResimCekTarihli(Driver.getDriver());
        ReusableMethods.bekle(2);
        testotomasyonuPage.accountLinki.click();
        // 3- Kullanici email'i olarak gecerli email girin
        testotomasyonuPage.emailKutusu.sendKeys("wise@gmail.com");

        // 4- Kullanici sifresi olarak gecerli password girin
        testotomasyonuPage.passwordKutusu.sendKeys("123456");

        // 5- Login butonuna basarak login olun
        testotomasyonuPage.loginButonu.click();

        // 6- Basarili olarak giris yapilabildigini test edin
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(testotomasyonuPage.logoutButonu.isDisplayed());

        // 7- logout olun
        testotomasyonuPage.logoutButonu.click();

        // 8- sayfayi kapatin
        Driver.quitDriver();


    }
}
