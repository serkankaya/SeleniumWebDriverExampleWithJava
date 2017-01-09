package com.n11.homework;

import java.util.List;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testCase extends page {
	WebDriverWait wait= new WebDriverWait(driver, 1000);
	//Anasayfa açılış kontrolü
	@Test
	public void test_1_1_WebSiteControl(){
		driver.get(webSiteMainUrl);
		Assert.assertTrue(driver.getTitle().equals("n11.com - Alışverişin Uğurlu Adresi"));
		System.out.println("Web Sitesi Açıldı");
	}
	//Kullanıcı giriş sayfası açılma testi
	@Test
	public void test_1_2_loginPageReadyControl(){
		findByClassName("btnSignIn").click();
		wait.until(elementClickableById("loginButton"));
		Assert.assertTrue(findById("loginButton").getText().equals("Üye Girişi"));
		System.out.println("Sayfa kullanıcı girişi için hazır ...");
	}
	//Kullanıcı girişi testi
	@Test
	public void test_1_3_loginControl(){
		findById("email").sendKeys("serkankayatr212@gmail.com");
		findById("password").sendKeys("s123456");
		findById("loginButton").click();
		waitForPageLoad();
		Assert.assertTrue(!findByClassName("username").getText().equals(""));
		System.out.println("Kullanıcı Girişi Başarılı ...");
	}
	//samsung için arama sonucu testi
	@Test
	public void test_1_4_searchControl(){
		wait.until(elementClickableById("searchData"));
		findById("searchData").sendKeys("samsung");
		findByClassName("searchBtn").click();
		wait.until(elementClickableByClassName("pagination"));
		String resultOk=findByXpad("//section[2]/div/div").getText();
		Assert.assertTrue(resultOk.contains("sonuç bulundu."));
		System.out.println("Samsung için sonuç bulundu");
	}
	//ikinci sayfaya tıklanma ve 2. sayfanın açılma testi
	@Test
	public void test_1_5_clickPageAndPageTwoOpenedControl(){
		findByXpad("//*[@class='pagination']/a[2]").click();
		waitForPageLoad();
		Assert.assertTrue(driver.getTitle().contains("Samsung - n11.com - 2/"));
		System.out.println("2. Sayfa Gösterimde ...");
	}
	//listede 3. ürünün favorilere eklenme testi
	@Test
	public void test_1_6_addThirdProductFavorite(){
		//Listede 3. Ürün Oluşana Kadar Bekle
		wait.until(elementClickableByXpad("//li[3]/div/div[2]/span"));
		selectedFavoriteProduct=getElementTextByXpad("//li[3]/div/div/a/h3");
		findByXpad("//li[3]/div/div[2]/span").click();
		System.out.println("Favoriye Eklenen Ürün Adı : "+selectedFavoriteProduct);
	}
	//Favorilerim bölümüne tıklanma testi
	@Test
	public void test_1_7_clickMyFavorite(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", findByXpad("//*[@class='myAccountMenu hOpenMenu']/div[1]/a[2]"));
		waitForPageLoad();
	}
	//Favorilerimde daha önce eklenmiş ürünün onaylanma testi
	@Test
	public void test_1_8_clickedFavoriteConfirmation(){
		List<WebElement> productTitles= findListByXpad("//*[@class='productTitle']/p/a");
		for (WebElement productTitle : productTitles) {
			favoriesCount+=1;
			String watchesProduct=productTitle.getText();
			if (watchesProduct.equals(selectedFavoriteProduct)) {
				System.out.println("Favoriye Eklenen Ürün Onaylandı.Ürünün Başlığı :"+watchesProduct+"\n");
				willDeleteFavorite=favoriesCount;
				Assert.assertTrue(watchesProduct.equals(selectedFavoriteProduct));
			}
		}
	}
	//Favorilerden aynı ürünün silinme testi
	@Test
	public void test_1_9_deleteSelectedProduct(){
		findByXpad("//table[@id='watchList']/tbody/tr['"+willDeleteFavorite+"']/td/a").click();
		waitForPageLoad();
	}
	//Silinen ürünün favorilerim listesinde bulunmadığının testi
	@Test
	public void test_2_1_checkDeletedFavorite(){
		
		boolean isThereProduct=false;
		List<WebElement> productTitles= findListByXpad("//*[@class='productTitle']/p/a");
		for (WebElement productTitle : productTitles) {
			String watchesProduct=productTitle.getText();
			if (watchesProduct.equals(selectedFavoriteProduct)) {
				isThereProduct=true;
			}
		}
		Assert.assertFalse(isThereProduct);
		System.out.println("Favorilerim Sayfasında "+selectedFavoriteProduct+" isimli ürün artık bulunmuyor ...");
	}
}
