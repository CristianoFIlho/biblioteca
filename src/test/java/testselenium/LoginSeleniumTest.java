package testselenium;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSeleniumTest {

	private void exemploLoginFuncionario(final String usuario, final String senha) {
		WebDriver driver = null;
		WebDriverManager.chromedriver().version("91.0.4472.19").setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("enable-automation");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--disable-gpu");
		driver = new ChromeDriver(options);

		driver.get("http://localhost:8080/");

		WebElement campoPesquisado = driver.findElement(By.name("usuario"));
		campoPesquisado.clear();
		campoPesquisado.sendKeys(usuario);

		WebElement campoPesquisado2 = driver.findElement(By.name("senha"));
		campoPesquisado2.clear();
		campoPesquisado2.sendKeys(senha);

		System.out.println("O título da página é: " + driver.getTitle());

		campoPesquisado.submit();

		new WebDriverWait(driver, 5);

		String actualUrl = driver.getCurrentUrl();

		Assert.assertEquals("http://localhost:8080/biblioteca/funcionario/auth", actualUrl);

		driver.quit();
	}

	@Test
	public void testeFuncionario() {
		exemploLoginFuncionario("iron", "asd");
	}

	@Test
	public void testeFuncionario2() {
		exemploLoginFuncionario("testeteste", "testeteste");
	}
}
