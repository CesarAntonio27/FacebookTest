package com.titaniumSolutions.mx;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FacebookTest extends BasePage{ 
	
	private WebDriver driver;
	BasePage basePage = new BasePage();
	
	//localizadores
	By newpublicationLocator = By.xpath("//span[contains(text(),'¿Qué estás pensando,')]");
	By publicationtextLocator = By.xpath("//div[@role='textbox']");
	By publicarLocator = By.xpath("//span[contains(text(),'Publicar')]");
	By opcionespublicacionLocator = By.xpath("//div[@aria-label='Acciones para esta publicación']");
	By editarpublicacionLocator = By.xpath("//span[contains(text(),'Editar publicación')]");
	By guardarpublicacionLocator = By.xpath("//span[contains(text(),'Guardar')]");
	By borrarpublicacionLocator = By.xpath("//span[contains(text(),'Mover a la papelera')]");
	By confirmareliminacionLocator = By.xpath("(//span[contains(text(),'Mover')])[2]");
	By menuLocator = By.xpath("//div[@aria-label='Cuenta']");
	By logoutLocator = By.xpath("(//span[contains(text(),'Cerrar sesión')])");
	By gmailLocator = By.xpath("(//input[@name='email'])[1]");
	By passwordLocator = By.xpath("(//input[@name='pass'])[1]");
	By loginLocator = By.xpath("(//label[@id='loginbutton'])[1]");
	By Locator = By.xpath("");
	By Locator = By.xpath("");
	By Locator = By.xpath("");
	
	
	
	@Before
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/whitehat/accounts/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}

	
	@Test
	public void createAccount() throws InterruptedException {
		
	
		//inicia sesion con la cuenta principal
		String newpassword = "480694";
		String gmailaccount = "facebookttesting@gmail.com";	
		driver.findElement(gmailLocator).sendKeys(gmailaccount);		
		driver.findElement(passwordLocator).sendKeys(newpassword);
		driver.findElement(loginLocator).click();
		Thread.sleep(5000);
		//basePage.disableChromenotification();//intento para cerrar la alerta de chrome (aun en reparacion)
		//driver.switchTo().alert().accept();
		
		//crea una cuenta de prueba en fecbook con el user principal
		driver.findElement(By.xpath("(//span[contains(text(),'Crear cuenta nueva')])[1]")).click();	
		Thread.sleep(7000);
		String accountTest = driver.findElement(By.xpath("(//div[@class='qzhwtbm6 knvmm38d'])[15]")).getText();
		String accountTestPass = driver.findElement(By.xpath("(//div[@class='qzhwtbm6 knvmm38d'])[17]")).getText();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//span[contains(text(),'Cerrar')])")).click();
		Thread.sleep(4000);
		driver.findElement(menuLocator).click();
		driver.findElement(logoutLocator).click();
		Thread.sleep(4000);
		
		//inicia session con la cuenta de prueba 
		driver.findElement(gmailLocator).sendKeys(accountTest);		
		driver.findElement(passwordLocator).sendKeys(accountTestPass);
		driver.findElement(By.xpath("(//button[@name='login'])")).click();
		
		
		
		driver.findElement(By.xpath("")).click();
		driver.findElement(By.xpath("")).click();
		driver.findElement(By.xpath("")).click();
		driver.findElement(By.xpath("")).click();
		driver.findElement(By.xpath("")).click();
		
		/*
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(gmailaccount);		
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys( "1234.Pass");		
		driver.findElement(By.xpath("//option[contains(text(),'jul')]")).click();		
		driver.findElement(By.xpath("//Select[@name='birthday_year']")).click();	
		driver.findElement(By.xpath("//option[contains(text(),'1999')]")).click();	
		driver.findElement(By.xpath("//label[contains(text(),'Mujer')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Registrarte')]")).click();
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		Thread.sleep(10000);
		//accede a gmail
		driver.get("https://www.google.com/intl/es-419/gmail/about/#");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//inicia sesion con el user para obtener el codigo de seguridad
		driver.findElement(By.xpath("(//a[contains(text(),'Acceder')])[2]")).click();
		ArrayList<String> tabs_windows = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs_windows.get(1));
		driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys("facebookttesting@gmail.com");
		driver.findElement(By.xpath("//span[contains(text(),'Siguiente')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(gmailpassword);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();//salta error "NoSUchElementException; no such element: Unable to locate element"
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String codigo = driver.findElement(By.xpath("//td[@style='font-size:11px;font-family:LucidaGrande,tahoma,verdana,arial,sans-serif;padding:10px;background-color:#f2f2f2;border-left:1px solid #ccc;border-right:1px solid #ccc;border-top:1px solid #ccc;border-bottom:1px solid #ccc']")).getText();
		driver.findElement(By.xpath("(//span[contains(text(),'Confirmar')])")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//vuelve a facebook para confirmar cuenta 
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(gmailpassword);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='code']")).sendKeys(codigo);
		driver.findElement(By.xpath("//button[@name='confirm']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Aceptar')]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		*/
		
		
		

		
		
		driver.findElement(By.xpath("")).sendKeys();
		driver.findElement(By.xpath("")).sendKeys();
		driver.findElement(By.xpath("")).sendKeys();
		
		
		
		
	};	

	@After
	public void endTest() {
		//driver.quit();
		
	}
	
}
