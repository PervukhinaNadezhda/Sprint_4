package yandex.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserInfoDeliveryPage {
    private final WebDriver driver;
    private final By nameField = By.xpath(".//input[@placeholder = '* Имя']"); //Поле "Имя"
    private final By surnameField = By.xpath(".//input[@placeholder = '* Фамилия']"); //Поле "Фамилия"
    private final By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']"); //Поле "Адрес"
    private final By metroStationField = By.xpath(".//input[@placeholder = '* Станция метро']"); //Поле "Метро"
    private final String metroStationFromList = ".//div[@class='select-search has-focus']//*[text()='%s']"; //Станция метро из списка
    private final By phoneField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']"); //Поле "Телефон"
    private final By agreeCookiesWindowButton = By.id("rcc-confirm-button"); //Кнопка принять соглашение куки
    private final By nextButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']"); //Кнопка "Далее"

    public UserInfoDeliveryPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод для заполнения поля "Имя"
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    // метод для заполнения поля "Фамилия"
    public void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    // метод для заполнения поля "Адрес"
    public void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    // метод для заполнения поля "Станция метро"
    public void setMetroStation(String metroStation) {
        driver.findElement(metroStationField).click();
        String metroSearchFormatter = String.format(metroStationFromList, metroStation);
        driver.findElement(By.xpath(metroSearchFormatter)).click();
    }

    // метод для заполнения поля "Телефон"
    public void setPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    // метод закрывающий всплывающее окно
    public void clickAgreeCookiesWindow() {
        driver.findElement(agreeCookiesWindowButton).click();
    }

    // метод для заполнения формы "Для кого самокат"
    public void setUserInfoPage(String name, String surname, String address, String metroStation, String phone) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetroStation(metroStation);
        setPhone(phone);
    }

    // метод нажатие на кнопку "Далее"
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
}
