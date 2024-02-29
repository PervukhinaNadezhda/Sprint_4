package yandex.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {

    private final WebDriver driver;
    private final By confirmationButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']//*[text()='Да']"); //Кнопка "Да" подтверждение оформления заказа

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод нажатие на кнопку подтверждения
    public void clickConfirmationButton() {
        driver.findElement(confirmationButton).click();
    }
}
