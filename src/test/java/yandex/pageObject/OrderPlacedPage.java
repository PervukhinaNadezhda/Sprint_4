package yandex.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class OrderPlacedPage {

    private final WebDriver driver;
    private final By orderPlacedWindow = By.xpath(".//*[text() = 'Заказ оформлен']"); //Заголовок окна 'Заказ оформлен'

    public OrderPlacedPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод проверяет наличие окна "Заказ оформлен"
    public void checkOrderPlacedWindow() {
        assertEquals("Отсутствует окно 'Заказ оформлен'", true, !driver.findElements(orderPlacedWindow).isEmpty());
    }

}
