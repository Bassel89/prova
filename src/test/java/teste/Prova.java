package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Prova {
    @Test
    public void gerarDados1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bassel Said\\Desktop\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Acessar o site para gerar pessoa
        driver.navigate().to("https://www.4devs.com.br/gerador_de_nomes");
        //Pegar o primeiro nome e salvá-lo em variavel chama nome
        String nome = driver.findElement(By.className("generated-nick")).getText();
        //Pegar sobrenome e salvá-lo em variável chama sobrenome
        String sobrenome = driver.findElement(By.xpath("//*[@id=\"nicks\"]/ul/li[4]/span")).getText();
        //Acessa site gmail para cadastrar
        driver.navigate().to("https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fe-11-15e9226eb9419c7ff90ddf3a01cea409-fe24559afe4d4efabdca6e15fdf205aa414807d5&flowName=GlifWebSignIn&flowEntry=SignUp");
        //Preencher campo name com o valor que pegou do outro site
        driver.findElement(By.id("firstName")).sendKeys(nome);
        //Preencher campo name com o valor que pegou do outro site
        driver.findElement(By.id("lastName")).sendKeys(sobrenome);
        //Clica no campo username para ver se ele vai gerar user name aleatório e limpar esse campo
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).clear();
        Thread.sleep(2000);
        //Preencher o campo user name com o valor que preencheu em campo first name e last name
        driver.findElement(By.id("username")).sendKeys(nome);
        driver.findElement(By.id("username")).sendKeys(sobrenome);
        Thread.sleep(2000);
        //Definir senha
        driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input")).sendKeys("Inm@2020");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")).sendKeys("Inm@2020");
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[2]/form/div[2]/div/div[2]/div[1]/div/span/span")).click();
        Thread.sleep(2000);
        //Preencher campo telefone
        driver.findElement(By.xpath("//*[@id=\"phoneNumberId\"]")).sendKeys("00000000000000000");
        //Clicar no botão Próxima
        driver.findElement(By.xpath("//*[@id=\"gradsIdvPhoneNext\"]/span/span")).click();
        //Pegar o texto que vai aparecer quando o numero estiver errado e salvá-lo num variável texto
        // String texto = driver.findElement(By.xpath("//*[@id=\"view_container\"]/form/div[2]/div/div[1]/div/div[2]/div[2]/div[2]")).getAttribute("value");
        //div[@class="dEOOab RxsGPe"]
        Thread.sleep(3000);
        String texto = driver.findElement(By.xpath("//div[@class='dEOOab RxsGPe']")).getText();
        Assert.assertEquals("Este formato de número de telefone não é válido. Verifique o país e o número.", texto);
        driver.close();
    }
}