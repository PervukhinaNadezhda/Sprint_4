package yandex.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentDeliveryPage {

    private final WebDriver driver;
    private final By dateField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']"); //Поле "Дата"
    private final By topWindow = By.className("Header_Header__214zg"); //Хэдер (верхняя часть) страницы
    private final By rentDayField = By.className("Dropdown-control"); //Поле "Количество дней аренды"
    private final By rentDayOneFromList = By.xpath(".//div[@class = 'Dropdown-menu']//*[text()='сутки']"); //Список доступных для аренды дней
    private final By blackScooterColorField = By.id("black"); //Чек-бокс выбора черного цвета самоката
    private final By commentField = By.xpath(".//input[@placeholder = 'Комментарий для курьера']"); //Поле "Комментарий"
    private final By orderButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']"); //Кнопка "Заказать"

    public RentDeliveryPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод для заполнения поля "Дата" и закрытие календаря
    public void setDate(String date) {
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(topWindow).click();
    }

    // метод для заполнения поля "Срок аренды"
    public void setRentDay() {
        driver.findElement(rentDayField).click();
        driver.findElement(rentDayOneFromList).click();
    }

    // метод для выбора цвета самоката
    public void setScooterColor() {
        driver.findElement(blackScooterColorField).click();
    }

    // метод для заполнения поля "Комментарий"
    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    // метод для заполнения формы "Про аренду"
    public void setRentDeliveryPage(String date, String comment) {
        setDate(date);
        setRentDay();
        setScooterColor();
        setComment(comment);
    }

    // метод нажатие на кнопку "Заказать"
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

}
