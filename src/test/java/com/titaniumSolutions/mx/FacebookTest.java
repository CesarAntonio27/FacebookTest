package com.titaniumSolutions.mx;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.annotation.WillClose;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FacebookTest extends BasePage{ 
	
	private WebDriver driver;
	private ChromeOptions options;
	BasePage basePage = new BasePage();
	
	String newpassword = "480694";
	String gmailaccount = "facebookttesting@gmail.com";	
	
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
	By inicioLocator = By.xpath("//a[@aria-label='Inicio']");
	By seleccionarCuentaLocator = By.xpath("//input[@type='checkbox']");
	By eliminarSeleccionLocator = By.xpath("(//div[@aria-label='Eliminar selección'])[2]");
	By cerrarLocator = By.xpath("(//div[@aria-label='Cerrar'])[2]");
	/*By iniciarPublicacionLocator = By.xpath("(//div[@role='button'])[16]");
	By textodePublicacionLocator = By.xpath("(//div[@class='rq0escxv buofh1pr df2bnetk hv4rvrfc dati1w0a l9j0dhe7 k4urcfbm du4w35lb gbhij3x4'])");
	By publicarLocator = By.xpath("//span[contains(text(),'Publicar')]");
	
	By Locator = By.xpath("");
	By Locator = By.xpath("");
	By Locator = By.xpath("");
	By Locator = By.xpath("");
	By Locator = By.xpath("");
	By Locator = By.xpath("");
	By Locator = By.xpath("");*/
	By menudeCuentaLocator = By.xpath("//div[@aria-label='Cuenta']");
	
	
	
	@Before
	public void setup() {
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		
	}

	
	@Test
	public void createAccount() throws InterruptedException {
		
		//accede a la pagina 
		driver.get("https://www.facebook.com/whitehat/accounts/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//inicia sesion con la cuenta principal
		driver.findElement(gmailLocator).sendKeys(gmailaccount);		
		driver.findElement(passwordLocator).sendKeys(newpassword);
		driver.findElement(loginLocator).click();
		Thread.sleep(5000);
		//basePage.disableChromenotification();//intento para cerrar la alerta de chrome (aun en reparacion)
		//driver.switchTo().alert().accept();
		
		//crea una cuenta de prueba en fecbook con el user principal
		driver.findElement(By.xpath("(//span[contains(text(),'Crear cuenta nueva')])[1]")).click();	
		Thread.sleep(7000);
		String accountTest = driver.findElement(By.xpath("(//span[@class='d2edcug0 hpfvmrgz qv66sw1b c1et5uql lr9zc1uh jq4qci2q a3bd9o3v knj5qynh oo9gr5id hzawbc8m'])[3]")).getText();
		String accountTestPass = driver.findElement(By.xpath("(//span[@class='d2edcug0 hpfvmrgz qv66sw1b c1et5uql lr9zc1uh jq4qci2q a3bd9o3v knj5qynh oo9gr5id hzawbc8m'])[4]")).getText();
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
		
		
		
		/*driver.findElement(By.xpath("")).click();
		driver.findElement(By.xpath("")).click();
		driver.findElement(By.xpath("")).click();
		driver.findElement(By.xpath("")).click();
		driver.findElement(By.xpath("")).click();
	
		
		driver.findElement(By.xpath("")).sendKeys();
		driver.findElement(By.xpath("")).sendKeys();
		driver.findElement(By.xpath("")).sendKeys();*/
		
		
		
		
	};	
	
	@Test
	public void createPost() throws InterruptedException{
	
		//crea la publicacion
		driver.findElement(newpublicationLocator).click();
		driver.findElement(publicationtextLocator).sendKeys("hola mundo,");
		driver.findElement(publicarLocator).click();
		Thread.sleep(5000);
		
		
		
		

	};
	
	@Test
	public void editPost() throws InterruptedException{
	
		
		
		//edita la publicacion
		driver.findElement(opcionespublicacionLocator).click();
		driver.findElement(editarpublicacionLocator).click();
		driver.findElement(publicationtextLocator).sendKeys(" fue un gusto");
		driver.findElement(guardarpublicacionLocator).click();
		Thread.sleep(4000);
		
		
	};
	
	@Test
	public void deletePost() throws InterruptedException{
	
		driver.findElement(opcionespublicacionLocator).click();
		driver.findElement(borrarpublicacionLocator).click();
		driver.findElement(confirmareliminacionLocator).click();
		Thread.sleep(4000);
		driver.findElement(menuLocator).click();
		driver.findElement(logoutLocator).click();
		
	};
	

	@Test
	public void deleteAccountAndEndTheTest() throws InterruptedException{
		
		driver.get("https://www.facebook.com/whitehat/accounts/");
		driver.findElement(gmailLocator).sendKeys(gmailaccount);		
		driver.findElement(passwordLocator).sendKeys(newpassword);
		driver.findElement(loginLocator).click();
		Thread.sleep(5000);
		driver.findElement(seleccionarCuentaLocator).click();
		driver.findElement(eliminarSeleccionLocator).click();
		Thread.sleep(7000);
		driver.findElement(cerrarLocator).click();
		driver.findElement(menuLocator).click();
		driver.findElement(logoutLocator).click();
		driver.quit();
		
	}
	
}
