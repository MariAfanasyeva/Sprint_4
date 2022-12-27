//тут все эл. главной стр, вкл. локаторы и методы
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    //локаторы списка вопросов
    private final By[] locatorsByQuestionsAccordeon = {
            By.xpath (".//div[@id = 'accordion__heading-0']"),
            By.xpath (".//div[@id = 'accordion__heading-1']"),
            By.xpath (".//div[@id = 'accordion__heading-2']"),
            By.xpath (".//div[@id = 'accordion__heading-3']"),
            By.xpath (".//div[@id = 'accordion__heading-4']"),
            By.xpath (".//div[@id = 'accordion__heading-5']"),
            By.xpath (".//div[@id = 'accordion__heading-6']"),
            By.xpath (".//div[@id = 'accordion__heading-7']")
    };
    //локаторы списка ответов
    private final By[] locatorsByAnswersAccordeon = {
            By.xpath(".//div[@id = 'accordion__panel-0']/p"),
            By.xpath(".//div[@id = 'accordion__panel-1']/p"),
            By.xpath(".//div[@id = 'accordion__panel-2']/p"),
            By.xpath(".//div[@id = 'accordion__panel-3']/p"),
            By.xpath(".//div[@id = 'accordion__panel-4']/p"),
            By.xpath(".//div[@id = 'accordion__panel-5']/p"),
            By.xpath(".//div[@id = 'accordion__panel-6']/p"),
            By.xpath(".//div[@id = 'accordion__panel-7']/p")
    };

    //локаторы кнопки "Заказать" вверху и внизу главной страницы
    private final By [] orderButtonsOfHomePage = {
            By.xpath(".//button[@class='Button_Button__ra12g']"),
            By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM')]")
    };
    //создаем драйвер
    public HomePage (WebDriver driver) {
        this.driver = driver;
    }
    //открыть главную страницу сервиса
    public void openUrl() {
        String url = "https://qa-scooter.praktikum-services.ru/";
        driver.get(url);
    }

    //промотать(сделать скролл) до нужного блока с Вопросами и Ответами
    public void scrollHomePage(int numberOfQuestion) {
        WebElement element = driver.findElement(locatorsByQuestionsAccordeon[numberOfQuestion]);
        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView();",
                        element
                );
    }

    //ожидание вопроса 5 секунд
    public void waitForQuestion(int numberOfQuestion) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locatorsByQuestionsAccordeon[numberOfQuestion]));
    }

    //клик по вопросу
    public void clickAccordeonQuestion(int numberOfQuestion) {
        driver.findElement(locatorsByQuestionsAccordeon[numberOfQuestion]).click();
    }

    //ожидание ответа 5 секунд
    public void waitForAnswer(int numberOfAnswer) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(locatorsByAnswersAccordeon[numberOfAnswer]));
    }

    //вернуть ответ по номеру элемента
    public String getAnswerText(int numberOfAnswer) {
        return driver.findElement(locatorsByAnswersAccordeon[numberOfAnswer]).getText();
    }

    //ждем и кликаем по кнопке "Заказать" внизу или вверху главной страницы
    public void clickOrderButton(int number){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderButtonsOfHomePage[number]));
        driver.findElement(orderButtonsOfHomePage[number]).click();
    }

    //промотать(сделать скролл) до нижней кнопки "Заказать"
    public void scrollHomePageToOrderButton(int i) {
        WebElement element = driver.findElement(orderButtonsOfHomePage[1]);
        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView();",
                        element
                );
    }

}

