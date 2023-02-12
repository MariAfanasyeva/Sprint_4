import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderTestSamokat {
    private WebDriver driver;


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
    }
    @Test
    //тест с первым комплектом данных и кнопкой вверху главной страницы
    public void testOfOrderForm1() {
        HomePage homePage = new HomePage(driver);
        OrderPage orderPage = new OrderPage(driver);
        homePage.openUrl();
        homePage.clickOrderButton(0);
        orderPage.setInputs1();
        orderPage.setInputs2();

    }

    @Test
    //тест со вторым комплектом данных и кнопкой вверху главной страницы
    public void testOfOrderForm2() {
        HomePage homePage = new HomePage(driver);
        OrderPage orderPage = new OrderPage(driver);
        homePage.openUrl();
        homePage.clickOrderButton(0);
        orderPage.setInputs1NewData();
        orderPage.setInputs2NewData();

    }

    @Test
    //тест с первым комплектом данных и кнопкой внизу главной страницы
    public void testOfOrderForm3() {
        HomePage homePage = new HomePage(driver);
        OrderPage orderPage = new OrderPage(driver);
        homePage.openUrl();
        homePage.scrollHomePageToOrderButton(1);
        homePage.clickOrderButton(1);
        orderPage.setInputs1();
        orderPage.setInputs2();

    }

    @Test
    //тест со вторым комплектом данных и кнопкой внизу главной страницы
    public void testOfOrderForm4() {
        HomePage homePage = new HomePage(driver);
        OrderPage orderPage = new OrderPage(driver);
        homePage.openUrl();
        homePage.scrollHomePageToOrderButton(1);
        homePage.clickOrderButton(1);
        orderPage.setInputs1NewData();
        orderPage.setInputs2NewData();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}

