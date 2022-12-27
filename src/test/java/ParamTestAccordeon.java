import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
//тестовый класс с полями и конструктор, кот. будет менять поля
public class ParamTestAccordeon {
    private WebDriver driver;
    //ввели переменную для ожидаемого ответа
    private final String expectedAnswer;
    //ввели переменную для указания номера элемента
    private final int numberOfQaElement;
    public ParamTestAccordeon(String expectedAnswer, int numberOfQaElement) {
        this.expectedAnswer = expectedAnswer;
        this.numberOfQaElement = numberOfQaElement;
    }
    //получаем конкретные тестовые значения
    @Parameterized.Parameters
    public static Object[][]AccordeonAnswers(){
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",2},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.",3},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",4},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",5},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",6},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.",7},
        };
    }
    //браузер переключаем через комментирование
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();A
    }
    //сам тест
    @Test
    public void testOfAccordeon() {
        HomePage homePage = new HomePage(driver);
        homePage.openUrl();
        homePage.scrollHomePage(numberOfQaElement);
        homePage.waitForQuestion(numberOfQaElement);
        homePage.clickAccordeonQuestion(numberOfQaElement);
        homePage.waitForAnswer(numberOfQaElement);
        //проверяем что указанный ожидаемый текст соответствует нужному элементу
        Assert.assertEquals(expectedAnswer,homePage.getAnswerText(numberOfQaElement));
    }


    //закрываем браузер
    @After
    public void tearDown() {
        driver.quit();
    }

}

