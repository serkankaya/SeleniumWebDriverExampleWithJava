# SeleniumWebDriverExampleWithJava

Test Koşturulan Ortam Bilgileri Aşağıdaki Gibidir.

Selenium Web Driver : 3.0.1
IDE                 : Eclips Neon 2 (Java EE)
OS                  : Ubuntu : 16.04 LTS
Browser             : Firefox Mozilla 50.1.0
Kullanılan Dil      : Java
Junit version       : 4.12
Geckodriver version : 0.13.0

---------------------------------------------------------------------------------------------------------------
--Ayarlamalar--

Firefox ayarlaması için aşağıda linkte bulunan size uygun driver'ı indirin ;
https://github.com/mozilla/geckodriver/releases

utility.java içerisinde aşağıda bulunan kodu bulun ve indirdiğiniz driver'ın yolunu gösterin ve kaydedin.

System.setProperty("webdriver.gecko.driver", "Driver Yolu");

testCase.java dosyasını Junit ile çalıştırın.
Test Koşturma işlemi başlayacak ...
---------------------------------------------------------------------------------------------------------------
--Test Senaryosu--
1. http://www.n11.com <http://www.n11.com/> sitesine gelecek ve anasayfanin acildigini onaylayacak
2. Login ekranini acip, bir kullanici ile login olacak ( daha once siteye uyeligin varsa o olabilir )
3. Ekranin ustundeki Search alanina 'samsung' yazip Ara butonuna tiklayacak
4. Gelen sayfada samsung icin sonuc bulundugunu onaylayacak
5. Arama sonuclarindan 2. sayfaya tiklayacak ve acilan sayfada 2. sayfanin su an gosterimde oldugunu onaylayacak
6. Ustten 3. urunun icindeki 'favorilere ekle' butonuna tiklayacak
7. Ekranin en ustundeki 'favorilerim' linkine tiklayacak
8. Acilan sayfada bir onceki sayfada izlemeye alinmis urunun bulundugunu onaylayacak
9. Favorilere alinan bu urunun yanindaki 'Kaldir' butonuna basarak, favorilerimden cikaracak
10. Sayfada bu urunun artik favorilere alinmadigini onaylayacak.
