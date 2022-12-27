//тут будет страница заказа и ее локаторы и методы
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPage {
    private final WebDriver driver;
    //список локаторов
    private final By orderForm = By.xpath(".//div[@class='Order_Form__17u6u']");
    private final By name = By.xpath(".//input[contains(@placeholder,'Имя')]");
    private final By lastName = By.xpath(".//input[contains(@placeholder,'Фамилия')]");
    private final By adress = By.xpath(".//input[contains(@placeholder,'Адрес: куда привезти заказ')]");
    private final By metro = By.xpath(".//input[contains(@placeholder,'Станция метро')]");
    private final By metroStation1 = By.xpath(".//div[@class='select-search__select']//div[text()='Бульвар Рокоссовского']");
    private final By metroStation2 = By.xpath(".//div[@class='select-search__select']//div[text()='Черкизовская']");
    private final By phoneNumber = By.xpath(".//input[contains(@placeholder,'Телефон: на него позвонит курьер')]");
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By dateOfOrder = By.xpath(".//input[contains(@placeholder,'Когда привезти самокат')]");

    private final By myDateOfOrder = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--031 react-datepicker__day--weekend']");
    private final By myDateOfOrder2 = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--030 react-datepicker__day--outside-month']");
    private final By limitOfRentInput = By.xpath(".//div[@class = 'Dropdown-placeholder']");
    private final By limitOfRentValue = By.xpath(".//div[@class = 'Dropdown-menu']//div[text()='двое суток']");
    private final By limitOfRentValue2 = By.xpath(".//div[@class = 'Dropdown-menu']//div[text()='трое суток']");
    private final By colourOfSamokat = By.xpath(".//input[@id = 'black']");
    private final By colourOfSamokat2 = By.xpath(".//input[@id = 'grey']");
    private final By orderButtonOfOrderPage = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private final By confirmOrderButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']//button[text()='Да']");
    //private final By modalWindowOrderSuccess = By.xpath(".//div[@class = 'Order_Modal__YZ-d3']");
    //создаем драйвер
    public OrderPage (WebDriver driver) {
        this.driver = driver;
    }

    //заполняем первую форму с первым комплектом тестовых данных
    public void setInputs1() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderForm));
        driver.findElement(name).sendKeys("Наруто");
        driver.findElement(lastName).sendKeys("Узумаки");
        driver.findElement(adress).sendKeys("г. Москва, ул. Листа, д. 7");
        driver.findElement(metro).click();
        driver.findElement(metroStation1).click();
        driver.findElement(phoneNumber).sendKeys("+79991234567");
        driver.findElement(nextButton).click();

    }

    //заполняем вторую форму с первым комплектом тестовых данных
    public void setInputs2(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderForm));
        driver.findElement(dateOfOrder).click();
        driver.findElement(myDateOfOrder).click();
        driver.findElement(limitOfRentInput).click();
        driver.findElement(limitOfRentValue).click();
        driver.findElement(colourOfSamokat).click();
        driver.findElement(orderButtonOfOrderPage).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(confirmOrderButton));
        driver.findElement(confirmOrderButton).click();
        //ищем модальное окно и получаем его текст с выводом
        String text = driver.findElement(By.className("Order_ModalHeader__3FDaJ")).getText();
        System.out.println("Текст модального окна с номером совершённого заказа: " + text);
    }

    //заполняем вторую форму с первым комплектом тестовых данных
    public void setInputs1NewData() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderForm));
        driver.findElement(name).sendKeys("Саске");
        driver.findElement(lastName).sendKeys("Учиха");
        driver.findElement(adress).sendKeys("г. Москва, ул. Акацки, д. 8");
        driver.findElement(metro).click();
        driver.findElement(metroStation2).click();
        driver.findElement(phoneNumber).sendKeys("+79991230101");
        driver.findElement(nextButton).click();
    }

    //заполняем вторую форму со вторым комплектом тестовых данных
    public void setInputs2NewData(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderForm));
        driver.findElement(dateOfOrder).click();
        driver.findElement(myDateOfOrder2).click();
        driver.findElement(limitOfRentInput).click();
        driver.findElement(limitOfRentValue2).click();
        driver.findElement(colourOfSamokat2).click();
        driver.findElement(orderButtonOfOrderPage).click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(confirmOrderButton));
        driver.findElement(confirmOrderButton).click();
        //ищем модальное окно и получаем его текст с выводом
        String text = driver.findElement(By.className("Order_ModalHeader__3FDaJ")).getText();
        System.out.println("Текст модального окна с номером совершённого заказа: " + text);
    }
